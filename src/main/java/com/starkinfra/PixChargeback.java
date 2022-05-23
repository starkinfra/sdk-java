package com.starkinfra;

import com.starkinfra.error.ErrorElement;
import com.starkinfra.utils.SubResource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class PixChargeback extends Resource {
    /**
     * PixChargeback object
     * <p>
     * A Pix Chargeback can be created when fraud is detected on a transaction or a system malfunction
     * results in an erroneous transaction.
     * It notifies another participant of your request to reverse the payment they have received.
     * When you initialize a PixChargeback, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * amount                [number]: amount in cents to be reversed. ex: 11234 (= R$ 112.34)
     * referenceId           [string]: endToEndId or returnId of the transaction to be reversed. ex: "E20018183202201201450u34sDGd19lz"
     * reason                [string]: reason why the chargeback was requested. Options: "fraud", "flaw", "reversalChargeback"
     * description           [string, default null]: description for the PixChargeback.
     * analysis              [string, default null]: analysis that led to the result.
     * bacenId               [string, default null]: central bank's unique UUID that identifies the PixChargeback.
     * senderBankCode        [string, default null]: bankCode of the Pix participant that created the PixChargeback. ex: "20018183"
     * receiverBankCode      [string, default null]: bankCode of the Pix participant that received the PixChargeback. ex: "20018183"
     * rejectionReason       [string, default null]: reason for the rejection of the Pix Chargeback. Options: "noBalance", "accountClosed", "unableToReverse"
     * reversalReferenceId   [string, default null]: return id of the reversal transaction. ex: "D20018183202202030109X3OoBHG74wo".
     * id                    [string, default null]: unique id returned when the PixChargeback is created. ex: "5656565656565656"
     * result                [string, default null]: result after the analysis of the PixChargeback by the receiving party. Options: "rejected", "accepted", "partiallyAccepted"
     * status                [string, default null]: current PixChargeback status. Options: "created", "failed", "delivered", "closed", "canceled".
     * created               [string, default null]: creation datetime for the PixChargeback. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated               [string, default null]: latest update datetime for the PixChargeback. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(PixChargeback.class, "PixChargeback");

    public Number amount;
    public String referenceId;
    public String reason;
    public String description;
    public String analysis;
    public String bacenId;
    public String senderBankCode;
    public String receiverBankCode;
    public String rejectionReason;
    public String reversalReferenceId;
    public String result;
    public String status;
    public String created;
    public String updated;

    /**
     * PixChargeback object
     * <p>
     * A Pix Chargeback can be created when fraud is detected on a transaction or a system malfunction
     * results in an erroneous transaction.
     * It notifies another participant of your request to reverse the payment they have received.
     * When you initialize a PixChargeback, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param amount                [number]: amount in cents to be reversed. ex: 11234 (= R$ 112.34)
     * @param referenceId           [string]: endToEndId or returnId of the transaction to be reversed. ex: "E20018183202201201450u34sDGd19lz"
     * @param reason                [string]: reason why the chargeback was requested. Options: "fraud", "flaw", "reversalChargeback"
     * @param description           [string, default null]: description for the PixChargeback.
     * @param analysis              [string, default null]: analysis that led to the result.
     * @param bacenId               [string, default null]: central bank's unique UUID that identifies the PixChargeback.
     * @param senderBankCode        [string, default null]: bankCode of the Pix participant that created the PixChargeback. ex: "20018183"
     * @param receiverBankCode      [string, default null]: bankCode of the Pix participant that received the PixChargeback. ex: "20018183"
     * @param rejectionReason       [string, default null]: reason for the rejection of the Pix Chargeback. Options: "noBalance", "accountClosed", "unableToReverse"
     * @param reversalReferenceId   [string, default null]: return id of the reversal transaction. ex: "D20018183202202030109X3OoBHG74wo".
     * @param id                    [string, default null]: unique id returned when the PixChargeback is created. ex: "5656565656565656"
     * @param result                [string, default null]: result after the analysis of the PixChargeback by the receiving party. Options: "rejected", "accepted", "partiallyAccepted"
     * @param status                [string, default null]: current PixChargeback status. Options: "created", "failed", "delivered", "closed", "canceled".
     * @param created               [string, default null]: creation datetime for the PixChargeback. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated               [string, default null]: latest update datetime for the PixChargeback. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    public PixChargeback(Number amount, String referenceId, String reason, String description, String analysis,
                         String bacenId, String senderBankCode, String receiverBankCode, String rejectionReason,
                         String reversalReferenceId, String id, String result, String status, String created,
                         String updated) {
        super(id);
        this.amount = amount;
        this.referenceId = referenceId;
        this.reason = reason;
        this.description = description ;
        this.analysis = analysis;
        this.bacenId = bacenId;
        this.senderBankCode = senderBankCode;
        this.receiverBankCode = receiverBankCode;
        this.rejectionReason = rejectionReason;
        this.reversalReferenceId = reversalReferenceId;
        this.result = result;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    /**
     * PixChargeback object
     * <p>
     * A Pix Chargeback can be created when fraud is detected on a transaction or a system malfunction
     * results in an erroneous transaction.
     * It notifies another participant of your request to reverse the payment they have received.
     * When you initialize a PixChargeback, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * amount [number]: amount in cents to be reversed. ex: 11234 (= R$ 112.34)
     * referenceId [string]: endToEndId or returnId of the transaction to be reversed. ex: "E20018183202201201450u34sDGd19lz"
     * reason [string]: reason why the chargeback was requested. Options: "fraud", "flaw", "reversalChargeback"
     * <p>
     * Parameters (optional):
     * description [string, default null]: description for the PixChargeback.
     * <p>
     * Attributes (return-only):
     * analysis [string, default null]: analysis that led to the result.
     * bacenId [string, default null]: central bank's unique UUID that identifies the PixChargeback.
     * senderBankCode [string, default null]: bankCode of the Pix participant that created the PixChargeback. ex: "20018183"
     * receiverBankCode [string, default null]: bankCode of the Pix participant that received the PixChargeback. ex: "20018183"
     * rejectionReason [string, default null]: reason for the rejection of the Pix Chargeback. Options: "noBalance", "accountClosed", "unableToReverse"
     * reversalReferenceId [string, default null]: return id of the reversal transaction. ex: "D20018183202202030109X3OoBHG74wo".
     * id [string, default null]: unique id returned when the PixChargeback is created. ex: "5656565656565656"
     * result [string, default null]: result after the analysis of the PixChargeback by the receiving party. Options: "rejected", "accepted", "partiallyAccepted"
     * status [string, default null]: current PixChargeback status. Options: "created", "failed", "delivered", "closed", "canceled".
     * created [string, default null]: creation datetime for the PixChargeback. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string, default null]: latest update datetime for the PixChargeback. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public PixChargeback(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.amount = (Number) dataCopy.remove("amount");
        this.referenceId = (String) dataCopy.remove("referenceId");
        this.reason = (String) dataCopy.remove("reason");
        this.description = (String) dataCopy.remove("description");
        this.analysis = null;
        this.bacenId = null;
        this.senderBankCode = null;
        this.receiverBankCode = null;
        this.rejectionReason = null;
        this.reversalReferenceId = null;
        this.result = null;
        this.status = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific PixChargeback
     * <p>
     * Receive a single PixChargeback object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return PixChargeback object with updated attributes
     * @throws Exception error in the request
     */
    public static PixChargeback get(String id) throws Exception {
        return PixChargeback.get(id, null);
    }

    /**
     * Retrieve a specific PixChargeback
     * <p>
     * Receive a single PixChargeback object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixChargeback object with updated attributes
     * @throws Exception error in the request
     */
    public static PixChargeback get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve PixChargebacks
     * <p>
     * Receive a generator of PixChargeback objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "closed", "canceled"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of PixChargeback objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixChargeback> query(Map<String, Object> params) throws Exception {
        return PixChargeback.query(params, null);
    }

    /**
     * Retrieve PixChargebacks
     * <p>
     * Receive a generator of PixChargeback objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of PixChargeback objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixChargeback> query(User user) throws Exception {
        return PixChargeback.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PixChargebacks
     * <p>
     * Receive a generator of PixChargeback objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of PixChargeback objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixChargeback> query() throws Exception {
        return PixChargeback.query(new HashMap<>(), null);
    }

    /**
     * Retrieve PixChargebacks
     * <p>
     * Receive a generator of PixChargeback objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of properties for the creation of the PixChargeback
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "closed", "canceled"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of PixChargeback objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixChargeback> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<PixChargeback> chargebacks;
        public String cursor;

        public Page(List<PixChargeback> chargebacks, String cursor) {
            this.chargebacks = chargebacks;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged PixChargebacks
     * <p>
     * Receive a list of up to 100 PixChargeback objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your chargebacks.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "closed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return PixChargeback.Page object:
     * PixChargeback.Page.chargebacks: list of PixChargeback objects with updated attributes
     * PixChargeback.Page.cursor: cursor to retrieve the next page of PixChargeback objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged PixChargebacks
     * <p>
     * Receive a list of up to 100 PixChargeback objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your chargebacks.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixChargeback.Page object:
     * PixChargeback.Page.chargebacks: list of PixChargeback objects with updated attributes
     * PixChargeback.Page.cursor: cursor to retrieve the next page of PixChargeback objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PixChargebacks
     * <p>
     * Receive a list of up to 100 PixChargeback objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your chargebacks.
     * <p>
     * Return:
     * @return PixChargeback.Page object:
     * PixChargeback.Page.chargebacks: list of PixChargeback objects with updated attributes
     * PixChargeback.Page.cursor: cursor to retrieve the next page of PixChargeback objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PixChargebacks
     * <p>
     * Receive a list of up to 100 PixChargeback objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your chargebacks.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "closed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixChargeback.Page object:
     * PixChargeback.Page.chargebacks: list of PixChargeback objects with updated attributes
     * PixChargeback.Page.cursor: cursor to retrieve the next page of PixChargeback objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<PixChargeback> chargebacks = new ArrayList<>();
        for (SubResource chargeback: page.entities) {
            chargebacks.add((PixChargeback) chargeback);
        }
        return new Page(chargebacks, page.cursor);
    }

    /**
     * Create PixChargebacks
     * <p>
     * Send a PixChargeback object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param chargebacks [list of PixChargeback objects or HashMaps]: list of PixChargebacks to be created in the API
     * <p>
     * Return:
     * @return PixChargeback object with updated attributes
     * @throws Exception error in the request
     */
    public static List<PixChargeback> create(List<PixChargeback> chargebacks) throws Exception {
        return PixChargeback.create(chargebacks, null);
    }

    /**
     * Create PixChargebacks
     * <p>
     * Send a PixChargeback object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param chargebacks [list of PixChargeback objects or HashMaps]: list of PixChargebacks to be created in the API
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixChargeback object with updated attributes
     * @throws Exception error in the request
     */
    public static List<PixChargeback> create(List<PixChargeback> chargebacks, User user) throws Exception {
        List<PixChargeback> chargebackList = new ArrayList<>();
        for (Object chargeback : chargebacks) {
            if (chargeback instanceof Map) {
                chargebackList.add(new PixChargeback((Map<String, Object>) chargeback));
                continue;
            }
            if (chargeback instanceof PixChargeback) {
                chargebackList.add((PixChargeback) chargeback);
                continue;
            }
            throw new Exception("Unknown type \"" + chargeback.getClass() + "\", use PixChargeback or HashMap");
        }
        return Rest.post(data, chargebackList, user);
    }

    /**
     * Cancel a PixChargeback entity
     * <p>
     * Cancel a PixChargeback entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: PixChargeback unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return canceled PixChargeback object
     * @throws Exception error in the request
     */
    public static PixChargeback cancel(String id) throws Exception {
        return PixChargeback.cancel(id, null);
    }

    /**
     * Cancel a PixChargeback entity
     * <p>
     * Cancel a PixChargeback entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: PixChargeback unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return canceled PixChargeback object
     * @throws Exception error in the request
     */
    public static PixChargeback cancel(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * Update PixChargeback entity
     * <p>
     * Update the PixChargeback by passing id.
     * <p>
     * Parameters:
     * @param id [string]: PixChargeback id. ex: "5656565656565656"
     * @param result [string]: result after the analysis of the PixChargeback. Options: "rejected", "accepted", "partiallyAccepted".
     * <p>
     * Return:
     * @return PixChargeback object with updated attributes
     * @throws Exception error in the request
     */
    public static PixChargeback update(String id, String result) throws Exception {
        return PixChargeback.update(id, result, new HashMap<>(), null);
    }

    /**
     * Update PixChargeback entity
     * <p>
     * Update the PixChargeback by passing id.
     * <p>
     * Parameters:
     * @param id [string]: PixChargeback id. ex: "5656565656565656"
     * @param result [string]: result after the analysis of the PixChargeback. Options: "rejected", "accepted", "partiallyAccepted".
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixChargeback object with updated attributes
     * @throws Exception error in the request
     */
    public static PixChargeback update(String id, String result, User user) throws Exception {
        return PixChargeback.update(id, result, new HashMap<>(), user);
    }

    /**
     * Update PixChargeback entity
     * <p>
     * Update the PixChargeback by passing id.
     * <p>
     * Parameters:
     * @param id [string]: PixChargeback id. ex: "5656565656565656"
     * @param result [string]: result after the analysis of the PixChargeback. Options: "rejected", "accepted", "partiallyAccepted".
     * @param patchData map of patch parameters
     * rejectionReason [string, default null]: if the PixChargeback is rejected a reason is required. Options: "noBalance", "accountClosed", "unableToReverse",
     * reversalReferenceId [string, default null]: return_id of the chargeback transaction. ex: "D20018183202201201450u34sDGd19lz"
     * analysis [string, default null]: description of the analysis that led to the result.
     * <p>
     * Return:
     * @return PixChargeback object with updated attributes
     * @throws Exception error in the request
     */
    public static PixChargeback update(String id, String result, Map<String, Object> patchData) throws Exception {
        return PixChargeback.update(id, result, patchData, null);
    }

    /**
     * Update PixChargeback entity
     * <p>
     * Update PixChargeback by passing id.
     * <p>
     * Parameters:
     * @param id [string]: PixChargeback id. ex: "5656565656565656"
     * @param result [string]: result after the analysis of the PixChargeback. Options: "rejected", "accepted", "partiallyAccepted".
     * @param patchData map of patch parameters
     * rejectionReason [string, default null]: if the PixChargeback is rejected a reason is required. Options: "noBalance", "accountClosed", "unableToReverse",
     * reversalReferenceId [string, default null]: return_id of the chargeback transaction. ex: "D20018183202201201450u34sDGd19lz"
     * analysis [string, default null]: description of the analysis that led to the result.
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixChargeback object with updated attributes
     * @throws Exception error in the request
     */
    public static PixChargeback update(String id, String result, Map<String, Object> patchData, User user) throws Exception {
        patchData.put("result", result);
        return Rest.patch(data, id, patchData, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "PixChargebackLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public PixChargeback chargeback;

        /**
         * PixChargeback Log object
         * <p>
         * Every time a PixChargeback entity is modified, a corresponding PixChargeback Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param created [string]: creation datetime for the log. ex: "2020-03-29"
         * @param type [string]: type of the PixChargeback event which triggered the log creation. ex: "created"
         * @param errors [list of strings]: list of errors linked to this PixChargeback event
         * @param chargeback [PixChargeback]: PixChargeback entity to which the log refers to.
         */
        public Log(String created, String type, List<ErrorElement> errors, PixChargeback chargeback, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.chargeback = chargeback;
        }

        /**
         * Retrieve a specific PixChargeback Log
         * <p>
         * Receive a single PixChargeback Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return PixChargeback Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific PixChargeback Log
         * <p>
         * Receive a single PixChargeback Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return PixChargeback Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve PixChargeback Logs
         * <p>
         * Receive a generator of PixChargeback.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * chargebackIds [string, default null]: list of PixChargeback IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of PixChargeback Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve PixChargeback Logs
         * <p>
         * Receive a generator of PixChargeback.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return generator of PixChargeback Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve PixChargeback Logs
         * <p>
         * Receive a generator of PixChargeback.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of PixChargeback Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve PixChargeback Logs
         * <p>
         * Receive a generator of PixChargeback.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * chargebackIds [string, default null]: list of PixChargeback IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of PixChargeback Log objects with updated attributes
         * @throws Exception error in the request
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
         * Retrieve paged PixChargeback.Logs
         * <p>
         * Receive a list of up to 100 PixChargeback.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your chargebacks.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * chargebackIds [string, default null]: list of PixChargeback IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return PixChargeback.Log.Page object:
         * PixChargeback.Log.Page.logs: list of PixChargeback.Log objects with updated attributes
         * PixChargeback.Log.Page.cursor: cursor to retrieve the next page of PixChargeback.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged PixChargeback.Logs
         * <p>
         * Receive a list of up to 100 PixChargeback.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your chargebacks.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return PixChargeback.Log.Page object:
         * PixChargeback.Log.Page.logs: list of PixChargeback.Log objects with updated attributes
         * PixChargeback.Log.Page.cursor: cursor to retrieve the next page of PixChargeback.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged PixChargeback.Logs
         * <p>
         * Receive a list of up to 100 PixChargeback.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your chargebacks.
         * <p>
         * Return:
         * @return PixChargeback.Log.Page object:
         * PixChargeback.Log.Page.logs: list of PixChargeback.Log objects with updated attributes
         * PixChargeback.Log.Page.cursor: cursor to retrieve the next page of PixChargeback.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged PixChargeback.Logs
         * <p>
         * Receive a list of up to 100 PixChargeback.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your chargebacks.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * chargebackIds [string, default null]: list of PixChargeback IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return PixChargeback.Log.Page object:
         * PixChargeback.Log.Page.logs: list of PixChargeback.Log objects with updated attributes
         * PixChargeback.Log.Page.cursor: cursor to retrieve the next page of PixChargeback.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params, User user) throws Exception {
            com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
            List<Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }
}
