package com.starkinfra;

import com.starkinfra.error.ErrorElement;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Rest;
import com.starkinfra.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class IssuingInvoice extends Resource {
    /**
     * IssuingInvoice object
     * <p>
     * The IssuingInvoice objects created in your Workspace load your Issuing balance when paid.
     * <p>
     * Parameters:
     * amount [integer]: IssuingInvoice value in cents. ex: 1234 (= R$ 12.34)
     * taxId [string, default sub-issuer tax ID]: payer tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * name [string, default sub-issuer name]: payer name. ex: "Iron Bank S.A."
     * tags [list of strings, default b]: list of strings for tagging. ex: ["travel", "food"]
     * status [string]: current IssuingHolder status. ex: "active", "blocked" or "canceled"
     * issuingTransactionId [string]: ledger transaction ids linked to this IssuingInvoice. ex: "issuing-invoice/5656565656565656"
     * updated [string]: latest update datetime for the IssuingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(IssuingInvoice.class, "IssuingInvoice");

    public Number amount;
    public String name;
    public String taxId;
    public String status;
    public String issuingTransactionId;
    public String[] tags;
    public String updated;
    public String created;

    /**
     * IssuingInvoice object
     * <p>
     * The IssuingInvoice objects created in your Workspace load your Issuing balance when paid.
     * <p>
     * Parameters:
     * @param amount [integer]: IssuingInvoice value in cents. ex: 1234 (= R$ 12.34)
     * @param taxId [string, default sub-issuer tax ID]: payer tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * @param name [string, default sub-issuer name]: payer name. ex: "Iron Bank S.A."
     * @param tags [list of strings, default []]: list of strings for tagging. ex: ["travel", "food"]
     * @param status [string]: current IssuingHolder status. ex: "active", "blocked" or "canceled"
     * @param issuingTransactionId [string]: ledger transaction ids linked to this IssuingInvoice. ex: "issuing-invoice/5656565656565656"
     * @param updated [string]: latest update datetime for the IssuingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the IssuingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingInvoice(String id, String name, Number amount, String taxId, String status,
                          String issuingTransactionId, String[] tags, String updated, String created){
        super(id);
        this.amount = amount;
        this.name = name;
        this.taxId = taxId;
        this.status = status;
        this.issuingTransactionId = issuingTransactionId;
        this.tags = tags;
        this.updated = updated;
        this.created = created;
    }

    /**
     * IssuingInvoice object
     * <p>
     * The IssuingInvoice objects created in your Workspace load your Issuing balance when paid.
     * <p>
     * Parameters:
     * amount [integer]: IssuingInvoice value in cents. ex: 1234 (= R$ 12.34)
     *<p>
     * Parameters (optional):
     * taxId [string, default sub-issuer tax ID]: payer tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * name [string, default sub-issuer name]: payer name. ex: "Iron Bank S.A."
     * tags [list of strings, default []]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Attributes (return-only):
     * status [string]: current IssuingHolder status. ex: "active", "blocked" or "canceled"
     * issuingTransactionId [string]: ledger transaction ids linked to this IssuingInvoice. ex: "issuing-invoice/5656565656565656"
     * updated [string]: latest update datetime for the IssuingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */

    @SuppressWarnings("unchecked")
    public IssuingInvoice(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.amount = (Number) dataCopy.remove("amount");
        this.name = (String) dataCopy.remove("name");
        this.taxId = (String) dataCopy.remove("taxId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.status = null;
        this.issuingTransactionId = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create an IssuingInvoice
     * <p>
     * Send an IssuingInvoice object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param statement [IssuingInvoice object]: IssuingInvoice object to be created in the API
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return IssuingInvoice object with updated attributes
     * @throws Exception error in the statement
     */
    public static IssuingInvoice create(IssuingInvoice statement, User user) throws Exception {
        return Rest.postSingle(data, statement, user);
    }

    /**
     * Create an IssuingInvoice
     * <p>
     * Send an IssuingInvoice object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param statement [IssuingInvoice object]: IssuingInvoice object to be created in the API
     * <p>
     * Return:
     * @return IssuingInvoice object with updated attributes
     * @throws Exception error in the statement
     */
    public static IssuingInvoice create(IssuingInvoice statement) throws Exception {
        return Rest.postSingle(data, statement, null);
    }

    /**
     * Retrieve a specific IssuingInvoice
     * <p>
     * Receive a single IssuingInvoice object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return IssuingInvoice object with updated attributes
     * @throws Exception error in the statement
     */
    public static IssuingInvoice get(String id, User user) throws Exception{
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific IssuingInvoice
     * <p>
     * Receive a single IssuingInvoice object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingInvoice object with updated attributes
     * @throws Exception error in the statement
     */
    public static IssuingInvoice get(String id) throws Exception{
        return Rest.getId(data, id, null);
    }

    /**
     * Retrieve IssuingInvoices
     * <p>
     * Receive a generator of IssuingInvoices objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [date string, default null] date filter for objects created only after specified date. ex: datetime.date(2020, 3, 10)
     * before [date string, default null] date filter for objects created only before specified date. ex: datetime.date(2020, 3, 10)
     * status [string, default ""]: filter for status of retrieved objects. ex: "paid" or "registered"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of IssuingInvoices objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Generator<IssuingInvoice> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IssuingInvoices
     * <p>
     * Receive a generator of IssuingInvoices objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [date string, default null] date filter for objects created only after specified date. ex: datetime.date(2020, 3, 10)
     * before [date string, default null] date filter for objects created only before specified date. ex: datetime.date(2020, 3, 10)
     * status [string, default ""]: filter for status of retrieved objects. ex: "paid" or "registered"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return generator of IssuingInvoices objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Generator<IssuingInvoice> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IssuingInvoices
     * <p>
     * Receive a generator of IssuingInvoices objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of IssuingInvoices objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Generator<IssuingInvoice> query(User user) throws Exception{
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingInvoices
     * <p>
     * Receive a generator of IssuingInvoices objects previously created in the Stark Infra API
     * <p>
     * Return:
     * @return generator of IssuingInvoices objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Generator<IssuingInvoice> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IssuingInvoice> invoices;
        public String cursor;

        public Page(List<IssuingInvoice> invoices, String cursor) {
            this.invoices = invoices;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve IssuingInvoices
     * <p>
     * Receive a list of IssuingInvoices objects previously created in the Stark Infra API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [date string, default null] date filter for objects created only after specified date. ex: datetime.date(2020, 3, 10)
     * before [date string, default null] date filter for objects created only before specified date. ex: datetime.date(2020, 3, 10)
     * status [string, default ""]: filter for status of retrieved objects. ex: "paid" or "registered"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * cursor [string, default ""]: cursor returned on the previous page function call
     * <p>
     * Return:
     * @return IssuingInvoice.Page of IssuingInvoices objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve IssuingInvoices
     * <p>
     * Receive a list of IssuingInvoices objects previously created in the Stark Infra API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return IssuingInvoice.Page of IssuingInvoices objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingInvoices
     * <p>
     * Receive a list of IssuingInvoices objects previously created in the Stark Infra API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [date string, default null] date filter for objects created only after specified date. ex: datetime.date(2020, 3, 10)
     * before [date string, default null] date filter for objects created only before specified date. ex: datetime.date(2020, 3, 10)
     * status [string, default ""]: filter for status of retrieved objects. ex: "paid" or "registered"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * cursor [string, default ""]: cursor returned on the previous page function call
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return IssuingInvoice.Page of IssuingInvoices objects with updated attributes
     * @throws Exception error in the statement
     */
    public static Page page(Map<String , Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingInvoice> invoices = new ArrayList<>();
        for (SubResource issuingInvoice: page.entities) {
            invoices.add((IssuingInvoice) issuingInvoice);
        }
        return new Page(invoices, page.cursor);

    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(IssuingInvoice.Log.class, "IssuingInvoiceLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public IssuingInvoice invoice;

        /**
         * IssuingInvoice Log object
         * <p>
         * Every time an IssuingInvoice entity is modified, a corresponding IssuingInvoice Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param invoice [IssuingInvoice]: IssuingInvoice entity to which the log refers to.
         * @param errors [list of strings]: list of errors linked to the IssuingInvoice event.
         * @param type [string]: type of the IssuingInvoice event which triggered the log creation. ex: "processing" or "success"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Log(String created, String type, List<ErrorElement> errors, IssuingInvoice invoice, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.invoice = invoice;
        }

        /**
         * Retrieve a specific IssuingInvoice Log
         * <p>
         * Receive a single IssuingInvoice Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return IssuingInvoice Log object with updated attributes
         * @throws Exception error in the invoice
         */
        public static IssuingInvoice.Log get(String id) throws Exception {
            return IssuingInvoice.Log.get(id, null);
        }

        /**
         * Retrieve a specific IssuingInvoice Log
         * <p>
         * Receive a single IssuingInvoice Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return IssuingInvoice Log object with updated attributes
         * @throws Exception error in the invoice
         */
        public static IssuingInvoice.Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve IssuingInvoice Logs
         * <p>
         * Receive a generator of IssuingInvoice.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * invoiceIds [list of strings, default null]: list of IssuingInvoice ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of IssuingInvoice Log objects with updated attributes
         * @throws Exception error in the invoice
         */
        public static Generator<IssuingInvoice.Log> query(Map<String, Object> params) throws Exception {
            return IssuingInvoice.Log.query(params, null);
        }

        /**
         * Retrieve IssuingInvoice Logs
         * <p>
         * Receive a generator of IssuingInvoice.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return generator of IssuingInvoice Log objects with updated attributes
         * @throws Exception error in the invoice
         */
        public static Generator<IssuingInvoice.Log> query(User user) throws Exception {
            return IssuingInvoice.Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve IssuingInvoice Logs
         * <p>
         * Receive a generator of IssuingInvoice.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of IssuingInvoice Log objects with updated attributes
         * @throws Exception error in the invoice
         */
        public static Generator<IssuingInvoice.Log> query() throws Exception {
            return IssuingInvoice.Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve IssuingInvoice Logs
         * <p>
         * Receive a generator of IssuingInvoice.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * invoiceIds [list of strings, default null]: list of IssuingInvoice ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return generator of IssuingInvoice Log objects with updated attributes
         * @throws Exception error in the invoice
         */
        public static Generator<IssuingInvoice.Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<IssuingInvoice.Log> logs;
            public String cursor;

            public Page(List<IssuingInvoice.Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged IssuingInvoice.Logs
         * <p>
         * Receive a list of up to 100 IssuingInvoice.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your invoices.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * invoiceIds [list of strings, default null]: list of IssuingInvoice ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return IssuingInvoice.Log.Page object:
         * IssuingInvoice.Log.Page.logs: list of IssuingInvoice.Log objects with updated attributes
         * IssuingInvoice.Log.Page.cursor: cursor to retrieve the next page of IssuingInvoice.Log objects
         * @throws Exception error in the invoice
         */
        public static IssuingInvoice.Log.Page page(Map<String, Object> params) throws Exception {
            return IssuingInvoice.Log.page(params, null);
        }

        /**
         * Retrieve paged IssuingInvoice.Logs
         * <p>
         * Receive a list of up to 100 IssuingInvoice.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your invoices.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return IssuingInvoice.Log.Page object:
         * IssuingInvoice.Log.Page.logs: list of IssuingInvoice.Log objects with updated attributes
         * IssuingInvoice.Log.Page.cursor: cursor to retrieve the next page of IssuingInvoice.Log objects
         * @throws Exception error in the invoice
         */
        public static IssuingInvoice.Log.Page page(User user) throws Exception {
            return IssuingInvoice.Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged IssuingInvoice.Logs
         * <p>
         * Receive a list of up to 100 IssuingInvoice.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your invoices.
         * <p>
         * Return:
         * @return IssuingInvoice.Log.Page object:
         * IssuingInvoice.Log.Page.logs: list of IssuingInvoice.Log objects with updated attributes
         * IssuingInvoice.Log.Page.cursor: cursor to retrieve the next page of IssuingInvoice.Log objects
         * @throws Exception error in the invoice
         */
        public static IssuingInvoice.Log.Page page() throws Exception {
            return IssuingInvoice.Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged IssuingInvoice.Logs
         * <p>
         * Receive a list of up to 100 IssuingInvoice.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your invoices.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * invoiceIds [list of strings, default null]: list of IssuingInvoice ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return IssuingInvoice.Log.Page object:
         * IssuingInvoice.Log.Page.logs: list of IssuingInvoice.Log objects with updated attributes
         * IssuingInvoice.Log.Page.cursor: cursor to retrieve the next page of IssuingInvoice.Log objects
         * @throws Exception error in the invoice
         */
        public static IssuingInvoice.Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
            List<IssuingInvoice.Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((IssuingInvoice.Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }

}
