package com.starkinfra;

import com.starkinfra.utils.Parse;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.HashMap;


public final class IssuingTokenActivation extends SubResource {
    /**
     * IssuingTokenActivation object
     * <p>
     * The IssuingTokenActivation object displays the necessary information to proceed with the card tokenization.
     * You will receive this object at your registered URL to notify you which method your user want to receive the activation code.
     * The POST request must be answered with no content, within 2 seconds, and with an HTTP status code 200.
     * After that, you may generate the activation code and send it to the cardholder.
     * <p>
     * Parameters:
     * cardId [string]: card ID which the token is bounded to. ex: "5656565656565656"
     * tokenId [string]: token unique id. ex: "5656565656565656"
     * tags [list of strings]: tags to filter retrieved object. ex: ["tony", "stark"]
     * activationMethod [Hashmap Object]: Hashmap object with "type":string and "value":string pairs
     */
    static SubResource.ClassData data = new SubResource.ClassData(IssuingTokenActivation.class, "IssuingTokenActivation");

    public String cardId;
    public String tokenId;
    public String[] tags;
    public HashMap<String, String> activationMethod;

    /**
     * IssuingTokenActivation object
     * <p>
     * The IssuingTokenActivation object displays the necessary information to proceed with the card tokenization.
     * You will receive this object at your registered URL to notify you which method your user want to receive the activation code.
     * The POST request must be answered with no content, within 2 seconds, and with an HTTP status code 200.
     * After that, you may generate the activation code and send it to the cardholder.
     * <p>
     * Attributes (return-only):
     * cardId [string]: card ID which the token is bounded to. ex: "5656565656565656"
     * tokenId [string]: token unique id. ex: "5656565656565656"
     * tags [list of strings]: tags to filter retrieved object. ex: ["tony", "stark"]
     * activationMethod [Hashmap Object]: Hashmap object with "type":string and "value":string pairs
     * @throws Exception error in the request
     */
    public IssuingTokenActivation(Map<String, Object> data) throws Exception {
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.cardId = null;
        this.tokenId = null;
        this.tags = null;
        this.activationMethod = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * IssuingTokenActivation object
     * <p>
     * The IssuingTokenActivation object displays the necessary information to proceed with the card tokenization.
     * You will receive this object at your registered URL to notify you which method your user want to receive the activation code.
     * The POST request must be answered with no content, within 2 seconds, and with an HTTP status code 200.
     * After that, you may generate the activation code and send it to the cardholder.
     * <p>
     * Parameters:
     * @param cardId [string]: card ID which the token is bounded to. ex: "5656565656565656"
     * @param tokenId [string]: token unique id. ex: "5656565656565656"
     * @param tags [list of strings]: tags to filter retrieved object. ex: ["tony", "stark"]
     * @param activationMethod [Hashmap Object]: Hashmap object with "type":string and "value":string pairs
     */
    public IssuingTokenActivation(String cardId, String tokenId, String[] tags,
                                  HashMap<String, String> activationMethod
    ) {
        this.cardId = cardId;
        this.tokenId = tokenId;
        this.tags = tags;
        this.activationMethod = activationMethod;
    }


    /**
     * Create a single verified IssuingTokenActivation request from a content string
     * <p>
     * Use this method to parse and verify the authenticity of the request received at the informed endpoint.
     * Activation requests are posted to your registered endpoint whenever IssuingTokenActivations are received.
     * If the provided digital signature does not check out with the StarkInfra public key, a stark.exception.InvalidSignatureException will be raised.
     * <p>
     * Parameters (required):
     * @param content [string]: response content from request received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * <p>
     * Return:
     * @return Parsed IssuingTokenActivation object
     * @throws Exception error in the request
     */
    public static IssuingTokenActivation parse(String content, String signature) throws Exception {
        return IssuingTokenActivation.parse(content, signature, null);
    }

    /**
     * Create a single verified IssuingTokenActivation request from a content string
     * <p>
     * Use this method to parse and verify the authenticity of the request received at the informed endpoint.
     * Activation requests are posted to your registered endpoint whenever IssuingTokenActivations are received.
     * If the provided digital signature does not check out with the StarkInfra public key, a stark.exception.InvalidSignatureException will be raised.
     * <p>
     * Parameters (required):
     * @param content [string]: response content from request received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * <p>
     * Parameters (optional)
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.user was set before function call
     * Return:
     * @return Parsed IssuingTokenActivation object
     * @throws Exception error in the request
     */
    public static IssuingTokenActivation parse(String content, String signature, User user) throws Exception {
        return Parse.parseAndVerify(data, content, signature, user);
    }

}
