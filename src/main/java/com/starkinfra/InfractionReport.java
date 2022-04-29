package com.starkinfra;

import com.starkinfra.utils.SubResource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class InfractionReport extends Resource {
    /**
     * InfractionReport object
     * <p>
     * Infraction reports are used to report transactions that are suspected of
     * fraud, to request a refund or to reverse a refund.
     * When you initialize an InfractionReport, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * referenceId       [string]: endToEndId or returnId of the transaction being reported. ex: referenceId= "E20018183202201201450u34sDGd19lz"
     * type              [string]: type of infraction report. Options: "fraud", "reversal", "reversalChargeback"
     * description       [string, Default null]: description for any details that can help with the infraction investigation.
     * creditedBankCode  [string, Default null]: bankCode of the credited Pix participant in the reported transaction. ex: "20018183"
     * agent             [string, Default null]: Options: "reporter" if you created the InfractionReport, "reported" if you received the InfractionReport.
     * analysis          [string, Default null]: analysis that led to the result.
     * bacenId           [string, Default null]: central bank's unique UUID that identifies the infraction report.
     * debitedBankCode   [string, Default null]: bankCode of the debited Pix participant in the reported transaction. ex: "20018183"
     * id                [string, default null]: unique id returned when the InfractionReport is created. ex: "5656565656565656"
     * reportedBy        [string, Default null]: agent that reported the InfractionReport. Options: "debited", "credited".
     * result            [string, Default null]: result after the analysis of the InfractionReport by the receiving party. Options: "agreed", "disagreed"
     * status            [string, default null]: current InfractionReport status. Options: "created", "failed", "delivered", "closed", "canceled".
     * created           [string, default null]: creation datetime for the InfractionReport. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated           [string, default null]: latest update datetime for the InfractionReport. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(InfractionReport.class, "InfractionReport");

    public String referenceId;
    public String type;
    public String description;
    public String creditedBankCode;
    public String agent;
    public String analysis;
    public String bacenId;
    public String debitedBankCode;
    public String reportedBy;
    public String result;
    public String status;
    public String created;
    public String updated;

    /**
     * InfractionReport object
     * <p>
     * When you initialize an InfractionReport, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param referenceId       [string]: endToEndId or returnId of the transaction being reported. ex: referenceId= "E20018183202201201450u34sDGd19lz"
     * @param type              [string]: type of infraction report. Options: "fraud", "reversal", "reversalChargeback"
     * @param description       [string, Default null]: description for any details that can help with the infraction investigation.
     * @param creditedBankCode  [string, Default null]: bankCode of the credited Pix participant in the reported transaction. ex: "20018183"
     * @param agent             [string, Default null]: Options: "reporter" if you created the InfractionReport, "reported" if you received the InfractionReport.
     * @param analysis          [string, Default null]: analysis that led to the result.
     * @param bacenId           [string, Default null]: central bank's unique UUID that identifies the infraction report.
     * @param debitedBankCode   [string, Default null]: bankCode of the debited Pix participant in the reported transaction. ex: "20018183"
     * @param id                [string, default null]: unique id returned when the InfractionReport is created. ex: "5656565656565656"
     * @param reportedBy        [string, Default null]: agent that reported the InfractionReport. Options: "debited", "credited".
     * @param result            [string, Default null]: result after the analysis of the InfractionReport by the receiving party. Options: "agreed", "disagreed"
     * @param status            [string, default null]: current InfractionReport status. Options: "created", "failed", "delivered", "closed", "canceled".
     * @param created           [string, default null]: creation datetime for the InfractionReport. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated           [string, default null]: latest update datetime for the InfractionReport. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    public InfractionReport(String referenceId, String type, String description, String creditedBankCode, String agent,
                            String analysis, String bacenId, String debitedBankCode, String id, String reportedBy,
                            String result, String status, String created, String updated) {
        super(id);
        this.referenceId = referenceId;
        this.type = type;
        this.description = description;
        this.creditedBankCode = creditedBankCode;
        this.agent = agent;
        this.analysis = analysis;
        this.bacenId = bacenId;
        this.debitedBankCode = debitedBankCode;
        this.reportedBy = reportedBy;
        this.result = result;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    /**
     * InfractionReport object
     * <p>
     * When you initialize an InfractionReport, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * referenceId [string]: endToEndId or returnId of the transaction being reported. ex: referenceId= "E20018183202201201450u34sDGd19lz"
     * type [string]: type of infraction report. Options: "fraud", "reversal", "reversalChargeback"
     * <p>
     * Parameters (optional):
     * description [string, Default null]: description for any details that can help with the infraction investigation.
     * creditedBankCode [string, Default null]: bankCode of the credited Pix participant in the reported transaction. ex: "20018183"
     * <p>
     * Attributes (return-only):
     * agent [string, Default null]: Options: "reporter" if you created the InfractionReport, "reported" if you received the InfractionReport.
     * analysis [string, Default null]: analysis that led to the result.
     * bacenId [string, Default null]: central bank's unique UUID that identifies the infraction report.
     * debitedBankCode [string, Default null]: bankCode of the debited Pix participant in the reported transaction. ex: "20018183"
     * id [string, default null]: unique id returned when the InfractionReport is created. ex: "5656565656565656"
     * reportedBy [string, Default null]: agent that reported the InfractionReport. Options: "debited", "credited".
     * result [string, Default null]: result after the analysis of the InfractionReport by the receiving party. Options: "agreed", "disagreed"
     * status [string, default null]: current InfractionReport status. Options: "created", "failed", "delivered", "closed", "canceled".
     * created [string, default null]: creation datetime for the InfractionReport. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string, default null]: latest update datetime for the InfractionReport. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public InfractionReport(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.referenceId = (String) dataCopy.remove("referenceId");
        this.type = (String) dataCopy.remove("type");
        this.description = (String) dataCopy.remove("description");
        this.creditedBankCode = (String) dataCopy.remove("creditedBankCode");
        this.agent = null;
        this.analysis = null;
        this.bacenId = null;
        this.debitedBankCode = null;
        this.reportedBy = null;
        this.result = null;
        this.status = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific InfractionReport
     * <p>
     * Receive a single InfractionReport object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return InfractionReport object with updated attributes
     * @throws Exception error in the request
     */
    public static InfractionReport get(String id) throws Exception {
        return InfractionReport.get(id, null);
    }

    /**
     * Retrieve a specific InfractionReport
     * <p>
     * Receive a single InfractionReport object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return InfractionReport object with updated attributes
     * @throws Exception error in the request
     */
    public static InfractionReport get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve InfractionReports
     * <p>
     * Receive a generator of InfractionReport objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "closed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved InfractionReports. Options: "fraud", "reversal", "reversalChargeback".
     * <p>
     * Return:
     * @return generator of InfractionReport objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<InfractionReport> query(Map<String, Object> params) throws Exception {
        return InfractionReport.query(params, null);
    }

    /**
     * Retrieve InfractionReports
     * <p>
     * Receive a generator of InfractionReport objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of InfractionReport objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<InfractionReport> query(User user) throws Exception {
        return InfractionReport.query(new HashMap<>(), user);
    }

    /**
     * Retrieve InfractionReports
     * <p>
     * Receive a generator of InfractionReport objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of InfractionReport objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<InfractionReport> query() throws Exception {
        return InfractionReport.query(new HashMap<>(), null);
    }

    /**
     * Retrieve InfractionReports
     * <p>
     * Receive a generator of InfractionReport objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of properties for the creation of the InfractionReport
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "closed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved InfractionReports. Options: "fraud", "reversal", "reversalChargeback".
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of InfractionReport objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<InfractionReport> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<InfractionReport> reports;
        public String cursor;

        public Page(List<InfractionReport> reports, String cursor) {
            this.reports = reports;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged InfractionReports
     * <p>
     * Receive a list of up to 100 InfractionReport objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your reports.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "closed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved InfractionReports. Options: "fraud", "reversal", "reversalChargeback".
     * <p>
     * Return:
     * @return InfractionReport.Page object:
     * InfractionReport.Page.reports: list of InfractionReport objects with updated attributes
     * InfractionReport.Page.cursor: cursor to retrieve the next page of InfractionReport objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged InfractionReports
     * <p>
     * Receive a list of up to 100 InfractionReport objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your reports.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return InfractionReport.Page object:
     * InfractionReport.Page.reports: list of InfractionReport objects with updated attributes
     * InfractionReport.Page.cursor: cursor to retrieve the next page of InfractionReport objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged InfractionReports
     * <p>
     * Receive a list of up to 100 InfractionReport objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your reports.
     * <p>
     * Return:
     * @return InfractionReport.Page object:
     * InfractionReport.Page.reports: list of InfractionReport objects with updated attributes
     * InfractionReport.Page.cursor: cursor to retrieve the next page of InfractionReport objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged InfractionReports
     * <p>
     * Receive a list of up to 100 InfractionReport objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your reports.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "closed", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved InfractionReports. Options: "fraud", "reversal", "reversalChargeback".
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return InfractionReport.Page object:
     * InfractionReport.Page.reports: list of InfractionReport objects with updated attributes
     * InfractionReport.Page.cursor: cursor to retrieve the next page of InfractionReport objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<InfractionReport> reports = new ArrayList<>();
        for (SubResource report: page.entities) {
            reports.add((InfractionReport) report);
        }
        return new Page(reports, page.cursor);
    }

    /**
     * Create an InfractionReport
     * <p>
     * Send an InfractionReport object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param report [InfractionReport object or HashMap]: InfractionReport object to be created in the API
     * <p>
     * Return:
     * @return InfractionReport object with updated attributes
     * @throws Exception error in the request
     */
    public static InfractionReport create(InfractionReport report) throws Exception {
        return InfractionReport.create(report, null);
    }

    /**
     * Create an InfractionReport
     * <p>
     * Send an InfractionReport object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param report [InfractionReport object or HashMaps]: InfractionReport object to be created in the API
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return InfractionReport object with updated attributes
     * @throws Exception error in the request
     */
    public static InfractionReport create(InfractionReport report, User user) throws Exception {
        return Rest.postSingle(data, report, user);
    }

    /**
     * Delete an  InfractionReport
     * <p>
     * Delete an InfractionReport entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: InfractionReport unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return deleted InfractionReport object
     * @throws Exception error in the request
     */
    public static InfractionReport delete(String id) throws Exception {
        return InfractionReport.delete(id, null);
    }

    /**
     * Delete an InfractionReport entity
     * <p>
     * Delete an InfractionReport entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: InfractionReport unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return deleted InfractionReport object
     * @throws Exception error in the request
     */
    public static InfractionReport delete(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * Update notification InfractionReport entity
     * <p>
     * Update the InfractionReport by passing id.
     * <p>
     * Parameters:
     * @param id        [string]: InfractionReport id. ex: '5656565656565656'
     * @param patchData map of patch parameters
     *                  result [string]: result after the analysis of the InfractionReport. Options: "agreed", "disagreed"
     *                  analysis [string, default null]: analysis that led to the result.
     * <p>
     * Return:
     * @return InfractionReport object with updated attributes
     * @throws Exception error in the request
     */
    public static InfractionReport update(String id, Map<String, Object> patchData) throws Exception {
        return InfractionReport.update(id, patchData, null);
    }

    /**
     * Update notification InfractionReport entity
     * <p>
     * Update notification InfractionReport by passing id.
     * <p>
     * Parameters:
     * @param id        [string]: InfractionReport id. ex: '5656565656565656'
     * @param patchData map of patch parameters
     *                  result [string]: result after the analysis of the InfractionReport. Options: "agreed", "disagreed"
     *                  analysis [string, default null]: analysis that led to the result.
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return InfractionReport object with updated attributes
     * @throws Exception error in the request
     */
    public static InfractionReport update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    /**
     * InfractionReport.Error object
     * <p>
     * Used to define an error in the Infraction Report
     * <p>
     * Parameters:
     * key      [string]: report describing a part of the Infraction Report value. ex: "Taxes"
     * value    [string]: value to which the key refers to. ex: "120"
     */
    public final static class Error extends SubResource {
        public String key;
        public String value;

        /**
         * InfractionReport.Error object
         * Used to define an error in the Infraction Report
         * Parameters:
         * @param key   [string]: text indicating an item to be described. ex: "Taxes"
         * @param value [string]: text describing the specified item. ex: "Bad"
         */
        public Error(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "InfractionReportLog");

        public String created;
        public String type;
        public List<InfractionReport.Error> errors;
        public String agent;
        public String reason;
        public InfractionReport report;

        /**
         * InfractionReport Log object
         * <p>
         * Every time an InfractionReport entity is modified, a corresponding InfractionReport Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param created [string]: creation datetime for the log. ex: "2020-03-29"
         * @param type [string]: type of the InfractionReport event which triggered the log creation. ex: "created"
         * @param errors [list of strings]: list of errors linked to this InfractionReport event
         * @param report [InfractionReport]: InfractionReport entity to which the log refers to.
         */
        public Log(String created, String type, List<InfractionReport.Error> errors, InfractionReport report, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.report = report;
        }

        /**
         * Retrieve a specific InfractionReport Log
         * <p>
         * Receive a single InfractionReport Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return InfractionReport Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific InfractionReport Log
         * <p>
         * Receive a single InfractionReport Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return InfractionReport Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve InfractionReport Logs
         * <p>
         * Receive a generator of InfractionReport.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * reportIds [string, default null]: list of InfractionReport IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return list of InfractionReport Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve InfractionReport Logs
         * <p>
         * Receive a generator of InfractionReport.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return list of InfractionReport Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve InfractionReport Logs
         * <p>
         * Receive a generator of InfractionReport.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return list of InfractionReport Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve InfractionReport Logs
         * <p>
         * Receive a generator of InfractionReport.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * reportIds [string, default null]: list of InfractionReport IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return list of InfractionReport Log objects with updated attributes
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
         * Retrieve paged InfractionReport.Logs
         * <p>
         * Receive a list of up to 100 InfractionReport.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your reports.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * reportIds [string, default null]: list of InfractionReport IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return InfractionReport.Log.Page object:
         * InfractionReport.Log.Page.logs: list of InfractionReport.Log objects with updated attributes
         * InfractionReport.Log.Page.cursor: cursor to retrieve the next page of InfractionReport.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged InfractionReport.Logs
         * <p>
         * Receive a list of up to 100 InfractionReport.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your reports.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return InfractionReport.Log.Page object:
         * InfractionReport.Log.Page.logs: list of InfractionReport.Log objects with updated attributes
         * InfractionReport.Log.Page.cursor: cursor to retrieve the next page of InfractionReport.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged InfractionReport.Logs
         * <p>
         * Receive a list of up to 100 InfractionReport.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your reports.
         * <p>
         * Return:
         * @return InfractionReport.Log.Page object:
         * InfractionReport.Log.Page.logs: list of InfractionReport.Log objects with updated attributes
         * InfractionReport.Log.Page.cursor: cursor to retrieve the next page of InfractionReport.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged InfractionReport.Logs
         * <p>
         * Receive a list of up to 100 InfractionReport.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your reports.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * reportIds [string, default null]: list of InfractionReport IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return InfractionReport.Log.Page object:
         * InfractionReport.Log.Page.logs: list of InfractionReport.Log objects with updated attributes
         * InfractionReport.Log.Page.cursor: cursor to retrieve the next page of InfractionReport.Log objects
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
