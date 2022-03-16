package com.starkinfra;

import com.starkinfra.utils.Generator;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Rest;
import com.starkinfra.utils.SubResource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class PixStatement extends Resource {
    /**
     * PixStatement object
     * <p>
     * The PixStatement object stores information about all the transactions that happened on
     * a specific day at the workspace. It must be created by the user before it can be
     * accessed by the user. This feature is only available for direct participants.
     * <p>
     * Parameters:
     * after             [String]: transactions that happened at this date are stored in the PixStatement, must be the same as before. ex: (2022-01-01)
     * before            [String]: transactions that happened at this date are stored in the PixStatement, must be the same as after. ex: (2022-01-01)
     * type              [String]: types of entities to include in statement. Options: ["interchange", "interchangeTotal", "transaction"]
     * id                [String, default null]: unique id returned when the PixStatement is created. ex: "5656565656565656"
     * status            [String, default null]: current PixStatement status. ex: "success" or "failed"
     * transactionCount  [integer, default null]: number of transactions that happened during the day that the PixStatement was requested. ex 11
     * created           [String, default null]: creation datetime for the PixStatement. ex: datetime.datetime(2020, 3, 10, 10, 30, 0, 0)
     * updated           [String, default null]: latest update datetime for the PixStatement. ex: datetime.datetime(2020, 3, 10, 10, 30, 0, 0)
     *
     */
    static ClassData data = new ClassData(PixStatement.class, "PixStatement");

    public String after;
    public String before;
    public String type;
    public String status;
    public Integer transactionCount;
    public String created;
    public String updated;

    /**
     * PixStatement object
     * <p>
     * The PixStatement object stores information about all the transactions that happened on
     * a specific day at the workspace. It must be created by the user before it can be
     * accessed by the user. This feature is only available for direct participants.
     * <p>
     * Parameters:
     * @param after [String]: transactions that happened at this date are stored in the PixStatement, must be the same as before. ex: (2022-01-01)
     * @param before [String]: transactions that happened at this date are stored in the PixStatement, must be the same as after. ex: (2022-01-01)
     * @param type [String]: types of entities to include in statement. Options: ["interchange", "interchangeTotal", "transaction"]
     * @param id [String, default null]: unique id returned when the PixStatement is created. ex: "5656565656565656"
     * @param status [String, default null]: current PixStatement status. ex: "success" or "failed"
     * @param transactionCount [Integer, default null]: number of transactions that happened during the day that the PixStatement was requested. ex 11
     * @param created [String, default null]: creation datetime for the PixStatement. ex: datetime.datetime(2020, 3, 10, 10, 30, 0, 0)
     * @param updated [String, default null]: latest update datetime for the PixStatement. ex: datetime.datetime(2020, 3, 10, 10, 30, 0, 0)
     *
     */
    public PixStatement(String after, String before, String type, String id, String status, Integer transactionCount,
                        String created, String updated) {
        super(id);
        this.after = after;
        this.before = before;
        this.type = type;
        this.status = status;
        this.transactionCount = transactionCount;
        this.created = created;
        this.updated = updated;
    }

    /**
     * PixStatement object
     * <p>
     * The PixStatement object stores information about all the transactions that happened on
     * a specific day at the workspace. It must be created by the user before it can be
     * accessed by the user. This feature is only available for direct participants.
     * <p>
     * Parameters:
     * after             [String]: transactions that happened at this date are stored in the PixStatement, must be the same as before. ex: (2022-01-01)
     * before            [String]: transactions that happened at this date are stored in the PixStatement, must be the same as after. ex: (2022-01-01)
     * type              [String]: types of entities to include in statement. Options: ["interchange", "interchangeTotal", "transaction"]
     * id                [String, default null]: unique id returned when the PixStatement is created. ex: "5656565656565656"
     * status            [String, default null]: current PixStatement status. ex: "success" or "failed"
     * transactionCount  [integer, default null]: number of transactions that happened during the day that the PixStatement was requested. ex 11
     * created           [String, default null]: creation datetime for the PixStatement. ex: datetime.datetime(2020, 3, 10, 10, 30, 0, 0)
     * updated           [String, default null]: latest update datetime for the PixStatement. ex: datetime.datetime(2020, 3, 10, 10, 30, 0, 0)
     *
     */
    public PixStatement(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.after = (String) dataCopy.remove("after");
        this.before = (String) dataCopy.remove("before");
        this.type = (String) dataCopy.remove("type");
        this.status = null;
        this.transactionCount = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific PixStatement
     * <p>
     * Receive a single PixStatement object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return PixStatement object with updated attributes
     * @throws Exception error in the statement
     */
    public static PixStatement get(String id) throws Exception {
        return PixStatement.get(id, null);
    }

    /**
     * Retrieve a specific PixStatement
     * <p>
     * Receive a single PixStatement object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixStatement object with updated attributes
     * @throws Exception error in the statement
     */
    public static PixStatement get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve PixStatements
     * <p>
     * Receive a generator of PixStatement objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of PixStatement objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Generator<PixStatement> query(Map<String, Object> params) throws Exception {
        return PixStatement.query(params, null);
    }

    /**
     * Retrieve PixStatements
     * <p>
     * Receive a generator of PixStatement objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of PixStatement objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Generator<PixStatement> query(User user) throws Exception {
        return PixStatement.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PixStatements
     * <p>
     * Receive a generator of PixStatement objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of PixStatement objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Generator<PixStatement> query() throws Exception {
        return PixStatement.query(new HashMap<>(), null);
    }

    /**
     * Retrieve PixStatements
     * <p>
     * Receive a generator of PixStatement objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of PixStatement objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Generator<PixStatement> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<PixStatement> statements;
        public String cursor;

        public Page(List<PixStatement> statements, String cursor) {
            this.statements = statements;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged PixStatements
     * <p>
     * Receive a list of up to 100 PixStatement objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your statements.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return PixStatement.Page object:
     * PixStatement.Page.statements: list of PixStatement objects with updated attributes
     * PixStatement.Page.cursor: cursor to retrieve the next page of PixStatement objects
     * @throws Exception error in the statement
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged PixStatements
     * <p>
     * Receive a list of up to 100 PixStatement objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your statements.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixStatement.Page object:
     * PixStatement.Page.statements: list of PixStatement objects with updated attributes
     * PixStatement.Page.cursor: cursor to retrieve the next page of PixStatement objects
     * @throws Exception error in the statement
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PixStatements
     * <p>
     * Receive a list of up to 100 PixStatement objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your statements.
     * <p>
     * Return:
     * @return PixStatement.Page object:
     * PixStatement.Page.statements: list of PixStatement objects with updated attributes
     * PixStatement.Page.cursor: cursor to retrieve the next page of PixStatement objects
     * @throws Exception error in the statement
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PixStatements
     * <p>
     * Receive a list of up to 100 PixStatement objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your statements.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixStatement.Page object:
     * PixStatement.Page.statements: list of PixStatement objects with updated attributes
     * PixStatement.Page.cursor: cursor to retrieve the next page of PixStatement objects
     * @throws Exception error in the statement
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<PixStatement> statements = new ArrayList<>();
        for (SubResource statement: page.entities) {
            statements.add((PixStatement) statement);
        }
        return new Page(statements, page.cursor);
    }

    /**
     * Create a PixStatement
     * <p>
     * Send a PixStatement object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param statement [PixStatement object]: PixStatement object to be created in the API
     * <p>
     * Return:
     * @return PixStatement object with updated attributes
     * @throws Exception error in the statement
     */
    public static PixStatement create(PixStatement statement) throws Exception {
        return PixStatement.create(statement, null);
    }

    /**
     * Create a PixStatement
     * <p>
     * Send a PixStatement object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param statement [PixStatement object]: PixStatement object to be created in the API
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixStatement object with updated attributes
     * @throws Exception error in the statement
     */
    public static PixStatement create(PixStatement statement, User user) throws Exception {
        return Rest.postSingle(data, statement, user);
    }

    /**
     * Retrieve a specific PixStatement csv file
     * <p>
     * Receive a single PixStatement csv file generated in the Stark Infra API by passing its id.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return PixStatement csv file
     * @throws Exception error in the request
     */
    public static InputStream csv(String id) throws Exception {
        return PixStatement.csv(id, null);
    }

    /**
     * Retrieve a specific PixStatement csv file
     * <p>
     * Receive a single PixStatement csv file generated in the Stark Infra API by passing its id.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixStatement csv file
     * @throws Exception error in the request
     */
    public static InputStream csv(String id, User user) throws Exception {
        return Rest.getContent(data, id, "csv", user, new HashMap<>());
    }

    /**
     * PixStatement.Error object
     * <p>
     * Used to define a error in the pixStatement
     * <p>
     * Parameters:
     * key      [string]: key describing a part of the pixStatement value. ex: "Taxes"
     * value    [string]: value to which the key refers to. ex: "120"
     */
    public final static class Error extends SubResource {
        public String key;
        public String value;

        /**
         * PixStatement.Error object
         * Used to define a error in the pixStatement
         * Parameters:
         * @param key   [string]: text indicating an item to be described. ex: "Taxes"
         * @param value [string]: text describing the specified item. ex: "Bad"
         */
        public Error(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
}
