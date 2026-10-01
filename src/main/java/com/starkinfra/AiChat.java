package com.starkinfra;

import com.starkinfra.utils.AiApi;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;

import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;


public final class AiChat extends Resource {
    /**
     * AiChat object
     * <p>
     * An AiChat is a conversation between a user and an AiAgent. The chat holds no text itself: each turn is an
     * AiMessage posted to it.
     * <p>
     * When you initialize an AiChat, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * agentId [string]: id of the AiAgent that answers in this chat. ex: "5656565656565656"
     * <p>
     * Parameters (optional):
     * title [string, default null]: title of the chat. Up to 100 characters. When omitted, the API generates one from the first message. ex: "Order 123"
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the AiChat is created. ex: "5656565656565656"
     * agentName [string]: name of the agent. Only present when requested with expand ["agentName"].
     * updated [string]: latest update datetime for the AiChat. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public String agentId;
    public String title;
    public String agentName;
    public String updated;

    private static final String PATH = "/ai-chat";
    private static final String KEY = "chat";

    /**
     * AiChat object
     * <p>
     * An AiChat is a conversation between a user and an AiAgent. The chat holds no text itself: each turn is an
     * AiMessage posted to it.
     * <p>
     * When you initialize an AiChat, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param agentId [string]: id of the AiAgent that answers in this chat. ex: "5656565656565656"
     * <p>
     * Parameters (optional):
     * @param title [string, default null]: title of the chat. Up to 100 characters. When omitted, the API generates one from the first message. ex: "Order 123"
     * <p>
     * Attributes (return-only):
     * @param id [string]: unique id returned when the AiChat is created. ex: "5656565656565656"
     * @param agentName [string]: name of the agent. Only present when requested with expand ["agentName"].
     * @param updated [string]: latest update datetime for the AiChat. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public AiChat(String agentId, String title, String id, String agentName, String updated) {
        super(id);
        this.agentId = agentId;
        this.title = title;
        this.agentName = agentName;
        this.updated = updated;
    }

    /**
     * AiChat object
     * <p>
     * An AiChat is a conversation between a user and an AiAgent. The chat holds no text itself: each turn is an
     * AiMessage posted to it.
     * <p>
     * When you initialize an AiChat, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param agentId [string]: id of the AiAgent that answers in this chat. ex: "5656565656565656"
     * <p>
     * Parameters (optional):
     * @param title [string, default null]: title of the chat. Up to 100 characters. When omitted, the API generates one from the first message. ex: "Order 123"
     */
    public AiChat(String agentId, String title) {
        this(agentId, title, null, null, null);
    }

    /**
     * Create an AiChat
     * <p>
     * Send an AiChat object for creation at the Stark Infra API
     * <p>
     * Parameters:
     * @param chat [AiChat object]: AiChat object to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiChat object with updated attributes
     * @throws Exception error in the request
     */
    public static AiChat create(AiChat chat, User user) throws Exception {
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("agentId", chat.agentId);
        payload.put("title", chat.title);
        return AiApi.createOne(PATH, KEY, AiApi.dropNulls(payload), null, user, AiChat.class);
    }

    /**
     * Create an AiChat
     * <p>
     * Send an AiChat object for creation at the Stark Infra API
     * <p>
     * Parameters:
     * @param chat [AiChat object]: AiChat object to be created in the API
     * <p>
     * Return:
     * @return AiChat object with updated attributes
     * @throws Exception error in the request
     */
    public static AiChat create(AiChat chat) throws Exception {
        return create(chat, null);
    }

    /**
     * Retrieve a specific AiChat
     * <p>
     * Receive a single AiChat object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters for the request
     * fields [list of strings, default null]: attributes to keep in the response. ex: ["id", "title"]
     * expand [list of strings, default null]: extra attributes to compute. Options: "agentName". When fields is also given, the expanded attribute must be listed there too.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiChat object with updated attributes
     * @throws Exception error in the request
     */
    public static AiChat get(String id, Map<String, Object> params, User user) throws Exception {
        return AiApi.getOne(PATH, id, KEY, AiApi.dropNulls(params), user, AiChat.class);
    }

    /**
     * Retrieve a specific AiChat
     * <p>
     * Receive a single AiChat object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters for the request
     * fields [list of strings, default null]: attributes to keep in the response. ex: ["id", "title"]
     * expand [list of strings, default null]: extra attributes to compute. Options: "agentName". When fields is also given, the expanded attribute must be listed there too.
     * <p>
     * Return:
     * @return AiChat object with updated attributes
     * @throws Exception error in the request
     */
    public static AiChat get(String id, Map<String, Object> params) throws Exception {
        return get(id, params, null);
    }

    /**
     * Retrieve a specific AiChat
     * <p>
     * Receive a single AiChat object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiChat object with updated attributes
     * @throws Exception error in the request
     */
    public static AiChat get(String id, User user) throws Exception {
        return get(id, null, user);
    }

    /**
     * Retrieve a specific AiChat
     * <p>
     * Receive a single AiChat object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return AiChat object with updated attributes
     * @throws Exception error in the request
     */
    public static AiChat get(String id) throws Exception {
        return get(id, null, null);
    }

    /**
     * Retrieve AiChats
     * <p>
     * Receive a generator of AiChat objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * fields [list of strings, default null]: attributes to keep in the response. ex: ["id", "title"]
     * expand [list of strings, default null]: extra attributes to compute. Options: "agentName". When fields is also given, the expanded attribute must be listed there too.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiChat objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiChat> query(Map<String, Object> params, User user) throws Exception {
        // this route is not paginated and rejects limit, cursor and every filter (invalidQueryString)
        return AiApi.listAll(PATH, "chats", AiApi.dropNulls(params), user, AiChat.class);
    }

    /**
     * Retrieve AiChats
     * <p>
     * Receive a generator of AiChat objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * fields [list of strings, default null]: attributes to keep in the response. ex: ["id", "title"]
     * expand [list of strings, default null]: extra attributes to compute. Options: "agentName". When fields is also given, the expanded attribute must be listed there too.
     * <p>
     * Return:
     * @return generator of AiChat objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiChat> query(Map<String, Object> params) throws Exception {
        return query(params, null);
    }

    /**
     * Retrieve AiChats
     * <p>
     * Receive a generator of AiChat objects previously created in the Stark Infra API
     * <p>
     * Return:
     * @return generator of AiChat objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiChat> query() throws Exception {
        return query(null, null);
    }

    /**
     * Update AiChat entity
     * <p>
     * Rename a chat or hand it over to another agent. Only the fields present in the map are sent.
     * <p>
     * Parameters:
     * @param id [string]: AiChat unique id. ex: "5656565656565656"
     * @param patchData map of parameters
     * title [string, default null]: new title of the chat. Up to 100 characters.
     * agentId [string, default null]: id of the AiAgent that answers from now on.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiChat with updated attributes
     * @throws Exception error in the request
     */
    public static AiChat update(String id, Map<String, Object> patchData, User user) throws Exception {
        return AiApi.patchOne(PATH, id, KEY, AiApi.dropNulls(patchData), user, AiChat.class);
    }

    /**
     * Update AiChat entity
     * <p>
     * Rename a chat or hand it over to another agent. Only the fields present in the map are sent.
     * <p>
     * Parameters:
     * @param id [string]: AiChat unique id. ex: "5656565656565656"
     * @param patchData map of parameters
     * title [string, default null]: new title of the chat. Up to 100 characters.
     * agentId [string, default null]: id of the AiAgent that answers from now on.
     * <p>
     * Return:
     * @return AiChat with updated attributes
     * @throws Exception error in the request
     */
    public static AiChat update(String id, Map<String, Object> patchData) throws Exception {
        return update(id, patchData, null);
    }

    /**
     * Delete AiChats
     * <p>
     * Delete up to 100 AiChats at once. The messages of a deleted chat go with it.
     * <p>
     * Parameters:
     * @param ids [list of strings]: ids of the AiChats to be deleted. Up to 100 ids. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of deleted AiChat objects
     * @throws Exception error in the request
     */
    public static List<AiChat> delete(List<String> ids, User user) throws Exception {
        return AiApi.deleteMany(PATH, "chats", ids, user, AiChat.class);
    }

    /**
     * Delete AiChats
     * <p>
     * Delete up to 100 AiChats at once. The messages of a deleted chat go with it.
     * <p>
     * Parameters:
     * @param ids [list of strings]: ids of the AiChats to be deleted. Up to 100 ids. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return list of deleted AiChat objects
     * @throws Exception error in the request
     */
    public static List<AiChat> delete(List<String> ids) throws Exception {
        return delete(ids, null);
    }
}
