import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import com.starkinfra.Settings;
import com.starkinfra.AiVoice;
import com.starkcore.error.InputErrors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class TestAiVoice {

    private static String audio;
    private static AiVoice voice;

    @BeforeClass
    public static void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
        audio = utils.AiFixtures.speechAudio();
        Assume.assumeTrue("the workspace has no finished speech to take an audio from", audio != null);
        voice = AiVoice.create(new AiVoice(audio, "sdk-java test", null, null, null));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (voice != null) {
            AiVoice.delete(Arrays.asList(voice.id));
        }
    }

    @Test
    public void testCreateReturnsAProcessingVoice() {
        Assert.assertNotNull(voice.id);
        Assert.assertEquals("processing", voice.status);
        Assert.assertEquals("sdk-java test", voice.name);
        Assert.assertNotNull(voice.created);
        Assert.assertNull(voice.audio);
    }

    @Test
    public void testQueryListsTheCreatedVoiceWithoutTheAudio() throws Exception {
        AiVoice found = null;
        for (AiVoice entity : AiVoice.query()) {
            if (voice.id.equals(entity.id)) {
                found = entity;
            }
        }
        Assert.assertNotNull(found);
        Assert.assertNull(found.audio);
        Assert.assertNotNull(found.errors);
    }

    @Test
    public void testQueryWithLimitStopsAtTheLimit() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);

        List<AiVoice> found = new ArrayList<>();
        for (AiVoice entity : AiVoice.query(params)) {
            found.add(entity);
        }
        Assert.assertEquals(1, found.size());
    }

    @Test
    public void testPageReturnsTheVoicesAndACursor() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);

        AiVoice.Page page = AiVoice.page(params);
        Assert.assertEquals(1, page.voices.size());
        Assert.assertTrue(page.cursor == null || !page.cursor.isEmpty());
    }

    @Test
    public void testDeleteReturnsTheDeletedVoice() throws Exception {
        AiVoice extra = AiVoice.create(new AiVoice(audio, "sdk-java delete test", null, null, null));

        List<AiVoice> deleted = AiVoice.delete(Arrays.asList(extra.id));
        Assert.assertEquals(Arrays.asList(extra.id), Arrays.asList(deleted.get(0).id));
    }

    @Test(expected = InputErrors.class)
    public void testQueryWithANegativeLimitRaisesInputErrors() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", -1);

        AiVoice.query(params).iterator().next();
    }

    @Test(expected = InputErrors.class)
    public void testPageWithALimitAboveTheMaximumRaisesInputErrors() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 101);

        AiVoice.page(params);
    }
}
