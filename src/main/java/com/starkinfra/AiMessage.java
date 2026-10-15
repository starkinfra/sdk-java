package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.ResponseHandler;

import com.starkcore.utils.SubResource;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public final class AiMessage extends Resource {
    /**
     * AiMessage object
     * <p>
     * An AiMessage is a single turn of an AiChat. You post what the user said and the same call returns the user's
     * message and the agent's answer.
     * <p>
     * When you initialize an AiMessage, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the user's message and the agent's answer.
     * <p>
     * Parameters (required):
     * chatId [string]: id of the AiChat to post to. ex: "5656565656565656"
     * text [string]: content of the user's message. Between 1 and 50000 characters. ex: "What is the status of my order?"
     * <p>
     * Parameters (optional):
     * model [string, default null]: AI model to use for this turn only. Options: "bender-1.0", "prime-1.0". The API defaults to the agent's own model.
     * <p>
     * Attributes (return-only):
     * id [string]: unique id of the AiMessage. ex: "5656565656565656"
     * sender [string]: who wrote the message. Options: "user", "system". The agent's answers are sent by "system".
     * speech [string]: version of the text written to be heard rather than read, ready to be sent to AiSpeech. Only filled when the agent has a voice.
     * metadata [map]: structured data the agent extracted, shaped by the agent's metadataSchema. The keys are the agent's, exactly as it declared them.
     * chatName [string]: title of the chat. Only present when create is called with expand ["chatName"].
     * created [string]: creation datetime for the AiMessage. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public String chatId;
    public String text;
    public String model;
    public String sender;
    public String speech;
    public Map<String, Object> metadata;
    public String chatName;
    public String created;

    static ClassData data = new ClassData(AiMessage.class, "AiMessage");

    private static final String PATH = "/ai-message";

    /**
     * AiMessage object
     * <p>
     * An AiMessage is a single turn of an AiChat. You post what the user said and the same call returns the user's
     * message and the agent's answer.
     * <p>
     * When you initialize an AiMessage, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the user's message and the agent's answer.
     * <p>
     * Parameters (required):
     * @param chatId [string]: id of the AiChat to post to. ex: "5656565656565656"
     * @param text [string]: content of the user's message. Between 1 and 50000 characters. ex: "What is the status of my order?"
     * <p>
     * Parameters (optional):
     * @param model [string, default null]: AI model to use for this turn only. Options: "bender-1.0", "prime-1.0". The API defaults to the agent's own model.
     * <p>
     * Attributes (return-only):
     * @param id [string]: unique id of the AiMessage. ex: "5656565656565656"
     * @param sender [string]: who wrote the message. Options: "user", "system". The agent's answers are sent by "system".
     * @param speech [string]: version of the text written to be heard rather than read, ready to be sent to AiSpeech. Only filled when the agent has a voice.
     * @param metadata [map]: structured data the agent extracted, shaped by the agent's metadataSchema. The keys are the agent's, exactly as it declared them.
     * @param chatName [string]: title of the chat. Only present when create is called with expand ["chatName"].
     * @param created [string]: creation datetime for the AiMessage. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public AiMessage(String chatId, String text, String model, String id, String sender, String speech,
                     Map<String, Object> metadata, String chatName, String created
    ) {
        super(id);
        this.chatId = chatId;
        this.text = text;
        this.model = model;
        this.sender = sender;
        this.speech = speech;
        this.metadata = metadata;
        this.chatName = chatName;
        this.created = created;
    }

    /**
     * AiMessage object
     * <p>
     * An AiMessage is a single turn of an AiChat. You post what the user said and the same call returns the user's
     * message and the agent's answer.
     * <p>
     * When you initialize an AiMessage, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the user's message and the agent's answer.
     * <p>
     * Parameters (required):
     * @param chatId [string]: id of the AiChat to post to. ex: "5656565656565656"
     * @param text [string]: content of the user's message. Between 1 and 50000 characters. ex: "What is the status of my order?"
     * <p>
     * Parameters (optional):
     * @param model [string, default null]: AI model to use for this turn only. Options: "bender-1.0", "prime-1.0". The API defaults to the agent's own model.
     */
    public AiMessage(String chatId, String text, String model) {
        this(chatId, text, model, null, null, null, null, null, null);
    }

    /**
     * AiMessage object
     * <p>
     * An AiMessage is a single turn of an AiChat. You post what the user said and the same call returns the user's
     * message and the agent's answer.
     * <p>
     * Parameters (required):
     * @param chatId [string]: id of the AiChat to post to. ex: "5656565656565656"
     * @param text [string]: content of the user's message. Between 1 and 50000 characters. ex: "What is the status of my order?"
     */
    public AiMessage(String chatId, String text) {
        this(chatId, text, null);
    }

    /**
     * Create an AiMessage
     * <p>
     * Post the user's message to an AiChat. The call waits for the agent and returns both messages.
     * <p>
     * Parameters:
     * @param message [AiMessage object]: AiMessage object with chatId and text, to be created in the API
     * @param expand [list of strings, default null]: extra attributes to compute. Options: "chatName", which returns the chat title on every message, useful on the first turn, when the title is generated. It travels in the query string, not in the body.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list with the user's AiMessage and the agent's AiMessage
     * @throws Exception error in the request
     */
    public static List<AiMessage> create(AiMessage message, List<String> expand, User user) throws Exception {
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("chatId", message.chatId);
        payload.put("text", message.text);
        payload.put("model", message.model);
        Map<String, Object> query = null;
        if (expand != null) {
            query = new HashMap<>();
            query.put("expand", expand);
        }
        String content = Rest.postRaw(PATH, payload, query, user).content();
        List<AiMessage> messages = ResponseHandler.post(content, AiMessage.class, "messages");
        JsonElement chatName = new Gson().fromJson(content, JsonObject.class).get("chatName");
        for (AiMessage created : messages) {
            created.chatName = chatName == null || chatName.isJsonNull() ? null : chatName.getAsString();
        }
        return messages;
    }

    /**
     * Create an AiMessage
     * <p>
     * Post the user's message to an AiChat. The call waits for the agent and returns both messages.
     * <p>
     * Parameters:
     * @param message [AiMessage object]: AiMessage object with chatId and text, to be created in the API
     * @param expand [list of strings, default null]: extra attributes to compute. Options: "chatName", which returns the chat title on every message, useful on the first turn, when the title is generated. It travels in the query string, not in the body.
     * <p>
     * Return:
     * @return list with the user's AiMessage and the agent's AiMessage
     * @throws Exception error in the request
     */
    public static List<AiMessage> create(AiMessage message, List<String> expand) throws Exception {
        return create(message, expand, null);
    }

    /**
     * Create an AiMessage
     * <p>
     * Post the user's message to an AiChat. The call waits for the agent and returns both messages.
     * <p>
     * Parameters:
     * @param message [AiMessage object]: AiMessage object with chatId and text, to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list with the user's AiMessage and the agent's AiMessage
     * @throws Exception error in the request
     */
    public static List<AiMessage> create(AiMessage message, User user) throws Exception {
        return create(message, null, user);
    }

    /**
     * Create an AiMessage
     * <p>
     * Post the user's message to an AiChat. The call waits for the agent and returns both messages.
     * <p>
     * Parameters:
     * @param message [AiMessage object]: AiMessage object with chatId and text, to be created in the API
     * <p>
     * Return:
     * @return list with the user's AiMessage and the agent's AiMessage
     * @throws Exception error in the request
     */
    public static List<AiMessage> create(AiMessage message) throws Exception {
        return create(message, null, null);
    }

    /**
     * Retrieve AiMessages
     * <p>
     * Receive a generator of AiMessage objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. The API answers up to 100 objects per request. ex: 35
     * chatId [string, default null]: id of the AiChat whose messages you want. When omitted, the messages of the whole workspace are returned. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiMessage objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiMessage> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve AiMessages
     * <p>
     * Receive a generator of AiMessage objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. The API answers up to 100 objects per request. ex: 35
     * chatId [string, default null]: id of the AiChat whose messages you want. When omitted, the messages of the whole workspace are returned. ex: "5656565656565656"
     * <p>
     * Return:
     * @return generator of AiMessage objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiMessage> query(Map<String, Object> params) throws Exception {
        return query(params, null);
    }

    /**
     * Retrieve AiMessages
     * <p>
     * Receive a generator of AiMessage objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiMessage objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiMessage> query(User user) throws Exception {
        return query(new HashMap<>(), user);
    }

    /**
     * Retrieve AiMessages
     * <p>
     * Receive a generator of AiMessage objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * <p>
     * Return:
     * @return generator of AiMessage objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiMessage> query() throws Exception {
        return query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<AiMessage> messages;
        public String cursor;

        public Page(List<AiMessage> messages, String cursor) {
            this.messages = messages;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged AiMessages
     * <p>
     * Receive a list of up to 100 AiMessage objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your messages.
     * <p>
     * Parameters:
     * @param params map of parameters for the request
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. The API accepts integers between 1 and 100 and answers an error for any other value. ex: 35
     * chatId [string, default null]: id of the AiChat whose messages you want. When omitted, the messages of the whole workspace are returned. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiMessage.Page object:
     * AiMessage.Page.messages: list of AiMessage objects with updated attributes
     * AiMessage.Page.cursor: cursor to retrieve the next page of AiMessage objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<AiMessage> messages = new ArrayList<>();
        for (SubResource item: page.entities) {
            messages.add((AiMessage) item);
        }
        return new Page(messages, page.cursor);
    }

    /**
     * Retrieve paged AiMessages
     * <p>
     * Receive a list of up to 100 AiMessage objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your messages.
     * <p>
     * Parameters:
     * @param params map of parameters for the request
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. The API accepts integers between 1 and 100 and answers an error for any other value. ex: 35
     * chatId [string, default null]: id of the AiChat whose messages you want. When omitted, the messages of the whole workspace are returned. ex: "5656565656565656"
     * <p>
     * Return:
     * @return AiMessage.Page object:
     * AiMessage.Page.messages: list of AiMessage objects with updated attributes
     * AiMessage.Page.cursor: cursor to retrieve the next page of AiMessage objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged AiMessages
     * <p>
     * Receive a list of up to 100 AiMessage objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your messages.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiMessage.Page object:
     * AiMessage.Page.messages: list of AiMessage objects with updated attributes
     * AiMessage.Page.cursor: cursor to retrieve the next page of AiMessage objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged AiMessages
     * <p>
     * Receive a list of up to 100 AiMessage objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your messages.
     * <p>
     * Parameters:
     * <p>
     * Return:
     * @return AiMessage.Page object:
     * AiMessage.Page.messages: list of AiMessage objects with updated attributes
     * AiMessage.Page.cursor: cursor to retrieve the next page of AiMessage objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }
}
