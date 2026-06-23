package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;
import com.starkinfra.error.ErrorElement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class BusinessAttachment extends Resource {
    /**
     * BusinessAttachment object
     * <p>
     * A BusinessAttachment represents a document (incorporation document / articles of association etc.)
     * sent to a BusinessIdentity. You must reference the desired BusinessIdentity by its id. A BusinessIdentity
     * accepts at most 2 attachments.
     * <p>
     * When you initialize a BusinessAttachment, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * name [string]: document name. It must be unique among the identity's active attachments. ex: "contrato-social.pdf"
     * content [string]: Base64 data url of the file. ex: data:application/pdf;base64,JVBERi0xLjQ...
     * businessIdentityId [string]: unique id of the BusinessIdentity this attachment belongs to. ex: "5656565656565656"
     * contentType [string]: content MIME type. This parameter is required as input only. ex: "application/pdf", "image/png" or "image/jpeg"
     * tags [list of strings, default []]: list of strings for reference when searching for BusinessAttachments. ex: ["doc-principal"]
     * id [string]: unique id returned when the BusinessAttachment is created. ex: "5656565656565656"
     * attachmentId [string]: id of the document in the external attachment service. ex: "5104320788332544"
     * status [string]: current status of the BusinessAttachment. ex: "created", "canceled", "approved", "denied"
     * created [string]: creation datetime for the BusinessAttachment. ex: "2020-03-10 10:30:00.000"
     * updated [string]: latest update datetime for the BusinessAttachment. ex: "2020-03-10 10:30:00.000"
     *
     */
    static ClassData data = new ClassData(BusinessAttachment.class, "BusinessAttachment");

    public String name;
    public String content;
    public String businessIdentityId;
    public String[] tags;
    public String attachmentId;
    public String status;
    public String created;
    public String updated;

    /**
     * BusinessAttachment object
     * <p>
     * A BusinessAttachment represents a document (incorporation document / articles of association etc.)
     * sent to a BusinessIdentity. You must reference the desired BusinessIdentity by its id.
     * <p>
     * When you initialize a BusinessAttachment, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param name [string]: document name. It must be unique among the identity's active attachments. ex: "contrato-social.pdf"
     * @param content [string]: Base64 data url of the file. ex: data:application/pdf;base64,JVBERi0xLjQ...
     * @param businessIdentityId [string]: unique id of the BusinessIdentity this attachment belongs to. ex: "5656565656565656"
     * @param tags [list of strings, default []]: list of strings for reference when searching for BusinessAttachments. ex: ["doc-principal"]
     * @param id [string]: unique id returned when the BusinessAttachment is created. ex: "5656565656565656"
     * @param attachmentId [string]: id of the document in the external attachment service. ex: "5104320788332544"
     * @param status [string]: current status of the BusinessAttachment. Options: "created", "canceled", "approved" or "denied"
     * @param created [string]: creation datetime for the BusinessAttachment. ex: "2020-03-10 10:30:00.000"
     * @param updated [string]: latest update datetime for the BusinessAttachment. ex: "2020-03-10 10:30:00.000"
     */
    public BusinessAttachment(
        String name, String content, String businessIdentityId, String[] tags, String id, String attachmentId,
        String status, String created, String updated
    ) throws Exception {
        super(id);
        this.name = name;
        this.content = content;
        this.businessIdentityId = businessIdentityId;
        this.tags = tags;
        this.attachmentId = attachmentId;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    /**
     * BusinessAttachment object
     * <p>
     * A BusinessAttachment represents a document (incorporation document / articles of association etc.)
     * sent to a BusinessIdentity. You must reference the desired BusinessIdentity by its id.
     * <p>
     * When you initialize a BusinessAttachment, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param name [string]: document name. It must be unique among the identity's active attachments. ex: "contrato-social.pdf"
     * @param content [byte[]]: raw bytes of the file. They will be encoded into a Base64 data url. ex: data:application/pdf;base64,JVBERi0xLjQ...
     * @param contentType [string]: content MIME type. This parameter is required as input only. ex: "application/pdf", "image/png" or "image/jpeg"
     * @param businessIdentityId [string]: unique id of the BusinessIdentity this attachment belongs to. ex: "5656565656565656"
     * @param tags [list of strings, default []]: list of strings for reference when searching for BusinessAttachments. ex: ["doc-principal"]
     * @param id [string]: unique id returned when the BusinessAttachment is created. ex: "5656565656565656"
     * @param attachmentId [string]: id of the document in the external attachment service. ex: "5104320788332544"
     * @param status [string]: current status of the BusinessAttachment. Options: "created", "canceled", "approved" or "denied"
     * @param created [string]: creation datetime for the BusinessAttachment. ex: "2020-03-10 10:30:00.000"
     * @param updated [string]: latest update datetime for the BusinessAttachment. ex: "2020-03-10 10:30:00.000"
     */
    public BusinessAttachment(
        String name, byte[] content, String contentType, String businessIdentityId, String[] tags, String id,
        String attachmentId, String status, String created, String updated
    ) throws Exception {
        super(id);
        this.name = name;
        this.businessIdentityId = businessIdentityId;
        this.tags = tags;
        this.attachmentId = attachmentId;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.content = "data:" + contentType + ";base64," + Base64.getEncoder().encodeToString(content);
    }

    /**
     * BusinessAttachment object
     * <p>
     * A BusinessAttachment represents a document (incorporation document / articles of association etc.)
     * sent to a BusinessIdentity. You must reference the desired BusinessIdentity by its id.
     * <p>
     * When you initialize a BusinessAttachment, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * All parameters are passed in a Map of String and Object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the BusinessAttachment
     * name [string]: document name. It must be unique among the identity's active attachments. ex: "contrato-social.pdf"
     * content [string or byte[]]: Base64 data url of the file or raw bytes. ex: data:application/pdf;base64,JVBERi0xLjQ...
     * contentType [string]: content MIME type. This parameter is required as input only. ex: "application/pdf", "image/png" or "image/jpeg"
     * businessIdentityId [string]: unique id of the BusinessIdentity this attachment belongs to. ex: "5656565656565656"
     * <p>
     * Parameters (optional):
     * tags [list of strings, default []]: list of strings for reference when searching for BusinessAttachments. ex: ["doc-principal"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the BusinessAttachment is created. ex: "5656565656565656"
     * attachmentId [string]: id of the document in the external attachment service. ex: "5104320788332544"
     * status [string]: current status of the BusinessAttachment. Options: "created", "canceled", "approved" or "denied"
     * created [string]: creation datetime for the BusinessAttachment. ex: "2020-03-10 10:30:00.000"
     * updated [string]: latest update datetime for the BusinessAttachment. ex: "2020-03-10 10:30:00.000"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public BusinessAttachment(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.name = (String) dataCopy.remove("name");
        this.businessIdentityId = (String) dataCopy.remove("businessIdentityId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.attachmentId = null;
        this.status = null;
        this.created = null;
        this.updated = null;

        if (dataCopy.containsKey("contentType")) {
            byte[] content = (byte[]) dataCopy.remove("content");
            String contentType = (String) dataCopy.remove("contentType");
            this.content = "data:" + contentType + ";base64," + Base64.getEncoder().encodeToString(content);
        }

        if (dataCopy.containsKey("content") && dataCopy.get("content") instanceof String) {
            this.content = (String) dataCopy.remove("content");
        }

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create BusinessAttachments
     * <p>
     * Send a list of BusinessAttachment objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param attachments [list of BusinessAttachment objects or Maps]: list of BusinessAttachment objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of BusinessAttachment objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<BusinessAttachment> create(List<?> attachments, User user) throws Exception {
        List<BusinessAttachment> attachmentsList = new ArrayList<>();
        for (Object attachment : attachments){
            if (attachment instanceof Map){
                attachmentsList.add(new BusinessAttachment((Map<String, Object>) attachment));
                continue;
            }
            if (attachment instanceof BusinessAttachment){
                attachmentsList.add((BusinessAttachment) attachment);
                continue;
            }
            throw new Exception("Unknown type \"" + attachment.getClass() + "\", use BusinessAttachment or HashMap");
        }
        return Rest.post(data, attachmentsList, user);
    }

    /**
     * Create BusinessAttachments
     * <p>
     * Send a list of BusinessAttachment objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param attachments [list of BusinessAttachment objects or Maps]: list of BusinessAttachment objects to be created in the API
     * <p>
     * Return:
     * @return list of BusinessAttachment objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<BusinessAttachment> create(List<?> attachments) throws Exception {
        return BusinessAttachment.create(attachments, null);
    }

    /**
     * Retrieve a specific BusinessAttachment
     * <p>
     * Receive a single BusinessAttachment object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters
     * expand [list of strings, default null]: fields to expand information. ex: ["content"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return BusinessAttachment object with updated attributes
     * @throws Exception error in the request
     */
    public static BusinessAttachment get(String id, Map<String, Object> params, User user) throws Exception {
        return Rest.getId(data, id, params, user);
    }

    /**
     * Retrieve a specific BusinessAttachment
     * <p>
     * Receive a single BusinessAttachment object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters
     * expand [list of strings, default null]: fields to expand information. ex: ["content"]
     * <p>
     * Return:
     * @return BusinessAttachment object with updated attributes
     * @throws Exception error in the request
     */
    public static BusinessAttachment get(String id, Map<String, Object> params) throws Exception {
        return BusinessAttachment.get(id, params, null);
    }

    /**
     * Retrieve a specific BusinessAttachment
     * <p>
     * Receive a single BusinessAttachment object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return BusinessAttachment object with updated attributes
     * @throws Exception error in the request
     */
    public static BusinessAttachment get(String id, User user) throws Exception {
        return BusinessAttachment.get(id, null, user);
    }

    /**
     * Retrieve a specific BusinessAttachment
     * <p>
     * Receive a single BusinessAttachment object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return BusinessAttachment object with updated attributes
     * @throws Exception error in the request
     */
    public static BusinessAttachment get(String id) throws Exception {
        return BusinessAttachment.get(id, null, null);
    }

    /**
     * Retrieve BusinessAttachments
     * <p>
     * Receive a generator of BusinessAttachment objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["created", "canceled", "approved", "denied"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of BusinessAttachment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BusinessAttachment> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve BusinessAttachments
     * <p>
     * Receive a generator of BusinessAttachment objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["created", "canceled", "approved", "denied"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of BusinessAttachment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BusinessAttachment> query(Map<String, Object> params) throws Exception {
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve BusinessAttachments
     * <p>
     * Receive a generator of BusinessAttachment objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of BusinessAttachment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BusinessAttachment> query(User user) throws Exception {
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve BusinessAttachments
     * <p>
     * Receive a generator of BusinessAttachment objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of BusinessAttachment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BusinessAttachment> query() throws Exception {
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<BusinessAttachment> attachments;
        public String cursor;
        public Page(List<BusinessAttachment> attachments, String cursor) {
            this.attachments = attachments;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged BusinessAttachments
     * <p>
     * Receive a list of up to 100 BusinessAttachment objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["created", "canceled", "approved", "denied"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return BusinessAttachment.Page object:
     * BusinessAttachment.Page.attachments: list of BusinessAttachment objects with updated attributes
     * BusinessAttachment.Page.cursor: cursor to retrieve the next page of BusinessAttachment objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<BusinessAttachment> attachments = new ArrayList<>();
        for (SubResource attachment: page.entities) {
            attachments.add((BusinessAttachment) attachment);
        }
        return new Page(attachments, page.cursor);
    }

    /**
     * Retrieve paged BusinessAttachments
     * <p>
     * Receive a list of up to 100 BusinessAttachment objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["created", "canceled", "approved", "denied"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return BusinessAttachment.Page object:
     * BusinessAttachment.Page.attachments: list of BusinessAttachment objects with updated attributes
     * BusinessAttachment.Page.cursor: cursor to retrieve the next page of BusinessAttachment objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged BusinessAttachments
     * <p>
     * Receive a list of up to 100 BusinessAttachment objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return BusinessAttachment.Page object:
     * BusinessAttachment.Page.attachments: list of BusinessAttachment objects with updated attributes
     * BusinessAttachment.Page.cursor: cursor to retrieve the next page of BusinessAttachment objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged BusinessAttachments
     * <p>
     * Receive a list of up to 100 BusinessAttachment objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return BusinessAttachment.Page object:
     * BusinessAttachment.Page.attachments: list of BusinessAttachment objects with updated attributes
     * BusinessAttachment.Page.cursor: cursor to retrieve the next page of BusinessAttachment objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Cancel a BusinessAttachment entity
     * <p>
     * Cancel a BusinessAttachment entity previously created in the Stark Infra API. Only attachments
     * in the 'created' status can be canceled.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled BusinessAttachment object
     * @throws Exception error in the request
     */
    public static BusinessAttachment cancel(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * Cancel a BusinessAttachment entity
     * <p>
     * Cancel a BusinessAttachment entity previously created in the Stark Infra API. Only attachments
     * in the 'created' status can be canceled.
     * <p>
     * Parameters (required):
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return canceled BusinessAttachment object
     * @throws Exception error in the request
     */
    public static BusinessAttachment cancel(String id) throws Exception {
        return BusinessAttachment.cancel(id, null);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "BusinessAttachmentLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public BusinessAttachment attachment;

        /**
         * BusinessAttachment Log object
         * <p>
         * Every time a BusinessAttachment entity is modified, a corresponding BusinessAttachment Log
         * is generated for the entity. This log is never generated by the user.
         * <p>
         * Parameters:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param attachment [BusinessAttachment object]: BusinessAttachment entity to which the log refers to.
         * @param errors [list of ErrorElement objects]: list of errors linked to the BusinessAttachment event.
         * @param type [string]: type of the BusinessAttachment event which triggered the log creation. ex: "created", "canceled", "approved" or "denied"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10"
         */
        public Log(String created, String type, List<ErrorElement> errors, BusinessAttachment attachment, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.attachment = attachment;
        }

        /**
         * Retrieve a specific BusinessAttachment Log
         * <p>
         * Receive a single BusinessAttachment Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return BusinessAttachment.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific BusinessAttachment Log
         * <p>
         * Receive a single BusinessAttachment Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Project object]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return BusinessAttachment.Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve BusinessAttachment Logs
         * <p>
         * Receive a generator of BusinessAttachment.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "canceled", "approved" or "denied"
         * ids [list of strings, default null]: Log ids to filter BusinessAttachment Logs. ex: ["5656565656565656"]
         * attachmentIds [list of strings, default null]: list of BusinessAttachment ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of BusinessAttachment Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve BusinessAttachment Logs
         * <p>
         * Receive a generator of BusinessAttachment.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of BusinessAttachment Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve BusinessAttachment Logs
         * <p>
         * Receive a generator of BusinessAttachment.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of BusinessAttachment Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve BusinessAttachment Logs
         * <p>
         * Receive a generator of BusinessAttachment.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "canceled", "approved" or "denied"
         * ids [list of strings, default null]: Log ids to filter BusinessAttachment Logs. ex: ["5656565656565656"]
         * attachmentIds [list of strings, default null]: list of BusinessAttachment ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of BusinessAttachment Log objects with updated attributes
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
         * Retrieve paged BusinessAttachment.Logs
         * <p>
         * Receive a list of up to 100 BusinessAttachment.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "canceled", "approved" or "denied"
         * ids [list of strings, default null]: Log ids to filter BusinessAttachment Logs. ex: ["5656565656565656"]
         * attachmentIds [list of strings, default null]: list of BusinessAttachment ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return BusinessAttachment.Log.Page object:
         * BusinessAttachment.Log.Page.logs: list of BusinessAttachment.Log objects with updated attributes
         * BusinessAttachment.Log.Page.cursor: cursor to retrieve the next page of BusinessAttachment.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged BusinessAttachment.Logs
         * <p>
         * Receive a list of up to 100 BusinessAttachment.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return BusinessAttachment.Log.Page object:
         * BusinessAttachment.Log.Page.logs: list of BusinessAttachment.Log objects with updated attributes
         * BusinessAttachment.Log.Page.cursor: cursor to retrieve the next page of BusinessAttachment.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged BusinessAttachment.Logs
         * <p>
         * Receive a list of up to 100 BusinessAttachment.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return BusinessAttachment.Log.Page object:
         * BusinessAttachment.Log.Page.logs: list of BusinessAttachment.Log objects with updated attributes
         * BusinessAttachment.Log.Page.cursor: cursor to retrieve the next page of BusinessAttachment.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged BusinessAttachment.Logs
         * <p>
         * Receive a list of up to 100 BusinessAttachment.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "canceled", "approved" or "denied"
         * ids [list of strings, default null]: Log ids to filter BusinessAttachment Logs. ex: ["5656565656565656"]
         * attachmentIds [list of strings, default null]: list of BusinessAttachment ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return BusinessAttachment.Log.Page object:
         * BusinessAttachment.Log.Page.logs: list of BusinessAttachment.Log objects with updated attributes
         * BusinessAttachment.Log.Page.cursor: cursor to retrieve the next page of BusinessAttachment.Log objects
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
