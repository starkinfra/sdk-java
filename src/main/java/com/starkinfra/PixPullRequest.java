package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class PixPullRequest extends Resource {
    /**
     * PixPullRequest object
     * <p>
     * A Pix Pull Request is a command sent to the payer's bank to trigger the automatic
     * debit linked to an active Pix Pull Subscription. It confirms the receiver's intent
     * to collect the agreed amount within the current billing cycle and initiates the
     * settlement process through the Pix infrastructure.
     * <p>
     * When you initialize a PixPullRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * amount [Long]: amount to be charged.
     * due [string]: due date for answering with an approval or denial. ex: "2020-03-10 10:30:00.000000+00:00"
     * endToEndId [string]: Central Bank's unique transaction id. ex: "E00002649202201172211u34srod19le"
     * receiverAccountNumber [string]: receiver's bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * receiverAccountType [string]: receiver's account type. Options: "checking", "savings", "salary" and "payment"
     * receiverBankCode [string]: receiver's bank code.
     * receiverName [string]: receiver's name.
     * reconciliationId [string]: id to be used for conciliation of the resulting Pix transaction. Up to 25 alphanumeric characters. ex: "123456"
     * subscriptionId [string]: unique id of the Pix Pull Subscription.
     * subscriptionBacenId [string]: unique id returned by the Central Bank for the Pix Pull Subscription.
     * attemptType [string]: defines the type of attempt for the Pix Pull Request. Options: "default", "instantRetry" and "scheduledRetry".
     * description [string]: additional information to be delivered to the sender.
     * receiverBranchCode [string]: receiver's branch code.
     * tags [list of strings]: list of strings for reference when searching for PixPullRequests. ex: ["employees", "monthly"]
     * id [string]: unique id returned when the PixPullRequest is created. ex: "5656565656565656"
     * status [string]: current PixPullRequest status.
     * created [string]: creation datetime for the PixPullRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixPullRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * flow [string]: direction of money flow. ex: "in" or "out"
     * receiverTaxId [string]: receiver's tax ID (CPF or CNPJ).
     * senderBankCode [string]: sender's bank institution code in Brazil.
     * senderFinalName [string]: sender's final name.
     * senderTaxId [string]: sender's tax ID (CPF or CNPJ).
     *
     */
    static ClassData data = new ClassData(PixPullRequest.class, "PixPullRequest");

    public Long amount;
    public String due;
    public String endToEndId;
    public String receiverAccountNumber;
    public String receiverAccountType;
    public String receiverBankCode;
    public String receiverName;
    public String reconciliationId;
    public String subscriptionId;
    public String subscriptionBacenId;
    public String attemptType;
    public String description;
    public String receiverBranchCode;
    public String[] tags;
    public String status;
    public String created;
    public String updated;
    public String flow;
    public String receiverTaxId;
    public String senderBankCode;
    public String senderFinalName;
    public String senderTaxId;

    /**
     * PixPullRequest object
     * <p>
     * When you initialize a PixPullRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param amount [Long]: amount to be charged.
     * @param due [string]: due date for answering with an approval or denial. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param endToEndId [string]: Central Bank's unique transaction id. ex: "E00002649202201172211u34srod19le"
     * @param receiverAccountNumber [string]: receiver's bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * @param receiverAccountType [string]: receiver's account type. Options: "checking", "savings", "salary" and "payment"
     * @param receiverBankCode [string]: receiver's bank code.
     * @param receiverName [string]: receiver's name.
     * @param reconciliationId [string]: id to be used for conciliation of the resulting Pix transaction. Up to 25 alphanumeric characters. ex: "123456"
     * @param subscriptionId [string]: unique id of the Pix Pull Subscription.
     * @param subscriptionBacenId [string]: unique id returned by the Central Bank for the Pix Pull Subscription.
     * @param attemptType [string, default null]: defines the type of attempt for the Pix Pull Request. Options: "default", "instantRetry" and "scheduledRetry".
     * @param description [string, default null]: additional information to be delivered to the sender.
     * @param receiverBranchCode [string, default null]: receiver's branch code.
     * @param tags [list of strings, default null]: list of strings for reference when searching for PixPullRequests. ex: ["employees", "monthly"]
     * @param id [string]: unique id returned when the PixPullRequest is created. ex: "5656565656565656"
     * @param status [string]: current PixPullRequest status.
     * @param created [string]: creation datetime for the PixPullRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the PixPullRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param flow [string]: direction of money flow. ex: "in" or "out"
     * @param receiverTaxId [string]: receiver's tax ID (CPF or CNPJ).
     * @param senderBankCode [string]: sender's bank institution code in Brazil.
     * @param senderFinalName [string]: sender's final name.
     * @param senderTaxId [string]: sender's tax ID (CPF or CNPJ).
     */
    public PixPullRequest(Long amount, String due, String endToEndId, String receiverAccountNumber,
                          String receiverAccountType, String receiverBankCode, String receiverName,
                          String reconciliationId, String subscriptionId, String subscriptionBacenId,
                          String attemptType, String description, String receiverBranchCode, String[] tags,
                          String id, String status, String created, String updated, String flow,
                          String receiverTaxId, String senderBankCode, String senderFinalName, String senderTaxId
    ) {
        super(id);
        this.amount = amount;
        this.due = due;
        this.endToEndId = endToEndId;
        this.receiverAccountNumber = receiverAccountNumber;
        this.receiverAccountType = receiverAccountType;
        this.receiverBankCode = receiverBankCode;
        this.receiverName = receiverName;
        this.reconciliationId = reconciliationId;
        this.subscriptionId = subscriptionId;
        this.subscriptionBacenId = subscriptionBacenId;
        this.attemptType = attemptType;
        this.description = description;
        this.receiverBranchCode = receiverBranchCode;
        this.tags = tags;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.flow = flow;
        this.receiverTaxId = receiverTaxId;
        this.senderBankCode = senderBankCode;
        this.senderFinalName = senderFinalName;
        this.senderTaxId = senderTaxId;
    }

    /**
     * PixPullRequest object
     * <p>
     * When you initialize a PixPullRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the PixPullRequest
     * amount [Long]: amount to be charged.
     * due [string]: due date for answering with an approval or denial. ex: "2020-03-10 10:30:00.000000+00:00"
     * endToEndId [string]: Central Bank's unique transaction id. ex: "E00002649202201172211u34srod19le"
     * receiverAccountNumber [string]: receiver's bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * receiverAccountType [string]: receiver's account type. Options: "checking", "savings", "salary" and "payment"
     * receiverBankCode [string]: receiver's bank code.
     * reconciliationId [string]: id to be used for conciliation of the resulting Pix transaction. Up to 25 alphanumeric characters. ex: "123456"
     * subscriptionId [string]: unique id of the Pix Pull Subscription.
     * <p>
     * Parameters (optional):
     * receiverName [string, default null]: receiver's name.
     * subscriptionBacenId [string, default null]: unique id returned by the Central Bank for the Pix Pull Subscription.
     * attemptType [string, default null]: defines the type of attempt for the Pix Pull Request. Options: "default", "instantRetry" and "scheduledRetry".
     * description [string, default null]: additional information to be delivered to the sender.
     * receiverBranchCode [string, default null]: receiver's branch code.
     * tags [list of strings, default null]: list of strings for reference when searching for PixPullRequests. ex: ["employees", "monthly"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the PixPullRequest is created. ex: "5656565656565656"
     * status [string]: current PixPullRequest status.
     * created [string]: creation datetime for the PixPullRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixPullRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * flow [string]: direction of money flow. ex: "in" or "out"
     * receiverTaxId [string]: receiver's tax ID (CPF or CNPJ).
     * senderBankCode [string]: sender's bank institution code in Brazil.
     * senderFinalName [string]: sender's final name.
     * senderTaxId [string]: sender's tax ID (CPF or CNPJ).
     * @throws Exception error in the request
     */
    public PixPullRequest(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.amount = ((Number) dataCopy.remove("amount")).longValue();
        this.due = (String) dataCopy.remove("due");
        this.endToEndId = (String) dataCopy.remove("endToEndId");
        this.receiverAccountNumber = (String) dataCopy.remove("receiverAccountNumber");
        this.receiverAccountType = (String) dataCopy.remove("receiverAccountType");
        this.receiverBankCode = (String) dataCopy.remove("receiverBankCode");
        this.receiverName = (String) dataCopy.remove("receiverName");
        this.reconciliationId = (String) dataCopy.remove("reconciliationId");
        this.subscriptionId = (String) dataCopy.remove("subscriptionId");
        this.subscriptionBacenId = (String) dataCopy.remove("subscriptionBacenId");
        this.attemptType = (String) dataCopy.remove("attemptType");
        this.description = (String) dataCopy.remove("description");
        this.receiverBranchCode = (String) dataCopy.remove("receiverBranchCode");
        this.tags = (String[]) dataCopy.remove("tags");
        this.status = null;
        this.created = null;
        this.updated = null;
        this.flow = null;
        this.receiverTaxId = null;
        this.senderBankCode = null;
        this.senderFinalName = null;
        this.senderTaxId = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific PixPullRequest
     * <p>
     * Receive a single PixPullRequest object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return PixPullRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static PixPullRequest get(String id) throws Exception {
        return PixPullRequest.get(id, null);
    }

    /**
     * Retrieve a specific PixPullRequest
     * <p>
     * Receive a single PixPullRequest object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixPullRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static PixPullRequest get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve PixPullRequests
     * <p>
     * Receive a generator of PixPullRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [string, default null]: filter for status of retrieved objects. ex: "created", "active", "canceled", "failed"
     * tags [list of strings, default null]: list of strings for tagging. ex: ["employees", "monthly"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * flow [string, default null]: filter Pix Pull Requests by the specific flow. Options: "in", "out"
     * subscriptionIds [list of strings, default null]: filter Pix Pull Requests by the subscriptionIds. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of PixPullRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixPullRequest> query(Map<String, Object> params) throws Exception {
        return PixPullRequest.query(params, null);
    }

    /**
     * Retrieve PixPullRequests
     * <p>
     * Receive a generator of PixPullRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixPullRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixPullRequest> query(User user) throws Exception {
        return PixPullRequest.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PixPullRequests
     * <p>
     * Receive a generator of PixPullRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of PixPullRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixPullRequest> query() throws Exception {
        return PixPullRequest.query(new HashMap<>(), null);
    }

    /**
     * Retrieve PixPullRequests
     * <p>
     * Receive a generator of PixPullRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [string, default null]: filter for status of retrieved objects. ex: "created", "active", "canceled", "failed"
     * tags [list of strings, default null]: list of strings for tagging. ex: ["employees", "monthly"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * flow [string, default null]: filter Pix Pull Requests by the specific flow. Options: "in", "out"
     * subscriptionIds [list of strings, default null]: filter Pix Pull Requests by the subscriptionIds. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixPullRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixPullRequest> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<PixPullRequest> requests;
        public String cursor;

        public Page(List<PixPullRequest> requests, String cursor) {
            this.requests = requests;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged PixPullRequests
     * <p>
     * Receive a list of up to 100 PixPullRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "active", "canceled", "failed"]
     * tags [list of strings, default null]: list of strings for tagging. ex: ["employees", "monthly"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * flow [string, default null]: filter Pix Pull Requests by the specific flow. Options: "in", "out"
     * subscriptionIds [list of strings, default null]: filter Pix Pull Requests by the subscriptionIds. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return PixPullRequest.Page object:
     * PixPullRequest.Page.requests: list of PixPullRequest objects with updated attributes
     * PixPullRequest.Page.cursor: cursor to retrieve the next page of PixPullRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged PixPullRequests
     * <p>
     * Receive a list of up to 100 PixPullRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixPullRequest.Page object:
     * PixPullRequest.Page.requests: list of PixPullRequest objects with updated attributes
     * PixPullRequest.Page.cursor: cursor to retrieve the next page of PixPullRequest objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PixPullRequests
     * <p>
     * Receive a list of up to 100 PixPullRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return PixPullRequest.Page object:
     * PixPullRequest.Page.requests: list of PixPullRequest objects with updated attributes
     * PixPullRequest.Page.cursor: cursor to retrieve the next page of PixPullRequest objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PixPullRequests
     * <p>
     * Receive a list of up to 100 PixPullRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "active", "canceled", "failed"]
     * tags [list of strings, default null]: list of strings for tagging. ex: ["employees", "monthly"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * flow [string, default null]: filter Pix Pull Requests by the specific flow. Options: "in", "out"
     * subscriptionIds [list of strings, default null]: filter Pix Pull Requests by the subscriptionIds. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixPullRequest.Page object:
     * PixPullRequest.Page.requests: list of PixPullRequest objects with updated attributes
     * PixPullRequest.Page.cursor: cursor to retrieve the next page of PixPullRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<PixPullRequest> requests = new ArrayList<>();
        for (SubResource request: page.entities) {
            requests.add((PixPullRequest) request);
        }
        return new Page(requests, page.cursor);
    }

    /**
     * Create PixPullRequests
     * <p>
     * Send a list of PixPullRequest objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param requests [list of PixPullRequest objects or HashMaps]: list of PixPullRequest objects to be created in the API
     * <p>
     * Return:
     * @return list of PixPullRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<PixPullRequest> create(List<?> requests) throws Exception {
        return PixPullRequest.create(requests, null);
    }

    /**
     * Create PixPullRequests
     * <p>
     * Send a list of PixPullRequest objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param requests [list of PixPullRequest objects or HashMaps]: list of PixPullRequest objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of PixPullRequest objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<PixPullRequest> create(List<?> requests, User user) throws Exception {
        List<PixPullRequest> requestList = new ArrayList<>();
        for (Object request : requests){
            if (request instanceof Map){
                requestList.add(new PixPullRequest((Map<String, Object>) request));
                continue;
            }
            if (request instanceof PixPullRequest){
                requestList.add((PixPullRequest) request);
                continue;
            }
            throw new Exception("Unknown type \"" + request.getClass() + "\", use PixPullRequest or HashMap");
        }
        return Rest.post(data, requestList, user);
    }

    /**
     * Cancel a PixPullRequest
     * <p>
     * Cancel a PixPullRequest entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: PixPullRequest unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return canceled PixPullRequest object
     * @throws Exception error in the request
     */
    public static PixPullRequest cancel(String id) throws Exception {
        return PixPullRequest.cancel(id, null, null);
    }

    /**
     * Cancel a PixPullRequest
     * <p>
     * Cancel a PixPullRequest entity previously created in the Stark Infra API.
     * As the receiver, you can also cancel a delivered or confirmed request by providing a specific reason:
     * "accountClosed", "receiverOrganizationClosed", "receiverInternalError", "fraud", "receiverUserRequested".
     * As the sender, you can cancel a confirmed request. The allowed reasons for cancellation are:
     * "accountClosed", "senderDeceased", "fraud", "senderUserRequested".
     * <p>
     * Parameters:
     * @param id [string]: PixPullRequest unique id. ex: "5656565656565656"
     * @param reason [string]: reason why the Pix Pull Request is being canceled. Options: "accountClosed", "receiverOrganizationClosed", "receiverInternalError", "fraud", "receiverUserRequested", "senderDeceased", "senderUserRequested"
     * <p>
     * Return:
     * @return canceled PixPullRequest object
     * @throws Exception error in the request
     */
    public static PixPullRequest cancel(String id, String reason) throws Exception {
        return PixPullRequest.cancel(id, reason, null);
    }

    /**
     * Cancel a PixPullRequest entity
     * <p>
     * Cancel a PixPullRequest entity previously created in the Stark Infra API.
     * As the receiver, you can also cancel a delivered or confirmed request by providing a specific reason:
     * "accountClosed", "receiverOrganizationClosed", "receiverInternalError", "fraud", "receiverUserRequested".
     * As the sender, you can cancel a confirmed request. The allowed reasons for cancellation are:
     * "accountClosed", "senderDeceased", "fraud", "senderUserRequested".
     * <p>
     * Parameters:
     * @param id [string]: PixPullRequest unique id. ex: "5656565656565656"
     * @param reason [string]: reason why the Pix Pull Request is being canceled. Options: "accountClosed", "receiverOrganizationClosed", "receiverInternalError", "fraud", "receiverUserRequested", "senderDeceased", "senderUserRequested"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled PixPullRequest object
     * @throws Exception error in the request
     */
    public static PixPullRequest cancel(String id, String reason, User user) throws Exception {
        HashMap<String, Object> query = new HashMap<>();
        if (reason != null) query.put("reason", reason);
        return Rest.delete(data, id, query, user);
    }

    /**
     * Update PixPullRequest entity
     * <p>
     * Update the PixPullRequest by passing id. A Pix Pull Request can be updated to change the status to "scheduled" or "denied".
     * <p>
     * Parameters:
     * @param id [string]: PixPullRequest id. ex: "5656565656565656"
     * @param patchData map of properties to patch
     * status [string]: new status of the Pix Pull Request.
     * reason [string, conditionally required]: reason why the Pix Pull Request is being denied. Options: "senderAccountClosed", "senderAccountBLocked", "amountNotAllowed"
     * <p>
     * Return:
     * @return PixPullRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static PixPullRequest update(String id, Map<String, Object> patchData) throws Exception {
        return PixPullRequest.update(id, patchData, null);
    }

    /**
     * Update PixPullRequest entity
     * <p>
     * Update PixPullRequest by passing id. A Pix Pull Request can be updated to change the status to "scheduled" or "denied".
     * <p>
     * Parameters:
     * @param id [string]: PixPullRequest id. ex: "5656565656565656"
     * @param patchData map of patch parameters:
     * status [string]: new status of the Pix Pull Request.
     * reason [string, conditionally required]: reason why the Pix Pull Request is being denied. Options: "senderAccountClosed", "senderAccountBLocked", "amountNotAllowed"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixPullRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static PixPullRequest update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "PixPullRequestLog");

        public String created;
        public String type;
        public List<String> errors;
        public String description;
        public String reason;
        public PixPullRequest request;

        /**
         * PixPullRequest.Log object
         * <p>
         * Every time a PixPullRequest entity is modified, a corresponding PixPullRequest.Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param created [string]: creation datetime for the log. ex: "2020-03-29"
         * @param type [string]: type of the PixPullRequest event which triggered the log creation. ex: "sent", "denied", "failed", "created", "success", "approved", "credited", "refunded", "processing"
         * @param errors [list of strings]: list of errors linked to this PixPullRequest event
         * @param description [string]: additional information regarding the log event.
         * @param reason [string]: reason associated with the log event when applicable.
         * @param request [PixPullRequest]: PixPullRequest entity to which the log refers to.
         */
        public Log(String created, String type, List<String> errors, String description, String reason, PixPullRequest request, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.description = description;
            this.reason = reason;
            this.request = request;
        }

        /**
         * Retrieve a specific PixPullRequest.Log
         * <p>
         * Receive a single PixPullRequest.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return PixPullRequest.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific PixPullRequest.Log
         * <p>
         * Receive a single PixPullRequest.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixPullRequest.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve PixPullRequest.Logs
         * <p>
         * Receive a generator of PixPullRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["sent", "denied", "failed", "created", "success", "approved", "credited", "refunded", "processing"]
         * requestIds [list of strings, default null]: list of PixPullRequest IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of PixPullRequest.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve PixPullRequest.Logs
         * <p>
         * Receive a generator of PixPullRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of PixPullRequest.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve PixPullRequest.Logs
         * <p>
         * Receive a generator of PixPullRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of PixPullRequest.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve PixPullRequest.Logs
         * <p>
         * Receive a generator of PixPullRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["sent", "denied", "failed", "created", "success", "approved", "credited", "refunded", "processing"]
         * requestIds [list of strings, default null]: list of PixPullRequest IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of PixPullRequest.Log objects with updated attributes
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
         * Retrieve paged PixPullRequest.Logs
         * <p>
         * Receive a list of up to 100 PixPullRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["sent", "denied", "failed", "created", "success", "approved", "credited", "refunded", "processing"]
         * requestIds [list of strings, default null]: list of PixPullRequest IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return PixPullRequest.Log.Page object:
         * PixPullRequest.Log.Page.logs: list of PixPullRequest.Log objects with updated attributes
         * PixPullRequest.Log.Page.cursor: cursor to retrieve the next page of PixPullRequest.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged PixPullRequest.Logs
         * <p>
         * Receive a list of up to 100 PixPullRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixPullRequest.Log.Page object:
         * PixPullRequest.Log.Page.logs: list of PixPullRequest.Log objects with updated attributes
         * PixPullRequest.Log.Page.cursor: cursor to retrieve the next page of PixPullRequest.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged PixPullRequest.Logs
         * <p>
         * Receive a list of up to 100 PixPullRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return PixPullRequest.Log.Page object:
         * PixPullRequest.Log.Page.logs: list of PixPullRequest.Log objects with updated attributes
         * PixPullRequest.Log.Page.cursor: cursor to retrieve the next page of PixPullRequest.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged PixPullRequest.Logs
         * <p>
         * Receive a list of up to 100 PixPullRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["sent", "denied", "failed", "created", "success", "approved", "credited", "refunded", "processing"]
         * requestIds [list of strings, default null]: list of PixPullRequest IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixPullRequest.Log.Page object:
         * PixPullRequest.Log.Page.logs: list of PixPullRequest.Log objects with updated attributes
         * PixPullRequest.Log.Page.cursor: cursor to retrieve the next page of PixPullRequest.Log objects
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
