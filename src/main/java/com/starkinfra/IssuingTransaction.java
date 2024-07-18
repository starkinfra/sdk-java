package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IssuingTransaction extends Resource {
    /**
     * IssuingTransaction object
     * <p>
     * The IssuingTransaction objects created in your Workspace to represent each balance shift.
     * <p>
     * Parameters:
     * id [string]: unique id returned when IssuingTransaction is created. ex: "5656565656565656"
     * amount [Long]: IssuingTransaction value in cents. ex: 1234 (= R$ 12.34)
     * balance [Long]: balance amount of the workspace at the instant of the Transaction in cents. ex: 200 (= R$ 2.00)
     * description [string]: IssuingTransaction description. ex: "Buying food"
     * source [string]: source of the transaction. ex: "issuing-purchase/5656565656565656"
     * tags [string]: list of strings inherited from the source resource. ex: ["tony", "stark"]
     * created [string]: creation datetime for the IssuingTransaction. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(IssuingTransaction.class, "IssuingTransaction");

    public Long amount;
    public Long balance;
    public String description;
    public String source;
    public String[] tags;
    public String created;

    /**
     * IssuingTransaction object
     * <p>
     * The IssuingTransaction objects created in your Workspace to represent each balance shift.
     * <p>
     * Parameters:
     * @param id [string]: unique id returned when IssuingTransaction is created. ex: "5656565656565656"
     * @param amount [Long]: IssuingTransaction value in cents. ex: 1234 (= R$ 12.34)
     * @param balance [Long]: balance amount of the workspace at the instant of the Transaction in cents. ex: 200 (= R$ 2.00)
     * @param description [string]: IssuingTransaction description. ex: "Buying food"
     * @param source [string]: source of the transaction. ex: "issuing-purchase/5656565656565656"
     * @param tags [string]: list of strings inherited from the source resource. ex: ["tony", "stark"]
     * @param created [string]: creation datetime for the IssuingTransaction. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingTransaction(String id, Long amount, Long balance, String description,
                              String source, String[] tags, String created
    ) {
        super(id);
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        this.source = source;
        this.tags = tags;
        this.created = created;
    }

    /**
     * IssuingTransaction object
     * <p>
     * The IssuingTransaction objects created in your Workspace to represent each balance shift.
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when IssuingTransaction is created. ex: "5656565656565656"
     * amount [Long]: IssuingTransaction value in cents. ex: 1234 (= R$ 12.34)
     * balance [Long]: balance amount of the workspace at the instant of the Transaction in cents. ex: 200 (= R$ 2.00)
     * description [string]: IssuingTransaction description. ex: "Buying food"
     * source [string]: source of the transaction. ex: "issuing-purchase/5656565656565656"
     * tags [string]: list of strings inherited from the source resource. ex: ["tony", "stark"]
     * created [string]: creation datetime for the IssuingTransaction. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public IssuingTransaction(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.amount = null;
        this.balance = null;
        this.description = null;
        this.source = null;
        this.tags = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific IssuingTransaction
     * <p>
     * Receive a single IssuingTransaction object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingTransaction object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingTransaction get(String id, User user) throws Exception{
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific IssuingTransaction
     * <p>
     * Receive a single IssuingTransaction object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingTransaction object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingTransaction get(String id) throws Exception{
        return Rest.getId(data, id, null);
    }

    /**
     * Retrieve a specific IssuingTransaction
     * <p>
     * Receive a single IssuingTransaction object previously created in the Stark Infra API by its id
     * <p>
     * Return:
     * @return IssuingTransaction object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingTransaction get() throws Exception{
        return Rest.getId(data, null, null);
    }

    /**
     * Retrieve IssuingTransaction
     * <p>
     * Receive a generator of IssuingTransaction objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * externalIds [list of strings, default []]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default ""]: filter for status of retrieved objects. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * ids [list of strings, default []]: transaction IDs
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingTransaction objects with updated attributes
     * @throws Exception error in the transaction
     */
    public static Generator<IssuingTransaction> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }
    /**
     * Retrieve IssuingTransaction
     * <p>
     * Receive a generator of IssuingTransaction objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * externalIds [list of strings, default []]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default ""]: filter for status of retrieved objects. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * ids [list of strings, default []]: transaction IDs
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * <p>
     * Return:
     * @return generator of IssuingTransaction objects with updated attributes
     * @throws Exception error in the transaction
     */
    public static Generator<IssuingTransaction> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IssuingTransactions
     * <p>
     * Receive a generator of IssuingTransaction objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingTransaction objects with updated attributes
     * @throws Exception error in the transaction
     */
    public static Generator<IssuingTransaction> query(User user) throws Exception{
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingTransactions
     * <p>
     * Receive a generator of IssuingTransaction objects previously created in the Stark Infra API
     * <p>
     * Return:
     * @return generator of IssuingTransaction objects with updated attributes
     * @throws Exception error in the transaction
     */
    public static Generator<IssuingTransaction> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IssuingTransaction> issuingTransactions;
        public String cursor;

        public Page(List<IssuingTransaction> issuingTransactions, String cursor) {
            this.issuingTransactions = issuingTransactions;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingTransactions
     * <p>
     * Receive a list of up to 100 IssuingTransaction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page transactions.
     * <p>
     * Return:
     * IssuingTransaction.Page.transactions: list of IssuingTransaction objects with updated attributes
     * IssuingTransaction.Page.cursor: cursor to retrieve the next page of IssuingTransaction objects
     * @throws Exception error in the request
     */
    public static IssuingTransaction.Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged IssuingTransactions
     * <p>
     * Receive a list of up to 100 IssuingTransaction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page transactions.
     * <p>
     * Parameters:
     * @param params map of parameters
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * externalIds [list of strings, default []]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * status [string, default ""]: filter for status of retrieved objects. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * ids [list of strings, default []]: transaction IDs
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * cursor [string, default null]: cursor returned on the previous page function call
     * <p>
     * Return:
     * IssuingTransaction.Page.transactions: list of IssuingTransaction objects with updated attributes
     * IssuingTransaction.Page.cursor: cursor to retrieve the next page of IssuingTransaction objects
     * @throws Exception error in the request
     */
    public static IssuingTransaction.Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingTransactions
     * <p>
     * Receive a list of up to 100 IssuingTransaction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page transactions.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * IssuingTransaction.Page.transactions: list of IssuingTransaction objects with updated attributes
     * IssuingTransaction.Page.cursor: cursor to retrieve the next page of IssuingTransaction objects
     * @throws Exception error in the request
     */
    public static IssuingTransaction.Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingTransactions
     * <p>
     * Receive a list of up to 100 IssuingTransaction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page transactions.
     * <p>
     * Parameters:
     * @param params map of parameters
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * externalIds [list of strings, default []]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * status [string, default ""]: filter for status of retrieved objects. ex: "approved", "canceled", "denied", "confirmed" or "voided"
     * ids [list of strings, default []]: transaction IDs
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * cursor [string, default null]: cursor returned on the previous page function call
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * IssuingTransaction.Page.transactions: list of IssuingTransaction objects with updated attributes
     * IssuingTransaction.Page.cursor: cursor to retrieve the next page of IssuingTransaction objects
     * @throws Exception error in the request
     */
    public static IssuingTransaction.Page page(Map<String , Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingTransaction> issuingTransactions = new ArrayList<>();
        for (SubResource issuingTransaction: page.entities) {
            issuingTransactions.add((IssuingTransaction) issuingTransaction);
        }
        return new Page(issuingTransactions, page.cursor);

    }
}
