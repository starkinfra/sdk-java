package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class BusinessAccountRequest extends Resource {
    /**
     * BusinessAccountRequest object
     * <p>
     * You can create a business account request to request an account for a specific company, opening the
     * account with identity verification by webview for each of its owners.
     * <p>
     * When you initialize a BusinessAccountRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * address [BusinessAccountRequest.Address object]: company's structured address. ex: new BusinessAccountRequest.Address(...)
     * revenue [Long]: company's annual revenue in cents. ex: 100000000L (= R$ 1,000,000.00)
     * name [string]: company's legal name (minimum 5 characters). ex: "Stark Bank S.A."
     * taxId [string]: company's tax ID (CNPJ). ex: "20.018.183/0001-80"
     * owners [list of BusinessAccountRequest.Owner objects]: list of 1 to 10 company owners. ex: [new BusinessAccountRequest.Owner(...)]
     * tags [list of strings, default null]: list of strings for reference when searching for BusinessAccountRequests. ex: ["employees", "monthly"]
     * id [string]: unique id returned when the BusinessAccountRequest is created. ex: "5656565656565656"
     * accountType [string]: type of the account. ex: "business"
     * flags [list of HashMaps]: flags that motivated the decision, populated when the request is denied. Each flag has a code and a message. ex: [{"code": "failedIdentityProof", "message": "O representante: 012.345.678-90 falhou na verificação de identidade."}]
     * status [string]: current status of the BusinessAccountRequest. Options: "created", "processing", "approved", "denied", "failed"
     * created [string]: creation datetime for the BusinessAccountRequest. ex: "2020-03-10 10:30:00.000"
     * updated [string]: latest update datetime for the BusinessAccountRequest. ex: "2020-03-10 10:30:00.000"
     *
     */
    static ClassData data = new ClassData(BusinessAccountRequest.class, "BusinessAccountRequest");

    public Address address;
    public Long revenue;
    public String name;
    public String taxId;
    public List<Owner> owners;
    public String[] tags;
    public String accountType;
    public List<HashMap<String, Object>> flags;
    public String status;
    public String created;
    public String updated;

    /**
     * BusinessAccountRequest object
     * <p>
     * You can create a business account request to request an account for a specific company, opening the
     * account with identity verification by webview for each of its owners.
     * <p>
     * When you initialize a BusinessAccountRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param address [BusinessAccountRequest.Address object]: company's structured address. ex: new BusinessAccountRequest.Address(...)
     * @param revenue [Long]: company's annual revenue in cents. ex: 100000000L (= R$ 1,000,000.00)
     * @param name [string]: company's legal name (minimum 5 characters). ex: "Stark Bank S.A."
     * @param taxId [string]: company's tax ID (CNPJ). ex: "20.018.183/0001-80"
     * @param owners [list of BusinessAccountRequest.Owner objects]: list of 1 to 10 company owners. ex: [new BusinessAccountRequest.Owner(...)]
     * @param tags [list of strings, default null]: list of strings for reference when searching for BusinessAccountRequests. ex: ["employees", "monthly"]
     * @param id [string]: unique id returned when the BusinessAccountRequest is created. ex: "5656565656565656"
     * @param accountType [string]: type of the account. ex: "business"
     * @param flags [list of HashMaps]: flags that motivated the decision, populated when the request is denied. Each flag has a code and a message.
     * @param status [string]: current status of the BusinessAccountRequest. Options: "created", "processing", "approved", "denied", "failed"
     * @param created [string]: creation datetime for the BusinessAccountRequest. ex: "2020-03-10 10:30:00.000"
     * @param updated [string]: latest update datetime for the BusinessAccountRequest. ex: "2020-03-10 10:30:00.000"
     */
    public BusinessAccountRequest(
        Address address, Long revenue, String name, String taxId, List<Owner> owners, String[] tags, String id,
        String accountType, List<HashMap<String, Object>> flags, String status, String created, String updated
    ) throws Exception {
        super(id);
        this.address = address;
        this.revenue = revenue;
        this.name = name;
        this.taxId = taxId;
        this.owners = owners;
        this.tags = tags;
        this.accountType = accountType;
        this.flags = flags;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    /**
     * BusinessAccountRequest object
     * <p>
     * You can create a business account request to request an account for a specific company, opening the
     * account with identity verification by webview for each of its owners.
     * <p>
     * When you initialize a BusinessAccountRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * All parameters are passed in a Map of String and Object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the BusinessAccountRequest
     * address [BusinessAccountRequest.Address object or Map]: company's structured address. ex: new BusinessAccountRequest.Address(...)
     * revenue [Long]: company's annual revenue in cents. ex: 100000000L (= R$ 1,000,000.00)
     * name [string]: company's legal name (minimum 5 characters). ex: "Stark Bank S.A."
     * taxId [string]: company's tax ID (CNPJ). ex: "20.018.183/0001-80"
     * owners [list of BusinessAccountRequest.Owner objects or Maps]: list of 1 to 10 company owners. ex: [new BusinessAccountRequest.Owner(...)]
     * <p>
     * Parameters (optional):
     * tags [list of strings, default null]: list of strings for reference when searching for BusinessAccountRequests. ex: ["employees", "monthly"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the BusinessAccountRequest is created. ex: "5656565656565656"
     * accountType [string]: type of the account. ex: "business"
     * flags [list of HashMaps]: flags that motivated the decision, populated when the request is denied. Each flag has a code and a message.
     * status [string]: current status of the BusinessAccountRequest. Options: "created", "processing", "approved", "denied", "failed"
     * created [string]: creation datetime for the BusinessAccountRequest. ex: "2020-03-10 10:30:00.000"
     * updated [string]: latest update datetime for the BusinessAccountRequest. ex: "2020-03-10 10:30:00.000"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public BusinessAccountRequest(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.address = parseAddress(dataCopy.remove("address"));
        Object revenue = dataCopy.remove("revenue");
        this.revenue = revenue == null ? null : ((Number) revenue).longValue();
        this.name = (String) dataCopy.remove("name");
        this.taxId = (String) dataCopy.remove("taxId");
        this.owners = parseOwners((List<Object>) dataCopy.remove("owners"));
        this.tags = (String[]) dataCopy.remove("tags");
        this.accountType = null;
        this.flags = null;
        this.status = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    @SuppressWarnings("unchecked")
    private static Address parseAddress(Object address) throws Exception {
        if (address == null) {
            return null;
        }
        if (address instanceof Address) {
            return (Address) address;
        }
        return new Address((Map<String, Object>) address);
    }

    @SuppressWarnings("unchecked")
    private static List<Owner> parseOwners(List<Object> owners) throws Exception {
        if (owners == null) {
            return null;
        }
        List<Owner> parsed = new ArrayList<>();
        for (Object owner : owners) {
            if (owner instanceof Owner) {
                parsed.add((Owner) owner);
                continue;
            }
            parsed.add(new Owner((Map<String, Object>) owner));
        }
        return parsed;
    }

    /**
     * Create BusinessAccountRequests
     * <p>
     * Send a list of BusinessAccountRequest objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param requests [list of BusinessAccountRequest objects or Maps]: list of BusinessAccountRequest objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of BusinessAccountRequest objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<BusinessAccountRequest> create(List<?> requests, User user) throws Exception {
        List<BusinessAccountRequest> requestsList = new ArrayList<>();
        for (Object request : requests){
            if (request instanceof Map){
                requestsList.add(new BusinessAccountRequest((Map<String, Object>) request));
                continue;
            }
            if (request instanceof BusinessAccountRequest){
                requestsList.add((BusinessAccountRequest) request);
                continue;
            }
            throw new Exception("Unknown type \"" + request.getClass() + "\", use BusinessAccountRequest or HashMap");
        }
        return Rest.post(data, requestsList, user);
    }

    /**
     * Create BusinessAccountRequests
     * <p>
     * Send a list of BusinessAccountRequest objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param requests [list of BusinessAccountRequest objects or Maps]: list of BusinessAccountRequest objects to be created in the API
     * <p>
     * Return:
     * @return list of BusinessAccountRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<BusinessAccountRequest> create(List<?> requests) throws Exception {
        return BusinessAccountRequest.create(requests, null);
    }

    /**
     * Retrieve a specific BusinessAccountRequest
     * <p>
     * Receive a single BusinessAccountRequest object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return BusinessAccountRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static BusinessAccountRequest get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific BusinessAccountRequest
     * <p>
     * Receive a single BusinessAccountRequest object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return BusinessAccountRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static BusinessAccountRequest get(String id) throws Exception {
        return BusinessAccountRequest.get(id, null);
    }

    /**
     * Retrieve BusinessAccountRequests
     * <p>
     * Receive a generator of BusinessAccountRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "processing", "approved", "denied", "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of BusinessAccountRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BusinessAccountRequest> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve BusinessAccountRequests
     * <p>
     * Receive a generator of BusinessAccountRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "processing", "approved", "denied", "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of BusinessAccountRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BusinessAccountRequest> query(Map<String, Object> params) throws Exception {
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve BusinessAccountRequests
     * <p>
     * Receive a generator of BusinessAccountRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of BusinessAccountRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BusinessAccountRequest> query(User user) throws Exception {
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve BusinessAccountRequests
     * <p>
     * Receive a generator of BusinessAccountRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of BusinessAccountRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BusinessAccountRequest> query() throws Exception {
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<BusinessAccountRequest> requests;
        public String cursor;
        public Page(List<BusinessAccountRequest> requests, String cursor) {
            this.requests = requests;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged BusinessAccountRequests
     * <p>
     * Receive a list of up to 100 BusinessAccountRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "processing", "approved", "denied", "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return BusinessAccountRequest.Page object:
     * BusinessAccountRequest.Page.requests: list of BusinessAccountRequest objects with updated attributes
     * BusinessAccountRequest.Page.cursor: cursor to retrieve the next page of BusinessAccountRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<BusinessAccountRequest> requests = new ArrayList<>();
        for (SubResource request: page.entities) {
            requests.add((BusinessAccountRequest) request);
        }
        return new Page(requests, page.cursor);
    }

    /**
     * Retrieve paged BusinessAccountRequests
     * <p>
     * Receive a list of up to 100 BusinessAccountRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "processing", "approved", "denied", "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return BusinessAccountRequest.Page object:
     * BusinessAccountRequest.Page.requests: list of BusinessAccountRequest objects with updated attributes
     * BusinessAccountRequest.Page.cursor: cursor to retrieve the next page of BusinessAccountRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged BusinessAccountRequests
     * <p>
     * Receive a list of up to 100 BusinessAccountRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return BusinessAccountRequest.Page object:
     * BusinessAccountRequest.Page.requests: list of BusinessAccountRequest objects with updated attributes
     * BusinessAccountRequest.Page.cursor: cursor to retrieve the next page of BusinessAccountRequest objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged BusinessAccountRequests
     * <p>
     * Receive a list of up to 100 BusinessAccountRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return BusinessAccountRequest.Page object:
     * BusinessAccountRequest.Page.requests: list of BusinessAccountRequest objects with updated attributes
     * BusinessAccountRequest.Page.cursor: cursor to retrieve the next page of BusinessAccountRequest objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    public final static class Address extends SubResource {
        public String street;
        public String number;
        public String neighborhood;
        public String city;
        public String state;
        public String zipCode;
        public String complement;

        /**
         * BusinessAccountRequest.Address object
         * <p>
         * The Address object is the structured address of the company referenced by a
         * BusinessAccountRequest. It is embedded on the parent's address field and has no endpoints of its own.
         * <p>
         * Parameters:
         * @param street [string]: street name. ex: "Av. Faria Lima"
         * @param number [string]: street number. ex: "2000"
         * @param neighborhood [string]: neighborhood / district. ex: "Itaim Bibi"
         * @param city [string]: city. ex: "Sao Paulo"
         * @param state [string]: state (BR 2-letter code). ex: "SP"
         * @param zipCode [string]: ZIP code (BR CEP), formatted or digit-only. ex: "04538-132"
         * @param complement [string, default null]: address complement. ex: "Sala 42"
         */
        public Address(String street, String number, String neighborhood, String city, String state, String zipCode, String complement) {
            this.street = street;
            this.number = number;
            this.neighborhood = neighborhood;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
            this.complement = complement;
        }

        /**
         * BusinessAccountRequest.Address object
         * <p>
         * The Address object is the structured address of the company referenced by a
         * BusinessAccountRequest. It is embedded on the parent's address field and has no endpoints of its own.
         * <p>
         * Parameters:
         * @param data map of properties for the creation of the BusinessAccountRequest.Address
         * street [string]: street name. ex: "Av. Faria Lima"
         * number [string]: street number. ex: "2000"
         * neighborhood [string]: neighborhood / district. ex: "Itaim Bibi"
         * city [string]: city. ex: "Sao Paulo"
         * state [string]: state (BR 2-letter code). ex: "SP"
         * zipCode [string]: ZIP code (BR CEP), formatted or digit-only. ex: "04538-132"
         * complement [string, default null]: address complement. ex: "Sala 42"
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
            this.complement = (String) dataCopy.remove("complement");

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }
    }

    public final static class Owner extends SubResource {
        public String taxId;
        public String name;
        public String role;
        public String identityId;
        public String validatorLink;
        public String status;

        /**
         * BusinessAccountRequest.Owner object
         * <p>
         * The Owner object represents a company owner referenced by a BusinessAccountRequest. Each owner
         * completes its own identity verification through an independent webview. It is embedded on the
         * parent's owners field and has no endpoints of its own.
         * <p>
         * Parameters:
         * @param taxId [string]: owner's tax ID (CPF). ex: "012.345.678-90"
         * @param name [string]: owner's full name (minimum 5 characters). ex: "Jamie Lannister"
         * @param role [string]: owner's role in the company. Options: "partner", "representative"
         * @param identityId [string]: unique id of the identity verification linked to this owner. ex: "5709594221805568"
         * @param validatorLink [string]: webview link to be delivered to the owner to complete biometrics and document capture. Treat it as a credential: deliver it through a secure channel and never log it.
         * @param status [string]: current status of the owner verification. Options: "created", "approved", "denied"
         */
        public Owner(String taxId, String name, String role, String identityId, String validatorLink, String status) {
            this.taxId = taxId;
            this.name = name;
            this.role = role;
            this.identityId = identityId;
            this.validatorLink = validatorLink;
            this.status = status;
        }

        /**
         * BusinessAccountRequest.Owner object
         * <p>
         * The Owner object represents a company owner referenced by a BusinessAccountRequest. Each owner
         * completes its own identity verification through an independent webview. It is embedded on the
         * parent's owners field and has no endpoints of its own.
         * <p>
         * Parameters (required):
         * @param data map of properties for the creation of the BusinessAccountRequest.Owner
         * taxId [string]: owner's tax ID (CPF). ex: "012.345.678-90"
         * name [string]: owner's full name (minimum 5 characters). ex: "Jamie Lannister"
         * role [string]: owner's role in the company. Options: "partner", "representative"
         * <p>
         * Attributes (return-only):
         * identityId [string]: unique id of the identity verification linked to this owner. ex: "5709594221805568"
         * validatorLink [string]: webview link to be delivered to the owner to complete biometrics and document capture. Treat it as a credential.
         * status [string]: current status of the owner verification. Options: "created", "approved", "denied"
         * @throws Exception error in the request
         */
        public Owner(Map<String, Object> data) throws Exception {
            HashMap<String, Object> dataCopy = new HashMap<>(data);

            this.taxId = (String) dataCopy.remove("taxId");
            this.name = (String) dataCopy.remove("name");
            this.role = (String) dataCopy.remove("role");
            this.identityId = null;
            this.validatorLink = null;
            this.status = null;

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "BusinessAccountRequestLog");

        public String created;
        public String type;
        public List<String> errors;
        public BusinessAccountRequest request;

        /**
         * BusinessAccountRequest.Log object
         * <p>
         * Every time a BusinessAccountRequest entity is modified, a corresponding BusinessAccountRequest.Log
         * is generated for the entity. This log is never generated by the user.
         * <p>
         * Parameters:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param request [BusinessAccountRequest object]: BusinessAccountRequest entity to which the log refers to.
         * @param errors [list of strings]: list of errors linked to this BusinessAccountRequest event
         * @param type [string]: type of the BusinessAccountRequest event which triggered the log creation. ex: "created", "processing", "approved", "denied", "failed"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000"
         */
        public Log(String created, String type, List<String> errors, BusinessAccountRequest request, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.request = request;
        }

        /**
         * Retrieve a specific BusinessAccountRequest.Log
         * <p>
         * Receive a single BusinessAccountRequest.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return BusinessAccountRequest.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific BusinessAccountRequest.Log
         * <p>
         * Receive a single BusinessAccountRequest.Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Project object]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return BusinessAccountRequest.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve BusinessAccountRequest.Logs
         * <p>
         * Receive a generator of BusinessAccountRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["created", "processing", "approved", "denied", "failed"]
         * accountRequestIds [list of strings, default null]: list of BusinessAccountRequest ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of BusinessAccountRequest.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve BusinessAccountRequest.Logs
         * <p>
         * Receive a generator of BusinessAccountRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of BusinessAccountRequest.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve BusinessAccountRequest.Logs
         * <p>
         * Receive a generator of BusinessAccountRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of BusinessAccountRequest.Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve BusinessAccountRequest.Logs
         * <p>
         * Receive a generator of BusinessAccountRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["created", "processing", "approved", "denied", "failed"]
         * accountRequestIds [list of strings, default null]: list of BusinessAccountRequest ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of BusinessAccountRequest.Log objects with updated attributes
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
         * Retrieve paged BusinessAccountRequest.Logs
         * <p>
         * Receive a list of up to 100 BusinessAccountRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["created", "processing", "approved", "denied", "failed"]
         * accountRequestIds [list of strings, default null]: list of BusinessAccountRequest ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return BusinessAccountRequest.Log.Page object:
         * BusinessAccountRequest.Log.Page.logs: list of BusinessAccountRequest.Log objects with updated attributes
         * BusinessAccountRequest.Log.Page.cursor: cursor to retrieve the next page of BusinessAccountRequest.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged BusinessAccountRequest.Logs
         * <p>
         * Receive a list of up to 100 BusinessAccountRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return BusinessAccountRequest.Log.Page object:
         * BusinessAccountRequest.Log.Page.logs: list of BusinessAccountRequest.Log objects with updated attributes
         * BusinessAccountRequest.Log.Page.cursor: cursor to retrieve the next page of BusinessAccountRequest.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged BusinessAccountRequest.Logs
         * <p>
         * Receive a list of up to 100 BusinessAccountRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return BusinessAccountRequest.Log.Page object:
         * BusinessAccountRequest.Log.Page.logs: list of BusinessAccountRequest.Log objects with updated attributes
         * BusinessAccountRequest.Log.Page.cursor: cursor to retrieve the next page of BusinessAccountRequest.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged BusinessAccountRequest.Logs
         * <p>
         * Receive a list of up to 100 BusinessAccountRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["created", "processing", "approved", "denied", "failed"]
         * accountRequestIds [list of strings, default null]: list of BusinessAccountRequest ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return BusinessAccountRequest.Log.Page object:
         * BusinessAccountRequest.Log.Page.logs: list of BusinessAccountRequest.Log objects with updated attributes
         * BusinessAccountRequest.Log.Page.cursor: cursor to retrieve the next page of BusinessAccountRequest.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }
}
