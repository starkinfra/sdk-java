package com.starkinfra;

import com.starkcore.user.User;
import com.starkcore.utils.Generator;
import com.starkcore.utils.Resource;
import com.starkcore.utils.SubResource;
import com.starkinfra.utils.Rest;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IssuingRestock extends Resource {
    /**
     * IssuingRestock object
     * <p>
     * The IssuingRestock object displays the information of the restock orders created in your Workspace. 
     * This resource place a restock order for a specific IssuingStock object.
     * <p>
     * When you initialize a IssuingRestock, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * count [long]: number of restocks to be restocked. ex: 100
     * stockId [string]: IssuingStock unique id ex: "5136459887542272"
     * tags [list of strings, default null]: list of strings for tagging. ex: ["card", "corporate"]
     * id [string]: unique id returned when IssuingRestock is created. ex: "5656565656565656"
     * status [string]: current IssuingRestock status. ex: "created", "processing", "confirmed"
     * updated [string]: latest update datetime for the IssuingRestock. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingRestock. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(IssuingRestock.class, "IssuingRestock");

    public long count;
    public String stockId;
    public String[] tags;
    public String status;
    public String updated;
    public String created;

    /**
     * IssuingRestock object
     * <p>
     * The IssuingRestock object displays the information of the restock orders created in your Workspace. 
     * This resource place a restock order for a specific IssuingStock object.
     * <p>
     * When you initialize a IssuingRestock, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * @param count [long]: number of restocks to be restocked. ex: 100
     * @param stockId [string]: IssuingStock unique id ex: "5136459887542272"
     * @param tags [list of strings, default null]: list of strings for tagging. ex: ["card", "corporate"]
     * @param id [string]: unique id returned when IssuingRestock is created. ex: "5656565656565656"
     * @param status [string]: current IssuingRestock status. ex: "created", "processing", "confirmed"
     * @param updated [string]: latest update datetime for the IssuingRestock. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the IssuingRestock. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingRestock(
        String id, long count, String stockId, String[] tags, String status, 
        String updated, String created
    ) {
        super(id);
        this.count = count;
        this.stockId = stockId;
        this.tags = tags;
        this.status = status;
        this.updated = updated;
        this.created = created;
    }

    /**
     * IssuingRestock object
     * <p>
     * The IssuingRestock object displays the information of the restock orders created in your Workspace. 
     * This resource place a restock order for a specific IssuingStock object.
     * <p>
     * When you initialize a IssuingRestock, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the IssuingRestock
     * count [long]: number of restocks to be restocked. ex: 100
     * stockId [string]: IssuingStock unique id ex: "5136459887542272"
     * <p>
     * Parameters (optional):
     * tags [list of strings, default null]: list of strings for tagging. ex: ["card", "corporate"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when IssuingRestock is created. ex: "5656565656565656"
     * status [string]: current IssuingRestock status. ex: "created", "processing", "confirmed"
     * updated [string]: latest update datetime for the IssuingRestock. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingRestock. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public IssuingRestock(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.count = ((Number) dataCopy.remove("count")).longValue();
        this.stockId = (String) dataCopy.remove("stockId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.status = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create IssuingRestocks
     * <p>
     * Send a list of IssuingRestock objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param restocks [list of IssuingRestock objects]: list of IssuingRestock objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of IssuingRestock objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<IssuingRestock> create(List<IssuingRestock> restocks, User user) throws Exception {
        return Rest.post(data, restocks, user);
    }

    /**
     * Create IssuingRestocks
     * <p>
     * Send a list of IssuingRestock objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param restocks [list of IssuingRestock objects]: list of IssuingRestock objects to be created in the API
     * <p>
     * Return:
     * @return list of IssuingRestock objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<IssuingRestock> create(List<IssuingRestock> restocks) throws Exception {
        return IssuingRestock.create(restocks, null);
    }

    /**
     * Retrieve IssuingRestocks
     * <p>
     * Receive a generator of IssuingRestock objects registered to your workspace in the Stark Infra API.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "processing", "confirmed"]
     * stockIds [list of string, default null]: list of stockIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["card", "corporate"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingRestock objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingRestock> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IssuingRestocks
     * <p>
     * Receive a generator of IssuingRestock objects registered to your workspace in the Stark Infra API.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "processing", "confirmed"]
     * stockIds [list of string, default null]: list of stockIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["card", "corporate"]
     * <p>
     * Return:
     * @return generator of IssuingRestock objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingRestock> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IssuingRestocks
     * <p>
     * Receive a generator of IssuingRestock objects registered to your workspace in the Stark Infra API.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingRestock objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingRestock> query(User user) throws Exception{
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingRestocks
     * <p>
     * Receive a generator of IssuingRestock objects registered to your workspace in the Stark Infra API.
     * <p>
     * Return:
     * @return generator of IssuingRestock objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingRestock> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IssuingRestock> restocks;
        public String cursor;

        public Page(List<IssuingRestock> restocks, String cursor) {
            this.restocks = restocks;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingRestocks
     * <p>
     * Receive a list of up to 100 IssuingRestock objects registered to your workspace in the Stark Infra API. and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "processing", "confirmed"]
     * stockIds [list of string, default null]: list of stockIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["card", "corporate"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingRestock.Page object:
     * IssuingRestock.Page.restocks: list of IssuingRestock objects with updated attributes
     * IssuingRestock.Page.cursor: cursor to retrieve the next page of IssuingRestock objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingRestock> restocks = new ArrayList<>();
        for (SubResource card: page.entities) {
            restocks.add((IssuingRestock) card);
        }
        return new Page(restocks, page.cursor);
    }

    /**
     * Retrieve paged IssuingRestocks
     * <p>
     * Receive a list of up to 100 IssuingRestock objects registered to your workspace in the Stark Infra API. and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "processing", "confirmed"]
     * stockIds [list of string, default null]: list of stockIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["card", "corporate"]
     * <p>
     * Return:
     * @return IssuingRestock.Page object:
     * IssuingRestock.Page.restocks: list of IssuingRestock objects with updated attributes
     * IssuingRestock.Page.cursor: cursor to retrieve the next page of IssuingRestock objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingRestocks
     * <p>
     * Receive a list of up to 100 IssuingRestock objects registered to your workspace in the Stark Infra API. and the cursor to the next page.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingRestock.Page object:
     * IssuingRestock.Page.restocks: list of IssuingRestock objects with updated attributes
     * IssuingRestock.Page.cursor: cursor to retrieve the next page of IssuingRestock objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingRestocks
     * <p>
     * Receive a list of up to 100 IssuingRestock objects registered to your workspace in the Stark Infra API. and the cursor to the next page.
     * <p>
     * Return:
     * @return IssuingRestock.Page object:
     * IssuingRestock.Page.restocks: list of IssuingRestock objects with updated attributes
     * IssuingRestock.Page.cursor: cursor to retrieve the next page of IssuingRestock objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve a specific IssuingRestock
     * <p>
     * Receive a single IssuingRestock object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingRestock object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingRestock get(String id, User user) throws Exception{
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific IssuingRestock
     * <p>
     * Receive a single IssuingRestock object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingRestock object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingRestock get(String id) throws Exception{
        return IssuingRestock.get(id, null);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(IssuingRestock.Log.class, "IssuingRestockLog");

        public IssuingRestock restock;
        public String type;
        public String created;

        /**
         * IssuingRestock.Log object
         * <p>
         * Every time an IssuingRestock entity is modified, a corresponding IssuingRestock.Log
         * is generated for the entity. This log is never generated by the user, 
         * but it can be retrieved to check additional information on the IssuingRestock.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param restock [IssuingRestock object]: IssuingRestock entity to which the log refers to.
         * @param type [string]: type of the IssuingRestock event which triggered the log creation. Options: "created", "processing", "confirmed"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Log(String id, IssuingRestock restock, String type, String created ) {
            super(id);
            this.restock = restock;
            this.type = type;
            this.created = created;
        }

        /**
         * Retrieve a specific IssuingRestock.Log
         * <p>
         * Receive a single IssuingRestock.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return IssuingRestock.Log object with updated attributes
         * @throws Exception error in the restock
         */
        public static IssuingRestock.Log get(String id) throws Exception {
            return IssuingRestock.Log.get(id, null);
        }

        /**
         * Retrieve a specific IssuingRestock.Log
         * <p>
         * Receive a single IssuingRestock.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingRestock.Log object with updated attributes
         * @throws Exception error in the restock
         */
        public static IssuingRestock.Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve IssuingRestock.Log objects
         * <p>
         * Receive a generator of IssuingRestock.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created", "processing", "confirmed"]
         * restockIds [list of strings, default null]: list of IssuingRestock ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of IssuingRestock.Log objects with updated attributes
         * @throws Exception error in the restock
         */
        public static Generator<IssuingRestock.Log> query(Map<String, Object> params) throws Exception {
            return IssuingRestock.Log.query(params, null);
        }

        /**
         * Retrieve IssuingRestock.Log objects
         * <p>
         * Receive a generator of IssuingRestock.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IssuingRestock.Log objects with updated attributes
         * @throws Exception error in the restock
         */
        public static Generator<IssuingRestock.Log> query(User user) throws Exception {
            return IssuingRestock.Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve IssuingRestock.Log objects
         * <p>
         * Receive a generator of IssuingRestock.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of IssuingRestock.Log objects with updated attributes
         * @throws Exception error in the restock
         */
        public static Generator<IssuingRestock.Log> query() throws Exception {
            return IssuingRestock.Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve IssuingRestock.Log objects
         * <p>
         * Receive a generator of IssuingRestock.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created", "processing", "confirmed"]
         * restockIds [list of strings, default null]: list of IssuingRestock ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IssuingRestock.Log objects with updated attributes
         * @throws Exception error in the restock
         */
        public static Generator<IssuingRestock.Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<IssuingRestock.Log> logs;
            public String cursor;

            public Page(List<IssuingRestock.Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged IssuingRestock.Log objects
         * <p>
         * Receive a list of up to 100 IssuingRestock.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your restocks.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created", "processing", "confirmed"]
         * restockIds [list of strings, default null]: list of IssuingRestock ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return IssuingRestock.Log.Page object:
         * IssuingRestock.Log.Page.logs: list of IssuingRestock.Log objects with updated attributes
         * IssuingRestock.Log.Page.cursor: cursor to retrieve the next page of IssuingRestock.Log objects
         * @throws Exception error in the restock
         */
        public static IssuingRestock.Log.Page page(Map<String, Object> params) throws Exception {
            return IssuingRestock.Log.page(params, null);
        }

        /**
         * Retrieve paged IssuingRestock.Log objects
         * <p>
         * Receive a list of up to 100 IssuingRestock.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your restocks.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingRestock.Log.Page object:
         * IssuingRestock.Log.Page.logs: list of IssuingRestock.Log objects with updated attributes
         * IssuingRestock.Log.Page.cursor: cursor to retrieve the next page of IssuingRestock.Log objects
         * @throws Exception error in the restock
         */
        public static IssuingRestock.Log.Page page(User user) throws Exception {
            return IssuingRestock.Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged IssuingRestock.Log objects
         * <p>
         * Receive a list of up to 100 IssuingRestock.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your restocks.
         * <p>
         * Return:
         * @return IssuingRestock.Log.Page object:
         * IssuingRestock.Log.Page.logs: list of IssuingRestock.Log objects with updated attributes
         * IssuingRestock.Log.Page.cursor: cursor to retrieve the next page of IssuingRestock.Log objects
         * @throws Exception error in the restock
         */
        public static IssuingRestock.Log.Page page() throws Exception {
            return IssuingRestock.Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged IssuingRestock.Log objects
         * <p>
         * Receive a list of up to 100 IssuingRestock.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your restocks.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created", "processing", "confirmed"]
         * restockIds [list of strings, default null]: list of IssuingRestock ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingRestock.Log.Page object:
         * IssuingRestock.Log.Page.logs: list of IssuingRestock.Log objects with updated attributes
         * IssuingRestock.Log.Page.cursor: cursor to retrieve the next page of IssuingRestock.Log objects
         * @throws Exception error in the restock
         */
        public static IssuingRestock.Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<IssuingRestock.Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((IssuingRestock.Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }

}
