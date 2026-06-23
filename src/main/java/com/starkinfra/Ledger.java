package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class Ledger extends Resource {
    /**
     * Ledger object
     * <p>
     * Ledgers are used to track the balance of a given amount by inserting LedgerTransactions to them.
     * They can represent a bank account, a digital wallet, an inventory product, etc.
     * <p>
     * When you initialize a Ledger, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * externalId [string]: string that must be unique among all your Ledgers. ex: "my-internal-id-123456"
     * rules [list of Ledger.Rule objects, default []]: list of Rule objects linked to the Ledger. Rules are used to limit the balance of the Ledger. ex: [new Ledger.Rule("minimumBalance", 0)]
     * tags [list of strings, default []]: list of strings for reference when searching for Ledgers. ex: ["account/123", "savings"]
     * metadata [Hashmap object, default {}]: Hashmap object used to store additional information about the Ledger object. ex: { "accountId": "123", "accountType": "savings" }
     * id [string]: unique id returned when the Ledger is created. ex: "5656565656565656"
     * created [string]: creation datetime for the Ledger. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the Ledger. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(Ledger.class, "Ledger");

    public String externalId;
    public List<Ledger.Rule> rules;
    public String[] tags;
    public HashMap<String, Object> metadata;
    public String created;
    public String updated;

    /**
     * Ledger object
     * <p>
     * Ledgers are used to track the balance of a given amount by inserting LedgerTransactions to them.
     * They can represent a bank account, a digital wallet, an inventory product, etc.
     * <p>
     * When you initialize a Ledger, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * @param externalId [string]: string that must be unique among all your Ledgers. ex: "my-internal-id-123456"
     * @param rules [list of Ledger.Rule objects, default []]: list of Rule objects linked to the Ledger. Rules are used to limit the balance of the Ledger. ex: [new Ledger.Rule("minimumBalance", 0)]
     * @param tags [list of strings, default []]: list of strings for reference when searching for Ledgers. ex: ["account/123", "savings"]
     * @param metadata [Hashmap object, default {}]: Hashmap object used to store additional information about the Ledger object. ex: { "accountId": "123", "accountType": "savings" }
     * @param id [string]: unique id returned when the Ledger is created. ex: "5656565656565656"
     * @param created [string]: creation datetime for the Ledger. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the Ledger. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public Ledger(String id, String externalId, List<Ledger.Rule> rules, String[] tags, HashMap<String, Object> metadata,
                  String created, String updated
    ) {
        super(id);
        this.externalId = externalId;
        this.rules = rules;
        this.tags = tags;
        this.metadata = metadata;
        this.created = created;
        this.updated = updated;
    }

    /**
     * Ledger object
     * <p>
     * Ledgers are used to track the balance of a given amount by inserting LedgerTransactions to them.
     * They can represent a bank account, a digital wallet, an inventory product, etc.
     * <p>
     * When you initialize a Ledger, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the Ledger
     * externalId [string]: string that must be unique among all your Ledgers. ex: "my-internal-id-123456"
     * <p>
     * Parameters (optional):
     * rules [list of Ledger.Rule objects, default []]: list of Rule objects linked to the Ledger. Rules are used to limit the balance of the Ledger. ex: [new Ledger.Rule("minimumBalance", 0)]
     * tags [list of strings, default []]: list of strings for reference when searching for Ledgers. ex: ["account/123", "savings"]
     * metadata [Hashmap object, default {}]: Hashmap object used to store additional information about the Ledger object. ex: { "accountId": "123", "accountType": "savings" }
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the Ledger is created. ex: "5656565656565656"
     * created [string]: creation datetime for the Ledger. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the Ledger. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public Ledger(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.externalId = (String) dataCopy.remove("externalId");
        this.rules = Ledger.Rule.parseRules((List<Object>) dataCopy.remove("rules"));
        this.tags = (String[]) dataCopy.remove("tags");
        this.metadata = (HashMap<String, Object>) dataCopy.remove("metadata");
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create Ledgers
     * <p>
     * Send a list of Ledger objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param ledgers [list of Ledger objects]: list of Ledger objects to be created in the API
     * <p>
     * Return:
     * @return list of Ledger objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<Ledger> create(List<?> ledgers) throws Exception {
        return Ledger.create(ledgers, null);
    }

    /**
     * Create Ledgers
     * <p>
     * Send a list of Ledger objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param ledgers [list of Ledger objects]: list of Ledger objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of Ledger objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<Ledger> create(List<?> ledgers, User user) throws Exception {
        List<Ledger> ledgerList = new ArrayList<>();
        for (Object ledger : ledgers){
            if (ledger instanceof Map){
                ledgerList.add(new Ledger((Map<String, Object>) ledger));
                continue;
            }
            if (ledger instanceof Ledger){
                ledgerList.add((Ledger) ledger);
                continue;
            }
            throw new Exception("Unknown type \"" + ledger.getClass() + "\", use Ledger or HashMap");
        }
        return Rest.post(data, ledgerList, user);
    }

    /**
     * Retrieve a specific Ledger
     * <p>
     * Receive a single Ledger object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return Ledger object with updated attributes
     * @throws Exception error in the request
     */
    public static Ledger get(String id) throws Exception {
        return Ledger.get(id, null);
    }

    /**
     * Retrieve a specific Ledger
     * <p>
     * Receive a single Ledger object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Ledger object with updated attributes
     * @throws Exception error in the request
     */
    public static Ledger get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve Ledgers
     * <p>
     * Receive a generator of Ledger objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of Ledger objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Ledger> query() throws Exception {
        return Ledger.query(new HashMap<>(), null);
    }

    /**
     * Retrieve Ledgers
     * <p>
     * Receive a generator of Ledger objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-04-03"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-03"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: list of external ids to filter retrieved objects. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["account/123", "savings"]
     * <p>
     * Return:
     * @return generator of Ledger objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Ledger> query(Map<String, Object> params) throws Exception {
        return Ledger.query(params, null);
    }

    /**
     * Retrieve Ledgers
     * <p>
     * Receive a generator of Ledger objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Ledger objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Ledger> query(User user) throws Exception {
        return Ledger.query(new HashMap<>(), user);
    }

    /**
     * Retrieve Ledgers
     * <p>
     * Receive a generator of Ledger objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-04-03"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-03"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: list of external ids to filter retrieved objects. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["account/123", "savings"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Ledger objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Ledger> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<Ledger> ledgers;
        public String cursor;

        public Page(List<Ledger> ledgers, String cursor) {
            this.ledgers = ledgers;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged Ledgers
     * <p>
     * Receive a list of up to 100 Ledger objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return Ledger.Page object:
     * Ledger.Page.ledgers: list of Ledger objects with updated attributes
     * Ledger.Page.cursor: cursor to retrieve the next page of Ledger objects
     * @throws Exception error in the request
     */
    public static Ledger.Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged Ledgers
     * <p>
     * Receive a list of up to 100 Ledger objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-04-03"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-03"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: list of external ids to filter retrieved objects. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["account/123", "savings"]
     * <p>
     * Return:
     * @return Ledger.Page object:
     * Ledger.Page.ledgers: list of Ledger objects with updated attributes
     * Ledger.Page.cursor: cursor to retrieve the next page of Ledger objects
     * @throws Exception error in the request
     */
    public static Ledger.Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged Ledgers
     * <p>
     * Receive a list of up to 100 Ledger objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Ledger.Page object:
     * Ledger.Page.ledgers: list of Ledger objects with updated attributes
     * Ledger.Page.cursor: cursor to retrieve the next page of Ledger objects
     * @throws Exception error in the request
     */
    public static Ledger.Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged Ledgers
     * <p>
     * Receive a list of up to 100 Ledger objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-04-03"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-03"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: list of external ids to filter retrieved objects. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["account/123", "savings"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Ledger.Page object:
     * Ledger.Page.ledgers: list of Ledger objects with updated attributes
     * Ledger.Page.cursor: cursor to retrieve the next page of Ledger objects
     * @throws Exception error in the request
     */
    public static Ledger.Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<Ledger> ledgers = new ArrayList<>();
        for (SubResource ledger: page.entities) {
            ledgers.add((Ledger) ledger);
        }
        return new Page(ledgers, page.cursor);
    }

    /**
     * Update Ledger entity
     * <p>
     * Update a Ledger by passing id.
     * <p>
     * Parameters:
     * @param id [string]: Ledger id. ex: "5656565656565656"
     * @param patchData map of parameters
     * rules [list of Ledger.Rule objects or HashMaps, default null]: list of Rule objects linked to the Ledger. Rules are used to limit the balance of the Ledger. ex: [new Ledger.Rule("minimumBalance", 0)]
     * tags [list of strings, default null]: list of strings for reference when searching for Ledgers. ex: ["account/123", "savings"]
     * metadata [Hashmap object, default null]: Hashmap object used to store additional information about the Ledger object. ex: { "accountId": "123", "accountType": "savings" }
     * <p>
     * Return:
     * @return target Ledger with updated attributes
     * @throws Exception error in the request
     */
    public static Ledger update(String id, Map<String, Object> patchData) throws Exception {
        return Ledger.update(id, patchData, null);
    }

    /**
     * Update Ledger entity
     * <p>
     * Update a Ledger by passing id.
     * <p>
     * Parameters:
     * @param id [string]: Ledger id. ex: "5656565656565656"
     * @param patchData map of parameters
     * rules [list of Ledger.Rule objects or HashMaps, default null]: list of Rule objects linked to the Ledger. Rules are used to limit the balance of the Ledger. ex: [new Ledger.Rule("minimumBalance", 0)]
     * tags [list of strings, default null]: list of strings for reference when searching for Ledgers. ex: ["account/123", "savings"]
     * metadata [Hashmap object, default null]: Hashmap object used to store additional information about the Ledger object. ex: { "accountId": "123", "accountType": "savings" }
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return target Ledger with updated attributes
     * @throws Exception error in the request
     */
    public static Ledger update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    public final static class Rule extends SubResource {
        /**
         * Ledger.Rule object
         * <p>
         * The Ledger.Rule object modifies the behavior of Ledger objects when passed as an argument upon their creation or update.
         * <p>
         * Parameters:
         * key [string]: Rule to be customized, describes what Ledger behavior will be altered. ex: "minimumBalance", "maximumBalance"
         * value [integer]: Value of the rule. ex: 1000
         *
         */
        static SubResource.ClassData data = new SubResource.ClassData(Ledger.Rule.class, "Rule");

        public String key;
        public Number value;

        /**
         * Ledger.Rule object
         * <p>
         * The Ledger.Rule object modifies the behavior of Ledger objects when passed as an argument upon their creation or update.
         * <p>
         * Parameters:
         * @param key [string]: Rule to be customized, describes what Ledger behavior will be altered. ex: "minimumBalance", "maximumBalance"
         * @param value [integer]: Value of the rule. ex: 1000
         */
        public Rule(String key, Number value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Ledger.Rule object
         * <p>
         * The Ledger.Rule object modifies the behavior of Ledger objects when passed as an argument upon their creation or update.
         * <p>
         * Parameters (required):
         * @param data map of properties for the creation of the Ledger.Rule
         * key [string]: Rule to be customized, describes what Ledger behavior will be altered. ex: "minimumBalance", "maximumBalance"
         * value [integer]: Value of the rule. ex: 1000
         * @throws Exception error in the request
         */
        public Rule(Map<String, Object> data) throws Exception {
            HashMap<String, Object> dataCopy = new HashMap<>(data);

            this.key = (String) dataCopy.remove("key");
            this.value = (Number) dataCopy.remove("value");

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }

        @SuppressWarnings("unchecked")
        static List<Ledger.Rule> parseRules(List<Object> rules) throws Exception {
            if (rules == null)
                return null;

            List<Ledger.Rule> parsed = new ArrayList<>();
            if (rules.size() == 0 || rules.get(0) instanceof Ledger.Rule) {
                for (Object rule : rules) {
                    parsed.add((Ledger.Rule) rule);
                }
                return parsed;
            }

            for (Object rule : rules) {
                Ledger.Rule ruleObject = new Ledger.Rule((Map<String, Object>) rule);
                parsed.add(ruleObject);
            }

            return parsed;
        }
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Ledger.Log.class, "LedgerLog");

        public String created;
        public String type;
        public Ledger ledger;

        /**
         * Ledger Log object
         * <p>
         * Every time a Ledger entity is updated, a corresponding Ledger Log
         * is generated for the entity. This log is never generated by the
         * user, but it can be retrieved to check additional information
         * on the Ledger.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         * @param type [string]: type of the Ledger event which triggered the log creation. ex: "created" or "updated"
         * @param ledger [Ledger]: Ledger entity to which the log refers to.
         */
        public Log(String created, String type, Ledger ledger, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.ledger = ledger;
        }

        /**
         * Retrieve a specific Ledger Log
         * <p>
         * Receive a single Ledger Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return Ledger Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Ledger.Log get(String id) throws Exception {
            return Ledger.Log.get(id, null);
        }

        /**
         * Retrieve a specific Ledger Log
         * <p>
         * Receive a single Ledger Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return Ledger Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Ledger.Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve Ledger Logs
         * <p>
         * Receive a generator of Ledger.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of Ledger Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Ledger.Log> query() throws Exception {
            return Ledger.Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve Ledger Logs
         * <p>
         * Receive a generator of Ledger.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * ledgerId [string, default null]: filter logs by Ledger id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return generator of Ledger Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Ledger.Log> query(Map<String, Object> params) throws Exception {
            return Ledger.Log.query(params, null);
        }

        /**
         * Retrieve Ledger Logs
         * <p>
         * Receive a generator of Ledger.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of Ledger Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Ledger.Log> query(User user) throws Exception {
            return Ledger.Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve Ledger Logs
         * <p>
         * Receive a generator of Ledger.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * ledgerId [string, default null]: filter logs by Ledger id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of Ledger Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Ledger.Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<Ledger.Log> logs;
            public String cursor;

            public Page(List<Ledger.Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged Ledger.Logs
         * <p>
         * Receive a list of up to 100 Ledger.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return Ledger.Log.Page object:
         * Ledger.Log.Page.logs: list of Ledger.Log objects with updated attributes
         * Ledger.Log.Page.cursor: cursor to retrieve the next page of Ledger.Log objects
         * @throws Exception error in the request
         */
        public static Ledger.Log.Page page() throws Exception {
            return Ledger.Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged Ledger.Logs
         * <p>
         * Receive a list of up to 100 Ledger.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * ledgerId [string, default null]: filter logs by Ledger id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return Ledger.Log.Page object:
         * Ledger.Log.Page.logs: list of Ledger.Log objects with updated attributes
         * Ledger.Log.Page.cursor: cursor to retrieve the next page of Ledger.Log objects
         * @throws Exception error in the request
         */
        public static Ledger.Log.Page page(Map<String, Object> params) throws Exception {
            return Ledger.Log.page(params, null);
        }

        /**
         * Retrieve paged Ledger.Logs
         * <p>
         * Receive a list of up to 100 Ledger.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return Ledger.Log.Page object:
         * Ledger.Log.Page.logs: list of Ledger.Log objects with updated attributes
         * Ledger.Log.Page.cursor: cursor to retrieve the next page of Ledger.Log objects
         * @throws Exception error in the request
         */
        public static Ledger.Log.Page page(User user) throws Exception {
            return Ledger.Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged Ledger.Logs
         * <p>
         * Receive a list of up to 100 Ledger.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * ledgerId [string, default null]: filter logs by Ledger id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return Ledger.Log.Page object:
         * Ledger.Log.Page.logs: list of Ledger.Log objects with updated attributes
         * Ledger.Log.Page.cursor: cursor to retrieve the next page of Ledger.Log objects
         * @throws Exception error in the request
         */
        public static Ledger.Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<Ledger.Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Ledger.Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }
}
