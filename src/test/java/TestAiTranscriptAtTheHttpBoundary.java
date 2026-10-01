import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.AiTranscript;

import java.util.Arrays;
import java.util.TreeSet;


// A transcript cannot be deleted and every creation leaves one behind, so creating is checked at the HTTP boundary.
public class TestAiTranscriptAtTheHttpBoundary {

    private static final String TRANSCRIPT = "{\"id\":\"5147403464212480\","
        + "\"text\":\"This is a short recording used to test the transcription service.\",\"status\":\"success\","
        + "\"errors\":[],\"created\":\"2026-10-01T14:28:04.482326+00:00\",\"updated\":\"2026-10-01T14:28:05.752389+00:00\"}";

    @Test
    public void testCreateSendsOnlyTheAudio() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        AiTranscript returned = new AiTranscript(
            "UklGRg==", "5147403464212480", "old", "success", new String[]{}, "2026-10-01T14:28:04+00:00", "2026-10-01T14:28:05+00:00"
        );

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"transcript\":" + TRANSCRIPT + "}")) {
            AiTranscript created = AiTranscript.create(returned);

            Assert.assertEquals("POST", api.requests.get(0).method);
            Assert.assertEquals("/v2/ai-transcript", api.requests.get(0).target);
            Assert.assertEquals(new TreeSet<>(Arrays.asList("audio")), utils.AiBoundary.keys(api.requests.get(0).body));
            Assert.assertEquals("success", created.status);
            Assert.assertTrue(created.text.startsWith("This is a short recording"));
        }
    }

    @Test
    public void testQueryReadsTheTranscriptsKey() throws Exception {
        utils.AiBoundary.useThrowawayProject();

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"transcripts\":[" + TRANSCRIPT + "]}")) {
            int count = 0;
            for (AiTranscript transcript : AiTranscript.query()) {
                Assert.assertEquals("5147403464212480", transcript.id);
                count++;
            }

            Assert.assertEquals(1, count);
            Assert.assertEquals("/v2/ai-transcript", api.requests.get(0).target);
        }
    }
}
