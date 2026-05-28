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


public final class PixPullSubscription extends Resource {
    /**
     * PixPullSubscription object
     * <p>
     * Pix Pull Subscriptions allow you to set up and manage recurring Pix debits,
     * defining the frequency, amount, and required payer authorizations for each subscription.
     * When you initialize a PixPullSubscription, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * bacenId [string]: Central Bank's unique recurrency id.
     * externalId [string]: Safe string that must be unique among all your Pix Pull Subscriptions.
     * installmentStart [string]: Start of settlements allowed for this Pix Pull Subscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * interval [string]: Cycle definition of the Pix Pull Requests. Options: "week", "month", "quarter", "semester" or "year"
     * receiverName [string]: Receiver's full name. ex: "Edward Stark"
     * receiverTaxId [string]: Receiver's tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * senderAccountNumber [string]: Sender's bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * senderBankCode [string]: Sender's bank institution code in Brazil. ex: "20018183"
     * senderBranchCode [string]: Sender's bank account branch code. Use '-' in case there is a verifier digit. ex: "1357-9"
     * senderTaxId [string]: Sender's tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * type [string]: Subscription journey type. Options: "push", "qrcode", "qrcodeAndPayment", "paymentAndOrQrcode"
     * amount [Long]: Amount in cents to be transferred in every cycle of the subscription. Required if the subscription has a fixed value.
     * amountMinLimit [Long]: The floor value for the maximum amount allowed to be set by the sender when approving the subscription.
     * description [string]: Additional information to be delivered to the sender.
     * due [string]: Due date for answering with an approval or denial. ex: "2020-03-10 10:30:00.000000+00:00"
     * installmentEnd [string]: End of settlements allowed for this Pix Pull Subscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * receiverBankCode [string]: Receiver's bank institution code in Brazil.
     * referenceCode [string]: Represents the commercial relation. It can be a contract number, order identification or client code.
     * pullRetryLimit [Long]: Defines how many times the receiver is able to create Pix Pull Requests for retries. Options: 0 or 3. Default is 3.
     * senderCityCode [string]: IBGE Code of the payer's city.
     * senderFinalName [string]: Sender's final name.
     * senderFinalTaxId [string]: Sender's final tax ID.
     * tags [list of strings]: list of strings for tagging. ex: ["employees", "monthly"]
     * id [string]: Unique id returned when the PixPullSubscription is created. ex: "5656565656565656"
     * status [string]: Current PixPullSubscription status.
     * created [string]: Creation datetime for the PixPullSubscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: Latest update datetime for the PixPullSubscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * flow [string]: Indicates the flow of the Pix Subscription. ex: "in" or "out"
     *
     */
    static ClassData data = new ClassData(PixPullSubscription.class, "PixPullSubscription");

    public String bacenId;
    public String externalId;
    public String installmentStart;
    public String interval;
    public String receiverName;
    public String receiverTaxId;
    public String senderAccountNumber;
    public String senderBankCode;
    public String senderBranchCode;
    public String senderTaxId;
    public String type;
    public Long amount;
    public Long amountMinLimit;
    public String description;
    public String due;
    public String installmentEnd;
    public String receiverBankCode;
    public String referenceCode;
    public Long pullRetryLimit;
    public String senderCityCode;
    public String senderFinalName;
    public String senderFinalTaxId;
    public String[] tags;
    public String status;
    public String created;
    public String updated;
    public String flow;

    /**
     * PixPullSubscription object
     * <p>
     * When you initialize a PixPullSubscription, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param bacenId [string]: Central Bank's unique recurrency id.
     * @param externalId [string]: Safe string that must be unique among all your Pix Pull Subscriptions.
     * @param installmentStart [string]: Start of settlements allowed for this Pix Pull Subscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param interval [string]: Cycle definition of the Pix Pull Requests. Options: "week", "month", "quarter", "semester" or "year"
     * @param receiverName [string]: Receiver's full name. ex: "Edward Stark"
     * @param receiverTaxId [string]: Receiver's tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * @param senderAccountNumber [string]: Sender's bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * @param senderBankCode [string]: Sender's bank institution code in Brazil. ex: "20018183"
     * @param senderBranchCode [string]: Sender's bank account branch code. Use '-' in case there is a verifier digit. ex: "1357-9"
     * @param senderTaxId [string]: Sender's tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * @param type [string]: Subscription journey type. Options: "push", "qrcode", "qrcodeAndPayment", "paymentAndOrQrcode"
     * @param amount [Long, default null]: Amount in cents to be transferred in every cycle of the subscription. Required if the subscription has a fixed value.
     * @param amountMinLimit [Long, default null]: The floor value for the maximum amount allowed to be set by the sender when approving the subscription.
     * @param description [string, default null]: Additional information to be delivered to the sender.
     * @param due [string, default null]: Due date for answering with an approval or denial. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param installmentEnd [string, default null]: End of settlements allowed for this Pix Pull Subscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param receiverBankCode [string, default null]: Receiver's bank institution code in Brazil.
     * @param referenceCode [string]: Represents the commercial relation. It can be a contract number, order identification or client code.
     * @param pullRetryLimit [Long, default null]: Defines how many times the receiver is able to create Pix Pull Requests for retries. Options: 0 or 3. Default is 3.
     * @param senderCityCode [string]: IBGE Code of the payer's city.
     * @param senderFinalName [string, default null]: Sender's final name.
     * @param senderFinalTaxId [string, default null]: Sender's final tax ID.
     * @param tags [list of strings, default null]: list of strings for tagging. ex: ["employees", "monthly"]
     * @param id [string]: Unique id returned when the PixPullSubscription is created. ex: "5656565656565656"
     * @param status [string]: Current PixPullSubscription status.
     * @param created [string]: Creation datetime for the PixPullSubscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: Latest update datetime for the PixPullSubscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param flow [string]: Indicates the flow of the Pix Subscription. ex: "in" or "out"
     */
    public PixPullSubscription(String bacenId, String externalId, String installmentStart, String interval,
                               String receiverName, String receiverTaxId, String senderAccountNumber,
                               String senderBankCode, String senderBranchCode, String senderTaxId, String type,
                               Long amount, Long amountMinLimit, String description, String due,
                               String installmentEnd, String receiverBankCode, String referenceCode,
                               Long pullRetryLimit, String senderCityCode, String senderFinalName,
                               String senderFinalTaxId, String[] tags, String id, String status, String created,
                               String updated, String flow
    ) {
        super(id);
        this.bacenId = bacenId;
        this.externalId = externalId;
        this.installmentStart = installmentStart;
        this.interval = interval;
        this.receiverName = receiverName;
        this.receiverTaxId = receiverTaxId;
        this.senderAccountNumber = senderAccountNumber;
        this.senderBankCode = senderBankCode;
        this.senderBranchCode = senderBranchCode;
        this.senderTaxId = senderTaxId;
        this.type = type;
        this.amount = amount;
        this.amountMinLimit = amountMinLimit;
        this.description = description;
        this.due = due;
        this.installmentEnd = installmentEnd;
        this.receiverBankCode = receiverBankCode;
        this.referenceCode = referenceCode;
        this.pullRetryLimit = pullRetryLimit;
        this.senderCityCode = senderCityCode;
        this.senderFinalName = senderFinalName;
        this.senderFinalTaxId = senderFinalTaxId;
        this.tags = tags;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.flow = flow;
    }

    /**
     * PixPullSubscription object
     * <p>
     * When you initialize a PixPullSubscription, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the PixPullSubscription
     * bacenId [string]: Central Bank's unique recurrency id.
     * externalId [string]: Safe string that must be unique among all your Pix Pull Subscriptions.
     * installmentStart [string]: Start of settlements allowed for this Pix Pull Subscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * interval [string]: Cycle definition of the Pix Pull Requests. Options: "week", "month", "quarter", "semester" or "year"
     * receiverName [string]: Receiver's full name. ex: "Edward Stark"
     * receiverTaxId [string]: Receiver's tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * senderAccountNumber [string]: Sender's bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * senderBankCode [string]: Sender's bank institution code in Brazil. ex: "20018183"
     * senderBranchCode [string]: Sender's bank account branch code. Use '-' in case there is a verifier digit. ex: "1357-9"
     * senderTaxId [string]: Sender's tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * type [string]: Subscription journey type. Options: "push", "qrcode", "qrcodeAndPayment", "paymentAndOrQrcode"
     * <p>
     * Parameters (optional):
     * amount [Long, default null]: Amount in cents to be transferred in every cycle of the subscription. Required if the subscription has a fixed value.
     * amountMinLimit [Long, default null]: The floor value for the maximum amount allowed to be set by the sender when approving the subscription.
     * description [string, default null]: Additional information to be delivered to the sender.
     * due [string, default null]: Due date for answering with an approval or denial. ex: "2020-03-10 10:30:00.000000+00:00"
     * installmentEnd [string, default null]: End of settlements allowed for this Pix Pull Subscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * receiverBankCode [string, default null]: Receiver's bank institution code in Brazil.
     * referenceCode [string]: Represents the commercial relation. It can be a contract number, order identification or client code.
     * pullRetryLimit [Long, default null]: Defines how many times the receiver is able to create Pix Pull Requests for retries. Options: 0 or 3. Default is 3.
     * senderCityCode [string]: IBGE Code of the payer's city.
     * senderFinalName [string, default null]: Sender's final name.
     * senderFinalTaxId [string, default null]: Sender's final tax ID.
     * tags [list of strings, default null]: list of strings for tagging. ex: ["employees", "monthly"]
     * <p>
     * Attributes (return-only):
     * id [string]: Unique id returned when the PixPullSubscription is created. ex: "5656565656565656"
     * status [string]: Current PixPullSubscription status.
     * created [string]: Creation datetime for the PixPullSubscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: Latest update datetime for the PixPullSubscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * flow [string]: Indicates the flow of the Pix Subscription. ex: "in" or "out"
     * @throws Exception error in the request
     */
    public PixPullSubscription(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.bacenId = (String) dataCopy.remove("bacenId");
        this.externalId = (String) dataCopy.remove("externalId");
        this.installmentStart = (String) dataCopy.remove("installmentStart");
        this.interval = (String) dataCopy.remove("interval");
        this.receiverName = (String) dataCopy.remove("receiverName");
        this.receiverTaxId = (String) dataCopy.remove("receiverTaxId");
        this.senderAccountNumber = (String) dataCopy.remove("senderAccountNumber");
        this.senderBankCode = (String) dataCopy.remove("senderBankCode");
        this.senderBranchCode = (String) dataCopy.remove("senderBranchCode");
        this.senderTaxId = (String) dataCopy.remove("senderTaxId");
        this.type = (String) dataCopy.remove("type");
        Object amountRaw = dataCopy.remove("amount");
        this.amount = amountRaw == null ? null : ((Number) amountRaw).longValue();
        Object amountMinLimitRaw = dataCopy.remove("amountMinLimit");
        this.amountMinLimit = amountMinLimitRaw == null ? null : ((Number) amountMinLimitRaw).longValue();
        this.description = (String) dataCopy.remove("description");
        this.due = (String) dataCopy.remove("due");
        this.installmentEnd = (String) dataCopy.remove("installmentEnd");
        this.receiverBankCode = (String) dataCopy.remove("receiverBankCode");
        this.referenceCode = (String) dataCopy.remove("referenceCode");
        Object pullRetryLimitRaw = dataCopy.remove("pullRetryLimit");
        this.pullRetryLimit = pullRetryLimitRaw == null ? null : ((Number) pullRetryLimitRaw).longValue();
        this.senderCityCode = (String) dataCopy.remove("senderCityCode");
        this.senderFinalName = (String) dataCopy.remove("senderFinalName");
        this.senderFinalTaxId = (String) dataCopy.remove("senderFinalTaxId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.status = null;
        this.created = null;
        this.updated = null;
        this.flow = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific PixPullSubscription
     * <p>
     * Receive a single PixPullSubscription object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return PixPullSubscription object with updated attributes
     * @throws Exception error in the request
     */
    public static PixPullSubscription get(String id) throws Exception {
        return PixPullSubscription.get(id, null);
    }

    /**
     * Retrieve a specific PixPullSubscription
     * <p>
     * Receive a single PixPullSubscription object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixPullSubscription object with updated attributes
     * @throws Exception error in the request
     */
    public static PixPullSubscription get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve PixPullSubscriptions
     * <p>
     * Receive a generator of PixPullSubscription objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2022-11-10"
     * status [string, default null]: filter for objects with a given status. ex: "created", "active", "canceled", "failed"
     * tags [list of strings, default null]: filter for objects with a given tag. ex: ["employees", "monthly"]
     * ids [list of strings, default null]: filter for objects with a given id. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of PixPullSubscription objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixPullSubscription> query(Map<String, Object> params) throws Exception {
        return PixPullSubscription.query(params, null);
    }

    /**
     * Retrieve PixPullSubscriptions
     * <p>
     * Receive a generator of PixPullSubscription objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixPullSubscription objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixPullSubscription> query(User user) throws Exception {
        return PixPullSubscription.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PixPullSubscriptions
     * <p>
     * Receive a generator of PixPullSubscription objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of PixPullSubscription objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixPullSubscription> query() throws Exception {
        return PixPullSubscription.query(new HashMap<>(), null);
    }

    /**
     * Retrieve PixPullSubscriptions
     * <p>
     * Receive a generator of PixPullSubscription objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2022-11-10"
     * status [string, default null]: filter for objects with a given status. ex: "created", "active", "canceled", "failed"
     * tags [list of strings, default null]: filter for objects with a given tag. ex: ["employees", "monthly"]
     * ids [list of strings, default null]: filter for objects with a given id. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixPullSubscription objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixPullSubscription> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<PixPullSubscription> subscriptions;
        public String cursor;

        public Page(List<PixPullSubscription> subscriptions, String cursor) {
            this.subscriptions = subscriptions;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged PixPullSubscriptions
     * <p>
     * Receive a list of up to 100 PixPullSubscription objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your subscriptions.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2022-11-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "active", "canceled", "failed"]
     * tags [list of strings, default null]: filter for objects with a given tag. ex: ["employees", "monthly"]
     * ids [list of strings, default null]: filter for objects with a given id. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return PixPullSubscription.Page object:
     * PixPullSubscription.Page.subscriptions: list of PixPullSubscription objects with updated attributes
     * PixPullSubscription.Page.cursor: cursor to retrieve the next page of PixPullSubscription objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged PixPullSubscriptions
     * <p>
     * Receive a list of up to 100 PixPullSubscription objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your subscriptions.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixPullSubscription.Page object:
     * PixPullSubscription.Page.subscriptions: list of PixPullSubscription objects with updated attributes
     * PixPullSubscription.Page.cursor: cursor to retrieve the next page of PixPullSubscription objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PixPullSubscriptions
     * <p>
     * Receive a list of up to 100 PixPullSubscription objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your subscriptions.
     * <p>
     * Return:
     * @return PixPullSubscription.Page object:
     * PixPullSubscription.Page.subscriptions: list of PixPullSubscription objects with updated attributes
     * PixPullSubscription.Page.cursor: cursor to retrieve the next page of PixPullSubscription objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PixPullSubscriptions
     * <p>
     * Receive a list of up to 100 PixPullSubscription objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your subscriptions.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2022-11-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "active", "canceled", "failed"]
     * tags [list of strings, default null]: filter for objects with a given tag. ex: ["employees", "monthly"]
     * ids [list of strings, default null]: filter for objects with a given id. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixPullSubscription.Page object:
     * PixPullSubscription.Page.subscriptions: list of PixPullSubscription objects with updated attributes
     * PixPullSubscription.Page.cursor: cursor to retrieve the next page of PixPullSubscription objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<PixPullSubscription> subscriptions = new ArrayList<>();
        for (SubResource subscription: page.entities) {
            subscriptions.add((PixPullSubscription) subscription);
        }
        return new Page(subscriptions, page.cursor);
    }

    /**
     * Create PixPullSubscriptions
     * <p>
     * Send a list of PixPullSubscription objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param subscriptions [list of PixPullSubscription objects or HashMaps]: list of PixPullSubscription objects to be created in the API
     * <p>
     * Return:
     * @return list of PixPullSubscription objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<PixPullSubscription> create(List<?> subscriptions) throws Exception {
        return PixPullSubscription.create(subscriptions, null);
    }

    /**
     * Create PixPullSubscriptions
     * <p>
     * Send a list of PixPullSubscription objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param subscriptions [list of PixPullSubscription objects or HashMaps]: list of PixPullSubscription objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of PixPullSubscription objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<PixPullSubscription> create(List<?> subscriptions, User user) throws Exception {
        List<PixPullSubscription> subscriptionList = new ArrayList<>();
        for (Object subscription : subscriptions){
            if (subscription instanceof Map){
                subscriptionList.add(new PixPullSubscription((Map<String, Object>) subscription));
                continue;
            }
            if (subscription instanceof PixPullSubscription){
                subscriptionList.add((PixPullSubscription) subscription);
                continue;
            }
            throw new Exception("Unknown type \"" + subscription.getClass() + "\", use PixPullSubscription or HashMap");
        }
        return Rest.post(data, subscriptionList, user);
    }

    /**
     * Cancel a PixPullSubscription
     * <p>
     * Cancel a PixPullSubscription entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: PixPullSubscription unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return canceled PixPullSubscription object
     * @throws Exception error in the request
     */
    public static PixPullSubscription cancel(String id) throws Exception {
        return PixPullSubscription.cancel(id, null, null);
    }

    /**
     * Cancel a PixPullSubscription
     * <p>
     * Cancel a PixPullSubscription entity previously created in the Stark Infra API
     * <p>
     * The reason field accepts one of the following values:
     * "accountClosed", "receiverOrganizationClosed", "subscriptionRequestFailed", "fraud", "receiverUserRequested", "paymentNotFound".
     * <p>
     * Parameters:
     * @param id [string]: PixPullSubscription unique id. ex: "5656565656565656"
     * @param reason [string]: Reason why the Pix Pull Subscription is being canceled. Options: "accountClosed", "receiverOrganizationClosed", "subscriptionRequestFailed", "fraud", "receiverUserRequested", "paymentNotFound"
     * <p>
     * Return:
     * @return canceled PixPullSubscription object
     * @throws Exception error in the request
     */
    public static PixPullSubscription cancel(String id, String reason) throws Exception {
        return PixPullSubscription.cancel(id, reason, null);
    }

    /**
     * Cancel a PixPullSubscription
     * <p>
     * Cancel a PixPullSubscription entity previously created in the Stark Infra API
     * <p>
     * The reason field accepts one of the following values:
     * "accountClosed", "receiverOrganizationClosed", "subscriptionRequestFailed", "fraud", "receiverUserRequested", "paymentNotFound".
     * <p>
     * Parameters:
     * @param id [string]: PixPullSubscription unique id. ex: "5656565656565656"
     * @param reason [string]: Reason why the Pix Pull Subscription is being canceled. Options: "accountClosed", "receiverOrganizationClosed", "subscriptionRequestFailed", "fraud", "receiverUserRequested", "paymentNotFound"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled PixPullSubscription object
     * @throws Exception error in the request
     */
    public static PixPullSubscription cancel(String id, String reason, User user) throws Exception {
        HashMap<String, Object> query = new HashMap<>();
        if (reason != null) query.put("reason", reason);
        return Rest.delete(data, id, query, user);
    }

    /**
     * Update PixPullSubscription entity
     * <p>
     * A Pix Subscription can be patched for three distinct purposes - to update, confirm or deny it.
     * As the receiver, you can approve or deny the subscription if the subscription type is "subscriptionAndPayment".
     * As the sender, you can confirm or deny a delivered subscription.
     * <p>
     * Parameters:
     * @param id [string]: PixPullSubscription id. ex: "5656565656565656"
     * @param patchData map of properties to patch
     * status [string]: New status of the Pix Subscription.
     * senderCityCode [string, conditionally required]: IBGE Code of the payer's city. Required if you are confirming the subscription.
     * reason [string, conditionally required]: Reason why the Pix Subscription is being patched. Options: "accountClosed", "accountBlocked", "invalidBranchCode", "notRecognizedBySender", "userRejected", "notOffered"
     * <p>
     * Return:
     * @return PixPullSubscription object with updated attributes
     * @throws Exception error in the request
     */
    public static PixPullSubscription update(String id, Map<String, Object> patchData) throws Exception {
        return PixPullSubscription.update(id, patchData, null);
    }

    /**
     * Update PixPullSubscription entity
     * <p>
     * A Pix Subscription can be patched for three distinct purposes - to update, confirm or deny it.
     * As the receiver, you can approve or deny the subscription if the subscription type is "subscriptionAndPayment".
     * As the sender, you can confirm or deny a delivered subscription.
     * <p>
     * Parameters:
     * @param id [string]: PixPullSubscription id. ex: "5656565656565656"
     * @param patchData map of patch parameters:
     * status [string]: New status of the Pix Subscription.
     * senderCityCode [string, conditionally required]: IBGE Code of the payer's city. Required if you are confirming the subscription.
     * reason [string, conditionally required]: Reason why the Pix Subscription is being patched. Options: "accountClosed", "accountBlocked", "invalidBranchCode", "notRecognizedBySender", "userRejected", "notOffered"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixPullSubscription object with updated attributes
     * @throws Exception error in the request
     */
    public static PixPullSubscription update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "PixPullSubscriptionLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public String description;
        public String reason;
        public PixPullSubscription subscription;

        /**
         * PixPullSubscription.Log object
         * <p>
         * Every time a PixPullSubscription entity is modified, a corresponding PixPullSubscription.Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param created [string]: creation datetime for the log. ex: "2020-03-29"
         * @param type [string]: type of the PixPullSubscription event which triggered the log creation. ex: "sent", "denied", "failed", "created", "success", "approved", "credited", "refunded", "processing"
         * @param errors [list of ErrorElement]: list of errors linked to this PixPullSubscription event
         * @param description [string]: optional description detail of the event.
         * @param reason [string]: optional reason associated with the event.
         * @param subscription [PixPullSubscription]: PixPullSubscription entity to which the log refers to.
         */
        public Log(String created, String type, List<ErrorElement> errors, String description, String reason,
                   PixPullSubscription subscription, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.description = description;
            this.reason = reason;
            this.subscription = subscription;
        }

        /**
         * Retrieve a specific PixPullSubscription.Log
         * <p>
         * Receive a single PixPullSubscription.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return PixPullSubscription.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific PixPullSubscription.Log
         * <p>
         * Receive a single PixPullSubscription.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixPullSubscription.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve PixPullSubscription.Logs
         * <p>
         * Receive a generator of PixPullSubscription.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2022-11-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["sent", "denied", "failed", "created", "success", "approved", "credited", "refunded", "processing"]
         * subscriptionIds [list of strings, default null]: list of PixPullSubscription IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of PixPullSubscription.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve PixPullSubscription.Logs
         * <p>
         * Receive a generator of PixPullSubscription.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of PixPullSubscription.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve PixPullSubscription.Logs
         * <p>
         * Receive a generator of PixPullSubscription.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of PixPullSubscription.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve PixPullSubscription.Logs
         * <p>
         * Receive a generator of PixPullSubscription.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2022-11-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["sent", "denied", "failed", "created", "success", "approved", "credited", "refunded", "processing"]
         * subscriptionIds [list of strings, default null]: list of PixPullSubscription IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of PixPullSubscription.Log objects with updated attributes
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
         * Retrieve paged PixPullSubscription.Logs
         * <p>
         * Receive a list of up to 100 PixPullSubscription.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your logs.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2022-11-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["sent", "denied", "failed", "created", "success", "approved", "credited", "refunded", "processing"]
         * subscriptionIds [list of strings, default null]: list of PixPullSubscription IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return PixPullSubscription.Log.Page object:
         * PixPullSubscription.Log.Page.logs: list of PixPullSubscription.Log objects with updated attributes
         * PixPullSubscription.Log.Page.cursor: cursor to retrieve the next page of PixPullSubscription.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged PixPullSubscription.Logs
         * <p>
         * Receive a list of up to 100 PixPullSubscription.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your logs.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixPullSubscription.Log.Page object:
         * PixPullSubscription.Log.Page.logs: list of PixPullSubscription.Log objects with updated attributes
         * PixPullSubscription.Log.Page.cursor: cursor to retrieve the next page of PixPullSubscription.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged PixPullSubscription.Logs
         * <p>
         * Receive a list of up to 100 PixPullSubscription.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your logs.
         * <p>
         * Return:
         * @return PixPullSubscription.Log.Page object:
         * PixPullSubscription.Log.Page.logs: list of PixPullSubscription.Log objects with updated attributes
         * PixPullSubscription.Log.Page.cursor: cursor to retrieve the next page of PixPullSubscription.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged PixPullSubscription.Logs
         * <p>
         * Receive a list of up to 100 PixPullSubscription.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your logs.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2022-11-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["sent", "denied", "failed", "created", "success", "approved", "credited", "refunded", "processing"]
         * subscriptionIds [list of strings, default null]: list of PixPullSubscription IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixPullSubscription.Log.Page object:
         * PixPullSubscription.Log.Page.logs: list of PixPullSubscription.Log objects with updated attributes
         * PixPullSubscription.Log.Page.cursor: cursor to retrieve the next page of PixPullSubscription.Log objects
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
