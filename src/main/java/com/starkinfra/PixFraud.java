package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public final class PixFraud extends Resource {
    /**
     * PixFraud object
     * <p>
     * Pix Frauds are used to report the PixKey or taxId when a fraud
     * has been confirmed.
     * <p>
     * When you initialize a PixFraud, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * externalId [string]: a string that must be unique among all your PixFrauds, used to avoid resource duplication. ex: "my-internal-id-123456"
     * type [string]: type of PixFraud. Options: "identity", "mule", "scam", "other"
     * tags [list of strings]: list of strings for tagging. ex: ["fraudulent"]
     * id [string]: unique id returned when the PixFraud is created. ex: "5656565656565656"
     * bacenId [string]: unique transaction id returned from Central Bank. ex: "ccf9bd9c-e99d-999e-bab9-b999ca999f99"
     * keyId [string]: marked PixKey id. ex: "+5511989898989"
     * taxId [string]: user tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * status [string]: current PixFraud status. Options: "created", "failed", "registered", "canceled".
     * created [string]: creation datetime for the PixFraud. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixFraud. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(PixFraud.class, "PixFraud");

    public String externalId;
    public String type;
    public String[] tags;
    public String bacenId;
    public String keyId;
    public String taxId;
    public String status;
    public String created;
    public String updated;

    /**
     * PixFraud object
     * <p>
     * When you initialize a PixFraud, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param externalId [string]: a string that must be unique among all your PixFrauds, used to avoid resource duplication. ex: "my-internal-id-123456"
     * @param type [string]: type of PixFraud. Options: "identity", "mule", "scam", "other"
     * @param taxId [string]: user tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * @param tags [list of strings]: list of strings for tagging. ex: ["fraudulent"]
     * @param id [string]: unique id returned when the PixFraud is created. ex: "5656565656565656"
     * @param bacenId [string]: a string that must be unique among all your PixFrauds, used to avoid resource duplication. ex: "my-internal-id-123456"
     * @param keyId [string]: marked PixKey id. ex: "+5511989898989"
     * @param status [string]: current PixFraud status. Options: "created", "failed", "registered", "canceled".
     * @param created [string]: creation datetime for the PixFraud. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the PixFraud. ex: "2020-03-10 10:30:00.000000+00:00"

     */
    public PixFraud(String externalId, String type, String taxId, String[] tags, String id,
                    String bacenId, String keyId, String status, String created, String updated
    ) {
        super(id);
        this.externalId = externalId;
        this.type = type;
        this.taxId = taxId;
        this.tags = tags;
        this.bacenId = bacenId;
        this.keyId = keyId;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    /**
     * PixFraud object
     * <p>
     * When you initialize a PixFraud, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the PixFraud
     * externalId [string]: a string that must be unique among all your PixFrauds, used to avoid resource duplication. ex: "my-internal-id-123456"
     * type [string]: type of Pix Fraud. Options: "identity", "mule", "scam", "other"
     * taxId [string]: user tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * <p>
     * Parameters (optional):
     * tags [list of strings]: list of strings for tagging. ex: ["fraudulent"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the PixFraud is created. ex: "5656565656565656"
     * bacenId [string]: id of the bacen institution. ex "5656565656565656"
     * keyId [string]: marked PixKey id. ex: "+5511989898989"
     * status [string]: current PixFraud status. Options: "created", "failed", "registered", "canceled".
     * created [string]: creation datetime for the PixFraud. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixFraud. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public PixFraud(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.externalId = (String) dataCopy.remove("externalId");
        this.type = (String) dataCopy.remove("type");
        this.taxId = (String) dataCopy.remove("taxId");;
        this.bacenId = null;
        this.keyId = null;
        this.tags = null;
        this.status = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific PixFraud
     * <p>
     * Receive a single PixFraud object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return PixFraud object with updated attributes
     * @throws Exception error in the request
     */
    public static PixFraud get(String id) throws Exception {
        return PixFraud.get(id, null);
    }

    /**
     * Retrieve a specific PixFraud
     * <p>
     * Receive a single PixFraud object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixFraud object with updated attributes
     * @throws Exception error in the request
     */
    public static PixFraud get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve PixFrauds
     * <p>
     * Receive a generator of PixFraud objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "registered", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved PixFrauds. Options: "identity", "mule", "scam", "other"
     * tags [list of strings]: list of strings for tagging. ex: ["fraudulent"]
     * <p>
     * Return:
     * @return generator of PixFraud objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixFraud> query(Map<String, Object> params) throws Exception {
        return PixFraud.query(params, null);
    }

    /**
     * Retrieve PixFrauds
     * <p>
     * Receive a generator of PixFraud objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixFraud objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixFraud> query(User user) throws Exception {
        return PixFraud.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PixFrauds
     * <p>
     * Receive a generator of PixFraud objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of PixFraud objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixFraud> query() throws Exception {
        return PixFraud.query(new HashMap<>(), null);
    }

    /**
     * Retrieve PixFrauds
     * <p>
     * Receive a generator of PixFraud objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "registered", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved PixFrauds. Options: "identity", "mule", "scam", "other"
     * tags [list of strings]: list of strings for tagging. ex: ["fraudulent"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixFraud objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixFraud> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<PixFraud> frauds;
        public String cursor;

        public Page(List<PixFraud> frauds, String cursor) {
            this.frauds = frauds;
            this.cursor = cursor;
        }
    }

    /**
     * Cancel a PixFraud entity
     * <p>
     * Cancel a PixFraud entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: unique id returned when the PixFraud is created. ex: "5656565656565656"
     * <p>
     * Return:
     * @return canceled PixKey object
     * @throws Exception error in the request
     */
    public static PixFraud cancel(String id) throws Exception {
        return PixFraud.cancel(id, null);
    }

    /**
     * Cancel a PixFraud entity
     * <p>
     * Cancel a PixFraud entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: unique id returned when the PixFraud is created. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled PixFraud object
     * @throws Exception error in the request
     */
    public static PixFraud cancel(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * Retrieve paged PixFrauds
     * <p>
     * Receive a list of up to 100 PixFraud objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your frauds.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "registered", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved PixFrauds. Options: "identity", "mule", "scam", "other"
     * tags [list of strings]: list of strings for tagging. ex: ["fraudulent"]
     * <p>
     * Return:
     * @return PixFraud.Page object:
     * PixFraud.Page.frauds: list of PixFraud objects with updated attributes
     * PixFraud.Page.cursor: cursor to retrieve the next page of PixFraud objects
     * @throws Exception error in the request
     */
    public static PixFraud.Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged PixFrauds
     * <p>
     * Receive a list of up to 100 PixFraud objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your frauds.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixFraud.Page object:
     * PixFraud.Page.frauds: list of PixFraud objects with updated attributes
     * PixFraud.Page.cursor: cursor to retrieve the next page of PixFraud objects
     * @throws Exception error in the request
     */
    public static PixFraud.Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PixFrauds
     * <p>
     * Receive a list of up to 100 PixFraud objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your frauds.
     * <p>
     * Return:
     * @return PixFraud.Page object:
     * PixFraud.Page.frauds: list of PixFraud objects with updated attributes
     * PixFraud.Page.cursor: cursor to retrieve the next page of PixFraud objects
     * @throws Exception error in the request
     */
    public static PixFraud.Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PixFrauds
     * <p>
     * Receive a list of up to 100 PixFraud objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your frauds.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "registered", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved PixFrauds. Options: "identity", "mule", "scam", "other"
     * tags [list of strings]: list of strings for tagging. ex: ["fraudulent"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixFraud.Page object:
     * PixFraud.Page.frauds: list of PixFraud objects with updated attributes
     * PixFraud.Page.cursor: cursor to retrieve the next page of PixFraud objects
     * @throws Exception error in the request
     */
    public static PixFraud.Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<PixFraud> frauds = new ArrayList<>();
        for (SubResource Fraud: page.entities) {
            frauds.add((PixFraud) Fraud);
        }
        return new PixFraud.Page(frauds, page.cursor);
    }

    /**
     * Create a PixFraud
     * <p>
     * Send a list of PixFraud object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param frauds [list of PixFraud objects or HashMaps]: list of PixFraud objects to be created in the API
     * <p>
     * Return:
     * @return PixFraud object with updated attributes
     * @throws Exception error in the request
     */
    public static List<PixFraud> create(List<?> frauds) throws Exception {
        return PixFraud.create(frauds, null);
    }

    /**
     * Create a PixFraud
     * <p>
     * Send a list of PixFraud object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param frauds [list of PixFraud objects or HashMaps]: list of PixFraud objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixFraud object with updated attributes
     * @throws Exception error in the request
     */
    public static List<PixFraud> create(List<?> frauds, User user) throws Exception {
        List<PixFraud> FraudList = new ArrayList<>();
        for (Object Fraud : frauds){
            if (Fraud instanceof Map){
                FraudList.add(new PixFraud((Map<String, Object>) Fraud));
                continue;
            }
            if (Fraud instanceof PixFraud){
                FraudList.add((PixFraud) Fraud);
                continue;
            }
            throw new Exception("Unknown type \"" + Fraud.getClass() + "\", use PixFraud or HashMap");
        }
        return Rest.post(data, FraudList, user);
    }
}
