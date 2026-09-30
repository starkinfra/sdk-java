import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;

import com.starkinfra.Settings;
import com.starkinfra.AiTranscript;

import java.util.Arrays;
import java.util.HashSet;


// A transcript cannot be deleted and every creation leaves one behind, so the live test only reads;
// creating is checked in TestAiTranscriptAtTheHttpBoundary.
public class TestAiTranscript {

    @BeforeClass
    public static void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
    }

    @Test
    public void testQuery() throws Exception {
        for (AiTranscript transcript : AiTranscript.query()) {
            Assert.assertNotNull(transcript.id);
            Assert.assertTrue(new HashSet<>(Arrays.asList("processing", "success", "failed")).contains(transcript.status));
            Assert.assertNotNull(transcript.created);
        }
    }
}
