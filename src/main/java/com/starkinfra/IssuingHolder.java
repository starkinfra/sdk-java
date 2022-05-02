package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.SubResource;
import com.starkinfra.error.ErrorElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class IssuingHolder extends Resource {
    /**
     * IssuingHolder object
     * <p>
     * The IssuingHolder describes a card holder that may group several cards.
     * <p>
     * Parameters:
     * name         [string]: card holder name.
     * taxId        [string]: card holder tax ID
     * externalId   [string]: card holder external ID
     * rules        [list of IssuingRule or HashMap, default []]: [EXPANDABLE] list of holder spending rules
     * tags         [list of strings, default []]: list of strings for tagging. ex: ["travel", "food"]
     * id           [string]: unique id returned when IssuingHolder is created. ex: "5656565656565656"
     * status       [string]: current IssuingHolder status. ex: "active", "blocked" or "canceled"
     * updated      [string]: latest update datetime for the IssuingHolder. ex: "2020-03-10 10:30:00.000000+00:00"
     * created      [string]: creation datetime for the IssuingHolder. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(IssuingHolder.class, "IssuingHolder");

    public String name;
    public String taxId;
    public String externalId;
    public String status;
    public List<IssuingRule> rules;
    public String[] tags;
    public String updated;
    public String created;

    /**
     * IssuingHolder object
     * <p>
     * The IssuingHolder describes a card holder that may group several cards.
     * <p>
     * Parameters:
     * @param name          [string]: card holder name.
     * @param taxId         [string]: card holder tax ID
     * @param externalId    [string] card holder external ID
     * @param rules         [list of IssuingRule or HashMap, default []]: [EXPANDABLE] list of holder spending rules
     * @param tags          [list of strings, default []]: list of strings for tagging. ex: ["travel", "food"]
     * @param id            [string]: unique id returned when IssuingHolder is created. ex: "5656565656565656"
     * @param status        [string]: current IssuingHolder status. ex: "active", "blocked" or "canceled"
     * @param updated       [string]: latest update datetime for the IssuingHolder. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created       [string]: creation datetime for the IssuingHolder. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingHolder(String id, String name, String taxId, String externalId, String status, List<IssuingRule> rules,
                         String[] tags, String updated, String created){
        super(id);
        this.name = name;
        this.taxId = taxId;
        this.externalId = externalId;
        this.status = status;
        this.rules = rules;
        this.tags = tags;
        this.updated = updated;
        this.created = created;
    }

    /**
     * IssuingHolder object
     * <p>
     * The IssuingHolder describes a card holder that may group several cards.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the PixRequest
     * name [string]: card holder name.
     * taxId [string]: card holder tax ID
     * externalId [string] card holder external ID
     * <p>
     * Parameters (optional):
     * rules [list of IssuingRule or HashMap, default []]: [EXPANDABLE] list of holder spending rules
     * tags [list of strings, default []]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when IssuingHolder is created. ex: "5656565656565656"
     * status [string]: current IssuingHolder status. ex: "active", "blocked" or "canceled"
     * updated [string]: latest update datetime for the IssuingHolder. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingHolder. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public IssuingHolder(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.name = (String) dataCopy.remove("name");
        this.taxId = (String) dataCopy.remove("taxId");
        this.externalId = (String) dataCopy.remove("externalId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.rules = parseRules((List<Object>) dataCopy.remove("rules"));
        this.status = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    @SuppressWarnings("unchecked")
    private List<IssuingRule> parseRules(List<Object> rules){
        if (rules == null)
            return null;

        List<IssuingRule> parsed = new ArrayList<>();
        if (rules.size() == 0 || rules.get(0) instanceof IssuingRule) {
            for (Object rule : rules) {
                parsed.add((IssuingRule) rule);
            }
            return parsed;
        }

        for (Object rule : rules) {
            IssuingRule ruleObject = new IssuingRule(
                (String) ((Map<String, Object>) rule).get("id"),
                (String) ((Map<String, Object>) rule).get("name"),
                ((Long) ((Map<String, Object>) rule).get("amount")),
                (String) ((Map<String, Object>) rule).get("interval"),
                (String) ((Map<String, Object>) rule).get("currencyCode"),
                (String[]) ((Map<String, Object>) rule).get("categories"),
                (String[]) ((Map<String, Object>) rule).get("countries"),
                (String[]) ((Map<String, Object>) rule).get("methods"),
                ((Long) ((Map<String, Object>) rule).get("counterAmount")),
                (String) ((Map<String, Object>) rule).get("currencySymbol"),
                (String) ((Map<String, Object>) rule).get("currencyName")
            );
            parsed.add(ruleObject);
        }

        return parsed;
    }

    /**
     * Create IssuingHolder
     * <p>
     * Send a list of IssuingHolder objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param holders [list of IssuingHolder objects]: list of IssuingHolder objects to be created in the API
     * Return:
     * @return list of IssuingHolder objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<IssuingHolder> create(List<?> holders) throws Exception {
        return IssuingHolder.create(holders, null);
    }

    /**
     * Create IssuingHolder
     * <p>
     * Send a list of IssuingHolder objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param holders [list of IssuingHolder objects]: list of IssuingHolder objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.user was set before function call
     * Return:
     * @return list of IssuingHolder objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<IssuingHolder> create(List<?> holders, User user) throws Exception {
        List<IssuingHolder> holderList = new ArrayList<>();
        for (Object holder : holders){
            if (holder instanceof Map){
                holderList.add(new IssuingHolder((Map<String, Object>) holder));
                continue;
            }
            if (holder instanceof IssuingHolder){
                holderList.add((IssuingHolder) holder);
                continue;
            }
            throw new Exception("Unknown type \"" + holder.getClass() + "\", use IssuingHolder or HashMap");
        }
        return Rest.post(data, holderList, user);
    }

    /**
     * Retrieve a specific IssuingHolder
     * <p>
     * Receive a single IssuingHolder object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.user was set before function call
     * Return:
     * @return IssuingHolder object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingHolder get(String id, User user) throws Exception{

        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific IssuingHolder
     * <p>
     * Receive a single IssuingHolder object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * Return:
     * @return IssuingHolder object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingHolder get(String id) throws Exception{
        return Rest.getId(data, id, null);
    }

    /**
     * Retrieve a specific IssuingHolder
     * <p>
     * Receive a single IssuingHolder object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param params map of parameters
     * id [string]: object unique id. ex: "5656565656565656"
     * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return  IssuingHolder object with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingHolder> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve a specific IssuingHolder
     * <p>
     * Receive a single IssuingHolder object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param params map of parameters
     * id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return  IssuingHolder object with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingHolder> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve a specific IssuingHolder
     * <p>
     * Receive a single IssuingHolder object previously created in the Stark Infra API by its id
     * <p>
     * Return:
     * @return  IssuingHolder object with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingHolder> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IssuingHolder> holders;
        public String cursor;

        public Page(List<IssuingHolder> holders, String cursor) {
            this.holders = holders;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve IssuingHolders
     * <p>
     * Receive a generator of IssuingHolder objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [date string, default null] date filter for objects created only after specified date. ex: datetime.date(2020, 3, 10)
     * before [date string, default null] date filter for objects created only before specified date. ex: datetime.date(2020, 3, 10)
     * status [string, default ""]: filter for status of retrieved objects. ex: "paid" or "registered"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * expand [list of strings, default null]: fields to expand information. ex: ["rules"]
     * <p>
     * Return:
     * @return  IssuingHolder object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingHolder.Page page(Map<String , Object> params) throws Exception {

        return page(params, null);
    }

    /**
     * Retrieve IssuingHolders
     * <p>
     * Receive a generator of IssuingHolder objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return  IssuingHolder object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingHolder.Page page(User user) throws Exception {

        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingHolders
     * <p>
     * Receive a generator of IssuingHolder objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [date string, default null] date filter for objects created only after specified date. ex: datetime.date(2020, 3, 10)
     * before [date string, default null] date filter for objects created only before specified date. ex: datetime.date(2020, 3, 10)
     * status [string, default ""]: filter for status of retrieved objects. ex: "paid" or "registered"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * expand [list of strings, default null]: fields to expand information. ex: ["rules"]
     * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return  IssuingHolder object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingHolder.Page page(Map<String , Object> params, User user) throws Exception {

        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingHolder> holders = new ArrayList<>();
        for (SubResource holder: page.entities) {
            holders.add((IssuingHolder) holder);
        }
        return new Page(holders, page.cursor);

    }

    /**
     * Update IssuingHolder entity
     * <p>
     * Update an IssuingHolder by passing id, if it hasn't been paid yet.
     * <p>
     * Parameters:
     * @param id [string]: IssuingHolder id. ex: '5656565656565656'
     * @param patchData map of parameters
     * status [string]: You may block the IssuingHolder by passing 'blocked' in the status
     * name [string]: card holder name.
     * tags [list of strings]: list of strings for tagging
     * rules [list of IssuingRule or HashMap, default []]: list of new IssuingRules. If the rule id isn't set, a new rule will be created.
     * <p>
     * Return:
     * @return  target IssuingHolder with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingHolder update(String id, Map<String, Object> patchData) throws Exception {
        return IssuingHolder.update(id, patchData, null);
    }

    /**
     * Update IssuingHolder entity
     * <p>
     * Update an IssuingHolder by passing id, if it hasn't been paid yet.
     * <p>
     * Parameters:
     * @param id [string]: IssuingHolder id. ex: '5656565656565656'
     * @param patchData map of parameters
     * status [string]: You may block the IssuingHolder by passing 'blocked' in the status
     * name [string]: card holder name.
     * tags [list of strings]: list of strings for tagging
     * rules [list of dictionaries, default []]: list of new IssuingRules. If the rule id isn't set, a new rule will be created.
     * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return  target IssuingHolder with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingHolder update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    /**
     * Delete an IssuingHolder entity
     * <p>
     * Delete an IssuingHolder entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: IssuingHolder id. ex: '5656565656565656'
     * <p>
     * Return:
     * @return  deleted IssuingHolder object
     * @throws Exception error in the request
     */
    public static IssuingHolder delete(String id) throws Exception {
        return IssuingHolder.delete(id, null);
    }

    /**
     * Delete an IssuingHolder entity
     * <p>
     * Delete an IssuingHolder entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: IssuingHolder id. ex: '5656565656565656'
     * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return  deleted IssuingHolder object
     * @throws Exception error in the request
     */
    public static IssuingHolder delete(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(IssuingHolder.Log.class, "IssuingHolderLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public IssuingHolder holder;

        /**
         * IssuingHolder Log object
         * <p>
         * Every time an IssuingHolder entity is modified, a corresponding IssuingHolder Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param holder [IssuingHolder]: IssuingHolder entity to which the log refers to.
         * @param errors [list of strings]: list of errors linked to the IssuingHolder event.
         * @param type [string]: type of the IssuingHolder event which triggered the log creation. ex: "processing" or "success"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Log(String created, String type, List<ErrorElement> errors, IssuingHolder holder, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.holder = holder;
        }

        /**
         * Retrieve a specific IssuingHolder Log
         * <p>
         * Receive a single IssuingHolder Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return IssuingHolder Log object with updated attributes
         * @throws Exception error in the holder
         */
        public static IssuingHolder.Log get(String id) throws Exception {
            return IssuingHolder.Log.get(id, null);
        }

        /**
         * Retrieve a specific IssuingHolder Log
         * <p>
         * Receive a single IssuingHolder Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return IssuingHolder Log object with updated attributes
         * @throws Exception error in the holder
         */
        public static IssuingHolder.Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve IssuingHolder Logs
         * <p>
         * Receive a generator of IssuingHolder.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * holderIds [list of strings, default null]: list of IssuingHolder ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of IssuingHolder Log objects with updated attributes
         * @throws Exception error in the holder
         */
        public static Generator<IssuingHolder.Log> query(Map<String, Object> params) throws Exception {
            return IssuingHolder.Log.query(params, null);
        }

        /**
         * Retrieve IssuingHolder Logs
         * <p>
         * Receive a generator of IssuingHolder.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return generator of IssuingHolder Log objects with updated attributes
         * @throws Exception error in the holder
         */
        public static Generator<IssuingHolder.Log> query(User user) throws Exception {
            return IssuingHolder.Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve IssuingHolder Logs
         * <p>
         * Receive a generator of IssuingHolder.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of IssuingHolder Log objects with updated attributes
         * @throws Exception error in the holder
         */
        public static Generator<IssuingHolder.Log> query() throws Exception {
            return IssuingHolder.Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve IssuingHolder Logs
         * <p>
         * Receive a generator of IssuingHolder.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * holderIds [list of strings, default null]: list of IssuingHolder ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return generator of IssuingHolder Log objects with updated attributes
         * @throws Exception error in the holder
         */
        public static Generator<IssuingHolder.Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<IssuingHolder.Log> logs;
            public String cursor;

            public Page(List<IssuingHolder.Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged IssuingHolder.Logs
         * <p>
         * Receive a list of up to 100 IssuingHolder.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your holders.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * holderIds [list of strings, default null]: list of IssuingHolder ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return IssuingHolder.Log.Page object:
         * IssuingHolder.Log.Page.logs: list of IssuingHolder.Log objects with updated attributes
         * IssuingHolder.Log.Page.cursor: cursor to retrieve the next page of IssuingHolder.Log objects
         * @throws Exception error in the holder
         */
        public static IssuingHolder.Log.Page page(Map<String, Object> params) throws Exception {
            return IssuingHolder.Log.page(params, null);
        }

        /**
         * Retrieve paged IssuingHolder.Logs
         * <p>
         * Receive a list of up to 100 IssuingHolder.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your holders.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return IssuingHolder.Log.Page object:
         * IssuingHolder.Log.Page.logs: list of IssuingHolder.Log objects with updated attributes
         * IssuingHolder.Log.Page.cursor: cursor to retrieve the next page of IssuingHolder.Log objects
         * @throws Exception error in the holder
         */
        public static IssuingHolder.Log.Page page(User user) throws Exception {
            return IssuingHolder.Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged IssuingHolder.Logs
         * <p>
         * Receive a list of up to 100 IssuingHolder.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your holders.
         * <p>
         * Return:
         * @return IssuingHolder.Log.Page object:
         * IssuingHolder.Log.Page.logs: list of IssuingHolder.Log objects with updated attributes
         * IssuingHolder.Log.Page.cursor: cursor to retrieve the next page of IssuingHolder.Log objects
         * @throws Exception error in the holder
         */
        public static IssuingHolder.Log.Page page() throws Exception {
            return IssuingHolder.Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged IssuingHolder.Logs
         * <p>
         * Receive a list of up to 100 IssuingHolder.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your holders.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * holderIds [list of strings, default null]: list of IssuingHolder ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return IssuingHolder.Log.Page object:
         * IssuingHolder.Log.Page.logs: list of IssuingHolder.Log objects with updated attributes
         * IssuingHolder.Log.Page.cursor: cursor to retrieve the next page of IssuingHolder.Log objects
         * @throws Exception error in the holder
         */
        public static IssuingHolder.Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
            List<IssuingHolder.Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((IssuingHolder.Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }
}
