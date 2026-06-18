package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IssuingBillingInvoice extends Resource {
    /**
     * IssuingBillingInvoice object
     * <p>
     * The IssuingBillingInvoice object displays the information of the invoices
     * charged to your issuing balance. These objects are not created by the user,
     * but are returned by the API when an invoice is generated and can be
     * retrieved to see the information available.
     * <p>
     * Parameters:
     * id [string]: unique id returned when the IssuingBillingInvoice is created. ex: "5656565656565656"
     * taxId [string]: payer tax ID (CPF or CNPJ) with or without formatting. ex: "20.018.183/0001-80"
     * name [string]: payer name. ex: "Iron Bank S.A."
     * fine [number]: fine amount charged in cents. ex: 200 (= R$ 2.00)
     * interest [number]: interest amount charged in cents. ex: 100 (= R$ 1.00)
     * amount [Long]: invoice amount in cents. ex: 1234 (= R$ 12.34)
     * nominalAmount [Long]: nominal amount in cents. ex: 1234 (= R$ 12.34)
     * status [string]: current IssuingBillingInvoice status. ex: "created" or "paid"
     * brcode [string]: BR Code for the invoice payment. ex: "00020101021226930014br.gov.bcb.pix..."
     * link [string]: public invoice webpage URL. ex: "https://starkbank-card-issuer.com/invoice/123"
     * due [string]: due datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * start [string]: billing cycle start datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * end [string]: billing cycle end datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(IssuingBillingInvoice.class, "IssuingBillingInvoice");

    public String taxId;
    public String name;
    public Number fine;
    public Number interest;
    public Long amount;
    public Long nominalAmount;
    public String status;
    public String brcode;
    public String link;
    public String due;
    public String start;
    public String end;
    public String created;
    public String updated;

    /**
     * IssuingBillingInvoice object
     * <p>
     * The IssuingBillingInvoice object displays the information of the invoices
     * charged to your issuing balance. These objects are not created by the user,
     * but are returned by the API when an invoice is generated and can be
     * retrieved to see the information available.
     * <p>
     * Parameters:
     * @param id [string]: unique id returned when the IssuingBillingInvoice is created. ex: "5656565656565656"
     * @param taxId [string]: payer tax ID (CPF or CNPJ) with or without formatting. ex: "20.018.183/0001-80"
     * @param name [string]: payer name. ex: "Iron Bank S.A."
     * @param fine [number]: fine amount charged in cents. ex: 200 (= R$ 2.00)
     * @param interest [number]: interest amount charged in cents. ex: 100 (= R$ 1.00)
     * @param amount [Long]: invoice amount in cents. ex: 1234 (= R$ 12.34)
     * @param nominalAmount [Long]: nominal amount in cents. ex: 1234 (= R$ 12.34)
     * @param status [string]: current IssuingBillingInvoice status. ex: "created" or "paid"
     * @param brcode [string]: BR Code for the invoice payment. ex: "00020101021226930014br.gov.bcb.pix..."
     * @param link [string]: public invoice webpage URL. ex: "https://starkbank-card-issuer.com/invoice/123"
     * @param due [string]: due datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param start [string]: billing cycle start datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param end [string]: billing cycle end datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingBillingInvoice(String id, String taxId, String name, Number fine, Number interest, Long amount,
                                 Long nominalAmount, String status, String brcode, String link, String due,
                                 String start, String end, String created, String updated
    ) {
        super(id);
        this.taxId = taxId;
        this.name = name;
        this.fine = fine;
        this.interest = interest;
        this.amount = amount;
        this.nominalAmount = nominalAmount;
        this.status = status;
        this.brcode = brcode;
        this.link = link;
        this.due = due;
        this.start = start;
        this.end = end;
        this.created = created;
        this.updated = updated;
    }

    /**
     * IssuingBillingInvoice object
     * <p>
     * The IssuingBillingInvoice object displays the information of the invoices
     * charged to your issuing balance. These objects are not created by the user,
     * but are returned by the API when an invoice is generated and can be
     * retrieved to see the information available.
     * <p>
     * Attributes (return-only):
     * @param data map of properties for the IssuingBillingInvoice
     * id [string]: unique id returned when the IssuingBillingInvoice is created. ex: "5656565656565656"
     * taxId [string]: payer tax ID (CPF or CNPJ) with or without formatting. ex: "20.018.183/0001-80"
     * name [string]: payer name. ex: "Iron Bank S.A."
     * fine [number]: fine amount charged in cents. ex: 200 (= R$ 2.00)
     * interest [number]: interest amount charged in cents. ex: 100 (= R$ 1.00)
     * amount [Long]: invoice amount in cents. ex: 1234 (= R$ 12.34)
     * nominalAmount [Long]: nominal amount in cents. ex: 1234 (= R$ 12.34)
     * status [string]: current IssuingBillingInvoice status. ex: "created" or "paid"
     * brcode [string]: BR Code for the invoice payment. ex: "00020101021226930014br.gov.bcb.pix..."
     * link [string]: public invoice webpage URL. ex: "https://starkbank-card-issuer.com/invoice/123"
     * due [string]: due datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * start [string]: billing cycle start datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * end [string]: billing cycle end datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the IssuingBillingInvoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public IssuingBillingInvoice(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.taxId = (String) dataCopy.remove("taxId");
        this.name = (String) dataCopy.remove("name");
        this.fine = (Number) dataCopy.remove("fine");
        this.interest = (Number) dataCopy.remove("interest");
        this.amount = (Long) dataCopy.remove("amount");
        this.nominalAmount = (Long) dataCopy.remove("nominalAmount");
        this.status = (String) dataCopy.remove("status");
        this.brcode = (String) dataCopy.remove("brcode");
        this.link = (String) dataCopy.remove("link");
        this.due = (String) dataCopy.remove("due");
        this.start = (String) dataCopy.remove("start");
        this.end = (String) dataCopy.remove("end");
        this.created = (String) dataCopy.remove("created");
        this.updated = (String) dataCopy.remove("updated");

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific IssuingBillingInvoice
     * <p>
     * Receive a single IssuingBillingInvoice object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingBillingInvoice object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingBillingInvoice get(String id) throws Exception {
        return IssuingBillingInvoice.get(id, null);
    }

    /**
     * Retrieve a specific IssuingBillingInvoice
     * <p>
     * Receive a single IssuingBillingInvoice object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingBillingInvoice object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingBillingInvoice get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve IssuingBillingInvoices
     * <p>
     * Receive a generator of IssuingBillingInvoice objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "created" or "paid"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of IssuingBillingInvoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingBillingInvoice> query(Map<String, Object> params) throws Exception {
        return IssuingBillingInvoice.query(params, null);
    }

    /**
     * Retrieve IssuingBillingInvoices
     * <p>
     * Receive a generator of IssuingBillingInvoice objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingBillingInvoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingBillingInvoice> query(User user) throws Exception {
        return IssuingBillingInvoice.query(new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingBillingInvoices
     * <p>
     * Receive a generator of IssuingBillingInvoice objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of IssuingBillingInvoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingBillingInvoice> query() throws Exception {
        return IssuingBillingInvoice.query(new HashMap<>(), null);
    }

    /**
     * Retrieve IssuingBillingInvoices
     * <p>
     * Receive a generator of IssuingBillingInvoice objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "created" or "paid"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingBillingInvoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingBillingInvoice> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<IssuingBillingInvoice> invoices;
        public String cursor;

        public Page(List<IssuingBillingInvoice> invoices, String cursor) {
            this.invoices = invoices;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingBillingInvoices
     * <p>
     * Receive a list of up to 100 IssuingBillingInvoice objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "created" or "paid"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return IssuingBillingInvoice.Page object:
     * IssuingBillingInvoice.Page.invoices: list of IssuingBillingInvoice objects with updated attributes
     * IssuingBillingInvoice.Page.cursor: cursor to retrieve the next page of IssuingBillingInvoice objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingBillingInvoices
     * <p>
     * Receive a list of up to 100 IssuingBillingInvoice objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingBillingInvoice.Page object:
     * IssuingBillingInvoice.Page.invoices: list of IssuingBillingInvoice objects with updated attributes
     * IssuingBillingInvoice.Page.cursor: cursor to retrieve the next page of IssuingBillingInvoice objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingBillingInvoices
     * <p>
     * Receive a list of up to 100 IssuingBillingInvoice objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return IssuingBillingInvoice.Page object:
     * IssuingBillingInvoice.Page.invoices: list of IssuingBillingInvoice objects with updated attributes
     * IssuingBillingInvoice.Page.cursor: cursor to retrieve the next page of IssuingBillingInvoice objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged IssuingBillingInvoices
     * <p>
     * Receive a list of up to 100 IssuingBillingInvoice objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "created" or "paid"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingBillingInvoice.Page object:
     * IssuingBillingInvoice.Page.invoices: list of IssuingBillingInvoice objects with updated attributes
     * IssuingBillingInvoice.Page.cursor: cursor to retrieve the next page of IssuingBillingInvoice objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingBillingInvoice> invoices = new ArrayList<>();
        for (SubResource invoice: page.entities) {
            invoices.add((IssuingBillingInvoice) invoice);
        }
        return new Page(invoices, page.cursor);
    }
}
