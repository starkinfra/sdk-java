package com.starkinfra;

import com.starkinfra.utils.Generator;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Rest;
import com.starkinfra.utils.SubResource;

import java.util.*;

public final class CreditNote extends Resource {
    /**
     * CreditNote object
     * <p>
     * When you initialize a CreditNote, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * templateId       [string]: ID of the contract template on which the credit note will be based. ex: templateId="0123456789101112"
     * name             [string]: credit receiver's full name. ex: name="Anthony Edward Stark"
     * taxId            [string]: credit receiver's tax ID (CPF or CNPJ). ex: taxId="20.018.183/0001-80"
     * nominalAmount    [number]: amount in cents transferred to the credit receiver, before deductions. ex: nominalAmount=11234 (= R$ 112.34)
     * scheduled        [string, default now] date of transfer execution. ex: "2020-03-11 08:00:00.000"
     * invoices         [list of maps]: list of invoices to be created and sent to the credit receiver. ex: invoices=[{"amount":"120000", "name":"Jamie Lannister", "taxId":"20.018.183/0001-80"}]
     * transfer         [map]: Transfer object to be created and sent to the credit receiver. ex: transfer={"amount":"", "bankCode":"", "branchCode":"", "accounNumber":"","taxId":"","name":""}
     * signers          [list of maps]: name and e-mail of signers that sign the contract. ex: signers=[{"name": "Tony Stark", "contact": "tony@starkindustries.com", "method": "link"}]
     * Parameters (optional):
     * rebateAmount     [number, default null]: credit analysis fee deducted from lent amount. ex: rebateAmount=11234 (= R$ 112.34)
     * tags             [list of strings, default null]: list of strings for reference when searching for transfers. ex: ["employees", "monthly"]
     * externalId       [string, default null]: url safe string that must be unique among all your CreditNotes. ex: externalId="my-internal-id-123456"
     * Attributes (return-only):
     * id               [string, default null]: unique id returned when the CreditNote is created. ex: "5656565656565656"
     * interest         [number, default null]: yearly effective interest rate of the credit note, in percentage. ex: 12.5
     * created          [string, default null]: creation datetime for the CreditNote. ex: "2020-03-11 08:00:00.000"
     * updated          [string, default null]: latest update datetime for the CreditNote. ex: "2020-03-11 08:00:00.000"
     */

    static ClassData data = new ClassData(CreditNote.class, "CreditNote");

    public String templateId;
    public String name;
    public String taxId;
    public Number nominalAmount;
    public String scheduled;
    public HashMap<String,Object> transfer;
    public List<HashMap<String,Object>> invoices;
    public List<HashMap<String,String>> signers;
    public Number rebateAmount;
    public String[] tags;
    public String externalId;
    public Number interest;
    public String created;
    public String updated;

    /**
     * CreditNote object
     * When you initialize a CreditNote, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * To create scheduled CreditNotes, which will display the discount, interest, etc. on the final users banking interface,
     * use dates instead of datetimes on the "due" and "discounts" fields.
     * All parameters are passed in a Map of String and Object object.
     *
     * @param templateId       [string]: ID of the contract template on which the credit note will be based. ex: templateId="0123456789101112"
     * @param name             [string]: credit receiver's full name. ex: name="Anthony Edward Stark"
     * @param taxId            [string]: credit receiver's tax ID (CPF or CNPJ). ex: taxId="20.018.183/0001-80"
     * @param nominalAmount    [number]: amount in cents transferred to the credit receiver, before deductions. ex: nominalAmount=11234 (= R$ 112.34)
     * @param scheduled        [string, default now] date of transfer execution. ex: "2020-03-11 08:00:00.000"
     * @param invoices         [list of maps]: list of invoices to be created and sent to the credit receiver. ex: invoices=[{"amount":120000, "name":"Jamie Lannister", "taxId":"20.018.183/0001-80"}]
     * @param transfer         [map]: Transfer object to be created and sent to the credit receiver. ex: transfer={"amount":10000, "bankCode":"00000000", "branchCode":"1234", "accountNumber":"129340-1", "taxId":"012.345.678-90", "name":"Jamie Lannister"}
     * @param signers          [list of maps]: name and e-mail of signers that sign the contract. ex: signers=[{"name": "Tony Stark", "contact": "tony@starkindustries.com", "method": "link"}]
     * @param rebateAmount     [number, default null]: credit analysis fee deducted from lent amount. ex: rebateAmount=11234 (= R$ 112.34)
     * @param tags             [list of strings, default null]: list of strings for reference when searching for transfers. ex: ["employees", "monthly"]
     * @param externalId       [string, default null]: url safe string that must be unique among all your CreditNotes. ex: externalId="my-internal-id-123456"
     * @param id               [string, default null]: unique id returned when the CreditNote is created. ex: "5656565656565656"
     * @param interest         [number, default null]: yearly effective interest rate of the credit note, in percentage. ex: 12.5
     * @param created          [string, default null]: creation datetime for the CreditNote. ex: "2020-03-11 08:00:00.000"
     * @param updated          [string, default null]: latest update datetime for the CreditNote. ex: "2020-03-11 08:00:00.000"
     */

    public CreditNote(String templateId, String name, String taxId, Number nominalAmount, String scheduled, HashMap<String,Object> transfer,
                      List<HashMap<String,Object>> invoices, List<HashMap<String,String>> signers, Number rebateAmount, String[] tags, String externalId,
                      String id, Number interest, String created, String updated
    ){
        super(id);
        this.templateId = templateId;
        this.name = name;
        this.taxId = taxId;
        this.nominalAmount = nominalAmount;
        this.scheduled = scheduled;
        this.transfer = transfer;
        this.invoices = invoices;
        this.signers = signers;
        this.rebateAmount = rebateAmount;
        this.tags = tags;
        this.externalId = externalId;
        this.interest = interest;
        this.created = created;
        this.updated = updated;
    }

    /**
     * CreditNote object
     * <p>
     * When you initialize a CreditNote, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * * All parameters are passed in a Map of String and Object object.
     * <p>
     * @param data map of parameters for the creation of the CreditNote
     * Parameters (required):
     * templateId       [string]: ID of the contract template on which the credit note will be based. ex: templateId="0123456789101112"
     * name             [string]: credit receiver's full name. ex: name="Anthony Edward Stark"
     * taxId            [string]: credit receiver's tax ID (CPF or CNPJ). ex: taxId="20.018.183/0001-80"
     * nominalAmount    [number]: amount in cents transferred to the credit receiver, before deductions. ex: nominalAmount=11234 (= R$ 112.34)
     * scheduled        [string, default now] date of transfer execution. ex: "2020-03-11 08:00:00.000"
     * invoices         [list of maps]: list of invoices to be created and sent to the credit receiver. ex: invoices=[{"amount": 120000, "name":"Jamie Lannister", "taxId":"20.018.183/0001-80"}]
     * transfer         [map]: Transfer object to be created and sent to the credit receiver. ex: transfer={"amount": 10000, "bankCode":"00000000", "branchCode":"1234", "accountNumber": "129340-1", "taxId": "012.345.678-90", "name": "Jamie Lannister"}
     * signers          [list of maps]: name and e-mail of signers that sign the contract. ex: signers=[{"name": "Tony Stark", "contact": "tony@starkindustries.com", "method": "link"}]
     * Parameters (optional):
     * rebateAmount     [number, default null]: credit analysis fee deducted from lent amount. ex: rebateAmount=11234 (= R$ 112.34)
     * tags             [list of strings, default null]: list of strings for reference when searching for transfers. ex: ["employees", "monthly"]
     * externalId       [string, default null]: url safe string that must be unique among all your CreditNotes. ex: externalId="my-internal-id-123456"
     * Attributes (return-only):
     * id               [string, default null]: unique id returned when the CreditNote is created. ex: "5656565656565656"
     * interest         [number, default null]: yearly effective interest rate of the credit note, in percentage. ex: 12.5
     * created          [string, default null]: creation datetime for the CreditNote. ex: "2020-03-11 08:00:00.000"
     * updated          [string, default null]: latest update datetime for the CreditNote. ex: "2020-03-11 08:00:00.000"
     */

    public CreditNote(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.templateId = (String) dataCopy.remove("templateId");
        this.name = (String) dataCopy.remove("name");
        this.taxId = (String) dataCopy.remove("taxId");
        this.nominalAmount = (Number) dataCopy.remove("nominalAmount");
        this.scheduled = (String) dataCopy.remove("scheduled");
        this.invoices = (List<HashMap<String,Object>>) dataCopy.remove("invoices");
        this.transfer = (HashMap<String,Object>) dataCopy.remove("transfer");
        this.signers = (List<HashMap<String,String>>) dataCopy.remove("signers");
        this.rebateAmount = (Number) dataCopy.remove("rebateAmount");
        this.tags = (String[]) dataCopy.remove("tags");
        this.externalId = (String) dataCopy.remove("externalId");
        this.interest = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create CreditNote
     * <p>
     * Send a list of CreditNote objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param creditNotes   [list of CreditNotes objects or Maps]: list of CreditNotes objects to be created in the API
     * @param user          [Project object]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of CreditNote objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<CreditNote> create(List<?> creditNotes, User user) throws Exception {
        List<CreditNote> creditNoteList = new ArrayList<>();
        for (Object creditNote : creditNotes){
            if (creditNote instanceof Map){
                creditNoteList.add(new CreditNote((Map<String, Object>) creditNote));
                continue;
            }
            if (creditNote instanceof CreditNote){
                creditNoteList.add((CreditNote) creditNote);
                continue;
            }
            throw new Exception("Unknown type \"" + creditNote.getClass() + "\", use CreditNote or HashMap");
        }
        return Rest.post(data, creditNoteList, user);
    }

    /**
     * Create CreditNote
     * <p>
     * Send a list of CreditNote objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param creditNotes   [list of CreditNote objects or Maps]: list of CreditNote objects to be created in the API
     * <p>
     * Return:
     * @return list of CreditNote objects with updated attributes
     * @throws Exception error in the request
     */

    public static List<CreditNote> create(List<?> creditNotes) throws Exception {
        return CreditNote.create(creditNotes, null);
    }

    /**
     * Retrieve a specific CreditNote
     * <p>
     * Receive a single CreditNote object previously created in the Stark Infra API by passing its id
     * Parameters:
     * @param id        [string]: object unique id. ex: "5656565656565656"
     * Parameters:
     * @param user      [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * Return:
     * @return CreditNote object with updated attributes
     * @throws Exception error in the request
     */

    public static CreditNote get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific CreditNote
     * <p>
     * Receive a single CreditNote object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id        [string]: object unique id. ex: "5656565656565656"
     * Return:
     * @return CreditNote object with updated attributes
     * @throws Exception error in the request
     */

    public static CreditNote get(String id) throws Exception {
        return CreditNote.get(id, null);
    }

    /**
     * Retrieve CreditNote
     * <p>
     * Receive a generator of Creditnote objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters
     * limit            [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after            [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before           [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status           [string, default null]: filter for status of retrieved objects. ex: "created", "paid", "canceled" or "overdue"
     * tags             [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids              [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user      [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of CreditNote objects with updated attributes
     * @throws Exception error in the request
     */

    public static Generator<CreditNote> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve CreditNote
     * <p>
     * Receive a generator of CreditNote objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters
     * limit        [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after        [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before       [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status       [string, default null]: filter for status of retrieved objects. ex: "created", "paid", "canceled" or "overdue"
     * tags         [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids          [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of CreditNote objects with updated attributes
     * @throws Exception error in the request
     */

    public static Generator<CreditNote> query(Map<String, Object> params) throws Exception {
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve CreditNote
     * <p>
     * Receive a generator of CreditNote objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user    [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of CreditNote objects with updated attributes
     * @throws Exception error in the request
     */

    public static Generator<CreditNote> query(User user) throws Exception {
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve CreditNote
     * <p>
     * Receive a generator of CreditNote objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * Return:
     * @return generator of CreditNote objects with updated attributes
     * @throws Exception error in the request
     */

    public static Generator<CreditNote> query() throws Exception {
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<CreditNote> creditNotes;
        public String cursor;
        public Page(List<CreditNote> creditNotes, String cursor) {
            this.creditNotes = creditNotes;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged CreditNote
     * <p>
     * Receive a list of up to 100 CreditNote objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor       [string, default null]: cursor returned on the previous page function call
     * limit        [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after        [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before       [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status       [string, default null]: filter for status of retrieved objects. ex: "created", "paid", "canceled" or "overdue"
     * tags         [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids          [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return CreditNote.Page object:
     * CreditNote.Page.creditNotes: list of CreditNote objects with updated attributes
     * CreditNote.Page.cursor: cursor to retrieve the next page of CreditNote objects
     * @throws Exception error in the request
     */

    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<CreditNote> creditNotes = new ArrayList<>();
        for (SubResource creditNote: page.entities) {
            creditNotes.add((CreditNote) creditNote);
        }
        return new Page(creditNotes, page.cursor);
    }

    /**
     * Retrieve paged CreditNote
     * <p>
     * Receive a list of up to 100 CreditNote objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor       [string, default null]: cursor returned on the previous page function call
     * limit        [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after        [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before       [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status       [string, default null]: filter for status of retrieved objects. ex: "created", "paid", "canceled" or "overdue"
     * tags         [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids          [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return CreditNote.Page object:
     * CreditNote.Page.creditNotes: list of CreditNote objects with updated attributes
     * CreditNote.Page.cursor: cursor to retrieve the next page of CreditNote objects
     * @throws Exception error in the request
     */

    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged CreditNotes
     * <p>
     * Receive a list of up to 100 CreditNote objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user      [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return CreditNote.Page object:
     * CreditNote.Page.creditNotes: list of CreditNote objects with updated attributes
     * CreditNote.Page.cursor: cursor to retrieve the next page of CreditNote objects
     * @throws Exception error in the request
     */

    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged CreditNotes
     * <p>
     * Receive a list of up to 100 CreditNote objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return CreditNote.Page object:
     * CreditNote.Page.creditNotes: list of CreditNote objects with updated attributes
     * CreditNote.Page.cursor: cursor to retrieve the next page of CreditNote objects
     * @throws Exception error in the request
     */

    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Cancel a CreditNote entity
     * <p>
     * Cancel a CreditNote entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id        [string]: CreditNote unique id. ex: "5656565656565656"
     * @param user      [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return canceled CreditNote object
     * @throws Exception error in the request
     */

    public static CreditNote delete(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * Cancel a CreditNote entity
     * <p>
     * Cancel a CreditNote entity previously created in the Stark Infra API
     * <p>
     * Parameters (required):
     * @param id   [string]: CreditNote unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return canceled CreditNote object
     * @throws Exception error in the request
     */

    public static CreditNote delete(String id) throws Exception {
        return CreditNote.delete(id, null);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "CreditNote");

        public String created;
        public String type;
        public String[] errors;
        public CreditNote creditNote;

        public Log(String created, String type, String[] errors, CreditNote creditNote, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.creditNote = creditNote;
        }

        /**
         * Retrieve a specific CreditNote Log
         * <p>
         * Receive a single CreditNote Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return CreditNote Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific CreditNote Log
         * <p>
         * Receive a single CreditNote Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id    [string]: object unique id. ex: "5656565656565656"
         * @param user  [Project object]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return CreditNote Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve CreditNote Logs
         * <p>
         * Receive a generator of CreditNote.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * creditNoteIds [list of strings, default null]: list of CreditNote ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return list of CreditNote Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve CreditNote Logs
         * <p>
         * Receive a generator of CreditNote.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return list of CreditNote Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve CreditNote Logs
         * <p>
         * Receive a generator of CreditNote.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return list of CreditNote Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve CreditNote Logs
         * <p>
         * Receive a generator of CreditNote.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * creditNoteIds [list of strings, default null]: list of CreditNote ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user  [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return list of CreditNote Log objects with updated attributes
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
         * Retrieve paged CreditNotes.Logs
         * <p>
         * Receive a list of up to 100 CreditNote.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * creditNoteIds [list of strings, default null]: list of CreditNote ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return CreditNote.Log.Page object:
         * CreditNote.Log.Page.logs: list of CreditNote.Log objects with updated attributes
         * CreditNote.Log.Page.cursor: cursor to retrieve the next page of CreditNote.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged CreditNote.Logs
         * <p>
         * Receive a list of up to 100 CreditNote.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return CreditNote.Log.Page object:
         * CreditNote.Log.Page.logs: list of CreditNote.Log objects with updated attributes
         * CreditNote.Log.Page.cursor: cursor to retrieve the next page of CreditNote.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged CreditNote.Logs
         * <p>
         * Receive a list of up to 100 CreditNote.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return CreditNote.Log.Page object:
         * CreditNote.Log.Page.logs: list of CreditNote.Log objects with updated attributes
         * CreditNote.Log.Page.cursor: cursor to retrieve the next page of CreditNote.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged CreditNote.Logs
         * <p>
         * Receive a list of up to 100 CreditNote.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * creditNoteIds [list of strings, default null]: list of CreditNote ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return CreditNote.Log.Page object:
         * CreditNote.Log.Page.logs: list of CreditNote.Log objects with updated attributes
         * CreditNote.Log.Page.cursor: cursor to retrieve the next page of CreditNote.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
            List<Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Log.Page(logs, page.cursor);
        }
    }
}
