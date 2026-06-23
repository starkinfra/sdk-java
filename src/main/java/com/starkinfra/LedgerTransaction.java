package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class LedgerTransaction extends Resource {
    /**
     * LedgerTransaction object
     * <p>
     * LedgerTransactions are used to track the balance of a given amount by inserting LedgerTransactions to them.
     * They can represent a bank account, a digital wallet, an inventory product, etc.
     * <p>
     * When you initialize a LedgerTransaction, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * amount [Long]: amount of the transaction. ex: 11234
     * ledgerId [string]: id of the Ledger containing the transaction. ex: "5656565656565656"
     * externalId [string]: string that must be unique among all your LedgerTransactions in a single Ledger. ex: "my-internal-id-123456"
     * source [string]: source of the LedgerTransaction. ex: "bank-transfer/123"
     * fee [Long, default null]: fee applied to the LedgerTransaction. ex: 100
     * rules [list of Ledger.Rule objects, default []]: list of Rule objects linked to the LedgerTransaction. Rules are used to overwrite the Ledger's rules for this transaction. ex: [new Ledger.Rule("minimumBalance", 0)]
     * metadata [Hashmap object, default {}]: Hashmap object used to store additional information about the LedgerTransaction object. ex: { "orderId": "123", "orderType": "purchase" }
     * tags [list of strings, default []]: list of strings for reference when searching for LedgerTransactions. ex: ["transfer/123", "savings"]
     * id [string]: unique id returned when the LedgerTransaction is created. ex: "5656565656565656"
     * balance [Long]: Ledger's balance after the transaction. ex: 11234
     * created [string]: creation datetime for the LedgerTransaction. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(LedgerTransaction.class, "LedgerTransaction");

    public Long amount;
    public String ledgerId;
    public String externalId;
    public String source;
    public Long fee;
    public List<Ledger.Rule> rules;
    public HashMap<String, Object> metadata;
    public String[] tags;
    public Long balance;
    public String created;

    /**
     * LedgerTransaction object
     * <p>
     * LedgerTransactions are used to track the balance of a given amount by inserting LedgerTransactions to them.
     * They can represent a bank account, a digital wallet, an inventory product, etc.
     * <p>
     * When you initialize a LedgerTransaction, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * @param amount [Long]: amount of the transaction. ex: 11234
     * @param ledgerId [string]: id of the Ledger containing the transaction. ex: "5656565656565656"
     * @param externalId [string]: string that must be unique among all your LedgerTransactions in a single Ledger. ex: "my-internal-id-123456"
     * @param source [string]: source of the LedgerTransaction. ex: "bank-transfer/123"
     * @param fee [Long, default null]: fee applied to the LedgerTransaction. ex: 100
     * @param rules [list of Ledger.Rule objects, default []]: list of Rule objects linked to the LedgerTransaction. Rules are used to overwrite the Ledger's rules for this transaction. ex: [new Ledger.Rule("minimumBalance", 0)]
     * @param metadata [Hashmap object, default {}]: Hashmap object used to store additional information about the LedgerTransaction object. ex: { "orderId": "123", "orderType": "purchase" }
     * @param tags [list of strings, default []]: list of strings for reference when searching for LedgerTransactions. ex: ["transfer/123", "savings"]
     * @param id [string]: unique id returned when the LedgerTransaction is created. ex: "5656565656565656"
     * @param balance [Long]: Ledger's balance after the transaction. ex: 11234
     * @param created [string]: creation datetime for the LedgerTransaction. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public LedgerTransaction(String id, Long amount, String ledgerId, String externalId, String source, Long fee,
                             List<Ledger.Rule> rules, HashMap<String, Object> metadata, String[] tags, Long balance,
                             String created
    ) {
        super(id);
        this.amount = amount;
        this.ledgerId = ledgerId;
        this.externalId = externalId;
        this.source = source;
        this.fee = fee;
        this.rules = rules;
        this.metadata = metadata;
        this.tags = tags;
        this.balance = balance;
        this.created = created;
    }

    /**
     * LedgerTransaction object
     * <p>
     * LedgerTransactions are used to track the balance of a given amount by inserting LedgerTransactions to them.
     * They can represent a bank account, a digital wallet, an inventory product, etc.
     * <p>
     * When you initialize a LedgerTransaction, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the LedgerTransaction
     * amount [Long]: amount of the transaction. ex: 11234
     * ledgerId [string]: id of the Ledger containing the transaction. ex: "5656565656565656"
     * externalId [string]: string that must be unique among all your LedgerTransactions in a single Ledger. ex: "my-internal-id-123456"
     * source [string]: source of the LedgerTransaction. ex: "bank-transfer/123"
     * <p>
     * Parameters (optional):
     * fee [Long, default null]: fee applied to the LedgerTransaction. ex: 100
     * rules [list of Ledger.Rule objects, default []]: list of Rule objects linked to the LedgerTransaction. Rules are used to overwrite the Ledger's rules for this transaction. ex: [new Ledger.Rule("minimumBalance", 0)]
     * metadata [Hashmap object, default {}]: Hashmap object used to store additional information about the LedgerTransaction object. ex: { "orderId": "123", "orderType": "purchase" }
     * tags [list of strings, default []]: list of strings for reference when searching for LedgerTransactions. ex: ["transfer/123", "savings"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the LedgerTransaction is created. ex: "5656565656565656"
     * balance [Long]: Ledger's balance after the transaction. ex: 11234
     * created [string]: creation datetime for the LedgerTransaction. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public LedgerTransaction(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.amount = ((Number) dataCopy.remove("amount")).longValue();
        this.ledgerId = (String) dataCopy.remove("ledgerId");
        this.externalId = (String) dataCopy.remove("externalId");
        this.source = (String) dataCopy.remove("source");
        Object fee = dataCopy.remove("fee");
        this.fee = fee == null ? null : ((Number) fee).longValue();
        this.rules = Ledger.Rule.parseRules((List<Object>) dataCopy.remove("rules"));
        this.metadata = (HashMap<String, Object>) dataCopy.remove("metadata");
        this.tags = (String[]) dataCopy.remove("tags");
        this.balance = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create LedgerTransactions
     * <p>
     * Send a list of LedgerTransaction objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param transactions [list of LedgerTransaction objects]: list of LedgerTransaction objects to be created in the API
     * <p>
     * Return:
     * @return list of LedgerTransaction objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<LedgerTransaction> create(List<?> transactions) throws Exception {
        return LedgerTransaction.create(transactions, null);
    }

    /**
     * Create LedgerTransactions
     * <p>
     * Send a list of LedgerTransaction objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param transactions [list of LedgerTransaction objects]: list of LedgerTransaction objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of LedgerTransaction objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<LedgerTransaction> create(List<?> transactions, User user) throws Exception {
        List<LedgerTransaction> transactionList = new ArrayList<>();
        for (Object transaction : transactions){
            if (transaction instanceof Map){
                transactionList.add(new LedgerTransaction((Map<String, Object>) transaction));
                continue;
            }
            if (transaction instanceof LedgerTransaction){
                transactionList.add((LedgerTransaction) transaction);
                continue;
            }
            throw new Exception("Unknown type \"" + transaction.getClass() + "\", use LedgerTransaction or HashMap");
        }
        return Rest.post(data, transactionList, user);
    }

    /**
     * Retrieve a specific LedgerTransaction
     * <p>
     * Receive a single LedgerTransaction object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return LedgerTransaction object with updated attributes
     * @throws Exception error in the request
     */
    public static LedgerTransaction get(String id) throws Exception {
        return LedgerTransaction.get(id, null);
    }

    /**
     * Retrieve a specific LedgerTransaction
     * <p>
     * Receive a single LedgerTransaction object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return LedgerTransaction object with updated attributes
     * @throws Exception error in the request
     */
    public static LedgerTransaction get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve LedgerTransactions
     * <p>
     * Receive a generator of LedgerTransaction objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of LedgerTransaction objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<LedgerTransaction> query() throws Exception {
        return LedgerTransaction.query(new HashMap<>(), null);
    }

    /**
     * Retrieve LedgerTransactions
     * <p>
     * Receive a generator of LedgerTransaction objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * ledgerId [string, default null]: id of the Ledger containing the transaction. Either ledgerId or ids must be provided. ex: "5656565656565656"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. Either ledgerId or ids must be provided. ex: ["5656565656565656", "4545454545454545"]
     * flow [string, default null]: direction of the transaction. ex: "in" or "out"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["transfer/123", "savings"]
     * externalIds [list of strings, default null]: list of external ids to filter retrieved objects. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-04-03"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-03"
     * limit [integer, default 100, maximum 1000]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * <p>
     * Return:
     * @return generator of LedgerTransaction objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<LedgerTransaction> query(Map<String, Object> params) throws Exception {
        return LedgerTransaction.query(params, null);
    }

    /**
     * Retrieve LedgerTransactions
     * <p>
     * Receive a generator of LedgerTransaction objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of LedgerTransaction objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<LedgerTransaction> query(User user) throws Exception {
        return LedgerTransaction.query(new HashMap<>(), user);
    }

    /**
     * Retrieve LedgerTransactions
     * <p>
     * Receive a generator of LedgerTransaction objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * ledgerId [string, default null]: id of the Ledger containing the transaction. Either ledgerId or ids must be provided. ex: "5656565656565656"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. Either ledgerId or ids must be provided. ex: ["5656565656565656", "4545454545454545"]
     * flow [string, default null]: direction of the transaction. ex: "in" or "out"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["transfer/123", "savings"]
     * externalIds [list of strings, default null]: list of external ids to filter retrieved objects. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-04-03"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-03"
     * limit [integer, default 100, maximum 1000]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of LedgerTransaction objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<LedgerTransaction> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<LedgerTransaction> transactions;
        public String cursor;

        public Page(List<LedgerTransaction> transactions, String cursor) {
            this.transactions = transactions;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged LedgerTransactions
     * <p>
     * Receive a list of up to 100 LedgerTransaction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return LedgerTransaction.Page object:
     * LedgerTransaction.Page.transactions: list of LedgerTransaction objects with updated attributes
     * LedgerTransaction.Page.cursor: cursor to retrieve the next page of LedgerTransaction objects
     * @throws Exception error in the request
     */
    public static LedgerTransaction.Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged LedgerTransactions
     * <p>
     * Receive a list of up to 100 LedgerTransaction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * ledgerId [string, default null]: id of the Ledger containing the transaction. Either ledgerId or ids must be provided. ex: "5656565656565656"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. Either ledgerId or ids must be provided. ex: ["5656565656565656", "4545454545454545"]
     * flow [string, default null]: direction of the transaction. ex: "in" or "out"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["transfer/123", "savings"]
     * externalIds [list of strings, default null]: list of external ids to filter retrieved objects. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-04-03"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-03"
     * limit [integer, default 100, maximum 1000]: maximum number of objects to be retrieved. ex: 35
     * <p>
     * Return:
     * @return LedgerTransaction.Page object:
     * LedgerTransaction.Page.transactions: list of LedgerTransaction objects with updated attributes
     * LedgerTransaction.Page.cursor: cursor to retrieve the next page of LedgerTransaction objects
     * @throws Exception error in the request
     */
    public static LedgerTransaction.Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged LedgerTransactions
     * <p>
     * Receive a list of up to 100 LedgerTransaction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return LedgerTransaction.Page object:
     * LedgerTransaction.Page.transactions: list of LedgerTransaction objects with updated attributes
     * LedgerTransaction.Page.cursor: cursor to retrieve the next page of LedgerTransaction objects
     * @throws Exception error in the request
     */
    public static LedgerTransaction.Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged LedgerTransactions
     * <p>
     * Receive a list of up to 100 LedgerTransaction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * ledgerId [string, default null]: id of the Ledger containing the transaction. Either ledgerId or ids must be provided. ex: "5656565656565656"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. Either ledgerId or ids must be provided. ex: ["5656565656565656", "4545454545454545"]
     * flow [string, default null]: direction of the transaction. ex: "in" or "out"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["transfer/123", "savings"]
     * externalIds [list of strings, default null]: list of external ids to filter retrieved objects. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-04-03"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-03"
     * limit [integer, default 100, maximum 1000]: maximum number of objects to be retrieved. ex: 35
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return LedgerTransaction.Page object:
     * LedgerTransaction.Page.transactions: list of LedgerTransaction objects with updated attributes
     * LedgerTransaction.Page.cursor: cursor to retrieve the next page of LedgerTransaction objects
     * @throws Exception error in the request
     */
    public static LedgerTransaction.Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<LedgerTransaction> transactions = new ArrayList<>();
        for (SubResource transaction: page.entities) {
            transactions.add((LedgerTransaction) transaction);
        }
        return new Page(transactions, page.cursor);
    }
}
