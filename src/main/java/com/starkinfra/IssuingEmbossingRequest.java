package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.error.ErrorElement;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IssuingEmbossingRequest extends Resource {
    /**
     * IssuingEmbossingRequest object
     * <p>
     * The IssuingEmbossingRequest object displays the information of embossing requests in your Workspace.
     * <p>
     * When you initialize a IssuingEmbossingRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * cardId [string]: id of the IssuingCard to be embossed. ex "5656565656565656"
     * kitId [string]: card embossing kit id. ex "5656565656565656"
     * displayName1 [string]: card displayed name. ex: "ANTHONY STARK"
     * shippingCity [string]: shipping city. ex: "NEW YORK"
     * shippingCountryCode [string]: shipping country code. ex: "US"
     * shippingDistrict [string]: shipping district. ex: "NY"
     * shippingStateCode [string]: shipping state code. ex: "NY"
     * shippingStreetLine1 [string]: shipping main address. ex: "AVENUE OF THE AMERICAS"
     * shippingStreetLine2 [string]: shipping address complement. ex: "Apt. 6"
     * shippingService [string]: shipping service. ex: "loggi"
     * shippingTrackingNumber [string]: shipping tracking number. ex: "5656565656565656"
     * shippingZipCode [string]: shipping zip code. ex: "12345-678"
     * embosserId [string]: id of the card embosser. ex: "5656565656565656"
     * displayName2 [string]: card displayed name. ex: "IT Services"
     * displayName3 [string]: card displayed name. ex: "StarkBank S.A."
     * shippingPhone [string]: shipping phone. ex: "+5511999999999"
     * tags [list of strings, default null]: list of strings for tagging. ex: ["card", "corporate"]
     * id [string]: unique id returned when IssuingEmbossingRequest is created. ex: "5656565656565656"
     * fee [integer]: fee charged when IssuingEmbossingRequest is created. ex: 1000
     * status [string]: status of the IssuingEmbossingRequest. ex: "created", "processing", "success", "failed"
     * updated [string]: latest update datetime for the IssuingEmbossingRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingEmbossingRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(IssuingEmbossingRequest.class, "IssuingEmbossingRequest");

    public String cardId;
    public String kitId;
    public String displayName1;
    public String shippingCity;
    public String shippingCountryCode;
    public String shippingDistrict;
    public String shippingStateCode;
    public String shippingStreetLine1;
    public String shippingStreetLine2;
    public String shippingService;
    public String shippingTrackingNumber;
    public String shippingZipCode;
    public String embosserId;
    public String displayName2;
    public String displayName3;
    public String shippingPhone;
    public String[] tags;
    public Integer fee;
    public String status;
    public String updated;
    public String created;
    
    /**
     * IssuingEmbossingRequest object
     * <p>
     * The IssuingEmbossingRequest objects display information on the card embossing requests made in your Workspace.
     * <p>
     * When you initialize a IssuingEmbossingRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * @param cardId [string]: id of the IssuingCard to be embossed. ex "5656565656565656"
     * @param kitId [string]: card embossing kit id. ex "5656565656565656".
     * @param displayName1 [string]: card displayed name. ex: "ANTHONY STARK"
     * @param shippingCity [string]: shipping city. ex: "NEW YORK"
     * @param shippingCountryCode [string]: shipping country code. ex: "US"
     * @param shippingDistrict [string]: shipping district. ex: "NY"
     * @param shippingStateCode [string]: shipping state code. ex: "NY"
     * @param shippingStreetLine1 [string]: shipping main address. ex: "AVENUE OF THE AMERICAS"
     * @param shippingStreetLine2 [string]: shipping address complement. ex: "Apt. 6"
     * @param shippingService [string]: shipping service. ex: "loggi"
     * @param shippingTrackingNumber [string]: shipping tracking number. ex: "5656565656565656"
     * @param shippingZipCode [string]: shipping zip code. ex: "12345-678"
     * @param embosserId [string]: id of the card embosser. ex: "5656565656565656"
     * @param displayName2 [string]: card displayed name. ex: "IT Services"
     * @param displayName3 [string]: card displayed name. ex: "StarkBank S.A."
     * @param shippingPhone [string]: shipping phone. ex: "+5511999999999"
     * @param tags [list of strings, default null]: list of strings for tagging. ex: ["card", "corporate"]
     * @param id [string]: unique id returned when IssuingEmbossingRequest is created. ex: "5656565656565656"
     * @param fee [integer]: fee charged when IssuingEmbossingRequest is created. ex: 1000
     * @param status [string]: status of the IssuingEmbossingRequest. ex: "created", "processing", "success", "failed"
     * @param updated [string]: latest update datetime for the IssuingEmbossingRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the IssuingEmbossingRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingEmbossingRequest(
        String cardId, String kitId, String displayName1,
        String shippingCity, String shippingCountryCode, String shippingDistrict, 
        String shippingStateCode, String shippingStreetLine1, String shippingStreetLine2, 
        String shippingService, String shippingTrackingNumber, String shippingZipCode, 
        String embosserId, String displayName2, String displayName3, String shippingPhone, 
        String[] tags, String id, Integer fee, String status, String updated, String created
    ) {
        super(id);
        this.cardId = cardId;
        this.kitId = kitId;
        this.displayName1 = displayName1;
        this.shippingCity = shippingCity;
        this.shippingCountryCode = shippingCountryCode;
        this.shippingDistrict = shippingDistrict;
        this.shippingStateCode = shippingStateCode;
        this.shippingStreetLine1 = shippingStreetLine1;
        this.shippingStreetLine2 = shippingStreetLine2;
        this.shippingService = shippingService;
        this.shippingTrackingNumber = shippingTrackingNumber;
        this.shippingZipCode = shippingZipCode;
        this.embosserId = embosserId;
        this.displayName2 = displayName2;
        this.displayName3 = displayName3;
        this.shippingPhone = shippingPhone;
        this.tags = tags;
        this.fee = fee;
        this.status = status;
        this.updated = updated;
        this.created = created;
    }

    /**
     * IssuingEmbossingRequest object
     * <p>
     * The IssuingEmbossingRequest object displays the information of the request orders created in your Workspace.
     * <p>
     * When you initialize a IssuingEmbossingRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the IssuingEmbossingRequest
     * cardId [string]: id of the IssuingCard to be embossed. ex "5656565656565656"
     * kitId [string]: card embossing kit id. ex "5656565656565656"
     * displayName1 [string]: card displayed name. ex: "ANTHONY STARK"
     * shippingCity [string]: shipping city. ex: "NEW YORK"
     * shippingCountryCode [string]: shipping country code. ex: "US"
     * shippingDistrict [string]: shipping district. ex: "NY"
     * shippingStateCode [string]: shipping state code. ex: "NY"
     * shippingStreetLine1 [string]: shipping main address. ex: "AVENUE OF THE AMERICAS"
     * shippingStreetLine2 [string]: shipping address complement. ex: "Apt. 6"
     * shippingService [string]: shipping service. ex: "loggi"
     * shippingTrackingNumber [string]: shipping tracking number. ex: "5656565656565656"
     * shippingZipCode [string]: shipping zip code. ex: "12345-678"
     * embosserId [string]: id of the card embosser. ex: "5656565656565656"
     * displayName2 [string]: card displayed name. ex: "IT Services"
     * displayName3 [string]: card displayed name. ex: "StarkBank S.A."
     * shippingPhone [string]: shipping phone. ex: "+5511999999999"
     * <p>
     * Parameters (optional):
     * tags [list of strings, default null]: list of strings for tagging. ex: ["card", "corporate"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when IssuingEmbossingRequest is created. ex: "5656565656565656"
     * fee [integer]: fee charged when IssuingEmbossingRequest is created. ex: 1000
     * status [string]: status of the IssuingEmbossingRequest. ex: "created", "processing", "success", "failed"
     * updated [string]: latest update datetime for the IssuingEmbossingRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingEmbossingRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public IssuingEmbossingRequest(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        
        this.cardId = (String) dataCopy.remove("cardId");
        this.kitId = (String) dataCopy.remove("kitId");
        this.displayName1 = (String) dataCopy.remove("displayName1");
        this.shippingCity = (String) dataCopy.remove("shippingCity");
        this.shippingCountryCode = (String) dataCopy.remove("shippingCountryCode");
        this.shippingDistrict = (String) dataCopy.remove("shippingDistrict");
        this.shippingStateCode = (String) dataCopy.remove("shippingStateCode");
        this.shippingStreetLine1 = (String) dataCopy.remove("shippingStreetLine1");
        this.shippingStreetLine2 = (String) dataCopy.remove("shippingStreetLine2");
        this.shippingService = (String) dataCopy.remove("shippingService");
        this.shippingTrackingNumber = (String) dataCopy.remove("shippingTrackingNumber");
        this.shippingZipCode = (String) dataCopy.remove("shippingZipCode");
        this.embosserId = (String) dataCopy.remove("embosserId");
        this.displayName2 = (String) dataCopy.remove("displayName2");
        this.displayName3 = (String) dataCopy.remove("displayName3");
        this.shippingPhone = (String) dataCopy.remove("shippingPhone");
        this.tags = (String[]) dataCopy.remove("tags");
        this.fee = null;
        this.status = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create IssuingEmbossingRequests
     * <p>
     * Send a list of IssuingEmbossingRequest objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param requests [list of IssuingEmbossingRequest objects]: list of IssuingEmbossingRequest objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of IssuingEmbossingRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<IssuingEmbossingRequest> create(List<IssuingEmbossingRequest> requests, User user) throws Exception {
        return Rest.post(data, requests, user);
    }

    /**
     * Create IssuingEmbossingRequests
     * <p>
     * Send a list of IssuingEmbossingRequest objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param requests [list of IssuingEmbossingRequest objects]: list of IssuingEmbossingRequest objects to be created in the API
     * <p>
     * Return:
     * @return list of IssuingEmbossingRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<IssuingEmbossingRequest> create(List<IssuingEmbossingRequest> requests) throws Exception {
        return IssuingEmbossingRequest.create(requests, null);
    }

    /**
     * Retrieve IssuingEmbossingRequests
     * <p>
     * Receive a generator of IssuingEmbossingRequest objects registered to your workspace in the Stark Infra API.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "processing", "success", "failed"]
     * cardIds [list of string, default null]: list of cardIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingEmbossingRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingEmbossingRequest> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IssuingEmbossingRequests
     * <p>
     * Receive a generator of IssuingEmbossingRequest objects registered to your workspace in the Stark Infra API.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "processing", "success", "failed"]
     * cardIds [list of string, default null]: list of cardIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return generator of IssuingEmbossingRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingEmbossingRequest> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IssuingEmbossingRequests
     * <p>
     * Receive a generator of IssuingEmbossingRequest objects registered to your workspace in the Stark Infra API.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingEmbossingRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingEmbossingRequest> query(User user) throws Exception{
        return Rest.getStream(data, new HashMap<>(), user);
    }


    /**
     * Retrieve IssuingEmbossingRequests
     * <p>
     * Receive a generator of IssuingEmbossingRequest objects registered to your workspace in the Stark Infra API.
     * <p>
     * Return:
     * @return generator of IssuingEmbossingRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingEmbossingRequest> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IssuingEmbossingRequest> requests;
        public String cursor;

        public Page(List<IssuingEmbossingRequest> requests, String cursor) {
            this.requests = requests;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingEmbossingRequests
     * <p>
     * Receive a list of up to 100 IssuingEmbossingRequest objects registered to your workspace in the Stark Infra API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "processing", "success", "failed"]
     * cardIds [list of string, default null]: list of cardIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingEmbossingRequest.Page object:
     * IssuingEmbossingRequest.Page.requests: list of IssuingEmbossingRequest objects with updated attributes
     * IssuingEmbossingRequest.Page.cursor: cursor to retrieve the next page of IssuingEmbossingRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingEmbossingRequest> requests = new ArrayList<>();
        for (SubResource card: page.entities) {
            requests.add((IssuingEmbossingRequest) card);
        }
        return new Page(requests, page.cursor);
    }

    /**
     * Retrieve paged IssuingEmbossingRequests
     * <p>
     * Receive a list of up to 100 IssuingEmbossingRequest objects registered to your workspace in the Stark Infra API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "processing", "success", "failed"]
     * cardIds [list of string, default null]: list of cardIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return IssuingEmbossingRequest.Page object:
     * IssuingEmbossingRequest.Page.requests: list of IssuingEmbossingRequest objects with updated attributes
     * IssuingEmbossingRequest.Page.cursor: cursor to retrieve the next page of IssuingEmbossingRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingEmbossingRequests
     * <p>
     * Receive a list of up to 100 IssuingEmbossingRequest objects registered to your workspace in the Stark Infra API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingEmbossingRequest.Page object:
     * IssuingEmbossingRequest.Page.requests: list of IssuingEmbossingRequest objects with updated attributes
     * IssuingEmbossingRequest.Page.cursor: cursor to retrieve the next page of IssuingEmbossingRequest objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingEmbossingRequests
     * <p>
     * Receive a list of up to 100 IssuingEmbossingRequest objects registered to your workspace in the Stark Infra API and the cursor to the next page.
     * <p>
     * Return:
     * @return IssuingEmbossingRequest.Page object:
     * IssuingEmbossingRequest.Page.requests: list of IssuingEmbossingRequest objects with updated attributes
     * IssuingEmbossingRequest.Page.cursor: cursor to retrieve the next page of IssuingEmbossingRequest objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve a specific IssuingEmbossingRequest
     * <p>
     * Receive a single IssuingEmbossingRequest object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingEmbossingRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingEmbossingRequest get(String id, User user) throws Exception{
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific IssuingEmbossingRequest
     * <p>
     * Receive a single IssuingEmbossingRequest object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingEmbossingRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingEmbossingRequest get(String id) throws Exception{
        return IssuingEmbossingRequest.get(id, null);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(IssuingEmbossingRequest.Log.class, "IssuingEmbossingRequestLog");

        public IssuingEmbossingRequest request;
        public String type;
        public List<ErrorElement> errors;
        public String created;

        /**
         * IssuingEmbossingRequest.Log object
         * <p>
         * Every time an IssuingEmbossingRequest entity is modified, a corresponding IssuingEmbossingRequest.Log
         * is generated for the entity. This log is never generated by the user, 
         * but it can be retrieved to check additional information on the IssuingEmbossingRequest.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param request [IssuingEmbossingRequest object]: IssuingEmbossingRequest entity to which the log refers to.
         * @param type [string]: type of the IssuingEmbossingRequest event which triggered the log creation. Options: "created", "processing", "confirmed"
         * @param errors [list of ErrorElement]: list of errors linked to this IssuingEmbossingRequest event.
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Log(String id, IssuingEmbossingRequest request, String type, List<ErrorElement> errors, String created ) {
            super(id);
            this.request = request;
            this.type = type;
            this.errors = errors;
            this.created = created;
        }

        /**
         * Retrieve a specific IssuingEmbossingRequest.Log
         * <p>
         * Receive a single IssuingEmbossingRequest.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return IssuingEmbossingRequest.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static IssuingEmbossingRequest.Log get(String id) throws Exception {
            return IssuingEmbossingRequest.Log.get(id, null);
        }

        /**
         * Retrieve a specific IssuingEmbossingRequest.Log
         * <p>
         * Receive a single IssuingEmbossingRequest.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingEmbossingRequest.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static IssuingEmbossingRequest.Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve IssuingEmbossingRequest.Log objects
         * <p>
         * Receive a generator of IssuingEmbossingRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created", "processing", "confirmed"]
         * requestIds [list of strings, default null]: list of IssuingEmbossingRequest ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of IssuingEmbossingRequest.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<IssuingEmbossingRequest.Log> query(Map<String, Object> params) throws Exception {
            return IssuingEmbossingRequest.Log.query(params, null);
        }

        /**
         * Retrieve IssuingEmbossingRequest.Log objects
         * <p>
         * Receive a generator of IssuingEmbossingRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IssuingEmbossingRequest.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<IssuingEmbossingRequest.Log> query(User user) throws Exception {
            return IssuingEmbossingRequest.Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve IssuingEmbossingRequest.Log objects
         * <p>
         * Receive a generator of IssuingEmbossingRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of IssuingEmbossingRequest.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<IssuingEmbossingRequest.Log> query() throws Exception {
            return IssuingEmbossingRequest.Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve IssuingEmbossingRequest.Log objects
         * <p>
         * Receive a generator of IssuingEmbossingRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created", "processing", "confirmed"]
         * requestIds [list of strings, default null]: list of IssuingEmbossingRequest ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IssuingEmbossingRequest.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<IssuingEmbossingRequest.Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<IssuingEmbossingRequest.Log> logs;
            public String cursor;

            public Page(List<IssuingEmbossingRequest.Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged IssuingEmbossingRequest.Logs
         * <p>
         * Receive a list of up to 100 IssuingEmbossingRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created", "processing", "confirmed"]
         * requestIds [list of strings, default null]: list of IssuingEmbossingRequest ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return IssuingEmbossingRequest.Log.Page object:
         * IssuingEmbossingRequest.Log.Page.logs: list of IssuingEmbossingRequest.Log objects with updated attributes
         * IssuingEmbossingRequest.Log.Page.cursor: cursor to retrieve the next page of IssuingEmbossingRequest.Log objects
         * @throws Exception error in the request
         */
        public static IssuingEmbossingRequest.Log.Page page(Map<String, Object> params) throws Exception {
            return IssuingEmbossingRequest.Log.page(params, null);
        }

        /**
         * Retrieve paged IssuingEmbossingRequest.Logs
         * <p>
         * Receive a list of up to 100 IssuingEmbossingRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingEmbossingRequest.Log.Page object:
         * IssuingEmbossingRequest.Log.Page.logs: list of IssuingEmbossingRequest.Log objects with updated attributes
         * IssuingEmbossingRequest.Log.Page.cursor: cursor to retrieve the next page of IssuingEmbossingRequest.Log objects
         * @throws Exception error in the request
         */
        public static IssuingEmbossingRequest.Log.Page page(User user) throws Exception {
            return IssuingEmbossingRequest.Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged IssuingEmbossingRequest.Logs
         * <p>
         * Receive a list of up to 100 IssuingEmbossingRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return IssuingEmbossingRequest.Log.Page object:
         * IssuingEmbossingRequest.Log.Page.logs: list of IssuingEmbossingRequest.Log objects with updated attributes
         * IssuingEmbossingRequest.Log.Page.cursor: cursor to retrieve the next page of IssuingEmbossingRequest.Log objects
         * @throws Exception error in the request
         */
        public static IssuingEmbossingRequest.Log.Page page() throws Exception {
            return IssuingEmbossingRequest.Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged IssuingEmbossingRequest.Logs
         * <p>
         * Receive a list of up to 100 IssuingEmbossingRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created", "processing", "confirmed"]
         * requestIds [list of strings, default null]: list of IssuingEmbossingRequest ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IssuingEmbossingRequest.Log.Page object:
         * IssuingEmbossingRequest.Log.Page.logs: list of IssuingEmbossingRequest.Log objects with updated attributes
         * IssuingEmbossingRequest.Log.Page.cursor: cursor to retrieve the next page of IssuingEmbossingRequest.Log objects
         * @throws Exception error in the request
         */
        public static IssuingEmbossingRequest.Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
            List<IssuingEmbossingRequest.Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((IssuingEmbossingRequest.Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }

}
