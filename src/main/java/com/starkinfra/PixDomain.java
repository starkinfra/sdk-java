package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.List;
import java.util.HashMap;


public final class PixDomain extends SubResource {
    /**
     * PixDomain object
     * <p>
     * The PixDomain object displays the domain and certificate information of registered
     * SPI participants able to issue dynamic QR Codes.
     * They are used in the validation of the URLs contained in the dynamic QR Codes.
     * <p>
     * Parameters:
     * certificates [list of Certificate objects]: list of Certificate objects of the SPI participant in PEM format.
     * name [string]: current active domain (URL) of the SPI participant.
     *
     */
    static ClassData data = new ClassData(PixDomain.class, "PixDomain");
    
    public List<Certificate> certificates;
    public String name;

    /**
     * PixDomain object
     * <p>
     * The PixDomain object displays the certificate information of registered
     * SPI participants able to issue dynamic QR Codes.
     * They are used in the validation of the URLs contained in the dynamic QR Codes.
     * <p>
     * Parameters:
     * @param certificates [list of Certificate objects]: list of Certificate objects of the SPI participant in PEM format.
     * @param name  [string]: current active domain (URL) of the SPI participant.
     */
    public PixDomain(List<Certificate> certificates, String name) {
        this.certificates = certificates;
        this.name = name;
    }

    /**
     * Retrieve PixDomains
     * <p>
     * Receive a generator of PixDomain objects.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixDomain objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixDomain> query(User user) throws Exception {
        return Rest.getStream(data, new HashMap<String, Object>(), user);
    }

    /**
     * Retrieve PixDomains
     * <p>
     * Receive a generator of PixDomain objects.
     * <p>
     * Return:
     * @return generator of PixDomain objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixDomain> query() throws Exception {
        return PixDomain.query(null);
    }

    /**
     * PixDomain Certificate object
     * <p>
     * The Certificate object displays the certificate's content from a specific domain.
     * <p>
     * Attributes (return-only):
     * content [string]: certificate's content of the Pix participant in PEM format.
     */
    public final static class Certificate extends SubResource {
        public String content;

        static ClassData data = new ClassData(Certificate.class, "Certificate");

        /***
         * PixDomain Certificate object
         * <p>
         * The Certificate object displays the certificate's content from a specific domain.
         * <p>
         * Parameters:
         * @param content [string]: certificate of the Pix participant in PEM format.
         */
        public Certificate(String content) {
            this.content = content;
        }
    }

}
