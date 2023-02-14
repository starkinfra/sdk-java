package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.SubResource;
import com.starkinfra.error.ErrorElement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class IndividualDocument extends Resource {
    /**
     * IndividualDocument object
     * <p>
     * IndividualDocuments are the set of images required to validate a person's identity. Each IndividualDocument must contain either side
     * of a document (front or back) and a selfie photo.
     * <p>
     * When you initialize an IndividualDocument, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * type [string]: it's a type of IndividualDocument. Options: "drivers-license-front", "drivers-license-back", "identity-front", "identity-back" or "selfie"
     * content [string]: Base64 data url of the picture. ex: data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD...
     * identityId [string]: Unique id of IndividualIdentity. ex: "5656565656565656"
     * tags [list of strings, default []]: list of strings for reference when searching for IndividualDocuments. ex: ["employees", "monthly"]
     * id [string]: unique id returned when the IndividualDocument is created. ex: "5656565656565656"
     * status [string]: current status of the IndividualDocument. Options: "created", "canceled", "processing", "failed" or "success"
     * created [string]: creation datetime for the IndividualDocument. ex: "2020-03-11 08:00:00.000"
     * updated [string]: latest update datetime for the IndividualDocument. ex: "2020-03-11 08:00:00.000"
     * 
     */
    static ClassData data = new ClassData(IndividualDocument.class, "IndividualDocument");

    public String type;
    public String content;
    public String identityId;
    public String[] tags;
    public String status;
    public String created;

    /**
     * IndividualDocument object
     * <p>
     * IndividualDocuments are the set of images required to validate a person's identity. Each IndividualDocument must contain either side
     * of a document (front or back) and a selfie photo.
     * <p>
     * When you initialize an IndividualDocument, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * All parameters are passed in a Map of String and Object.
     * <p>
     * Parameters:
     * @param type [string]: it's a type of IndividualDocument. ex: "drivers-license-front", "drivers-license-back", "identity-front", "identity-back" or "selfie"
     * @param content [string]: Base64 data url of the picture. ex: data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD...
     * @param identityId [string]: Unique id of IndividualIdentity. ex: "5656565656565656"
     * @param tags [list of strings, default []]: list of strings for reference when searching for IndividualDocuments. ex: ["employees", "monthly"]
     * @param id [string]: unique id returned when the IndividualDocument is created. ex: "5656565656565656"
     * @param status [string]: current status of the IndividualDocument. Options: "created", "canceled", "processing", "failed" or "success"
     * @param created [string]: creation datetime for the IndividualDocument. ex: "2020-03-11 08:00:00.000"
     */
    public IndividualDocument(String type, String content, String identityId, String[] tags, String id, String status, String created
    ) throws Exception {
        super(id);
        this.type = type;
        this.content = content;
        this.identityId = identityId;
        this.tags = tags;
        this.status = status;
        this.created = created;
    }

    /**
     * IndividualDocument object
     * <p>
     * IndividualDocuments are the set of images required to validate a person's identity. Each IndividualDocument must contain either side
     * of a document (front or back) and a selfie photo.
     * <p>
     * When you initialize an IndividualDocument, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * All parameters are passed in a Map of String and Object.
     * <p>
     * Parameters:
     * @param type [string]: it's a type of IndividualDocument. Options: "drivers-license-front", "drivers-license-back", "identity-front", "identity-back" or "selfie"
     * @param content [byte[]]: Base64 data url of the picture. ex: data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD...
     * @param contentType [string]: content MIME type. This parameter is required as input only. ex: "image/png" or "image/jpeg"
     * @param identityId [string]: Unique id of IndividualIdentity. ex: "5656565656565656"
     * @param tags [list of strings, default []]: list of strings for reference when searching for IndividualDocuments. ex: ["employees", "monthly"]
     * @param id [string]: unique id returned when the IndividualDocument is created. ex: "5656565656565656"
     * @param status [string]: current status of the IndividualDocument. Options: "created", "canceled", "processing", "failed" or "success"
     * @param created [string]: creation datetime for the IndividualDocument. ex: "2020-03-11 08:00:00.000"
     */
    public IndividualDocument(
        String type, byte[] content, String contentType, String identityId, String[] tags, String id, String status, String created
    ) throws Exception {
        super(id);
        this.type = type;
        this.identityId = identityId;
        this.tags = tags;
        this.status = status;
        this.created = created;
        this.content = "data:" + contentType + ";base64," + Base64.getEncoder().encodeToString(content);
    }

    /**
     * IndividualDocument object
     * <p>
     * IndividualDocuments are used to aggregate an object list of IndividualDocuments
     * for natural person documents check.
     * <p>
     * When you initialize an IndividualDocument, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * All parameters are passed in a Map of String and Object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the IndividualDocument
     * type [string]: it's a type of IndividualDocument. ex: "drivers-license-front", "drivers-license-back", "identity-front", "identity-back" or "selfie"
     * content [string]: Base64 data url of the picture. ex: data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD...
     * contentType [string]: content MIME type. This parameter is required as input only. ex: "image/png" or "image/jpeg"
     * identityId [string]: Unique id of IndividualIdentity. ex: "5656565656565656"
     * <p>
     * Parameters (optional):
     * tags [list of strings, default []]: list of strings for reference when searching for IndividualDocuments. ex: ["employees", "monthly"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the IndividualDocument is created. ex: "5656565656565656"
     * status [string]: current status of the IndividualDocument. Options: "created", "canceled", "processing", "failed" or "success"
     * created [string]: creation datetime for the IndividualDocument. ex: "2020-03-11 08:00:00.000"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public IndividualDocument(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.type = (String) dataCopy.remove("type");
        this.identityId = (String) dataCopy.remove("identityId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.status = null;
        this.created = null;

        if(dataCopy.containsKey("contentType")){
            byte[] content = (byte[]) dataCopy.remove("content");
            String contentType = (String) dataCopy.remove("contentType");
            this.content = "data:" + contentType + ";base64," + Base64.getEncoder().encodeToString(content);
        } 

        if(dataCopy.containsKey("content") && dataCopy.get("content") instanceof String){
            this.content = (String) dataCopy.remove("content");
        }

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create IndividualDocument
     * <p>
     * Send a list of IndividualDocument objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param documents [list of IndividualDocument objects or Maps]: list of IndividualDocument objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of IndividualDocument objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<IndividualDocument> create(List<IndividualDocument> documents, User user) throws Exception {
        List<IndividualDocument> documentsList = new ArrayList<>();
        for (Object document : documents){
            if (document instanceof Map){
                documentsList.add(new IndividualDocument((Map<String, Object>) document));
                continue;
            }
            if (document instanceof IndividualDocument){
                documentsList.add((IndividualDocument) document);
                continue;
            }
            throw new Exception("Unknown type \"" + document.getClass() + "\", use IndividualDocument or HashMap");
        }
        return Rest.post(data, documentsList, user);
    }

    /**
     * Create IndividualDocument
     * <p>
     * Send a list of IndividualDocument objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param documents [list of IndividualDocument objects or Maps]: list of IndividualDocument objects to be created in the API
     * <p>
     * Return:
     * @return list of IndividualDocument objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<IndividualDocument> create(List<IndividualDocument> documents) throws Exception {
        return IndividualDocument.create(documents, null);
    }

    /**
     * Retrieve a specific IndividualDocument
     * <p>
     * Receive a single IndividualDocument object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IndividualDocument object with updated attributes
     * @throws Exception error in the request
     */
    public static IndividualDocument get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific IndividualDocument
     * <p>
     * Receive a single IndividualDocument object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IndividualDocument object with updated attributes
     * @throws Exception error in the request
     */
    public static IndividualDocument get(String id) throws Exception {
        return IndividualDocument.get(id, null);
    }

    /**
     * Retrieve IndividualDocuments
     * <p>
     * Receive a generator of IndividualDocument objects previously created in the Stark Infra API.
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
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IndividualDocument objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualDocument> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IndividualDocuments
     * <p>
     * Receive a generator of IndividualDocument objects previously created in the Stark Infra API.
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
     * @return generator of IndividualDocument objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualDocument> query(Map<String, Object> params) throws Exception {
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IndividualDocuments
     * <p>
     * Receive a generator of IndividualDocument objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IndividualDocument objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualDocument> query(User user) throws Exception {
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve IndividualDocuments
     * <p>
     * Receive a generator of IndividualDocument objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of IndividualDocument objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualDocument> query() throws Exception {
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IndividualDocument> documents;
        public String cursor;
        public Page(List<IndividualDocument> documents, String cursor) {
            this.documents = documents;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IndividualDocuments
     * <p>
     * Receive a list of up to 100 IndividualDocument objects previously created in the Stark Infra API and the cursor to the next page.
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
     * @return IndividualDocument.Page object:
     * IndividualDocument.Page.documents: list of IndividualDocument objects with updated attributes
     * IndividualDocument.Page.cursor: cursor to retrieve the next page of IndividualDocument objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<IndividualDocument> documents = new ArrayList<>();
        for (SubResource document: page.entities) {
            documents.add((IndividualDocument) document);
        }
        return new Page(documents, page.cursor);
    }

    /**
     * Retrieve paged IndividualDocuments
     * <p>
     * Receive a list of up to 100 IndividualDocument objects previously created in the Stark Infra API and the cursor to the next page.
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
     * @return IndividualDocument.Page object:
     * IndividualDocument.Page.documents: list of IndividualDocument objects with updated attributes
     * IndividualDocument.Page.cursor: cursor to retrieve the next page of IndividualDocument objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IndividualDocuments
     * <p>
     * Receive a list of up to 100 IndividualDocument objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return IndividualDocument.Page object:
     * IndividualDocument.Page.documents: list of IndividualDocument objects with updated attributes
     * IndividualDocument.Page.cursor: cursor to retrieve the next page of IndividualDocument objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IndividualDocuments
     * <p>
     * Receive a list of up to 100 IndividualDocument objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return IndividualDocument.Page object:
     * IndividualDocument.Page.documents: list of IndividualDocument objects with updated attributes
     * IndividualDocument.Page.cursor: cursor to retrieve the next page of IndividualDocument objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "IndividualDocumentLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public IndividualDocument document;

        /**
         * IndividualDocument Log object
         * <p>
         * Every time an IndividualDocument entity is modified, a corresponding IndividualDocument Log
         * is generated for the entity. This log is never generated by the user.
         * <p>
         * Parameters:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param document [IndividualDocument]: IndividualDocument object to which the log refers to.
         * @param errors [list of strings]: list of errors linked to the IndividualDocument event.
         * @param type [string]: type of the IndividualDocument event which triggered the log creation. ex: "processing" or "success"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10"
         */
        public Log(String created, String type, List<ErrorElement> errors, IndividualDocument document, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.document = document;
        }

        /**
         * Retrieve a specific IndividualDocument Log
         * <p>
         * Receive a single IndividualDocument Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return IndividualDocument.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific IndividualDocument Log
         * <p>
         * Receive a single IndividualDocument Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return IndividualDocument.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve IndividualDocument Log
         * <p>
         * Receive a generator of IndividualDocument Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * documentIds [list of strings, default null]: list of IndividualDocument ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of IndividualDocument Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve IndividualDocument Logs
         * <p>
         * Receive a generator of IndividualDocument Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IndividualDocument Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve IndividualDocument Logs
         * <p>
         * Receive a generator of IndividualDocument Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of IndividualDocument Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve IndividualDocument Logs
         * <p>
         * Receive a generator of IndividualDocument Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * documentIds [list of strings, default null]: list of IndividualDocument ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IndividualDocument Log objects with updated attributes
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
         * Retrieve paged IndividualDocuments Logs
         * <p>
         * Receive a list of up to 100 IndividualDocument Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * documentIds [list of strings, default null]: list of IndividualDocument ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return IndividualDocument.Log.Page object:
         * IndividualDocument.Log.Page.logs: list of IndividualDocument.Log objects with updated attributes
         * IndividualDocument.Log.Page.cursor: cursor to retrieve the next page of IndividualDocument.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged IndividualDocument Logs
         * <p>
         * Receive a list of up to 100 IndividualDocument Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IndividualDocument.Log.Page object:
         * IndividualDocument.Log.Page.logs: list of IndividualDocument.Log objects with updated attributes
         * IndividualDocument.Log.Page.cursor: cursor to retrieve the next page of IndividualDocument.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged IndividualDocument Logs
         * <p>
         * Receive a list of up to 100 IndividualDocument Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return IndividualDocument.Log.Page object:
         * IndividualDocument.Log.Page.logs: list of IndividualDocument.Log objects with updated attributes
         * IndividualDocument.Log.Page.cursor: cursor to retrieve the next page of IndividualDocument.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged IndividualDocument Logs
         * <p>
         * Receive a list of up to 100 IndividualDocument Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * documentIds [list of strings, default null]: list of IndividualDocument ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IndividualDocument.Log.Page object:
         * IndividualDocument.Log.Page.logs: list of IndividualDocument.Log objects with updated attributes
         * IndividualDocument.Log.Page.cursor: cursor to retrieve the next page of IndividualDocument.Log objects
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
