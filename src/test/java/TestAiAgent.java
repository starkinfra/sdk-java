import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import com.starkinfra.Settings;
import com.starkinfra.AiAgent;
import com.starkinfra.AiKnowledgeBase;
import com.starkcore.error.InputErrors;

import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;


public class TestAiAgent {

    private static AiKnowledgeBase knowledgeBase;
    private static AiAgent sharedAgent;

    @BeforeClass
    public static void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
        knowledgeBase = AiKnowledgeBase.create(utils.AiKnowledgeBase.example());
        sharedAgent = AiAgent.create(utils.AiFixtures.exampleAgent(new String[]{knowledgeBase.id}));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        try {
            AiAgent.delete(Arrays.asList(sharedAgent.id));
        } finally {
            AiKnowledgeBase.delete(Arrays.asList(knowledgeBase.id));
        }
    }

    @Test
    public void testCreateKeepsTheSchemaKeysAsWritten() throws Exception {
        AiAgent agent = sharedAgent;

        Assert.assertNotNull(agent.id);
        Assert.assertEquals("bender-1.0", agent.model);
        Assert.assertArrayEquals(new String[]{knowledgeBase.id}, agent.knowledgeBaseIds);
        Assert.assertEquals(Arrays.asList("order_id"), new ArrayList<>(agent.metadataSchema.keySet()));
        Assert.assertNotNull(agent.created);
    }

    @Test
    public void testGetAndExpandKnowledgeBases() throws Exception {
        AiAgent agent = sharedAgent;

        AiAgent plain = AiAgent.get(agent.id);
        Assert.assertEquals(agent.id, plain.id);
        Assert.assertNull(plain.knowledgeBases);

        HashMap<String, Object> params = new HashMap<>();
        params.put("expand", Arrays.asList("knowledgeBases"));
        AiAgent expanded = AiAgent.get(agent.id, params);
        Assert.assertEquals(1, expanded.knowledgeBases.size());
        Assert.assertEquals(knowledgeBase.id, expanded.knowledgeBases.get(0).id);
    }

    @Test
    public void testQueryAndPageListTheAgent() throws Exception {
        AiAgent agent = sharedAgent;

        List<String> ids = new ArrayList<>();
        for (AiAgent entity : AiAgent.query()) {
            ids.add(entity.id);
        }
        Assert.assertTrue(ids.contains(agent.id));

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        AiAgent.Page page = AiAgent.page(params);
        Assert.assertEquals(1, page.agents.size());
        Assert.assertTrue(page.cursor == null || !page.cursor.isEmpty());
    }

    @Test
    public void testQueryWithLimitStopsAtTheLimit() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);

        List<AiAgent> found = new ArrayList<>();
        for (AiAgent entity : AiAgent.query(params)) {
            found.add(entity);
        }
        Assert.assertEquals(1, found.size());
    }

    @Test
    public void testPageWithTheNextCursorReturnsAnotherPage() throws Exception {
        AiAgent second = AiAgent.create(utils.AiFixtures.exampleAgent(null));
        try {
            HashMap<String, Object> params = new HashMap<>();
            params.put("limit", 1);
            AiAgent.Page first = AiAgent.page(params);
            Assert.assertNotNull(first.cursor);

            params.put("cursor", first.cursor);
            AiAgent.Page next = AiAgent.page(params);
            Assert.assertEquals(1, next.agents.size());
            Assert.assertNotEquals(first.agents.get(0).id, next.agents.get(0).id);
        } finally {
            AiAgent.delete(Arrays.asList(second.id));
        }
    }

    @Test
    public void testUpdateKeepsWhatItWasNotAskedToChange() throws Exception {
        AiAgent agent = sharedAgent;
        AiAgent original = AiAgent.get(agent.id);
        HashMap<String, Object> patch = new HashMap<>();
        patch.put("name", "renamed-by-sdk");

        try {
            AiAgent renamed = AiAgent.update(agent.id, patch);
            Assert.assertEquals("renamed-by-sdk", renamed.name);
            Assert.assertEquals(original.systemPrompt, renamed.systemPrompt);
            Assert.assertArrayEquals(new String[]{knowledgeBase.id}, renamed.knowledgeBaseIds);
            Assert.assertEquals(Arrays.asList("order_id"), new ArrayList<>(renamed.metadataSchema.keySet()));
        } finally {
            HashMap<String, Object> restore = new HashMap<>();
            restore.put("name", original.name);
            AiAgent.update(agent.id, restore);
        }
    }

    @Test
    public void testUpdateWithEmptyValuesClearsTheKnowledgeBasesAndTheSchema() throws Exception {
        AiAgent agent = AiAgent.create(utils.AiFixtures.exampleAgent(new String[]{knowledgeBase.id}));
        try {
            HashMap<String, Object> patch = new HashMap<>();
            patch.put("knowledgeBaseIds", new String[]{});
            patch.put("metadataSchema", new HashMap<String, Object>());

            AiAgent cleared = AiAgent.update(agent.id, patch);
            Assert.assertEquals(0, cleared.knowledgeBaseIds.length);
            Assert.assertTrue(cleared.metadataSchema.isEmpty());
        } finally {
            AiAgent.delete(Arrays.asList(agent.id));
        }
    }

    @Test
    public void testDeleteReturnsTheDeletedAgents() throws Exception {
        AiAgent agent = AiAgent.create(utils.AiFixtures.exampleAgent(null));

        List<AiAgent> deleted = AiAgent.delete(Arrays.asList(agent.id));
        Assert.assertEquals(Arrays.asList(agent.id), Arrays.asList(deleted.get(0).id));
    }

    @Test(expected = InputErrors.class)
    public void testQueryWithANegativeLimitRaisesInputErrors() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", -1);

        AiAgent.query(params).iterator().next();
    }

    @Test(expected = InputErrors.class)
    public void testPageWithALimitAboveTheMaximumRaisesInputErrors() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 101);

        AiAgent.page(params);
    }

    @Test(expected = InputErrors.class)
    public void testCreateWithInvalidModelRaisesInputErrors() throws Exception {
        AiAgent.create(new AiAgent("invalid", "gpt"));
    }

    @Test(expected = InputErrors.class)
    public void testGetUnknownIdRaisesInputErrors() throws Exception {
        AiAgent.get("0000000000000000");
    }
}
