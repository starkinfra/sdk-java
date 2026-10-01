package com.starkinfra;

import com.starkinfra.utils.AiApi;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;

import java.util.Map;
import java.util.LinkedHashMap;


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

    private static final String PATH = "/ai-transcript";

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
     * Send an AiTranscript object for creation at the Stark Infra API. The audio is transcribed during the call.
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
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("audio", transcript.audio);
        return AiApi.createOne(PATH, "transcript", AiApi.dropNulls(payload), null, user, AiTranscript.class);
    }

    /**
     * Create an AiTranscript
     * <p>
     * Send an AiTranscript object for creation at the Stark Infra API. The audio is transcribed during the call.
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
     * Receive a generator of AiTranscript objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiTranscript objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiTranscript> query(User user) throws Exception {
        // this route is not paginated and takes no filters
        return AiApi.listAll(PATH, "transcripts", null, user, AiTranscript.class);
    }

    /**
     * Retrieve AiTranscripts
     * <p>
     * Receive a generator of AiTranscript objects previously created in the Stark Infra API
     * <p>
     * Return:
     * @return generator of AiTranscript objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiTranscript> query() throws Exception {
        return query(null);
    }
}
