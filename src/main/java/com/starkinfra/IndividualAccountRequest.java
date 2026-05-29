package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;
import com.starkinfra.error.ErrorElement;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IndividualAccountRequest extends Resource {
    /**
     * IndividualAccountRequest object
     * <p>
     * IndividualAccountRequests are used to open a Stark Infra account for an individual. The
     * caller submits the individual's identifying data and income, and the API runs the approval
     * flow asynchronously, moving the request through created, processing, success, failed or canceled.
     * <p>
     * When you initialize an IndividualAccountRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * name [string]: full legal name of the individual. ex: "Tony Stark"
     * taxId [string]: Brazilian CPF with or without formatting. ex: "012.345.678-90" or "01234567890"
     * address [IndividualAccountRequest.Address]: structured residential address. ex: new IndividualAccountRequest.Address(data)
     * income [Long]: monthly income in cents. Must be greater than 0. ex: 1000000 (= R$ 10,000.00)
     * tags [list of strings, default null]: list of strings for reference when searching for IndividualAccountRequests. ex: ["employees", "monthly"]
     * id [string]: unique id returned when the IndividualAccountRequest is created. ex: "5189530608992256"
     * status [string]: current IndividualAccountRequest status. ex: "created", "processing", "success", "failed" or "canceled"
     * accountType [string]: account-request kind. Always "individual" for this resource. ex: "individual"
     * flags [list of strings]: server-side review flags. Empty unless the request triggered a manual-review condition. ex: ["manualReview"]
     * created [string]: creation datetime for the IndividualAccountRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the IndividualAccountRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(IndividualAccountRequest.class, "IndividualAccountRequest");

    public String name;
    public String taxId;
    public Address address;
    public Long income;
    public String[] tags;
    public String accountType;
    public String[] flags;
    public String status;
    public String created;
    public String updated;

    /**
     * IndividualAccountRequest object
     * <p>
     * IndividualAccountRequests are used to open a Stark Infra account for an individual.
     * <p>
     * When you initialize an IndividualAccountRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param name [string]: full legal name of the individual. ex: "Tony Stark"
     * @param taxId [string]: Brazilian CPF with or without formatting. ex: "012.345.678-90" or "01234567890"
     * @param address [IndividualAccountRequest.Address]: structured residential address.
     * @param income [Long]: monthly income in cents. Must be greater than 0. ex: 1000000 (= R$ 10,000.00)
     * @param tags [list of strings, default null]: list of strings for reference when searching for IndividualAccountRequests. ex: ["employees", "monthly"]
     * @param id [string]: unique id returned when the IndividualAccountRequest is created. ex: "5189530608992256"
     * @param status [string]: current IndividualAccountRequest status. ex: "created", "processing", "success", "failed" or "canceled"
     * @param accountType [string]: account-request kind. Always "individual" for this resource. ex: "individual"
     * @param flags [list of strings]: server-side review flags. ex: ["manualReview"]
     * @param created [string]: creation datetime for the IndividualAccountRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the IndividualAccountRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IndividualAccountRequest(String name, String taxId, Address address, Long income, String[] tags,
                                    String id, String status, String accountType, String[] flags,
                                    String created, String updated) {
        super(id);
        this.name = name;
        this.taxId = taxId;
        this.address = address;
        this.income = income;
        this.tags = tags;
        this.status = status;
        this.accountType = accountType;
        this.flags = flags;
        this.created = created;
        this.updated = updated;
    }

    /**
     * IndividualAccountRequest object
     * <p>
     * IndividualAccountRequests are used to open a Stark Infra account for an individual.
     * <p>
     * When you initialize an IndividualAccountRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the IndividualAccountRequest
     * name [string]: full legal name of the individual. ex: "Tony Stark"
     * taxId [string]: Brazilian CPF with or without formatting. ex: "012.345.678-90" or "01234567890"
     * address [IndividualAccountRequest.Address or map]: structured residential address.
     * income [Long]: monthly income in cents. Must be greater than 0. ex: 1000000 (= R$ 10,000.00)
     * <p>
     * Parameters (optional):
     * tags [list of strings, default null]: list of strings for reference when searching for IndividualAccountRequests. ex: ["employees", "monthly"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the IndividualAccountRequest is created. ex: "5189530608992256"
     * status [string]: current IndividualAccountRequest status. ex: "created", "processing", "success", "failed" or "canceled"
     * accountType [string]: account-request kind. Always "individual" for this resource. ex: "individual"
     * flags [list of strings]: server-side review flags. ex: ["manualReview"]
     * created [string]: creation datetime for the IndividualAccountRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the IndividualAccountRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public IndividualAccountRequest(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.name = (String) dataCopy.remove("name");
        this.taxId = (String) dataCopy.remove("taxId");
        this.address = parseAddress(dataCopy.remove("address"));
        this.income = ((Number) dataCopy.remove("income")).longValue();
        this.tags = (String[]) dataCopy.remove("tags");
        this.status = null;
        this.accountType = null;
        this.flags = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    @SuppressWarnings("unchecked")
    private Address parseAddress(Object address) throws Exception {
        if (address == null)
            return null;

        if (address instanceof Address) {
            return (Address) address;
        }

        return new Address((Map<String, Object>) address);
    }

    /**
     * Retrieve a specific IndividualAccountRequest
     * <p>
     * Receive a single IndividualAccountRequest object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5189530608992256"
     * <p>
     * Return:
     * @return IndividualAccountRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static IndividualAccountRequest get(String id) throws Exception {
        return IndividualAccountRequest.get(id, null);
    }

    /**
     * Retrieve a specific IndividualAccountRequest
     * <p>
     * Receive a single IndividualAccountRequest object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5189530608992256"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IndividualAccountRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static IndividualAccountRequest get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve IndividualAccountRequests
     * <p>
     * Receive a generator of IndividualAccountRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "created"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of IndividualAccountRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualAccountRequest> query(Map<String, Object> params) throws Exception {
        return IndividualAccountRequest.query(params, null);
    }

    /**
     * Retrieve IndividualAccountRequests
     * <p>
     * Receive a generator of IndividualAccountRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IndividualAccountRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualAccountRequest> query(User user) throws Exception {
        return IndividualAccountRequest.query(new HashMap<>(), user);
    }

    /**
     * Retrieve IndividualAccountRequests
     * <p>
     * Receive a generator of IndividualAccountRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of IndividualAccountRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualAccountRequest> query() throws Exception {
        return IndividualAccountRequest.query(new HashMap<>(), null);
    }

    /**
     * Retrieve IndividualAccountRequests
     * <p>
     * Receive a generator of IndividualAccountRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "created"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IndividualAccountRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualAccountRequest> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<IndividualAccountRequest> requests;
        public String cursor;

        public Page(List<IndividualAccountRequest> requests, String cursor) {
            this.requests = requests;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IndividualAccountRequests
     * <p>
     * Receive a list of up to 100 IndividualAccountRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "created"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return IndividualAccountRequest.Page object:
     * IndividualAccountRequest.Page.requests: list of IndividualAccountRequest objects with updated attributes
     * IndividualAccountRequest.Page.cursor: cursor to retrieve the next page of IndividualAccountRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IndividualAccountRequests
     * <p>
     * Receive a list of up to 100 IndividualAccountRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IndividualAccountRequest.Page object:
     * IndividualAccountRequest.Page.requests: list of IndividualAccountRequest objects with updated attributes
     * IndividualAccountRequest.Page.cursor: cursor to retrieve the next page of IndividualAccountRequest objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IndividualAccountRequests
     * <p>
     * Receive a list of up to 100 IndividualAccountRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return IndividualAccountRequest.Page object:
     * IndividualAccountRequest.Page.requests: list of IndividualAccountRequest objects with updated attributes
     * IndividualAccountRequest.Page.cursor: cursor to retrieve the next page of IndividualAccountRequest objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged IndividualAccountRequests
     * <p>
     * Receive a list of up to 100 IndividualAccountRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "created"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IndividualAccountRequest.Page object:
     * IndividualAccountRequest.Page.requests: list of IndividualAccountRequest objects with updated attributes
     * IndividualAccountRequest.Page.cursor: cursor to retrieve the next page of IndividualAccountRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<IndividualAccountRequest> requests = new ArrayList<>();
        for (SubResource request: page.entities) {
            requests.add((IndividualAccountRequest) request);
        }
        return new Page(requests, page.cursor);
    }

    /**
     * Create IndividualAccountRequests
     * <p>
     * Send a list of IndividualAccountRequest objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param requests [list of IndividualAccountRequest objects or HashMaps]: list of IndividualAccountRequest objects to be created in the API
     * <p>
     * Return:
     * @return list of IndividualAccountRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<IndividualAccountRequest> create(List<?> requests) throws Exception {
        return IndividualAccountRequest.create(requests, null);
    }

    /**
     * Create IndividualAccountRequests
     * <p>
     * Send a list of IndividualAccountRequest objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param requests [list of IndividualAccountRequest objects or HashMaps]: list of IndividualAccountRequest objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of IndividualAccountRequest objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<IndividualAccountRequest> create(List<?> requests, User user) throws Exception {
        List<IndividualAccountRequest> requestList = new ArrayList<>();
        for (Object request : requests){
            if (request instanceof Map){
                requestList.add(new IndividualAccountRequest((Map<String, Object>) request));
                continue;
            }
            if (request instanceof IndividualAccountRequest){
                requestList.add((IndividualAccountRequest) request);
                continue;
            }
            throw new Exception("Unknown type \"" + request.getClass() + "\", use IndividualAccountRequest or HashMap");
        }
        return Rest.post(data, requestList, user);
    }

    /**
     * Update IndividualAccountRequest entity
     * <p>
     * Update an IndividualAccountRequest by passing id.
     * <p>
     * Parameters:
     * @param id [string]: IndividualAccountRequest id. ex: "5189530608992256"
     * @param patchData map of parameters
     * name [string, default null]: replace the legal name. ex: "Tony Stark"
     * taxId [string, default null]: replace the CPF. ex: "012.345.678-90"
     * address [map, default null]: replace the address as a whole object (no partial address PATCH).
     * income [Long, default null]: replace monthly income in cents. ex: 1000000
     * status [string, default null]: manual state transition. ex: "processing"
     * tags [list of strings, default null]: replace tag list. ex: ["employees", "monthly"]
     * <p>
     * Return:
     * @return IndividualAccountRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static IndividualAccountRequest update(String id, Map<String, Object> patchData) throws Exception {
        return IndividualAccountRequest.update(id, patchData, null);
    }

    /**
     * Update IndividualAccountRequest entity
     * <p>
     * Update an IndividualAccountRequest by passing id.
     * <p>
     * Parameters:
     * @param id [string]: IndividualAccountRequest id. ex: "5189530608992256"
     * @param patchData map of parameters
     * name [string, default null]: replace the legal name. ex: "Tony Stark"
     * taxId [string, default null]: replace the CPF. ex: "012.345.678-90"
     * address [map, default null]: replace the address as a whole object (no partial address PATCH).
     * income [Long, default null]: replace monthly income in cents. ex: 1000000
     * status [string, default null]: manual state transition. ex: "processing"
     * tags [list of strings, default null]: replace tag list. ex: ["employees", "monthly"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IndividualAccountRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static IndividualAccountRequest update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    /**
     * IndividualAccountRequest.Address object
     * <p>
     * Embedded value object describing the individual's residential address. It has no endpoints
     * of its own; it is exposed only as the address field on the parent and is serialized as a
     * nested JSON object on the wire.
     * <p>
     * Parameters:
     * street [string]: street name. ex: "Rua do Estilo Barroco"
     * number [string]: street number. ex: "648"
     * neighborhood [string]: neighborhood / district. ex: "Santo Amaro"
     * city [string]: city. ex: "Sao Paulo"
     * state [string]: state (BR 2-letter code). ex: "SP"
     * zipCode [string]: ZIP code (BR CEP) with or without formatting. ex: "05724005"
     *
     */
    public final static class Address extends SubResource {
        public String street;
        public String number;
        public String neighborhood;
        public String city;
        public String state;
        public String zipCode;

        /**
         * IndividualAccountRequest.Address object
         * <p>
         * Embedded value object describing the individual's residential address.
         * <p>
         * Parameters:
         * @param street [string]: street name. ex: "Rua do Estilo Barroco"
         * @param number [string]: street number. ex: "648"
         * @param neighborhood [string]: neighborhood / district. ex: "Santo Amaro"
         * @param city [string]: city. ex: "Sao Paulo"
         * @param state [string]: state (BR 2-letter code). ex: "SP"
         * @param zipCode [string]: ZIP code (BR CEP) with or without formatting. ex: "05724005"
         */
        public Address(String street, String number, String neighborhood, String city, String state, String zipCode) {
            this.street = street;
            this.number = number;
            this.neighborhood = neighborhood;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
        }

        /**
         * IndividualAccountRequest.Address object
         * <p>
         * Embedded value object describing the individual's residential address.
         * <p>
         * Parameters:
         * @param data map of properties for the creation of the IndividualAccountRequest.Address
         * street [string]: street name. ex: "Rua do Estilo Barroco"
         * number [string]: street number. ex: "648"
         * neighborhood [string]: neighborhood / district. ex: "Santo Amaro"
         * city [string]: city. ex: "Sao Paulo"
         * state [string]: state (BR 2-letter code). ex: "SP"
         * zipCode [string]: ZIP code (BR CEP) with or without formatting. ex: "05724005"
         * @throws Exception error in the request
         */
        public Address(Map<String, Object> data) throws Exception {
            HashMap<String, Object> dataCopy = new HashMap<>(data);

            this.street = (String) dataCopy.remove("street");
            this.number = (String) dataCopy.remove("number");
            this.neighborhood = (String) dataCopy.remove("neighborhood");
            this.city = (String) dataCopy.remove("city");
            this.state = (String) dataCopy.remove("state");
            this.zipCode = (String) dataCopy.remove("zipCode");

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "IndividualAccountRequestLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public IndividualAccountRequest request;

        /**
         * IndividualAccountRequest Log object
         * <p>
         * Every time an IndividualAccountRequest entity is modified, a corresponding IndividualAccountRequest Log
         * is generated for the entity. This log is never generated by the user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param request [IndividualAccountRequest]: IndividualAccountRequest entity to which the log refers to.
         * @param errors [list of ErrorElement]: list of errors linked to the IndividualAccountRequest event.
         * @param type [string]: type of the IndividualAccountRequest event which triggered the log creation. ex: "processing" or "success"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Log(String created, String type, List<ErrorElement> errors, IndividualAccountRequest request, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.request = request;
        }

        /**
         * Retrieve a specific IndividualAccountRequest Log
         * <p>
         * Receive a single IndividualAccountRequest Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return IndividualAccountRequest Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific IndividualAccountRequest Log
         * <p>
         * Receive a single IndividualAccountRequest Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IndividualAccountRequest Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve IndividualAccountRequest Logs
         * <p>
         * Receive a generator of IndividualAccountRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * accountRequestIds [list of strings, default null]: list of IndividualAccountRequest ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of IndividualAccountRequest Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve IndividualAccountRequest Logs
         * <p>
         * Receive a generator of IndividualAccountRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IndividualAccountRequest Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve IndividualAccountRequest Logs
         * <p>
         * Receive a generator of IndividualAccountRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of IndividualAccountRequest Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve IndividualAccountRequest Logs
         * <p>
         * Receive a generator of IndividualAccountRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * accountRequestIds [list of strings, default null]: list of IndividualAccountRequest ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IndividualAccountRequest Log objects with updated attributes
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
         * Retrieve paged IndividualAccountRequest.Logs
         * <p>
         * Receive a list of up to 100 IndividualAccountRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * accountRequestIds [list of strings, default null]: list of IndividualAccountRequest ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return IndividualAccountRequest.Log.Page object:
         * IndividualAccountRequest.Log.Page.logs: list of IndividualAccountRequest.Log objects with updated attributes
         * IndividualAccountRequest.Log.Page.cursor: cursor to retrieve the next page of IndividualAccountRequest.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged IndividualAccountRequest.Logs
         * <p>
         * Receive a list of up to 100 IndividualAccountRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IndividualAccountRequest.Log.Page object:
         * IndividualAccountRequest.Log.Page.logs: list of IndividualAccountRequest.Log objects with updated attributes
         * IndividualAccountRequest.Log.Page.cursor: cursor to retrieve the next page of IndividualAccountRequest.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged IndividualAccountRequest.Logs
         * <p>
         * Receive a list of up to 100 IndividualAccountRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return IndividualAccountRequest.Log.Page object:
         * IndividualAccountRequest.Log.Page.logs: list of IndividualAccountRequest.Log objects with updated attributes
         * IndividualAccountRequest.Log.Page.cursor: cursor to retrieve the next page of IndividualAccountRequest.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged IndividualAccountRequest.Logs
         * <p>
         * Receive a list of up to 100 IndividualAccountRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * accountRequestIds [list of strings, default null]: list of IndividualAccountRequest ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IndividualAccountRequest.Log.Page object:
         * IndividualAccountRequest.Log.Page.logs: list of IndividualAccountRequest.Log objects with updated attributes
         * IndividualAccountRequest.Log.Page.cursor: cursor to retrieve the next page of IndividualAccountRequest.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Log.Page(logs, page.cursor);
        }
    }
}
