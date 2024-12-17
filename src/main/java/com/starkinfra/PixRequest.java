package com.starkinfra;

import com.google.gson.Gson;
import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Parse;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;
import com.starkinfra.error.ErrorElement;

import java.util.Map;
import java.util.List;
import java.util.Objects;
import java.util.HashMap;
import java.util.ArrayList;


public final class PixRequest extends Resource {
    /**
     * PixRequest object
     * <p>
     * PixRequests are used to receive or send instant payments to accounts
     * hosted in any Pix participant.
     * <p>
     * When you initialize a PixRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * amount [Long]: amount in cents to be transferred. ex: 11234 (= R$ 112.34)
     * externalId [string]: url safe string that must be unique among all your PixRequests. Duplicated external IDs will cause failures. By default, this parameter will block any PixRequests that repeats amount and receiver information on the same date. ex: "my-internal-id-123456"
     * senderName [string]: sender's full name. ex: "Anthony Edward Stark"
     * senderTaxId [string]: sender's tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * senderBranchCode [string]: sender's bank account branch code. Use '-' in case there is a verifier digit. ex: "1357-9"
     * senderAccountNumber [string]: sender's bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * senderAccountType [string, default "checking"]: sender's bank account type. ex: "checking", "savings", "salary" or "payment"
     * receiverName [string]: receiver's full name. ex: "Anthony Edward Stark"
     * receiverTaxId [string]: receiver's tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * receiverBankCode [string]: receiver's bank institution code in Brazil. ex: "20018183"
     * receiverAccountNumber [string]: receiver's bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * receiverBranchCode [string]: receiver's bank account branch code. Use '-' in case there is a verifier digit. ex: "1357-9"
     * receiverAccountType [string]: receiver's bank account type. ex: "checking", "savings", "salary" or "payment"
     * endToEndId [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * receiverKeyId [string, default null]: receiver's dict key. ex: "20.018.183/0001-80"
     * description [string, default null]: optional description to override default description to be shown in the bank statement. ex: "Payment for service #1234"
     * reconciliationId [string, default null]: Reconciliation ID linked to this payment. ex: "b77f5236-7ab9-4487-9f95-66ee6eaf1781"
     * initiatorTaxId [string, default null]: Payment initiator's tax id (CPF/CNPJ). ex: "01234567890" or "20.018.183/0001-80"
     * cashAmount [Long, default 0]: Amount to be withdrawal from the cashier in cents. ex: 1000 (= R$ 10.00)
     * cashierBankCode [string, default null]: Cashier's bank code. ex: "00000000"
     * cashierType [string, default null]: Cashier's type. ex: [merchant, other, participant]
     * tags [list of strings, default null]: list of strings for reference when searching for PixRequests. ex: ["employees", "monthly"]
     * method [string]: execution  method for thr creation of the PIX. ex: "manual", "payerQrcode", "dynamicQrcode".
     * id [string]: unique id returned when the PixRequest is created. ex: "5656565656565656"
     * fee [integer]: fee charged when PixRequest is paid. ex: 200 (= R$ 2.00)
     * status [string]: current PixRequest status. ex: "registered" or "paid"
     * flow [string]: direction of money flow. ex: "in" or "out"
     * senderBankCode [string]: sender's bank institution code in Brazil. ex: "20018183"
     * created [string]: creation datetime for the PixRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(PixRequest.class, "PixRequest");

    public Long amount;
    public String externalId;
    public String senderName;
    public String senderTaxId;
    public String senderBranchCode;
    public String senderAccountNumber;
    public String senderAccountType;
    public String receiverName;
    public String receiverTaxId;
    public String receiverBankCode;
    public String receiverAccountNumber;
    public String receiverBranchCode;
    public String receiverAccountType;
    public String endToEndId;
    public String receiverKeyId;
    public String description;
    public String reconciliationId;
    public String initiatorTaxId;
    public Long cashAmount;
    public String cashierBankCode;
    public String cashierType;
    public String[] tags;
    public String method;
    public Integer fee;
    public String status;
    public String flow;
    public String senderBankCode;
    public String created;
    public String updated;

    /**
     * PixRequest object
     * <p>
     * PixRequests are used to receive or send instant payments to accounts
     * hosted in any Pix participant.
     * <p>
     * When you initialize a PixRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param amount [Long]: amount in cents to be transferred. ex: 11234 (= R$ 112.34)
     * @param externalId [string]: url safe string that must be unique among all your PixRequests. Duplicated external IDs will cause failures. By default, this parameter will block any PixRequests that repeats amount and receiver information on the same date. ex: "my-internal-id-123456"
     * @param senderName [string]: sender's full name. ex: "Anthony Edward Stark"
     * @param senderTaxId [string]: sender's tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * @param senderBranchCode [string]: sender's bank account branch code. Use '-' in case there is a verifier digit. ex: "1357-9"
     * @param senderAccountNumber [string]: sender's bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * @param senderAccountType [string, default "checking"]: sender's bank account type. ex: "checking", "savings", "salary" or "payment"
     * @param receiverName [string]: receiver's full name. ex: "Anthony Edward Stark"
     * @param receiverTaxId [string]: receiver's tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * @param receiverBankCode [string]: receiver's bank institution code in Brazil. ex: "20018183"
     * @param receiverAccountNumber [string]: receiver's bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * @param receiverBranchCode [string]: receiver's bank account branch code. Use '-' in case there is a verifier digit. ex: "1357-9"
     * @param receiverAccountType [string]: receiver's bank account type. ex: "checking", "savings", "salary" or "payment"
     * @param endToEndId [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * @param receiverKeyId [string, default null]: receiver's dict key. ex: "20.018.183/0001-80"
     * @param description [string, default null]: optional description to override default description to be shown in the bank statement. ex: "Payment for service #1234"
     * @param reconciliationId [string, default null]: Reconciliation ID linked to this payment. ex: "b77f5236-7ab9-4487-9f95-66ee6eaf1781"
     * @param initiatorTaxId [string, default null]: Payment initiator's tax id (CPF/CNPJ). ex: "01234567890" or "20.018.183/0001-80"
     * @param cashAmount [Long, default 0]: Amount to be withdrawal from the cashier in cents. ex: 1000 (= R$ 10.00)
     * @param cashierBankCode [string, default null]: Cashier's bank code. ex: "00000000"
     * @param cashierType [string, default null]: Cashier's type. ex: [merchant, other, participant]
     * @param tags [list of strings, default null]: list of strings for reference when searching for PixRequests. ex: ["employees", "monthly"]
     * @param method [string, default null]: execution  method for thr creation of the PIX. ex: "manual", "payerQrcode", "dynamicQrcode".
     * @param id [string]: unique id returned when the PixRequest is created. ex: "5656565656565656"
     * @param fee [integer]: fee charged when PixRequest is paid. ex: 200 (= R$ 2.00)
     * @param status [string]: current PixRequest status. ex: "registered" or "paid"
     * @param flow [string]: direction of money flow. ex: "in" or "out"
     * @param senderBankCode [string]: sender's bank institution code in Brazil. ex: "20018183"
     * @param created [string]: creation datetime for the PixRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the PixRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public PixRequest(Long amount, String externalId, String senderName, String senderTaxId, String senderBranchCode,
                      String senderAccountNumber, String senderAccountType, String receiverName, String receiverTaxId,
                      String receiverBankCode, String receiverAccountNumber, String receiverBranchCode,
                      String receiverAccountType, String endToEndId, String receiverKeyId, String description,
                      String reconciliationId, String initiatorTaxId, Long cashAmount, String cashierBankCode,
                      String cashierType, String[] tags, String method, Integer fee, String status, String flow,
                      String senderBankCode, String created, String updated, String id
    ) {
        super(id);
        this.amount = amount;
        this.externalId = externalId;
        this.senderName = senderName;
        this.senderTaxId = senderTaxId;
        this.senderBranchCode = senderBranchCode;
        this.senderAccountNumber = senderAccountNumber;
        this.senderAccountType = senderAccountType;
        this.receiverName = receiverName;
        this.receiverTaxId = receiverTaxId;
        this.receiverBankCode = receiverBankCode;
        this.receiverAccountNumber = receiverAccountNumber;
        this.receiverBranchCode = receiverBranchCode;
        this.receiverAccountType = receiverAccountType;
        this.endToEndId = endToEndId;
        this.receiverKeyId = receiverKeyId;
        this.description = description;
        this.reconciliationId = reconciliationId;
        this.initiatorTaxId = initiatorTaxId;
        this.cashAmount = cashAmount;
        this.cashierBankCode = cashierBankCode;
        this.cashierType = cashierType;
        this.tags = tags;
        this.method = method;
        this.fee = fee;
        this.status = status;
        this.flow = flow;
        this.senderBankCode = senderBankCode;
        this.created = created;
        this.updated = updated;
    }

    /**
     * PixRequest object
     * <p>
     * PixRequests are used to receive or send instant payments to accounts
     * hosted in any Pix participant.
     * <p>
     * When you initialize a PixRequest, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the PixRequest
     * amount [Long]: amount in cents to be transferred. ex: 11234 (= R$ 112.34)
     * externalId [string]: url safe string that must be unique among all your PixRequests. Duplicated external IDs will cause failures. By default, this parameter will block any PixRequests that repeats amount and receiver information on the same date. ex: "my-internal-id-123456"
     * senderName [string]: sender's full name. ex: "Anthony Edward Stark"
     * senderTaxId [string]: sender's tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * senderBranchCode [string]: sender's bank account branch code. Use '-' in case there is a verifier digit. ex: "1357-9"
     * senderAccountNumber [string]: sender's bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * senderAccountType [string, default "checking"]: sender's bank account type. ex: "checking", "savings", "salary" or "payment"
     * receiverName [string]: receiver's full name. ex: "Anthony Edward Stark"
     * receiverTaxId [string]: receiver's tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * receiverBankCode [string]: receiver's bank institution code in Brazil. ex: "20018183"
     * receiverAccountNumber [string]: receiver's bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * receiverBranchCode [string]: receiver's bank account branch code. Use '-' in case there is a verifier digit. ex: "1357-9"
     * receiverAccountType [string]: receiver's bank account type. ex: "checking", "savings", "salary" or "payment"
     * endToEndId [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * <p>
     * Parameters (optional):
     * receiverKeyId [string, default null]: receiver's dict key. ex: "20.018.183/0001-80"
     * description [string, default null]: optional description to override default description to be shown in the bank statement. ex: "Payment for service #1234"
     * reconciliationId [string, default null]: Reconciliation ID linked to this payment. ex: "b77f5236-7ab9-4487-9f95-66ee6eaf1781"
     * initiatorTaxId [string, default null]: Payment initiator's tax id (CPF/CNPJ). ex: "01234567890" or "20.018.183/0001-80"
     * cashAmount [Long, default 0]: Amount to be withdrawal from the cashier in cents. ex: 1000 (= R$ 10.00)
     * cashierBankCode [string, default null]: Cashier's bank code. ex: "00000000"
     * cashierType [string, default null]: Cashier's type. ex: [merchant, other, participant]
     * tags [list of strings, default null]: list of strings for reference when searching for PixRequests. ex: ["employees", "monthly"]
     * method [string, default null]: execution  method for thr creation of the PIX. ex: "manual", "payerQrcode", "dynamicQrcode".
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the PixRequest is created. ex: "5656565656565656"
     * fee [integer]: fee charged when PixRequest is paid. ex: 200 (= R$ 2.00)
     * status [string]: current PixRequest status. ex: "registered" or "paid"
     * flow [string]: direction of money flow. ex: "in" or "out"
     * senderBankCode [string]: sender's bank institution code in Brazil. ex: "20018183"
     * created [string]: creation datetime for the PixRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public PixRequest(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.amount = ((Long) dataCopy.remove("amount")).longValue();
        this.externalId = (String) dataCopy.remove("externalId");
        this.senderName = (String) dataCopy.remove("senderName");
        this.senderTaxId = (String) dataCopy.remove("senderTaxId");
        this.senderBranchCode = (String) dataCopy.remove("senderBranchCode");
        this.senderAccountNumber = (String) dataCopy.remove("senderAccountNumber");
        this.senderAccountType = (String) dataCopy.remove("senderAccountType");
        this.receiverName = (String) dataCopy.remove("receiverName");
        this.receiverTaxId = (String) dataCopy.remove("receiverTaxId");
        this.receiverBankCode = (String) dataCopy.remove("receiverBankCode");
        this.receiverAccountNumber = (String) dataCopy.remove("receiverAccountNumber");
        this.receiverBranchCode = (String) dataCopy.remove("receiverBranchCode");
        this.receiverAccountType = (String) dataCopy.remove("receiverAccountType");
        this.endToEndId = (String) dataCopy.remove("endToEndId");
        this.receiverKeyId = (String) dataCopy.remove("receiverKeyId");
        this.description = (String) dataCopy.remove("description");
        this.reconciliationId = (String) dataCopy.remove("reconciliationId");
        this.initiatorTaxId = (String) dataCopy.remove("initiatorTaxId");
        this.cashAmount = (Long) dataCopy.remove("cashAmount");
        this.cashierBankCode = (String) dataCopy.remove("cashierBankCode");
        this.cashierType = (String) dataCopy.remove("cashierType");
        this.tags = (String[]) dataCopy.remove("tags");
        this.method = (String) dataCopy.remove("method");
        this.fee = null;
        this.status = null;
        this.flow = null;
        this.senderBankCode = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific PixRequest
     * <p>
     * Receive a single PixRequest object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return PixRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static PixRequest get(String id) throws Exception {
        return PixRequest.get(id, null);
    }

    /**
     * Retrieve a specific PixRequest
     * <p>
     * Receive a single PixRequest object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static PixRequest get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve PixRequests
     * <p>
     * Receive a generator of PixRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * endToEndIds [list of strings, default null]: central bank's unique transaction IDs. ex: ["E79457883202101262140HHX553UPqeq", "E79457883202101262140HHX553UPxzx"]
     * externalIds [list of strings, default null]: url safe strings that must be unique among all your PixRequests. Duplicated external IDs will cause failures. By default, this parameter will block any PixRequests that repeats amount and receiver information on the same date. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * <p>
     * Return:
     * @return generator of PixRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixRequest> query(Map<String, Object> params) throws Exception {
        return PixRequest.query(params, null);
    }

    /**
     * Retrieve PixRequests
     * <p>
     * Receive a generator of PixRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixRequest> query(User user) throws Exception {
        return PixRequest.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PixRequests
     * <p>
     * Receive a generator of PixRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of PixRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixRequest> query() throws Exception {
        return PixRequest.query(new HashMap<>(), null);
    }

    /**
     * Retrieve PixRequests
     * <p>
     * Receive a generator of PixRequest objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * endToEndIds [list of strings, default null]: central bank's unique transaction IDs. ex: ["E79457883202101262140HHX553UPqeq", "E79457883202101262140HHX553UPxzx"]
     * externalIds [list of strings, default null]: url safe strings that must be unique among all your PixRequests. Duplicated external IDs will cause failures. By default, this parameter will block any PixRequests that repeats amount and receiver information on the same date. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixRequest> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<PixRequest> requests;
        public String cursor;

        public Page(List<PixRequest> requests, String cursor) {
            this.requests = requests;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged PixRequests
     * <p>
     * Receive a list of up to 100 PixRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * endToEndIds [list of strings, default null]: central bank's unique transaction IDs. ex: ["E79457883202101262140HHX553UPqeq", "E79457883202101262140HHX553UPxzx"]
     * externalIds [list of strings, default null]: url safe strings that must be unique among all your PixRequests. Duplicated external IDs will cause failures. By default, this parameter will block any PixRequests that repeats amount and receiver information on the same date. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * <p>
     * Return:
     * @return PixRequest.Page object:
     * PixRequest.Page.requests: list of PixRequest objects with updated attributes
     * PixRequest.Page.cursor: cursor to retrieve the next page of PixRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged PixRequests
     * <p>
     * Receive a list of up to 100 PixRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixRequest.Page object:
     * PixRequest.Page.requests: list of PixRequest objects with updated attributes
     * PixRequest.Page.cursor: cursor to retrieve the next page of PixRequest objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PixRequests
     * <p>
     * Receive a list of up to 100 PixRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return PixRequest.Page object:
     * PixRequest.Page.requests: list of PixRequest objects with updated attributes
     * PixRequest.Page.cursor: cursor to retrieve the next page of PixRequest objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PixRequests
     * <p>
     * Receive a list of up to 100 PixRequest objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * endToEndIds [list of strings, default null]: central bank's unique transaction IDs. ex: ["E79457883202101262140HHX553UPqeq", "E79457883202101262140HHX553UPxzx"]
     * externalIds [list of strings, default null]: url safe strings that must be unique among all your PixRequests. Duplicated external IDs will cause failures. By default, this parameter will block any PixRequests that repeats amount and receiver information on the same date. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixRequest.Page object:
     * PixRequest.Page.requests: list of PixRequest objects with updated attributes
     * PixRequest.Page.cursor: cursor to retrieve the next page of PixRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<PixRequest> requests = new ArrayList<>();
        for (SubResource request: page.entities) {
            requests.add((PixRequest) request);
        }
        return new Page(requests, page.cursor);
    }

    /**
     * Create PixRequests
     * <p>
     * Send a list of PixRequest objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param requests [list of PixRequest objects or HashMaps]: list of PixRequest objects to be created in the API
     * <p>
     * Return:
     * @return list of PixRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<PixRequest> create(List<?> requests) throws Exception {
        return PixRequest.create(requests, null);
    }

    /**
     * Create PixRequests
     * <p>
     * Send a list of PixRequest objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param requests [list of PixRequest objects or HashMaps]: list of PixRequest objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of PixRequest objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<PixRequest> create(List<?> requests, User user) throws Exception {
        List<PixRequest> requestList = new ArrayList<>();
        for (Object request : requests){
            if (request instanceof Map){
                requestList.add(new PixRequest((Map<String, Object>) request));
                continue;
            }
            if (request instanceof PixRequest){
                requestList.add((PixRequest) request);
                continue;
            }
            throw new Exception("Unknown type \"" + request.getClass() + "\", use PixRequest or HashMap");
        }
        return Rest.post(data, requestList, user);
    }

    /**
     * Create single verified PixRequest object from a content string
     * <p>
     * Create a single PixRequest object from a content string received from a handler listening at the request url.
     * If the provided digital signature does not check out with the Stark public key, a
     * starkinfra.error.InvalidSignatureError will be raised.
     * <p>
     * Parameters:
     * @param content [string]: response content from request received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * <p>
     * Return:
     * @return Parsed PixRequest object
     * @throws Exception error in the request
     */
    public static<T extends PixRequest> T parse(String content, String signature) throws Exception {
        T Resource = Parse.parseAndVerify(data, content, signature, Settings.user);

        Resource.fee = Resource.fee != null ? Resource.fee : 0;
        Resource.tags = Resource.tags != null ? Resource.tags : new String[]{};
        Resource.externalId = !Objects.equals(Resource.externalId, "") ? Resource.externalId : "";
        Resource.description = !Objects.equals(Resource.description, "") ? Resource.description : "";
        return Resource;
    }

    /**
     * Create single verified PixRequest object from a content string
     * <p>
     * Create a single PixRequest object from a content string received from a handler listening at the request url.
     * If the provided digital signature does not check out with the Stark public key, a
     * starkinfra.error.InvalidSignatureError will be raised.
     * <p>
     * Parameters:
     * @param content [string]: response content from request received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Parsed PixRequest object
     * @throws Exception error in the request
     */
    public static PixRequest parse(String content, String signature, User user) throws Exception {
        return Parse.parseAndVerify(data ,content, signature, user);
    }

    /**
     * Helps you respond to a PixRequest authorization
     * <p>
     * Parameters:
     * @param params to be returned on a PixRequest read.
     * status [string]: response to the authorization. ex: "approved" or "denied"
     * reason [string, default null]: denial reason. Options: "invalidAccountNumber", "blockedAccount", "accountClosed", "invalidAccountType", "invalidTransactionType", "taxIdMismatch", "invalidTaxId", "orderRejected", "reversalTimeExpired", "settlementFailed"
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us
     */
    public static String response(Map<String, Object> params){
        Gson gson = new Gson();
        return gson.toJson(params);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "PixRequestLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public PixRequest request;

        /**
         * PixRequest Log object
         * <p>
         * Every time a PixRequest entity is modified, a corresponding PixRequest Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param request [PixRequest]: PixRequest entity to which the log refers to.
         * @param errors [list of strings]: list of errors linked to the PixRequest event.
         * @param type [string]: type of the PixRequest event which triggered the log creation. ex: "processing" or "success"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Log(String created, String type, List<ErrorElement> errors, PixRequest request, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.request = request;
        }

        /**
         * Retrieve a specific PixRequest Log
         * <p>
         * Receive a single PixRequest Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return PixRequest Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific PixRequest Log
         * <p>
         * Receive a single PixRequest Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixRequest Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve PixRequest Logs
         * <p>
         * Receive a generator of PixRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * requestIds [list of strings, default null]: list of PixRequest ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * reconciliationId [string, default null]: PixRequest reconciliation id to filter retrieved objects. ex: "b77f5236-7ab9-4487-9f95-66ee6eaf1781"
         * <p>
         * Return:
         * @return generator of PixRequest Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve PixRequest Logs
         * <p>
         * Receive a generator of PixRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of PixRequest Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve PixRequest Logs
         * <p>
         * Receive a generator of PixRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of PixRequest Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve PixRequest Logs
         * <p>
         * Receive a generator of PixRequest.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * requestIds [list of strings, default null]: list of PixRequest ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * reconciliationId [string, default null]: PixRequest reconciliation id to filter retrieved objects. ex: "b77f5236-7ab9-4487-9f95-66ee6eaf1781"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of PixRequest Log objects with updated attributes
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
         * Retrieve paged PixRequest.Logs
         * <p>
         * Receive a list of up to 100 PixRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * requestIds [list of strings, default null]: list of PixRequest ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * reconciliationId [string, default null]: PixRequest reconciliation id to filter retrieved objects. ex: "b77f5236-7ab9-4487-9f95-66ee6eaf1781"
         * <p>
         * Return:
         * @return PixRequest.Log.Page object:
         * PixRequest.Log.Page.logs: list of PixRequest.Log objects with updated attributes
         * PixRequest.Log.Page.cursor: cursor to retrieve the next page of PixRequest.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged PixRequest.Logs
         * <p>
         * Receive a list of up to 100 PixRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixRequest.Log.Page object:
         * PixRequest.Log.Page.logs: list of PixRequest.Log objects with updated attributes
         * PixRequest.Log.Page.cursor: cursor to retrieve the next page of PixRequest.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged PixRequest.Logs
         * <p>
         * Receive a list of up to 100 PixRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return PixRequest.Log.Page object:
         * PixRequest.Log.Page.logs: list of PixRequest.Log objects with updated attributes
         * PixRequest.Log.Page.cursor: cursor to retrieve the next page of PixRequest.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged PixRequest.Logs
         * <p>
         * Receive a list of up to 100 PixRequest.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * requestIds [list of strings, default null]: list of PixRequest ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * reconciliationId [string, default null]: PixRequest reconciliation id to filter retrieved objects. ex: "b77f5236-7ab9-4487-9f95-66ee6eaf1781"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixRequest.Log.Page object:
         * PixRequest.Log.Page.logs: list of PixRequest.Log objects with updated attributes
         * PixRequest.Log.Page.cursor: cursor to retrieve the next page of PixRequest.Log objects
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
