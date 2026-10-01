package utils;

import com.starkinfra.AiAgent;
import com.starkinfra.AiChat;
import com.starkinfra.AiMessage;
import com.starkinfra.AiKnowledgeBase;
import com.starkcore.error.InternalServerError;

import java.util.UUID;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


// The AI resources that cannot be deleted (voice, speech, transcript) are only created at the HTTP boundary or by
// reading what already exists. Agents, chats and knowledge bases can be deleted, so one of each is shared by every
// test in the process and removed when it ends.
public class AiFixtures {

    private static AiKnowledgeBase knowledgeBase;
    private static AiAgent agent;
    private static AiChat chat;
    private static List<AiMessage> messages;
    private static boolean cleanupRegistered = false;

    public static synchronized AiKnowledgeBase knowledgeBase() throws Exception {
        if (knowledgeBase != null) {
            return knowledgeBase;
        }
        registerCleanup();
        knowledgeBase = AiKnowledgeBase.create(utils.AiKnowledgeBase.example());
        return knowledgeBase;
    }

    public static synchronized AiAgent agent() throws Exception {
        if (agent != null) {
            return agent;
        }
        registerCleanup();
        agent = AiAgent.create(exampleAgent(new String[]{knowledgeBase().id}));
        return agent;
    }

    public static synchronized AiChat chat() throws Exception {
        if (chat != null) {
            return chat;
        }
        registerCleanup();
        chat = AiChat.create(new AiChat(agent().id, name("sdk-java-chat")));
        return chat;
    }

    // one model call per run: it takes seconds and its answer is what the message tests read
    public static synchronized List<AiMessage> messages() throws Exception {
        if (messages != null) {
            return messages;
        }
        messages = AiMessage.create(
            new AiMessage(chat().id, "Say hello and mention order 123."),
            Arrays.asList("chatName")
        );
        return messages;
    }

    public static AiAgent exampleAgent(String[] knowledgeBaseIds) {
        Map<String, Object> orderId = new HashMap<>();
        orderId.put("type", "string");
        orderId.put("description", "Order the customer mentions");
        Map<String, Object> schema = new HashMap<>();
        schema.put("order_id", orderId);
        return new AiAgent(
            name("sdk-java-agent"), "bender-1.0", "Answer in one short sentence.", null, knowledgeBaseIds, schema
        );
    }

    public static String name(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString().replace("-", "").substring(0, 12);
    }

    private static void registerCleanup() {
        if (cleanupRegistered) {
            return;
        }
        cleanupRegistered = true;
        Runtime.getRuntime().addShutdownHook(new Thread(AiFixtures::cleanup));
    }

    private static void cleanup() {
        if (chat != null) {
            deleteOrReport("chat", chat.id, () -> AiChat.delete(Arrays.asList(chat.id)));
        }
        if (agent != null) {
            deleteOrReport("agent", agent.id, () -> AiAgent.delete(Arrays.asList(agent.id)));
        }
        if (knowledgeBase != null) {
            deleteOrReport("knowledgeBase", knowledgeBase.id, () -> AiKnowledgeBase.delete(Arrays.asList(knowledgeBase.id)));
        }
    }

    private interface Deletion {
        void run() throws Exception;
    }

    private static void deleteOrReport(String kind, String id, Deletion deletion) {
        try {
            deletion.run();
        } catch (InternalServerError e) {
            System.err.println(kind + " " + id + " was not deleted: the API answered 500");
        } catch (Exception e) {
            System.err.println(kind + " " + id + " was not deleted: " + e.getClass().getSimpleName());
        }
    }
}
