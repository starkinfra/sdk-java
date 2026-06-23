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


public final class PixInternalTransactionReport extends Resource {
    /**
     * PixInternalTransactionReport object
     * <p>
     * Transactions that happen internally — outside of the SPI — must be reported
     * to the Central Bank so they are reflected in the participant's statements. A
     * PixInternalTransactionReport is the report you create for each such transaction.
     * <p>
     * When you initialize a PixInternalTransactionReport, the entity will not be
     * automatically created in the Stark Infra API. The 'create' function sends the
     * objects to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * amount [Long]: amount in cents of the reported transaction. ex: 1234 (= R$ 12.34)
     * created [string]: datetime when the reported transaction occurred. ex: "2026-06-15T17:23:53.980238+00:00"
     * endToEndId [string]: central bank's unique transaction id. ex: "E20018183202201201213u34sav898j"
     * method [string]: execution method of the reported transaction. ex: "manual", "dict", "dynamicQrcode", "contactless", "initiator", "payerQrcode", "staticContactless", "staticQrcode", "subscription"
     * referenceType [string]: type of the reported transaction. ex: "request" or "reversal"
     * senderAccountNumber [string]: sender's bank account number. ex: "76543-8"
     * senderBranchCode [string]: sender's branch code. ex: "2201"
     * senderAccountType [string]: sender's bank account type. ex: "checking", "savings", "salary" or "payment"
     * senderBankCode [string]: sender's participant code (ISPB). ex: "00000665"
     * senderTaxId [string]: sender's tax ID (CPF or CNPJ) with or without formatting. ex: "012.345.678-90"
     * receiverAccountNumber [string]: receiver's bank account number. ex: "00000-0"
     * receiverBranchCode [string]: receiver's branch code. ex: "0001"
     * receiverAccountType [string]: receiver's bank account type. ex: "checking", "savings", "salary" or "payment"
     * receiverBankCode [string]: receiver's participant code (ISPB). ex: "18236120"
     * receiverTaxId [string]: receiver's tax ID (CPF or CNPJ) with or without formatting. ex: "012.345.678-90"
     * <p>
     * Parameters (optional):
     * receiverKeyId [string, default null]: receiver's Pix Key. ex: "+5511989898989"
     * returnId [string, default null]: central bank's unique reversal id. Required when referenceType is "reversal". ex: "D20018183202201201213u34sav898j"
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the PixInternalTransactionReport is created. ex: "5656565656565656"
     * status [string]: current PixInternalTransactionReport status. ex: "created", "failed", "sent" or "success"
     * updated [string]: latest update datetime for the PixInternalTransactionReport. ex: "2026-06-15 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(PixInternalTransactionReport.class, "PixInternalTransactionReport");

    public Long amount;
    public String created;
    public String endToEndId;
    public String method;
    public String referenceType;
    public String senderAccountNumber;
    public String senderBranchCode;
    public String senderAccountType;
    public String senderBankCode;
    public String senderTaxId;
    public String receiverAccountNumber;
    public String receiverBranchCode;
    public String receiverAccountType;
    public String receiverBankCode;
    public String receiverTaxId;
    public String receiverKeyId;
    public String returnId;
    public String status;
    public String updated;

    /**
     * PixInternalTransactionReport object
     * <p>
     * Transactions that happen internally — outside of the SPI — must be reported
     * to the Central Bank so they are reflected in the participant's statements. A
     * PixInternalTransactionReport is the report you create for each such transaction.
     * <p>
     * When you initialize a PixInternalTransactionReport, the entity will not be
     * automatically created in the Stark Infra API. The 'create' function sends the
     * objects to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param amount [Long]: amount in cents of the reported transaction. ex: 1234 (= R$ 12.34)
     * @param created [string]: datetime when the reported transaction occurred. ex: "2026-06-15T17:23:53.980238+00:00"
     * @param endToEndId [string]: central bank's unique transaction id. ex: "E20018183202201201213u34sav898j"
     * @param method [string]: execution method of the reported transaction. ex: "manual", "dict", "dynamicQrcode", "contactless", "initiator", "payerQrcode", "staticContactless", "staticQrcode", "subscription"
     * @param referenceType [string]: type of the reported transaction. ex: "request" or "reversal"
     * @param senderAccountNumber [string]: sender's bank account number. ex: "76543-8"
     * @param senderBranchCode [string]: sender's branch code. ex: "2201"
     * @param senderAccountType [string]: sender's bank account type. ex: "checking", "savings", "salary" or "payment"
     * @param senderBankCode [string]: sender's participant code (ISPB). ex: "00000665"
     * @param senderTaxId [string]: sender's tax ID (CPF or CNPJ) with or without formatting. ex: "012.345.678-90"
     * @param receiverAccountNumber [string]: receiver's bank account number. ex: "00000-0"
     * @param receiverBranchCode [string]: receiver's branch code. ex: "0001"
     * @param receiverAccountType [string]: receiver's bank account type. ex: "checking", "savings", "salary" or "payment"
     * @param receiverBankCode [string]: receiver's participant code (ISPB). ex: "18236120"
     * @param receiverTaxId [string]: receiver's tax ID (CPF or CNPJ) with or without formatting. ex: "012.345.678-90"
     * @param receiverKeyId [string, default null]: receiver's Pix Key. ex: "+5511989898989"
     * @param returnId [string, default null]: central bank's unique reversal id. Required when referenceType is "reversal". ex: "D20018183202201201213u34sav898j"
     * @param status [string]: current PixInternalTransactionReport status. ex: "created", "failed", "sent" or "success"
     * @param updated [string]: latest update datetime for the PixInternalTransactionReport. ex: "2026-06-15 10:30:00.000000+00:00"
     * @param id [string]: unique id returned when the PixInternalTransactionReport is created. ex: "5656565656565656"
     */
    public PixInternalTransactionReport(Long amount, String created, String endToEndId, String method,
                                        String referenceType, String senderAccountNumber, String senderBranchCode,
                                        String senderAccountType, String senderBankCode, String senderTaxId,
                                        String receiverAccountNumber, String receiverBranchCode,
                                        String receiverAccountType, String receiverBankCode, String receiverTaxId,
                                        String receiverKeyId, String returnId, String status, String updated, String id
    ) {
        super(id);
        this.amount = amount;
        this.created = created;
        this.endToEndId = endToEndId;
        this.method = method;
        this.referenceType = referenceType;
        this.senderAccountNumber = senderAccountNumber;
        this.senderBranchCode = senderBranchCode;
        this.senderAccountType = senderAccountType;
        this.senderBankCode = senderBankCode;
        this.senderTaxId = senderTaxId;
        this.receiverAccountNumber = receiverAccountNumber;
        this.receiverBranchCode = receiverBranchCode;
        this.receiverAccountType = receiverAccountType;
        this.receiverBankCode = receiverBankCode;
        this.receiverTaxId = receiverTaxId;
        this.receiverKeyId = receiverKeyId;
        this.returnId = returnId;
        this.status = status;
        this.updated = updated;
    }

    /**
     * PixInternalTransactionReport object
     * <p>
     * Transactions that happen internally — outside of the SPI — must be reported
     * to the Central Bank so they are reflected in the participant's statements. A
     * PixInternalTransactionReport is the report you create for each such transaction.
     * <p>
     * When you initialize a PixInternalTransactionReport, the entity will not be
     * automatically created in the Stark Infra API. The 'create' function sends the
     * objects to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the PixInternalTransactionReport
     * amount [Long]: amount in cents of the reported transaction. ex: 1234 (= R$ 12.34)
     * created [string]: datetime when the reported transaction occurred. ex: "2026-06-15T17:23:53.980238+00:00"
     * endToEndId [string]: central bank's unique transaction id. ex: "E20018183202201201213u34sav898j"
     * method [string]: execution method of the reported transaction. ex: "manual", "dict", "dynamicQrcode", "contactless", "initiator", "payerQrcode", "staticContactless", "staticQrcode", "subscription"
     * referenceType [string]: type of the reported transaction. ex: "request" or "reversal"
     * senderAccountNumber [string]: sender's bank account number. ex: "76543-8"
     * senderBranchCode [string]: sender's branch code. ex: "2201"
     * senderAccountType [string]: sender's bank account type. ex: "checking", "savings", "salary" or "payment"
     * senderBankCode [string]: sender's participant code (ISPB). ex: "00000665"
     * senderTaxId [string]: sender's tax ID (CPF or CNPJ) with or without formatting. ex: "012.345.678-90"
     * receiverAccountNumber [string]: receiver's bank account number. ex: "00000-0"
     * receiverBranchCode [string]: receiver's branch code. ex: "0001"
     * receiverAccountType [string]: receiver's bank account type. ex: "checking", "savings", "salary" or "payment"
     * receiverBankCode [string]: receiver's participant code (ISPB). ex: "18236120"
     * receiverTaxId [string]: receiver's tax ID (CPF or CNPJ) with or without formatting. ex: "012.345.678-90"
     * <p>
     * Parameters (optional):
     * receiverKeyId [string, default null]: receiver's Pix Key. ex: "+5511989898989"
     * returnId [string, default null]: central bank's unique reversal id. Required when referenceType is "reversal". ex: "D20018183202201201213u34sav898j"
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the PixInternalTransactionReport is created. ex: "5656565656565656"
     * status [string]: current PixInternalTransactionReport status. ex: "created", "failed", "sent" or "success"
     * updated [string]: latest update datetime for the PixInternalTransactionReport. ex: "2026-06-15 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public PixInternalTransactionReport(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.amount = ((Number) dataCopy.remove("amount")).longValue();
        this.created = (String) dataCopy.remove("created");
        this.endToEndId = (String) dataCopy.remove("endToEndId");
        this.method = (String) dataCopy.remove("method");
        this.referenceType = (String) dataCopy.remove("referenceType");
        this.senderAccountNumber = (String) dataCopy.remove("senderAccountNumber");
        this.senderBranchCode = (String) dataCopy.remove("senderBranchCode");
        this.senderAccountType = (String) dataCopy.remove("senderAccountType");
        this.senderBankCode = (String) dataCopy.remove("senderBankCode");
        this.senderTaxId = (String) dataCopy.remove("senderTaxId");
        this.receiverAccountNumber = (String) dataCopy.remove("receiverAccountNumber");
        this.receiverBranchCode = (String) dataCopy.remove("receiverBranchCode");
        this.receiverAccountType = (String) dataCopy.remove("receiverAccountType");
        this.receiverBankCode = (String) dataCopy.remove("receiverBankCode");
        this.receiverTaxId = (String) dataCopy.remove("receiverTaxId");
        this.receiverKeyId = (String) dataCopy.remove("receiverKeyId");
        this.returnId = (String) dataCopy.remove("returnId");
        this.status = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific PixInternalTransactionReport
     * <p>
     * Receive a single PixInternalTransactionReport object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return PixInternalTransactionReport object with updated attributes
     * @throws Exception error in the request
     */
    public static PixInternalTransactionReport get(String id) throws Exception {
        return PixInternalTransactionReport.get(id, null);
    }

    /**
     * Retrieve a specific PixInternalTransactionReport
     * <p>
     * Receive a single PixInternalTransactionReport object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixInternalTransactionReport object with updated attributes
     * @throws Exception error in the request
     */
    public static PixInternalTransactionReport get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve PixInternalTransactionReports
     * <p>
     * Receive a generator of PixInternalTransactionReport objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of PixInternalTransactionReport objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixInternalTransactionReport> query(Map<String, Object> params) throws Exception {
        return PixInternalTransactionReport.query(params, null);
    }

    /**
     * Retrieve PixInternalTransactionReports
     * <p>
     * Receive a generator of PixInternalTransactionReport objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixInternalTransactionReport objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixInternalTransactionReport> query(User user) throws Exception {
        return PixInternalTransactionReport.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PixInternalTransactionReports
     * <p>
     * Receive a generator of PixInternalTransactionReport objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of PixInternalTransactionReport objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixInternalTransactionReport> query() throws Exception {
        return PixInternalTransactionReport.query(new HashMap<>(), null);
    }

    /**
     * Retrieve PixInternalTransactionReports
     * <p>
     * Receive a generator of PixInternalTransactionReport objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixInternalTransactionReport objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixInternalTransactionReport> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<PixInternalTransactionReport> reports;
        public String cursor;

        public Page(List<PixInternalTransactionReport> reports, String cursor) {
            this.reports = reports;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged PixInternalTransactionReports
     * <p>
     * Receive a list of up to 100 PixInternalTransactionReport objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return PixInternalTransactionReport.Page object:
     * PixInternalTransactionReport.Page.reports: list of PixInternalTransactionReport objects with updated attributes
     * PixInternalTransactionReport.Page.cursor: cursor to retrieve the next page of PixInternalTransactionReport objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged PixInternalTransactionReports
     * <p>
     * Receive a list of up to 100 PixInternalTransactionReport objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixInternalTransactionReport.Page object:
     * PixInternalTransactionReport.Page.reports: list of PixInternalTransactionReport objects with updated attributes
     * PixInternalTransactionReport.Page.cursor: cursor to retrieve the next page of PixInternalTransactionReport objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PixInternalTransactionReports
     * <p>
     * Receive a list of up to 100 PixInternalTransactionReport objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return PixInternalTransactionReport.Page object:
     * PixInternalTransactionReport.Page.reports: list of PixInternalTransactionReport objects with updated attributes
     * PixInternalTransactionReport.Page.cursor: cursor to retrieve the next page of PixInternalTransactionReport objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PixInternalTransactionReports
     * <p>
     * Receive a list of up to 100 PixInternalTransactionReport objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixInternalTransactionReport.Page object:
     * PixInternalTransactionReport.Page.reports: list of PixInternalTransactionReport objects with updated attributes
     * PixInternalTransactionReport.Page.cursor: cursor to retrieve the next page of PixInternalTransactionReport objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<PixInternalTransactionReport> reports = new ArrayList<>();
        for (SubResource report: page.entities) {
            reports.add((PixInternalTransactionReport) report);
        }
        return new Page(reports, page.cursor);
    }

    /**
     * Create PixInternalTransactionReports
     * <p>
     * Send a list of PixInternalTransactionReport objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param reports [list of PixInternalTransactionReport objects or HashMaps]: list of PixInternalTransactionReport objects to be created in the API
     * <p>
     * Return:
     * @return list of PixInternalTransactionReport objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<PixInternalTransactionReport> create(List<?> reports) throws Exception {
        return PixInternalTransactionReport.create(reports, null);
    }

    /**
     * Create PixInternalTransactionReports
     * <p>
     * Send a list of PixInternalTransactionReport objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param reports [list of PixInternalTransactionReport objects or HashMaps]: list of PixInternalTransactionReport objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of PixInternalTransactionReport objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<PixInternalTransactionReport> create(List<?> reports, User user) throws Exception {
        List<PixInternalTransactionReport> reportList = new ArrayList<>();
        for (Object report : reports){
            if (report instanceof Map){
                reportList.add(new PixInternalTransactionReport((Map<String, Object>) report));
                continue;
            }
            if (report instanceof PixInternalTransactionReport){
                reportList.add((PixInternalTransactionReport) report);
                continue;
            }
            throw new Exception("Unknown type \"" + report.getClass() + "\", use PixInternalTransactionReport or HashMap");
        }
        return Rest.post(data, reportList, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "PixInternalTransactionReportLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public PixInternalTransactionReport report;

        /**
         * PixInternalTransactionReport Log object
         * <p>
         * Every time a PixInternalTransactionReport entity is modified, a corresponding
         * PixInternalTransactionReport Log is generated for the entity. This log is never
         * generated by the user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param report [PixInternalTransactionReport]: PixInternalTransactionReport entity to which the log refers to.
         * @param errors [list of ErrorElement]: list of errors linked to the PixInternalTransactionReport event.
         * @param type [string]: type of the PixInternalTransactionReport event which triggered the log creation. ex: "created", "failed", "sent" or "success"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Log(String created, String type, List<ErrorElement> errors, PixInternalTransactionReport report, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.report = report;
        }

        /**
         * Retrieve a specific PixInternalTransactionReport Log
         * <p>
         * Receive a single PixInternalTransactionReport Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return PixInternalTransactionReport Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific PixInternalTransactionReport Log
         * <p>
         * Receive a single PixInternalTransactionReport Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixInternalTransactionReport Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve PixInternalTransactionReport Logs
         * <p>
         * Receive a generator of PixInternalTransactionReport.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * reportIds [list of strings, default null]: list of PixInternalTransactionReport ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656"]
         * <p>
         * Return:
         * @return generator of PixInternalTransactionReport Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve PixInternalTransactionReport Logs
         * <p>
         * Receive a generator of PixInternalTransactionReport.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of PixInternalTransactionReport Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve PixInternalTransactionReport Logs
         * <p>
         * Receive a generator of PixInternalTransactionReport.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of PixInternalTransactionReport Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve PixInternalTransactionReport Logs
         * <p>
         * Receive a generator of PixInternalTransactionReport.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * reportIds [list of strings, default null]: list of PixInternalTransactionReport ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of PixInternalTransactionReport Log objects with updated attributes
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
         * Retrieve paged PixInternalTransactionReport.Logs
         * <p>
         * Receive a list of up to 100 PixInternalTransactionReport.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * reportIds [list of strings, default null]: list of PixInternalTransactionReport ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656"]
         * <p>
         * Return:
         * @return PixInternalTransactionReport.Log.Page object:
         * PixInternalTransactionReport.Log.Page.logs: list of PixInternalTransactionReport.Log objects with updated attributes
         * PixInternalTransactionReport.Log.Page.cursor: cursor to retrieve the next page of PixInternalTransactionReport.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged PixInternalTransactionReport.Logs
         * <p>
         * Receive a list of up to 100 PixInternalTransactionReport.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixInternalTransactionReport.Log.Page object:
         * PixInternalTransactionReport.Log.Page.logs: list of PixInternalTransactionReport.Log objects with updated attributes
         * PixInternalTransactionReport.Log.Page.cursor: cursor to retrieve the next page of PixInternalTransactionReport.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged PixInternalTransactionReport.Logs
         * <p>
         * Receive a list of up to 100 PixInternalTransactionReport.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return PixInternalTransactionReport.Log.Page object:
         * PixInternalTransactionReport.Log.Page.logs: list of PixInternalTransactionReport.Log objects with updated attributes
         * PixInternalTransactionReport.Log.Page.cursor: cursor to retrieve the next page of PixInternalTransactionReport.Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged PixInternalTransactionReport.Logs
         * <p>
         * Receive a list of up to 100 PixInternalTransactionReport.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-09"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * reportIds [list of strings, default null]: list of PixInternalTransactionReport ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixInternalTransactionReport.Log.Page object:
         * PixInternalTransactionReport.Log.Page.logs: list of PixInternalTransactionReport.Log objects with updated attributes
         * PixInternalTransactionReport.Log.Page.cursor: cursor to retrieve the next page of PixInternalTransactionReport.Log objects
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
