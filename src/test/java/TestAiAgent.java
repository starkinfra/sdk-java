import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;

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

    @BeforeClass
    public static void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
    }

    @Test
    public void testCreateKeepsTheSchemaKeysAsWritten() throws Exception {
        AiAgent agent = utils.AiFixtures.agent();

        Assert.assertNotNull(agent.id);
        Assert.assertEquals("bender-1.0", agent.model);
        Assert.assertArrayEquals(new String[]{utils.AiFixtures.knowledgeBase().id}, agent.knowledgeBaseIds);
        Assert.assertEquals(Arrays.asList("order_id"), new ArrayList<>(agent.metadataSchema.keySet()));
        Assert.assertNotNull(agent.created);
    }

    @Test
    public void testGetAndExpandKnowledgeBases() throws Exception {
        AiAgent agent = utils.AiFixtures.agent();

        AiAgent plain = AiAgent.get(agent.id);
        Assert.assertEquals(agent.id, plain.id);
        Assert.assertNull(plain.knowledgeBases);

        HashMap<String, Object> params = new HashMap<>();
        params.put("expand", Arrays.asList("knowledgeBases"));
        AiAgent expanded = AiAgent.get(agent.id, params);
        Assert.assertEquals(1, expanded.knowledgeBases.size());
        Assert.assertEquals(utils.AiFixtures.knowledgeBase().id, expanded.knowledgeBases.get(0).id);
    }

    @Test
    public void testQueryWithFields() throws Exception {
        AiAgent agent = utils.AiFixtures.agent();
        HashMap<String, Object> params = new HashMap<>();
        params.put("fields", Arrays.asList("id", "name"));

        AiAgent found = null;
        for (AiAgent entity : AiAgent.query(params)) {
            if (agent.id.equals(entity.id)) {
                found = entity;
            }
        }
        Assert.assertNotNull(found);
        Assert.assertEquals(agent.name, found.name);
        Assert.assertNull(found.model);
    }

    @Test
    public void testUpdateKeepsTheKnowledgeBasesItWasNotAskedToChange() throws Exception {
        AiAgent agent = utils.AiFixtures.agent();
        AiAgent original = AiAgent.get(agent.id);
        HashMap<String, Object> patch = new HashMap<>();
        patch.put("name", "renamed-by-sdk");

        try {
            AiAgent renamed = AiAgent.update(agent.id, patch);
            Assert.assertEquals("renamed-by-sdk", renamed.name);
            Assert.assertArrayEquals(new String[]{utils.AiFixtures.knowledgeBase().id}, renamed.knowledgeBaseIds);
            Assert.assertEquals(Arrays.asList("order_id"), new ArrayList<>(renamed.metadataSchema.keySet()));
        } finally {
            HashMap<String, Object> restore = new HashMap<>();
            restore.put("name", original.name);
            AiAgent.update(agent.id, restore);
        }
    }

    @Test
    public void testUpdateWithAnEmptyListClearsTheKnowledgeBases() throws Exception {
        AiAgent agent = AiAgent.create(utils.AiFixtures.exampleAgent(new String[]{utils.AiFixtures.knowledgeBase().id}));
        try {
            HashMap<String, Object> patch = new HashMap<>();
            patch.put("knowledgeBaseIds", new String[]{});

            AiAgent cleared = AiAgent.update(agent.id, patch);
            Assert.assertEquals(0, cleared.knowledgeBaseIds.length);
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
    public void testCreateWithInvalidModelRaisesInputErrors() throws Exception {
        AiAgent.create(new AiAgent("invalid", "gpt"));
    }

    @Test(expected = InputErrors.class)
    public void testGetUnknownIdRaisesInputErrors() throws Exception {
        AiAgent.get("0000000000000000");
    }
}
