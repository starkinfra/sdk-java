import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;

import com.starkinfra.Settings;
import com.starkinfra.AiChat;
import com.starkcore.error.InputErrors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class TestAiChat {

    @BeforeClass
    public static void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
    }

    @Test
    public void testCreateReturnsTheChat() throws Exception {
        AiChat chat = utils.AiFixtures.chat();

        Assert.assertNotNull(chat.id);
        Assert.assertEquals(utils.AiFixtures.agent().id, chat.agentId);
    }

    @Test
    public void testGetAndExpandAgentName() throws Exception {
        AiChat chat = utils.AiFixtures.chat();
        HashMap<String, Object> params = new HashMap<>();
        params.put("expand", Arrays.asList("agentName"));

        Assert.assertNull(AiChat.get(chat.id).agentName);
        Assert.assertEquals(utils.AiFixtures.agent().name, AiChat.get(chat.id, params).agentName);
    }

    @Test
    public void testQuery() throws Exception {
        AiChat chat = utils.AiFixtures.chat();

        List<String> ids = new ArrayList<>();
        for (AiChat entity : AiChat.query()) {
            ids.add(entity.id);
        }
        Assert.assertTrue(ids.contains(chat.id));
    }

    @Test
    public void testUpdateChangesOnlyTheTitle() throws Exception {
        AiChat chat = utils.AiFixtures.chat();
        HashMap<String, Object> patch = new HashMap<>();
        patch.put("title", "renamed-by-sdk");

        try {
            AiChat updated = AiChat.update(chat.id, patch);
            Assert.assertEquals("renamed-by-sdk", updated.title);
            Assert.assertEquals(chat.agentId, updated.agentId);
        } finally {
            HashMap<String, Object> restore = new HashMap<>();
            restore.put("title", chat.title);
            AiChat.update(chat.id, restore);
        }
    }

    @Test
    public void testDeleteReturnsTheDeletedChats() throws Exception {
        AiChat chat = AiChat.create(new AiChat(utils.AiFixtures.agent().id, "sdk-java-delete"));

        List<AiChat> deleted = AiChat.delete(Arrays.asList(chat.id));
        Assert.assertEquals(chat.id, deleted.get(0).id);
    }

    @Test(expected = InputErrors.class)
    public void testCreateWithUnknownAgentRaisesInputErrors() throws Exception {
        AiChat.create(new AiChat("0000000000000000", null));
    }

    @Test(expected = InputErrors.class)
    public void testGetUnknownIdRaisesInputErrors() throws Exception {
        AiChat.get("0000000000000000");
    }
}
