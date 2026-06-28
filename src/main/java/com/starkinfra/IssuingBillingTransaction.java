package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IssuingBillingTransaction extends Resource {
    /**
     * IssuingBillingTransaction object
     * <p>
     * The IssuingBillingTransaction object displays the information of the
     * transactions charged to your issuing balance. These objects are not created
     * by the user, but are returned by the API when an invoice is generated and
     * can be retrieved to see the information available.
     * <p>
     * Parameters:
     * id [string]: unique id returned when the IssuingBillingTransaction is created. ex: "5656565656565656"
     * amount [Long]: transaction amount in cents. ex: 1234 (= R$ 12.34)
     * invoiceId [string]: parent IssuingBillingInvoice id. May be null. ex: "5656565656565656"
     * installment [integer]: installment number. ex: 1
     * installmentCount [integer]: total installment count. ex: 12
     * balance [Long]: remaining issuing balance in cents. ex: 1234 (= R$ 12.34)
     * holderName [string]: card holder name. ex: "Tony Stark"
     * source [string]: transaction source. ex: "purchase"
     * externalId [string]: external transaction id. ex: "my-external-id-123456"
     * description [string]: transaction description. ex: "Coffee shop"
     * cardEnding [string]: last 4 digits of the card number. ex: "1234"
     * tax [number]: tax amount charged in cents. ex: 100 (= R$ 1.00)
     * rate [number]: tax rate as a percentage. ex: 1.5
     * merchantAmount [Long]: merchant amount in cents. ex: 1234 (= R$ 12.34)
     * merchantCurrencyCode [string]: merchant currency code (ISO 4217). ex: "BRL"
     * created [string]: creation datetime for the IssuingBillingTransaction. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(IssuingBillingTransaction.class, "IssuingBillingTransaction");

    public Long amount;
    public String invoiceId;
    public Integer installment;
    public Integer installmentCount;
    public Long balance;
    public String holderName;
    public String source;
    public String externalId;
    public String description;
    public String cardEnding;
    public Number tax;
    public Number rate;
    public Long merchantAmount;
    public String merchantCurrencyCode;
    public String created;

    /**
     * IssuingBillingTransaction object
     * <p>
     * The IssuingBillingTransaction object displays the information of the
     * transactions charged to your issuing balance. These objects are not created
     * by the user, but are returned by the API when an invoice is generated and
     * can be retrieved to see the information available.
     * <p>
     * Parameters:
     * @param id [string]: unique id returned when the IssuingBillingTransaction is created. ex: "5656565656565656"
     * @param amount [Long]: transaction amount in cents. ex: 1234 (= R$ 12.34)
     * @param invoiceId [string]: parent IssuingBillingInvoice id. May be null. ex: "5656565656565656"
     * @param installment [integer]: installment number. ex: 1
     * @param installmentCount [integer]: total installment count. ex: 12
     * @param balance [Long]: remaining issuing balance in cents. ex: 1234 (= R$ 12.34)
     * @param holderName [string]: card holder name. ex: "Tony Stark"
     * @param source [string]: transaction source. ex: "purchase"
     * @param externalId [string]: external transaction id. ex: "my-external-id-123456"
     * @param description [string]: transaction description. ex: "Coffee shop"
     * @param cardEnding [string]: last 4 digits of the card number. ex: "1234"
     * @param tax [number]: tax amount charged in cents. ex: 100 (= R$ 1.00)
     * @param rate [number]: tax rate as a percentage. ex: 1.5
     * @param merchantAmount [Long]: merchant amount in cents. ex: 1234 (= R$ 12.34)
     * @param merchantCurrencyCode [string]: merchant currency code (ISO 4217). ex: "BRL"
     * @param created [string]: creation datetime for the IssuingBillingTransaction. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingBillingTransaction(String id, Long amount, String invoiceId, Integer installment,
                                     Integer installmentCount, Long balance, String holderName, String source,
                                     String externalId, String description, String cardEnding, Number tax,
                                     Number rate, Long merchantAmount, String merchantCurrencyCode, String created
    ) {
        super(id);
        this.amount = amount;
        this.invoiceId = invoiceId;
        this.installment = installment;
        this.installmentCount = installmentCount;
        this.balance = balance;
        this.holderName = holderName;
        this.source = source;
        this.externalId = externalId;
        this.description = description;
        this.cardEnding = cardEnding;
        this.tax = tax;
        this.rate = rate;
        this.merchantAmount = merchantAmount;
        this.merchantCurrencyCode = merchantCurrencyCode;
        this.created = created;
    }

    /**
     * IssuingBillingTransaction object
     * <p>
     * The IssuingBillingTransaction object displays the information of the
     * transactions charged to your issuing balance. These objects are not created
     * by the user, but are returned by the API when an invoice is generated and
     * can be retrieved to see the information available.
     * <p>
     * Attributes (return-only):
     * @param data map of properties for the IssuingBillingTransaction
     * id [string]: unique id returned when the IssuingBillingTransaction is created. ex: "5656565656565656"
     * amount [Long]: transaction amount in cents. ex: 1234 (= R$ 12.34)
     * invoiceId [string]: parent IssuingBillingInvoice id. May be null. ex: "5656565656565656"
     * installment [integer]: installment number. ex: 1
     * installmentCount [integer]: total installment count. ex: 12
     * balance [Long]: remaining issuing balance in cents. ex: 1234 (= R$ 12.34)
     * holderName [string]: card holder name. ex: "Tony Stark"
     * source [string]: transaction source. ex: "purchase"
     * externalId [string]: external transaction id. ex: "my-external-id-123456"
     * description [string]: transaction description. ex: "Coffee shop"
     * cardEnding [string]: last 4 digits of the card number. ex: "1234"
     * tax [number]: tax amount charged in cents. ex: 100 (= R$ 1.00)
     * rate [number]: tax rate as a percentage. ex: 1.5
     * merchantAmount [Long]: merchant amount in cents. ex: 1234 (= R$ 12.34)
     * merchantCurrencyCode [string]: merchant currency code (ISO 4217). ex: "BRL"
     * created [string]: creation datetime for the IssuingBillingTransaction. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public IssuingBillingTransaction(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.amount = null;
        this.invoiceId = null;
        this.installment = null;
        this.installmentCount = null;
        this.balance = null;
        this.holderName = null;
        this.source = null;
        this.externalId = null;
        this.description = null;
        this.cardEnding = null;
        this.tax = null;
        this.rate = null;
        this.merchantAmount = null;
        this.merchantCurrencyCode = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve IssuingBillingTransactions
     * <p>
     * Receive a generator of IssuingBillingTransaction objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-30"
     * invoiceId [string, default null]: filter for transactions of a specific IssuingBillingInvoice. ex: "5656565656565656"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return generator of IssuingBillingTransaction objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingBillingTransaction> query(Map<String, Object> params) throws Exception {
        return IssuingBillingTransaction.query(params, null);
    }

    /**
     * Retrieve IssuingBillingTransactions
     * <p>
     * Receive a generator of IssuingBillingTransaction objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingBillingTransaction objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingBillingTransaction> query(User user) throws Exception {
        return IssuingBillingTransaction.query(new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingBillingTransactions
     * <p>
     * Receive a generator of IssuingBillingTransaction objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of IssuingBillingTransaction objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingBillingTransaction> query() throws Exception {
        return IssuingBillingTransaction.query(new HashMap<>(), null);
    }

    /**
     * Retrieve IssuingBillingTransactions
     * <p>
     * Receive a generator of IssuingBillingTransaction objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-30"
     * invoiceId [string, default null]: filter for transactions of a specific IssuingBillingInvoice. ex: "5656565656565656"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingBillingTransaction objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingBillingTransaction> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<IssuingBillingTransaction> transactions;
        public String cursor;

        public Page(List<IssuingBillingTransaction> transactions, String cursor) {
            this.transactions = transactions;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingBillingTransactions
     * <p>
     * Receive a list of up to 100 IssuingBillingTransaction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-30"
     * invoiceId [string, default null]: filter for transactions of a specific IssuingBillingInvoice. ex: "5656565656565656"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return IssuingBillingTransaction.Page object:
     * IssuingBillingTransaction.Page.transactions: list of IssuingBillingTransaction objects with updated attributes
     * IssuingBillingTransaction.Page.cursor: cursor to retrieve the next page of IssuingBillingTransaction objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingBillingTransactions
     * <p>
     * Receive a list of up to 100 IssuingBillingTransaction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingBillingTransaction.Page object:
     * IssuingBillingTransaction.Page.transactions: list of IssuingBillingTransaction objects with updated attributes
     * IssuingBillingTransaction.Page.cursor: cursor to retrieve the next page of IssuingBillingTransaction objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingBillingTransactions
     * <p>
     * Receive a list of up to 100 IssuingBillingTransaction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return IssuingBillingTransaction.Page object:
     * IssuingBillingTransaction.Page.transactions: list of IssuingBillingTransaction objects with updated attributes
     * IssuingBillingTransaction.Page.cursor: cursor to retrieve the next page of IssuingBillingTransaction objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged IssuingBillingTransactions
     * <p>
     * Receive a list of up to 100 IssuingBillingTransaction objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-30"
     * invoiceId [string, default null]: filter for transactions of a specific IssuingBillingInvoice. ex: "5656565656565656"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingBillingTransaction.Page object:
     * IssuingBillingTransaction.Page.transactions: list of IssuingBillingTransaction objects with updated attributes
     * IssuingBillingTransaction.Page.cursor: cursor to retrieve the next page of IssuingBillingTransaction objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingBillingTransaction> transactions = new ArrayList<>();
        for (SubResource transaction: page.entities) {
            transactions.add((IssuingBillingTransaction) transaction);
        }
        return new Page(transactions, page.cursor);
    }
}
