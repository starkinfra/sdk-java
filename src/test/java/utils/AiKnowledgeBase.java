package utils;

import java.util.UUID;


public class AiKnowledgeBase {

    public static com.starkinfra.AiKnowledgeBase example() {
        String suffix = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
        return new com.starkinfra.AiKnowledgeBase(
            "sdk-java-" + suffix,
            "https://docs.starkinfra.com",
            false,
            new String[]{"sdk-java", "test"}
        );
    }
}
