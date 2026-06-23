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


public final class BusinessIdentity extends Resource {
    /**
     * BusinessIdentity object
     * <p>
     * A BusinessIdentity represents a company to be validated through its tax ID (CNPJ). It can have up to two
     * BusinessAttachments attached to it, which are used to validate the company's identity. Once a BusinessIdentity is
     * created, BusinessAttachments must be attached to it using the create method of the BusinessAttachment resource.
     * When all the required BusinessAttachments are attached to a BusinessIdentity it can be sent to validation by
     * patching its status to processing.
     * <p>
     * When you initialize a BusinessIdentity, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * taxId [string]: company's tax ID (CNPJ). ex: "20.018.183/0001-80"
     * tags [list of strings, default []]: list of strings for reference when searching for BusinessIdentities. ex: ["onboarding-123"]
     * id [string]: unique id returned when the BusinessIdentity is created. ex: "5656565656565656"
     * name [string]: company's corporate name retrieved from the tax ID bureau. ex: "Stark Bank S.A."
     * taxIdStatus [string]: status of the tax ID (CNPJ) at the bureau. ex: "active", "blocked", "pending"
     * insightTaxId [string]: tax ID (CNPJ) extracted from the document by the insight. ex: "20.018.183/0001-80"
     * insightDocumentType [string]: type of document detected by the insight. ex: "incorporation"
     * numPages [integer]: number of pages of the document. ex: 12
     * representatives [string]: JSON string with the company's representatives (legal structure). ex: "[{\"name\": \"Edward Stark\", \"qualification\": \"Director\"}]"
     * attachments [list of strings]: list of attachment references linked to this identity. ex: ["attachment/5104320788332544"]
     * rules [string]: JSON string with the complemented signature rules extracted from the documents.
     * status [string]: current status of the BusinessIdentity. ex: "created", "pending", "canceled", "processing", "success", "failed"
     * created [string]: creation datetime for the BusinessIdentity. ex: "2020-03-10 10:30:00.000"
     * updated [string]: latest update datetime for the BusinessIdentity. ex: "2020-03-10 10:30:00.000"
     *
     */
    static ClassData data = new ClassData(BusinessIdentity.class, "BusinessIdentity");

    public String taxId;
    public String[] tags;
    public String name;
    public String taxIdStatus;
    public String insightTaxId;
    public String insightDocumentType;
    public Integer numPages;
    public String representatives;
    public String[] attachments;
    public String rules;
    public String status;
    public String created;
    public String updated;

    /**
     * BusinessIdentity object
     * <p>
     * A BusinessIdentity represents a company to be validated through its tax ID (CNPJ). It can have up to two
     * BusinessAttachments attached to it, which are used to validate the company's identity.
     * <p>
     * When you initialize a BusinessIdentity, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param taxId [string]: company's tax ID (CNPJ). ex: "20.018.183/0001-80"
     * @param tags [list of strings, default []]: list of strings for reference when searching for BusinessIdentities. ex: ["onboarding-123"]
     * @param id [string]: unique id returned when the BusinessIdentity is created. ex: "5656565656565656"
     * @param name [string]: company's corporate name retrieved from the tax ID bureau. ex: "Stark Bank S.A."
     * @param taxIdStatus [string]: status of the tax ID (CNPJ) at the bureau. ex: "active", "blocked", "pending"
     * @param insightTaxId [string]: tax ID (CNPJ) extracted from the document by the insight. ex: "20.018.183/0001-80"
     * @param insightDocumentType [string]: type of document detected by the insight. ex: "incorporation"
     * @param numPages [integer]: number of pages of the document. ex: 12
     * @param representatives [string]: JSON string with the company's representatives (legal structure).
     * @param attachments [list of strings]: list of attachment references linked to this identity. ex: ["attachment/5104320788332544"]
     * @param rules [string]: JSON string with the complemented signature rules extracted from the documents.
     * @param status [string]: current status of the BusinessIdentity. Options: "created", "pending", "canceled", "processing", "success" or "failed"
     * @param created [string]: creation datetime for the BusinessIdentity. ex: "2020-03-10 10:30:00.000"
     * @param updated [string]: latest update datetime for the BusinessIdentity. ex: "2020-03-10 10:30:00.000"
     */
    public BusinessIdentity(
        String taxId, String[] tags, String id, String name, String taxIdStatus, String insightTaxId,
        String insightDocumentType, Integer numPages, String representatives, String[] attachments, String rules,
        String status, String created, String updated
    ) throws Exception {
        super(id);
        this.taxId = taxId;
        this.tags = tags;
        this.name = name;
        this.taxIdStatus = taxIdStatus;
        this.insightTaxId = insightTaxId;
        this.insightDocumentType = insightDocumentType;
        this.numPages = numPages;
        this.representatives = representatives;
        this.attachments = attachments;
        this.rules = rules;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    /**
     * BusinessIdentity object
     * <p>
     * A BusinessIdentity represents a company to be validated through its tax ID (CNPJ). It can have up to two
     * BusinessAttachments attached to it, which are used to validate the company's identity.
     * <p>
     * When you initialize a BusinessIdentity, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * All parameters are passed in a Map of String and Object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the BusinessIdentity
     * taxId [string]: company's tax ID (CNPJ). ex: "20.018.183/0001-80"
     * <p>
     * Parameters (optional):
     * tags [list of strings, default []]: list of strings for reference when searching for BusinessIdentities. ex: ["onboarding-123"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the BusinessIdentity is created. ex: "5656565656565656"
     * name [string]: company's corporate name retrieved from the tax ID bureau. ex: "Stark Bank S.A."
     * taxIdStatus [string]: status of the tax ID (CNPJ) at the bureau. ex: "active", "blocked", "pending"
     * insightTaxId [string]: tax ID (CNPJ) extracted from the document by the insight. ex: "20.018.183/0001-80"
     * insightDocumentType [string]: type of document detected by the insight. ex: "incorporation"
     * numPages [integer]: number of pages of the document. ex: 12
     * representatives [string]: JSON string with the company's representatives (legal structure).
     * attachments [list of strings]: list of attachment references linked to this identity. ex: ["attachment/5104320788332544"]
     * rules [string]: JSON string with the complemented signature rules extracted from the documents.
     * status [string]: current status of the BusinessIdentity. Options: "created", "pending", "canceled", "processing", "success" or "failed"
     * created [string]: creation datetime for the BusinessIdentity. ex: "2020-03-10 10:30:00.000"
     * updated [string]: latest update datetime for the BusinessIdentity. ex: "2020-03-10 10:30:00.000"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public BusinessIdentity(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.taxId = (String) dataCopy.remove("taxId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.name = null;
        this.taxIdStatus = null;
        this.insightTaxId = null;
        this.insightDocumentType = null;
        this.numPages = null;
        this.representatives = null;
        this.attachments = null;
        this.rules = null;
        this.status = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create BusinessIdentity
     * <p>
     * Send a list of BusinessIdentity objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param identities [list of BusinessIdentity objects or Maps]: list of BusinessIdentity objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of BusinessIdentity objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<BusinessIdentity> create(List<?> identities, User user) throws Exception {
        List<BusinessIdentity> identitiesList = new ArrayList<>();
        for (Object identity : identities){
            if (identity instanceof Map){
                identitiesList.add(new BusinessIdentity((Map<String, Object>) identity));
                continue;
            }
            if (identity instanceof BusinessIdentity){
                identitiesList.add((BusinessIdentity) identity);
                continue;
            }
            throw new Exception("Unknown type \"" + identity.getClass() + "\", use BusinessIdentity or HashMap");
        }
        return Rest.post(data, identitiesList, user);
    }

    /**
     * Create BusinessIdentity
     * <p>
     * Send a list of BusinessIdentity objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param identities [list of BusinessIdentity objects or Maps]: list of BusinessIdentity objects to be created in the API
     * <p>
     * Return:
     * @return list of BusinessIdentity objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<BusinessIdentity> create(List<?> identities) throws Exception {
        return BusinessIdentity.create(identities, null);
    }

    /**
     * Retrieve a specific BusinessIdentity
     * <p>
     * Receive a single BusinessIdentity object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return BusinessIdentity object with updated attributes
     * @throws Exception error in the request
     */
    public static BusinessIdentity get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific BusinessIdentity
     * <p>
     * Receive a single BusinessIdentity object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return BusinessIdentity object with updated attributes
     * @throws Exception error in the request
     */
    public static BusinessIdentity get(String id) throws Exception {
        return BusinessIdentity.get(id, null);
    }

    /**
     * Retrieve BusinessIdentities
     * <p>
     * Receive a generator of BusinessIdentity objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["created", "pending", "canceled", "processing", "success", "failed"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * taxIds [list of strings, default null]: list of company tax IDs (CNPJ) to filter retrieved objects. ex: ["20.018.183/0001-80"]
     * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of BusinessIdentity objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BusinessIdentity> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve BusinessIdentities
     * <p>
     * Receive a generator of BusinessIdentity objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["created", "pending", "canceled", "processing", "success", "failed"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * taxIds [list of strings, default null]: list of company tax IDs (CNPJ) to filter retrieved objects. ex: ["20.018.183/0001-80"]
     * <p>
     * Return:
     * @return generator of BusinessIdentity objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BusinessIdentity> query(Map<String, Object> params) throws Exception {
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve BusinessIdentities
     * <p>
     * Receive a generator of BusinessIdentity objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of BusinessIdentity objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BusinessIdentity> query(User user) throws Exception {
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve BusinessIdentities
     * <p>
     * Receive a generator of BusinessIdentity objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of BusinessIdentity objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BusinessIdentity> query() throws Exception {
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<BusinessIdentity> identities;
        public String cursor;
        public Page(List<BusinessIdentity> identities, String cursor) {
            this.identities = identities;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged BusinessIdentities
     * <p>
     * Receive a list of up to 100 BusinessIdentity objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["created", "pending", "canceled", "processing", "success", "failed"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * taxIds [list of strings, default null]: list of company tax IDs (CNPJ) to filter retrieved objects. ex: ["20.018.183/0001-80"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return BusinessIdentity.Page object:
     * BusinessIdentity.Page.identities: list of BusinessIdentity objects with updated attributes
     * BusinessIdentity.Page.cursor: cursor to retrieve the next page of BusinessIdentity objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<BusinessIdentity> identities = new ArrayList<>();
        for (SubResource identity: page.entities) {
            identities.add((BusinessIdentity) identity);
        }
        return new Page(identities, page.cursor);
    }

    /**
     * Retrieve paged BusinessIdentities
     * <p>
     * Receive a list of up to 100 BusinessIdentity objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["created", "pending", "canceled", "processing", "success", "failed"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * taxIds [list of strings, default null]: list of company tax IDs (CNPJ) to filter retrieved objects. ex: ["20.018.183/0001-80"]
     * <p>
     * Return:
     * @return BusinessIdentity.Page object:
     * BusinessIdentity.Page.identities: list of BusinessIdentity objects with updated attributes
     * BusinessIdentity.Page.cursor: cursor to retrieve the next page of BusinessIdentity objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged BusinessIdentities
     * <p>
     * Receive a list of up to 100 BusinessIdentity objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return BusinessIdentity.Page object:
     * BusinessIdentity.Page.identities: list of BusinessIdentity objects with updated attributes
     * BusinessIdentity.Page.cursor: cursor to retrieve the next page of BusinessIdentity objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged BusinessIdentities
     * <p>
     * Receive a list of up to 100 BusinessIdentity objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return BusinessIdentity.Page object:
     * BusinessIdentity.Page.identities: list of BusinessIdentity objects with updated attributes
     * BusinessIdentity.Page.cursor: cursor to retrieve the next page of BusinessIdentity objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Update BusinessIdentity entity
     * <p>
     * Update a BusinessIdentity by passing its id.
     * <p>
     * Parameters:
     * @param id [string]: BusinessIdentity id. ex: "5656565656565656"
     * @param patchData map of parameters
     * status [string]: You may send the BusinessIdentity to processing by passing 'processing' in the status. The identity must have attachments. Options: "processing"
     * tags [list of strings]: list of strings for reference when searching for BusinessIdentities. ex: ["onboarding-123"]
     * <p>
     * Return:
     * @return BusinessIdentity object with updated attributes
     * @throws Exception error in the request
     */
    public static BusinessIdentity update(String id, Map<String, Object> patchData) throws Exception {
        return BusinessIdentity.update(id, patchData, null);
    }

    /**
     * Update BusinessIdentity entity
     * <p>
     * Update a BusinessIdentity by passing its id.
     * <p>
     * Parameters:
     * @param id [string]: BusinessIdentity id. ex: "5656565656565656"
     * @param patchData map of parameters
     * status [string]: You may send the BusinessIdentity to processing by passing 'processing' in the status. The identity must have attachments. Options: "processing"
     * tags [list of strings]: list of strings for reference when searching for BusinessIdentities. ex: ["onboarding-123"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return BusinessIdentity object with updated attributes
     * @throws Exception error in the request
     */
    public static BusinessIdentity update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    /**
     * Cancel a BusinessIdentity entity
     * <p>
     * Cancel a BusinessIdentity entity previously created in the Stark Infra API. Only identities
     * in the 'created' or 'pending' status can be canceled.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled BusinessIdentity object
     * @throws Exception error in the request
     */
    public static BusinessIdentity cancel(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * Cancel a BusinessIdentity entity
     * <p>
     * Cancel a BusinessIdentity entity previously created in the Stark Infra API. Only identities
     * in the 'created' or 'pending' status can be canceled.
     * <p>
     * Parameters (required):
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return canceled BusinessIdentity object
     * @throws Exception error in the request
     */
    public static BusinessIdentity cancel(String id) throws Exception {
        return BusinessIdentity.cancel(id, null);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "BusinessIdentityLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public BusinessIdentity identity;

        /**
         * BusinessIdentity Log object
         * <p>
         * Every time a BusinessIdentity entity is modified, a corresponding BusinessIdentity Log
         * is generated for the entity. This log is never generated by the user.
         * <p>
         * Parameters:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param identity [BusinessIdentity object]: BusinessIdentity entity to which the log refers to.
         * @param errors [list of ErrorElement objects]: list of errors linked to the BusinessIdentity event.
         * @param type [string]: type of the BusinessIdentity event which triggered the log creation. ex: "created", "updated", "canceled", "processing", "success" or "failed"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10"
         */
        public Log(String created, String type, List<ErrorElement> errors, BusinessIdentity identity, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.identity = identity;
        }

        /**
         * Retrieve a specific BusinessIdentity Log
         * <p>
         * Receive a single BusinessIdentity Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return BusinessIdentity.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific BusinessIdentity Log
         * <p>
         * Receive a single BusinessIdentity Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Project object]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return BusinessIdentity.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve BusinessIdentity Logs
         * <p>
         * Receive a generator of BusinessIdentity.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "updated", "canceled", "processing", "success" or "failed"
         * ids [list of strings, default null]: Log ids to filter BusinessIdentity Logs. ex: ["5656565656565656"]
         * identityIds [list of strings, default null]: list of BusinessIdentity ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of BusinessIdentity Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve BusinessIdentity Logs
         * <p>
         * Receive a generator of BusinessIdentity.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of BusinessIdentity Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve BusinessIdentity Logs
         * <p>
         * Receive a generator of BusinessIdentity.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of BusinessIdentity Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve BusinessIdentity Logs
         * <p>
         * Receive a generator of BusinessIdentity.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "updated", "canceled", "processing", "success" or "failed"
         * ids [list of strings, default null]: Log ids to filter BusinessIdentity Logs. ex: ["5656565656565656"]
         * identityIds [list of strings, default null]: list of BusinessIdentity ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of BusinessIdentity Log objects with updated attributes
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
         * Retrieve paged BusinessIdentity.Logs
         * <p>
         * Receive a list of up to 100 BusinessIdentity.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "updated", "canceled", "processing", "success" or "failed"
         * ids [list of strings, default null]: Log ids to filter BusinessIdentity Logs. ex: ["5656565656565656"]
         * identityIds [list of strings, default null]: list of BusinessIdentity ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return BusinessIdentity.Log.Page object:
         * BusinessIdentity.Log.Page.logs: list of BusinessIdentity.Log objects with updated attributes
         * BusinessIdentity.Log.Page.cursor: cursor to retrieve the next page of BusinessIdentity.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged BusinessIdentity.Logs
         * <p>
         * Receive a list of up to 100 BusinessIdentity.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return BusinessIdentity.Log.Page object:
         * BusinessIdentity.Log.Page.logs: list of BusinessIdentity.Log objects with updated attributes
         * BusinessIdentity.Log.Page.cursor: cursor to retrieve the next page of BusinessIdentity.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged BusinessIdentity.Logs
         * <p>
         * Receive a list of up to 100 BusinessIdentity.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return BusinessIdentity.Log.Page object:
         * BusinessIdentity.Log.Page.logs: list of BusinessIdentity.Log objects with updated attributes
         * BusinessIdentity.Log.Page.cursor: cursor to retrieve the next page of BusinessIdentity.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged BusinessIdentity.Logs
         * <p>
         * Receive a list of up to 100 BusinessIdentity.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "updated", "canceled", "processing", "success" or "failed"
         * ids [list of strings, default null]: Log ids to filter BusinessIdentity Logs. ex: ["5656565656565656"]
         * identityIds [list of strings, default null]: list of BusinessIdentity ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return BusinessIdentity.Log.Page object:
         * BusinessIdentity.Log.Page.logs: list of BusinessIdentity.Log objects with updated attributes
         * BusinessIdentity.Log.Page.cursor: cursor to retrieve the next page of BusinessIdentity.Log objects
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
