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


public final class AiVoice extends Resource {
    /**
     * AiVoice object
     * <p>
     * An AiVoice is a voice cloned from a recording you upload. Once cloned, it can read any text out loud through
     * an AiSpeech, and it can be attached to an AiAgent so every reply carries a speech ready to be synthesized.
     * Cloning is asynchronous: the voice is created in "processing" status and moves to "success" when it is ready
     * to speak, or to "failed" when the recording could not be cloned.
     * <p>
     * When you initialize an AiVoice, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * audio [string]: base64-encoded recording of the speaker. MP3, WAV, OGG, FLAC and WebM are accepted. Up to 10000000 characters.
     * <p>
     * Parameters (optional):
     * name [string, default null]: name of the voice. Up to 100 characters. Defaults to the voice's own id. ex: "Helena"
     * description [string, default null]: free-text description of the voice. Up to 1000 characters.
     * language [string, default null]: language the voice speaks. Options: "portuguese", "english". The API defaults to "portuguese".
     * gender [string, default null]: gender of the voice. Options: "male", "female", "neutral"
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the AiVoice is created. This is the voiceId you send to other AI resources. ex: "5656565656565656"
     * status [string]: current status of the voice. Options: "processing", "success", "failed". Only a voice in "success" can speak.
     * errors [list of strings]: reasons the cloning failed. Empty while the voice is healthy.
     * created [string]: creation datetime for the AiVoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the AiVoice. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public String audio;
    public String name;
    public String description;
    public String language;
    public String gender;
    public String status;
    public String[] errors;
    public String created;
    public String updated;

    static ClassData data = new ClassData(AiVoice.class, "AiVoice");

    private static final String PATH = "/ai-voice";

    /**
     * AiVoice object
     * <p>
     * An AiVoice is a voice cloned from a recording you upload. Once cloned, it can read any text out loud through
     * an AiSpeech, and it can be attached to an AiAgent so every reply carries a speech ready to be synthesized.
     * Cloning is asynchronous: the voice is created in "processing" status and moves to "success" when it is ready
     * to speak, or to "failed" when the recording could not be cloned.
     * <p>
     * When you initialize an AiVoice, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param audio [string]: base64-encoded recording of the speaker. MP3, WAV, OGG, FLAC and WebM are accepted. Up to 10000000 characters.
     * <p>
     * Parameters (optional):
     * @param name [string, default null]: name of the voice. Up to 100 characters. Defaults to the voice's own id. ex: "Helena"
     * @param description [string, default null]: free-text description of the voice. Up to 1000 characters.
     * @param language [string, default null]: language the voice speaks. Options: "portuguese", "english". The API defaults to "portuguese".
     * @param gender [string, default null]: gender of the voice. Options: "male", "female", "neutral"
     * <p>
     * Attributes (return-only):
     * @param id [string]: unique id returned when the AiVoice is created. This is the voiceId you send to other AI resources. ex: "5656565656565656"
     * @param status [string]: current status of the voice. Options: "processing", "success", "failed". Only a voice in "success" can speak.
     * @param errors [list of strings]: reasons the cloning failed. Empty while the voice is healthy.
     * @param created [string]: creation datetime for the AiVoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the AiVoice. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public AiVoice(String audio, String name, String description, String language, String gender, String id,
                   String status, String[] errors, String created, String updated
    ) {
        super(id);
        this.audio = audio;
        this.name = name;
        this.description = description;
        this.language = language;
        this.gender = gender;
        this.status = status;
        this.errors = errors;
        this.created = created;
        this.updated = updated;
    }

    /**
     * AiVoice object
     * <p>
     * An AiVoice is a voice cloned from a recording you upload. Once cloned, it can read any text out loud through
     * an AiSpeech, and it can be attached to an AiAgent so every reply carries a speech ready to be synthesized.
     * <p>
     * When you initialize an AiVoice, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param audio [string]: base64-encoded recording of the speaker. MP3, WAV, OGG, FLAC and WebM are accepted. Up to 10000000 characters.
     * <p>
     * Parameters (optional):
     * @param name [string, default null]: name of the voice. Up to 100 characters. Defaults to the voice's own id. ex: "Helena"
     * @param description [string, default null]: free-text description of the voice. Up to 1000 characters.
     * @param language [string, default null]: language the voice speaks. Options: "portuguese", "english". The API defaults to "portuguese".
     * @param gender [string, default null]: gender of the voice. Options: "male", "female", "neutral"
     */
    public AiVoice(String audio, String name, String description, String language, String gender) {
        this(audio, name, description, language, gender, null, null, null, null, null);
    }

    /**
     * Create an AiVoice
     * <p>
     * Send an AiVoice object for creation at the Stark Infra API and start cloning it.
     * The call returns immediately with the voice in "processing" status.
     * <p>
     * Parameters:
     * @param voice [AiVoice object]: AiVoice object to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiVoice object with updated attributes
     * @throws Exception error in the request
     */
    public static AiVoice create(AiVoice voice, User user) throws Exception {
        return Rest.postSingle(data, voice, user);
    }

    /**
     * Create an AiVoice
     * <p>
     * Send an AiVoice object for creation at the Stark Infra API and start cloning it.
     * The call returns immediately with the voice in "processing" status.
     * <p>
     * Parameters:
     * @param voice [AiVoice object]: AiVoice object to be created in the API
     * <p>
     * Return:
     * @return AiVoice object with updated attributes
     * @throws Exception error in the request
     */
    public static AiVoice create(AiVoice voice) throws Exception {
        return create(voice, null);
    }

    /**
     * Retrieve AiVoices
     * <p>
     * Receive a generator of AiVoice objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. The API answers up to 100 objects per request. ex: 35
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiVoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiVoice> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve AiVoices
     * <p>
     * Receive a generator of AiVoice objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. The API answers up to 100 objects per request. ex: 35
     * <p>
     * Return:
     * @return generator of AiVoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiVoice> query(Map<String, Object> params) throws Exception {
        return query(params, null);
    }

    /**
     * Retrieve AiVoices
     * <p>
     * Receive a generator of AiVoice objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiVoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiVoice> query(User user) throws Exception {
        return query(new HashMap<>(), user);
    }

    /**
     * Retrieve AiVoices
     * <p>
     * Receive a generator of AiVoice objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * <p>
     * Return:
     * @return generator of AiVoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiVoice> query() throws Exception {
        return query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<AiVoice> voices;
        public String cursor;

        public Page(List<AiVoice> voices, String cursor) {
            this.voices = voices;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged AiVoices
     * <p>
     * Receive a list of up to 100 AiVoice objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your voices.
     * <p>
     * Parameters:
     * @param params map of parameters for the request
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. The API accepts integers between 1 and 100 and answers an error for any other value. ex: 35
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiVoice.Page object:
     * AiVoice.Page.voices: list of AiVoice objects with updated attributes
     * AiVoice.Page.cursor: cursor to retrieve the next page of AiVoice objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<AiVoice> voices = new ArrayList<>();
        for (SubResource item: page.entities) {
            voices.add((AiVoice) item);
        }
        return new Page(voices, page.cursor);
    }

    /**
     * Retrieve paged AiVoices
     * <p>
     * Receive a list of up to 100 AiVoice objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your voices.
     * <p>
     * Parameters:
     * @param params map of parameters for the request
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. The API accepts integers between 1 and 100 and answers an error for any other value. ex: 35
     * <p>
     * Return:
     * @return AiVoice.Page object:
     * AiVoice.Page.voices: list of AiVoice objects with updated attributes
     * AiVoice.Page.cursor: cursor to retrieve the next page of AiVoice objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged AiVoices
     * <p>
     * Receive a list of up to 100 AiVoice objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your voices.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiVoice.Page object:
     * AiVoice.Page.voices: list of AiVoice objects with updated attributes
     * AiVoice.Page.cursor: cursor to retrieve the next page of AiVoice objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged AiVoices
     * <p>
     * Receive a list of up to 100 AiVoice objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your voices.
     * <p>
     * Parameters:
     * <p>
     * Return:
     * @return AiVoice.Page object:
     * AiVoice.Page.voices: list of AiVoice objects with updated attributes
     * AiVoice.Page.cursor: cursor to retrieve the next page of AiVoice objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Delete AiVoices
     * <p>
     * Delete up to 100 AiVoices at once.
     * <p>
     * Parameters:
     * @param ids [list of strings]: ids of the AiVoices to be deleted. Up to 100 ids. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of deleted AiVoice objects
     * @throws Exception error in the request
     */
    public static List<AiVoice> delete(List<String> ids, User user) throws Exception {
        Map<String, Object> query = new HashMap<>();
        query.put("ids", ids);
        String content = Rest.deleteRaw(PATH, query, user).content();
        return ResponseHandler.post(content, AiVoice.class, Api.getLastNamePlural(data));
    }

    /**
     * Delete AiVoices
     * <p>
     * Delete up to 100 AiVoices at once.
     * <p>
     * Parameters:
     * @param ids [list of strings]: ids of the AiVoices to be deleted. Up to 100 ids. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return list of deleted AiVoice objects
     * @throws Exception error in the request
     */
    public static List<AiVoice> delete(List<String> ids) throws Exception {
        return delete(ids, null);
    }
}
