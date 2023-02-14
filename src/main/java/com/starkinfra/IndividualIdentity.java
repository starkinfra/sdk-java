package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.SubResource;
import com.starkinfra.error.ErrorElement;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IndividualIdentity extends Resource {
    /**
     * IndividualIdentity object
     * <p>
     * IndividualIdentities are used to aggregate a list of IndividualDocument
     * objects for natural person documents check.
     * <p>
     * When you initialize an IndividualIdentity, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * name [string]: credit receiver's full name. ex: "Edward Stark"
     * taxId [string]: credit receiver's tax ID (CPF). ex: "594.739.480-42"
     * tags [list of strings, default []]: list of strings for reference when searching for IndividualIdentities. ex: ["employees", "monthly"]
     * id [string]: unique id returned when the IndividualIdentity is created. ex: "5656565656565656"
     * status [string]: current status of the IndividualIdentity. ex: "created", "canceled", "processing", "failed", "success"
     * created [string]: creation datetime for the IndividualIdentity. ex: "2020-03-11 08:00:00.000"
     * 
     */
    static ClassData data = new ClassData(IndividualIdentity.class, "IndividualIdentity");

    public String name;
    public String taxId;
    public String externalId;
    public String[] tags;
    public String status;
    public String created;

    /**
     * IndividualIdentity object
     * <p>
     * IndividualIdentities are used to aggregate an object list of IndividualDocuments
     * for natural person documents check.
     * <p>
     * When you initialize an IndividualIdentity, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * All parameters are passed in a Map of String and Object.
     * <p>
     * Parameters:
     * @param name [string]: credit receiver's full name. ex: "Anthony Edward Stark"
     * @param taxId [string]: credit receiver's tax ID (CPF or CNPJ). ex: "20.018.183/0001-80"
     * @param tags [list of strings, default []]: list of strings for reference when searching for IndividualIdentities. ex: ["employees", "monthly"]
     * @param id [string]: unique id returned when the IndividualIdentity is created. ex: "5656565656565656"
     * @param status [string]: current status of the IndividualIdentity. Options: "created", "canceled", "processing", "failed" or "success"
     * @param created [string]: creation datetime for the IndividualIdentity. ex: "2020-03-11 08:00:00.000"
     */
    public IndividualIdentity(
        String name, String taxId, String[] tags, String id, String status, String created
    ) throws Exception {
        super(id);
        this.name = name;
        this.taxId = taxId;
        this.tags = tags;
        this.status = status;
        this.created = created;
    }

    /**
     * IndividualIdentity object
     * <p>
     * IndividualIdentities are used to aggregate an object list of IndividualDocuments
     * for natural person documents check.
     * <p>
     * When you initialize an IndividualIdentity, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * All parameters are passed in a Map of String and Object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the IndividualIdentity
     * name [string]: credit receiver's full name. ex: "Anthony Edward Stark"
     * taxId [string]: credit receiver's tax ID (CPF or CNPJ). ex: "20.018.183/0001-80"
     * <p>
     * Parameters (optional):
     * tags [list of strings, default []]: list of strings for reference when searching for IndividualIdentities. ex: ["employees", "monthly"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the IndividualIdentity is created. ex: "5656565656565656"
     * status [string]: current status of the IndividualIdentity. Options: "created", "canceled", "processing", "failed" or "success"
     * created [string]: creation datetime for the IndividualIdentity. ex: "2020-03-11 08:00:00.000"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public IndividualIdentity(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.name = (String) dataCopy.remove("name");
        this.taxId = (String) dataCopy.remove("taxId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.status = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create IndividualIdentity
     * <p>
     * Send a list of IndividualIdentity objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param identities [list of IndividualIdentity objects or Maps]: list of IndividualIdentity objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of IndividualIdentity objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<IndividualIdentity> create(List<IndividualIdentity> identities, User user) throws Exception {
        List<IndividualIdentity> identitiesList = new ArrayList<>();
        for (Object identity : identities){
            if (identity instanceof Map){
                identitiesList.add(new IndividualIdentity((Map<String, Object>) identity));
                continue;
            }
            if (identity instanceof IndividualIdentity){
                identitiesList.add((IndividualIdentity) identity);
                continue;
            }
            throw new Exception("Unknown type \"" + identity.getClass() + "\", use IndividualIdentity or HashMap");
        }
        return Rest.post(data, identitiesList, user);
    }

    /**
     * Create IndividualIdentity
     * <p>
     * Send a list of IndividualIdentity objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param identities [list of IndividualIdentity objects or Maps]: list of IndividualIdentity objects to be created in the API
     * <p>
     * Return:
     * @return list of IndividualIdentity objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<IndividualIdentity> create(List<IndividualIdentity> identities) throws Exception {
        return IndividualIdentity.create(identities, null);
    }

    /**
     * Retrieve a specific IndividualIdentity
     * <p>
     * Receive a single IndividualIdentity object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IndividualIdentity object with updated attributes
     * @throws Exception error in the request
     */
    public static IndividualIdentity get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific IndividualIdentity
     * <p>
     * Receive a single IndividualIdentity object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IndividualIdentity object with updated attributes
     * @throws Exception error in the request
     */
    public static IndividualIdentity get(String id) throws Exception {
        return IndividualIdentity.get(id, null);
    }

    /**
     * Retrieve IndividualIdentities
     * <p>
     * Receive a generator of IndividualIdentity objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["canceled", "created", "expired", "failed", "processing", "signed", "success"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IndividualIdentity objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualIdentity> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IndividualIdentities
     * <p>
     * Receive a generator of IndividualIdentity objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["canceled", "created", "expired", "failed", "processing", "signed", "success"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of IndividualIdentity objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualIdentity> query(Map<String, Object> params) throws Exception {
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IndividualIdentities
     * <p>
     * Receive a generator of IndividualIdentity objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IndividualIdentity objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualIdentity> query(User user) throws Exception {
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve IndividualIdentities
     * <p>
     * Receive a generator of IndividualIdentity objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of IndividualIdentity objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualIdentity> query() throws Exception {
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IndividualIdentity> identities;
        public String cursor;
        public Page(List<IndividualIdentity> identities, String cursor) {
            this.identities = identities;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IndividualIdentities
     * <p>
     * Receive a list of up to 100 IndividualIdentity objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["canceled", "created", "expired", "failed", "processing", "signed", "success"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IndividualIdentity.Page object:
     * IndividualIdentity.Page.identities: list of IndividualIdentity objects with updated attributes
     * IndividualIdentity.Page.cursor: cursor to retrieve the next page of IndividualIdentity objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<IndividualIdentity> identities = new ArrayList<>();
        for (SubResource identity: page.entities) {
            identities.add((IndividualIdentity) identity);
        }
        return new Page(identities, page.cursor);
    }

    /**
     * Retrieve paged IndividualIdentity
     * <p>
     * Receive a list of up to 100 IndividualIdentity objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["canceled", "created", "expired", "failed", "processing", "signed", "success"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return IndividualIdentity.Page object:
     * IndividualIdentity.Page.identities: list of IndividualIdentity objects with updated attributes
     * IndividualIdentity.Page.cursor: cursor to retrieve the next page of IndividualIdentity objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IndividualIdentities
     * <p>
     * Receive a list of up to 100 IndividualIdentity objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return IndividualIdentity.Page object:
     * IndividualIdentity.Page.identities: list of IndividualIdentity objects with updated attributes
     * IndividualIdentity.Page.cursor: cursor to retrieve the next page of IndividualIdentity objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IndividualIdentities
     * <p>
     * Receive a list of up to 100 IndividualIdentity objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return IndividualIdentity.Page object:
     * IndividualIdentity.Page.identities: list of IndividualIdentity objects with updated attributes
     * IndividualIdentity.Page.cursor: cursor to retrieve the next page of IndividualIdentity objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Update IndividualIdentity entity
     * <p>
     * Update IndividualIdentity by passing id.
     * <p>
     * Parameters:
     * @param id [string]: IndividualIdentity id. ex: "5656565656565656"
     * @param status [string]: You may send IndividualDocuments to validation by passing 'processing' in the status. Options: "processing".
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IndividualIdentity object with updated attributes
     * @throws Exception error in the request
     */
    public static IndividualIdentity update(String id, String status, User user) throws Exception {
        Map<String, Object> patchData = new HashMap<String, Object>();
        patchData.put("status", status);

        return Rest.patch(data, id, patchData, user);
    }

    /**
     * Update IndividualIdentity entity
     * <p>
     * Update the IndividualIdentity by passing id.
     * <p>
     * Parameters:
     * @param id [string]: IndividualIdentity id. ex: "5656565656565656"
     * @param status [string]: You may send IndividualDocuments to validation by passing 'processing' in the status. Options: "rejected", "accepted", "partiallyAccepted".
     * <p>
     * Return:
     * @return IndividualIdentity object with updated attributes
     * @throws Exception error in the request
     */
    public static IndividualIdentity update(String id, String status) throws Exception {
        return IndividualIdentity.update(id, status, null);
    }

    /**
     * Cancel an IndividualIdentity entity
     * <p>
     * Cancel an IndividualIdentity entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled IndividualIdentity object
     * @throws Exception error in the request
     */
    public static IndividualIdentity cancel(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * Cancel an IndividualIdentity entity
     * <p>
     * Cancel an IndividualIdentity entity previously created in the Stark Infra API
     * <p>
     * Parameters (required):
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return canceled IndividualIdentity object
     * @throws Exception error in the request
     */
    public static IndividualIdentity cancel(String id) throws Exception {
        return IndividualIdentity.cancel(id, null);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "IndividualIdentityLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public IndividualIdentity identity;

        /**
         * IndividualIdentity Log object
         * <p>
         * Every time an IndividualIdentity entity is modified, a corresponding IndividualIdentity Log
         * is generated for the entity. This log is never generated by the user.
         * <p>
         * Parameters:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param identity [IndividualIdentity object]: IndividualIdentity entity to which the log refers to.
         * @param errors [list of strings]: list of errors linked to the IndividualIdentity event.
         * @param type [string]: type of the IndividualIdentity event which triggered the log creation. ex: "processing" or "success"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10"
         */
        public Log(String created, String type, List<ErrorElement> errors, IndividualIdentity identity, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.identity = identity;
        }

        /**
         * Retrieve a specific IndividualIdentity Log
         * <p>
         * Receive a single IndividualIdentity Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return IndividualIdentity.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific IndividualIdentity Log
         * <p>
         * Receive a single IndividualIdentity Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Project object]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IndividualIdentity.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve IndividualIdentity Logs
         * <p>
         * Receive a generator of IndividualIdentity.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * identityIds [list of strings, default null]: list of IndividualIdentity ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of IndividualIdentity Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve IndividualIdentity Logs
         * <p>
         * Receive a generator of IndividualIdentity.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IndividualIdentity Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve IndividualIdentity Logs
         * <p>
         * Receive a generator of IndividualIdentity.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of IndividualIdentity Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve IndividualIdentity Logs
         * <p>
         * Receive a generator of IndividualIdentity.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * identityIds [list of strings, default null]: list of IndividualIdentity ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IndividualIdentity Log objects with updated attributes
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
         * Retrieve paged IndividualIdentities.Logs
         * <p>
         * Receive a list of up to 100 IndividualIdentity.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * identityIds [list of strings, default null]: list of IndividualIdentity ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return IndividualIdentity.Log.Page object:
         * IndividualIdentity.Log.Page.logs: list of IndividualIdentity.Log objects with updated attributes
         * IndividualIdentity.Log.Page.cursor: cursor to retrieve the next page of IndividualIdentity.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged IndividualIdentity.Logs
         * <p>
         * Receive a list of up to 100 IndividualIdentity.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IndividualIdentity.Log.Page object:
         * IndividualIdentity.Log.Page.logs: list of IndividualIdentity.Log objects with updated attributes
         * IndividualIdentity.Log.Page.cursor: cursor to retrieve the next page of IndividualIdentity.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged IndividualIdentity.Logs
         * <p>
         * Receive a list of up to 100 IndividualIdentity.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return IndividualIdentity.Log.Page object:
         * IndividualIdentity.Log.Page.logs: list of IndividualIdentity.Log objects with updated attributes
         * IndividualIdentity.Log.Page.cursor: cursor to retrieve the next page of IndividualIdentity.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged IndividualIdentity.Logs
         * <p>
         * Receive a list of up to 100 IndividualIdentity.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * identityIds [list of strings, default null]: list of IndividualIdentity ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IndividualIdentity.Log.Page object:
         * IndividualIdentity.Log.Page.logs: list of IndividualIdentity.Log objects with updated attributes
         * IndividualIdentity.Log.Page.cursor: cursor to retrieve the next page of IndividualIdentity.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params, User user) throws Exception {
            com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
            List<Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }
}
