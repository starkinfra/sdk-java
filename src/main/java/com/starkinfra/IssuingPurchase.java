package com.starkinfra;


import com.starkinfra.error.ErrorElement;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Rest;
import com.starkinfra.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class IssuingPurchase extends Resource {
    /**
     * IssuingPurchase object
     * <p>
     * Displays the IssuingPurchase objects created in your Workspace.
     * <p>
     * Attributes (return-only):
     * id                       [string]: unique id returned when IssuingPurchase is created. ex: "5656565656565656"
     * holderName               [string]: card holder name. ex: "Tony Stark"
     * cardId                   [string]: unique id returned when IssuingPurchase is created. ex: "5656565656565656"
     * cardEnding               [string]: last 4 digits of the card number. ex: "1234"
     * amount                   [integer]: IssuingPurchase value in cents. Minimum = 0. ex: 1234 (= R$ 12.34)
     * tax                      [integer]: IOF amount taxed for international purchases. ex: 1234 (= R$ 12.34)
     * issuerAmount             [integer]: issuer amount. ex: 1234 (= R$ 12.34)
     * issuerCurrencyCode       [string]: issuer currency code. ex: "USD"
     * issuerCurrencySymbol     [string]: issuer currency symbol. ex: "$"
     * merchantAmount           [integer]: merchant amount. ex: 1234 (= R$ 12.34)
     * merchantCurrencyCode     [string]: merchant currency code. ex: "USD"
     * merchantCurrencySymbol   [string]: merchant currency symbol. ex: "$"
     * merchantCategoryCode     [string]: merchant category code. ex: "fastFoodRestaurants"
     * merchantCountryCode      [string]: merchant country code. ex: "USA"
     * acquirerId               [string]: acquirer ID. ex: "5656565656565656"
     * merchantId               [string]: merchant ID. ex: "5656565656565656"
     * merchantName             [string]: merchant name. ex: "Google Cloud Platform"
     * walletId                 [string]: virtual wallet ID. ex: "5656565656565656"
     * methodCode               [string]: method code. ex: "chip", "token", "server", "manual", "magstripe" or "contactless"
     * score                    [float]: internal score calculated for the authenticity of the purchase. Null in case of insufficient data. ex: 7.6
     * issuingTransactionIds    [string]: ledger transaction ids linked to this Purchase
     * endToEndId               [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * status                   [string]: current IssuingPurchase status. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * tags                     [string]: list of strings for tagging returned by the sub-issuer during the authorization. ex: ["travel", "food"]
     * updated                  [string]: latest update datetime for the IssuingPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * created                  [string]: creation datetime for the IssuingPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(IssuingPurchase.class, "IssuingPurchase");

    public String holderName;
    public String cardId;
    public String cardEnding;
    public String amount;
    public String tax;
    public String issuerAmount;
    public String issuerCurrencyCode;
    public String issuerCurrencySymbol;
    public String merchantAmount;
    public String merchantCurrencyCode;
    public String merchantCurrencySymbol;
    public String merchantCategoryCode;
    public String merchantCountryCode;
    public String acquirerId;
    public String merchantId;
    public String merchantName;
    public String walletId;
    public String methodCode;
    public String score;
    public String issuingTransactionIds;
    public String endToEndId;
    public String status;
    public String[] tags;
    public String updated;
    public String created;


    /**
     * IssuingPurchase object
     * <p>
     * Displays the IssuingPurchase objects created in your Workspace.
     * <p>
     * Attributes (return-only):
     * @param id [string]: unique id returned when IssuingPurchase is created. ex: "5656565656565656"
     * @param holderName [string]: card holder name. ex: "Tony Stark"
     * @param cardId [string]: unique id returned when IssuingPurchase is created. ex: "5656565656565656"
     * @param cardEnding [string]: last 4 digits of the card number. ex: "1234"
     * @param amount [integer]: IssuingPurchase value in cents. Minimum = 0. ex: 1234 (= R$ 12.34)
     * @param tax [integer]: IOF amount taxed for international purchases. ex: 1234 (= R$ 12.34)
     * @param issuerAmount [integer]: issuer amount. ex: 1234 (= R$ 12.34)
     * @param issuerCurrencyCode [string]: issuer currency code. ex: "USD"
     * @param issuerCurrencySymbol [string]: issuer currency symbol. ex: "$"
     * @param merchantAmount [integer]: merchant amount. ex: 1234 (= R$ 12.34)
     * @param merchantCurrencyCode [string]: merchant currency code. ex: "USD"
     * @param merchantCurrencySymbol [string]: merchant currency symbol. ex: "$"
     * @param merchantCategoryCode [string]: merchant category code. ex: "fastFoodRestaurants"
     * @param merchantCountryCode [string]: merchant country code. ex: "USA"
     * @param acquirerId [string]: acquirer ID. ex: "5656565656565656"
     * @param merchantId [string]: merchant ID. ex: "5656565656565656"
     * @param merchantName [string]: merchant name. ex: "Google Cloud Platform"
     * @param walletId [string]: virtual wallet ID. ex: "5656565656565656"
     * @param methodCode [string]: method code. ex: "chip", "token", "server", "manual", "magstripe" or "contactless"
     * @param score [float]: internal score calculated for the authenticity of the purchase. Null in case of insufficient data. ex: 7.6
     * @param issuingTransactionIds [string]: ledger transaction ids linked to this Purchase
     * @param endToEndId [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * @param status [string]: current IssuingPurchase status. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * @param tags [string]: list of strings for tagging returned by the sub-issuer during the authorization. ex: ["travel", "food"]
     * @param updated [string]: latest update datetime for the IssuingPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the IssuingPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingPurchase(String id, String holderName, String cardId, String cardEnding, String amount, String tax, String issuerAmount, String issuerCurrencyCode, String issuerCurrencySymbol, String merchantAmount, String merchantCurrencyCode, String merchantCurrencySymbol, String merchantCategoryCode, String merchantCountryCode, String acquirerId, String merchantId, String merchantName, String walletId, String methodCode, String score, String issuingTransactionIds, String endToEndId, String status, String[] tags, String updated, String created){
        super(id);
        this.holderName = holderName;
        this.cardId = cardId;
        this.cardEnding = cardEnding;
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
        this.walletId = walletId;
        this.methodCode = methodCode;
        this.score = score;
        this.issuingTransactionIds = issuingTransactionIds;
        this.endToEndId = endToEndId;
        this.status = status;
        this.tags = tags;
        this.updated = updated;
        this.created = created;
    }

    /**
     * IssuingPurchase object
     * <p>
     * Displays the IssuingPurchase objects created in your Workspace.
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when IssuingPurchase is created. ex: "5656565656565656"
     * holderName [string]: card holder name. ex: "Tony Stark"
     * cardId [string]: unique id returned when IssuingPurchase is created. ex: "5656565656565656"
     * cardEnding [string]: last 4 digits of the card number. ex: "1234"
     * amount [integer]: IssuingPurchase value in cents. Minimum = 0. ex: 1234 (= R$ 12.34)
     * tax [integer]: IOF amount taxed for international purchases. ex: 1234 (= R$ 12.34)
     * issuerAmount [integer]: issuer amount. ex: 1234 (= R$ 12.34)
     * issuerCurrencyCode [string]: issuer currency code. ex: "USD"
     * issuerCurrencySymbol [string]: issuer currency symbol. ex: "$"
     * merchantAmount [integer]: merchant amount. ex: 1234 (= R$ 12.34)
     * merchantCurrencyCode [string]: merchant currency code. ex: "USD"
     * merchantCurrencySymbol [string]: merchant currency symbol. ex: "$"
     * merchantCategoryCode [string]: merchant category code. ex: "fastFoodRestaurants"
     * merchantCountryCode [string]: merchant country code. ex: "USA"
     * acquirerId [string]: acquirer ID. ex: "5656565656565656"
     * merchantId [string]: merchant ID. ex: "5656565656565656"
     * merchantName [string]: merchant name. ex: "Google Cloud Platform"
     * walletId [string]: virtual wallet ID. ex: "5656565656565656"
     * methodCode [string]: method code. ex: "chip", "token", "server", "manual", "magstripe" or "contactless"
     * score [float]: internal score calculated for the authenticity of the purchase. Null in case of insufficient data. ex: 7.6
     * issuingTransactionIds [string]: ledger transaction ids linked to this Purchase
     * endToEndId [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * status [string]: current IssuingPurchase status. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * tags [string]: list of strings for tagging returned by the sub-issuer during the authorization. ex: ["travel", "food"]
     * updated [string]: latest update datetime for the IssuingPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */

    public IssuingPurchase(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.holderName = null;
        this.cardId = null;
        this.cardEnding = null;
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
        this.walletId = null;
        this.methodCode = null;
        this.score = null;
        this.issuingTransactionIds = null;
        this.endToEndId = null;
        this.status = null;
        this.tags = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific IssuingPurchase
     * <p>
     * Receive a single IssuingPurchase object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.user was set before function call
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
     * Receive a single IssuingPurchase object previously created in the Stark Bank API by its id
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
     * Receive a generator of IssuingPurchases objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters
     * id [string]: object unique id. ex: "5656565656565656"
     * endToEndIds [list of strings, default []]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * holderIds [list of strings, default []]: card holder IDs. ex: ["5656565656565656", "4545454545454545"]
     * cardIds [list of strings, default []]: card  IDs. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default ""]: filter for status of retrieved objects. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * after [date string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [date string, default null] date filter for objects created only before specified date. ex: "2022-03-22"
     * ids [list of strings, default []]: purchase IDs
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.user was set before function call
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
     * Receive a generator of IssuingPurchases objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters
     * id [string]: object unique id. ex: "5656565656565656"
     * endToEndIds [list of strings, default []]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * holderIds [list of strings, default []]: card holder IDs. ex: ["5656565656565656", "4545454545454545"]
     * cardIds [list of strings, default []]: card  IDs. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default ""]: filter for status of retrieved objects. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * after [date string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [date string, default null] date filter for objects created only before specified date. ex: "2022-03-22"
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
     * Receive a generator of IssuingPurchases objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.user was set before function call
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
     * Receive a generator of IssuingPurchases objects previously created in the Stark Infra API
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
     * endToEndIds [list of strings, default []]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * holderIds [list of strings, default []]: card holder IDs. ex: ["5656565656565656", "4545454545454545"]
     * cardIds [list of strings, default []]: card  IDs. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default ""]: filter for status of retrieved objects. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * after [date string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [date string, default null] date filter for objects created only before specified date. ex: "2022-03-22"
     * ids [list of strings, default []]: purchase IDs
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * cursor [string, default ""]: cursor returned on the previous page function call
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
     * endToEndIds [list of strings, default []]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * holderIds [list of strings, default []]: card holder IDs. ex: ["5656565656565656", "4545454545454545"]
     * cardIds [list of strings, default []]: card  IDs. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default ""]: filter for status of retrieved objects. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * after [date string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [date string, default null] date filter for objects created only before specified date. ex: "2022-03-22"
     * ids [list of strings, default []]: purchase IDs
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * cursor [string, default ""]: cursor returned on the previous page function call
     * <p>
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.user was set before function call
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

    public final static class Log extends Resource {
        static ClassData data = new ClassData(IssuingPurchase.Log.class, "IssuingPurchaseLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public IssuingPurchase reversal;

        /**
         * IssuingPurchase Log object
         * <p>
         * Every time an IssuingPurchase entity is modified, a corresponding IssuingPurchase Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param reversal [IssuingPurchase]: IssuingPurchase entity to which the log refers to.
         * @param errors [list of strings]: list of errors linked to the IssuingPurchase event.
         * @param type [string]: type of the IssuingPurchase event which triggered the log creation. ex: ["approved", "denied"]
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Log(String created, String type, List<ErrorElement> errors, IssuingPurchase reversal, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.reversal = reversal;
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
         * @throws Exception error in the reversal
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
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return IssuingPurchase Log object with updated attributes
         * @throws Exception error in the reversal
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
         * @param params parameters of the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["approved", "denied"]
         * reversalIds [list of strings, default null]: list of IssuingPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of IssuingPurchase Log objects with updated attributes
         * @throws Exception error in the reversal
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
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return generator of IssuingPurchase Log objects with updated attributes
         * @throws Exception error in the reversal
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
         * @throws Exception error in the reversal
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
         * @param params parameters of the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["approved", "denied"]
         * reversalIds [list of strings, default null]: list of IssuingPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return generator of IssuingPurchase Log objects with updated attributes
         * @throws Exception error in the reversal
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
         * Use this function instead of query if you want to manually page your reversals.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["approved", "denied"]
         * reversalIds [list of strings, default null]: list of IssuingPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return IssuingPurchase.Log.Page object:
         * IssuingPurchase.Log.Page.logs: list of IssuingPurchase.Log objects with updated attributes
         * IssuingPurchase.Log.Page.cursor: cursor to retrieve the next page of IssuingPurchase.Log objects
         * @throws Exception error in the reversal
         */
        public static IssuingPurchase.Log.Page page(Map<String, Object> params) throws Exception {
            return IssuingPurchase.Log.page(params, null);
        }

        /**
         * Retrieve paged IssuingPurchase.Logs
         * <p>
         * Receive a list of up to 100 IssuingPurchase.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your reversals.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return IssuingPurchase.Log.Page object:
         * IssuingPurchase.Log.Page.logs: list of IssuingPurchase.Log objects with updated attributes
         * IssuingPurchase.Log.Page.cursor: cursor to retrieve the next page of IssuingPurchase.Log objects
         * @throws Exception error in the reversal
         */
        public static IssuingPurchase.Log.Page page(User user) throws Exception {
            return IssuingPurchase.Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged IssuingPurchase.Logs
         * <p>
         * Receive a list of up to 100 IssuingPurchase.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your reversals.
         * <p>
         * Return:
         * @return IssuingPurchase.Log.Page object:
         * IssuingPurchase.Log.Page.logs: list of IssuingPurchase.Log objects with updated attributes
         * IssuingPurchase.Log.Page.cursor: cursor to retrieve the next page of IssuingPurchase.Log objects
         * @throws Exception error in the reversal
         */
        public static IssuingPurchase.Log.Page page() throws Exception {
            return IssuingPurchase.Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged IssuingPurchase.Logs
         * <p>
         * Receive a list of up to 100 IssuingPurchase.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your reversals.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * reversalIds [list of strings, default null]: list of IssuingPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return IssuingPurchase.Log.Page object:
         * IssuingPurchase.Log.Page.logs: list of IssuingPurchase.Log objects with updated attributes
         * IssuingPurchase.Log.Page.cursor: cursor to retrieve the next page of IssuingPurchase.Log objects
         * @throws Exception error in the reversal
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
