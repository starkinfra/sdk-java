import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.AiMessage;

import java.util.List;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.ArrayList;


public class TestAiMessageAtTheHttpBoundary {

    private static final String USER_MESSAGE = "{\"id\":\"5642368648740864\",\"chatId\":\"5632499082330112\","
        + "\"sender\":\"user\",\"text\":\"Say hello.\",\"speech\":\"Say hello.\",\"metadata\":{},\"model\":\"bender-1.0\","
        + "\"created\":\"2026-10-01T14:28:02.652375+00:00\"}";
    private static final String SYSTEM_MESSAGE = "{\"id\":\"5079418695319552\",\"chatId\":\"5632499082330112\","
        + "\"sender\":\"system\",\"text\":\"Hello!\",\"speech\":\"Hello!\",\"metadata\":{\"order_id\":\"123\"},"
        + "\"model\":\"bender-1.0\",\"created\":\"2026-10-01T14:28:02.653375+00:00\"}";

    @Test
    public void testCreateSendsExpandInTheQueryStringAndNotInTheBody() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        String body = "{\"chatName\":\"Greeting\",\"messages\":[" + USER_MESSAGE + "," + SYSTEM_MESSAGE + "]}";

        try (utils.FakeStarkApi api = new utils.FakeStarkApi(body)) {
            List<AiMessage> messages = AiMessage.create(
                new AiMessage("5632499082330112", "Say hello.", "prime-1.0"),
                Arrays.asList("chatName")
            );

            Assert.assertEquals("POST", api.requests.get(0).method);
            Assert.assertEquals("/v2/ai-message", utils.AiBoundary.path(api.requests.get(0).target));
            Assert.assertEquals(Arrays.asList("expand=chatName"), utils.AiBoundary.queryPairs(api.requests.get(0).target));
            Assert.assertEquals(
                new TreeSet<>(Arrays.asList("chatId", "model", "text")),
                utils.AiBoundary.keys(api.requests.get(0).body)
            );
            Assert.assertEquals(Arrays.asList("user", "system"), Arrays.asList(messages.get(0).sender, messages.get(1).sender));
            Assert.assertEquals("Greeting", messages.get(0).chatName);
            Assert.assertEquals("Greeting", messages.get(1).chatName);
            Assert.assertEquals("123", messages.get(1).metadata.get("order_id"));
        }
    }

    @Test
    public void testCreateWithoutExpandSendsNoQueryAndLeavesChatNameEmpty() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        String body = "{\"messages\":[" + USER_MESSAGE + "," + SYSTEM_MESSAGE + "]}";

        try (utils.FakeStarkApi api = new utils.FakeStarkApi(body)) {
            List<AiMessage> messages = AiMessage.create(new AiMessage("5632499082330112", "Say hello."));

            Assert.assertEquals("/v2/ai-message", api.requests.get(0).target);
            Assert.assertEquals(new TreeSet<>(Arrays.asList("chatId", "text")), utils.AiBoundary.keys(api.requests.get(0).body));
            Assert.assertNull(messages.get(0).chatName);
        }
    }

    @Test
    public void testQueryFollowsTheCursorUntilItRunsOut() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        String first = "{\"cursor\":\"next-page\",\"messages\":[" + USER_MESSAGE + "]}";
        String second = "{\"cursor\":null,\"messages\":[" + SYSTEM_MESSAGE + "]}";

        try (utils.FakeStarkApi api = new utils.FakeStarkApi(first, second)) {
            List<String> ids = new ArrayList<>();
            for (AiMessage message : AiMessage.query("5632499082330112")) {
                ids.add(message.id);
            }

            Assert.assertEquals(Arrays.asList("5642368648740864", "5079418695319552"), ids);
            Assert.assertEquals(2, api.requests.size());
            Assert.assertEquals("/v2/ai-message", utils.AiBoundary.path(api.requests.get(0).target));
            Assert.assertEquals(
                new TreeSet<>(Arrays.asList("chatId=5632499082330112", "limit=100")),
                new TreeSet<>(utils.AiBoundary.queryPairs(api.requests.get(0).target))
            );
            Assert.assertEquals(
                new TreeSet<>(Arrays.asList("chatId=5632499082330112", "cursor=next-page", "limit=100")),
                new TreeSet<>(utils.AiBoundary.queryPairs(api.requests.get(1).target))
            );
        }
    }

    @Test
    public void testQueryStopsAtTheLimit() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        String page = "{\"cursor\":\"next-page\",\"messages\":[" + USER_MESSAGE + "," + SYSTEM_MESSAGE + "]}";

        try (utils.FakeStarkApi api = new utils.FakeStarkApi(page)) {
            int count = 0;
            for (AiMessage message : AiMessage.query("5632499082330112", 1)) {
                count++;
            }

            Assert.assertEquals(1, count);
            Assert.assertEquals(1, api.requests.size());
            Assert.assertTrue(utils.AiBoundary.queryPairs(api.requests.get(0).target).contains("limit=1"));
        }
    }

    @Test
    public void testPageReturnsTheMessagesAndTheCursor() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        String page = "{\"cursor\":\"next-page\",\"messages\":[" + USER_MESSAGE + "]}";

        try (utils.FakeStarkApi api = new utils.FakeStarkApi(page)) {
            AiMessage.Page result = AiMessage.page("5632499082330112", "previous-page", 1);

            Assert.assertEquals("next-page", result.cursor);
            Assert.assertEquals(1, result.messages.size());
            Assert.assertEquals(
                new TreeSet<>(Arrays.asList("chatId=5632499082330112", "cursor=previous-page", "limit=1")),
                new TreeSet<>(utils.AiBoundary.queryPairs(api.requests.get(0).target))
            );
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPageRequiresAChatId() throws Exception {
        AiMessage.page(null);
    }
}
