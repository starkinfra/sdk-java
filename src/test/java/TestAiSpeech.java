import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;

import com.starkinfra.Settings;
import com.starkinfra.AiSpeech;
import com.starkcore.error.InputErrors;

import java.util.Arrays;
import java.util.HashMap;


// A speech cannot be deleted and every creation leaves one behind, so the live tests only read;
// creating is checked in TestAiSpeechAtTheHttpBoundary.
public class TestAiSpeech {

    @BeforeClass
    public static void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
    }

    private static AiSpeech finishedSpeech() throws Exception {
        for (AiSpeech speech : AiSpeech.query()) {
            if ("success".equals(speech.status)) {
                return speech;
            }
        }
        Assume.assumeTrue("the workspace has no finished speech to read", false);
        return null;
    }

    @Test
    public void testQueryLeavesTheAudioOut() throws Exception {
        for (AiSpeech speech : AiSpeech.query()) {
            Assert.assertNotNull(speech.id);
            Assert.assertNull(speech.audio);
            Assert.assertNotNull(speech.created);
        }
    }

    @Test
    public void testQueryFieldsKeepOnlyWhatWasAsked() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("fields", Arrays.asList("id", "status"));

        for (AiSpeech speech : AiSpeech.query(params)) {
            Assert.assertNotNull(speech.id);
            Assert.assertNull(speech.text);
        }
    }

    @Test
    public void testGetReturnsTheAudio() throws Exception {
        AiSpeech speech = finishedSpeech();

        AiSpeech fetched = AiSpeech.get(speech.id);
        Assert.assertEquals(speech.id, fetched.id);
        Assert.assertFalse(fetched.audio == null || fetched.audio.isEmpty());
    }

    @Test
    public void testGetExpandVoiceName() throws Exception {
        AiSpeech speech = finishedSpeech();
        HashMap<String, Object> params = new HashMap<>();
        params.put("fields", Arrays.asList("id", "voiceName"));
        params.put("expand", Arrays.asList("voiceName"));

        AiSpeech fetched = AiSpeech.get(speech.id, params);
        Assert.assertFalse(fetched.voiceName == null || fetched.voiceName.isEmpty());
    }

    @Test(expected = InputErrors.class)
    public void testGetUnknownIdRaisesInputErrors() throws Exception {
        AiSpeech.get("0000000000000000");
    }
}
