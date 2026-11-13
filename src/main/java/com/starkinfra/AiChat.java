package com.starkinfra;

import com.starkinfra.utils.Api;
import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.ResponseHandler;

import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


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
     * tags [list of strings, default null]: tags to label and filter the chat. ex: ["vip", "late"]
     * context [map, default null]: free-form data about the conversation that the agent can read. Its keys are yours and are sent exactly as written. ex: {"customerId": "42"}
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the AiChat is created. ex: "5656565656565656"
     * agentName [string]: name of the agent. Only present when requested with expand ["agentName"].
     * updated [string]: latest update datetime for the AiChat. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public String agentId;
    public String title;
    public String[] tags;
    public Map<String, Object> context;
    public String agentName;
    public String updated;

    static ClassData data = new ClassData(AiChat.class, "AiChat");

    private static final String PATH = "/ai-chat";

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
     * @param tags [list of strings, default null]: tags to label and filter the chat. ex: ["vip", "late"]
     * @param context [map, default null]: free-form data about the conversation that the agent can read. Its keys are yours and are sent exactly as written. ex: {"customerId": "42"}
     * <p>
     * Attributes (return-only):
     * @param id [string]: unique id returned when the AiChat is created. ex: "5656565656565656"
     * @param agentName [string]: name of the agent. Only present when requested with expand ["agentName"].
     * @param updated [string]: latest update datetime for the AiChat. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public AiChat(String agentId, String title, String[] tags, Map<String, Object> context, String id,
                  String agentName, String updated
    ) {
        super(id);
        this.agentId = agentId;
        this.title = title;
        this.tags = tags;
        this.context = context;
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
     * @param tags [list of strings, default null]: tags to label and filter the chat. ex: ["vip", "late"]
     * @param context [map, default null]: free-form data about the conversation that the agent can read. Its keys are yours and are sent exactly as written. ex: {"customerId": "42"}
     */
    public AiChat(String agentId, String title, String[] tags, Map<String, Object> context) {
        this(agentId, title, tags, context, null, null, null);
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
        this(agentId, title, null, null);
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
        return Rest.postSingle(data, chat, user);
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
     * expand [list of strings, default null]: extra attributes to compute. Options: "agentName".
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiChat object with updated attributes
     * @throws Exception error in the request
     */
    public static AiChat get(String id, Map<String, Object> params, User user) throws Exception {
        return Rest.getId(data, id, params, user);
    }

    /**
     * Retrieve a specific AiChat
     * <p>
     * Receive a single AiChat object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters for the request
     * expand [list of strings, default null]: extra attributes to compute. Options: "agentName".
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
     * Receive a generator of AiChat objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. The API answers up to 100 objects per request. ex: 35
     * expand [list of strings, default null]: extra attributes to compute. Options: "agentName".
     * tags [list of strings, default null]: filter for chats that carry the given tags, sent comma-separated. ex: ["vip", "late"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiChat objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiChat> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve AiChats
     * <p>
     * Receive a generator of AiChat objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. The API answers up to 100 objects per request. ex: 35
     * expand [list of strings, default null]: extra attributes to compute. Options: "agentName".
     * tags [list of strings, default null]: filter for chats that carry the given tags, sent comma-separated. ex: ["vip", "late"]
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
     * Receive a generator of AiChat objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiChat objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiChat> query(User user) throws Exception {
        return query(new HashMap<>(), user);
    }

    /**
     * Retrieve AiChats
     * <p>
     * Receive a generator of AiChat objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * <p>
     * Return:
     * @return generator of AiChat objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiChat> query() throws Exception {
        return query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<AiChat> chats;
        public String cursor;

        public Page(List<AiChat> chats, String cursor) {
            this.chats = chats;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged AiChats
     * <p>
     * Receive a list of up to 100 AiChat objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your chats.
     * <p>
     * Parameters:
     * @param params map of parameters for the request
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. The API accepts integers between 1 and 100 and answers an error for any other value. ex: 35
     * expand [list of strings, default null]: extra attributes to compute. Options: "agentName".
     * tags [list of strings, default null]: filter for chats that carry the given tags, sent comma-separated. ex: ["vip", "late"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiChat.Page object:
     * AiChat.Page.chats: list of AiChat objects with updated attributes
     * AiChat.Page.cursor: cursor to retrieve the next page of AiChat objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<AiChat> chats = new ArrayList<>();
        for (SubResource item: page.entities) {
            chats.add((AiChat) item);
        }
        return new Page(chats, page.cursor);
    }

    /**
     * Retrieve paged AiChats
     * <p>
     * Receive a list of up to 100 AiChat objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your chats.
     * <p>
     * Parameters:
     * @param params map of parameters for the request
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. The API accepts integers between 1 and 100 and answers an error for any other value. ex: 35
     * expand [list of strings, default null]: extra attributes to compute. Options: "agentName".
     * tags [list of strings, default null]: filter for chats that carry the given tags, sent comma-separated. ex: ["vip", "late"]
     * <p>
     * Return:
     * @return AiChat.Page object:
     * AiChat.Page.chats: list of AiChat objects with updated attributes
     * AiChat.Page.cursor: cursor to retrieve the next page of AiChat objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged AiChats
     * <p>
     * Receive a list of up to 100 AiChat objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your chats.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiChat.Page object:
     * AiChat.Page.chats: list of AiChat objects with updated attributes
     * AiChat.Page.cursor: cursor to retrieve the next page of AiChat objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged AiChats
     * <p>
     * Receive a list of up to 100 AiChat objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your chats.
     * <p>
     * Parameters:
     * <p>
     * Return:
     * @return AiChat.Page object:
     * AiChat.Page.chats: list of AiChat objects with updated attributes
     * AiChat.Page.cursor: cursor to retrieve the next page of AiChat objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Update AiChat entity
     * <p>
     * Update an AiChat's parameters by passing its id. The API keeps what you do not send: a parameter left out
     * (or null) changes nothing, and a field is cleared by sending an empty value ('' for the title, an empty list, an empty map).
     * <p>
     * Parameters:
     * @param id [string]: AiChat unique id. ex: "5656565656565656"
     * @param patchData map of parameters
     * title [string, default null]: new title for the chat. Up to 100 characters. Send '' to clear it.
     * agentId [string, default null]: id of the AiAgent that answers in this chat.
     * tags [list of strings, default null]: new tags for the chat. Replaces the current list. Send an empty list to clear it.
     * context [map, default null]: new context for the chat. Its keys are sent exactly as written. Send an empty map to clear it.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiChat with updated attributes
     * @throws Exception error in the request
     */
    public static AiChat update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    /**
     * Update AiChat entity
     * <p>
     * Update an AiChat's parameters by passing its id. The API keeps what you do not send: a parameter left out
     * (or null) changes nothing, and a field is cleared by sending an empty value ('' for the title, an empty list, an empty map).
     * <p>
     * Parameters:
     * @param id [string]: AiChat unique id. ex: "5656565656565656"
     * @param patchData map of parameters
     * title [string, default null]: new title for the chat. Up to 100 characters. Send '' to clear it.
     * agentId [string, default null]: id of the AiAgent that answers in this chat.
     * tags [list of strings, default null]: new tags for the chat. Replaces the current list. Send an empty list to clear it.
     * context [map, default null]: new context for the chat. Its keys are sent exactly as written. Send an empty map to clear it.
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
     * Delete up to 100 AiChats at once.
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
        Map<String, Object> query = new HashMap<>();
        query.put("ids", ids);
        String content = Rest.deleteRaw(PATH, query, user).content();
        return ResponseHandler.post(content, AiChat.class, Api.getLastNamePlural(data));
    }

    /**
     * Delete AiChats
     * <p>
     * Delete up to 100 AiChats at once.
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
