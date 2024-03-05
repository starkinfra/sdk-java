package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class CreditHolmes extends Resource {
    /**
     * CreditHolmes objects
     * <p>
     * CreditHolmes are used to obtain debt information on your customers.
     * Before you create a CreditHolmes, make sure you have your customer's express
     * authorization to verify their information in the Central Bank's SCR.
     * <p>
     * When you initialize a CreditHolmes, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * taxId [string]: customer's tax ID (CPF or CNPJ) for whom the credit operations will be verified. ex: "20.018.183/0001-80"
     * competence [string, default 'two months before current date']: competence month of the operation verification in string format. ex: "2020-03"
     * tags [list of strings, default null]: list of strings for tagging. ex: ["travel", "food"]
     * id [string, default null]: unique id returned when CreditHolmes is created. ex: "5656565656565656"
     * result [HashMap or CreditHolmes.Result, default empty HashMap]: result of the investigation after the case is solved.
     * status [string]: current CreditHolmes status. ex: "created", "failed", "success"
     * updated [string]: latest update datetime for the CreditHolmes. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the CreditHolmes. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(CreditHolmes.class, "CreditHolmes");

    public String taxId;
    public String competence;
    public String[] tags;
    public CreditHolmes.Result result;
    public String status;
    public String updated;
    public String created;

    /**
     * CreditHolmes objects
     * <p>
     * CreditHolmes are used to obtain debt information on your customers.
     * Before you create a CreditHolmes, make sure you have your customer's express
     * authorization to verify their information in the Central Bank's SCR.
     * <p>
     * When you initialize a CreditHolmes, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param taxId [string]: customer's tax ID (CPF or CNPJ) for whom the credit operations will be verified. ex: "20.018.183/0001-80"
     * @param competence [string, default 'two months before current date']: competence month of the operation verification in string format. ex: "2020-03"
     * @param tags [list of strings, default null]: list of strings for tagging. ex: ["travel", "food"]
     * @param id [string, default null]: unique id returned when CreditHolmes is created. ex: "5656565656565656"
     * @param result [HashMap or CreditHolmes.Result, default empty HashMap]: result of the investigation after the case is solved.
     * @param status [string]: current CreditHolmes status. ex: "created", "failed", "success"
     * @param updated [string]: latest update datetime for the CreditHolmes. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the CreditHolmes. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    public CreditHolmes(
        String taxId, String competence, String[] tags, String id, CreditHolmes.Result result, 
        String status, String updated, String created
    ) {
        super(id);
        this.taxId = taxId;
        this.competence = competence;
        this.tags = tags;
        this.result = result;
        this.status = status;
        this.updated = updated;
        this.created = created;
    }

    /**
     * CreditHolmes objects
     * <p>
     * CreditHolmes are used to obtain debt information on your customers.
     * Before you create a CreditHolmes, make sure you have your customer's express
     * authorization to verify their information in the Central Bank's SCR.
     * <p>
     * When you initialize a CreditHolmes, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the CreditHolmes
     * taxId [string]: customer's tax ID (CPF or CNPJ) for whom the credit operations will be verified. ex: "20.018.183/0001-80"
     * <p>
     * Parameters (optional):
     * competence [string, default 'two months before current date']: competence month of the operation verification in string format. ex: "2020-03"
     * tags [list of strings, default null]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Attributes (return-only):
     * id [string, default null]: unique id returned when CreditHolmes is created. ex: "5656565656565656"
     * result [HashMap or CreditHolmes.Result, default empty HashMap]: result of the investigation after the case is solved.
     * status [string]: current CreditHolmes status. ex: "active", "blocked" or "canceled"
     * updated [string]: latest update datetime for the CreditHolmes. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the CreditHolmes. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public CreditHolmes(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        
        this.taxId = (String) dataCopy.remove("taxId");
        this.competence = (String) dataCopy.remove("competence");
        this.tags = (String[]) dataCopy.remove("tags");
        this.result = parseResult(dataCopy.remove("result"));
        this.status = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    @SuppressWarnings("unchecked")
    public static CreditHolmes.Result parseResult(Object result) throws Exception {
        if (result == null)
            return null;

        if (result instanceof CreditHolmes.Result) {
            return (CreditHolmes.Result) result;
        }

        return new CreditHolmes.Result((Map<String, Object>) result);
    }

    /**
     * Create CreditHolmes
     * <p>
     * Send a list of CreditHolmes objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param holmes [list of CreditHolmes objects]: List of CreditHolmes objects to be created in the API
     * <p>
     * Return:
     * @return list of CreditHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<CreditHolmes> create(List<?> holmes) throws Exception {
        return CreditHolmes.create(holmes, null);
    }

    /**
     * Create CreditHolmes
     * <p>
     * Send a list of CreditHolmes objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param holmes [list of CreditHolmes objects]: List of CreditHolmes objects to be created in the API
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return list of CreditHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<CreditHolmes> create(List<?> holmes, User user) throws Exception {
        List<CreditHolmes> sherlockList = new ArrayList<>();
        for (Object sherlock : holmes){
            if (sherlock instanceof Map){
                sherlockList.add(new CreditHolmes((Map<String, Object>) sherlock));
                continue;
            }
            if (sherlock instanceof CreditHolmes){
                sherlockList.add((CreditHolmes) sherlock);
                continue;
            }
            throw new Exception("Unknown type \"" + sherlock.getClass() + "\", use CreditHolmes or HashMap");
        }
        return Rest.post(data, sherlockList, user);
    }

    /**
     * Retrieve a specific CreditHolmes
     * <p>
     * Receive a single CreditHolmes object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return CreditHolmes object with updated attributes
     * @throws Exception error in the request
     */
    public static CreditHolmes get(String id, User user) throws Exception{
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific CreditHolmes
     * <p>
     * Receive a single CreditHolmes object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return CreditHolmes object with updated attributes
     * @throws Exception error in the request
     */
    public static CreditHolmes get(String id) throws Exception{
        return Rest.getId(data, id, null);
    }

    /**
     * Retrieve CreditHolmes
     * <p>
     * Receive a generator of CreditHolmes objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. Options: "created", "failed", "success".
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of CreditHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CreditHolmes> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve CreditHolmes
     * <p>
     * Receive a generator of CreditHolmes objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. Options: "created", "failed", "success"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of CreditHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CreditHolmes> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve CreditHolmes
     * <p>
     * Receive a generator of CreditHolmes objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of CreditHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CreditHolmes> query(User user) throws Exception{
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve CreditHolmes
     * <p>
     * Receive a generator of CreditHolmes objects previously created in the Stark Infra API
     * <p>
     * Return:
     * @return generator of CreditHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CreditHolmes> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<CreditHolmes> holmes;
        public String cursor;

        public Page(List<CreditHolmes> holmes, String cursor) {
            this.holmes = holmes;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged CreditHolmes
     * <p>
     * Receive a list of up to 100 CreditHolmes objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your CreditHolmes.
     * <p>
     * Return:
     * CreditHolmes.Page.holmes: list of CreditHolmes objects with updated attributes
     * CreditHolmes.Page.cursor: cursor to retrieve the next page of CreditHolmes objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged CreditHolmes
     * <p>
     * Receive a list of up to 100 CreditHolmes objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your CreditHolmes.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * status [string, default null]: filter for status of retrieved objects. Options: "created", "failed", "success"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * CreditHolmes.Page.holmes: list of CreditHolmes objects with updated attributes
     * CreditHolmes.Page.cursor: cursor to retrieve the next page of CreditHolmes objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged CreditHolmes
     * <p>
     * Receive a list of up to 100 CreditHolmes objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your CreditHolmes.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * CreditHolmes.Page.holmes: list of CreditHolmes objects with updated attributes
     * CreditHolmes.Page.cursor: cursor to retrieve the next page of CreditHolmes objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged CreditHolmes
     * <p>
     * Receive a list of up to 100 CreditHolmes objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your CreditHolmes.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * status [string, default null]: filter for status of retrieved objects. Options: "created", "failed", "success"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * CreditHolmes.Page.holmes: list of CreditHolmes objects with updated attributes
     * CreditHolmes.Page.cursor: cursor to retrieve the next page of CreditHolmes objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<CreditHolmes> holmes = new ArrayList<>();
        for (SubResource CreditHolmes: page.entities) {
            holmes.add((CreditHolmes) CreditHolmes);
        }
        return new Page(holmes, page.cursor);

    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "CreditHolmesLog");

        public CreditHolmes holmes;
        public String[] errors;
        public String type;
        public String created;


        /**
         * CreditHolmes Log object
         * <p>
         * Every time a CreditHolmes entity is modified, a corresponding CreditHolmes Log
         * is generated for the entity. This log is never generated by the user, but it can
         * be retrieved to check additional information on the CreditHolmes.
         * <p>
         * Parameters:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param holmes [CreditHolmes Object]: CreditHolmes entity to which the log refers to.
         * @param errors [list of strings]: list of errors linked to the CreditHolmes event.
         * @param type [string]: type of the CreditHolmes event which triggered the log creation. ex: "created", "failed", "success"
         * @param created [string]: creation datetime for the log. ex: "2022-12-21T18:50:01.005022+00:00"
         */

        public Log(
            String id, CreditHolmes holmes, String[] errors, String type, String created
        ) {
            super(id);
            this.holmes = holmes;
            this.errors = errors;
            this.type = type;
            this.created = created;
        }

        /**
         * Retrieve a specific CreditHolmes Log
         * <p>
         * Receive a single CreditHolmes Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: CreditHolmes unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return CreditHolmes.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific CreditHolmes Log
         * <p>
         * Receive a single CreditHolmes Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: CreditHolmes Log unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return CreditHolmes.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve CreditHolmes Logs
         * <p>
         * Receive a generator of CreditHolmes.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["canceled", "created", "expired", "failed", "refunded", "registered", "sending", "sent", "signed", "success"]
         * holmesIds [list of strings, default null]: list of CreditHolmes ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of CreditHolmes Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve CreditHolmes Logs
         * <p>
         * Receive a generator of CreditHolmes.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of CreditHolmes Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve CreditHolmes Logs
         * <p>
         * Receive a generator of CreditHolmes.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of CreditHolmes Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve CreditHolmes Logs
         * <p>
         * Receive a generator of CreditHolmes.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["canceled", "created", "expired", "failed", "refunded", "registered", "sending", "sent", "signed", "success"]
         * holmesIds [list of strings, default null]: list of CreditHolmes ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of CreditHolmes Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<Log> logs;
            public String cursor;

            public Page(List<Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged CreditNotes Logs
         * <p>
         * Receive a list of up to 100 CreditHolmes.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["canceled", "created", "expired", "failed", "refunded", "registered", "sending", "sent", "signed", "success"]
         * holmesIds [list of strings, default null]: list of CreditHolmes ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return CreditHolmes.Log.Page object:
         * CreditHolmes.Log.Page.logs: list of CreditHolmes.Log objects with updated attributes
         * CreditHolmes.Log.Page.cursor: cursor to retrieve the next page of CreditHolmes.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged CreditHolmes Logs
         * <p>
         * Receive a list of up to 100 CreditHolmes.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return CreditHolmes.Log.Page object:
         * CreditHolmes.Log.Page.logs: list of CreditHolmes.Log objects with updated attributes
         * CreditHolmes.Log.Page.cursor: cursor to retrieve the next page of CreditHolmes.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged CreditHolmes Logs
         * <p>
         * Receive a list of up to 100 CreditHolmes.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return CreditHolmes.Log.Page object:
         * CreditHolmes.Log.Page.logs: list of CreditHolmes.Log objects with updated attributes
         * CreditHolmes.Log.Page.cursor: cursor to retrieve the next page of CreditHolmes.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged CreditHolmes Logs
         * <p>
         * Receive a list of up to 100 CreditHolmes.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["canceled", "created", "expired", "failed", "refunded", "registered", "sending", "sent", "signed", "success"]
         * holmesIds [list of strings, default null]: list of CreditHolmes ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return CreditHolmes.Log.Page object:
         * CreditHolmes.Log.Page.logs: list of CreditHolmes.Log objects with updated attributes
         * CreditHolmes.Log.Page.cursor: cursor to retrieve the next page of CreditHolmes.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
            List<Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Log.Page(logs, page.cursor);
        }
    }

    public static final class Result extends SubResource{
        /**
         * CreditHolmes.Result object
         * <p>
         * Result of the CreditHolmes investigation after the case is solved.
         * <p>
         * Parameters:
         * risk [Long]: vendor calculated risk
         * companyCount [integer]: number of financial institutions the target has relations with.
         * blockedCount [integer]: number of operations which are under legal block
         * blockedPercentage [Long]: percentage of installment amount under legal block
         * disputedCount [integer]: number of operations which are under legal dispute
         * disputedPercentage [Long]: percentage of installment amount under legal dispute
         * acquiredShare [Long]: percentage of credit operations which have been acquired from other financial institutions
         * receivedShare [Long]: percentage of credit operations which have been received from other financial institutions
         * operations [list of HashMap]: list of credit operations listed within the current competence
         * created [string]: creation date of the user in SCR database. ex: "2020-03-10"
         *
         */
        static ClassData data = new ClassData(Result.class, "Result");

        public Long risk;
        public Integer companyCount;
        public Integer blockedCount;
        public Long blockedPercentage;
        public Integer disputedCount;
        public Long disputedPercentage;
        public Long acquiredShare;
        public Long receivedShare;
        public List<HashMap<String, Object>> operations;
        public String created;

        /**
         * CreditHolmes.Result object
         * <p>
         * Result of the CreditHolmes investigation after the case is solved.
         * <p>
         * Parameters:
         * @param risk [Long]: vendor calculated risk
         * @param companyCount [integer]: number of financial institutions the target has relations with.
         * @param blockedCount [integer]: number of operations which are under legal block
         * @param blockedPercentage [Long]: percentage of installment amount under legal block
         * @param disputedCount [integer]: number of operations which are under legal dispute
         * @param disputedPercentage [Long]: percentage of installment amount under legal dispute
         * @param acquiredShare [Long]: percentage of credit operations which have been acquired from other financial institutions
         * @param receivedShare [Long]: percentage of credit operations which have been received from other financial institutions
         * @param operations [list of HashMap]: list of credit operations listed within the current competence
         * @param created [string]: creation date of the user in SCR database. ex: "2020-03-10"
         */
        public Result(
            Long risk, Integer companyCount, Integer blockedCount, Long blockedPercentage, 
            Integer disputedCount, Long disputedPercentage, Long acquiredShare, 
            Long receivedShare, List<HashMap<String, Object>> operations, 
            String created
        ) {
            this.risk = risk;
            this.companyCount = companyCount;
            this.blockedCount = blockedCount;
            this.blockedPercentage = blockedPercentage;
            this.disputedCount = disputedCount;
            this.disputedPercentage = disputedPercentage;
            this.acquiredShare = acquiredShare;
            this.receivedShare = receivedShare;
            this.operations = operations;
            this.created = created;
        }

        /**
         * CreditHolmes.Result object
         * <p>
         * Result of the CreditHolmes investigation after the case is solved.
         * <p>
         * Attributes (return-only):
         * @param data map of properties for the creation of the CreditNote.Result
         * risk [Long]: vendor calculated risk
         * companyCount [integer]: number of financial institutions the target has relations with.
         * blockedCount [integer]: number of operations which are under legal block
         * blockedPercentage [Long]: percentage of installment amount under legal block
         * disputedCount [integer]: number of operations which are under legal dispute
         * disputedPercentage [Long]: percentage of installment amount under legal dispute
         * acquiredShare [Long]: percentage of credit operations which have been acquired from other financial institutions
         * receivedShare [Long]: percentage of credit operations which have been received from other financial institutions
         * operations [list of HashMap]: list of credit operations listed within the current competence
         * created [string]: creation date of the user in SCR database. ex: "2020-03-10"
         */
        @SuppressWarnings("unchecked")
        public Result(Map<String, Object> data) throws Exception {
            HashMap<String, Object> dataCopy = new HashMap<>(data);

            this.risk = null;
            this.companyCount = null;
            this.blockedCount = null;
            this.blockedPercentage = null;
            this.disputedCount = null;
            this.disputedPercentage = null;
            this.acquiredShare = null;
            this.receivedShare = null;
            this.operations = null;
            this.created = null;

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }
    }
}
