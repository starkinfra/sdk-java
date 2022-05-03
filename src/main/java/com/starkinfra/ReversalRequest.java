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


public final class ReversalRequest extends Resource {
    /**
     * ReversalRequest object
     * <p>
     * A reversal request can be created when fraud is detected on a transaction or a system malfunction
     * results in an erroneous transaction.
     * It notifies another participant of your request to reverse the payment they have received.
     * When you initialize a ReversalRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * amount                [number]: amount in cents to be reversed. ex: 11234 (= R$ 112.34)
     * referenceId           [string]: endToEndId or returnId of the transaction to be reversed. ex: "E20018183202201201450u34sDGd19lz"
     * reason                [string]: reason why the reversal was requested. Options: "fraud", "flaw", "reversalChargeback"
     * description           [string, default null]: description for the ReversalRequest.
     * analysis              [string, Default null]: analysis that led to the result.
     * bacenId               [string, Default null]: central bank's unique UUID that identifies the ReversalRequest.
     * senderBankCode        [string, Default null]: bankCode of the Pix participant that created the ReversalRequest. ex: "20018183"
     * receiverBankCode      [string, Default null]: bankCode of the Pix participant that received the ReversalRequest. ex: "20018183"
     * rejectionReason       [string, Default null]: reason for the rejection of the reversal request. Options: "noBalance", "accountClosed", "unableToReverse"
     * reversalReferenceId   [string, Default null]: return id of the reversal transaction. ex: "D20018183202202030109X3OoBHG74wo".
     * id                    [string, default null]: unique id returned when the ReversalRequest is created. ex: "5656565656565656"
     * result                [string, Default null]: result after the analysis of the ReversalRequest by the receiving party. Options: "rejected", "accepted", "partiallyAccepted"
     * status                [string, default null]: current ReversalRequest status. Options: "created", "failed", "delivered", "closed", "canceled".
     * created               [string, default null]: creation datetime for the ReversalRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated               [string, default null]: latest update datetime for the ReversalRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(ReversalRequest.class, "ReversalRequest");

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
     * ReversalRequest object
     * <p>
     * A reversal request can be created when fraud is detected on a transaction or a system malfunction
     * results in an erroneous transaction.
     * It notifies another participant of your request to reverse the payment they have received.
     * When you initialize a ReversalRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param amount                [number]: amount in cents to be reversed. ex: 11234 (= R$ 112.34)
     * @param referenceId           [string]: endToEndId or returnId of the transaction to be reversed. ex: "E20018183202201201450u34sDGd19lz"
     * @param reason                [string]: reason why the reversal was requested. Options: "fraud", "flaw", "reversalChargeback"
     * @param description           [string, default null]: description for the ReversalRequest.
     * @param analysis              [string, Default null]: analysis that led to the result.
     * @param bacenId               [string, Default null]: central bank's unique UUID that identifies the ReversalRequest.
     * @param senderBankCode        [string, Default null]: bankCode of the Pix participant that created the ReversalRequest. ex: "20018183"
     * @param receiverBankCode      [string, Default null]: bankCode of the Pix participant that received the ReversalRequest. ex: "20018183"
     * @param rejectionReason       [string, Default null]: reason for the rejection of the reversal request. Options: "noBalance", "accountClosed", "unableToReverse"
     * @param reversalReferenceId   [string, Default null]: return id of the reversal transaction. ex: "D20018183202202030109X3OoBHG74wo".
     * @param id                    [string, default null]: unique id returned when the ReversalRequest is created. ex: "5656565656565656"
     * @param result                [string, Default null]: result after the analysis of the ReversalRequest by the receiving party. Options: "rejected", "accepted", "partiallyAccepted"
     * @param status                [string, default null]: current ReversalRequest status. Options: "created", "failed", "delivered", "closed", "canceled".
     * @param created               [string, default null]: creation datetime for the ReversalRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated               [string, default null]: latest update datetime for the ReversalRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    public ReversalRequest(Number amount, String referenceId, String reason, String description, String analysis,
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
     * ReversalRequest object
     * <p>
     * A reversal request can be created when fraud is detected on a transaction or a system malfunction
     * results in an erroneous transaction.
     * It notifies another participant of your request to reverse the payment they have received.
     * When you initialize a ReversalRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * amount [number]: amount in cents to be reversed. ex: 11234 (= R$ 112.34)
     * referenceId [string]: endToEndId or returnId of the transaction to be reversed. ex: "E20018183202201201450u34sDGd19lz"
     * reason [string]: reason why the reversal was requested. Options: "fraud", "flaw", "reversalChargeback"
     * <p>
     * Parameters (optional):
     * description [string, default null]: description for the ReversalRequest.
     * <p>
     * Attributes (return-only):
     * analysis [string, Default null]: analysis that led to the result.
     * bacenId [string, Default null]: central bank's unique UUID that identifies the ReversalRequest.
     * senderBankCode [string, Default null]: bankCode of the Pix participant that created the ReversalRequest. ex: "20018183"
     * receiverBankCode [string, Default null]: bankCode of the Pix participant that received the ReversalRequest. ex: "20018183"
     * rejectionReason [string, Default null]: reason for the rejection of the reversal request. Options: "noBalance", "accountClosed", "unableToReverse"
     * reversalReferenceId [string, Default null]: return id of the reversal transaction. ex: "D20018183202202030109X3OoBHG74wo".
     * id [string, default null]: unique id returned when the ReversalRequest is created. ex: "5656565656565656"
     * result [string, Default null]: result after the analysis of the ReversalRequest by the receiving party. Options: "rejected", "accepted", "partiallyAccepted"
     * status [string, default null]: current ReversalRequest status. Options: "created", "failed", "delivered", "closed", "canceled".
     * created [string, default null]: creation datetime for the ReversalRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string, default null]: latest update datetime for the ReversalRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public ReversalRequest(Map<String, Object> data) throws Exception {
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
     * Retrieve a specific ReversalRequest
     * <p>
     * Receive a single ReversalRequest object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return ReversalRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static ReversalRequest get(String id) throws Exception {
        return ReversalRequest.get(id, null);
    }

    /**
     * Retrieve a specific ReversalRequest
     * <p>
     * Receive a single ReversalRequest object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return ReversalRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static ReversalRequest get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve ReversalRequests
     * <p>
     * Receive a generator of ReversalRequest objects previously created in the Stark Infra API.
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
     * @return generator of ReversalRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<ReversalRequest> query(Map<String, Object> params) throws Exception {
        return ReversalRequest.query(params, null);
    }

    /**
     * Retrieve ReversalRequests
     * <p>
     * Receive a generator of ReversalRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of ReversalRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<ReversalRequest> query(User user) throws Exception {
        return ReversalRequest.query(new HashMap<>(), user);
    }

    /**
     * Retrieve ReversalRequests
     * <p>
     * Receive a generator of ReversalRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of ReversalRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<ReversalRequest> query() throws Exception {
        return ReversalRequest.query(new HashMap<>(), null);
    }

    /**
     * Retrieve ReversalRequests
     * <p>
     * Receive a generator of ReversalRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of properties for the creation of the ReversalRequest
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "closed", "canceled"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of ReversalRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<ReversalRequest> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<ReversalRequest> requests;
        public String cursor;

        public Page(List<ReversalRequest> requests, String cursor) {
            this.requests = requests;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged ReversalRequests
     * <p>
     * Receive a list of up to 100 ReversalRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
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
     * @return ReversalRequest.Page object:
     * ReversalRequest.Page.requests: list of ReversalRequest objects with updated attributes
     * ReversalRequest.Page.cursor: cursor to retrieve the next page of ReversalRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged ReversalRequests
     * <p>
     * Receive a list of up to 100 ReversalRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return ReversalRequest.Page object:
     * ReversalRequest.Page.requests: list of ReversalRequest objects with updated attributes
     * ReversalRequest.Page.cursor: cursor to retrieve the next page of ReversalRequest objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged ReversalRequests
     * <p>
     * Receive a list of up to 100 ReversalRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return ReversalRequest.Page object:
     * ReversalRequest.Page.requests: list of ReversalRequest objects with updated attributes
     * ReversalRequest.Page.cursor: cursor to retrieve the next page of ReversalRequest objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged ReversalRequests
     * <p>
     * Receive a list of up to 100 ReversalRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
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
     * @return ReversalRequest.Page object:
     * ReversalRequest.Page.requests: list of ReversalRequest objects with updated attributes
     * ReversalRequest.Page.cursor: cursor to retrieve the next page of ReversalRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<ReversalRequest> requests = new ArrayList<>();
        for (SubResource request: page.entities) {
            requests.add((ReversalRequest) request);
        }
        return new Page(requests, page.cursor);
    }

    /**
     * Create ReversalRequests
     * <p>
     * Send a ReversalRequest object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param request [ReversalRequest object or HashMap]: ReversalRequest object to be created in the API
     * <p>
     * Return:
     * @return ReversalRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static ReversalRequest create(ReversalRequest request) throws Exception {
        return ReversalRequest.create(request, null);
    }

    /**
     * Create ReversalRequests
     * <p>
     * Send a ReversalRequest object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param request [ReversalRequest object or HashMap]: ReversalRequest object to be created in the API
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return ReversalRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static ReversalRequest create(ReversalRequest request, User user) throws Exception {
        return Rest.postSingle(data, request, user);
    }

    /**
     * Delete a ReversalRequest entity
     * <p>
     * Delete a ReversalRequest entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: ReversalRequest unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return deleted ReversalRequest object
     * @throws Exception error in the request
     */
    public static ReversalRequest delete(String id) throws Exception {
        return ReversalRequest.delete( id, null);
    }

    /**
     * Delete a ReversalRequest entity
     * <p>
     * Delete a ReversalRequest entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: ReversalRequest unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return deleted ReversalRequest object
     * @throws Exception error in the request
     */
    public static ReversalRequest delete(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * Update notification ReversalRequest entity
     * <p>
     * Update the ReversalRequest by passing id.
     * <p>
     * Parameters:
     * @param id        [string]: ReversalRequest id. ex: '5656565656565656'
     * @param patchData map of patch parameters
     *                  result [string]: result after the analysis of the ReversalRequest. Options: "rejected", "accepted", "partiallyAccepted".
     *                  rejectionReason [string, default null]: if the ReversalRequest is rejected a reason is required. Options: "noBalance", "accountClosed", "unableToReverse",
     *                  reversalReferenceId [string, default null]: return_id of the reversal transaction. ex: "D20018183202201201450u34sDGd19lz"
     *                  analysis [string, default null]: description of the analysis that led to the result.
     * <p>
     * Return:
     * @return ReversalRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static ReversalRequest update(String id, Map<String, Object> patchData) throws Exception {
        return ReversalRequest.update(id, patchData, null);
    }

    /**
     * Update notification ReversalRequest entity
     * <p>
     * Update notification ReversalRequest by passing id.
     * <p>
     * Parameters:
     * @param id        [string]: ReversalRequest id. ex: '5656565656565656'
     * @param patchData map of patch parameters
     *                  result [string]: result after the analysis of the ReversalRequest. Options: "rejected", "accepted", "partiallyAccepted".
     *                  rejectionReason [string, default null]: if the ReversalRequest is rejected a reason is required. Options: "noBalance", "accountClosed", "unableToReverse",
     *                  reversalReferenceId [string, default null]: return_id of the reversal transaction. ex: "D20018183202201201450u34sDGd19lz"
     *                  analysis [string, default null]: description of the analysis that led to the result.
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return ReversalRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static ReversalRequest update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "ReversalRequestLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public String agent;
        public String reason;
        public ReversalRequest request;

        /**
         * ReversalRequest Log object
         * <p>
         * Every time a ReversalRequest entity is modified, a corresponding ReversalRequest Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param created [string]: creation datetime for the log. ex: "2020-03-29"
         * @param type [string]: type of the ReversalRequest event which triggered the log creation. ex: "created"
         * @param errors [list of strings]: list of errors linked to this ReversalRequest event
         * @param request [ReversalRequest]: ReversalRequest entity to which the log refers to.
         */
        public Log(String created, String type, List<ErrorElement> errors, ReversalRequest request, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.request = request;
        }

        /**
         * Retrieve a specific ReversalRequest Log
         * <p>
         * Receive a single ReversalRequest Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return ReversalRequest Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific ReversalRequest Log
         * <p>
         * Receive a single ReversalRequest Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return ReversalRequest Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve ReversalRequest Logs
         * <p>
         * Receive a generator of ReversalRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * requestIds [string, default null]: list of ReversalRequest IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of ReversalRequest Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve ReversalRequest Logs
         * <p>
         * Receive a generator of ReversalRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return generator of ReversalRequest Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve ReversalRequest Logs
         * <p>
         * Receive a generator of ReversalRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of ReversalRequest Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve ReversalRequest Logs
         * <p>
         * Receive a generator of ReversalRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * requestIds [string, default null]: list of ReversalRequest IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of ReversalRequest Log objects with updated attributes
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
         * Retrieve paged ReversalRequest.Logs
         * <p>
         * Receive a list of up to 100 ReversalRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * requestIds [string, default null]: list of ReversalRequest IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return ReversalRequest.Log.Page object:
         * ReversalRequest.Log.Page.logs: list of ReversalRequest.Log objects with updated attributes
         * ReversalRequest.Log.Page.cursor: cursor to retrieve the next page of ReversalRequest.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged ReversalRequest.Logs
         * <p>
         * Receive a list of up to 100 ReversalRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return ReversalRequest.Log.Page object:
         * ReversalRequest.Log.Page.logs: list of ReversalRequest.Log objects with updated attributes
         * ReversalRequest.Log.Page.cursor: cursor to retrieve the next page of ReversalRequest.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged ReversalRequest.Logs
         * <p>
         * Receive a list of up to 100 ReversalRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return ReversalRequest.Log.Page object:
         * ReversalRequest.Log.Page.logs: list of ReversalRequest.Log objects with updated attributes
         * ReversalRequest.Log.Page.cursor: cursor to retrieve the next page of ReversalRequest.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged ReversalRequest.Logs
         * <p>
         * Receive a list of up to 100 ReversalRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * requestIds [string, default null]: list of ReversalRequest IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return ReversalRequest.Log.Page object:
         * ReversalRequest.Log.Page.logs: list of ReversalRequest.Log objects with updated attributes
         * ReversalRequest.Log.Page.cursor: cursor to retrieve the next page of ReversalRequest.Log objects
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
