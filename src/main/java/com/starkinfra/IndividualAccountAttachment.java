package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;
import com.starkinfra.error.ErrorElement;

import java.util.Map;
import java.util.List;
import java.util.Base64;
import java.util.HashMap;
import java.util.ArrayList;


public final class IndividualAccountAttachment extends Resource {
    /**
     * IndividualAccountAttachment object
     * <p>
     * IndividualAccountAttachments are supporting documents (identity, driver's license, selfie)
     * attached to an IndividualAccountRequest for the account-approval flow. The caller uploads the
     * raw image bytes and a MIME content type; the SDK encodes them as a data: URL before sending.
     * <p>
     * When you initialize an IndividualAccountAttachment, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * type [string]: kind of supporting document. Options: "drivers-license-front", "drivers-license-back", "identity-front", "identity-back" or "selfie"
     * content [string]: Base64 data url of the picture, built from the raw bytes and the contentType. ex: "data:image/png;base64,/9j/4AAQSkZJRgABAQAASABIAAD..."
     * accountRequestId [string]: ID of the parent IndividualAccountRequest. ex: "5189530608992256"
     * tags [list of strings, default null]: list of strings for reference when searching for IndividualAccountAttachments. ex: ["employees", "monthly"]
     * id [string]: unique id returned when the IndividualAccountAttachment is created. ex: "5656565656565656"
     * status [string]: current IndividualAccountAttachment status. ex: "created", "success", "failed" or "deleted"
     * created [string]: creation datetime for the IndividualAccountAttachment. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(IndividualAccountAttachment.class, "IndividualAccountAttachment");

    public String type;
    public String content;
    public String accountRequestId;
    public String[] tags;
    public String status;
    public String created;

    /**
     * IndividualAccountAttachment object
     * <p>
     * IndividualAccountAttachments are supporting documents attached to an IndividualAccountRequest.
     * This constructor takes the content already encoded as a Base64 data: URL.
     * <p>
     * Parameters:
     * @param type [string]: kind of supporting document. ex: "drivers-license-front", "drivers-license-back", "identity-front", "identity-back" or "selfie"
     * @param content [string]: Base64 data url of the picture. ex: "data:image/png;base64,/9j/4AAQSkZJRgABAQAASABIAAD..."
     * @param accountRequestId [string]: ID of the parent IndividualAccountRequest. ex: "5189530608992256"
     * @param tags [list of strings, default null]: list of strings for reference when searching for IndividualAccountAttachments. ex: ["employees", "monthly"]
     * @param id [string]: unique id returned when the IndividualAccountAttachment is created. ex: "5656565656565656"
     * @param status [string]: current IndividualAccountAttachment status. ex: "created", "success", "failed" or "deleted"
     * @param created [string]: creation datetime for the IndividualAccountAttachment. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IndividualAccountAttachment(String type, String content, String accountRequestId,
                                       String[] tags, String id, String status, String created) {
        super(id);
        this.type = type;
        this.content = content;
        this.accountRequestId = accountRequestId;
        this.tags = tags;
        this.status = status;
        this.created = created;
    }

    /**
     * IndividualAccountAttachment object
     * <p>
     * IndividualAccountAttachments are supporting documents attached to an IndividualAccountRequest.
     * <p>
     * When you initialize an IndividualAccountAttachment, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the IndividualAccountAttachment
     * type [string]: kind of supporting document. ex: "drivers-license-front", "drivers-license-back", "identity-front", "identity-back" or "selfie"
     * content [byte[]]: raw image bytes. ex: Files.readAllBytes(path)
     * contentType [string]: content MIME type. This parameter is required as input only. ex: "image/png" or "image/jpeg"
     * accountRequestId [string]: ID of the parent IndividualAccountRequest. ex: "5189530608992256"
     * <p>
     * Parameters (optional):
     * tags [list of strings, default null]: list of strings for reference when searching for IndividualAccountAttachments. ex: ["employees", "monthly"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the IndividualAccountAttachment is created. ex: "5656565656565656"
     * status [string]: current IndividualAccountAttachment status. ex: "created", "success", "failed" or "deleted"
     * created [string]: creation datetime for the IndividualAccountAttachment. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public IndividualAccountAttachment(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.type = (String) dataCopy.remove("type");
        this.accountRequestId = (String) dataCopy.remove("accountRequestId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.status = null;
        this.created = null;

        if (dataCopy.containsKey("contentType") && dataCopy.get("content") instanceof byte[]) {
            byte[] content = (byte[]) dataCopy.remove("content");
            String contentType = (String) dataCopy.remove("contentType");
            this.content = "data:" + contentType + ";base64," + Base64.getEncoder().encodeToString(content);
        }

        if (dataCopy.containsKey("content") && dataCopy.get("content") instanceof byte[]) {
            byte[] content = (byte[]) dataCopy.remove("content");
            this.content = "data:;base64," + Base64.getEncoder().encodeToString(content);
        }

        if (dataCopy.containsKey("content") && dataCopy.get("content") instanceof String) {
            this.content = (String) dataCopy.remove("content");
        }

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific IndividualAccountAttachment
     * <p>
     * Receive a single IndividualAccountAttachment object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IndividualAccountAttachment object with updated attributes
     * @throws Exception error in the request
     */
    public static IndividualAccountAttachment get(String id) throws Exception {
        return IndividualAccountAttachment.get(id, null);
    }

    /**
     * Retrieve a specific IndividualAccountAttachment
     * <p>
     * Receive a single IndividualAccountAttachment object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IndividualAccountAttachment object with updated attributes
     * @throws Exception error in the request
     */
    public static IndividualAccountAttachment get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve IndividualAccountAttachments
     * <p>
     * Receive a generator of IndividualAccountAttachment objects previously created in the Stark Infra API.
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
     * @return generator of IndividualAccountAttachment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualAccountAttachment> query(Map<String, Object> params) throws Exception {
        return IndividualAccountAttachment.query(params, null);
    }

    /**
     * Retrieve IndividualAccountAttachments
     * <p>
     * Receive a generator of IndividualAccountAttachment objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IndividualAccountAttachment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualAccountAttachment> query(User user) throws Exception {
        return IndividualAccountAttachment.query(new HashMap<>(), user);
    }

    /**
     * Retrieve IndividualAccountAttachments
     * <p>
     * Receive a generator of IndividualAccountAttachment objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of IndividualAccountAttachment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualAccountAttachment> query() throws Exception {
        return IndividualAccountAttachment.query(new HashMap<>(), null);
    }

    /**
     * Retrieve IndividualAccountAttachments
     * <p>
     * Receive a generator of IndividualAccountAttachment objects previously created in the Stark Infra API.
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
     * @return generator of IndividualAccountAttachment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IndividualAccountAttachment> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<IndividualAccountAttachment> attachments;
        public String cursor;

        public Page(List<IndividualAccountAttachment> attachments, String cursor) {
            this.attachments = attachments;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IndividualAccountAttachments
     * <p>
     * Receive a list of up to 100 IndividualAccountAttachment objects previously created in the Stark Infra API and the cursor to the next page.
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
     * @return IndividualAccountAttachment.Page object:
     * IndividualAccountAttachment.Page.attachments: list of IndividualAccountAttachment objects with updated attributes
     * IndividualAccountAttachment.Page.cursor: cursor to retrieve the next page of IndividualAccountAttachment objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IndividualAccountAttachments
     * <p>
     * Receive a list of up to 100 IndividualAccountAttachment objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IndividualAccountAttachment.Page object:
     * IndividualAccountAttachment.Page.attachments: list of IndividualAccountAttachment objects with updated attributes
     * IndividualAccountAttachment.Page.cursor: cursor to retrieve the next page of IndividualAccountAttachment objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IndividualAccountAttachments
     * <p>
     * Receive a list of up to 100 IndividualAccountAttachment objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return IndividualAccountAttachment.Page object:
     * IndividualAccountAttachment.Page.attachments: list of IndividualAccountAttachment objects with updated attributes
     * IndividualAccountAttachment.Page.cursor: cursor to retrieve the next page of IndividualAccountAttachment objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged IndividualAccountAttachments
     * <p>
     * Receive a list of up to 100 IndividualAccountAttachment objects previously created in the Stark Infra API and the cursor to the next page.
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
     * @return IndividualAccountAttachment.Page object:
     * IndividualAccountAttachment.Page.attachments: list of IndividualAccountAttachment objects with updated attributes
     * IndividualAccountAttachment.Page.cursor: cursor to retrieve the next page of IndividualAccountAttachment objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<IndividualAccountAttachment> attachments = new ArrayList<>();
        for (SubResource attachment: page.entities) {
            attachments.add((IndividualAccountAttachment) attachment);
        }
        return new Page(attachments, page.cursor);
    }

    /**
     * Create IndividualAccountAttachments
     * <p>
     * Send a list of IndividualAccountAttachment objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param attachments [list of IndividualAccountAttachment objects or HashMaps]: list of IndividualAccountAttachment objects to be created in the API
     * <p>
     * Return:
     * @return list of IndividualAccountAttachment objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<IndividualAccountAttachment> create(List<?> attachments) throws Exception {
        return IndividualAccountAttachment.create(attachments, null);
    }

    /**
     * Create IndividualAccountAttachments
     * <p>
     * Send a list of IndividualAccountAttachment objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param attachments [list of IndividualAccountAttachment objects or HashMaps]: list of IndividualAccountAttachment objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of IndividualAccountAttachment objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<IndividualAccountAttachment> create(List<?> attachments, User user) throws Exception {
        List<IndividualAccountAttachment> attachmentList = new ArrayList<>();
        for (Object attachment : attachments){
            if (attachment instanceof Map){
                attachmentList.add(new IndividualAccountAttachment((Map<String, Object>) attachment));
                continue;
            }
            if (attachment instanceof IndividualAccountAttachment){
                attachmentList.add((IndividualAccountAttachment) attachment);
                continue;
            }
            throw new Exception("Unknown type \"" + attachment.getClass() + "\", use IndividualAccountAttachment or HashMap");
        }
        return Rest.post(data, attachmentList, user);
    }

    /**
     * Cancel an IndividualAccountAttachment entity
     * <p>
     * Cancel an IndividualAccountAttachment entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: IndividualAccountAttachment unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return deleted IndividualAccountAttachment object
     * @throws Exception error in the request
     */
    public static IndividualAccountAttachment cancel(String id) throws Exception {
        return IndividualAccountAttachment.cancel(id, null);
    }

    /**
     * Cancel an IndividualAccountAttachment entity
     * <p>
     * Cancel an IndividualAccountAttachment entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: IndividualAccountAttachment unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return deleted IndividualAccountAttachment object
     * @throws Exception error in the request
     */
    public static IndividualAccountAttachment cancel(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "IndividualAccountAttachmentLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public IndividualAccountAttachment attachment;

        /**
         * IndividualAccountAttachment Log object
         * <p>
         * Every time an IndividualAccountAttachment entity is modified, a corresponding IndividualAccountAttachment Log
         * is generated for the entity. This log is never generated by the user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param attachment [IndividualAccountAttachment]: IndividualAccountAttachment entity to which the log refers to.
         * @param errors [list of ErrorElement]: list of errors linked to the IndividualAccountAttachment event.
         * @param type [string]: type of the IndividualAccountAttachment event which triggered the log creation. ex: "success" or "failed"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Log(String created, String type, List<ErrorElement> errors, IndividualAccountAttachment attachment, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.attachment = attachment;
        }

        /**
         * Retrieve a specific IndividualAccountAttachment Log
         * <p>
         * Receive a single IndividualAccountAttachment Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return IndividualAccountAttachment Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific IndividualAccountAttachment Log
         * <p>
         * Receive a single IndividualAccountAttachment Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IndividualAccountAttachment Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve IndividualAccountAttachment Logs
         * <p>
         * Receive a generator of IndividualAccountAttachment.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * attachmentIds [list of strings, default null]: list of IndividualAccountAttachment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of IndividualAccountAttachment Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve IndividualAccountAttachment Logs
         * <p>
         * Receive a generator of IndividualAccountAttachment.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IndividualAccountAttachment Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve IndividualAccountAttachment Logs
         * <p>
         * Receive a generator of IndividualAccountAttachment.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of IndividualAccountAttachment Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve IndividualAccountAttachment Logs
         * <p>
         * Receive a generator of IndividualAccountAttachment.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * attachmentIds [list of strings, default null]: list of IndividualAccountAttachment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of IndividualAccountAttachment Log objects with updated attributes
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
         * Retrieve paged IndividualAccountAttachment.Logs
         * <p>
         * Receive a list of up to 100 IndividualAccountAttachment.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * attachmentIds [list of strings, default null]: list of IndividualAccountAttachment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return IndividualAccountAttachment.Log.Page object:
         * IndividualAccountAttachment.Log.Page.logs: list of IndividualAccountAttachment.Log objects with updated attributes
         * IndividualAccountAttachment.Log.Page.cursor: cursor to retrieve the next page of IndividualAccountAttachment.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged IndividualAccountAttachment.Logs
         * <p>
         * Receive a list of up to 100 IndividualAccountAttachment.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IndividualAccountAttachment.Log.Page object:
         * IndividualAccountAttachment.Log.Page.logs: list of IndividualAccountAttachment.Log objects with updated attributes
         * IndividualAccountAttachment.Log.Page.cursor: cursor to retrieve the next page of IndividualAccountAttachment.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged IndividualAccountAttachment.Logs
         * <p>
         * Receive a list of up to 100 IndividualAccountAttachment.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return IndividualAccountAttachment.Log.Page object:
         * IndividualAccountAttachment.Log.Page.logs: list of IndividualAccountAttachment.Log objects with updated attributes
         * IndividualAccountAttachment.Log.Page.cursor: cursor to retrieve the next page of IndividualAccountAttachment.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged IndividualAccountAttachment.Logs
         * <p>
         * Receive a list of up to 100 IndividualAccountAttachment.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * attachmentIds [list of strings, default null]: list of IndividualAccountAttachment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return IndividualAccountAttachment.Log.Page object:
         * IndividualAccountAttachment.Log.Page.logs: list of IndividualAccountAttachment.Log objects with updated attributes
         * IndividualAccountAttachment.Log.Page.cursor: cursor to retrieve the next page of IndividualAccountAttachment.Log objects
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
