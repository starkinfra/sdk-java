package com.starkinfra;

import com.starkinfra.utils.AiApi;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;

import java.util.Map;
import java.util.LinkedHashMap;


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
     * audio [string]: base64-encoded MP3 of the speech. Left out of query results; get returns it unless fields is given without it.
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

    private static final String PATH = "/ai-speech";
    private static final String KEY = "speech";

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
     * @param audio [string]: base64-encoded MP3 of the speech. Left out of query results; get returns it unless fields is given without it.
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
     * Send an AiSpeech object for creation at the Stark Infra API. The audio is synthesized during the call.
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
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("voiceId", speech.voiceId);
        payload.put("text", speech.text);
        return AiApi.createOne(PATH, KEY, payload, null, user, AiSpeech.class);
    }

    /**
     * Create an AiSpeech
     * <p>
     * Send an AiSpeech object for creation at the Stark Infra API. The audio is synthesized during the call.
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
     * fields [list of strings, default null]: attributes to keep in the response. The audio is only attached when fields is omitted or lists "audio". ex: ["id", "status", "audio"]
     * expand [list of strings, default null]: extra attributes to compute. Options: "voiceName". When fields is also given, the expanded attribute must be listed there too.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiSpeech object with updated attributes
     * @throws Exception error in the request
     */
    public static AiSpeech get(String id, Map<String, Object> params, User user) throws Exception {
        return AiApi.getOne(PATH, id, KEY, AiApi.dropNulls(params), user, AiSpeech.class);
    }

    /**
     * Retrieve a specific AiSpeech
     * <p>
     * Receive a single AiSpeech object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters for the request
     * fields [list of strings, default null]: attributes to keep in the response. The audio is only attached when fields is omitted or lists "audio". ex: ["id", "status", "audio"]
     * expand [list of strings, default null]: extra attributes to compute. Options: "voiceName". When fields is also given, the expanded attribute must be listed there too.
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
     * Receive a generator of AiSpeech objects previously created in the Stark Infra API. The audio is left out of the results.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * fields [list of strings, default null]: attributes to keep in the response. ex: ["id", "status"]
     * expand [list of strings, default null]: extra attributes to compute. Options: "voiceName". When fields is also given, the expanded attribute must be listed there too.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiSpeech objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiSpeech> query(Map<String, Object> params, User user) throws Exception {
        // this route is not paginated and rejects limit, cursor and every filter (invalidQueryString);
        // starkcore would also read the response under "speechs", but the API answers under "speeches"
        return AiApi.listAll(PATH, "speeches", AiApi.dropNulls(params), user, AiSpeech.class);
    }

    /**
     * Retrieve AiSpeeches
     * <p>
     * Receive a generator of AiSpeech objects previously created in the Stark Infra API. The audio is left out of the results.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * fields [list of strings, default null]: attributes to keep in the response. ex: ["id", "status"]
     * expand [list of strings, default null]: extra attributes to compute. Options: "voiceName". When fields is also given, the expanded attribute must be listed there too.
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
     * Receive a generator of AiSpeech objects previously created in the Stark Infra API. The audio is left out of the results.
     * <p>
     * Return:
     * @return generator of AiSpeech objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiSpeech> query() throws Exception {
        return query(null, null);
    }
}
