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


public final class PixReversal extends Resource {
    /**
     * PixReversal object
     * <p>
     * PixReversals are instant payments used to revert PixRequests. You can only
     * revert inbound PixRequests.
     * <p>
     * When you initialize a PixReversal, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * amount [Long]: amount in cents to be reversed from PixReversal. ex: 1234 (= R$ 12.34)
     * externalId [string]: url safe string that must be unique among all your PixReversals. Duplicated external IDs will cause failures. By default, this parameter will block any PixReversal that repeats amount and receiver information on the same date. ex: "my-internal-id-123456"
     * endToEndId [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * reason [string]: reason why the PixReversal is being reversed. Options are "bankError", "fraud", "chashierError", "customerreversal"
     * tags [list of strings, default null]: list of strings for reference when searching for PixReversals. ex: ["employees", "monthly"]
     * id [string]: unique id returned when the PixReversal is created. ex: "5656565656565656".
     * returnId [string]: central bank's unique reversal transaction ID. ex: "D20018183202202030109X3OoBHG74wo".
     * fee [integer]: fee charged by this PixReversal. ex: 200 (= R$ 2.00)
     * status [string]: current PixReversal status. ex: "registered" or "paid"
     * flow [string]: direction of money flow. ex: "in" or "out"
     * created [string]: creation datetime for the PixReversal. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixReversal. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(PixReversal.class, "PixReversal");

    public Long amount;
    public String externalId;
    public String endToEndId;
    public String reason;
    public String[] tags;
    public String returnId;
    public Number fee;
    public String status;
    public String flow;
    public String created;
    public String updated;

    /**
     * PixReversal object
     * <p>
     * PixReversals are instant payments used to revert PixRequests. You can only
     * revert inbound PixRequests.
     * <p>
     * When you initialize a PixReversal, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param amount [Long]: amount in cents to be reversed from PixReversal. ex: 1234 (= R$ 12.34)
     * @param externalId [string]: url safe string that must be unique among all your PixReversals. Duplicated external IDs will cause failures. By default, this parameter will block any PixReversal that repeats amount and receiver information on the same date. ex: "my-internal-id-123456"
     * @param endToEndId [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * @param reason [string]: reason why the PixReversal is being reversed. Options are "bankError", "fraud", "chashierError", "customerreversal"
     * @param tags [list of strings, default null]: list of strings for reference when searching for PixReversals. ex: ["employees", "monthly"]
     * @param id [string]: unique id returned when the PixReversal is created. ex: "5656565656565656".
     * @param returnId [string]: central bank's unique reversal transaction ID. ex: "D20018183202202030109X3OoBHG74wo".
     * @param fee [integer]: fee charged by this PixReversal. ex: 200 (= R$ 2.00)
     * @param status [string]: current PixReversal status. ex: "registered" or "paid"
     * @param flow [string]: direction of money flow. ex: "in" or "out"
     * @param created [string]: creation datetime for the PixReversal. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the PixReversal. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public PixReversal(Long amount, String externalId, String endToEndId, String reason, String[] tags, String id,
                       String returnId, Number fee, String status, String flow, String created, String updated
    ) {
        super(id);
        this.amount = amount;
        this.externalId = externalId;
        this.endToEndId = endToEndId;
        this.reason = reason;
        this.tags = tags;
        this.returnId = returnId;
        this.fee = fee;
        this.status = status;
        this.flow = flow;
        this.created = created;
        this.updated = updated;
    }

    /**
     * PixReversal object
     * <p>
     * PixReversals are instant payments used to revert PixRequests. You can only
     * revert inbound PixRequests.
     * <p>
     * When you initialize a PixReversal, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the PixReversal
     * amount [Long]: amount in cents to be reversed from PixReversal. ex: 1234 (= R$ 12.34)
     * externalId [string]: url safe string that must be unique among all your PixReversals. Duplicated external IDs will cause failures. By default, this parameter will block any PixReversal that repeats amount and receiver information on the same date. ex: "my-internal-id-123456"
     * endToEndId [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * reason [string]: reason why the PixReversal is being reversed. Options are "bankError", "fraud", "chashierError", "customerreversal"
     * <p>
     * Parameters (optional):
     * tags [list of strings, default null]: list of strings for reference when searching for PixReversals. ex: ["employees", "monthly"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the PixReversal is created. ex: "5656565656565656".
     * returnId [string]: central bank's unique reversal transaction ID. ex: "D20018183202202030109X3OoBHG74wo".
     * fee [integer]: fee charged by this PixReversal. ex: 200 (= R$ 2.00)
     * status [string]: current PixReversal status. ex: "registered" or "paid"
     * flow [string]: direction of money flow. ex: "in" or "out"
     * created [string]: creation datetime for the PixReversal. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixReversal. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the reversal
     */
    public PixReversal(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.amount = ((Number) dataCopy.remove("amount")).longValue();
        this.externalId = (String) dataCopy.remove("externalId");
        this.endToEndId = (String) dataCopy.remove("endToEndId");
        this.reason = (String) dataCopy.remove("reason");
        this.tags = (String[]) dataCopy.remove("tags");
        this.returnId = null;
        this.fee = null;
        this.status = null;
        this.flow = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific PixReversal
     * <p>
     * Receive a single PixReversal object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return PixReversal object with updated attributes
     * @throws Exception error in the reversal
     */
    public static PixReversal get(String id) throws Exception {
        return PixReversal.get(id, null);
    }

    /**
     * Retrieve a specific PixReversal
     * <p>
     * Receive a single PixReversal object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixReversal object with updated attributes
     * @throws Exception error in the reversal
     */
    public static PixReversal get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve PixReversals
     * <p>
     * Receive a generator of PixReversal objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * returnIds [list of strings, default null]: central bank's unique transaction IDs. ex: ["E79457883202101262140HHX553UPqeq", "E79457883202101262140HHX553UPxzx"]
     * externalIds [list of strings, default null]: url safe strings that must be unique among all your PixReversals. Duplicated external IDs will cause failures. By default, this parameter will block any PixReversals that repeats amount and receiver information on the same date. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * <p>
     * Return:
     * @return generator of PixReversal objects with updated attributes
     * @throws Exception error in the reversal
     */
    public static Generator<PixReversal> query(Map<String, Object> params) throws Exception {
        return PixReversal.query(params, null);
    }

    /**
     * Retrieve PixReversals
     * <p>
     * Receive a generator of PixReversal objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixReversal objects with updated attributes
     * @throws Exception error in the reversal
     */
    public static Generator<PixReversal> query(User user) throws Exception {
        return PixReversal.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PixReversals
     * <p>
     * Receive a generator of PixReversal objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of PixReversal objects with updated attributes
     * @throws Exception error in the reversal
     */
    public static Generator<PixReversal> query() throws Exception {
        return PixReversal.query(new HashMap<>(), null);
    }

    /**
     * Retrieve PixReversals
     * <p>
     * Receive a generator of PixReversal objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * returnIds [list of strings, default null]: central bank's unique transaction IDs. ex: ["E79457883202101262140HHX553UPqeq", "E79457883202101262140HHX553UPxzx"]
     * externalIds [list of strings, default null]: url safe strings that must be unique among all your PixReversals. Duplicated external IDs will cause failures. By default, this parameter will block any PixReversals that repeats amount and receiver information on the same date. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixReversal objects with updated attributes
     * @throws Exception error in the reversal
     */
    public static Generator<PixReversal> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<PixReversal> reversals;
        public String cursor;

        public Page(List<PixReversal> reversals, String cursor) {
            this.reversals = reversals;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged PixReversals
     * <p>
     * Receive a list of up to 100 PixReversal objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your reversals.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * returnIds [list of strings, default null]: central bank's unique transaction IDs. ex: ["E79457883202101262140HHX553UPqeq", "E79457883202101262140HHX553UPxzx"]
     * externalIds [list of strings, default null]: url safe strings that must be unique among all your PixReversals. Duplicated external IDs will cause failures. By default, this parameter will block any PixReversals that repeats amount and receiver information on the same date. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * <p>
     * Return:
     * @return PixReversal.Page object:
     * PixReversal.Page.reversals: list of PixReversal objects with updated attributes
     * PixReversal.Page.cursor: cursor to retrieve the next page of PixReversal objects
     * @throws Exception error in the reversal
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged PixReversals
     * <p>
     * Receive a list of up to 100 PixReversal objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your reversals.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixReversal.Page object:
     * PixReversal.Page.reversals: list of PixReversal objects with updated attributes
     * PixReversal.Page.cursor: cursor to retrieve the next page of PixReversal objects
     * @throws Exception error in the reversal
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PixReversals
     * <p>
     * Receive a list of up to 100 PixReversal objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your reversals.
     * <p>
     * Return:
     * @return PixReversal.Page object:
     * PixReversal.Page.reversals: list of PixReversal objects with updated attributes
     * PixReversal.Page.cursor: cursor to retrieve the next page of PixReversal objects
     * @throws Exception error in the reversal
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PixReversals
     * <p>
     * Receive a list of up to 100 PixReversal objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your reversals.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * returnIds [list of strings, default null]: central bank's unique transaction IDs. ex: ["E79457883202101262140HHX553UPqeq", "E79457883202101262140HHX553UPxzx"]
     * externalIds [list of strings, default null]: url safe strings that must be unique among all your PixReversals. Duplicated external IDs will cause failures. By default, this parameter will block any PixReversals that repeats amount and receiver information on the same date. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixReversal.Page object:
     * PixReversal.Page.reversals: list of PixReversal objects with updated attributes
     * PixReversal.Page.cursor: cursor to retrieve the next page of PixReversal objects
     * @throws Exception error in the reversal
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<PixReversal> reversals = new ArrayList<>();
        for (SubResource reversal: page.entities) {
            reversals.add((PixReversal) reversal);
        }
        return new Page(reversals, page.cursor);
    }

    /**
     * Create PixReversals
     * <p>
     * Send a list of PixReversal objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param reversals [list of PixReversal objects or HashMaps]: list of PixReversal objects to be created in the API
     * <p>
     * Return:
     * @return list of PixReversal objects with updated attributes
     * @throws Exception error in the reversal
     */
    public static List<PixReversal> create(List<?> reversals) throws Exception {
        return PixReversal.create(reversals, null);
    }

    /**
     * Create PixReversals
     * <p>
     * Send a list of PixReversal objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param reversals [list of PixReversal objects or HashMaps]: list of PixReversal objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of PixReversal objects with updated attributes
     * @throws Exception error in the reversal
     */
    @SuppressWarnings("unchecked")
    public static List<PixReversal> create(List<?> reversals, User user) throws Exception {
        List<PixReversal> reversalList = new ArrayList<>();
        for (Object reversal : reversals){
            if (reversal instanceof Map){
                reversalList.add(new PixReversal((Map<String, Object>) reversal));
                continue;
            }
            if (reversal instanceof PixReversal){
                reversalList.add((PixReversal) reversal);
                continue;
            }
            throw new Exception("Unknown type \"" + reversal.getClass() + "\", use PixReversal or HashMap");
        }
        return Rest.post(data, reversalList, user);
    }

    /**
     * Create single verified PixReversal object from a content string
     * <p>
     * Create a single PixReversal object from a content string received from a handler listening at the request url.
     * If the provided digital signature does not check out with the Stark public key, a
     * starkinfra.error.InvalidSignatureError will be raised.
     * <p>
     * Parameters:
     * @param content [string]: response content from reversal received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * <p>
     * Return:
     * @return Parsed PixReversal object
     * @throws Exception error in the reversal
     */
    public static<T extends PixReversal> T parse(String content, String signature) throws Exception {
        T Resource = Parse.parseAndVerify(data, content, signature, Settings.user);

        Resource.fee = Resource.fee != null ? Resource.fee : 0;
        Resource.tags = Resource.tags != null ? Resource.tags : new String[]{};
        Resource.externalId = Resource.externalId != "" ? Resource.externalId : "";
        return Resource;
    }

    /**
     * Create single verified PixReversal object from a content string
     * <p>
     * Create a single PixReversal object from a content string received from a handler listening at the request url.
     * If the provided digital signature does not check out with the Stark public key, a
     * starkinfra.error.InvalidSignatureError will be raised.
     * <p>
     * Parameters:
     * @param content [string]: response content from request received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Parsed PixReversal object
     * @throws Exception error in the PixReversal
     */
    public static Event parse(String content, String signature, User user) throws Exception {
        return Parse.parseAndVerify(data ,content, signature, user);
    }

    /**
     * Helps you respond to a PixReversal authorization
     * <p>
     * Parameters:
     * @param params to be returned on a PixReversal read.
     * status [string]: response to the authorization. ex: "approved" or "denied"
     * reason [string, default None]: denial reason. Options: "invalidAccountNumber", "blockedAccount", "accountClosed", "invalidAccountType", "invalidTransactionType", "taxIdMismatch", "invalidTaxId", "orderRejected", "reversalTimeExpired", "settlementFailed"
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us
     */
    public static String response(Map<String, Object> params){
        Gson gson = new Gson();
        return gson.toJson(params);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "PixReversalLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public PixReversal reversal;

        /**
         * PixReversal Log object
         * <p>
         * Every time a PixReversal entity is modified, a corresponding PixReversal Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param reversal [PixReversal]: PixReversal entity to which the log refers to.
         * @param errors [list of strings]: list of errors linked to the PixReversal event.
         * @param type [string]: type of the PixReversal event which triggered the log creation. ex: "processing" or "success"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Log(String created, String type, List<ErrorElement> errors, PixReversal reversal, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.reversal = reversal;
        }

        /**
         * Retrieve a specific PixReversal Log
         * <p>
         * Receive a single PixReversal Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return PixReversal Log object with updated attributes
         * @throws Exception error in the reversal
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific PixReversal Log
         * <p>
         * Receive a single PixReversal Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixReversal Log object with updated attributes
         * @throws Exception error in the reversal
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve PixReversal Logs
         * <p>
         * Receive a generator of PixReversal.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * reversalIds [list of strings, default null]: list of PixReversal ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of PixReversal Log objects with updated attributes
         * @throws Exception error in the reversal
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve PixReversal Logs
         * <p>
         * Receive a generator of PixReversal.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of PixReversal Log objects with updated attributes
         * @throws Exception error in the reversal
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve PixReversal Logs
         * <p>
         * Receive a generator of PixReversal.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of PixReversal Log objects with updated attributes
         * @throws Exception error in the reversal
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve PixReversal Logs
         * <p>
         * Receive a generator of PixReversal.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * reversalIds [list of strings, default null]: list of PixReversal ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of PixReversal Log objects with updated attributes
         * @throws Exception error in the reversal
         */
        public static Generator<Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<Log> logs;
            public String cursor;

            public Page(List<Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged PixReversal.Logs
         * <p>
         * Receive a list of up to 100 PixReversal.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your reversals.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * reversalIds [list of strings, default null]: list of PixReversal ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return PixReversal.Log.Page object:
         * PixReversal.Log.Page.logs: list of PixReversal.Log objects with updated attributes
         * PixReversal.Log.Page.cursor: cursor to retrieve the next page of PixReversal.Log objects
         * @throws Exception error in the reversal
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged PixReversal.Logs
         * <p>
         * Receive a list of up to 100 PixReversal.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your reversals.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixReversal.Log.Page object:
         * PixReversal.Log.Page.logs: list of PixReversal.Log objects with updated attributes
         * PixReversal.Log.Page.cursor: cursor to retrieve the next page of PixReversal.Log objects
         * @throws Exception error in the reversal
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged PixReversal.Logs
         * <p>
         * Receive a list of up to 100 PixReversal.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your reversals.
         * <p>
         * Return:
         * @return PixReversal.Log.Page object:
         * PixReversal.Log.Page.logs: list of PixReversal.Log objects with updated attributes
         * PixReversal.Log.Page.cursor: cursor to retrieve the next page of PixReversal.Log objects
         * @throws Exception error in the reversal
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged PixReversal.Logs
         * <p>
         * Receive a list of up to 100 PixReversal.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your reversals.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * reversalIds [list of strings, default null]: list of PixReversal ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixReversal.Log.Page object:
         * PixReversal.Log.Page.logs: list of PixReversal.Log objects with updated attributes
         * PixReversal.Log.Page.cursor: cursor to retrieve the next page of PixReversal.Log objects
         * @throws Exception error in the reversal
         */
        public static Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
            List<Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Log.Page(logs, page.cursor);
        }
    }
}
