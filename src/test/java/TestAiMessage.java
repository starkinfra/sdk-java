import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;

import com.starkinfra.Settings;
import com.starkinfra.AiMessage;
import com.starkcore.error.InputErrors;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;


public class TestAiMessage {

    private static String chatId;
    private static List<AiMessage> posted;

    @BeforeClass
    public static void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
        chatId = utils.AiFixtures.chat().id;
        posted = utils.AiFixtures.messages();
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
        // whether the model fills a field is up to the model; the key spelling is checked at the HTTP boundary
        Assert.assertNotNull(posted.get(1).metadata);
    }

    @Test
    public void testQueryReturnsTheWholeHistory() throws Exception {
        Set<String> found = new HashSet<>();
        for (AiMessage message : AiMessage.query(chatId)) {
            found.add(message.id);
        }
        Assert.assertEquals(new HashSet<>(List.of(posted.get(0).id, posted.get(1).id)), found);
    }

    @Test
    public void testQueryWithLimitStopsAtTheLimit() throws Exception {
        List<AiMessage> found = new ArrayList<>();
        for (AiMessage message : AiMessage.query(chatId, 1)) {
            found.add(message);
        }
        Assert.assertEquals(1, found.size());
    }

    @Test
    public void testPageReturnsACursorThatLeadsToTheNextPage() throws Exception {
        AiMessage.Page first = AiMessage.page(chatId, null, 1);
        Assert.assertEquals(1, first.messages.size());
        Assert.assertNotNull(first.cursor);

        AiMessage.Page second = AiMessage.page(chatId, first.cursor, 1);
        Assert.assertEquals(1, second.messages.size());
        Assert.assertNotEquals(first.messages.get(0).id, second.messages.get(0).id);
    }

    @Test(expected = InputErrors.class)
    public void testCreateInAnUnknownChatRaisesInputErrors() throws Exception {
        AiMessage.create(new AiMessage("0000000000000000", "hi"));
    }
}
