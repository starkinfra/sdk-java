import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;

import com.starkinfra.Settings;
import com.starkinfra.AiVoice;

import java.util.Arrays;
import java.util.HashSet;


// A voice cannot be deleted in the sandbox and every creation leaves one behind, so the live test only reads;
// creating and deleting are checked in TestAiVoiceAtTheHttpBoundary.
public class TestAiVoice {

    @BeforeClass
    public static void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
    }

    @Test
    public void testQuery() throws Exception {
        for (AiVoice voice : AiVoice.query()) {
            Assert.assertNotNull(voice.id);
            Assert.assertTrue(new HashSet<>(Arrays.asList("processing", "success", "failed")).contains(voice.status));
            Assert.assertNotNull(voice.created);
            Assert.assertNotNull(voice.errors);
        }
    }
}
