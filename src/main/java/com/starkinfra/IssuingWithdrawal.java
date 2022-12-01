package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IssuingWithdrawal extends Resource {
    /**
     * IssuingWithdrawal object
     * <p>
     * The IssuingWithdrawal objects created in your Workspace return cash from your Issuing balance to your
     * Banking balance
     * <p>
     * When you initialize a IssuingWithdrawal, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * amount [Long]: IssuingWithdrawal value in cents. Minimum = 0 (any value will be accepted). ex: 1234 (= R$ 12.34)
     * externalId [string] IssuingWithdrawal external ID. ex: "12345"
     * description [string]: IssuingWithdrawal description. ex: "sending money back"
     * tags [list of strings, default []]: list of strings for tagging. ex: ["tony", "stark"]
     * id [string]: unique id returned when IssuingWithdrawal is created. ex: "5656565656565656"
     * transactionId [string]: Stark Infra ledger transaction ids linked to this IssuingWithdrawal
     * issuingTransactionId [string]: issuing ledger transaction ids linked to this IssuingWithdrawal
     * updated [string]: latest update datetime for the IssuingWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(IssuingWithdrawal.class, "IssuingWithdrawal");

    public Long amount;
    public String externalId;
    public String description;
    public String[] tags;
    public String transactionId;
    public String issuingTransactionId;
    public String updated;
    public String created;

    /**
     * IssuingWithdrawal object
     * <p>
     * The IssuingWithdrawal objects created in your Workspace return cash from your Issuing balance to your
     * Banking balance.
     * <p>
     * When you initialize a IssuingWithdrawal, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * @param amount [Long]: IssuingWithdrawal value in cents. Minimum = 0 (any value will be accepted). ex: 1234 (= R$ 12.34)
     * @param externalId [string] IssuingWithdrawal external ID. ex: "12345"
     * @param description [string]: IssuingWithdrawal description. ex: "sending money back"
     * @param tags [list of strings, default []]: list of strings for tagging. ex: ["tony", "stark"]
     * @param id [string]: unique id returned when IssuingWithdrawal is created. ex: "5656565656565656"
     * @param transactionId [string]: Stark Infra ledger transaction ids linked to this IssuingWithdrawal
     * @param issuingTransactionId [string]: issuing ledger transaction ids linked to this IssuingWithdrawal
     * @param updated [string]: latest update datetime for the IssuingWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the IssuingWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    IssuingWithdrawal(String id, Long amount, String description, String transactionId, String issuingTransactionId,
                      String externalId, String[] tags, String updated, String created
    ) {
        super(id);
        this.amount = amount;
        this.externalId = externalId;
        this.description = description;
        this.tags = tags;
        this.transactionId = transactionId;
        this.issuingTransactionId = issuingTransactionId;
        this.updated = updated;
        this.created = created;

    }

    /**
     * IssuingWithdrawal object
     * <p>
     * The IssuingWithdrawal objects created in your Workspace return cash from your Issuing balance to your
     * Banking balance.
     * <p>
     * When you initialize a IssuingWithdrawal, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the IssuingWithdrawal
     * amount [Long]: IssuingWithdrawal value in cents. Minimum = 0 (any value will be accepted). ex: 1234 (= R$ 12.34)
     * externalId [string] IssuingWithdrawal external ID. ex: "12345"
     * description [string]: IssuingWithdrawal description. ex: "sending money back"
     * <p>
     * Parameters (optional):
     * tags [list of strings, default []]: list of strings for tagging. ex: ["tony", "stark"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when IssuingWithdrawal is created. ex: "5656565656565656"
     * transactionId [string]: Stark Infra ledger transaction ids linked to this IssuingWithdrawal
     * issuingTransactionId [string]: issuing ledger transaction ids linked to this IssuingWithdrawal
     * updated [string]: latest update datetime for the IssuingWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public IssuingWithdrawal(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.amount = ((Number) dataCopy.remove("amount")).longValue();
        this.externalId = (String) dataCopy.remove("externalId");
        this.description = (String) dataCopy.remove("description");
        this.tags = (String[]) dataCopy.remove("tags");
        this.transactionId = null;
        this.issuingTransactionId = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create an IssuingWithdrawal
     * <p>
     * Send an IssuingWithdrawal object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param withdrawal [IssuingWithdrawal object]: IssuingWithdrawal object to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingWithdrawal object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingWithdrawal create(IssuingWithdrawal withdrawal, User user) throws Exception {
        return Rest.postSingle(data, withdrawal, user);
    }

    /**
     * Create an IssuingWithdrawal
     * <p>
     * Send an IssuingWithdrawal object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param withdrawal [IssuingWithdrawal object]: IssuingWithdrawal object to be created in the API
     * <p>
     * Return:
     * @return IssuingWithdrawal object with updated attributes
     * @throws Exception error in the withdrawal
     */
    public static IssuingWithdrawal create(IssuingWithdrawal withdrawal) throws Exception {
        return IssuingWithdrawal.create(withdrawal, null);
    }

    /**
     * Retrieve a specific IssuingWithdrawal
     * <p>
     * Receive a single IssuingWithdrawal object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingWithdrawal object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingWithdrawal get(String id, User user) throws Exception{
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific IssuingWithdrawal
     * <p>
     * Receive a single IssuingWithdrawal object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingWithdrawal object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingWithdrawal get(String id) throws Exception{
        return Rest.getId(data, id, null);
    }

    /**
     * Retrieve IssuingWithdrawals
     * <p>
     * Receive a generator of IssuingWithdrawal objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * externalIds [list of strings, default []]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * after [date string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingWithdrawal objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingWithdrawal> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IssuingWithdrawals
     * <p>
     * Receive a generator of IssuingWithdrawal objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * externalIds [list of strings, default []]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * after [date string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return generator of IssuingWithdrawal objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingWithdrawal> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IssuingWithdrawals
     * <p>
     * Receive a generator of IssuingWithdrawal objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingWithdrawal objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingWithdrawal> query(User user) throws Exception{
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingWithdrawals
     * <p>
     * Receive a generator of IssuingWithdrawal objects previously created in the Stark Infra API
     * <p>
     * Return:
     * @return generator of IssuingWithdrawal objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingWithdrawal> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IssuingWithdrawal> issuingWithdrawals;
        public String cursor;

        public Page(List<IssuingWithdrawal> issuingWithdrawals, String cursor) {
            this.issuingWithdrawals = issuingWithdrawals;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingWithdrawals
     * <p>
     * Receive a list of up to 100 IssuingWithdrawal objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page purchases.
     * <p>
     * Return:
     * IssuingWithdrawal.Page.withdrawals: list of IssuingWithdrawal objects with updated attributes
     * IssuingWithdrawal.Page.cursor: cursor to retrieve the next page of IssuingWithdrawal objects
     * @throws Exception error in the request
     */
    public static IssuingWithdrawal.Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged IssuingWithdrawals
     * <p>
     * Receive a list of up to 100 IssuingWithdrawal objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page purchases.
     * <p>
     * Parameters:
     * @param params map of parameters
     * limit [integer, default 100]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * externalIds [list of strings, default []]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * after [date string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * <p>
     * Return:
     * IssuingWithdrawal.Page.withdrawals: list of IssuingWithdrawal objects with updated attributes
     * IssuingWithdrawal.Page.cursor: cursor to retrieve the next page of IssuingWithdrawal objects
     * @throws Exception error in the request
     */
    public static IssuingWithdrawal.Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingWithdrawals
     * <p>
     * Receive a list of up to 100 IssuingWithdrawal objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page purchases.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * IssuingWithdrawal.Page.withdrawals: list of IssuingWithdrawal objects with updated attributes
     * IssuingWithdrawal.Page.cursor: cursor to retrieve the next page of IssuingWithdrawal objects
     * @throws Exception error in the request
     */
    public static IssuingWithdrawal.Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingWithdrawals
     * <p>
     * Receive a list of up to 100 IssuingWithdrawal objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page purchases.
     * <p>
     * Parameters:
     * @param params map of parameters
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * externalIds [list of strings, default []]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * after [date string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * IssuingWithdrawal.Page.withdrawals: list of IssuingWithdrawal objects with updated attributes
     * IssuingWithdrawal.Page.cursor: cursor to retrieve the next page of IssuingWithdrawal objects
     * @throws Exception error in the request
     */
    public static IssuingWithdrawal.Page page(Map<String , Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingWithdrawal> issuingWithdrawals = new ArrayList<>();
        for (SubResource issuingWithdrawal: page.entities) {
            issuingWithdrawals.add((IssuingWithdrawal) issuingWithdrawal);
        }
        return new Page(issuingWithdrawals, page.cursor);

    }
}
