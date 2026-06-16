package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class PixKeyHolmes extends Resource {
    /**
     * PixKeyHolmes object
     * <p>
     * A PixKeyHolmes is used to investigate the registration status of a Pix Key
     * in the Central Bank's DICT. You open one per key you want to check; the API
     * resolves it asynchronously and reports back whether the key is registered.
     * <p>
     * When you initialize a PixKeyHolmes, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * keyId [string]: Pix Key to be investigated. ex: "+5511989898989", "11.222.333/0001-00", "valid@sandbox.com"
     * tags [list of strings, default null]: list of strings for reference when searching for PixKeyHolmes. ex: ["travel", "food"]
     * id [string]: unique id returned when the PixKeyHolmes is created. ex: "5656565656565656"
     * result [string]: investigation outcome once solved. Options: "registered", "unregistered"
     * status [string]: current PixKeyHolmes status. Options: "created", "solving", "solved", "failed"
     * created [string]: creation datetime for the PixKeyHolmes. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixKeyHolmes. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(PixKeyHolmes.class, "PixKeyHolmes");

    public String keyId;
    public String[] tags;
    public String result;
    public String status;
    public String created;
    public String updated;

    /**
     * PixKeyHolmes object
     * <p>
     * When you initialize a PixKeyHolmes, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param keyId [string]: Pix Key to be investigated. ex: "+5511989898989", "11.222.333/0001-00", "valid@sandbox.com"
     * @param tags [list of strings, default null]: list of strings for reference when searching for PixKeyHolmes. ex: ["travel", "food"]
     * @param id [string]: unique id returned when the PixKeyHolmes is created. ex: "5656565656565656"
     * @param result [string]: investigation outcome once solved. Options: "registered", "unregistered"
     * @param status [string]: current PixKeyHolmes status. Options: "created", "solving", "solved", "failed"
     * @param created [string]: creation datetime for the PixKeyHolmes. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the PixKeyHolmes. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public PixKeyHolmes(
        String keyId, String[] tags, String id, String result,
        String status, String created, String updated
    ) {
        super(id);
        this.keyId = keyId;
        this.tags = tags;
        this.result = result;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    /**
     * PixKeyHolmes object
     * <p>
     * When you initialize a PixKeyHolmes, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the PixKeyHolmes
     * keyId [string]: Pix Key to be investigated. ex: "+5511989898989", "11.222.333/0001-00", "valid@sandbox.com"
     * <p>
     * Parameters (optional):
     * tags [list of strings, default null]: list of strings for reference when searching for PixKeyHolmes. ex: ["travel", "food"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the PixKeyHolmes is created. ex: "5656565656565656"
     * result [string]: investigation outcome once solved. Options: "registered", "unregistered"
     * status [string]: current PixKeyHolmes status. Options: "created", "solving", "solved", "failed"
     * created [string]: creation datetime for the PixKeyHolmes. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixKeyHolmes. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public PixKeyHolmes(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.keyId = (String) dataCopy.remove("keyId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.result = null;
        this.status = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve PixKeyHolmes
     * <p>
     * Receive a generator of PixKeyHolmes objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "solving", "solved", "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["travel", "food"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of PixKeyHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixKeyHolmes> query(Map<String, Object> params) throws Exception {
        return PixKeyHolmes.query(params, null);
    }

    /**
     * Retrieve PixKeyHolmes
     * <p>
     * Receive a generator of PixKeyHolmes objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixKeyHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixKeyHolmes> query(User user) throws Exception {
        return PixKeyHolmes.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PixKeyHolmes
     * <p>
     * Receive a generator of PixKeyHolmes objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of PixKeyHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixKeyHolmes> query() throws Exception {
        return PixKeyHolmes.query(new HashMap<>(), null);
    }

    /**
     * Retrieve PixKeyHolmes
     * <p>
     * Receive a generator of PixKeyHolmes objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "solving", "solved", "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["travel", "food"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixKeyHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixKeyHolmes> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<PixKeyHolmes> holmes;
        public String cursor;

        public Page(List<PixKeyHolmes> holmes, String cursor) {
            this.holmes = holmes;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged PixKeyHolmes
     * <p>
     * Receive a list of up to 100 PixKeyHolmes objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your PixKeyHolmes.
     * <p>
     * Return:
     * @return PixKeyHolmes.Page object:
     * PixKeyHolmes.Page.holmes: list of PixKeyHolmes objects with updated attributes
     * PixKeyHolmes.Page.cursor: cursor to retrieve the next page of PixKeyHolmes objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PixKeyHolmes
     * <p>
     * Receive a list of up to 100 PixKeyHolmes objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your PixKeyHolmes.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixKeyHolmes.Page object:
     * PixKeyHolmes.Page.holmes: list of PixKeyHolmes objects with updated attributes
     * PixKeyHolmes.Page.cursor: cursor to retrieve the next page of PixKeyHolmes objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PixKeyHolmes
     * <p>
     * Receive a list of up to 100 PixKeyHolmes objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your PixKeyHolmes.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "solving", "solved", "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["travel", "food"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return PixKeyHolmes.Page object:
     * PixKeyHolmes.Page.holmes: list of PixKeyHolmes objects with updated attributes
     * PixKeyHolmes.Page.cursor: cursor to retrieve the next page of PixKeyHolmes objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged PixKeyHolmes
     * <p>
     * Receive a list of up to 100 PixKeyHolmes objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your PixKeyHolmes.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "solving", "solved", "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["travel", "food"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixKeyHolmes.Page object:
     * PixKeyHolmes.Page.holmes: list of PixKeyHolmes objects with updated attributes
     * PixKeyHolmes.Page.cursor: cursor to retrieve the next page of PixKeyHolmes objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<PixKeyHolmes> holmes = new ArrayList<>();
        for (SubResource sherlock : page.entities) {
            holmes.add((PixKeyHolmes) sherlock);
        }
        return new Page(holmes, page.cursor);
    }

    /**
     * Create PixKeyHolmes
     * <p>
     * Send a list of PixKeyHolmes objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param holmes [list of PixKeyHolmes objects or HashMaps]: list of PixKeyHolmes objects to be created in the API
     * <p>
     * Return:
     * @return list of PixKeyHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<PixKeyHolmes> create(List<?> holmes) throws Exception {
        return PixKeyHolmes.create(holmes, null);
    }

    /**
     * Create PixKeyHolmes
     * <p>
     * Send a list of PixKeyHolmes objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param holmes [list of PixKeyHolmes objects or HashMaps]: list of PixKeyHolmes objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of PixKeyHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<PixKeyHolmes> create(List<?> holmes, User user) throws Exception {
        List<PixKeyHolmes> sherlockList = new ArrayList<>();
        for (Object sherlock : holmes){
            if (sherlock instanceof Map){
                sherlockList.add(new PixKeyHolmes((Map<String, Object>) sherlock));
                continue;
            }
            if (sherlock instanceof PixKeyHolmes){
                sherlockList.add((PixKeyHolmes) sherlock);
                continue;
            }
            throw new Exception("Unknown type \"" + sherlock.getClass() + "\", use PixKeyHolmes or HashMap");
        }
        return Rest.post(data, sherlockList, user);
    }
}
