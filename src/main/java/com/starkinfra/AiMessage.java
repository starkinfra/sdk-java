package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.AiApi;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.ResponseHandler;

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

    private static final String PATH = "/ai-message";
    private static final int PAGE_SIZE = 100;

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
     * @param expand [list of strings, default null]: extra attributes to compute. Options: "chatName", which returns the chat title on every message, useful on the first turn, when the title is generated.
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

        // expand travels in the query string; in the body the API rejects it as an unknown parameter
        Map<String, Object> query = new HashMap<>();
        query.put("expand", expand);

        String content = Rest.postRaw(PATH, AiApi.dropNulls(payload), AiApi.emptyToNull(AiApi.dropNulls(query)), user).content();
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
     * @param expand [list of strings, default null]: extra attributes to compute. Options: "chatName", which returns the chat title on every message, useful on the first turn, when the title is generated.
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
     * Receive a generator of the AiMessage objects of an AiChat, following the cursor until the history ends.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param chatId [string]: id of the AiChat whose messages you want. ex: "5656565656565656"
     * @param limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiMessage objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiMessage> query(String chatId, Integer limit, User user) throws Exception {
        return new Generator<AiMessage>() {
            protected void run() throws Exception {
                String cursor = null;
                int remaining = limit == null ? Integer.MAX_VALUE : limit;
                do {
                    Page page = fetchPage(chatId, cursor, Math.min(remaining, PAGE_SIZE), user);
                    for (AiMessage message : page.messages) {
                        if (remaining <= 0) {
                            return;
                        }
                        this.yield(message);
                        remaining--;
                    }
                    cursor = page.cursor;
                } while (cursor != null && !cursor.isEmpty() && remaining > 0);
            }
        };
    }

    /**
     * Retrieve AiMessages
     * <p>
     * Receive a generator of the AiMessage objects of an AiChat, following the cursor until the history ends.
     * <p>
     * Parameters:
     * @param chatId [string]: id of the AiChat whose messages you want. ex: "5656565656565656"
     * @param limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * <p>
     * Return:
     * @return generator of AiMessage objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiMessage> query(String chatId, Integer limit) throws Exception {
        return query(chatId, limit, null);
    }

    /**
     * Retrieve AiMessages
     * <p>
     * Receive a generator of the AiMessage objects of an AiChat, following the cursor until the history ends.
     * <p>
     * Parameters:
     * @param chatId [string]: id of the AiChat whose messages you want. ex: "5656565656565656"
     * <p>
     * Return:
     * @return generator of AiMessage objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiMessage> query(String chatId) throws Exception {
        return query(chatId, null, null);
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
     * Receive a list of up to 100 AiMessage objects of an AiChat and the cursor to the next page.
     * Use this function instead of query if you want to manually page your messages.
     * <p>
     * Parameters:
     * @param chatId [string]: id of the AiChat whose messages you want. ex: "5656565656565656"
     * @param cursor [string, default null]: cursor returned on the previous page function call
     * @param limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiMessage.Page object:
     * AiMessage.Page.messages: list of AiMessage objects with updated attributes
     * AiMessage.Page.cursor: cursor to retrieve the next page of AiMessage objects
     * @throws Exception error in the request
     */
    public static AiMessage.Page page(String chatId, String cursor, Integer limit, User user) throws Exception {
        return fetchPage(chatId, cursor, limit, user);
    }

    /**
     * Retrieve paged AiMessages
     * <p>
     * Receive a list of up to 100 AiMessage objects of an AiChat and the cursor to the next page.
     * Use this function instead of query if you want to manually page your messages.
     * <p>
     * Parameters:
     * @param chatId [string]: id of the AiChat whose messages you want. ex: "5656565656565656"
     * @param cursor [string, default null]: cursor returned on the previous page function call
     * @param limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * <p>
     * Return:
     * @return AiMessage.Page object:
     * AiMessage.Page.messages: list of AiMessage objects with updated attributes
     * AiMessage.Page.cursor: cursor to retrieve the next page of AiMessage objects
     * @throws Exception error in the request
     */
    public static AiMessage.Page page(String chatId, String cursor, Integer limit) throws Exception {
        return page(chatId, cursor, limit, null);
    }

    /**
     * Retrieve paged AiMessages
     * <p>
     * Receive a list of up to 100 AiMessage objects of an AiChat and the cursor to the next page.
     * Use this function instead of query if you want to manually page your messages.
     * <p>
     * Parameters:
     * @param chatId [string]: id of the AiChat whose messages you want. ex: "5656565656565656"
     * <p>
     * Return:
     * @return AiMessage.Page object:
     * AiMessage.Page.messages: list of AiMessage objects with updated attributes
     * AiMessage.Page.cursor: cursor to retrieve the next page of AiMessage objects
     * @throws Exception error in the request
     */
    public static AiMessage.Page page(String chatId) throws Exception {
        return page(chatId, null, null, null);
    }

    // the history is read one page at a time; the cursor of each page is what leads to the next
    private static Page fetchPage(String chatId, String cursor, Integer limit, User user) throws Exception {
        // without a chatId the API answers 200 with a list that belongs to nobody in particular
        if (chatId == null || chatId.isEmpty()) {
            throw new IllegalArgumentException("chatId is required to retrieve AiMessages");
        }
        Map<String, Object> query = new HashMap<>();
        query.put("chatId", chatId);
        query.put("limit", limit);
        query.put("cursor", cursor);

        String content = Rest.getRaw(PATH, AiApi.dropNulls(query), user).content();
        JsonElement next = new Gson().fromJson(content, JsonObject.class).get("cursor");
        return new Page(
            ResponseHandler.post(content, AiMessage.class, "messages"),
            next == null || next.isJsonNull() ? null : next.getAsString()
        );
    }
}
