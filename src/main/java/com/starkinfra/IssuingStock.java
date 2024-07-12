package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IssuingStock extends Resource {
    /**
     * IssuingStock object
     * <p>
     * The IssuingStock object represents the current stock of a certain IssuingDesign linked to an Embosser available to your workspace.
     * <p>
     * Parameters:
     * id [string]: unique id returned when IssuingStock is created. ex: "5656565656565656"
     * balance [integer]: [EXPANDABLE] current stock balance. ex: 1000
     * designId [string]: IssuingDesign unique id. ex: "5656565656565656"
     * embosserId [string]: Embosser unique id. ex: "5656565656565656"
     * updated [string]: latest update datetime for the IssuingStock. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingStock. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(IssuingStock.class, "IssuingStock");

    public Integer balance;
    public String designId;
    public String embosserId;
    public String updated;
    public String created;

    /**
     * IssuingStock object
     * <p>
     * The IssuingStock object represents the current stock of a certain IssuingDesign linked to an Embosser available to your workspace.
     * <p>
     * Parameters:
     * @param balance [integer]: [EXPANDABLE] current stock balance. ex: 1000
     * @param designId [string]: IssuingDesign unique id. ex: "5656565656565656"
     * @param embosserId [string]: Embosser unique id. ex: "5656565656565656"
     * @param updated [string]: latest update datetime for the IssuingStock. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the IssuingStock. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingStock(
        String id, Integer balance, String designId, String embosserId, String updated, String created
    ) {
        super(id);
        this.balance = balance;
        this.designId = designId;
        this.embosserId = embosserId;
        this.updated = updated;
        this.created = created;
    }

    /**
     * IssuingStock object
     * <p>
     * The IssuingStock object represents the current stock of a certain IssuingDesign linked to an Embosser available to your workspace.
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when IssuingStock is created. ex: "5656565656565656"
     * balance [integer]: [EXPANDABLE] current stock balance. ex: 1000
     * designId [string]: IssuingDesign unique id. ex: "5656565656565656"
     * embosserId [string]: Embosser unique id. ex: "5656565656565656"
     * updated [string]: latest update datetime for the IssuingStock. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingStock. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public IssuingStock(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.balance = null;
        this.designId = null;
        this.embosserId = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve IssuingStocks
     * <p>
     * Receive a generator of IssuingStock objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * designIds [list of strings, default null]: IssuingDesign unique ids. ex: ["5656565656565656", "4545454545454545"]
     * embosserIds [list of strings, default null]: Embosser unique ids. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * expand [list of strings, default null]: fields to expand information. ex: ["balance"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingStock objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingStock> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IssuingStocks
     * <p>
     * Receive a generator of IssuingStock objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * designIds [list of strings, default null]: IssuingDesign unique ids. ex: ["5656565656565656", "4545454545454545"]
     * embosserIds [list of strings, default null]: Embosser unique ids. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * expand [list of strings, default null]: fields to expand information. ex: ["balance"]
     * <p>
     * Return:
     * @return generator of IssuingStock objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingStock> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IssuingStocks
     * <p>
     * Receive a generator of IssuingStock objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingStock objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingStock> query(User user) throws Exception{
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingStocks
     * <p>
     * Receive a generator of IssuingStock objects previously created in the Stark Infra API
     * <p>
     * Return:
     * @return generator of IssuingStock objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingStock> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IssuingStock> stocks;
        public String cursor;

        public Page(List<IssuingStock> stocks, String cursor) {
            this.stocks = stocks;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingStocks
     * <p>
     * Receive a list of up to 100 IssuingStock objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your IssuingStocks.
     * <p>
     * Return:
     * IssuingStock.Page.Stocks: list of IssuingStock objects with updated attributes
     * IssuingStock.Page.cursor: cursor to retrieve the next page of IssuingStock objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged IssuingStocks
     * <p>
     * Receive a list of up to 100 IssuingStock objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your IssuingStocks.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * designIds [list of strings, default null]: IssuingDesign unique ids. ex: ["5656565656565656", "4545454545454545"]
     * embosserIds [list of strings, default null]: Embosser unique ids. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * expand [list of strings, default null]: fields to expand information. ex: ["balance"]
     * <p>
     * Return:
     * IssuingStock.Page.stocks: list of IssuingStock objects with updated attributes
     * IssuingStock.Page.cursor: cursor to retrieve the next page of IssuingStock objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingStocks
     * <p>
     * Receive a list of up to 100 IssuingStock objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your IssuingStocks.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * IssuingStock.Page.stocks: list of IssuingStock objects with updated attributes
     * IssuingStock.Page.cursor: cursor to retrieve the next page of IssuingStock objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingStocks
     * <p>
     * Receive a list of up to 100 IssuingStock objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your IssuingStocks.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * designIds [list of strings, default null]: IssuingDesign unique ids. ex: ["5656565656565656", "4545454545454545"]
     * embosserIds [list of strings, default null]: Embosser unique ids. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * expand [list of strings, default null]: fields to expand information. ex: ["balance"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * IssuingStock.Page.stocks: list of IssuingStock objects with updated attributes
     * IssuingStock.Page.cursor: cursor to retrieve the next page of IssuingStock objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingStock> stocks = new ArrayList<>();
        for (SubResource issuingStock: page.entities) {
            stocks.add((IssuingStock) issuingStock);
        }
        return new Page(stocks, page.cursor);
    }

    /**
     * Retrieve a specific IssuingStock
     * <p>
     * Receive a single IssuingStock object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters
     * expand [list of strings, default null]: fields to expand information. ex: ["balance"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingStock object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingStock get(String id, Map<String, Object> params, User user) throws Exception {
        return Rest.getId(data, id, params, user);
    }

    /**
     * Retrieve a specific IssuingStock
     * <p>
     * Receive a single IssuingStock object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters
     * expand [list of strings, default null]: fields to expand information. ex: ["balance"]
     * <p>
     * Return:
     * @return IssuingStock object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingStock get(String id, Map<String, Object> params) throws Exception{
        return Rest.getId(data, id, params, null);
    }
    
    /**
     * Retrieve a specific IssuingStock
     * <p>
     * Receive a single IssuingStock object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingStock object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingStock get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific IssuingStock
     * <p>
     * Receive a single IssuingStock object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingStock object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingStock get(String id) throws Exception{
        return Rest.getId(data, id, null);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(IssuingStock.Log.class, "IssuingStockLog");

        public IssuingStock stock;
        public String type;
        public Integer count;
        public String created;

        /**
         * IssuingStock Log object
         * <p>
         * Every time an IssuingStock entity is modified, a corresponding IssuingStock Log
         * is generated for the entity. This log is never generated by the user, 
         * but it can be retrieved to check additional information on the IssuingStock.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param stock [IssuingStock object]: IssuingStock entity to which the log refers to.
         * @param type [string]: type of the IssuingStock event which triggered the log creation. Options: "created", "spent", "restocked", "lost"
         * @param count [integer]: shift in stock balance. ex: 10
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Log(String id, IssuingStock stock, String type, Integer count, String created ) {
            super(id);
            this.stock = stock;
            this.type = type;
            this.count = count;
            this.created = created;
        }

        /**
         * Retrieve a specific IssuingStock Log
         * <p>
         * Receive a single IssuingStock Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return IssuingStock Log object with updated attributes
         * @throws Exception error in the stock
         */
        public static IssuingStock.Log get(String id) throws Exception {
            return IssuingStock.Log.get(id, null);
        }

        /**
         * Retrieve a specific IssuingStock Log
         * <p>
         * Receive a single IssuingStock Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingStock Log object with updated attributes
         * @throws Exception error in the stock
         */
        public static IssuingStock.Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve IssuingStock Logs
         * <p>
         * Receive a generator of IssuingStock.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created", "spent", "restocked", "lost"]
         * stockIds [list of strings, default null]: list of IssuingStock ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of IssuingStock Log objects with updated attributes
         * @throws Exception error in the stock
         */
        public static Generator<IssuingStock.Log> query(Map<String, Object> params) throws Exception {
            return IssuingStock.Log.query(params, null);
        }

        /**
         * Retrieve IssuingStock Logs
         * <p>
         * Receive a generator of IssuingStock.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IssuingStock Log objects with updated attributes
         * @throws Exception error in the stock
         */
        public static Generator<IssuingStock.Log> query(User user) throws Exception {
            return IssuingStock.Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve IssuingStock Logs
         * <p>
         * Receive a generator of IssuingStock.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of IssuingStock Log objects with updated attributes
         * @throws Exception error in the stock
         */
        public static Generator<IssuingStock.Log> query() throws Exception {
            return IssuingStock.Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve IssuingStock Logs
         * <p>
         * Receive a generator of IssuingStock.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created", "spent", "restocked", "lost"]
         * stockIds [list of strings, default null]: list of IssuingStock ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IssuingStock Log objects with updated attributes
         * @throws Exception error in the stock
         */
        public static Generator<IssuingStock.Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<IssuingStock.Log> logs;
            public String cursor;

            public Page(List<IssuingStock.Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged IssuingStock.Logs
         * <p>
         * Receive a list of up to 100 IssuingStock.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your stocks.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created", "spent", "restocked", "lost"]
         * stockIds [list of strings, default null]: list of IssuingStock ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return IssuingStock.Log.Page object:
         * IssuingStock.Log.Page.logs: list of IssuingStock.Log objects with updated attributes
         * IssuingStock.Log.Page.cursor: cursor to retrieve the next page of IssuingStock.Log objects
         * @throws Exception error in the stock
         */
        public static IssuingStock.Log.Page page(Map<String, Object> params) throws Exception {
            return IssuingStock.Log.page(params, null);
        }

        /**
         * Retrieve paged IssuingStock.Logs
         * <p>
         * Receive a list of up to 100 IssuingStock.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your stocks.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingStock.Log.Page object:
         * IssuingStock.Log.Page.logs: list of IssuingStock.Log objects with updated attributes
         * IssuingStock.Log.Page.cursor: cursor to retrieve the next page of IssuingStock.Log objects
         * @throws Exception error in the stock
         */
        public static IssuingStock.Log.Page page(User user) throws Exception {
            return IssuingStock.Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged IssuingStock.Logs
         * <p>
         * Receive a list of up to 100 IssuingStock.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your stocks.
         * <p>
         * Return:
         * @return IssuingStock.Log.Page object:
         * IssuingStock.Log.Page.logs: list of IssuingStock.Log objects with updated attributes
         * IssuingStock.Log.Page.cursor: cursor to retrieve the next page of IssuingStock.Log objects
         * @throws Exception error in the stock
         */
        public static IssuingStock.Log.Page page() throws Exception {
            return IssuingStock.Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged IssuingStock.Logs
         * <p>
         * Receive a list of up to 100 IssuingStock.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your stocks.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created", "spent", "restocked", "lost"]
         * stockIds [list of strings, default null]: list of IssuingStock ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingStock.Log.Page object:
         * IssuingStock.Log.Page.logs: list of IssuingStock.Log objects with updated attributes
         * IssuingStock.Log.Page.cursor: cursor to retrieve the next page of IssuingStock.Log objects
         * @throws Exception error in the stock
         */
        public static IssuingStock.Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<IssuingStock.Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((IssuingStock.Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }

}
