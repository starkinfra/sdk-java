import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.AiVoice;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.List;


// A voice cannot be deleted in the sandbox (DELETE answers 500) and every creation leaves one behind, so creating
// and deleting are checked at the HTTP boundary with the payloads the API answers. Only the network is replaced.
public class TestAiVoiceAtTheHttpBoundary {

    private static final String VOICE = "{\"id\":\"5631671361601536\",\"name\":\"Helena\",\"description\":\"Calm voice\","
        + "\"language\":\"portuguese\",\"gender\":\"female\",\"status\":\"processing\",\"errors\":[],"
        + "\"created\":\"2026-10-01T14:28:24.566332+00:00\",\"updated\":\"2026-10-01T14:28:24.566342+00:00\"}";

    @Test
    public void testCreateSendsOnlyTheCreatableFields() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        AiVoice returned = new AiVoice(
            "UklGRg==", "Helena", "Calm voice", "portuguese", "female",
            "5631671361601536", "success", new String[]{}, "2026-10-01T14:28:24+00:00", "2026-10-01T14:28:24+00:00"
        );

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"voice\":" + VOICE + "}")) {
            AiVoice created = AiVoice.create(returned);

            Assert.assertEquals("POST", api.requests.get(0).method);
            Assert.assertEquals("/v2/ai-voice", api.requests.get(0).target);
            Assert.assertEquals(
                new TreeSet<>(Arrays.asList("audio", "description", "gender", "language", "name")),
                utils.AiBoundary.keys(api.requests.get(0).body)
            );
            Assert.assertEquals("5631671361601536", created.id);
            Assert.assertEquals("processing", created.status);
            Assert.assertEquals("2026-10-01T14:28:24.566332+00:00", created.created);
        }
    }

    @Test
    public void testCreateOmitsTheOptionalFieldsItWasNotGiven() throws Exception {
        utils.AiBoundary.useThrowawayProject();

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"voice\":" + VOICE + "}")) {
            AiVoice.create(new AiVoice("UklGRg==", null, null, null, null));

            Assert.assertEquals(new TreeSet<>(Arrays.asList("audio")), utils.AiBoundary.keys(api.requests.get(0).body));
        }
    }

    @Test
    public void testQueryReadsTheVoicesKeyAndSendsNoParameters() throws Exception {
        utils.AiBoundary.useThrowawayProject();

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"voices\":[" + VOICE + "]}")) {
            int count = 0;
            for (AiVoice voice : AiVoice.query()) {
                Assert.assertEquals("5631671361601536", voice.id);
                count++;
            }

            Assert.assertEquals(1, count);
            Assert.assertEquals("GET", api.requests.get(0).method);
            Assert.assertEquals("/v2/ai-voice", api.requests.get(0).target);
        }
    }

    @Test
    public void testDeleteSendsIdsInTheQueryStringAndNoBody() throws Exception {
        utils.AiBoundary.useThrowawayProject();

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"voices\":[" + VOICE + "]}")) {
            List<AiVoice> deleted = AiVoice.delete(Arrays.asList("5631671361601536", "5631671361601537"));

            Assert.assertEquals("DELETE", api.requests.get(0).method);
            Assert.assertEquals("/v2/ai-voice", utils.AiBoundary.path(api.requests.get(0).target));
            Assert.assertEquals(
                Arrays.asList("ids=5631671361601536,5631671361601537"),
                utils.AiBoundary.queryPairs(api.requests.get(0).target)
            );
            Assert.assertEquals("", api.requests.get(0).body);
            Assert.assertEquals(1, deleted.size());
            Assert.assertEquals("5631671361601536", deleted.get(0).id);
        }
    }
}
