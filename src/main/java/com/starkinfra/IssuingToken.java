package com.starkinfra;

import com.google.gson.Gson;
import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Parse;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;
import com.starkinfra.error.ErrorElement;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class IssuingToken extends Resource {
    /**
     * IssuingToken object
     * <p>
     * The IssuingToken object displays the information of the tokens created in your Workspace.
     * <p>
     * Parameters:
     * cardId [string]: card ID which the token is bounded to. ex: "5656565656565656"
     * walletId [string]: wallet provider which the token is bounded to. ex: "google"
     * walletName [string]: wallet name. ex: "GOOGLE"
     * merchantId [string]: merchant unique id. ex: "5656565656565656"
     * id [string]: unique id returned when IssuingToken is created. ex: "5656565656565656"
     * externalId [string]: a unique string among all your IssuingTokens, used to avoid resource duplication. ex: "DSHRMC00002626944b0e3b539d4d459281bdba90c2588791"
     * tags [list of strings]: list of strings for reference when searching for IssuingToken. ex: ["employees", "monthly"]
     * status [string]: current IssuingToken status. ex: "active", "blocked", "canceled", "frozen" or "pending"
     * created [string]: creation datetime for the IssuingToken. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the IssuingToken. ex: "2020-03-10 10:30:00.000000+00:00"
     * activationCode [string]: activation code received through the bank app or sms. ex: "481632"
     * methodCode [string]: provisioning method. Options: "app", "token", "manual", "server" or "browser"
     * deviceType [string]: device type used for tokenization. ex: "Phone"
     * deviceName [string]: device name used for tokenization. ex: "My phone"
     * deviceSerialNumber [string]: device serial number used for tokenization. ex: "2F6D63"
     * deviceOsName [string]: device operational system name used for tokenization. ex: "Android"
     * deviceOsVersion [string]: device operational system version used for tokenization. ex: "4.4.4"
     * deviceImei [string]: device imei used for tokenization. ex: "352099001761481"
     * walletInstanceId [string]: unique id referred to the wallet app in the current device. ex: "71583be4777eb89aaf0345eebeb82594f096615ed17862d0"
     *
     */
    static ClassData data = new ClassData(IssuingToken.class, "IssuingToken");

    public String cardId;
    public String walletId;
    public String walletName;
    public String merchantId;
    public String externalId;
    public String[] tags;
    public String url;
    public String status;
    public String created;
    public String updated;
    public String activationCode;
    public String methodCode;
    public String deviceType;
    public String deviceName;
    public String deviceSerialNumber;
    public String deviceOsName;
    public String deviceOsVersion;
    public String deviceImei;
    public String walletInstanceId;


    /**
     * IssuingToken object
     * <p>
     * The IssuingToken object displays the information of the tokens created in your Workspace.
     * <p>
     * Parameters:
     * @param cardId [string]: card ID which the token is bounded to. ex: "5656565656565656"
     * @param walletId [string]: wallet provider which the token is bounded to. ex: "google"
     * @param walletName [string]: wallet name. ex: "GOOGLE"
     * @param merchantId [string]: merchant unique id. ex: "5656565656565656"
     * @param id [string]: unique id returned when IssuingToken is created. ex: "5656565656565656"
     * @param externalId [string]: a unique string among all your IssuingTokens, used to avoid resource duplication. ex: "DSHRMC00002626944b0e3b539d4d459281bdba90c2588791"
     * @param tags [list of strings]: list of strings for reference when searching for IssuingToken. ex: ["employees", "monthly"]
     * @param status [string]: current IssuingToken status. ex: "active", "blocked", "canceled", "frozen" or "pending"
     * @param created [string]: creation datetime for the IssuingToken. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the IssuingToken. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param activationCode [string]: activation code received through the bank app or sms. ex: "481632"
     * @param methodCode [string]: provisioning method. Options: "app", "token", "manual", "server" or "browser"
     * @param deviceType [string]: device type used for tokenization. ex: "Phone"
     * @param deviceName [string]: device name used for tokenization. ex: "My phone"
     * @param deviceSerialNumber [string]: device serial number used for tokenization. ex: "2F6D63"
     * @param deviceOsName [string]: device operational system name used for tokenization. ex: "Android"
     * @param deviceOsVersion [string]: device operational system version used for tokenization. ex: "4.4.4"
     * @param deviceImei [string]: device imei used for tokenization. ex: "352099001761481"
     * @param walletInstanceId [string]: unique id referred to the wallet app in the current device. ex: "71583be4777eb89aaf0345eebeb82594f096615ed17862d0"
     *
     */
    public IssuingToken(String cardId, String walletId, String walletName, String merchantId, String id,
                        String externalId,  String [] tags, String status, String created, String updated,
                        String activationCode, String methodCode, String deviceType, String deviceName,
                        String deviceSerialNumber, String deviceOsName, String deviceOsVersion, String deviceImei,
                        String walletInstanceId

    ) {
        super(id);
        this.cardId = cardId;
        this.walletId = walletId;
        this.walletName = walletName;
        this.merchantId = merchantId;
        this.externalId = externalId;
        this.tags = tags;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.activationCode = activationCode;
        this.methodCode = methodCode;
        this.deviceType = deviceType;
        this.deviceName = deviceName;
        this.deviceSerialNumber = deviceSerialNumber;
        this.deviceOsName = deviceOsName;
        this.deviceOsVersion = deviceOsVersion;
        this.deviceImei = deviceImei;
        this.walletInstanceId = walletInstanceId;
    }

    /**
     * IssuingToken object
     * <p>
     * The IssuingToken object displays the information of the tokens created in your Workspace.
     * <p>
     * Attributes (return-only):
     * cardId [string]: card ID which the token is bounded to. ex: "5656565656565656"
     * walletId [string]: wallet provider which the token is bounded to. ex: "google"
     * walletName [string]: wallet name. ex: "GOOGLE"
     * merchantId [string]: merchant unique id. ex: "5656565656565656"
     * Attributes (IssuingToken only):
     * id [string]: unique id returned when IssuingToken is created. ex: "5656565656565656"
     * externalId [string]: a unique string among all your IssuingTokens, used to avoid resource duplication. ex: "DSHRMC00002626944b0e3b539d4d459281bdba90c2588791"
     * tags [list of strings]: list of strings for reference when searching for IssuingToken. ex: ["employees", "monthly"]
     * status [string]: current IssuingToken status. ex: "active", "blocked", "canceled", "frozen" or "pending"
     * created [string]: creation datetime for the IssuingToken. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the IssuingToken. ex: "2020-03-10 10:30:00.000000+00:00"
     * Attributes (authorization request only):
     * activationCode [string]: activation code received through the bank app or sms. ex: "481632"
     * methodCode [string]: provisioning method. Options: "app", "token", "manual", "server" or "browser"
     * deviceType [string]: device type used for tokenization. ex: "Phone"
     * deviceName [string]: device name used for tokenization. ex: "My phone"
     * deviceSerialNumber [string]: device serial number used for tokenization. ex: "2F6D63"
     * deviceOsName [string]: device operational system name used for tokenization. ex: "Android"
     * deviceOsVersion [string]: device operational system version used for tokenization. ex: "4.4.4"
     * deviceImei [string]: device imei used for tokenization. ex: "352099001761481"
     * walletInstanceId [string]: unique id referred to the wallet app in the current device. ex: "71583be4777eb89aaf0345eebeb82594f096615ed17862d0"
     * @throws Exception error in the request
     */
    public IssuingToken(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.cardId = null;
        this.walletId = null;
        this.walletName = null;
        this.merchantId = null;
        this.externalId = null;
        this.tags = null;
        this.status = null;
        this.created = null;
        this.updated = null;
        this.activationCode = null;
        this.methodCode = null;
        this.deviceType = null;
        this.deviceName = null;
        this.deviceSerialNumber = null;
        this.deviceOsName = null;
        this.deviceOsVersion = null;
        this.deviceImei = null;
        this.walletInstanceId = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific IssuingToken
     * <p>
     * Receive a single IssuingToken object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingToken object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingToken get(String id) throws Exception {
        return IssuingToken.get(id, null);
    }

    /**
     * Retrieve a specific IssuingToken
     * <p>
     * Receive a single IssuingToken object previously created in the Stark Infra API by passing its uuid
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingToken object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingToken get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve IssuingTokens
     * <p>
     * Receive a generator of IssuingToken objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * status [string, default null]: current IssuingToken status. ex: "active", "blocked", "canceled", "frozen" or "pending"
     * cardIds [list of strings, default null]: list of cardIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my_external_id1", "my_external_id2"]
     * <p>
     * Return:
     * @return generator of IssuingToken objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingToken> query(Map<String, Object> params) throws Exception {
        return IssuingToken.query(params, null);
    }

    /**
     * Retrieve IssuingTokens
     * <p>
     * Receive a generator of IssuingToken objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingToken objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingToken> query(User user) throws Exception {
        return IssuingToken.query(new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingTokens
     * <p>
     * Receive a generator of IssuingToken objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of IssuingToken objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingToken> query() throws Exception {
        return IssuingToken.query(new HashMap<>(), null);
    }

    /**
     * Retrieve IssuingTokens
     * <p>
     * Receive a generator of IssuingToken objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * status [string, default null]: current IssuingToken status. ex: "active", "blocked", "canceled", "frozen" or "pending"
     * cardIds [list of strings, default null]: list of cardIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my_external_id1", "my_external_id2"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingToken objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingToken> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<IssuingToken> tokens;
        public String cursor;

        public Page(List<IssuingToken> tokens, String cursor) {
            this.tokens = tokens;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingTokens
     * <p>
     * Receive a list of up to 100 IssuingToken objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * status [string, default null]: current IssuingToken status. ex: "active", "blocked", "canceled", "frozen" or "pending"
     * cardIds [list of strings, default null]: list of cardIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my_external_id1", "my_external_id2"]
     * <p>
     * Return:
     * @return IssuingToken.Page object:
     * IssuingToken.Page.tokens: list of IssuingToken objects with updated attributes
     * IssuingToken.Page.cursor: cursor to retrieve the next page of IssuingToken objects
     * @throws Exception error in the request
     */
    public static IssuingToken.Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingTokens
     * <p>
     * Receive a list of up to 100 IssuingToken objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingToken.Page object:
     * IssuingToken.Page.tokens: list of IssuingToken objects with updated attributes
     * IssuingToken.Page.cursor: cursor to retrieve the next page of IssuingToken objects
     * @throws Exception error in the request
     */
    public static IssuingToken.Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingTokens
     * <p>
     * Receive a list of up to 100 IssuingToken objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return IssuingToken.Page object:
     * IssuingToken.Page.tokens: list of IssuingToken objects with updated attributes
     * IssuingToken.Page.cursor: cursor to retrieve the next page of IssuingToken objects
     * @throws Exception error in the request
     */
    public static IssuingToken.Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged IssuingTokens
     * <p>
     * Receive a list of up to 100 IssuingToken objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * status [string, default null]: current IssuingToken status. ex: "active", "blocked", "canceled", "frozen" or "pending"
     * cardIds [list of strings, default null]: list of cardIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my_external_id1", "my_external_id2"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingToken.Page object:
     * IssuingToken.Page.tokens: list of IssuingToken objects with updated attributes
     * IssuingToken.Page.cursor: cursor to retrieve the next page of IssuingToken objects
     * @throws Exception error in the request
     */
    public static IssuingToken.Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingToken> tokens = new ArrayList<>();
        for (SubResource request: page.entities) {
            tokens.add((IssuingToken) request);
        }
        return new IssuingToken.Page(tokens, page.cursor);
    }

    /**
     * Update IssuingToken entity
     * <p>
     * Update the IssuingToken by passing id.
     * <p>
     * Parameters:
     * @param id [string]: IssuingToken id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingToken object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingToken update(String id) throws Exception {
        return IssuingToken.update(id, new HashMap<>(), null);
    }

    /**
     * Update IssuingToken entity
     * <p>
     * Update the IssuingToken by passing id.
     * <p>
     * Parameters:
     * @param id [string]: IssuingToken id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingToken object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingToken update(String id, User user) throws Exception {
        return IssuingToken.update(id, new HashMap<>(), user);
    }

    /**
     * Update IssuingToken entity
     * <p>
     * Update the IssuingToken by passing id.
     * <p>
     * Parameters:
     * @param id [string]: IssuingToken id. ex: "5656565656565656"
     * @param patchData map of patch parameters
     * status [string, default null]: current IssuingToken status. ex: "active", "blocked", "canceled", "frozen" or "pending"
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * <p>
     * Return:
     * @return IssuingToken object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingToken update(String id, Map<String, Object> patchData) throws Exception {
        return IssuingToken.update(id, patchData, null);
    }

    /**
     * Update IssuingToken entity
     * <p>
     * Update IssuingToken by passing id.
     * <p>
     * Parameters:
     * @param id [string]: PixChargeback id. ex: "5656565656565656"
     * @param patchData map of patch parameters
     * status [string, default null]: current IssuingToken status. ex: "active", "blocked", "canceled", "frozen" or "pending"
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingToken object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingToken update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    /**
     * Cancel a IssuingToken entity
     * <p>
     * Cancel a IssuingToken entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: IssuingToken unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return canceled IssuingToken object
     * @throws Exception error in the request
     */
    public static IssuingToken cancel(String id) throws Exception {
        return IssuingToken.cancel(id, null);
    }

    /**
     * Cancel a IssuingToken entity
     * <p>
     * Cancel a IssuingToken entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: IssuingToken unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled IssuingToken object
     * @throws Exception error in the request
     */
    public static IssuingToken cancel(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * Create a single verified IssuingToken request from a content string
     * <p>
     * Use this method to parse and verify the authenticity of the request received at the informed endpoint.
     * Token requests are posted to your registered endpoint whenever IssuingTokens are received.
     * If the provided digital signature does not check out with the StarkInfra public key, a stark.exception.InvalidSignatureException will be raised.
     * <p>
     * Parameters:
     * @param content [string]: response content from request received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * <p>
     * Return:
     * @return Parsed IssuingToken object
     * @throws Exception error in the request
     */
    public static IssuingToken parse(String content, String signature) throws Exception{
        return IssuingToken.parse(content, signature, null);
    }

    /**
     * Create a single verified IssuingToken request from a content string
     * <p>
     * Use this method to parse and verify the authenticity of the request received at the informed endpoint.
     * Token requests are posted to your registered endpoint whenever IssuingTokens are received.
     * If the provided digital signature does not check out with the StarkInfra public key, a stark.exception.InvalidSignatureException will be raised.
     * <p>
     * Parameters:
     * @param content [string]: response content from request received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.user was set before function call
     * <p>
     * Return:
     * @return Parsed IssuingToken object
     * @throws Exception error in the request
     */
    public static IssuingToken parse(String content, String signature, User user) throws Exception{
        return Parse.parseAndVerify(data, content, signature, user);
    }

    /**
     * Helps you respond IssuingToken authorization requests
     * <p>
     * When a new tokenization is triggered by your user, a POST request will be made to your registered URL to get your decision to complete the tokenization.
     * The POST request must be answered in the following format, within 2 seconds, and with an HTTP status code 200.
     * <p>
     * Parameters (required):
     * @param params to be returned on a IssuingToken read.
     * status [string]: sub-issuer response to the activation. ex: "approved" or "denied"
     * <p>
     * Parameters (conditionally required):
     * reason [string, default null]: denial reason. Options: "other", "bruteForce", "subIssuerError", "lostCard", "invalidCard", "invalidHolder", "expiredCard", "canceledCard", "blockedCard", "invalidExpiration", "invalidSecurityCode", "missingTokenAuthorizationUrl", "maxCardTriesExceeded", "maxWalletInstanceTriesExceeded"
     * activationMethods [list of dictionaries, default null]: list of dictionaries with "type":string and "value":string pairs
     * designId [string, default null]: design unique id. ex: "5656565656565656"
     * <p>
     * Parameters (optional):
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us
     */
    public static String responseAuthorization(Map<String, Object> params){
        Gson gson = new Gson();
        return gson.toJson(params);
    }

    /**
     * Helps you respond IssuingToken activation requests
     * <p>
     * When a new token activation is triggered by your user, a POST request will be made to your registered URL for you to confirm the activation code you informed to them. You may identify this request through the present activationCode in the payload.
     * The POST request must be answered in the following format, within 2 seconds, and with an HTTP status code 200.
     * <p>
     * Parameters (required):
     * @param params to be returned on a IssuingToken read.
     * status [string]: sub-issuer response to the activation. ex: "approved" or "denied"
     * <p>
     * Parameters (optional):
     * reason [string, default null]: denial reason. Options: "other", "bruteForce", "subIssuerError", "lostCard", "invalidCard", "invalidHolder", "expiredCard", "canceledCard", "blockedCard", "invalidExpiration", "invalidSecurityCode", "missingTokenAuthorizationUrl", "maxCardTriesExceeded", "maxWalletInstanceTriesExceeded"
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us
     */
    public static String responseActivation(Map<String, Object> params){
        Gson gson = new Gson();
        return gson.toJson(params);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(IssuingToken.Log.class, "IssuingTokenLog");

        public IssuingToken token;
        public List<ErrorElement> errors;
        public String created;
        public String type;

        /**
         * IssuingToken Log object
         * <p>
         * Every time an IssuingToken entity is modified, a corresponding IssuingToken Log
         * is generated for the entity. This log is never generated by the user.
         * <p>
         * Parameters (return-only):
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param token [IssuingToken]: IssuingToken entity to which the log refers to.
         * @param errors [list of strings]: list of errors linked to this IssuingToken event.
         * @param type [string]: type of the IssuingToken event which triggered the log creation. Options: "active", "blocked", "canceled", "frozen" or "pending"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Log(String id, IssuingToken token, List<ErrorElement> errors, String type, String created) {
            super(id);
            this.token = token;
            this.errors = errors;
            this.type = type;
            this.created = created;
        }

        /**
         * Retrieve a specific IssuingToken Log
         * <p>
         * Receive a single IssuingToken Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return IssuingToken Log object with updated attributes
         * @throws Exception error in the IssuingToken
         */
        public static IssuingToken.Log get(String id) throws Exception {
            return IssuingToken.Log.get(id, null);
        }

        /**
         * Retrieve a specific IssuingToken Log
         * <p>
         * Receive a single IssuingToken Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingToken Log object with updated attributes
         * @throws Exception error in the IssuingToken
         */
        public static IssuingToken.Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve IssuingToken Logs
         * <p>
         * Receive a generator of IssuingToken.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. Options: "active", "blocked", "canceled", "frozen", "pending"
         * tokenIds [list of strings, default null]: list of IssuingToken ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of IssuingToken Log objects with updated attributes
         * @throws Exception error in the IssuingToken
         */
        public static Generator<IssuingToken.Log> query(Map<String, Object> params) throws Exception {
            return IssuingToken.Log.query(params, null);
        }

        /**
         * Retrieve IssuingToken Logs
         * <p>
         * Receive a generator of IssuingToken.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IssuingToken Log objects with updated attributes
         * @throws Exception error in the IssuingToken
         */
        public static Generator<IssuingToken.Log> query(User user) throws Exception {
            return IssuingToken.Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve IssuingToken Logs
         * <p>
         * Receive a generator of IssuingToken.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of IssuingToken Log objects with updated attributes
         * @throws Exception error in the IssuingToken
         */
        public static Generator<IssuingToken.Log> query() throws Exception {
            return IssuingToken.Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve IssuingToken Logs
         * <p>
         * Receive a generator of IssuingToken.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. Options: "active", "blocked", "canceled", "frozen", "pending"
         * tokenIds [list of strings, default null]: list of IssuingToken ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IssuingToken Log objects with updated attributes
         * @throws Exception error in the IssuingToken
         */
        public static Generator<IssuingToken.Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<IssuingToken.Log> logs;
            public String cursor;

            public Page(List<IssuingToken.Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged IssuingToken.Logs
         * <p>
         * Receive a list of up to 100 IssuingToken.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your IssuingTokens.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. Options: "active", "blocked", "canceled", "frozen", "pending"
         * tokenIds [list of strings, default null]: list of IssuingToken ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return IssuingToken.Log.Page object:
         * IssuingToken.Log.Page.logs: list of IssuingToken.Log objects with updated attributes
         * IssuingToken.Log.Page.cursor: cursor to retrieve the next page of IssuingToken.Log objects
         * @throws Exception error in the IssuingToken
         */
        public static IssuingToken.Log.Page page(Map<String, Object> params) throws Exception {
            return IssuingToken.Log.page(params, null);
        }

        /**
         * Retrieve paged IssuingToken.Logs
         * <p>
         * Receive a list of up to 100 IssuingToken.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your IssuingTokens.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingToken.Log.Page object:
         * IssuingToken.Log.Page.logs: list of IssuingToken.Log objects with updated attributes
         * IssuingToken.Log.Page.cursor: cursor to retrieve the next page of IssuingToken.Log objects
         * @throws Exception error in the IssuingToken
         */
        public static IssuingToken.Log.Page page(User user) throws Exception {
            return IssuingToken.Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged IssuingToken.Logs
         * <p>
         * Receive a list of up to 100 IssuingToken.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your IssuingTokens.
         * <p>
         * Return:
         * @return IssuingToken.Log.Page object:
         * IssuingToken.Log.Page.logs: list of IssuingToken.Log objects with updated attributes
         * IssuingToken.Log.Page.cursor: cursor to retrieve the next page of IssuingToken.Log objects
         * @throws Exception error in the IssuingToken
         */
        public static IssuingToken.Log.Page page() throws Exception {
            return IssuingToken.Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged IssuingToken.Logs
         * <p>
         * Receive a list of up to 100 IssuingToken.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your IssuingTokens.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. Options: "active", "blocked", "canceled", "frozen", "pending"
         * tokenIds [list of strings, default null]: list of IssuingToken ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingToken.Log.Page object:
         * IssuingToken.Log.Page.logs: list of IssuingToken.Log objects with updated attributes
         * IssuingToken.Log.Page.cursor: cursor to retrieve the next page of IssuingToken.Log objects
         * @throws Exception error in the IssuingToken
         */
        public static IssuingToken.Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<IssuingToken.Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((IssuingToken.Log) log);
            }
            return new IssuingToken.Log.Page(logs, page.cursor);
        }
    }
}
