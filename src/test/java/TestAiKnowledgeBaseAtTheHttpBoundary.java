import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Key;
import com.starkinfra.Project;
import com.starkinfra.Settings;
import com.starkinfra.AiKnowledgeBase;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.net.URLDecoder;


// The sandbox answers 500 to hosts and delete for a valid id, so these two are checked at the HTTP
// boundary with the payloads documented for the API. Only the network is replaced.
public class TestAiKnowledgeBaseAtTheHttpBoundary {

    private static void useThrowawayProject() throws Exception {
        Settings.user = new Project("sandbox", "5656565656565656", Key.create().privatePem);
    }

    private static List<String> queryPairs(String target) throws Exception {
        List<String> pairs = new ArrayList<>();
        for (String pair : target.substring(target.indexOf('?') + 1).split("&")) {
            if (pair.isEmpty()) {
                continue;
            }
            pairs.add(URLDecoder.decode(pair, "UTF-8"));
        }
        return pairs;
    }

    @Test
    public void testHostsGroupsPagesByHost() throws Exception {
        useThrowawayProject();
        String body = "{\"hosts\": {\"docs.starkinfra.com\": [{"
            + "\"originalUrl\": \"https://docs.starkinfra.com/get-started\", "
            + "\"status\": \"success\", "
            + "\"storageUrl\": \"https://storage.googleapis.com/ai-knowledge/6767676767676767/get-started.md\""
            + "}]}}";

        try (utils.FakeStarkApi api = new utils.FakeStarkApi(body)) {
            Map<String, List<Map<String, Object>>> hosts = AiKnowledgeBase.hosts("6767676767676767");

            Assert.assertEquals(1, api.requests.size());
            Assert.assertEquals("GET", api.requests.get(0).method);
            Assert.assertEquals("/v2/ai-knowledge-base/6767676767676767/hosts", api.requests.get(0).target);

            List<Map<String, Object>> pages = hosts.get("docs.starkinfra.com");
            Assert.assertEquals(1, pages.size());
            Assert.assertEquals("https://docs.starkinfra.com/get-started", pages.get(0).get("originalUrl"));
            Assert.assertEquals("success", pages.get(0).get("status"));
            Assert.assertEquals(
                "https://storage.googleapis.com/ai-knowledge/6767676767676767/get-started.md",
                pages.get(0).get("storageUrl")
            );
        }
    }

    @Test
    public void testDeleteSendsIdsInTheQueryStringAndReturnsTheDeletedObjects() throws Exception {
        useThrowawayProject();
        String body = "{\"knowledgeBases\": [{"
            + "\"id\": \"6767676767676767\", "
            + "\"name\": \"Public Documentation\", "
            + "\"rootUrl\": \"https://docs.starkinfra.com\", "
            + "\"isRecursive\": true, "
            + "\"status\": \"success\", "
            + "\"tags\": [\"support\"], "
            + "\"created\": \"2022-01-01T00:00:00.000000+00:00\", "
            + "\"updated\": \"2022-01-02T00:00:00.000000+00:00\""
            + "}]}";

        try (utils.FakeStarkApi api = new utils.FakeStarkApi(body)) {
            List<AiKnowledgeBase> deleted = AiKnowledgeBase.delete(Arrays.asList("6767676767676767", "6767676767676768"));

            Assert.assertEquals(1, api.requests.size());
            Assert.assertEquals("DELETE", api.requests.get(0).method);
            // starkcore writes the query as "?&ids=a,b"; what matters is the decoded ids parameter
            String target = api.requests.get(0).target;
            Assert.assertEquals("/v2/ai-knowledge-base", target.substring(0, target.indexOf('?')));
            Assert.assertEquals(
                Arrays.asList("ids=6767676767676767,6767676767676768"),
                queryPairs(target)
            );
            Assert.assertEquals("", api.requests.get(0).body);

            Assert.assertEquals(1, deleted.size());
            Assert.assertEquals("6767676767676767", deleted.get(0).id);
            Assert.assertEquals("Public Documentation", deleted.get(0).name);
            Assert.assertEquals(Boolean.TRUE, deleted.get(0).isRecursive);
        }
    }

    @Test
    public void testCreateSendsOnlyTheCreatableFields() throws Exception {
        useThrowawayProject();
        String body = "{\"knowledgeBase\": {\"id\": \"6767676767676767\", \"name\": \"Public Documentation\", "
            + "\"rootUrl\": \"https://docs.starkinfra.com\", \"isRecursive\": false, \"status\": \"processing\", "
            + "\"tags\": [\"support\"], \"created\": \"2022-01-01T00:00:00.000000+00:00\", "
            + "\"updated\": \"2022-01-01T00:00:00.000000+00:00\"}}";
        AiKnowledgeBase returned = new AiKnowledgeBase(
            "Public Documentation", "https://docs.starkinfra.com", false, new String[]{"support"},
            "6767676767676767", "success", "2022-01-01T00:00:00.000000+00:00", "2022-01-02T00:00:00.000000+00:00"
        );

        try (utils.FakeStarkApi api = new utils.FakeStarkApi(body)) {
            AiKnowledgeBase.create(returned);

            Assert.assertEquals("POST", api.requests.get(0).method);
            JsonObject sent = JsonParser.parseString(api.requests.get(0).body).getAsJsonObject();
            Assert.assertEquals(new TreeSet<>(Arrays.asList("isRecursive", "name", "rootUrl", "tags")), new TreeSet<>(sent.keySet()));
        }
    }

    @Test
    public void testQueryAndUpdateAcceptNullArguments() throws Exception {
        useThrowawayProject();
        String list = "{\"knowledgeBases\": []}";
        try (utils.FakeStarkApi api = new utils.FakeStarkApi(list)) {
            Assert.assertFalse(AiKnowledgeBase.query(null, null).iterator().hasNext());
            Assert.assertEquals("GET", api.requests.get(0).method);
        }

        String one = "{\"knowledgeBase\": {\"id\": \"6767676767676767\", \"name\": \"a\", \"rootUrl\": \"https://docs.starkinfra.com\"}}";
        try (utils.FakeStarkApi api = new utils.FakeStarkApi(one)) {
            AiKnowledgeBase.update("6767676767676767", null);
            Assert.assertEquals("PATCH", api.requests.get(0).method);
            Assert.assertEquals("{}", api.requests.get(0).body.trim());
        }
    }
}
