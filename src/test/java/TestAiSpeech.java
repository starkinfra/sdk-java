import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;

import com.starkinfra.Settings;
import com.starkinfra.AiSpeech;
import com.starkinfra.AiVoice;
import com.starkcore.error.InputErrors;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class TestAiSpeech {

    private static AiSpeech speech;

    @BeforeClass
    public static void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
        for (AiVoice voice : AiVoice.query()) {
            if ("success".equals(voice.status)) {
                speech = AiSpeech.create(new AiSpeech(voice.id, "Short test."));
                return;
            }
        }
        Assume.assumeTrue("the workspace has no ready voice to speak with", false);
    }

    @Test
    public void testCreateReturnsTheSynthesizedAudio() {
        Assert.assertNotNull(speech.id);
        Assert.assertEquals("success", speech.status);
        Assert.assertEquals("Short test.", speech.text);
        Assert.assertFalse(speech.audio == null || speech.audio.isEmpty());
        Assert.assertNotNull(speech.created);
    }

    @Test
    public void testGetReturnsTheAudio() throws Exception {
        AiSpeech fetched = AiSpeech.get(speech.id);

        Assert.assertEquals(speech.id, fetched.id);
        Assert.assertFalse(fetched.audio == null || fetched.audio.isEmpty());
    }

    @Test
    public void testGetExpandVoiceName() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("expand", java.util.Arrays.asList("voiceName"));

        AiSpeech fetched = AiSpeech.get(speech.id, params);
        Assert.assertFalse(fetched.voiceName == null || fetched.voiceName.isEmpty());
    }

    @Test
    public void testQueryLeavesTheAudioOut() throws Exception {
        for (AiSpeech entity : AiSpeech.query()) {
            Assert.assertNotNull(entity.id);
            Assert.assertNull(entity.audio);
            Assert.assertNotNull(entity.created);
        }
    }

    @Test
    public void testQueryWithLimitStopsAtTheLimit() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);

        List<AiSpeech> found = new ArrayList<>();
        for (AiSpeech entity : AiSpeech.query(params)) {
            found.add(entity);
        }
        Assert.assertEquals(1, found.size());
    }

    @Test
    public void testPageReturnsTheSpeechesAndACursor() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("expand", java.util.Arrays.asList("voiceName"));

        AiSpeech.Page page = AiSpeech.page(params);
        Assert.assertEquals(1, page.speeches.size());
        Assert.assertNotNull(page.speeches.get(0).voiceName);
        Assert.assertTrue(page.cursor == null || !page.cursor.isEmpty());
    }

    @Test(expected = InputErrors.class)
    public void testPageWithALimitAboveTheMaximumRaisesInputErrors() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 101);

        AiSpeech.page(params);
    }

    @Test(expected = InputErrors.class)
    public void testGetUnknownIdRaisesInputErrors() throws Exception {
        AiSpeech.get("0000000000000000");
    }
}
