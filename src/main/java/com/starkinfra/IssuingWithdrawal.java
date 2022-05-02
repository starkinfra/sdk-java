package com.starkinfra;

import com.starkinfra.utils.SubResource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class IssuingWithdrawal extends Resource {
    /**
     * IssuingWithdrawal object
     * <p>
     * The IssuingWithdrawal objects created in your Workspace return cash from your Issuing balance to your
     * Banking balance.
     * <p>
     * Parameters:
     * amount                   [integer]: IssuingWithdrawal value in cents. Minimum = 0 (any value will be accepted). ex: 1234 (= R$ 12.34)
     * externalId               [string] IssuingWithdrawal external ID. ex: "12345"
     * description              [string]: IssuingWithdrawal description. ex: "sending money back"
     * tags         `           [list of strings, default []]: list of strings for tagging. ex: ["tony", "stark"]
     * id                       [string]: unique id returned when IssuingWithdrawal is created. ex: "5656565656565656"
     * transactionId            [string]: Stark Bank ledger transaction ids linked to this IssuingWithdrawal
     * issuingTransactionId     [string]: issuing ledger transaction ids linked to this IssuingWithdrawal
     * updated                  [string]: latest update datetime for the IssuingWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     * created                  [string]: creation datetime for the IssuingWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(IssuingWithdrawal.class, "IssuingWithdrawal");

    public Number amount;
    public String description;
    public String transactionId;
    public String issuingTransactionId;
    public String externalId;
    public String[] tags;
    public String updated;
    public String created;

    /**
     * IssuingWithdrawal object
     * <p>
     * The IssuingWithdrawal objects created in your Workspace return cash from your Issuing balance to your
     * Banking balance.
     * <p>
     * Parameters:
     * @param amount [integer]: IssuingWithdrawal value in cents. Minimum = 0 (any value will be accepted). ex: 1234 (= R$ 12.34)
     * @param externalId [string] IssuingWithdrawal external ID. ex: "12345"
     * @param description [string]: IssuingWithdrawal description. ex: "sending money back"
     * @param tags [list of strings, default []]: list of strings for tagging. ex: ["tony", "stark"]
     * @param id [string]: unique id returned when IssuingWithdrawal is created. ex: "5656565656565656"
     * @param transactionId [string]: Stark Bank ledger transaction ids linked to this IssuingWithdrawal
     * @param issuingTransactionId [string]: issuing ledger transaction ids linked to this IssuingWithdrawal
     * @param updated [string]: latest update datetime for the IssuingWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the IssuingWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    IssuingWithdrawal(String id, Number amount, String description, String transactionId, String issuingTransactionId, String externalId, String[] tags, String updated, String created){
        super(id);
        this.amount = amount;
        this.description = description;
        this.transactionId = transactionId;
        this.issuingTransactionId = issuingTransactionId;
        this.externalId = externalId;
        this.tags = tags;
        this.updated = updated;
        this.created = created;

    }

    /**
     * IssuingWithdrawal object
     * <p>
     * The IssuingWithdrawal objects created in your Workspace return cash from your Issuing balance to your
     * Banking balance.
     * <p>
     * Parameters:
     * amount [integer]: IssuingWithdrawal value in cents. Minimum = 0 (any value will be accepted). ex: 1234 (= R$ 12.34)
     * externalId [string] IssuingWithdrawal external ID. ex: "12345"
     * description [string]: IssuingWithdrawal description. ex: "sending money back"
     * <p>
     * Parameters (optional):
     * tags [list of strings, default []]: list of strings for tagging. ex: ["tony", "stark"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when IssuingWithdrawal is created. ex: "5656565656565656"
     * transactionId [string]: Stark Bank ledger transaction ids linked to this IssuingWithdrawal
     * issuingTransactionId [string]: issuing ledger transaction ids linked to this IssuingWithdrawal
     * updated [string]: latest update datetime for the IssuingWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */

    @SuppressWarnings("unchecked")
    public IssuingWithdrawal(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.amount = (Number) dataCopy.remove("amount");
        this.description = (String) dataCopy.remove("description");
        this.transactionId = null;
        this.issuingTransactionId = null;
        this.externalId = (String) dataCopy.remove("externalId");
        this.tags = (String[]) dataCopy.remove("tags");
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
     * @param statement [IssuingWithdrawal object]: IssuingWithdrawal object to be created in the API
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return IssuingWithdrawal object with updated attributes
     * @throws Exception error in the statement
     */
    public static IssuingWithdrawal create(IssuingWithdrawal statement, User user) throws Exception {
        return Rest.postSingle(data, statement, user);
    }

    /**
     * Create an IssuingWithdrawal
     * <p>
     * Send an IssuingWithdrawal object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param statement [IssuingWithdrawal object]: IssuingWithdrawal object to be created in the API
     * <p>
     * Return:
     * @return IssuingWithdrawal object with updated attributes
     * @throws Exception error in the statement
     */
    public static IssuingWithdrawal create(IssuingWithdrawal statement) throws Exception {
        return IssuingWithdrawal.create(statement, null);
    }

    /**
     * Retrieve a specific IssuingWithdrawal
     * <p>
     * Receive a single IssuingWithdrawal object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return IssuingWithdrawal object with updated attributes
     * @throws Exception error in the statement
     */
    public static IssuingWithdrawal get(String id, User user) throws Exception{
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific IssuingWithdrawal
     * <p>
     * Receive a single IssuingWithdrawal object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingWithdrawal object with updated attributes
     * @throws Exception error in the statement
     */
    public static IssuingWithdrawal get(String id) throws Exception{
        return Rest.getId(data, id, null);
    }

    /**
     * Retrieve IssuingWithdrawal
     * <p>
     * Receive a generator of IssuingWithdrawal objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters
     * - limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * - externalIds [list of strings, default []]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * - after [date string, default null] date filter for objects created only after specified date. ex: datetime.date(2020, 3, 10)
     * - before [date string, default null] date filter for objects created only before specified date. ex: datetime.date(2020, 3, 10)
     * - tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of IssuingWithdrawals objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Generator<IssuingWithdrawal> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IssuingWithdrawal
     * <p>
     * Receive a generator of IssuingWithdrawal objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters
     * - limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * - externalIds [list of strings, default []]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * - after [date string, default null] date filter for objects created only after specified date. ex: datetime.date(2020, 3, 10)
     * - before [date string, default null] date filter for objects created only before specified date. ex: datetime.date(2020, 3, 10)
     * - tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return generator of IssuingWithdrawals objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Generator<IssuingWithdrawal> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IssuingWithdrawal
     * <p>
     * Receive a generator of IssuingWithdrawal objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of IssuingWithdrawals objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Generator<IssuingWithdrawal> query(User user) throws Exception{
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingWithdrawal
     * <p>
     * Receive a generator of IssuingWithdrawal objects previously created in the Stark Infra API
     * <p>
     * Return:
     * @return generator of IssuingWithdrawals objects with updated attributes
     * @throws Exception error in the statement
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
     * Retrieve IssuingWithdrawal
     * <p>
     * Receive a list of IssuingWithdrawal objects previously created in the Stark Infra API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters
     * - limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * - externalIds [list of strings, default []]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * - after [date string, default null] date filter for objects created only after specified date. ex: datetime.date(2020, 3, 10)
     * - before [date string, default null] date filter for objects created only before specified date. ex: datetime.date(2020, 3, 10)
     * - tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return list of IssuingWithdrawal objects with updated attributes
     *          - cursor to retrieve the next page of IssuingWithdrawal objects
     * @throws Exception error in the statement
     */
    public static IssuingWithdrawal.Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve IssuingWithdrawal
     * <p>
     * Receive a list of IssuingWithdrawal objects previously created in the Stark Infra API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return list of IssuingWithdrawal objects with updated attributes
     *          - cursor to retrieve the next page of IssuingWithdrawal objects
     * @throws Exception error in the statement
     */
    public static IssuingWithdrawal.Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingWithdrawal
     * <p>
     * Receive a list of IssuingWithdrawal objects previously created in the Stark Infra API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters
     * - limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * - externalIds [list of strings, default []]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * - after [date string, default null] date filter for objects created only after specified date. ex: datetime.date(2020, 3, 10)
     * - before [date string, default null] date filter for objects created only before specified date. ex: datetime.date(2020, 3, 10)
     * - tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return list of IssuingWithdrawal objects with updated attributes
     *          - cursor to retrieve the next page of IssuingWithdrawal objects
     * @throws Exception error in the statement
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
