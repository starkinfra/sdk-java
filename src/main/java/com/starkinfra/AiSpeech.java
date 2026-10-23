package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;

import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class AiSpeech extends Resource {
    /**
     * AiSpeech object
     * <p>
     * An AiSpeech is one text read out loud by an AiVoice. The speech is synthesized when it is created and comes
     * back as a base64 MP3 in the audio attribute.
     * <p>
     * When you initialize an AiSpeech, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * voiceId [string]: id of the AiVoice that should read the text. Only a voice in "success" can speak. ex: "5656565656565656"
     * text [string]: text to read out loud. Between 1 and 100000 characters. ex: "Hello, how can I help you?"
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the AiSpeech is created. ex: "5656565656565656"
     * status [string]: current status of the speech. Options: "processing", "success", "failed"
     * audio [string]: base64-encoded MP3 of the speech. Left out of query results; get returns it.
     * voiceName [string]: name of the voice. Only present when requested with expand ["voiceName"].
     * errors [list of strings]: reasons the synthesis failed. Empty when it worked.
     * created [string]: creation datetime for the AiSpeech. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the AiSpeech. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public String voiceId;
    public String text;
    public String status;
    public String audio;
    public String voiceName;
    public String[] errors;
    public String created;
    public String updated;

    static ClassData data = new ClassData(AiSpeech.class, "AiSpeech");

    /**
     * AiSpeech object
     * <p>
     * An AiSpeech is one text read out loud by an AiVoice. The speech is synthesized when it is created and comes
     * back as a base64 MP3 in the audio attribute.
     * <p>
     * When you initialize an AiSpeech, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param voiceId [string]: id of the AiVoice that should read the text. Only a voice in "success" can speak. ex: "5656565656565656"
     * @param text [string]: text to read out loud. Between 1 and 100000 characters. ex: "Hello, how can I help you?"
     * <p>
     * Attributes (return-only):
     * @param id [string]: unique id returned when the AiSpeech is created. ex: "5656565656565656"
     * @param status [string]: current status of the speech. Options: "processing", "success", "failed"
     * @param audio [string]: base64-encoded MP3 of the speech. Left out of query results; get returns it.
     * @param voiceName [string]: name of the voice. Only present when requested with expand ["voiceName"].
     * @param errors [list of strings]: reasons the synthesis failed. Empty when it worked.
     * @param created [string]: creation datetime for the AiSpeech. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the AiSpeech. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public AiSpeech(String voiceId, String text, String id, String status, String audio, String voiceName,
                    String[] errors, String created, String updated
    ) {
        super(id);
        this.voiceId = voiceId;
        this.text = text;
        this.status = status;
        this.audio = audio;
        this.voiceName = voiceName;
        this.errors = errors;
        this.created = created;
        this.updated = updated;
    }

    /**
     * AiSpeech object
     * <p>
     * An AiSpeech is one text read out loud by an AiVoice. The speech is synthesized when it is created and comes
     * back as a base64 MP3 in the audio attribute.
     * <p>
     * When you initialize an AiSpeech, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param voiceId [string]: id of the AiVoice that should read the text. Only a voice in "success" can speak. ex: "5656565656565656"
     * @param text [string]: text to read out loud. Between 1 and 100000 characters. ex: "Hello, how can I help you?"
     */
    public AiSpeech(String voiceId, String text) {
        this(voiceId, text, null, null, null, null, null, null, null);
    }

    /**
     * Create an AiSpeech
     * <p>
     * Send an AiSpeech object for creation at the Stark Infra API
     * <p>
     * Parameters:
     * @param speech [AiSpeech object]: AiSpeech object to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiSpeech object with updated attributes
     * @throws Exception error in the request
     */
    public static AiSpeech create(AiSpeech speech, User user) throws Exception {
        return Rest.postSingle(data, speech, user);
    }

    /**
     * Create an AiSpeech
     * <p>
     * Send an AiSpeech object for creation at the Stark Infra API
     * <p>
     * Parameters:
     * @param speech [AiSpeech object]: AiSpeech object to be created in the API
     * <p>
     * Return:
     * @return AiSpeech object with updated attributes
     * @throws Exception error in the request
     */
    public static AiSpeech create(AiSpeech speech) throws Exception {
        return create(speech, null);
    }

    /**
     * Retrieve a specific AiSpeech
     * <p>
     * Receive a single AiSpeech object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters for the request
     * expand [list of strings, default null]: extra attributes to compute. Options: "voiceName".
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiSpeech object with updated attributes
     * @throws Exception error in the request
     */
    public static AiSpeech get(String id, Map<String, Object> params, User user) throws Exception {
        return Rest.getId(data, id, params, user);
    }

    /**
     * Retrieve a specific AiSpeech
     * <p>
     * Receive a single AiSpeech object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters for the request
     * expand [list of strings, default null]: extra attributes to compute. Options: "voiceName".
     * <p>
     * Return:
     * @return AiSpeech object with updated attributes
     * @throws Exception error in the request
     */
    public static AiSpeech get(String id, Map<String, Object> params) throws Exception {
        return get(id, params, null);
    }

    /**
     * Retrieve a specific AiSpeech
     * <p>
     * Receive a single AiSpeech object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiSpeech object with updated attributes
     * @throws Exception error in the request
     */
    public static AiSpeech get(String id, User user) throws Exception {
        return get(id, null, user);
    }

    /**
     * Retrieve a specific AiSpeech
     * <p>
     * Receive a single AiSpeech object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return AiSpeech object with updated attributes
     * @throws Exception error in the request
     */
    public static AiSpeech get(String id) throws Exception {
        return get(id, null, null);
    }

    /**
     * Retrieve AiSpeeches
     * <p>
     * Receive a generator of AiSpeech objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. The API answers up to 100 objects per request. ex: 35
     * expand [list of strings, default null]: extra attributes to compute. Options: "voiceName".
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiSpeech objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiSpeech> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve AiSpeeches
     * <p>
     * Receive a generator of AiSpeech objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. The API answers up to 100 objects per request. ex: 35
     * expand [list of strings, default null]: extra attributes to compute. Options: "voiceName".
     * <p>
     * Return:
     * @return generator of AiSpeech objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiSpeech> query(Map<String, Object> params) throws Exception {
        return query(params, null);
    }

    /**
     * Retrieve AiSpeeches
     * <p>
     * Receive a generator of AiSpeech objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiSpeech objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiSpeech> query(User user) throws Exception {
        return query(new HashMap<>(), user);
    }

    /**
     * Retrieve AiSpeeches
     * <p>
     * Receive a generator of AiSpeech objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * <p>
     * Return:
     * @return generator of AiSpeech objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiSpeech> query() throws Exception {
        return query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<AiSpeech> speeches;
        public String cursor;

        public Page(List<AiSpeech> speeches, String cursor) {
            this.speeches = speeches;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged AiSpeeches
     * <p>
     * Receive a list of up to 100 AiSpeech objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your speeches.
     * <p>
     * Parameters:
     * @param params map of parameters for the request
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. The API accepts integers between 1 and 100 and answers an error for any other value. ex: 35
     * expand [list of strings, default null]: extra attributes to compute. Options: "voiceName".
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiSpeech.Page object:
     * AiSpeech.Page.speeches: list of AiSpeech objects with updated attributes
     * AiSpeech.Page.cursor: cursor to retrieve the next page of AiSpeech objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<AiSpeech> speeches = new ArrayList<>();
        for (SubResource item: page.entities) {
            speeches.add((AiSpeech) item);
        }
        return new Page(speeches, page.cursor);
    }

    /**
     * Retrieve paged AiSpeeches
     * <p>
     * Receive a list of up to 100 AiSpeech objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your speeches.
     * <p>
     * Parameters:
     * @param params map of parameters for the request
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. The API accepts integers between 1 and 100 and answers an error for any other value. ex: 35
     * expand [list of strings, default null]: extra attributes to compute. Options: "voiceName".
     * <p>
     * Return:
     * @return AiSpeech.Page object:
     * AiSpeech.Page.speeches: list of AiSpeech objects with updated attributes
     * AiSpeech.Page.cursor: cursor to retrieve the next page of AiSpeech objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged AiSpeeches
     * <p>
     * Receive a list of up to 100 AiSpeech objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your speeches.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiSpeech.Page object:
     * AiSpeech.Page.speeches: list of AiSpeech objects with updated attributes
     * AiSpeech.Page.cursor: cursor to retrieve the next page of AiSpeech objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged AiSpeeches
     * <p>
     * Receive a list of up to 100 AiSpeech objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your speeches.
     * <p>
     * Parameters:
     * <p>
     * Return:
     * @return AiSpeech.Page object:
     * AiSpeech.Page.speeches: list of AiSpeech objects with updated attributes
     * AiSpeech.Page.cursor: cursor to retrieve the next page of AiSpeech objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }
}
