package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;

import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class AiTranscript extends Resource {
    /**
     * AiTranscript object
     * <p>
     * An AiTranscript is the text of a recording. The audio is transcribed when the transcript is created, so the
     * created object already comes back in "success" status with the text.
     * <p>
     * When you initialize an AiTranscript, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * audio [string]: base64-encoded recording to transcribe. It is never returned by the API.
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the AiTranscript is created. ex: "5656565656565656"
     * text [string]: what was said in the recording.
     * status [string]: current status of the transcript. Options: "processing", "success", "failed"
     * errors [list of strings]: reasons the transcription failed. Empty when it worked.
     * created [string]: creation datetime for the AiTranscript. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the AiTranscript. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public String audio;
    public String text;
    public String status;
    public String[] errors;
    public String created;
    public String updated;

    static ClassData data = new ClassData(AiTranscript.class, "AiTranscript");

    /**
     * AiTranscript object
     * <p>
     * An AiTranscript is the text of a recording. The audio is transcribed when the transcript is created, so the
     * created object already comes back in "success" status with the text.
     * <p>
     * When you initialize an AiTranscript, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param audio [string]: base64-encoded recording to transcribe. It is never returned by the API.
     * <p>
     * Attributes (return-only):
     * @param id [string]: unique id returned when the AiTranscript is created. ex: "5656565656565656"
     * @param text [string]: what was said in the recording.
     * @param status [string]: current status of the transcript. Options: "processing", "success", "failed"
     * @param errors [list of strings]: reasons the transcription failed. Empty when it worked.
     * @param created [string]: creation datetime for the AiTranscript. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the AiTranscript. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public AiTranscript(String audio, String id, String text, String status, String[] errors, String created,
                        String updated
    ) {
        super(id);
        this.audio = audio;
        this.text = text;
        this.status = status;
        this.errors = errors;
        this.created = created;
        this.updated = updated;
    }

    /**
     * AiTranscript object
     * <p>
     * An AiTranscript is the text of a recording. The audio is transcribed when the transcript is created, so the
     * created object already comes back in "success" status with the text.
     * <p>
     * When you initialize an AiTranscript, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param audio [string]: base64-encoded recording to transcribe. It is never returned by the API.
     */
    public AiTranscript(String audio) {
        this(audio, null, null, null, null, null, null);
    }

    /**
     * Create an AiTranscript
     * <p>
     * Send an AiTranscript object for creation at the Stark Infra API
     * <p>
     * Parameters:
     * @param transcript [AiTranscript object]: AiTranscript object to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiTranscript object with updated attributes
     * @throws Exception error in the request
     */
    public static AiTranscript create(AiTranscript transcript, User user) throws Exception {
        return Rest.postSingle(data, transcript, user);
    }

    /**
     * Create an AiTranscript
     * <p>
     * Send an AiTranscript object for creation at the Stark Infra API
     * <p>
     * Parameters:
     * @param transcript [AiTranscript object]: AiTranscript object to be created in the API
     * <p>
     * Return:
     * @return AiTranscript object with updated attributes
     * @throws Exception error in the request
     */
    public static AiTranscript create(AiTranscript transcript) throws Exception {
        return create(transcript, null);
    }

    /**
     * Retrieve AiTranscripts
     * <p>
     * Receive a generator of AiTranscript objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. The API answers up to 100 objects per request. ex: 35
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiTranscript objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiTranscript> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve AiTranscripts
     * <p>
     * Receive a generator of AiTranscript objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. The API answers up to 100 objects per request. ex: 35
     * <p>
     * Return:
     * @return generator of AiTranscript objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiTranscript> query(Map<String, Object> params) throws Exception {
        return query(params, null);
    }

    /**
     * Retrieve AiTranscripts
     * <p>
     * Receive a generator of AiTranscript objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiTranscript objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiTranscript> query(User user) throws Exception {
        return query(new HashMap<>(), user);
    }

    /**
     * Retrieve AiTranscripts
     * <p>
     * Receive a generator of AiTranscript objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * <p>
     * Return:
     * @return generator of AiTranscript objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiTranscript> query() throws Exception {
        return query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<AiTranscript> transcripts;
        public String cursor;

        public Page(List<AiTranscript> transcripts, String cursor) {
            this.transcripts = transcripts;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged AiTranscripts
     * <p>
     * Receive a list of up to 100 AiTranscript objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your transcripts.
     * <p>
     * Parameters:
     * @param params map of parameters for the request
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. The API accepts integers between 1 and 100 and answers an error for any other value. ex: 35
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiTranscript.Page object:
     * AiTranscript.Page.transcripts: list of AiTranscript objects with updated attributes
     * AiTranscript.Page.cursor: cursor to retrieve the next page of AiTranscript objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<AiTranscript> transcripts = new ArrayList<>();
        for (SubResource item: page.entities) {
            transcripts.add((AiTranscript) item);
        }
        return new Page(transcripts, page.cursor);
    }

    /**
     * Retrieve paged AiTranscripts
     * <p>
     * Receive a list of up to 100 AiTranscript objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your transcripts.
     * <p>
     * Parameters:
     * @param params map of parameters for the request
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. The API accepts integers between 1 and 100 and answers an error for any other value. ex: 35
     * <p>
     * Return:
     * @return AiTranscript.Page object:
     * AiTranscript.Page.transcripts: list of AiTranscript objects with updated attributes
     * AiTranscript.Page.cursor: cursor to retrieve the next page of AiTranscript objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged AiTranscripts
     * <p>
     * Receive a list of up to 100 AiTranscript objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your transcripts.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiTranscript.Page object:
     * AiTranscript.Page.transcripts: list of AiTranscript objects with updated attributes
     * AiTranscript.Page.cursor: cursor to retrieve the next page of AiTranscript objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged AiTranscripts
     * <p>
     * Receive a list of up to 100 AiTranscript objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your transcripts.
     * <p>
     * Parameters:
     * <p>
     * Return:
     * @return AiTranscript.Page object:
     * AiTranscript.Page.transcripts: list of AiTranscript objects with updated attributes
     * AiTranscript.Page.cursor: cursor to retrieve the next page of AiTranscript objects, null on the last page
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }
}
