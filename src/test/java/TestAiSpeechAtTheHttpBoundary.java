import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.AiSpeech;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.HashMap;


// A speech cannot be deleted and every creation leaves one behind, so creating is checked at the HTTP boundary.
public class TestAiSpeechAtTheHttpBoundary {

    private static final String SPEECH = "{\"id\":\"5646488461901824\",\"voiceId\":\"5632499082330112\","
        + "\"text\":\"Short test.\",\"status\":\"success\",\"audio\":\"SUQzBAAAAAAA\",\"errors\":[],"
        + "\"created\":\"2026-10-01T14:28:06.942491+00:00\",\"updated\":\"2026-10-01T14:28:07.605185+00:00\"}";

    @Test
    public void testCreateSendsOnlyTheCreatableFields() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        AiSpeech returned = new AiSpeech(
            "5632499082330112", "Short test.", "5646488461901824", "success", "SUQzBAAAAAAA", "Fakas", new String[]{},
            "2026-10-01T14:28:06+00:00", "2026-10-01T14:28:07+00:00"
        );

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"speech\":" + SPEECH + "}")) {
            AiSpeech created = AiSpeech.create(returned);

            Assert.assertEquals("POST", api.requests.get(0).method);
            Assert.assertEquals("/v2/ai-speech", api.requests.get(0).target);
            Assert.assertEquals(new TreeSet<>(Arrays.asList("text", "voiceId")), utils.AiBoundary.keys(api.requests.get(0).body));
            Assert.assertEquals("5632499082330112", created.voiceId);
            Assert.assertEquals("SUQzBAAAAAAA", created.audio);
            Assert.assertEquals("success", created.status);
        }
    }

    @Test
    public void testQueryReadsTheSpeechesKeyAndSendsFieldsAndExpand() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("fields", Arrays.asList("id", "voiceName"));
        params.put("expand", Arrays.asList("voiceName"));

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"speeches\":[" + SPEECH + "]}")) {
            int count = 0;
            for (AiSpeech speech : AiSpeech.query(params)) {
                Assert.assertEquals("5646488461901824", speech.id);
                count++;
            }

            Assert.assertEquals(1, count);
            Assert.assertEquals("/v2/ai-speech", utils.AiBoundary.path(api.requests.get(0).target));
            Assert.assertEquals(
                new TreeSet<>(Arrays.asList("expand=voiceName", "fields=id,voiceName")),
                new TreeSet<>(utils.AiBoundary.queryPairs(api.requests.get(0).target))
            );
        }
    }

    @Test
    public void testGetReadsTheSpeechKeyAndSendsNoLimit() throws Exception {
        utils.AiBoundary.useThrowawayProject();

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"speech\":" + SPEECH + "}")) {
            AiSpeech speech = AiSpeech.get("5646488461901824");

            Assert.assertEquals("GET", api.requests.get(0).method);
            Assert.assertEquals("/v2/ai-speech/5646488461901824", api.requests.get(0).target);
            Assert.assertEquals("SUQzBAAAAAAA", speech.audio);
        }
    }
}
