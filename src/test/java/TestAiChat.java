import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import com.starkinfra.Settings;
import com.starkinfra.AiChat;
import com.starkinfra.AiAgent;
import com.starkinfra.AiKnowledgeBase;
import com.starkcore.error.InputErrors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class TestAiChat {

    private static AiKnowledgeBase knowledgeBase;
    private static AiAgent agent;
    private static AiChat sharedChat;

    @BeforeClass
    public static void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
        knowledgeBase = AiKnowledgeBase.create(utils.AiKnowledgeBase.example());
        agent = AiAgent.create(utils.AiFixtures.exampleAgent(new String[]{knowledgeBase.id}));
        sharedChat = AiChat.create(new AiChat(agent.id, utils.AiFixtures.name("sdk-java-chat")));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        try {
            AiChat.delete(Arrays.asList(sharedChat.id));
        } finally {
            try {
                AiAgent.delete(Arrays.asList(agent.id));
            } finally {
                AiKnowledgeBase.delete(Arrays.asList(knowledgeBase.id));
            }
        }
    }

    @Test
    public void testCreateReturnsTheChat() throws Exception {
        AiChat chat = sharedChat;

        Assert.assertNotNull(chat.id);
        Assert.assertEquals(agent.id, chat.agentId);
    }

    @Test
    public void testGetAndExpandAgentName() throws Exception {
        AiChat chat = sharedChat;
        HashMap<String, Object> params = new HashMap<>();
        params.put("expand", Arrays.asList("agentName"));

        Assert.assertNull(AiChat.get(chat.id).agentName);
        Assert.assertEquals(agent.name, AiChat.get(chat.id, params).agentName);
    }

    @Test
    public void testQuery() throws Exception {
        AiChat chat = sharedChat;

        List<String> ids = new ArrayList<>();
        for (AiChat entity : AiChat.query()) {
            ids.add(entity.id);
        }
        Assert.assertTrue(ids.contains(chat.id));
    }

    @Test
    public void testUpdateChangesOnlyTheTitle() throws Exception {
        AiChat chat = sharedChat;
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
    public void testCreateWithTagsAndContextReturnsThem() throws Exception {
        HashMap<String, Object> context = new HashMap<>();
        context.put("Customer_Id", "42");
        AiChat chat = AiChat.create(new AiChat(agent.id, "sdk-java-context", new String[]{"sdk-java"}, context));
        try {
            Assert.assertArrayEquals(new String[]{"sdk-java"}, chat.tags);
            Assert.assertEquals("42", chat.context.get("Customer_Id"));
        } finally {
            AiChat.delete(Arrays.asList(chat.id));
        }
    }

    @Test
    public void testAChatCreatedWithoutTagsAndContextComesBackEmpty() throws Exception {
        AiChat chat = AiChat.get(sharedChat.id);

        Assert.assertEquals(0, chat.tags.length);
        Assert.assertTrue(chat.context.isEmpty());
    }

    @Test
    public void testUpdateWithTagsAndContextThenEmptyValuesClearsThem() throws Exception {
        AiChat chat = AiChat.create(new AiChat(agent.id, "sdk-java-update"));
        try {
            HashMap<String, Object> patch = new HashMap<>();
            patch.put("tags", new String[]{"sdk-java", "late"});
            patch.put("context", new HashMap<String, Object>(java.util.Map.of("Customer_Id", "7")));
            AiChat updated = AiChat.update(chat.id, patch);
            Assert.assertArrayEquals(new String[]{"sdk-java", "late"}, updated.tags);
            Assert.assertEquals("7", updated.context.get("Customer_Id"));
            Assert.assertEquals("sdk-java-update", updated.title);

            HashMap<String, Object> clear = new HashMap<>();
            clear.put("tags", new String[]{});
            clear.put("context", new HashMap<String, Object>());
            AiChat cleared = AiChat.update(chat.id, clear);
            Assert.assertEquals(0, cleared.tags.length);
            Assert.assertTrue(cleared.context.isEmpty());
            Assert.assertEquals("sdk-java-update", cleared.title);
        } finally {
            AiChat.delete(Arrays.asList(chat.id));
        }
    }

    @Test
    public void testQueryAndPageFilterByTags() throws Exception {
        AiChat chat = AiChat.create(new AiChat(agent.id, "sdk-java-tags", new String[]{"sdk-java-tag"}, null));
        try {
            HashMap<String, Object> params = new HashMap<>();
            params.put("tags", Arrays.asList("sdk-java-tag"));

            List<String> ids = new ArrayList<>();
            for (AiChat entity : AiChat.query(params)) {
                ids.add(entity.id);
            }
            Assert.assertEquals(Arrays.asList(chat.id), ids);
            Assert.assertEquals(chat.id, AiChat.page(params).chats.get(0).id);
        } finally {
            AiChat.delete(Arrays.asList(chat.id));
        }
    }

    @Test
    public void testPageReturnsTheChatsAndACursorThatLeadsToAnotherPage() throws Exception {
        AiChat second = AiChat.create(new AiChat(agent.id, "sdk-java-page"));
        try {
            HashMap<String, Object> params = new HashMap<>();
            params.put("limit", 1);

            AiChat.Page first = AiChat.page(params);
            Assert.assertEquals(1, first.chats.size());
            Assert.assertNotNull(first.cursor);

            params.put("cursor", first.cursor);
            AiChat.Page next = AiChat.page(params);
            Assert.assertEquals(1, next.chats.size());
            Assert.assertNotEquals(first.chats.get(0).id, next.chats.get(0).id);
        } finally {
            AiChat.delete(Arrays.asList(second.id));
        }
    }

    @Test(expected = InputErrors.class)
    public void testQueryWithANegativeLimitRaisesInputErrors() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", -1);

        AiChat.query(params).iterator().next();
    }

    @Test(expected = InputErrors.class)
    public void testPageWithALimitAboveTheMaximumRaisesInputErrors() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 101);

        AiChat.page(params);
    }

    @Test
    public void testDeleteReturnsTheDeletedChats() throws Exception {
        AiChat chat = AiChat.create(new AiChat(agent.id, "sdk-java-delete"));

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
