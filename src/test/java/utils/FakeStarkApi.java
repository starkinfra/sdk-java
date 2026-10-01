package utils;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.net.ProxySelector;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyStore;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;
import java.util.List;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.KeyManagerFactory;


/**
 * Stands in for the network only: the SDK runs untouched and its HTTPS calls to the sandbox host
 * are tunnelled to this in-process server, which records each request and answers a canned body.
 * The sandbox answers 500 to hosts and delete for a valid id, so those two cannot be checked live.
 */
public final class FakeStarkApi implements AutoCloseable {

    private static final String HOST = "sandbox.api.starkinfra.com";
    private static final String PASSWORD = "changeit";

    public static final class Recorded {
        public final String method;
        public final String target;
        public final String body;

        Recorded(String method, String target, String body) {
            this.method = method;
            this.target = target;
            this.body = body;
        }
    }

    public final List<Recorded> requests = new CopyOnWriteArrayList<>();

    private final ServerSocket server;
    private final SSLContext context;
    private final String[] responseBodies;
    private final AtomicInteger answered = new AtomicInteger();
    private final Path directory;
    private final ProxySelector previousSelector;
    private final String previousTrustStore;
    private final String previousTrustStorePassword;
    private final String previousTrustStoreType;

    // Answers the n-th request with the n-th body and keeps repeating the last one, for flows of several requests.
    public FakeStarkApi(String... responseBodies) throws Exception {
        this.responseBodies = responseBodies;
        this.directory = Files.createTempDirectory("fake-stark-api");
        this.context = createContext(directory);
        this.server = new ServerSocket(0, 50, java.net.InetAddress.getLoopbackAddress());

        this.previousSelector = ProxySelector.getDefault();
        this.previousTrustStore = System.getProperty("javax.net.ssl.trustStore");
        this.previousTrustStorePassword = System.getProperty("javax.net.ssl.trustStorePassword");
        this.previousTrustStoreType = System.getProperty("javax.net.ssl.trustStoreType");

        System.setProperty("javax.net.ssl.trustStore", new File(directory.toFile(), "store.p12").getPath());
        System.setProperty("javax.net.ssl.trustStorePassword", PASSWORD);
        System.setProperty("javax.net.ssl.trustStoreType", "PKCS12");
        ProxySelector.setDefault(new TunnelSelector(previousSelector, server.getLocalPort()));

        Thread acceptor = new Thread(this::acceptLoop);
        acceptor.setDaemon(true);
        acceptor.start();
    }

    @Override
    public void close() throws Exception {
        ProxySelector.setDefault(previousSelector);
        restore("javax.net.ssl.trustStore", previousTrustStore);
        restore("javax.net.ssl.trustStorePassword", previousTrustStorePassword);
        restore("javax.net.ssl.trustStoreType", previousTrustStoreType);
        server.close();
        for (File file : directory.toFile().listFiles()) {
            file.delete();
        }
        directory.toFile().delete();
    }

    private static void restore(String name, String value) {
        if (value == null) {
            System.clearProperty(name);
            return;
        }
        System.setProperty(name, value);
    }

    // A throwaway self-signed certificate for the sandbox host name, valid for this run only.
    private static SSLContext createContext(Path directory) throws Exception {
        File store = new File(directory.toFile(), "store.p12");
        Process keytool = new ProcessBuilder(
            "keytool", "-genkeypair", "-alias", "fake", "-keyalg", "RSA", "-keysize", "2048",
            "-dname", "CN=" + HOST, "-ext", "SAN=dns:" + HOST, "-validity", "1",
            "-keystore", store.getPath(), "-storetype", "PKCS12", "-storepass", PASSWORD
        ).redirectErrorStream(true).start();
        keytool.getInputStream().readAllBytes();
        if (!keytool.waitFor(60, TimeUnit.SECONDS) || keytool.exitValue() != 0) {
            throw new IllegalStateException("keytool could not create the fake certificate");
        }

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (InputStream in = new FileInputStream(store)) {
            keyStore.load(in, PASSWORD.toCharArray());
        }
        KeyManagerFactory factory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        factory.init(keyStore, PASSWORD.toCharArray());
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(factory.getKeyManagers(), null, null);
        return context;
    }

    private void acceptLoop() {
        while (!server.isClosed()) {
            try {
                Socket socket = server.accept();
                Thread worker = new Thread(() -> serve(socket));
                worker.setDaemon(true);
                worker.start();
            } catch (IOException e) {
                return;
            }
        }
    }

    private void serve(Socket raw) {
        try (Socket socket = raw) {
            InputStream tunnelIn = socket.getInputStream();
            String connect = readLine(tunnelIn);
            if (connect == null || !connect.startsWith("CONNECT ")) {
                return;
            }
            while (!readLine(tunnelIn).isEmpty()) {
                // drop the CONNECT headers
            }
            OutputStream tunnelOut = socket.getOutputStream();
            tunnelOut.write("HTTP/1.1 200 Connection Established\r\n\r\n".getBytes(StandardCharsets.US_ASCII));
            tunnelOut.flush();

            SSLSocket tls = (SSLSocket) context.getSocketFactory().createSocket(socket, null, socket.getPort(), false);
            tls.setUseClientMode(false);
            tls.startHandshake();
            answer(tls);
        } catch (IOException e) {
            // the client closing a connection it no longer needs is not a test failure
        }
    }

    private void answer(SSLSocket tls) throws IOException {
        InputStream in = tls.getInputStream();
        String requestLine = readLine(in);
        if (requestLine == null) {
            return;
        }

        int contentLength = 0;
        String header;
        while (!(header = readLine(in)).isEmpty()) {
            if (header.toLowerCase().startsWith("content-length:")) {
                contentLength = Integer.parseInt(header.substring(header.indexOf(':') + 1).trim());
            }
        }
        byte[] body = in.readNBytes(contentLength);

        String[] parts = requestLine.split(" ");
        requests.add(new Recorded(parts[0], parts[1], new String(body, StandardCharsets.UTF_8)));

        int index = Math.min(answered.getAndIncrement(), responseBodies.length - 1);
        byte[] payload = responseBodies[index].getBytes(StandardCharsets.UTF_8);
        OutputStream out = tls.getOutputStream();
        out.write((
            "HTTP/1.1 200 OK\r\nContent-Type: application/json\r\nConnection: close\r\nContent-Length: "
            + payload.length + "\r\n\r\n"
        ).getBytes(StandardCharsets.US_ASCII));
        out.write(payload);
        out.flush();
    }

    private static String readLine(InputStream in) throws IOException {
        StringBuilder line = new StringBuilder();
        int current;
        while ((current = in.read()) != -1) {
            if (current == '\n') {
                return line.toString();
            }
            if (current != '\r') {
                line.append((char) current);
            }
        }
        return line.length() == 0 ? null : line.toString();
    }

    private static final class TunnelSelector extends ProxySelector {
        private final ProxySelector fallback;
        private final int port;

        TunnelSelector(ProxySelector fallback, int port) {
            this.fallback = fallback;
            this.port = port;
        }

        @Override
        public List<Proxy> select(URI uri) {
            if (HOST.equals(uri.getHost())) {
                return Collections.singletonList(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", port)));
            }
            return fallback == null ? Collections.singletonList(Proxy.NO_PROXY) : fallback.select(uri);
        }

        @Override
        public void connectFailed(URI uri, SocketAddress address, IOException error) {
            // nothing to reroute: the fake server is the only proxy
        }
    }
}
