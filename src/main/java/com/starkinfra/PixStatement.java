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
import java.io.InputStream;


public final class PixStatement extends Resource {
    /**
     * PixStatement object
     * <p>
     * The PixStatement object stores information about all the transactions that
     * happened on a specific day at your settlment account according to the Central Bank.
     * It must be created by the user before it can be accessed.
     * This feature is only available for direct participants.
     * <p>
     * When you initialize a PixStatement, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * before [string]: transactions that happened at this date are stored in the PixStatement, must be the same as after. ex: "2020-03-10"
     * after [string]: transactions that happened at this date are stored in the PixStatement, must be the same as before. ex: "2020-03-10"
     * type [string]: types of entities to include in statement. Options: "interchange", "interchangeTotal" and "transaction"
     * id [string]: unique id returned when the PixStatement is created. ex: "5656565656565656"
     * status [string]: current PixStatement status. ex: "success" or "failed"
     * transactionCount [integer]: number of transactions that happened during the day that the PixStatement was requested. ex 11
     * created [string]: creation datetime for the PixStatement. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixStatement. ex: "2020-03-10 10:30:00.000000+00:00"
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
     * The PixStatement object stores information about all the transactions that
     * happened on a specific day at your settlement account according to the Central Bank.
     * It must be created by the user before it can be accessed.
     * This feature is only available for direct participants.
     * <p>
     * When you initialize a PixStatement, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param after [string]: transactions that happened at this date are stored in the PixStatement, must be the same as before. ex: "2020-03-10"
     * @param before [string]: transactions that happened at this date are stored in the PixStatement, must be the same as after. ex: "2020-03-10"
     * @param type [string]: types of entities to include in statement. Options: "interchange", "interchangeTotal" and "transaction"
     * @param id [string]: unique id returned when the PixStatement is created. ex: "5656565656565656"
     * @param status [string]: current PixStatement status. ex: "success" or "failed"
     * @param transactionCount [integer]: number of transactions that happened during the day that the PixStatement was requested. ex 11
     * @param created [string]: creation datetime for the PixStatement. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the PixStatement. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public PixStatement(String after, String before, String type, String id, String status, Integer transactionCount,
                        String created, String updated
    ) {
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
     * The PixStatement object stores information about all the transactions that
     * happened on a specific day at your settlement account according to the Central Bank.
     * It must be created by the user before it can be accessed.
     * This feature is only available for direct participants.
     * <p>
     * When you initialize a PixStatement, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the PixStatement
     * after [string]: transactions that happened at this date are stored in the PixStatement, must be the same as before. ex: "2020-03-10"
     * before [string]: transactions that happened at this date are stored in the PixStatement, must be the same as after. ex: "2020-03-10"
     * type [string]: types of entities to include in statement. Options: "interchange", "interchangeTotal" and "transaction"
     * id [string]: unique id returned when the PixStatement is created. ex: "5656565656565656"
     * status [string]: current PixStatement status. ex: "success" or "failed"
     * transactionCount [integer]: number of transactions that happened during the day that the PixStatement was requested. ex 11
     * created [string]: creation datetime for the PixStatement. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixStatement. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
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
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
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
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
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
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
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
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
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
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
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
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixStatement.Page object:
     * PixStatement.Page.statements: list of PixStatement objects with updated attributes
     * PixStatement.Page.cursor: cursor to retrieve the next page of PixStatement objects
     * @throws Exception error in the statement
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
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
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
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
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixStatement csv file
     * @throws Exception error in the request
     */
    public static InputStream csv(String id, User user) throws Exception {
        return Rest.getContent(data, id, "csv", user, new HashMap<>());
    }
}
