import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.AiChat;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.HashMap;


public class TestAiChatAtTheHttpBoundary {

    private static final String CHAT = "{\"id\":\"5761660895625216\",\"agentId\":\"5740688905863168\","
        + "\"title\":\"Support chat\",\"updated\":\"2026-09-30T15:42:58.464506+00:00\"}";

    @Test
    public void testCreateSendsOnlyTheCreatableFields() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        AiChat returned = new AiChat(
            "5740688905863168", "Support chat", "5761660895625216", "Support assistant", "2026-09-30T15:42:58+00:00"
        );

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"chat\":" + CHAT + "}")) {
            AiChat created = AiChat.create(returned);

            Assert.assertEquals("POST", api.requests.get(0).method);
            Assert.assertEquals("/v2/ai-chat", api.requests.get(0).target);
            Assert.assertEquals(new TreeSet<>(Arrays.asList("agentId", "title")), utils.AiBoundary.keys(api.requests.get(0).body));
            Assert.assertEquals("5761660895625216", created.id);
            Assert.assertEquals("2026-09-30T15:42:58.464506+00:00", created.updated);
        }
    }

    @Test
    public void testUpdateSendsOnlyTheGivenFields() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        HashMap<String, Object> patch = new HashMap<>();
        patch.put("title", "New title");
        patch.put("agentId", null);

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"chat\":" + CHAT + "}")) {
            AiChat.update("5761660895625216", patch);

            Assert.assertEquals("PATCH", api.requests.get(0).method);
            Assert.assertEquals("/v2/ai-chat/5761660895625216", api.requests.get(0).target);
            Assert.assertEquals(new TreeSet<>(Arrays.asList("title")), utils.AiBoundary.keys(api.requests.get(0).body));
        }
    }

    @Test
    public void testUpdateWithNoFieldsSendsAnEmptyObject() throws Exception {
        utils.AiBoundary.useThrowawayProject();

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"chat\":" + CHAT + "}")) {
            AiChat.update("5761660895625216", null);

            Assert.assertEquals("{}", api.requests.get(0).body.trim());
        }
    }

    @Test
    public void testGetWithExpandAndQuery() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("expand", Arrays.asList("agentName"));

        try (utils.FakeStarkApi api = new utils.FakeStarkApi(
            "{\"chat\":" + CHAT.replace("\"title\"", "\"agentName\":\"Support assistant\",\"title\"") + "}",
            "{\"chats\":[" + CHAT + "]}"
        )) {
            Assert.assertEquals("Support assistant", AiChat.get("5761660895625216", params).agentName);
            Assert.assertEquals(Arrays.asList("expand=agentName"), utils.AiBoundary.queryPairs(api.requests.get(0).target));

            int count = 0;
            for (AiChat chat : AiChat.query()) {
                Assert.assertEquals("5761660895625216", chat.id);
                count++;
            }
            Assert.assertEquals(1, count);
            Assert.assertEquals("/v2/ai-chat", api.requests.get(1).target);
        }
    }

    @Test
    public void testDeleteSendsIdsInTheQueryStringAndNoBody() throws Exception {
        utils.AiBoundary.useThrowawayProject();

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"chats\":[" + CHAT + "]}")) {
            Assert.assertEquals("5761660895625216", AiChat.delete(Arrays.asList("5761660895625216")).get(0).id);

            Assert.assertEquals("DELETE", api.requests.get(0).method);
            Assert.assertEquals(Arrays.asList("ids=5761660895625216"), utils.AiBoundary.queryPairs(api.requests.get(0).target));
            Assert.assertEquals("", api.requests.get(0).body);
        }
    }
}
