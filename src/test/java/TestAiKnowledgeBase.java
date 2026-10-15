import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.starkinfra.Settings;
import com.starkinfra.AiKnowledgeBase;
import com.starkinfra.utils.Generator;
import com.starkcore.error.InputErrors;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAiKnowledgeBase {

    private static AiKnowledgeBase knowledgeBase;

    @BeforeClass
    public static void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
        knowledgeBase = AiKnowledgeBase.create(utils.AiKnowledgeBase.example());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        AiKnowledgeBase.delete(Arrays.asList(knowledgeBase.id));
    }

    @Test
    public void testCreateReturnsProcessingKnowledgeBase() {
        Assert.assertNotNull(knowledgeBase.id);
        Assert.assertEquals("processing", knowledgeBase.status);
        Assert.assertEquals("https://docs.starkinfra.com", knowledgeBase.rootUrl);
        Assert.assertEquals(Boolean.FALSE, knowledgeBase.isRecursive);
        Assert.assertArrayEquals(new String[]{"sdk-java", "test"}, knowledgeBase.tags);
        Assert.assertNotNull(knowledgeBase.created);
        Assert.assertNotNull(knowledgeBase.updated);
    }

    @Test
    public void testGet() throws Exception {
        AiKnowledgeBase fetched = AiKnowledgeBase.get(knowledgeBase.id);
        Assert.assertEquals(knowledgeBase.id, fetched.id);
        Assert.assertEquals(knowledgeBase.name, fetched.name);
    }

    @Test
    public void testQueryFiltersByIds() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("ids", Arrays.asList(knowledgeBase.id));

        List<String> found = new ArrayList<>();
        for (AiKnowledgeBase entity : AiKnowledgeBase.query(params)) {
            found.add(entity.id);
        }
        Assert.assertEquals(Arrays.asList(knowledgeBase.id), found);
    }

    @Test
    public void testQueryFiltersByNameAndStatus() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("name", knowledgeBase.name);
        params.put("status", AiKnowledgeBase.get(knowledgeBase.id).status);

        List<String> found = new ArrayList<>();
        for (AiKnowledgeBase entity : AiKnowledgeBase.query(params)) {
            found.add(entity.id);
        }
        Assert.assertTrue(found.contains(knowledgeBase.id));
    }

    @Test
    public void testQueryWithoutMatchIsEmpty() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("name", "no-knowledge-base-has-this-name");

        Generator<AiKnowledgeBase> found = AiKnowledgeBase.query(params);
        Assert.assertFalse(found.iterator().hasNext());
    }

    @Test
    public void testPageReturnsTheKnowledgeBasesAndACursor() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);

        AiKnowledgeBase.Page page = AiKnowledgeBase.page(params);
        Assert.assertEquals(1, page.knowledgeBases.size());
        Assert.assertTrue(page.cursor == null || !page.cursor.isEmpty());
    }

    @Test
    public void testPageFiltersByIds() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("ids", Arrays.asList(knowledgeBase.id));

        AiKnowledgeBase.Page page = AiKnowledgeBase.page(params);
        Assert.assertEquals(Arrays.asList(knowledgeBase.id), Arrays.asList(page.knowledgeBases.get(0).id));
        Assert.assertNull(page.cursor);
    }

    @Test
    public void testQueryWithLimitStopsAtTheLimit() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);

        List<String> found = new ArrayList<>();
        for (AiKnowledgeBase entity : AiKnowledgeBase.query(params)) {
            found.add(entity.id);
        }
        Assert.assertEquals(1, found.size());
    }

    @Test
    public void testUpdateChangesNameAndTagsOnly() throws Exception {
        HashMap<String, Object> patch = new HashMap<>();
        patch.put("name", "renamed-by-sdk");
        patch.put("tags", new String[]{"renamed"});

        AiKnowledgeBase updated = AiKnowledgeBase.update(knowledgeBase.id, patch);
        Assert.assertEquals("renamed-by-sdk", updated.name);
        Assert.assertArrayEquals(new String[]{"renamed"}, updated.tags);
        Assert.assertEquals(knowledgeBase.rootUrl, updated.rootUrl);
    }

    @Test(expected = InputErrors.class)
    public void testQueryWithANegativeLimitRaisesInputErrors() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", -1);

        AiKnowledgeBase.query(params).iterator().next();
    }

    @Test(expected = InputErrors.class)
    public void testPageWithALimitAboveTheMaximumRaisesInputErrors() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 101);

        AiKnowledgeBase.page(params);
    }

    @Test(expected = InputErrors.class)
    public void testCreateWithInvalidRootUrlRaisesInputErrors() throws Exception {
        AiKnowledgeBase.create(new AiKnowledgeBase("invalid", "not-a-url", null, null));
    }

    @Test(expected = InputErrors.class)
    public void testGetUnknownIdRaisesInputErrors() throws Exception {
        AiKnowledgeBase.get("0000000000000000");
    }
}
