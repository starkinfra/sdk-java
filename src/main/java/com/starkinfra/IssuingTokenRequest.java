package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.HashMap;

public class IssuingTokenRequest extends SubResource {
    /**
     * IssuingTokenRequest object
     * <p>
     * The IssuingTokenRequest object displays the necessary information to proceed with the card tokenization.
     * <p>
     * When you initialize a IssuingTokenRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * cardId [string]: card id to be tokenized. ex: "5734340247945216"
     * walletId [string]: desired wallet to be integrated. ex: "google"
     * methodCode [string]: method code. ex: "app" or "manual"
     * content [string]: token request content. ex: "eyJwdWJsaWNLZXlGaW5nZXJwcmludCI6ICJlNTNiZThjZTRhYWQxNWU2OWNmMjExOTA5Mjk4YzJkOTE0O..."
     * signature [string]: token request signature. ex: "eyJwdWJsaWNLZXlGaW5nZXJwcmludCI6ICJlNTNiZThjZTRhYWQxNWU2OWNmMjExOTA5Mjk4YzJkOTE0O..."
     * metadata [Hashmap object]: Hashmap object used to store additional information about the IssuingTokenRequest object.
     */
    static SubResource.ClassData data = new SubResource.ClassData(IssuingTokenRequest.class, "IssuingTokenRequest");

    public String cardId;
    public String walletId;
    public String methodCode;
    public String content;
    public String signature;
    public HashMap<String, Object> metadata;

    /**
     * IssuingTokenRequest object
     * <p>
     * The IssuingTokenRequest object displays the necessary information to proceed with the card tokenization.
     * <p>
     * When you initialize a IssuingTokenRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param cardId [string]: card id to be tokenized. ex: "5734340247945216"
     * @param walletId [string]: desired wallet to be integrated. ex: "google"
     * @param methodCode [string]: method code. ex: "app" or "manual"
     * @param content [string]: token request content. ex: "eyJwdWJsaWNLZXlGaW5nZXJwcmludCI6ICJlNTNiZThjZTRhYWQxNWU2OWNmMjExOTA5Mjk4YzJkOTE0O..."
     * @param signature [string]: token request signature. ex: "eyJwdWJsaWNLZXlGaW5nZXJwcmludCI6ICJlNTNiZThjZTRhYWQxNWU2OWNmMjExOTA5Mjk4YzJkOTE0O..."
     * @param metadata [Hashmap object]: Hashmap object used to store additional information about the IssuingTokenRequest object.
     */
    public IssuingTokenRequest(String cardId, String walletId, String methodCode, String content, String signature,
                               HashMap<String, Object> metadata
    ) {
        this.cardId = cardId;
        this.walletId = walletId;
        this.methodCode = methodCode;
        this.content = content;
        this.signature = signature;
        this.metadata = metadata;
    }

    /**
     * IssuingTokenRequest object
     * <p>
     * The IssuingTokenRequest object displays the necessary information to proceed with the card tokenization.
     * <p>
     * When you initialize a IssuingTokenRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the IssuingTokenRequest
     * cardId [string]: card id to be tokenized. ex: "5734340247945216"
     * walletId [string]: desired wallet to be integrated. ex: "google"
     * methodCode [string]: method code. ex: "app" or "manual"
     * <p>
     * Attributes (return-only):
     * content [string]: token request content. ex: "eyJwdWJsaWNLZXlGaW5nZXJwcmludCI6ICJlNTNiZThjZTRhYWQxNWU2OWNmMjExOTA5Mjk4YzJkOTE0O..."
     * signature [string]: token request signature. ex: "eyJwdWJsaWNLZXlGaW5nZXJwcmludCI6ICJlNTNiZThjZTRhYWQxNWU2OWNmMjExOTA5Mjk4YzJkOTE0O..."
     * metadata [Hashmap object]: Hashmap object used to store additional information about the IssuingTokenRequest object.
     * @throws Exception error in the request
     */
    public IssuingTokenRequest(Map<String, Object> data) throws Exception {
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.cardId = (String) dataCopy.remove("cardId");
        this.walletId = (String) dataCopy.remove("walletId");
        this.methodCode = (String) dataCopy.remove("methodCode");
        this.content = null;
        this.signature = null;
        this.metadata = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create an IssuingTokenRequest object
     * <p>
     * Send an IssuingTokenRequest object to Stark Infra API to create the payload to proceed with the card tokenization
     * <p>
     * Parameters (required):
     * @param request [IssuingTokenRequest object]: IssuingTokenRequest object to the API to generate the payload
     * <p>
     * Return:
     * @return IssuingTokenRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingTokenRequest create(IssuingTokenRequest request) throws Exception {
        return IssuingTokenRequest.create(request, null);
    }

    /**
     * Create an IssuingTokenRequest object
     * <p>
     * Send an IssuingTokenRequest object to Stark Infra API to create the payload to proceed with the card tokenization
     * <p>
     * Parameters:
     * @param request [IssuingTokenRequest object]: IssuingTokenRequest object to the API to generate the payload
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingTokenRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingTokenRequest create(IssuingTokenRequest request, User user) throws Exception {
        return Rest.postSingle(data, request, user);
    }
}
