package utils;

import com.starkinfra.AiSpeech;
import com.starkinfra.AiAgent;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;


public class AiFixtures {

    public static String speechAudio() throws Exception {
        for (AiSpeech speech : AiSpeech.query()) {
            if ("success".equals(speech.status)) {
                return AiSpeech.get(speech.id).audio;
            }
        }
        return null;
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
}
