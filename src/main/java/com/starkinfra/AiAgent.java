package com.starkinfra;

import com.starkinfra.utils.AiApi;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
import java.util.LinkedHashMap;


public final class AiAgent extends Resource {
    /**
     * AiAgent object
     * <p>
     * An AiAgent is the configuration of an assistant: the model, the instructions, the knowledge it may consult and
     * the voice it speaks with. The agent never changes during a conversation; the conversation lives in an AiChat
     * and each turn is an AiMessage.
     * <p>
     * When you initialize an AiAgent, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * name [string]: name of the agent. Between 1 and 100 characters. ex: "Support assistant"
     * model [string]: AI model the agent runs on. Options: "bender-1.0" for everyday conversations, "prime-1.0" for harder reasoning.
     * <p>
     * Parameters (optional):
     * systemPrompt [string, default null]: instructions that define the agent's persona, tone and domain behavior. Up to 100000 characters. The API falls back to its default assistant prompt when omitted.
     * voiceId [string, default null]: id of the AiVoice the agent speaks with. When set, every reply also carries a speech string ready to be sent to AiSpeech. The API does not check that the voice exists.
     * knowledgeBaseIds [list of strings, default null]: ids of up to 100 AiKnowledgeBases the agent retrieves from before answering. The API does not check that they exist.
     * metadataSchema [map, default null]: flat map whose keys are the fields the agent must extract on every reply. Each field takes a "type" (string, integer, number, boolean or array), an optional "description" of up to 2000 characters, an optional "enum" of up to 20 strings for string fields. The keys are yours and are sent exactly as written. ex: {"order_id": {"type": "string", "description": "Order the customer mentions"}}
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the AiAgent is created. ex: "5656565656565656"
     * knowledgeBases [list of AiKnowledgeBase objects]: the knowledge bases themselves. Only present when requested with expand ["knowledgeBases"].
     * created [string]: creation datetime for the AiAgent. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the AiAgent. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public String name;
    public String model;
    public String systemPrompt;
    public String voiceId;
    public String[] knowledgeBaseIds;
    public Map<String, Object> metadataSchema;
    public List<AiKnowledgeBase> knowledgeBases;
    public String created;
    public String updated;

    private static final String PATH = "/ai-agent";
    private static final String KEY = "agent";

    /**
     * AiAgent object
     * <p>
     * An AiAgent is the configuration of an assistant: the model, the instructions, the knowledge it may consult and
     * the voice it speaks with. The agent never changes during a conversation; the conversation lives in an AiChat
     * and each turn is an AiMessage.
     * <p>
     * When you initialize an AiAgent, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param name [string]: name of the agent. Between 1 and 100 characters. ex: "Support assistant"
     * @param model [string]: AI model the agent runs on. Options: "bender-1.0" for everyday conversations, "prime-1.0" for harder reasoning.
     * <p>
     * Parameters (optional):
     * @param systemPrompt [string, default null]: instructions that define the agent's persona, tone and domain behavior. Up to 100000 characters. The API falls back to its default assistant prompt when omitted.
     * @param voiceId [string, default null]: id of the AiVoice the agent speaks with. When set, every reply also carries a speech string ready to be sent to AiSpeech. The API does not check that the voice exists.
     * @param knowledgeBaseIds [list of strings, default null]: ids of up to 100 AiKnowledgeBases the agent retrieves from before answering. The API does not check that they exist.
     * @param metadataSchema [map, default null]: flat map whose keys are the fields the agent must extract on every reply. Each field takes a "type" (string, integer, number, boolean or array), an optional "description" of up to 2000 characters, an optional "enum" of up to 20 strings for string fields. The keys are yours and are sent exactly as written. ex: {"order_id": {"type": "string", "description": "Order the customer mentions"}}
     * <p>
     * Attributes (return-only):
     * @param id [string]: unique id returned when the AiAgent is created. ex: "5656565656565656"
     * @param knowledgeBases [list of AiKnowledgeBase objects]: the knowledge bases themselves. Only present when requested with expand ["knowledgeBases"].
     * @param created [string]: creation datetime for the AiAgent. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the AiAgent. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public AiAgent(String name, String model, String systemPrompt, String voiceId, String[] knowledgeBaseIds,
                   Map<String, Object> metadataSchema, String id, List<AiKnowledgeBase> knowledgeBases,
                   String created, String updated
    ) {
        super(id);
        this.name = name;
        this.model = model;
        this.systemPrompt = systemPrompt;
        this.voiceId = voiceId;
        this.knowledgeBaseIds = knowledgeBaseIds;
        this.metadataSchema = metadataSchema;
        this.knowledgeBases = knowledgeBases;
        this.created = created;
        this.updated = updated;
    }

    /**
     * AiAgent object
     * <p>
     * An AiAgent is the configuration of an assistant: the model, the instructions, the knowledge it may consult and
     * the voice it speaks with. The agent never changes during a conversation; the conversation lives in an AiChat
     * and each turn is an AiMessage.
     * <p>
     * When you initialize an AiAgent, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param name [string]: name of the agent. Between 1 and 100 characters. ex: "Support assistant"
     * @param model [string]: AI model the agent runs on. Options: "bender-1.0" for everyday conversations, "prime-1.0" for harder reasoning.
     * <p>
     * Parameters (optional):
     * @param systemPrompt [string, default null]: instructions that define the agent's persona, tone and domain behavior. Up to 100000 characters. The API falls back to its default assistant prompt when omitted.
     * @param voiceId [string, default null]: id of the AiVoice the agent speaks with. When set, every reply also carries a speech string ready to be sent to AiSpeech. The API does not check that the voice exists.
     * @param knowledgeBaseIds [list of strings, default null]: ids of up to 100 AiKnowledgeBases the agent retrieves from before answering. The API does not check that they exist.
     * @param metadataSchema [map, default null]: flat map whose keys are the fields the agent must extract on every reply. Each field takes a "type" (string, integer, number, boolean or array), an optional "description" of up to 2000 characters, an optional "enum" of up to 20 strings for string fields. The keys are yours and are sent exactly as written. ex: {"order_id": {"type": "string", "description": "Order the customer mentions"}}
     */
    public AiAgent(String name, String model, String systemPrompt, String voiceId, String[] knowledgeBaseIds,
                   Map<String, Object> metadataSchema
    ) {
        this(name, model, systemPrompt, voiceId, knowledgeBaseIds, metadataSchema, null, null, null, null);
    }

    /**
     * AiAgent object
     * <p>
     * An AiAgent is the configuration of an assistant: the model, the instructions, the knowledge it may consult and
     * the voice it speaks with.
     * <p>
     * Parameters (required):
     * @param name [string]: name of the agent. Between 1 and 100 characters. ex: "Support assistant"
     * @param model [string]: AI model the agent runs on. Options: "bender-1.0" for everyday conversations, "prime-1.0" for harder reasoning.
     */
    public AiAgent(String name, String model) {
        this(name, model, null, null, null, null);
    }

    /**
     * Create an AiAgent
     * <p>
     * Send an AiAgent object for creation at the Stark Infra API
     * <p>
     * Parameters:
     * @param agent [AiAgent object]: AiAgent object to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiAgent object with updated attributes
     * @throws Exception error in the request
     */
    public static AiAgent create(AiAgent agent, User user) throws Exception {
        // written out field by field: metadataSchema keys belong to the caller and must not be case-converted
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("name", agent.name);
        payload.put("model", agent.model);
        payload.put("systemPrompt", agent.systemPrompt);
        // an agent without a voice comes back with voiceId "", which the API rejects, so "" is treated as not given
        payload.put("voiceId", agent.voiceId == null || agent.voiceId.isEmpty() ? null : agent.voiceId);
        payload.put("knowledgeBaseIds", agent.knowledgeBaseIds);
        payload.put("metadataSchema", agent.metadataSchema);
        return AiApi.createOne(PATH, KEY, AiApi.dropNulls(payload), null, user, AiAgent.class);
    }

    /**
     * Create an AiAgent
     * <p>
     * Send an AiAgent object for creation at the Stark Infra API
     * <p>
     * Parameters:
     * @param agent [AiAgent object]: AiAgent object to be created in the API
     * <p>
     * Return:
     * @return AiAgent object with updated attributes
     * @throws Exception error in the request
     */
    public static AiAgent create(AiAgent agent) throws Exception {
        return create(agent, null);
    }

    /**
     * Retrieve a specific AiAgent
     * <p>
     * Receive a single AiAgent object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters for the request
     * fields [list of strings, default null]: attributes to keep in the response. ex: ["id", "name"]
     * expand [list of strings, default null]: extra attributes to compute. Options: "knowledgeBases". When fields is also given, the expanded attribute must be listed there too.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiAgent object with updated attributes
     * @throws Exception error in the request
     */
    public static AiAgent get(String id, Map<String, Object> params, User user) throws Exception {
        return AiApi.getOne(PATH, id, KEY, AiApi.dropNulls(params), user, AiAgent.class);
    }

    /**
     * Retrieve a specific AiAgent
     * <p>
     * Receive a single AiAgent object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters for the request
     * fields [list of strings, default null]: attributes to keep in the response. ex: ["id", "name"]
     * expand [list of strings, default null]: extra attributes to compute. Options: "knowledgeBases". When fields is also given, the expanded attribute must be listed there too.
     * <p>
     * Return:
     * @return AiAgent object with updated attributes
     * @throws Exception error in the request
     */
    public static AiAgent get(String id, Map<String, Object> params) throws Exception {
        return get(id, params, null);
    }

    /**
     * Retrieve a specific AiAgent
     * <p>
     * Receive a single AiAgent object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiAgent object with updated attributes
     * @throws Exception error in the request
     */
    public static AiAgent get(String id, User user) throws Exception {
        return get(id, null, user);
    }

    /**
     * Retrieve a specific AiAgent
     * <p>
     * Receive a single AiAgent object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return AiAgent object with updated attributes
     * @throws Exception error in the request
     */
    public static AiAgent get(String id) throws Exception {
        return get(id, null, null);
    }

    /**
     * Retrieve AiAgents
     * <p>
     * Receive a generator of AiAgent objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * fields [list of strings, default null]: attributes to keep in the response. ex: ["id", "name"]
     * expand [list of strings, default null]: extra attributes to compute. Options: "knowledgeBases". When fields is also given, the expanded attribute must be listed there too.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiAgent objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiAgent> query(Map<String, Object> params, User user) throws Exception {
        // this route is not paginated and rejects limit, cursor and every filter (invalidQueryString)
        return AiApi.listAll(PATH, "agents", AiApi.dropNulls(params), user, AiAgent.class);
    }

    /**
     * Retrieve AiAgents
     * <p>
     * Receive a generator of AiAgent objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * fields [list of strings, default null]: attributes to keep in the response. ex: ["id", "name"]
     * expand [list of strings, default null]: extra attributes to compute. Options: "knowledgeBases". When fields is also given, the expanded attribute must be listed there too.
     * <p>
     * Return:
     * @return generator of AiAgent objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiAgent> query(Map<String, Object> params) throws Exception {
        return query(params, null);
    }

    /**
     * Retrieve AiAgents
     * <p>
     * Receive a generator of AiAgent objects previously created in the Stark Infra API
     * <p>
     * Return:
     * @return generator of AiAgent objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiAgent> query() throws Exception {
        return query(null, null);
    }

    /**
     * Update AiAgent entity
     * <p>
     * Update an AiAgent's parameters by passing its id. Only the parameters you give are changed.
     * The API replaces the knowledge base list with whatever the request carries and clears it when the request
     * carries none, so when knowledgeBaseIds is not given this function reads the agent first and sends its
     * current list back. Pass an empty list to clear the knowledge bases on purpose.
     * The read and the update are two requests, so a knowledge base change made by someone else between them is overwritten.
     * <p>
     * Parameters:
     * @param id [string]: AiAgent unique id. ex: "5656565656565656"
     * @param patchData map of parameters
     * name [string, default null]: new name for the agent. Between 1 and 100 characters.
     * model [string, default null]: new AI model. Options: "bender-1.0", "prime-1.0"
     * systemPrompt [string, default null]: new instructions for the agent. Up to 100000 characters.
     * voiceId [string, default null]: new AiVoice id.
     * knowledgeBaseIds [list of strings, default null]: the AiKnowledgeBase ids the agent should end up with. Replaces the current list.
     * metadataSchema [map, default null]: new schema of the structured data the agent must extract. Its keys are sent exactly as written.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiAgent with updated attributes
     * @throws Exception error in the request
     */
    public static AiAgent update(String id, Map<String, Object> patchData, User user) throws Exception {
        Map<String, Object> payload = AiApi.dropNulls(patchData);
        if ("".equals(payload.get("voiceId"))) {
            payload.remove("voiceId");
        }
        if (!payload.containsKey("knowledgeBaseIds")) {
            Map<String, Object> params = new HashMap<>();
            params.put("fields", Arrays.asList("knowledgeBaseIds"));
            String[] current = get(id, params, user).knowledgeBaseIds;
            if (current != null) {
                payload.put("knowledgeBaseIds", current);
            }
        }
        return AiApi.patchOne(PATH, id, KEY, payload, user, AiAgent.class);
    }

    /**
     * Update AiAgent entity
     * <p>
     * Update an AiAgent's parameters by passing its id. Only the parameters you give are changed.
     * The API replaces the knowledge base list with whatever the request carries and clears it when the request
     * carries none, so when knowledgeBaseIds is not given this function reads the agent first and sends its
     * current list back. Pass an empty list to clear the knowledge bases on purpose.
     * The read and the update are two requests, so a knowledge base change made by someone else between them is overwritten.
     * <p>
     * Parameters:
     * @param id [string]: AiAgent unique id. ex: "5656565656565656"
     * @param patchData map of parameters
     * name [string, default null]: new name for the agent. Between 1 and 100 characters.
     * model [string, default null]: new AI model. Options: "bender-1.0", "prime-1.0"
     * systemPrompt [string, default null]: new instructions for the agent. Up to 100000 characters.
     * voiceId [string, default null]: new AiVoice id.
     * knowledgeBaseIds [list of strings, default null]: the AiKnowledgeBase ids the agent should end up with. Replaces the current list.
     * metadataSchema [map, default null]: new schema of the structured data the agent must extract. Its keys are sent exactly as written.
     * <p>
     * Return:
     * @return AiAgent with updated attributes
     * @throws Exception error in the request
     */
    public static AiAgent update(String id, Map<String, Object> patchData) throws Exception {
        return update(id, patchData, null);
    }

    /**
     * Delete AiAgents
     * <p>
     * Delete up to 100 AiAgents at once.
     * <p>
     * Parameters:
     * @param ids [list of strings]: ids of the AiAgents to be deleted. Up to 100 ids. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of deleted AiAgent objects
     * @throws Exception error in the request
     */
    public static List<AiAgent> delete(List<String> ids, User user) throws Exception {
        return AiApi.deleteMany(PATH, "agents", ids, user, AiAgent.class);
    }

    /**
     * Delete AiAgents
     * <p>
     * Delete up to 100 AiAgents at once.
     * <p>
     * Parameters:
     * @param ids [list of strings]: ids of the AiAgents to be deleted. Up to 100 ids. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return list of deleted AiAgent objects
     * @throws Exception error in the request
     */
    public static List<AiAgent> delete(List<String> ids) throws Exception {
        return delete(ids, null);
    }
}
