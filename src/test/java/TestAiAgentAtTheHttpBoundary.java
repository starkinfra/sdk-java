import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.AiAgent;

import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.HashMap;

import com.google.gson.JsonObject;


public class TestAiAgentAtTheHttpBoundary {

    private static final String AGENT = "{\"id\":\"5740688905863168\",\"name\":\"Support assistant\",\"model\":\"bender-1.0\","
        + "\"systemPrompt\":\"Answer in one short sentence.\",\"knowledgeBaseIds\":[\"5083538508480512\"],"
        + "\"metadataSchema\":{\"order_id\":{\"type\":\"string\"}},"
        + "\"created\":\"2026-09-30T15:42:56.879325+00:00\",\"updated\":\"2026-09-30T15:42:56.879334+00:00\"}";

    @Test
    public void testCreateSendsOnlyTheCreatableFieldsAndLeavesTheSchemaKeysAlone() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        Map<String, Object> schema = new HashMap<>();
        schema.put("order_id", new HashMap<String, Object>(Map.of("type", "string")));
        schema.put("isUrgent", new HashMap<String, Object>(Map.of("type", "boolean")));
        AiAgent returned = new AiAgent(
            "Support assistant", "bender-1.0", "Be brief.", "5632499082330112", new String[]{"5083538508480512"}, schema,
            "5740688905863168", null, "2026-09-30T15:42:56+00:00", "2026-09-30T15:42:56+00:00"
        );

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"agent\":" + AGENT + "}")) {
            AiAgent created = AiAgent.create(returned);

            Assert.assertEquals("POST", api.requests.get(0).method);
            Assert.assertEquals("/v2/ai-agent", api.requests.get(0).target);
            Assert.assertEquals(
                new TreeSet<>(Arrays.asList("knowledgeBaseIds", "metadataSchema", "model", "name", "systemPrompt", "voiceId")),
                utils.AiBoundary.keys(api.requests.get(0).body)
            );
            JsonObject sentSchema = utils.AiBoundary.json(api.requests.get(0).body).getAsJsonObject("metadataSchema");
            Assert.assertEquals(new TreeSet<>(Arrays.asList("isUrgent", "order_id")), new TreeSet<>(sentSchema.keySet()));
            Assert.assertEquals("5740688905863168", created.id);
            Assert.assertTrue(created.metadataSchema.containsKey("order_id"));
        }
    }

    @Test
    public void testCreateKeepsEmptyListsAndDropsNulls() throws Exception {
        utils.AiBoundary.useThrowawayProject();

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"agent\":" + AGENT + "}")) {
            AiAgent.create(new AiAgent("a", "prime-1.0", null, null, new String[]{}, null));

            Assert.assertEquals(
                new TreeSet<>(Arrays.asList("knowledgeBaseIds", "model", "name")),
                utils.AiBoundary.keys(api.requests.get(0).body)
            );
        }
    }

    @Test
    public void testAnAgentFetchedWithoutAVoiceCanBeCreatedAgain() throws Exception {
        utils.AiBoundary.useThrowawayProject();

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"agent\":" + AGENT + "}")) {
            AiAgent.create(new AiAgent("a", "bender-1.0", null, "", null, null));

            Assert.assertEquals(
                new TreeSet<>(Arrays.asList("model", "name")),
                utils.AiBoundary.keys(api.requests.get(0).body)
            );
        }
    }

    @Test
    public void testUpdateDropsAnEmptyVoiceId() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        HashMap<String, Object> patch = new HashMap<>();
        patch.put("voiceId", "");
        patch.put("knowledgeBaseIds", new String[]{});

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"agent\":" + AGENT + "}")) {
            AiAgent.update("5740688905863168", patch);

            Assert.assertEquals(
                new TreeSet<>(Arrays.asList("knowledgeBaseIds")),
                utils.AiBoundary.keys(api.requests.get(0).body)
            );
        }
    }

    @Test
    public void testGetWithExpandParsesTheKnowledgeBases() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        String expanded = AGENT.replace(
            "\"knowledgeBaseIds\":[\"5083538508480512\"],",
            "\"knowledgeBaseIds\":[\"5083538508480512\"],\"knowledgeBases\":[{\"id\":\"5083538508480512\",\"name\":\"Docs\","
                + "\"rootUrl\":\"https://docs.starkinfra.com\",\"status\":\"success\"}],"
        );
        HashMap<String, Object> params = new HashMap<>();
        params.put("expand", Arrays.asList("knowledgeBases"));

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"agent\":" + expanded + "}")) {
            AiAgent agent = AiAgent.get("5740688905863168", params);

            Assert.assertEquals("/v2/ai-agent/5740688905863168", utils.AiBoundary.path(api.requests.get(0).target));
            Assert.assertEquals(Arrays.asList("expand=knowledgeBases"), utils.AiBoundary.queryPairs(api.requests.get(0).target));
            Assert.assertEquals(1, agent.knowledgeBases.size());
            Assert.assertEquals("Docs", agent.knowledgeBases.get(0).name);
        }
    }

    @Test
    public void testUpdateWithoutKnowledgeBaseIdsReadsThemFirstAndSendsThemBack() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        String current = "{\"agent\":{\"id\":\"5740688905863168\",\"knowledgeBaseIds\":[\"5083538508480512\"]}}";
        HashMap<String, Object> patch = new HashMap<>();
        patch.put("name", "Renamed");

        try (utils.FakeStarkApi api = new utils.FakeStarkApi(current, "{\"agent\":" + AGENT + "}")) {
            AiAgent.update("5740688905863168", patch);

            Assert.assertEquals(2, api.requests.size());
            Assert.assertEquals("GET", api.requests.get(0).method);
            Assert.assertEquals("/v2/ai-agent/5740688905863168", utils.AiBoundary.path(api.requests.get(0).target));
            Assert.assertEquals(Arrays.asList("fields=knowledgeBaseIds"), utils.AiBoundary.queryPairs(api.requests.get(0).target));
            Assert.assertEquals("PATCH", api.requests.get(1).method);
            Assert.assertEquals("/v2/ai-agent/5740688905863168", api.requests.get(1).target);
            JsonObject sent = utils.AiBoundary.json(api.requests.get(1).body);
            Assert.assertEquals(new TreeSet<>(Arrays.asList("knowledgeBaseIds", "name")), new TreeSet<>(sent.keySet()));
            Assert.assertEquals("[\"5083538508480512\"]", sent.get("knowledgeBaseIds").toString());
        }
    }

    @Test
    public void testUpdateWithKnowledgeBaseIdsDoesNotReadTheAgent() throws Exception {
        utils.AiBoundary.useThrowawayProject();
        HashMap<String, Object> patch = new HashMap<>();
        patch.put("knowledgeBaseIds", new String[]{});

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"agent\":" + AGENT + "}")) {
            AiAgent.update("5740688905863168", patch);

            Assert.assertEquals(1, api.requests.size());
            Assert.assertEquals("PATCH", api.requests.get(0).method);
            Assert.assertEquals("{\"knowledgeBaseIds\":[]}", api.requests.get(0).body.trim());
        }
    }

    @Test
    public void testDeleteSendsIdsInTheQueryStringAndNoBody() throws Exception {
        utils.AiBoundary.useThrowawayProject();

        try (utils.FakeStarkApi api = new utils.FakeStarkApi("{\"agents\":[" + AGENT + "]}")) {
            List<AiAgent> deleted = AiAgent.delete(Arrays.asList("5740688905863168", "5740688905863169"));

            Assert.assertEquals("DELETE", api.requests.get(0).method);
            Assert.assertEquals("/v2/ai-agent", utils.AiBoundary.path(api.requests.get(0).target));
            Assert.assertEquals(
                Arrays.asList("ids=5740688905863168,5740688905863169"),
                utils.AiBoundary.queryPairs(api.requests.get(0).target)
            );
            Assert.assertEquals("", api.requests.get(0).body);
            Assert.assertEquals("5740688905863168", deleted.get(0).id);
        }
    }
}
