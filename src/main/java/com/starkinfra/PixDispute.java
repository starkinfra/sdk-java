package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class PixDispute extends Resource {
    /**
     * PixDispute object
     * <p>
     * Pix disputes can be created when a fraud is detected creating a chain of transactions
     * in order to reverse the funds to the origin.
     * <p>
     * When you initialize a PixDispute, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * referenceId [string]: endToEndId of the transaction being reported. ex: "E20018183202201201450u34sDGd19lz"
     * method [string]: method used to perform the fraudulent action. Options: "scam", "unauthorized", "coercion", "invasion", "other"
     * description [string]: description including any details that can help with the dispute investigation. The description parameter is required when method is "other".
     * operatorEmail [string]: contact email of the operator responsible for the dispute.
     * operatorPhone [string]: contact phone number of the operator responsible for the dispute.
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * minTransactionAmount [number]: minimum transaction amount to be considered for the graph creation.
     * maxTransactionCount [number]: maximum number of transactions to be considered for the graph creation.
     * maxHopInterval [number]: mean time between transactions to be considered for the graph creation.
     * maxHopCount [number]: depth to be considered for the graph creation.
     * id [string]: unique id returned when the PixDispute is created. ex: "5656565656565656"
     * bacenId [string]: Central Bank's unique dispute id. ex: "817fc523-9e9d-40ab-9e53-dacb71454a05"
     * flow [string]: indicates the flow of the Pix Dispute. Options: "in" if you received the PixDispute, "out" if you created the PixDispute.
     * status [string]: current PixDispute status. Options: "created", "delivered", "analysed", "processing", "closed", "failed", "canceled".
     * transactions [list of PixDispute.Transaction objects]: list of transactions related to the dispute.
     * created [string]: creation datetime for the PixDispute. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixDispute. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(PixDispute.class, "PixDispute");

    public String referenceId;
    public String method;
    public String description;
    public String operatorEmail;
    public String operatorPhone;
    public String[] tags;
    public Number minTransactionAmount;
    public Number maxTransactionCount;
    public Number maxHopInterval;
    public Number maxHopCount;
    public String bacenId;
    public String flow;
    public String status;
    public List<Transaction> transactions;
    public String created;
    public String updated;

    /**
     * PixDispute object
     * <p>
     * When you initialize a PixDispute, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param referenceId [string]: endToEndId of the transaction being reported. ex: "E20018183202201201450u34sDGd19lz"
     * @param method [string]: method used to perform the fraudulent action. Options: "scam", "unauthorized", "coercion", "invasion", "other"
     * @param description [string]: description including any details that can help with the dispute investigation. The description parameter is required when method is "other".
     * @param operatorEmail [string]: contact email of the operator responsible for the dispute.
     * @param operatorPhone [string]: contact phone number of the operator responsible for the dispute.
     * @param tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * @param minTransactionAmount [number]: minimum transaction amount to be considered for the graph creation.
     * @param maxTransactionCount [number]: maximum number of transactions to be considered for the graph creation.
     * @param maxHopInterval [number]: mean time between transactions to be considered for the graph creation.
     * @param maxHopCount [number]: depth to be considered for the graph creation.
     * @param id [string]: unique id returned when the PixDispute is created. ex: "5656565656565656"
     * @param bacenId [string]: Central Bank's unique dispute id. ex: "817fc523-9e9d-40ab-9e53-dacb71454a05"
     * @param flow [string]: indicates the flow of the Pix Dispute. Options: "in" if you received the PixDispute, "out" if you created the PixDispute.
     * @param status [string]: current PixDispute status. Options: "created", "delivered", "analysed", "processing", "closed", "failed", "canceled".
     * @param transactions [list of PixDispute.Transaction objects]: list of transactions related to the dispute.
     * @param created [string]: creation datetime for the PixDispute. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the PixDispute. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public PixDispute(String referenceId, String method, String description, String operatorEmail, String operatorPhone,
                     String[] tags, Number minTransactionAmount, Number maxTransactionCount, Number maxHopInterval,
                     Number maxHopCount, String id, String bacenId, String flow, String status,
                     List<Transaction> transactions, String created, String updated
    ) {
        super(id);
        this.referenceId = referenceId;
        this.method = method;
        this.description = description;
        this.operatorEmail = operatorEmail;
        this.operatorPhone = operatorPhone;
        this.tags = tags;
        this.minTransactionAmount = minTransactionAmount;
        this.maxTransactionCount = maxTransactionCount;
        this.maxHopInterval = maxHopInterval;
        this.maxHopCount = maxHopCount;
        this.bacenId = bacenId;
        this.flow = flow;
        this.status = status;
        this.transactions = transactions;
        this.created = created;
        this.updated = updated;
    }

    /**
     * PixDispute object
     * <p>
     * When you initialize a PixDispute, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the PixDispute
     * referenceId [string]: endToEndId of the transaction being reported. ex: "E20018183202201201450u34sDGd19lz"
     * method [string]: method used to perform the fraudulent action. Options: "scam", "unauthorized", "coercion", "invasion", "other"
     * operatorEmail [string]: contact email of the operator responsible for the dispute.
     * operatorPhone [string]: contact phone number of the operator responsible for the dispute.
     * <p>
     * Parameters (conditionally required):
     * description [string, default null]: description including any details that can help with the dispute investigation. The description parameter is required when method is "other".
     * <p>
     * Parameters (optional):
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * minTransactionAmount [number]: minimum transaction amount to be considered for the graph creation.
     * maxTransactionCount [number]: maximum number of transactions to be considered for the graph creation.
     * maxHopInterval [number]: mean time between transactions to be considered for the graph creation.
     * maxHopCount [number]: depth to be considered for the graph creation.
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the PixDispute is created. ex: "5656565656565656"
     * bacenId [string]: Central Bank's unique dispute id. ex: "817fc523-9e9d-40ab-9e53-dacb71454a05"
     * flow [string]: indicates the flow of the Pix Dispute. Options: "in" if you received the PixDispute, "out" if you created the PixDispute.
     * status [string]: current PixDispute status. Options: "created", "delivered", "analysed", "processing", "closed", "failed", "canceled".
     * transactions [list of PixDispute.Transaction objects]: list of transactions related to the dispute.
     * created [string]: creation datetime for the PixDispute. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixDispute. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public PixDispute(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.referenceId = (String) dataCopy.remove("referenceId");
        this.method = (String) dataCopy.remove("method");
        this.description = (String) dataCopy.remove("description");
        this.operatorEmail = (String) dataCopy.remove("operatorEmail");
        this.operatorPhone = (String) dataCopy.remove("operatorPhone");
        this.tags = (String[]) dataCopy.remove("tags");
        this.minTransactionAmount = (Number) dataCopy.remove("minTransactionAmount");
        this.maxTransactionCount = (Number) dataCopy.remove("maxTransactionCount");
        this.maxHopInterval = (Number) dataCopy.remove("maxHopInterval");
        this.maxHopCount = (Number) dataCopy.remove("maxHopCount");
        this.bacenId = null;
        this.flow = null;
        this.status = null;
        this.transactions = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific PixDispute
     * <p>
     * Receive a single PixDispute object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return PixDispute object with updated attributes
     * @throws Exception error in the request
     */
    public static PixDispute get(String id) throws Exception {
        return PixDispute.get(id, null);
    }

    /**
     * Retrieve a specific PixDispute
     * <p>
     * Receive a single PixDispute object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixDispute object with updated attributes
     * @throws Exception error in the request
     */
    public static PixDispute get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve PixDisputes
     * <p>
     * Receive a generator of PixDispute objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "delivered", "analysed", "processing", "closed", "failed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Return:
     * @return generator of PixDispute objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixDispute> query(Map<String, Object> params) throws Exception {
        return PixDispute.query(params, null);
    }

    /**
     * Retrieve PixDisputes
     * <p>
     * Receive a generator of PixDispute objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixDispute objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixDispute> query(User user) throws Exception {
        return PixDispute.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PixDisputes
     * <p>
     * Receive a generator of PixDispute objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of PixDispute objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixDispute> query() throws Exception {
        return PixDispute.query(new HashMap<>(), null);
    }

    /**
     * Retrieve PixDisputes
     * <p>
     * Receive a generator of PixDispute objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "delivered", "analysed", "processing", "closed", "failed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixDispute objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixDispute> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<PixDispute> disputes;
        public String cursor;

        public Page(List<PixDispute> disputes, String cursor) {
            this.disputes = disputes;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged PixDisputes
     * <p>
     * Receive a list of up to 100 PixDispute objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your disputes.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "delivered", "analysed", "processing", "closed", "failed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Return:
     * @return PixDispute.Page object:
     * PixDispute.Page.disputes: list of PixDispute objects with updated attributes
     * PixDispute.Page.cursor: cursor to retrieve the next page of PixDispute objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged PixDisputes
     * <p>
     * Receive a list of up to 100 PixDispute objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your disputes.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixDispute.Page object:
     * PixDispute.Page.disputes: list of PixDispute objects with updated attributes
     * PixDispute.Page.cursor: cursor to retrieve the next page of PixDispute objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PixDisputes
     * <p>
     * Receive a list of up to 100 PixDispute objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your disputes.
     * <p>
     * Return:
     * @return PixDispute.Page object:
     * PixDispute.Page.disputes: list of PixDispute objects with updated attributes
     * PixDispute.Page.cursor: cursor to retrieve the next page of PixDispute objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PixDisputes
     * <p>
     * Receive a list of up to 100 PixDispute objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your disputes.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "delivered", "analysed", "processing", "closed", "failed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixDispute.Page object:
     * PixDispute.Page.disputes: list of PixDispute objects with updated attributes
     * PixDispute.Page.cursor: cursor to retrieve the next page of PixDispute objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<PixDispute> disputes = new ArrayList<>();
        for (SubResource dispute: page.entities) {
            disputes.add((PixDispute) dispute);
        }
        return new Page(disputes, page.cursor);
    }

    /**
     * Create a PixDispute
     * <p>
     * Send a PixDispute object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param disputes [list of PixDispute objects or HashMaps]: list of PixDispute objects to be created in the API
     * <p>
     * Return:
     * @return PixDispute object with updated attributes
     * @throws Exception error in the request
     */
    public static List<PixDispute> create(List<?> disputes) throws Exception {
        return PixDispute.create(disputes, null);
    }

    /**
     * Create a PixDispute
     * <p>
     * Send a PixDispute object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param disputes [list of PixDispute objects or HashMaps]: list of PixDispute objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixDispute object with updated attributes
     * @throws Exception error in the request
     */
    public static List<PixDispute> create(List<?> disputes, User user) throws Exception {
        List<PixDispute> disputeList = new ArrayList<>();
        for (Object dispute : disputes){
            if (dispute instanceof Map){
                disputeList.add(new PixDispute((Map<String, Object>) dispute));
                continue;
            }
            if (dispute instanceof PixDispute){
                disputeList.add((PixDispute) dispute);
                continue;
            }
            throw new Exception("Unknown type \"" + dispute.getClass() + "\", use PixDispute or HashMap");
        }
        return Rest.post(data, disputeList, user);
    }

    /**
     * Cancel a PixDispute
     * <p>
     * Cancel a PixDispute entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: PixDispute unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return canceled PixDispute object
     * @throws Exception error in the request
     */
    public static PixDispute cancel(String id) throws Exception {
        return PixDispute.cancel(id, null);
    }

    /**
     * Cancel a PixDispute entity
     * <p>
     * Cancel a PixDispute entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: PixDispute unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled PixDispute object
     * @throws Exception error in the request
     */
    public static PixDispute cancel(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * PixDispute.Transaction object
     * <p>
     * Transaction object related to the PixDispute.
     * <p>
     * Attributes:
     * endToEndId [string]: Central Bank's unique transaction id. ex: "E79457883202101262140HHX553UPqeq"
     * amount [number]: refundable amount. ex: 11234 (= R$ 112.34)
     * nominalAmount [number]: transaction amount. ex: 11234 (= R$ 112.34)
     * receiverType [string]: receiver person type. Options: "individual", "business"
     * receiverTaxIdCreated [string]: receiver's taxId creation date. For business type only.
     * receiverAccountCreated [string]: receiver's account creation date.
     * receiverBankCode [string]: receiver's bank code. ex: "20018183"
     * receiverId [string]: identifier of accountholder in the graph.
     * senderType [string]: sender person type. Options: "individual", "business"
     * senderTaxIdCreated [string]: sender's taxId creation date. For business type only.
     * senderAccountCreated [string]: sender's account creation date.
     * senderBankCode [string]: sender's bank code. ex: "20018183"
     * senderId [string]: identifier of accountholder in the graph.
     * settled [string]: settled datetime of the transaction in ISO format. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public final static class Transaction {
        public String endToEndId;
        public Number amount;
        public Number nominalAmount;
        public String receiverType;
        public String receiverTaxIdCreated;
        public String receiverAccountCreated;
        public String receiverBankCode;
        public String receiverId;
        public String senderType;
        public String senderTaxIdCreated;
        public String senderAccountCreated;
        public String senderBankCode;
        public String senderId;
        public String settled;

        /**
         * PixDispute.Transaction object
         * <p>
         * Transaction object related to the PixDispute.
         * <p>
         * Parameters:
         * @param endToEndId [string]: Central Bank's unique transaction id. ex: "E79457883202101262140HHX553UPqeq"
         * @param amount [number]: refundable amount. ex: 11234 (= R$ 112.34)
         * @param nominalAmount [number]: transaction amount. ex: 11234 (= R$ 112.34)
         * @param receiverType [string]: receiver person type. Options: "individual", "business"
         * @param receiverTaxIdCreated [string]: receiver's taxId creation date. For business type only.
         * @param receiverAccountCreated [string]: receiver's account creation date.
         * @param receiverBankCode [string]: receiver's bank code. ex: "20018183"
         * @param receiverId [string]: identifier of accountholder in the graph.
         * @param senderType [string]: sender person type. Options: "individual", "business"
         * @param senderTaxIdCreated [string]: sender's taxId creation date. For business type only.
         * @param senderAccountCreated [string]: sender's account creation date.
         * @param senderBankCode [string]: sender's bank code. ex: "20018183"
         * @param senderId [string]: identifier of accountholder in the graph.
         * @param settled [string]: settled datetime of the transaction in ISO format. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Transaction(String endToEndId, Number amount, Number nominalAmount, String receiverType,
                          String receiverTaxIdCreated, String receiverAccountCreated, String receiverBankCode,
                          String receiverId, String senderType, String senderTaxIdCreated, String senderAccountCreated,
                          String senderBankCode, String senderId, String settled) {
            this.endToEndId = endToEndId;
            this.amount = amount;
            this.nominalAmount = nominalAmount;
            this.receiverType = receiverType;
            this.receiverTaxIdCreated = receiverTaxIdCreated;
            this.receiverAccountCreated = receiverAccountCreated;
            this.receiverBankCode = receiverBankCode;
            this.receiverId = receiverId;
            this.senderType = senderType;
            this.senderTaxIdCreated = senderTaxIdCreated;
            this.senderAccountCreated = senderAccountCreated;
            this.senderBankCode = senderBankCode;
            this.senderId = senderId;
            this.settled = settled;
        }
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "PixDisputeLog");

        public String created;
        public String type;
        public List<String> errors;
        public PixDispute dispute;

        /**
         * PixDispute.Log object
         * <p>
         * Every time a PixDispute entity is modified, a corresponding PixDispute.Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param created [string]: creation datetime for the log. ex: "2020-03-29"
         * @param type [string]: type of the PixDispute event which triggered the log creation. ex: "created"
         * @param errors [list of strings]: list of errors linked to this PixDispute event
         * @param dispute [PixDispute]: PixDispute entity to which the log refers to.
         */
        public Log(String created, String type, List<String> errors, PixDispute dispute, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.dispute = dispute;
        }

        /**
         * Retrieve a specific PixDispute.Log
         * <p>
         * Receive a single PixDispute.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return PixDispute.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific PixDispute.Log
         * <p>
         * Receive a single PixDispute.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixDispute.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve PixDispute.Logs
         * <p>
         * Receive a generator of PixDispute.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * disputeIds [string, default null]: list of PixDispute IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of PixDispute.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve PixDispute.Logs
         * <p>
         * Receive a generator of PixDispute.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of PixDispute.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve PixDispute.Logs
         * <p>
         * Receive a generator of PixDispute.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of PixDispute.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve PixDispute.Logs
         * <p>
         * Receive a generator of PixDispute.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * disputeIds [string, default null]: list of PixDispute IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of PixDispute.Log objects with updated attributes
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
         * Retrieve paged PixDispute.Logs
         * <p>
         * Receive a list of up to 100 PixDispute.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your disputes.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * disputeIds [string, default null]: list of PixDispute IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return PixDispute.Log.Page object:
         * PixDispute.Log.Page.logs: list of PixDispute.Log objects with updated attributes
         * PixDispute.Log.Page.cursor: cursor to retrieve the next page of PixDispute.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged PixDispute.Logs
         * <p>
         * Receive a list of up to 100 PixDispute.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your disputes.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixDispute.Log.Page object:
         * PixDispute.Log.Page.logs: list of PixDispute.Log objects with updated attributes
         * PixDispute.Log.Page.cursor: cursor to retrieve the next page of PixDispute.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged PixDispute.Logs
         * <p>
         * Receive a list of up to 100 PixDispute.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your disputes.
         * <p>
         * Return:
         * @return PixDispute.Log.Page object:
         * PixDispute.Log.Page.logs: list of PixDispute.Log objects with updated attributes
         * PixDispute.Log.Page.cursor: cursor to retrieve the next page of PixDispute.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged PixDispute.Logs
         * <p>
         * Receive a list of up to 100 PixDispute.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your disputes.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * disputeIds [string, default null]: list of PixDispute IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixDispute.Log.Page object:
         * PixDispute.Log.Page.logs: list of PixDispute.Log objects with updated attributes
         * PixDispute.Log.Page.cursor: cursor to retrieve the next page of PixDispute.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }
}
