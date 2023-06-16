package com.starkinfra;


import com.google.gson.Gson;
import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Parse;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.SubResource;
import com.starkinfra.error.ErrorElement;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IssuingPurchase extends Resource {
    /**
     * IssuingPurchase object
     * <p>
     * Displays the IssuingPurchase objects created in your Workspace.
     * <p>
     * Parameters:
     * id [string]: unique id returned when IssuingPurchase is created. ex: "5656565656565656"
     * holderName [string]: card holder name. ex: "Tony Stark"
     * productId [string]: unique card product number (BIN) registered within the card network. ex: "53810200"
     * cardId [string]: unique id returned when IssuingPurchase is created. ex: "5656565656565656"
     * cardEnding [string]: last 4 digits of the card number. ex: "1234"
     * purpose [string]: purchase purpose. ex: "purchase"
     * amount [Long]: IssuingPurchase value in cents. Minimum = 0. ex: 1234 (= R$ 12.34)
     * tax [Long]: IOF amount taxed for international purchases. ex: 1234 (= R$ 12.34)
     * issuerAmount [Long]: issuer amount. ex: 1234 (= R$ 12.34)
     * issuerCurrencyCode [string]: issuer currency code. ex: "USD"
     * issuerCurrencySymbol [string]: issuer currency symbol. ex: "$"
     * merchantAmount [Long]: merchant amount. ex: 1234 (= R$ 12.34)
     * merchantCurrencyCode [string]: merchant currency code. ex: "USD"
     * merchantCurrencySymbol [string]: merchant currency symbol. ex: "$"
     * merchantCategoryCode [string]: merchant category code. ex: "fastFoodRestaurants"
     * merchantCountryCode [string]: merchant country code. ex: "USA"
     * acquirerId [string]: acquirer ID. ex: "5656565656565656"
     * merchantId [string]: merchant ID. ex: "5656565656565656"
     * merchantName [string]: merchant name. ex: "Google Cloud Platform"
     * metadata [Hashmap object]: Hashmap object used to store additional information about the IssuingPurchase object. ex: { authorizationId: 'OjZAqj' }
     * merchantFee [Long]: fee charged by the merchant to cover specific costs, such as ATM withdrawal logistics, etc. ex: 200 (= R$ 2.00)
     * walletId [string]: virtual wallet ID. ex: "5656565656565656"
     * methodCode [string]: method code. ex: "chip", "token", "server", "manual", "magstripe" or "contactless"
     * score [number]: internal score calculated for the authenticity of the purchase. Null in case of insufficient data. ex: 7.6
     * endToEndId [string]: unique id used to identify the transaction through all of its life cycle, even before the purchase is denied or accepted and gets its usual id. ex: endToEndId="679cd385-642b-49d0-96b7-89491e1249a5"
     * tags [list of strings]: list of strings for tagging returned by the sub-issuer during the authorization. ex: ["travel", "food"]
     * zipCode [string]: zip code of the merchant location. ex: "02101234"
     * <p>
     * Parameters (IssuingPurchase only):
     * issuingTransactionIds [list of strings]: list of ledger transaction ids linked to this Purchase
     * status [string]: current IssuingPurchase status. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * updated [string]: latest update datetime for the IssuingPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * <p>
     * Parameters (authorization request only):
     * isPartialAllowed [Boolean]: true if the merchant allows partial purchases. ex: False
     * cardTags [list of strings]: tags of the IssuingCard responsible for this purchase. ex: ["travel", "food"]
     * holderTags [list of strings]: tags of the IssuingHolder responsible for this purchase. ex: ["technology", "john snow"]
     *
     */
    static ClassData data = new ClassData(IssuingPurchase.class, "IssuingPurchase");

    public String holderName;
    public String productId;
    public String cardId;
    public String cardEnding;
    public String purpose;
    public Long amount;
    public Long tax;
    public Long issuerAmount;
    public String issuerCurrencyCode;
    public String issuerCurrencySymbol;
    public Long merchantAmount;
    public HashMap<String, Object> metadata;
    public String merchantCurrencyCode;
    public String merchantCurrencySymbol;
    public String merchantCategoryCode;
    public String merchantCountryCode;
    public String acquirerId;
    public String merchantId;
    public String merchantName;
    public Long merchantFee;
    public String walletId;
    public String methodCode;
    public Number score;
    public String endToEndId;
    public String[] tags;
    public String zipCode;
    public String[] issuingTransactionIds;
    public String status;
    public String updated;
    public String created;
    public Boolean isPartialAllowed;
    public String[] cardTags;
    public String[] holderTags;


    /**
     * IssuingPurchase object
     * <p>
     * Displays the IssuingPurchase objects created in your Workspace.
     * <p>
     * Parameters:
     * @param id [string]: unique id returned when IssuingPurchase is created. ex: "5656565656565656"
     * @param holderName [string]: card holder name. ex: "Tony Stark"
     * @param productId [string]: unique card product number (BIN) registered within the card network. ex: "53810200"
     * @param cardId [string]: unique id returned when IssuingPurchase is created. ex: "5656565656565656"
     * @param cardEnding [string]: last 4 digits of the card number. ex: "1234"
     * @param purpose [string]: purchase purpose. ex: "purchase"
     * @param amount [Long]: IssuingPurchase value in cents. Minimum = 0. ex: 1234 (= R$ 12.34)
     * @param tax [Long]: IOF amount taxed for international purchases. ex: 1234 (= R$ 12.34)
     * @param issuerAmount [Long]: issuer amount. ex: 1234 (= R$ 12.34)
     * @param issuerCurrencyCode [string]: issuer currency code. ex: "USD"
     * @param issuerCurrencySymbol [string]: issuer currency symbol. ex: "$"
     * @param merchantAmount [Long]: merchant amount. ex: 1234 (= R$ 12.34)
     * @param merchantCurrencyCode [string]: merchant currency code. ex: "USD"
     * @param merchantCurrencySymbol [string]: merchant currency symbol. ex: "$"
     * @param merchantCategoryCode [string]: merchant category code. ex: "fastFoodRestaurants"
     * @param merchantCountryCode [string]: merchant country code. ex: "USA"
     * @param acquirerId [string]: acquirer ID. ex: "5656565656565656"
     * @param merchantId [string]: merchant ID. ex: "5656565656565656"
     * @param merchantName [string]: merchant name. ex: "Google Cloud Platform"
     * @param metadata [Hashmap object]: Hashmap object used to store additional information about the IssuingPurchase object. ex: { authorizationId: 'OjZAqj' }
     * @param merchantFee [Long]: fee charged by the merchant to cover specific costs, such as ATM withdrawal logistics, etc. ex: 200 (= R$ 2.00)
     * @param walletId [string]: virtual wallet ID. ex: "5656565656565656"
     * @param methodCode [string]: method code. ex: "chip", "token", "server", "manual", "magstripe" or "contactless"
     * @param score [number]: internal score calculated for the authenticity of the purchase. Null in case of insufficient data. ex: 7.6
     * @param endToEndId [string]: unique id used to identify the transaction through all of its life cycle, even before the purchase is denied or accepted and gets its usual id. ex: endToEndId="679cd385-642b-49d0-96b7-89491e1249a5"
     * @param tags [list of strings]: list of strings for tagging returned by the sub-issuer during the authorization. ex: ["travel", "food"]
     * @param zipCode [string]: zip code of the merchant location. ex: "02101234"
     * Parameters (IssuingPurchase only):
     * @param issuingTransactionIds [list of strings]: list of ledger transaction ids linked to this Purchase
     * @param status [string]: current IssuingPurchase status. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * @param updated [string]: latest update datetime for the IssuingPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the IssuingPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * Parameters (authorization request only):
     * @param isPartialAllowed [Boolean]: true if the merchant allows partial purchases. ex: False
     * @param cardTags [list of strings]: tags of the IssuingCard responsible for this purchase. ex: ["travel", "food"]
     * @param holderTags [list of strings]: tags of the IssuingHolder responsible for this purchase. ex: ["technology", "john snow"]
     */
    public IssuingPurchase(String id, String holderName, String productId, String cardId, String cardEnding, String purpose, Long amount,
                           Long tax, Long issuerAmount, String issuerCurrencyCode, String issuerCurrencySymbol,
                           Long merchantAmount, String merchantCurrencyCode, String merchantCurrencySymbol,
                           String merchantCategoryCode, String merchantCountryCode, String acquirerId, String merchantId,
                           String merchantName, HashMap<String, Object> metadata, Long merchantFee, String walletId, String methodCode, Number score,
                           String[] issuingTransactionIds, String endToEndId, String status, String[] tags, String zipCode,
                           String updated, String created, Boolean isPartialAllowed, String[] cardTags, String[] holderTags
    ) {
        super(id);
        this.holderName = holderName;
        this.productId = productId;
        this.cardId = cardId;
        this.cardEnding = cardEnding;
        this.purpose = purpose;
        this.amount = amount;
        this.tax = tax;
        this.issuerAmount = issuerAmount;
        this.issuerCurrencyCode = issuerCurrencyCode;
        this.issuerCurrencySymbol = issuerCurrencySymbol;
        this.merchantAmount = merchantAmount;
        this.merchantCurrencyCode = merchantCurrencyCode;
        this.merchantCurrencySymbol = merchantCurrencySymbol;
        this.merchantCategoryCode = merchantCategoryCode;
        this.merchantCountryCode = merchantCountryCode;
        this.acquirerId = acquirerId;
        this.merchantId = merchantId;
        this.merchantName = merchantName;
        this.metadata = metadata;
        this.merchantFee = merchantFee;
        this.walletId = walletId;
        this.methodCode = methodCode;
        this.score = score;
        this.endToEndId = endToEndId;
        this.tags = tags;
        this.zipCode = zipCode;
        this.issuingTransactionIds = issuingTransactionIds;
        this.status = status;
        this.updated = updated;
        this.created = created;
        this.isPartialAllowed = isPartialAllowed;
        this.cardTags = cardTags;
        this.holderTags = holderTags;
    }

    /**
     * IssuingPurchase object
     * <p>
     * Displays the IssuingPurchase objects created in your Workspace.
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when IssuingPurchase is created. ex: "5656565656565656"
     * holderName [string]: card holder name. ex: "Tony Stark"
     * productId [string]: unique card product number (BIN) registered within the card network. ex: "53810200"
     * cardId [string]: unique id returned when IssuingPurchase is created. ex: "5656565656565656"
     * cardEnding [string]: last 4 digits of the card number. ex: "1234"
     * purpose [string]: purchase purpose. ex: "purchase"
     * amount [Long]: IssuingPurchase value in cents. Minimum = 0. ex: 1234 (= R$ 12.34)
     * tax [Long]: IOF amount taxed for international purchases. ex: 1234 (= R$ 12.34)
     * issuerAmount [Long]: issuer amount. ex: 1234 (= R$ 12.34)
     * issuerCurrencyCode [string]: issuer currency code. ex: "USD"
     * issuerCurrencySymbol [string]: issuer currency symbol. ex: "$"
     * merchantAmount [Long]: merchant amount. ex: 1234 (= R$ 12.34)
     * merchantCurrencyCode [string]: merchant currency code. ex: "USD"
     * merchantCurrencySymbol [string]: merchant currency symbol. ex: "$"
     * merchantCategoryCode [string]: merchant category code. ex: "fastFoodRestaurants"
     * merchantCountryCode [string]: merchant country code. ex: "USA"
     * acquirerId [string]: acquirer ID. ex: "5656565656565656"
     * merchantId [string]: merchant ID. ex: "5656565656565656"
     * merchantName [string]: merchant name. ex: "Google Cloud Platform"
     * merchantFee [Long]: fee charged by the merchant to cover specific costs, such as ATM withdrawal logistics, etc. ex: 200 (= R$ 2.00)
     * walletId [string]: virtual wallet ID. ex: "5656565656565656"
     * methodCode [string]: method code. ex: "chip", "token", "server", "manual", "magstripe" or "contactless"
     * score [number]: internal score calculated for the authenticity of the purchase. Null in case of insufficient data. ex: 7.6
     * endToEndId [string]: unique id used to identify the transaction through all of its life cycle, even before the purchase is denied or accepted and gets its usual id. ex: endToEndId="679cd385-642b-49d0-96b7-89491e1249a5"
     * tags [list of strings]: list of strings for tagging returned by the sub-issuer during the authorization. ex: ["travel", "food"]
     * zipCode [string]: zip code of the merchant location. ex: "02101234"
     * Attributes (IssuingPurchase only):
     * issuingTransactionIds [list of strings]: list of ledger transaction ids linked to this Purchase
     * status [string]: current IssuingPurchase status. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * updated [string]: latest update datetime for the IssuingPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * Attributes (authorization request only):
     * isPartialAllowed [Boolean]: true if the merchant allows partial purchases. ex: False
     * cardTags [list of strings]: tags of the IssuingCard responsible for this purchase. ex: ["travel", "food"]
     * holderTags [list of strings]: tags of the IssuingHolder responsible for this purchase. ex: ["technology", "john snow"]
     * @throws Exception error in the request
     */
    public IssuingPurchase(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.holderName = null;
        this.productId = null;
        this.cardId = null;
        this.cardEnding = null;
        this.purpose = null;
        this.amount = null;
        this.tax = null;
        this.issuerAmount = null;
        this.issuerCurrencyCode = null;
        this.issuerCurrencySymbol = null;
        this.merchantAmount = null;
        this.merchantCurrencyCode = null;
        this.merchantCurrencySymbol = null;
        this.merchantCategoryCode = null;
        this.merchantCountryCode = null;
        this.acquirerId = null;
        this.merchantId = null;
        this.merchantName = null;
        this.metadata = null;
        this.merchantFee = null;
        this.walletId = null;
        this.methodCode = null;
        this.score = null;
        this.issuingTransactionIds = null;
        this.endToEndId = null;
        this.status = null;
        this.tags = null;
        this.zipCode = null;
        this.updated = null;
        this.created = null;
        this.isPartialAllowed = null;
        this.cardTags = null;
        this.holderTags = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific IssuingPurchase
     * <p>
     * Receive a single IssuingPurchase object previously created in the Stark Infra API by its id
     * <p>
     * Parameters (required):
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingPurchase object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingPurchase get(String id, User user) throws Exception{
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific IssuingPurchase
     * <p>
     * Receive a single IssuingPurchase object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingPurchase object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingPurchase get(String id) throws Exception{
        return Rest.getId(data, id, null);
    }

    /**
     * Retrieve IssuingPurchase
     * <p>
     * Receive a generator of IssuingPurchase objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * endToEndIds [list of strings, default []]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * holderIds [list of strings, default []]: card holder IDs. ex: ["5656565656565656", "4545454545454545"]
     * cardIds [list of strings, default []]: card  IDs. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default ""]: filter for status of retrieved objects. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * after [string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * ids [list of strings, default []]: purchase IDs
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingPurchase objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingPurchase> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IssuingPurchases
     * <p>
     * Receive a generator of IssuingPurchase objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * endToEndIds [list of strings, default []]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * holderIds [list of strings, default []]: card holder IDs. ex: ["5656565656565656", "4545454545454545"]
     * cardIds [list of strings, default []]: card  IDs. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default ""]: filter for status of retrieved objects. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * after [string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * ids [list of strings, default []]: purchase IDs
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return generator of IssuingPurchase objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingPurchase> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IssuingPurchases
     * <p>
     * Receive a generator of IssuingPurchase objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingPurchase objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingPurchase> query(User user) throws Exception{
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingPurchases
     * <p>
     * Receive a generator of IssuingPurchase objects previously created in the Stark Infra API
     * <p>
     * Return:
     * @return generator of IssuingPurchase objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingPurchase> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IssuingPurchase> issuingPurchases;
        public String cursor;

        public Page(List<IssuingPurchase> issuingPurchases, String cursor) {
            this.issuingPurchases = issuingPurchases;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingPurchases
     * <p>
     * Receive a list of up to 100 IssuingPurchase objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page purchases.
     * <p>
     * Return:
     * IssuingPurchase.Page.purchases: list of IssuingPurchase objects with updated attributes
     * IssuingPurchase.Page.cursor: cursor to retrieve the next page of IssuingPurchase objects
     * @throws Exception error in the request
     */
    public static IssuingPurchase.Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged IssuingPurchases
     * <p>
     * Receive a list of up to 100 IssuingPurchase objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page purchases.
     * * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * endToEndIds [list of strings, default []]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * holderIds [list of strings, default []]: card holder IDs. ex: ["5656565656565656", "4545454545454545"]
     * cardIds [list of strings, default []]: card  IDs. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default ""]: filter for status of retrieved objects. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * after [string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * ids [list of strings, default []]: purchase IDs
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * <p>
     * Return:
     * IssuingPurchase.Page.purchases: list of IssuingPurchase objects with updated attributes
     * IssuingPurchase.Page.cursor: cursor to retrieve the next page of IssuingPurchase objects
     * @throws Exception error in the request
     */
    public static IssuingPurchase.Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingPurchases
     * <p>
     * Receive a list of up to 100 IssuingPurchase objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page purchases.
     * <p>
     * Return:
     * IssuingPurchase.Page.purchases: list of IssuingPurchase objects with updated attributes
     * IssuingPurchase.Page.cursor: cursor to retrieve the next page of IssuingPurchase objects
     * @throws Exception error in the request
     */
    public static IssuingPurchase.Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingPurchases
     * <p>
     * Receive a list of up to 100 IssuingPurchase objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page purchases.
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * endToEndIds [list of strings, default []]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * holderIds [list of strings, default []]: card holder IDs. ex: ["5656565656565656", "4545454545454545"]
     * cardIds [list of strings, default []]: card  IDs. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default ""]: filter for status of retrieved objects. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * after [string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * ids [list of strings, default []]: purchase IDs
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * IssuingPurchase.Page.purchases: list of IssuingPurchase objects with updated attributes
     * IssuingPurchase.Page.cursor: cursor to retrieve the next page of IssuingPurchase objects
     * @throws Exception error in the request
     */
    public static IssuingPurchase.Page page(Map<String , Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingPurchase> issuingPurchases = new ArrayList<>();
        for (SubResource issuingPurchase: page.entities) {
            issuingPurchases.add((IssuingPurchase) issuingPurchase);
        }
        return new IssuingPurchase.Page(issuingPurchases, page.cursor);
    }

    /**
     * Create a single verified IssuingPurchase authorization request from a content string
     * <p>
     * Use this method to parse and verify the authenticity of the authorization request received at the informed endpoint.
     * Authorization requests are posted to your registered endpoint whenever IssuingPurchases are received.
     * They present IssuingPurchase data that must be analyzed and answered with approval or declination.
     * If the provided digital signature does not check out with the StarkInfra public key, a com.starkinfra.error.InvalidSignatureError will be raised.
     * If the authorization request is not answered within 2 seconds or is not answered with an HTTP status code 200 the IssuingPurchase will go through the pre-configured stand-in validation.
     * <p>
     * Parameters:
     * @param content [string]: response content from request received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.user was set before function call
     * <p>
     * Return:
     * @return Parsed IssuingPurchase object
     * @throws Exception error in the request
     */
    public static IssuingPurchase parse(String content, String signature, User user) throws Exception{
        return Parse.parseAndVerify(data, content, signature, user);
    }

    /**
     * Create a single verified IssuingPurchase authorization request from a content string
     * <p>
     * Use this method to parse and verify the authenticity of the authorization request received at the informed endpoint.
     * Authorization requests are posted to your registered endpoint whenever IssuingPurchases are received.
     * They present IssuingPurchase data that must be analyzed and answered with approval or declination.
     * If the provided digital signature does not check out with the StarkInfra public key, a com.starkinfra.error.InvalidSignatureError will be raised.
     * If the authorization request is not answered within 2 seconds or is not answered with an HTTP status code 200 the IssuingPurchase will go through the pre-configured stand-in validation.
     * <p>
     * Parameters:
     * @param content [string]: response content from request received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * <p>
     * Return:
     * @return Parsed IssuingPurchase object
     * @throws Exception error in the request
     */
    public static IssuingPurchase parse(String content, String signature) throws Exception{
        return Parse.parseAndVerify(data, content, signature, null);
    }

    /**
     * Helps you respond to a IssuingPurchase authorization request
     * <p>
     * Parameters:
     * @param params to be returned on a IssuingPurchase read.
     * status [string]: sub-issuer response to the authorization. ex: "approved" or "denied"
     * amount [integer, default 0]: amount in cents that was authorized. ex: 1234 (= R$ 12.34)
     * reason [string, default ""]: denial reason. ex: "other"
     * tags [list of strings, default []]: tags to filter retrieved object. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us on the IssuingPurchase request
     */
    public static String response(Map<String, Object> params){
        Gson gson = new Gson();
        return gson.toJson(params);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(IssuingPurchase.Log.class, "IssuingPurchaseLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public IssuingPurchase purchase;
        public String issuingTransactionId;

        /**
         * IssuingPurchase Log object
         * <p>
         * Every time an IssuingPurchase entity is modified, a corresponding IssuingPurchase Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param purchase [IssuingPurchase]: IssuingPurchase entity to which the log refers to.
         * @param issuingTransactionId [string]: transaction ID related to the IssuingPurchase.
         * @param errors [list of strings]: list of errors linked to the IssuingPurchase event.
         * @param type [string]: type of the IssuingPurchase event which triggered the log creation. ex: "approved" or "denied"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Log(String created, String type, List<ErrorElement> errors, IssuingPurchase purchase, String id, String issuingTransactionId) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.purchase = purchase;
            this.issuingTransactionId = issuingTransactionId;
        }

        /**
         * Retrieve a specific IssuingPurchase Log
         * <p>
         * Receive a single IssuingPurchase Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return IssuingPurchase Log object with updated attributes
         * @throws Exception error in the purchase
         */
        public static IssuingPurchase.Log get(String id) throws Exception {
            return IssuingPurchase.Log.get(id, null);
        }

        /**
         * Retrieve a specific IssuingPurchase Log
         * <p>
         * Receive a single IssuingPurchase Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingPurchase Log object with updated attributes
         * @throws Exception error in the purchase
         */
        public static IssuingPurchase.Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve IssuingPurchase Logs
         * <p>
         * Receive a generator of IssuingPurchase.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["approved", "denied"]
         * purchaseIds [list of strings, default null]: list of IssuingPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of IssuingPurchase Log objects with updated attributes
         * @throws Exception error in the purchase
         */
        public static Generator<IssuingPurchase.Log> query(Map<String, Object> params) throws Exception {
            return IssuingPurchase.Log.query(params, null);
        }

        /**
         * Retrieve IssuingPurchase Logs
         * <p>
         * Receive a generator of IssuingPurchase.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IssuingPurchase Log objects with updated attributes
         * @throws Exception error in the purchase
         */
        public static Generator<IssuingPurchase.Log> query(User user) throws Exception {
            return IssuingPurchase.Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve IssuingPurchase Logs
         * <p>
         * Receive a generator of IssuingPurchase.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of IssuingPurchase Log objects with updated attributes
         * @throws Exception error in the purchase
         */
        public static Generator<IssuingPurchase.Log> query() throws Exception {
            return IssuingPurchase.Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve IssuingPurchase Logs
         * <p>
         * Receive a generator of IssuingPurchase.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["approved", "denied"]
         * purchaseIds [list of strings, default null]: list of IssuingPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IssuingPurchase Log objects with updated attributes
         * @throws Exception error in the purchase
         */
        public static Generator<IssuingPurchase.Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<IssuingPurchase.Log> logs;
            public String cursor;

            public Page(List<IssuingPurchase.Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged IssuingPurchase.Logs
         * <p>
         * Receive a list of up to 100 IssuingPurchase.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your purchases.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["approved", "denied"]
         * puchaseIds [list of strings, default null]: list of IssuingPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return IssuingPurchase.Log.Page object:
         * IssuingPurchase.Log.Page.logs: list of IssuingPurchase.Log objects with updated attributes
         * IssuingPurchase.Log.Page.cursor: cursor to retrieve the next page of IssuingPurchase.Log objects
         * @throws Exception error in the purchase
         */
        public static IssuingPurchase.Log.Page page(Map<String, Object> params) throws Exception {
            return IssuingPurchase.Log.page(params, null);
        }

        /**
         * Retrieve paged IssuingPurchase.Logs
         * <p>
         * Receive a list of up to 100 IssuingPurchase.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your purchases.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingPurchase.Log.Page object:
         * IssuingPurchase.Log.Page.logs: list of IssuingPurchase.Log objects with updated attributes
         * IssuingPurchase.Log.Page.cursor: cursor to retrieve the next page of IssuingPurchase.Log objects
         * @throws Exception error in the purchase
         */
        public static IssuingPurchase.Log.Page page(User user) throws Exception {
            return IssuingPurchase.Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged IssuingPurchase.Logs
         * <p>
         * Receive a list of up to 100 IssuingPurchase.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your purchases.
         * <p>
         * Return:
         * @return IssuingPurchase.Log.Page object:
         * IssuingPurchase.Log.Page.logs: list of IssuingPurchase.Log objects with updated attributes
         * IssuingPurchase.Log.Page.cursor: cursor to retrieve the next page of IssuingPurchase.Log objects
         * @throws Exception error in the purchase
         */
        public static IssuingPurchase.Log.Page page() throws Exception {
            return IssuingPurchase.Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged IssuingPurchase.Logs
         * <p>
         * Receive a list of up to 100 IssuingPurchase.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your purchases.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * purchaseIds [list of strings, default null]: list of IssuingPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingPurchase.Log.Page object:
         * IssuingPurchase.Log.Page.logs: list of IssuingPurchase.Log objects with updated attributes
         * IssuingPurchase.Log.Page.cursor: cursor to retrieve the next page of IssuingPurchase.Log objects
         * @throws Exception error in the purchase
         */
        public static IssuingPurchase.Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
            List<IssuingPurchase.Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((IssuingPurchase.Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }
}
