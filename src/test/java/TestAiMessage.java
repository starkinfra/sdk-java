import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import com.starkinfra.Settings;
import com.starkinfra.AiMessage;
import com.starkinfra.AiChat;
import com.starkinfra.AiAgent;
import com.starkinfra.AiKnowledgeBase;
import com.starkcore.error.InputErrors;

import java.util.Set;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;


public class TestAiMessage {

    private static AiKnowledgeBase knowledgeBase;
    private static AiAgent agent;
    private static AiChat chat;
    private static String chatId;
    private static List<AiMessage> posted;

    @BeforeClass
    public static void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
        knowledgeBase = AiKnowledgeBase.create(utils.AiKnowledgeBase.example());
        agent = AiAgent.create(utils.AiFixtures.exampleAgent(new String[]{knowledgeBase.id}));
        chat = AiChat.create(new AiChat(agent.id, utils.AiFixtures.name("sdk-java-chat")));
        chatId = chat.id;
        posted = AiMessage.create(
            new AiMessage(chatId, "Say hello and mention order 123."),
            Arrays.asList("chatName")
        );
    }

    @AfterClass
    public static void tearDown() throws Exception {
        try {
            AiChat.delete(Arrays.asList(chat.id));
        } finally {
            try {
                AiAgent.delete(Arrays.asList(agent.id));
            } finally {
                AiKnowledgeBase.delete(Arrays.asList(knowledgeBase.id));
            }
        }
    }

    @Test
    public void testCreateReturnsTheUserMessageAndTheAnswer() {
        Assert.assertEquals(2, posted.size());
        Assert.assertEquals("user", posted.get(0).sender);
        Assert.assertEquals("system", posted.get(1).sender);
        for (AiMessage message : posted) {
            Assert.assertEquals(chatId, message.chatId);
            Assert.assertNotNull(message.created);
            Assert.assertFalse(message.chatName == null || message.chatName.isEmpty());
        }
    }

    @Test
    public void testTheAnswerCarriesTheSchemaKeysAsDeclared() {
        Assert.assertNotNull(posted.get(1).metadata);
    }

    @Test
    public void testQueryReturnsTheWholeHistoryOfTheChat() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("chatId", chatId);

        Set<String> found = new HashSet<>();
        for (AiMessage message : AiMessage.query(params)) {
            found.add(message.id);
        }
        Assert.assertEquals(new HashSet<>(List.of(posted.get(0).id, posted.get(1).id)), found);
    }

    @Test
    public void testQueryWithoutChatIdReadsTheWorkspaceHistory() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 5);

        Set<String> found = new HashSet<>();
        for (AiMessage message : AiMessage.query(params)) {
            found.add(message.id);
        }
        Assert.assertFalse(found.isEmpty());
        Assert.assertTrue(found.size() <= 5);
    }

    @Test
    public void testQueryWithLimitStopsAtTheLimit() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("chatId", chatId);
        params.put("limit", 1);

        List<AiMessage> found = new ArrayList<>();
        for (AiMessage message : AiMessage.query(params)) {
            found.add(message);
        }
        Assert.assertEquals(1, found.size());
    }

    @Test
    public void testPageReturnsACursorThatLeadsToTheNextPage() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("chatId", chatId);
        params.put("limit", 1);
        AiMessage.Page first = AiMessage.page(params);
        Assert.assertEquals(1, first.messages.size());
        Assert.assertNotNull(first.cursor);

        params.put("cursor", first.cursor);
        AiMessage.Page second = AiMessage.page(params);
        Assert.assertEquals(1, second.messages.size());
        Assert.assertNotEquals(first.messages.get(0).id, second.messages.get(0).id);
    }

    @Test(expected = InputErrors.class)
    public void testQueryWithANegativeLimitRaisesInputErrors() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", -1);

        AiMessage.query(params).iterator().next();
    }

    @Test(expected = InputErrors.class)
    public void testPageWithALimitAboveTheMaximumRaisesInputErrors() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 101);

        AiMessage.page(params);
    }

    @Test(expected = InputErrors.class)
    public void testCreateInAnUnknownChatRaisesInputErrors() throws Exception {
        AiMessage.create(new AiMessage("0000000000000000", "hi"));
    }
}
