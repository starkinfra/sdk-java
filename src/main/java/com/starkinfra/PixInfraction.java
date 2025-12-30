package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;
import com.starkinfra.error.ErrorElement;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class PixInfraction extends Resource {
    /**
     * PixInfraction object
     * <p>
     * Pix Infractions are used to report transactions that are suspected of
     * fraud, to request a refund or to reverse a refund.
     * <p>
     * When you initialize a PixInfraction, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * referenceId [string]: endToEndId or returnId of the transaction being reported. ex: "E20018183202201201450u34sDGd19lz"
     * type [string]: type of Pix Infraction. Options: "reversal", "reversalChargeback"
     * method [string]: method of Pix Infraction. Options: "scam", "unauthorized", "coercion", "invasion", "other"
     * description [string]: description for any details that can help with the infraction investigation. The description parameter is required when method is "other".
     * fraudType [string]: type of Pix Fraud. The fraudType parameter is required when result is "agreed". Options: "identity", "mule", "scam", "other"
     * operatorEmail [string]: contact email of the operator responsible for the PixInfraction.
     * operatorPhone [string]: contact phone number of the operator responsible for the PixInfraction.
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * id [string]: unique id returned when the PixInfraction is created. ex: "5656565656565656"
     * fraudId [string]: id of the Pix Fraud. ex: "5741774970552320"
     * analysis [string]: analysis that led to the result.
     * debitedBankCode [string]: bankCode of the debited Pix participant in the reported transaction. ex: "20018183"
     * flow [string]: direction of the PixInfraction flow. Options: "out" if you created the PixInfraction, "in" if you received the PixInfraction.
     * creditedBankCode [string]: bankCode of the credited Pix participant in the reported transaction. ex: "20018183"
     * reportedBy [string]: agent that reported the PixInfraction. Options: "debited", "credited".
     * result [string]: result after the analysis of the PixInfraction by the receiving party. Options: "agreed", "disagreed"
     * status [string]: current PixInfraction status. Options: "created", "failed", "delivered", "closed", "canceled".
     * created [string]: creation datetime for the PixInfraction. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixInfraction. ex: "2020-03-10 10:30:00.000000+00:00"
     * amount [Long]: amount in cents of the reported transaction. 
     * bacenId [string]: unique id returned by the Central Bank for the PixInfraction. ex: "3b10c3ef-3117-4ab8-815d-d3867ada7560"
     * disputeId [string]: id of the PixDispute associated with the PixInfraction. 
     *
     */
    static ClassData data = new ClassData(PixInfraction.class, "PixInfraction");

    public String referenceId;
    public String type;
    public String method;
    public String description;
    public String fraudType;
    public String operatorEmail;
    public String operatorPhone;
    public String[] tags;
    public String fraudId;
    public String analysis;
    public String debitedBankCode;
    public String flow;
    public String creditedBankCode;
    public String reportedBy;
    public String result;
    public String status;
    public String created;
    public String updated;
    public Long amount;
    public String bacenId;
    public String disputeId;

    /**
     * PixInfraction object
     * <p>
     * When you initialize a PixInfraction, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param referenceId [string]: endToEndId or returnId of the transaction being reported. ex: "E20018183202201201450u34sDGd19lz"
     * @param type [string]: type of Pix Infraction. Options: "reversal" or "reversalChargeback"
     * @param method [string]: method of Pix Infraction. Option: "scam", "unauthorized", "coercion", "invasion" or "other"
     * @param description [string, default null]: description for any details that can help with the infraction investigation. The description parameter is required when method is "other".
     * @param fraudType [string, default null]: type of Pix Fraud. The fraudType parameter is required when result is "agreed". Options: "identity", "mule", "scam", "other"
     * @param operatorEmail [string]: contact email of the operator responsible for the PixInfraction.
     * @param operatorPhone [string]: contact phone number of the operator responsible for the PixInfraction.
     * @param tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * @param id [string]: unique id returned when the PixInfraction is created. ex: "5656565656565656"
     * @param fraudId [string]: id of the Pix Fraud. ex: "5741774970552320"
     * @param analysis [string]: analysis that led to the result.
     * @param debitedBankCode [string]: bankCode of the debited Pix participant in the reported transaction. ex: "20018183"
     * @param flow [string]: direction of the PixInfraction flow. Options: "out" if you created the PixInfraction, "in" if you received the PixInfraction.
     * @param creditedBankCode [string]: bankCode of the credited Pix participant in the reported transaction. ex: "20018183"
     * @param reportedBy [string]: agent that reported the PixInfraction. Options: "debited", "credited".
     * @param result [string]: result after the analysis of the PixInfraction by the receiving party. Options: "agreed", "disagreed"
     * @param status [string]: current PixInfraction status. Options: "created", "failed", "delivered", "closed", "canceled".
     * @param created [string]: creation datetime for the PixInfraction. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the PixInfraction. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param amount [Long]: amount in cents of the reported transaction.
     * @param bacenId [string]: unique id returned by the Central Bank for the PixInfraction. ex: "3b10c3ef-3117-4ab8-815d-d3867ada7560"
     * @param disputeId [string]: id of the PixDispute associated with the PixInfraction.
     */
    public PixInfraction(String referenceId, String type, String method, String description, String fraudType,
                         String[] tags, String id, String fraudId, String analysis, String debitedBankCode, String flow,
                         String creditedBankCode, String reportedBy, String result, String status, String created,
                         String updated, String operatorPhone, String operatorEmail, Long amount, String bacenId, String disputeId
    ) {
        super(id);
        this.referenceId = referenceId;
        this.type = type;
        this.method = method;
        this.description = description;
        this.fraudType = fraudType;
        this.operatorEmail = operatorEmail;
        this.operatorPhone = operatorPhone;
        this.tags = tags;
        this.fraudId = fraudId;
        this.analysis = analysis;
        this.debitedBankCode = debitedBankCode;
        this.flow = flow;
        this.creditedBankCode = creditedBankCode;
        this.reportedBy = reportedBy;
        this.result = result;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.amount = amount;
        this.bacenId = bacenId;
        this.disputeId = disputeId;
    }

    /**
     * PixInfraction object
     * <p>
     * When you initialize a PixInfraction, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the PixInfraction
     * referenceId [string]: endToEndId or returnId of the transaction being reported. ex: "E20018183202201201450u34sDGd19lz"
     * type [string]: type of Pix Infraction. Options: "reversal" or "reversalChargeback"
     * method [string]: method of Pix Infraction. Options: "scam", "unauthorized", "coercion", "invasion" or "other"
     * operatorEmail [string]: contact email of the operator responsible for the PixInfraction.
     * operatorPhone [string]: contact phone number of the operator responsible for the PixInfraction.
     * <p>
     * Parameters (conditionally required):
     * description [string, default null]: description for any details that can help with the infraction investigation. The description parameter is required when method is "other".
     * fraudType [string, default null]: type of Pix Fraud. The fraudType parameter is required when result is "agreed". Options: "identity", "mule", "scam", "other"
     * <p>
     * Parameters (optional):
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the PixInfraction is created. ex: "5656565656565656"
     * fraudId [string]: id of the Pix Fraud. ex: "5741774970552320"
     * analysis [string]: analysis that led to the result.
     * debitedBankCode [string]: bankCode of the debited Pix participant in the reported transaction. ex: "20018183"
     * flow [string]: direction of the PixInfraction flow. Options: "out" if you created the PixInfraction, "in" if you received the PixInfraction.
     * creditedBankCode [string]: bankCode of the credited Pix participant in the reported transaction. ex: "20018183"
     * reportedBy [string]: agent that reported the PixInfraction. Options: "debited", "credited".
     * result [string]: result after the analysis of the PixInfraction by the receiving party. Options: "agreed", "disagreed"
     * status [string]: current PixInfraction status. Options: "created", "failed", "delivered", "closed", "canceled".
     * created [string]: creation datetime for the PixInfraction. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixInfraction. ex: "2020-03-10 10:30:00.000000+00:00"
     * amount [Long]: amount in cents of the reported transaction.
     * bacenId [string]: unique id returned by the Central Bank for the PixInfraction. ex: "3b10c3ef-3117-4ab8-815d-d3867ada7560"
     * disputeId [string]: id of the PixDispute associated with the PixInfraction.
     * @throws Exception error in the request
     */
    public PixInfraction(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.referenceId = (String) dataCopy.remove("referenceId");
        this.type = (String) dataCopy.remove("type");
        this.method = (String) dataCopy.remove("method");
        this.description = (String) dataCopy.remove("description");
        this.fraudType = (String) dataCopy.remove("fraudType");
        this.operatorEmail = (String) dataCopy.remove("operatorEmail");
        this.operatorPhone = (String) dataCopy.remove("operatorPhone");
        this.tags = (String[]) dataCopy.remove("tags");
        this.fraudId = null;
        this.analysis = null;
        this.debitedBankCode = null;
        this.flow = null;
        this.creditedBankCode = null;
        this.reportedBy = null;
        this.result = null;
        this.status = null;
        this.created = null;
        this.updated = null;
        this.amount = null;
        this.bacenId = null;
        this.disputeId = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific PixInfraction
     * <p>
     * Receive a single PixInfraction object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return PixInfraction object with updated attributes
     * @throws Exception error in the request
     */
    public static PixInfraction get(String id) throws Exception {
        return PixInfraction.get(id, null);
    }

    /**
     * Retrieve a specific PixInfraction
     * <p>
     * Receive a single PixInfraction object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixInfraction object with updated attributes
     * @throws Exception error in the request
     */
    public static PixInfraction get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve PixInfractions
     * <p>
     * Receive a generator of PixInfraction objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "closed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved PixInfractions. Options: "reversal", "reversalChargeback".
     * flow [string]: direction of the Pix Claim. Options: "in" if you received the PixClaim or "out" if you created the PixClaim.
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Return:
     * @return generator of PixInfraction objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixInfraction> query(Map<String, Object> params) throws Exception {
        return PixInfraction.query(params, null);
    }

    /**
     * Retrieve PixInfractions
     * <p>
     * Receive a generator of PixInfraction objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixInfraction objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixInfraction> query(User user) throws Exception {
        return PixInfraction.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PixInfractions
     * <p>
     * Receive a generator of PixInfraction objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of PixInfraction objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixInfraction> query() throws Exception {
        return PixInfraction.query(new HashMap<>(), null);
    }

    /**
     * Retrieve PixInfractions
     * <p>
     * Receive a generator of PixInfraction objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "closed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved PixInfractions. Options: "reversal", "reversalChargeback".
     * flow [string]: direction of the Pix Claim. Options: "in" if you received the PixClaim or "out" if you created the PixClaim.
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixInfraction objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixInfraction> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<PixInfraction> infractions;
        public String cursor;

        public Page(List<PixInfraction> infractions, String cursor) {
            this.infractions = infractions;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged PixInfractions
     * <p>
     * Receive a list of up to 100 PixInfraction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your infractions.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "closed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved PixInfractions. Options: "reversal", "reversalChargeback".
     * flow [string]: direction of the Pix Claim. Options: "in" if you received the PixClaim or "out" if you created the PixClaim.
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Return:
     * @return PixInfraction.Page object:
     * PixInfraction.Page.infractions: list of PixInfraction objects with updated attributes
     * PixInfraction.Page.cursor: cursor to retrieve the next page of PixInfraction objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged PixInfractions
     * <p>
     * Receive a list of up to 100 PixInfraction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your infractions.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixInfraction.Page object:
     * PixInfraction.Page.infractions: list of PixInfraction objects with updated attributes
     * PixInfraction.Page.cursor: cursor to retrieve the next page of PixInfraction objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PixInfractions
     * <p>
     * Receive a list of up to 100 PixInfraction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your infractions.
     * <p>
     * Return:
     * @return PixInfraction.Page object:
     * PixInfraction.Page.infractions: list of PixInfraction objects with updated attributes
     * PixInfraction.Page.cursor: cursor to retrieve the next page of PixInfraction objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PixInfractions
     * <p>
     * Receive a list of up to 100 PixInfraction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your infractions.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "closed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved PixInfractions. Options: "reversal", "reversalChargeback".
     * flow [string]: direction of the Pix Claim. Options: "in" if you received the PixClaim or "out" if you created the PixClaim.
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixInfraction.Page object:
     * PixInfraction.Page.infractions: list of PixInfraction objects with updated attributes
     * PixInfraction.Page.cursor: cursor to retrieve the next page of PixInfraction objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<PixInfraction> infractions = new ArrayList<>();
        for (SubResource infraction: page.entities) {
            infractions.add((PixInfraction) infraction);
        }
        return new Page(infractions, page.cursor);
    }

    /**
     * Create a PixInfraction
     * <p>
     * Send a PixInfraction object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param infractions [list of PixInfraction objects or HashMaps]: list of PixInfraction objects to be created in the API
     * <p>
     * Return:
     * @return PixInfraction object with updated attributes
     * @throws Exception error in the request
     */
    public static List<PixInfraction> create(List<?> infractions) throws Exception {
        return PixInfraction.create(infractions, null);
    }

    /**
     * Create a PixInfraction
     * <p>
     * Send a PixInfraction object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param infractions [list of PixInfraction objects or HashMaps]: list of PixInfraction objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixInfraction object with updated attributes
     * @throws Exception error in the request
     */
    public static List<PixInfraction> create(List<?> infractions, User user) throws Exception {
        List<PixInfraction> infractionList = new ArrayList<>();
        for (Object infraction : infractions){
            if (infraction instanceof Map){
                infractionList.add(new PixInfraction((Map<String, Object>) infraction));
                continue;
            }
            if (infraction instanceof PixInfraction){
                infractionList.add((PixInfraction) infraction);
                continue;
            }
            throw new Exception("Unknown type \"" + infraction.getClass() + "\", use PixInfraction or HashMap");
        }
        return Rest.post(data, infractionList, user);
    }

    /**
     * Cancel an  PixInfraction
     * <p>
     * Cancel a PixInfraction entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: PixInfraction unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return canceled PixInfraction object
     * @throws Exception error in the request
     */
    public static PixInfraction cancel(String id) throws Exception {
        return PixInfraction.cancel(id, null);
    }

    /**
     * Cancel a PixInfraction entity
     * <p>
     * Cancel a PixInfraction entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: PixInfraction unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled PixInfraction object
     * @throws Exception error in the request
     */
    public static PixInfraction cancel(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * Update PixInfraction entity
     * <p>
     * Update the PixInfraction by passing id.
     * <p>
     * Parameters:
     * @param id [string]: PixInfraction id. ex: "5656565656565656"
     * @param patchData map of properties to patch
     * analysis [string, default null]: analysis that led to the result.
     * result [string]: result after the analysis of the PixInfraction. Options: "agreed", "disagreed"
     * fraudType [string, default null]: type of Pix Fraud. The fraudType parameter is required when result is "agreed". Options: "identity", "mule", "scam", "other"
     * <p>
     * Return:
     * @return PixInfraction object with updated attributes
     * @throws Exception error in the request
     */
    public static PixInfraction update(String id, Map<String, Object> patchData) throws Exception {
        return PixInfraction.update(id, patchData, null);
    }

    /**
     * Update PixInfraction entity
     * <p>
     * Update PixInfraction by passing id.
     * <p>
     * Parameters:
     * @param id [string]: PixInfraction id. ex: "5656565656565656"
     * @param patchData map of patch parameters:
     * result [string]: result after the analysis of the PixInfraction. Options: "agreed", "disagreed"
     * analysis [string, default null]: analysis that led to the result.
     * fraudType [string]: type of Pix Fraud. The fraudType parameter is required when result is "agreed". Options: "identity", "mule", "scam", "other"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixInfraction object with updated attributes
     * @throws Exception error in the request
     */
    public static PixInfraction update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "PixInfractionLog");

        public String created;
        public String type;
        public List<String> errors;
        public PixInfraction infraction;

        /**
         * PixInfraction.Log object
         * <p>
         * Every time a PixInfraction entity is modified, a corresponding PixInfraction.Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param created [string]: creation datetime for the log. ex: "2020-03-29"
         * @param type [string]: type of the PixInfraction event which triggered the log creation. ex: "created"
         * @param errors [list of strings]: list of errors linked to this PixInfraction event
         * @param infraction [PixInfraction]: PixInfraction entity to which the log refers to.
         */
        public Log(String created, String type, List<String> errors, PixInfraction infraction, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.infraction = infraction;
        }

        /**
         * Retrieve a specific PixInfraction.Log
         * <p>
         * Receive a single PixInfraction.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return PixInfraction.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific PixInfraction.Log
         * <p>
         * Receive a single PixInfraction.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixInfraction.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve PixInfraction.Logs
         * <p>
         * Receive a generator of PixInfraction.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * infractionIds [string, default null]: list of PixInfraction IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of PixInfraction.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve PixInfraction.Logs
         * <p>
         * Receive a generator of PixInfraction.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of PixInfraction.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve PixInfraction.Logs
         * <p>
         * Receive a generator of PixInfraction.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of PixInfraction.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve PixInfraction.Logs
         * <p>
         * Receive a generator of PixInfraction.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * infractionIds [string, default null]: list of PixInfraction IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of PixInfraction.Log objects with updated attributes
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
         * Retrieve paged PixInfraction.Logs
         * <p>
         * Receive a list of up to 100 PixInfraction.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your infractions.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * infractionIds [string, default null]: list of PixInfraction IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return PixInfraction.Log.Page object:
         * PixInfraction.Log.Page.logs: list of PixInfraction.Log objects with updated attributes
         * PixInfraction.Log.Page.cursor: cursor to retrieve the next page of PixInfraction.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged PixInfraction.Logs
         * <p>
         * Receive a list of up to 100 PixInfraction.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your infractions.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixInfraction.Log.Page object:
         * PixInfraction.Log.Page.logs: list of PixInfraction.Log objects with updated attributes
         * PixInfraction.Log.Page.cursor: cursor to retrieve the next page of PixInfraction.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged PixInfraction.Logs
         * <p>
         * Receive a list of up to 100 PixInfraction.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your infractions.
         * <p>
         * Return:
         * @return PixInfraction.Log.Page object:
         * PixInfraction.Log.Page.logs: list of PixInfraction.Log objects with updated attributes
         * PixInfraction.Log.Page.cursor: cursor to retrieve the next page of PixInfraction.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged PixInfraction.Logs
         * <p>
         * Receive a list of up to 100 PixInfraction.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your infractions.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * infractionIds [string, default null]: list of PixInfraction IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixInfraction.Log.Page object:
         * PixInfraction.Log.Page.logs: list of PixInfraction.Log objects with updated attributes
         * PixInfraction.Log.Page.cursor: cursor to retrieve the next page of PixInfraction.Log objects
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
