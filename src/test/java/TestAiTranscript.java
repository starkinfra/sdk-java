import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;

import com.starkinfra.Settings;
import com.starkinfra.AiTranscript;
import com.starkcore.error.InputErrors;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class TestAiTranscript {

    private static AiTranscript transcript;

    @BeforeClass
    public static void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
        String audio = utils.AiFixtures.speechAudio();
        Assume.assumeTrue("the workspace has no finished speech to take an audio from", audio != null);
        transcript = AiTranscript.create(new AiTranscript(audio));
    }

    @Test
    public void testCreateReturnsTheText() {
        Assert.assertNotNull(transcript.id);
        Assert.assertEquals("success", transcript.status);
        Assert.assertNotNull(transcript.text);
        Assert.assertNotNull(transcript.created);
    }

    @Test
    public void testQueryListsTheCreatedTranscript() throws Exception {
        List<String> ids = new ArrayList<>();
        for (AiTranscript entity : AiTranscript.query()) {
            ids.add(entity.id);
        }
        Assert.assertTrue(ids.contains(transcript.id));
    }

    @Test
    public void testQueryWithLimitStopsAtTheLimit() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);

        List<AiTranscript> found = new ArrayList<>();
        for (AiTranscript entity : AiTranscript.query(params)) {
            found.add(entity);
        }
        Assert.assertEquals(1, found.size());
    }

    @Test
    public void testPageReturnsTheTranscriptsAndACursor() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);

        AiTranscript.Page page = AiTranscript.page(params);
        Assert.assertEquals(1, page.transcripts.size());
        Assert.assertTrue(page.cursor == null || !page.cursor.isEmpty());
    }

    @Test(expected = InputErrors.class)
    public void testQueryWithANegativeLimitRaisesInputErrors() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", -1);

        AiTranscript.query(params).iterator().next();
    }

    @Test(expected = InputErrors.class)
    public void testPageWithALimitAboveTheMaximumRaisesInputErrors() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 101);

        AiTranscript.page(params);
    }
}
