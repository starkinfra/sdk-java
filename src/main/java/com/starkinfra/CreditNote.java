package com.starkinfra;

import com.google.gson.*;
import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.SubResource;
import com.starkinfra.error.ErrorElement;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Objects;
import java.util.ArrayList;
import java.lang.reflect.Type;


public final class CreditNote extends Resource {
    /**
     * CreditNote object
     * <p>
     * CreditNotes are used to generate CCB contracts between you and your customers.
     * <p>
     * When you initialize a CreditNote, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * templateId [string]: ID of the contract template on which the CreditNote will be based. ex: templateId="0123456789101112"
     * name [string]: credit receiver's full name. ex: "Anthony Edward Stark"
     * taxId [string]: credit receiver's tax ID (CPF or CNPJ). ex: "20.018.183/0001-80"
     * nominalAmount [Long]: amount in cents transferred to the credit receiver, before deductions. ex: 11234 (= R$ 112.34)
     * scheduled [string]: date of payment execution. ex: "2020-03-11"
     * invoices [list of CreditNote.Invoice objects or maps]: list of Invoice objects to be created and sent to the credit receiver. ex: invoices=[Invoice(), Invoice()]
     * payment [CreditNote.Transfer object or map]: payment entity to be created and sent to the credit receiver. ex: payment=Creditnote.Transfer()
     * signers [list of CreditSigner objects or map]: list of signer entities each containing signer's name, contact and delivery method for the signature request. ex: signers=[CreditSigner(), CreditSigner()]
     * externalId [string]: a string that must be unique among all your CreditNotes, used to avoid resource duplication. ex: "my-internal-id-123456"
     * streetLine1 [string]: credit receiver main address. ex: "Av. Paulista, 200"
     * streetLine2 [string]: credit receiver address complement. ex: "Apto. 123"
     * district [string]: credit receiver address district / neighbourhood. ex: "Bela Vista"
     * city [string]: credit receiver address city. ex: "Rio de Janeiro"
     * stateCode [string]: credit receiver address state. ex: "GO"
     * zipCode [string]: credit receiver address zip code. ex: "01311-200"
     * paymentType [string, default null]: payment type, inferred from the payment parameter if it is not a map. ex: "transfer"
     * rebateAmount [Long, default 0]: credit analysis fee deducted from lent amount. ex: 11234 (= R$ 112.34)
     * tags [list of strings, default []]: list of strings for reference when searching for CreditNotes. ex: ["employees", "monthly"]
     * expiration [Long, default 604800]: time interval in seconds between scheduled date and expiration date. ex 123456789
     * id [string]: unique id returned when the CreditNote is created. ex: "5656565656565656"
     * amount [Long]: CreditNote value in cents. ex: 1234 (= R$ 12.34)
     * documentId [string]: ID of the signed document to execute this CreditNote. ex: "4545454545454545"
     * status [string]: current status of the CreditNote. Options: "canceled", "created", "expired", "failed", "processing", "signed", "success"
     * transactionIds [list of strings]: ledger transaction ids linked to this CreditNote. ex: ["19827356981273"]
     * workspaceId [string]: ID of the Workspace that generated this CreditNote. ex: "4545454545454545"
     * taxAmount [Long]: tax amount included in the CreditNote. ex: 100
     * nominalInterest [Number]: yearly nominal interest rate of the CreditNote, in percentage. ex: 11.5
     * interest [Number]: yearly effective interest rate of the CreditNote, in percentage. ex: 12.5
     * created [string]: creation datetime for the CreditNote. ex: "2020-03-11 08:00:00.000"
     * updated [string]: latest update datetime for the CreditNote. ex: "2020-03-11 08:00:00.000"
     *
     */
    static ClassData data = new ClassData(CreditNote.class, "CreditNote");

    public String templateId;
    public String name;
    public String taxId;
    public Long nominalAmount;
    public String scheduled;
    public List<CreditNote.Invoice> invoices;
    public Resource payment;
    public List<CreditSigner> signers;
    public String externalId;
    public String streetLine1;
    public String streetLine2;
    public String district;
    public String city;
    public String stateCode;
    public String zipCode;
    public String paymentType;
    public Long rebateAmount;
    public String[] tags;
    public Long amount;
    public Long expiration;
    public String documentId;
    public String status;
    public String[] transactionIds;
    public String workspaceId;
    public Long taxAmount;
    public Number interest;
    public Number nominalInterest;
    public String created;
    public String updated;

    /**
     * CreditNote object
     * <p>
     * CreditNotes are used to generate CCB contracts between you and your customers.
     * <p>
     * When you initialize a CreditNote, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * To create scheduled CreditNotes, which will display the discount, interest, etc. on the final users banking interface,
     * use dates instead of datetimes on the "due" and "discounts" fields.
     * All parameters are passed in a Map of String and Object.
     * <p>
     * Parameters:
     * @param templateId [string]: ID of the contract template on which the CreditNote will be based. ex: templateId="0123456789101112"
     * @param name [string]: credit receiver's full name. ex: "Anthony Edward Stark"
     * @param taxId [string]: credit receiver's tax ID (CPF or CNPJ). ex: "20.018.183/0001-80"
     * @param nominalAmount [Long]: amount in cents transferred to the credit receiver, before deductions. ex: 11234 (= R$ 112.34)
     * @param scheduled [string]: date of payment execution. ex: "2020-03-11"
     * @param invoices [list of CreditNote.Invoice objects or maps]: list of Invoice objects to be created and sent to the credit receiver. ex: invoices=[Invoice(), Invoice()]
     * @param payment [CreditNote.Transfer object or map]: payment entity to be created and sent to the credit receiver. ex: payment=Creditnote.Transfer()
     * @param signers [list of CreditSigner objects or map]: list of signer entities each containing signer's name, contact and delivery method for the signature request. ex: signers=[CreditSigner(), CreditSigner()]
     * @param externalId [string]: a string that must be unique among all your CreditNotes, used to avoid resource duplication. ex: "my-internal-id-123456"
     * @param streetLine1 [string]: credit receiver main address. ex: "Av. Paulista, 200"
     * @param streetLine2 [string]: credit receiver address complement. ex: "Apto. 123"
     * @param district [string]: credit receiver address district / neighbourhood. ex: "Bela Vista"
     * @param city [string]: credit receiver address city. ex: "Rio de Janeiro"
     * @param stateCode [string]: credit receiver address state. ex: "GO"
     * @param zipCode [string]: credit receiver address zip code. ex: "01311-200"
     * @param paymentType [string, default null]: payment type, inferred from the payment parameter if it is not a map. ex: "transfer"
     * @param rebateAmount [Long, default 0]: credit analysis fee deducted from lent amount. ex: 11234 (= R$ 112.34)
     * @param tags [list of strings, default []]: list of strings for reference when searching for CreditNotes. ex: ["employees", "monthly"]
     * @param expiration [Long, default 604800]: time interval in seconds between scheduled date and expiration date. ex 123456789
     * @param id [string]: unique id returned when the CreditNote is created. ex: "5656565656565656"
     * @param amount [Long]: CreditNote value in cents. ex: 1234 (= R$ 12.34)
     * @param documentId [string]: ID of the signed document to execute this CreditNote. ex: "4545454545454545"
     * @param status [string]: current status of the CreditNote. Options: "canceled", "created", "expired", "failed", "processing", "signed", "success"
     * @param transactionIds [list of strings]: ledger transaction ids linked to this CreditNote. ex: ["19827356981273"]
     * @param workspaceId [string]: ID of the Workspace that generated this CreditNote. ex: "4545454545454545"
     * @param taxAmount [Long]: tax amount included in the CreditNote. ex: 100
     * @param nominalInterest [Number]: yearly nominal interest rate of the CreditNote, in percentage. ex: 11.5
     * @param interest [Number]: yearly effective interest rate of the CreditNote, in percentage. ex: 12.5
     * @param created [string]: creation datetime for the CreditNote. ex: "2020-03-11 08:00:00.000"
     * @param updated [string]: latest update datetime for the CreditNote. ex: "2020-03-11 08:00:00.000"
     */
    public CreditNote(String templateId, String name, String taxId, Long nominalAmount, String scheduled,
                      List<Invoice> invoices, Resource payment, List<CreditSigner> signers, String externalId,
                      String streetLine1, String streetLine2, String district, String city, String stateCode,
                      String zipCode, String paymentType, Long rebateAmount, String[] tags, String id, Long amount,
                      Long expiration, String documentId, String status, String[] transactionIds, String workspaceId,
                      Long taxAmount, Number interest, Number nominalInterest, String created, String updated
    ) throws Exception {
        super(id);
        this.templateId = templateId;
        this.name = name;
        this.taxId = taxId;
        this.nominalAmount = nominalAmount;
        this.scheduled = scheduled;
        this.invoices = invoices;
        this.payment = payment;
        this.signers = signers;
        this.externalId = externalId;
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.district = district;
        this.city = city;
        this.stateCode = stateCode;
        this.zipCode = zipCode;
        this.rebateAmount = rebateAmount;
        this.tags = tags;
        this.expiration = expiration;
        this.amount = amount;
        this.documentId = documentId;
        this.status = status;
        this.transactionIds = transactionIds;
        this.workspaceId = workspaceId;
        this.taxAmount = taxAmount;
        this.nominalInterest = nominalInterest;
        this.interest = interest;
        this.created = created;
        this.updated = updated;
        this.paymentType = paymentType;
        if(paymentType == null) {
            this.paymentType = CreditNote.getType(payment);
        }
    }

    /**
     * CreditNote object
     * <p>
     * CreditNotes are used to generate CCB contracts between you and your customers.
     * <p>
     * When you initialize a CreditNote, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * All parameters are passed in a Map of String and Object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the CreditNote
     * templateId [string]: ID of the contract template on which the CreditNote will be based. ex: templateId="0123456789101112"
     * name [string]: credit receiver's full name. ex: "Anthony Edward Stark"
     * taxId [string]: credit receiver's tax ID (CPF or CNPJ). ex: "20.018.183/0001-80"
     * nominalAmount [Long]: amount in cents transferred to the credit receiver, before deductions. ex: 11234 (= R$ 112.34)
     * scheduled [string]: date of payment execution. ex: "2020-03-11"
     * invoices [list of CreditNote.Invoice objects or maps]: list of Invoice objects to be created and sent to the credit receiver. ex: invoices=[Invoice(), Invoice()]
     * payment [CreditNote.Transfer object or map]: payment entity to be created and sent to the credit receiver. ex: payment=Creditnote.Transfer()
     * signers [list of CreditSigner objects or map]: list of signer entities each containing signer's name, contact and delivery method for the signature request. ex: signers=[CreditSigner(), CreditSigner()]
     * externalId [string]: a string that must be unique among all your CreditNotes, used to avoid resource duplication. ex: "my-internal-id-123456"
     * streetLine1 [string]: credit receiver main address. ex: "Av. Paulista, 200"
     * streetLine2 [string]: credit receiver address complement. ex: "Apto. 123"
     * district [string]: credit receiver address district / neighbourhood. ex: "Bela Vista"
     * city [string]: credit receiver address city. ex: "Rio de Janeiro"
     * stateCode [string]: credit receiver address state. ex: "GO"
     * zipCode [string]: credit receiver address zip code. ex: "01311-200"
     * <p>
     * Parameters (conditionally required):
     * paymentType [string]: payment type, inferred from the payment parameter if it is not a map. ex: "transfer"
     * <p>
     * Parameters (optional):
     * rebateAmount [Long, default 0]: credit analysis fee deducted from lent amount. ex: 11234 (= R$ 112.34)
     * tags [list of strings, default []]: list of strings for reference when searching for CreditNotes. ex: ["employees", "monthly"]
     * expiration [Long, default 604800]: time interval in seconds between scheduled date and expiration date. ex 123456789
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the CreditNote is created. ex: "5656565656565656"
     * amount [Long]: CreditNote value in cents. ex: 1234 (= R$ 12.34)
     * documentId [string]: ID of the signed document to execute this CreditNote. ex: "4545454545454545"
     * status [string]: current status of the CreditNote. Options: "canceled", "created", "expired", "failed", "processing", "signed", "success"
     * transactionIds [list of strings]: ledger transaction ids linked to this CreditNote. ex: ["19827356981273"]
     * workspaceId [string]: ID of the Workspace that generated this CreditNote. ex: "4545454545454545"
     * taxAmount [Long]: tax amount included in the CreditNote. ex: 100
     * nominalInterest [Number]: yearly nominal interest rate of the CreditNote, in percentage. ex: 11.5
     * interest [Number]: yearly effective interest rate of the CreditNote, in percentage. ex: 12.5
     * created [string]: creation datetime for the CreditNote. ex: "2020-03-11 08:00:00.000"
     * updated [string]: latest update datetime for the CreditNote. ex: "2020-03-11 08:00:00.000"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public CreditNote(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.templateId = (String) dataCopy.remove("templateId");
        this.name = (String) dataCopy.remove("name");
        this.taxId = (String) dataCopy.remove("taxId");
        this.nominalAmount = ((Number) dataCopy.remove("nominalAmount")).longValue();
        this.scheduled = (String) dataCopy.remove("scheduled");
        this.invoices = parseInvoices((List<Object>) dataCopy.remove("invoices"));
        this.payment = (Resource) dataCopy.remove("payment");
        this.signers = parseSigners((List<Object>) dataCopy.remove("signers"));
        this.externalId = (String) dataCopy.remove("externalId");
        this.streetLine1 = (String) dataCopy.remove("streetLine1");
        this.streetLine2 = (String) dataCopy.remove("streetLine2");
        this.district = (String) dataCopy.remove("district");
        this.city = (String) dataCopy.remove("city");
        this.stateCode = (String) dataCopy.remove("stateCode");
        this.zipCode = (String) dataCopy.remove("zipCode");
        this.rebateAmount = ((Number) dataCopy.remove("rebateAmount")).longValue();
        this.tags = (String[]) dataCopy.remove("tags");
        this.expiration = (Long) dataCopy.remove("expiration");
        this.amount = null;
        this.documentId = null;
        this.status = null;
        this.transactionIds = null;
        this.workspaceId = null;
        this.taxAmount = null;
        this.nominalInterest = null;
        this.interest = null;
        this.created = null;
        this.updated = null;

        this.paymentType = (String) dataCopy.remove("paymentType");
        if(this.paymentType == null) {
            this.paymentType = CreditNote.getType(payment);
        }

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    @SuppressWarnings("unchecked")
    private List<CreditSigner> parseSigners(List<Object> signers) throws Exception {
        if (signers == null)
            return null;

        List<CreditSigner> parsed = new ArrayList<>();
        if (signers.size() == 0 || signers.get(0) instanceof CreditSigner) {
            for (Object signer : signers) {
                parsed.add((CreditSigner) signer);
            }

            return parsed;
        }

        for (Object signer : signers) {
            CreditSigner signerObject = new CreditSigner((Map<String, Object>) signer);
            parsed.add(signerObject);
        }

        return parsed;
    }

    @SuppressWarnings("unchecked")
    public static List<CreditNote.Invoice> parseInvoices(List<Object> invoices) throws Exception {
        if (invoices == null)
            return null;

        List<CreditNote.Invoice> parsed = new ArrayList<>();
        if (invoices.size() == 0 || invoices.get(0) instanceof CreditNote.Invoice) {
            for (Object invoice : invoices) {
                parsed.add((CreditNote.Invoice) invoice);
            }
            return parsed;
        }

        for (Object invoice : invoices) {
            CreditNote.Invoice invoiceObject = new CreditNote.Invoice((Map<String, Object>) invoice);
            parsed.add(invoiceObject);
        }

        return parsed;
    }

    @SuppressWarnings("unchecked")
    public static class Deserializer implements JsonDeserializer<CreditNote> {
        @Override
        public CreditNote deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctw) throws JsonParseException {
            JsonElement resourceElement = json.getAsJsonObject().get("payment");
            json.getAsJsonObject().remove("payment");
            CreditNote note = new Gson().fromJson(json, CreditNote.class);
            Resource resource = null;
            if (Objects.equals(note.paymentType, "transfer")) {
                resource = new Gson().fromJson(resourceElement, CreditNote.Transfer.class);
            }

            note.payment = resource;

            return note;
        }
    }

    /**
     * Create CreditNote
     * <p>
     * Send a list of CreditNote objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param notes [list of CreditNote objects or Maps]: list of CreditNote objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of CreditNote objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<CreditNote> create(List<?> notes, User user) throws Exception {
        List<CreditNote> noteList = new ArrayList<>();
        for (Object note : notes){
            if (note instanceof Map){
                noteList.add(new CreditNote((Map<String, Object>) note));
                continue;
            }
            if (note instanceof CreditNote){
                noteList.add((CreditNote) note);
                continue;
            }
            throw new Exception("Unknown type \"" + note.getClass() + "\", use CreditNote or HashMap");
        }
        return Rest.post(data, noteList, user);
    }

    /**
     * Create CreditNote
     * <p>
     * Send a list of CreditNote objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param notes [list of CreditNote objects or Maps]: list of CreditNote objects to be created in the API
     * <p>
     * Return:
     * @return list of CreditNote objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<CreditNote> create(List<?> notes) throws Exception {
        return CreditNote.create(notes, null);
    }

    /**
     * Retrieve a specific CreditNote
     * <p>
     * Receive a single CreditNote object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: CreditNote unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
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
     * @param id [string]: CreditNote unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return CreditNote object with updated attributes
     * @throws Exception error in the request
     */
    public static CreditNote get(String id) throws Exception {
        return CreditNote.get(id, null);
    }

    /**
     * Retrieve CreditNotes
     * <p>
     * Receive a generator of Creditnote objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["canceled", "created", "expired", "failed", "processing", "signed", "success"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of CreditNote objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CreditNote> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve CreditNotes
     * <p>
     * Receive a generator of CreditNote objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["canceled", "created", "expired", "failed", "processing", "signed", "success"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of CreditNote objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CreditNote> query(Map<String, Object> params) throws Exception {
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve CreditNotes
     * <p>
     * Receive a generator of CreditNote objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of CreditNote objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CreditNote> query(User user) throws Exception {
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve CreditNotes
     * <p>
     * Receive a generator of CreditNote objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of CreditNote objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CreditNote> query() throws Exception {
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<CreditNote> notes;
        public String cursor;
        public Page(List<CreditNote> notes, String cursor) {
            this.notes = notes;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged CreditNotes
     * <p>
     * Receive a list of up to 100 CreditNote objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["canceled", "created", "expired", "failed", "processing", "signed", "success"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return CreditNote.Page object:
     * CreditNote.Page.notes: list of CreditNote objects with updated attributes
     * CreditNote.Page.cursor: cursor to retrieve the next page of CreditNote objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<CreditNote> notes = new ArrayList<>();
        for (SubResource note: page.entities) {
            notes.add((CreditNote) note);
        }
        return new Page(notes, page.cursor);
    }

    /**
     * Retrieve paged CreditNote
     * <p>
     * Receive a list of up to 100 CreditNote objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: ["canceled", "created", "expired", "failed", "processing", "signed", "success"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return CreditNote.Page object:
     * CreditNote.Page.notes: list of CreditNote objects with updated attributes
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
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return CreditNote.Page object:
     * CreditNote.Page.notes: list of CreditNote objects with updated attributes
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
     * CreditNote.Page.notes: list of CreditNote objects with updated attributes
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
     * @param id [string]: CreditNote unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled CreditNote object
     * @throws Exception error in the request
     */
    public static CreditNote cancel(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * Cancel a CreditNote entity
     * <p>
     * Cancel a CreditNote entity previously created in the Stark Infra API
     * <p>
     * Parameters (required):
     * @param id [string]: CreditNote unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return canceled CreditNote object
     * @throws Exception error in the request
     */
    public static CreditNote cancel(String id) throws Exception {
        return CreditNote.cancel(id, null);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "CreditNoteLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public CreditNote note;

        /**
         * CreditNote Log object
         * <p>
         * Every time a CreditNote entity is modified, a corresponding CreditNote Log
         * is generated for the entity. This log is never generated by the user.
         * <p>
         * Parameters:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param note [CreditNote]: CreditNote entity to which the log refers to.
         * @param errors [list of strings]: list of errors linked to the CreditNote event.
         * @param type [string]: type of the CreditNote event which triggered the log creation. ex: "processing" or "success"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10"
         */

        public Log(String created, String type, List<ErrorElement> errors, CreditNote note, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.note = note;
        }

        /**
         * Retrieve a specific CreditNote Log
         * <p>
         * Receive a single CreditNote Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: CreditNote unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return CreditNote.Log object with updated attributes
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
         * @param id [string]: CreditNote unique id. ex: "5656565656565656"
         * @param user [Project object]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return CreditNote.Log object with updated attributes
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
         * @param params parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * noteIds [list of strings, default null]: list of CreditNote ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of CreditNote Log objects with updated attributes
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
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of CreditNote Log objects with updated attributes
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
         * @return generator of CreditNote Log objects with updated attributes
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
         * @param params parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * noteIds [list of strings, default null]: list of CreditNote ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user  [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of CreditNote Log objects with updated attributes
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
         * @param params parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * noteIds [list of strings, default null]: list of CreditNote ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
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
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
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
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "created", "paid", "canceled" or "overdue"
         * noteIds [list of strings, default null]: list of CreditNote ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
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

    private static String getType(Resource payment) throws Exception{
        if(payment instanceof Transfer)
            return "transfer";

        throw new Exception("Payment must be a Transfer.");
    }

    public static final class Transfer extends Resource{
        /**
         * CreditNote.Transfer object
         * <p>
         * Transfer object to be created after contract signature and sent to the credit receiver.
         * <p>
         * Parameters:
         * name [string]: receiver full name. ex: "Anthony Edward Stark"
         * taxId [string]: receiver tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
         * bankCode [string]: code of the receiver bank institution in Brazil. ex: "20018183"
         * branchCode [string]: receiver bank account branch. Use '-' in case there is a verifier digit. ex: "1357-9"
         * accountNumber [string]: receiver bank account number. Use '-' before the verifier digit. ex: "876543-2"
         * accountType [string, default "checking"]: Receiver bank account type. This parameter only has effect on Pix Transfers. ex: "checking", "savings", "salary" or "payment"
         * tags [list of strings, default []]: list of strings for reference when searching for transfers. ex: ["employees", "monthly"]
         * id [string]: unique id returned when the transfer is created. ex: "5656565656565656"
         * amount [Long]: amount in cents to be transferred. ex: 1234 (= R$ 12.34)
         * externalId [string]: url safe string that must be unique among all your transfers. Duplicated externalIds will cause failures. By default, this parameter will block any transfer that repeats amount and receiver information on the same date. ex: "my-internal-id-123456"
         * scheduled [string]: date when the transfer will be processed. May be pushed to next business day if necessary. ex: "2022-10-10"
         * description [string]: optional description to override default description to be shown in the bank statement. ex: "Payment for service #1234"
         * fee [integer]: fee charged when the Transfer is processed. ex: 200 (= R$ 2.00)
         * status [string]: current transfer status. ex: "success" or "failed"
         * transactionIds [list of strings]: ledger Transaction IDs linked to this Transfer (if there are two, the second is the chargeback). ex: ["19827356981273"]
         * created [string]: creation datetime for the transfer. "2020-03-10 10:30:00.000000+00:00"
         * updated [string]: latest update datetime for the transfer. ex: "2020-03-10 10:30:00.000000+00:00"
         *
         */
        static ClassData data = new ClassData(Transfer.class, "Transfer");

        public String name;
        public String taxId;
        public String bankCode;
        public String branchCode;
        public String accountNumber;
        public String accountType;
        public String[] tags;
        public Number amount;
        public String externalId;
        public String scheduled;
        public String description;
        public Integer fee;
        public String status;
        public String[] transactionIds;
        public String created;
        public String updated;

        /**
         * CreditNote.Transfer object
         * <p>
         * Transfer object to be created after contract signature and sent to the credit receiver.
         * <p>
         * Parameters:
         * @param name [string]: receiver full name. ex: "Anthony Edward Stark"
         * @param taxId [string]: receiver tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
         * @param bankCode [string]: code of the receiver bank institution in Brazil. ex: "20018183"
         * @param branchCode [string]: receiver bank account branch. Use '-' in case there is a verifier digit. ex: "1357-9"
         * @param accountNumber [string]: receiver bank account number. Use '-' before the verifier digit. ex: "876543-2"
         * @param accountType [string, default "checking"]: Receiver bank account type. This parameter only has effect on Pix Transfers. ex: "checking", "savings", "salary" or "payment"
         * @param tags [list of strings, default []]: list of strings for reference when searching for transfers. ex: ["employees", "monthly"]
         * @param amount [Long]: amount in cents to be transferred. ex: 1234 (= R$ 12.34)
         * @param externalId [string]: url safe string that must be unique among all your transfers. Duplicated externalids will cause failures. By default, this parameter will block any transfer that repeats amount and receiver information on the same date. ex: "my-internal-id-123456"
         * @param scheduled [string]: date or datetime when the transfer will be processed. May be pushed to next business day if necessary. ex: "2022-10-10"
         * @param description [string]: optional description to override default description to be shown in the bank statement. ex: "Payment for service #1234"
         * @param id [string]: unique id returned when the transfer is created. ex: "5656565656565656"
         * @param fee [integer]: fee charged when the Transfer is processed. ex: 200 (= R$ 2.00)
         * @param status [string]: current transfer status. ex: "success" or "failed"
         * @param transactionIds [list of strings]: ledger Transaction IDs linked to this Transfer (if there are two, the second is the chargeback). ex: ["19827356981273"]
         * @param created [string]: creation datetime for the transfer. "2020-03-10 10:30:00.000000+00:00"
         * @param updated [string]: latest update datetime for the transfer. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Transfer(String name, String taxId, String bankCode, String branchCode, String accountNumber,
                        String accountType, String[] tags, Long amount, String externalId, String scheduled,
                        String description, String id, Integer fee, String status, String[] transactionIds,
                        String created, String updated
        ) {
            super(id);
            this.name = name;
            this.taxId = taxId;
            this.bankCode = bankCode;
            this.branchCode = branchCode;
            this.accountNumber = accountNumber;
            this.accountType = accountType;
            this.tags = tags;
            this.amount = amount;
            this.externalId = externalId;
            this.scheduled = scheduled;
            this.description = description;
            this.fee = fee;
            this.status = status;
            this.transactionIds = transactionIds;
            this.created = created;
            this.updated = updated;
        }

        /**
         * CreditNote.Transfer object
         * <p>
         * Transfer object to be created after contract signature and sent to the credit receiver.
         * <p>
         * Parameters (required):
         * @param data map of properties for the creation of the CreditNote.Transfer
         * name [string]: receiver full name. ex: "Anthony Edward Stark"
         * taxId [string]: receiver tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
         * bankCode [string]: code of the receiver bank institution in Brazil. ex: "20018183"
         * branchCode [string]: receiver bank account branch. Use '-' in case there is a verifier digit. ex: "1357-9"
         * accountNumber [string]: receiver bank account number. Use '-' before the verifier digit. ex: "876543-2"
         * <p>
         * Parameters (optional):
         * accountType [string, default "checking"]: Receiver bank account type. This parameter only has effect on Pix Transfers. ex: "checking", "savings", "salary" or "payment"
         * tags [list of strings, default null]: list of strings for reference when searching for transfers. ex: ["employees", "monthly"]
         * <p>
         * Attributes (return-only):
         * id [string]: unique id returned when the transfer is created. ex: "5656565656565656"
         * amount [Long]: amount in cents to be transferred. ex: 1234 (= R$ 12.34)
         * externalId [string]: url safe string that must be unique among all your transfers. Duplicated externalIds will cause failures. By default, this parameter will block any transfer that repeats amount and receiver information on the same date. ex: "my-internal-id-123456"
         * scheduled [string]: date or datetime when the transfer will be processed. May be pushed to next business day if necessary. ex: "2022-10-10", "2020-03-10 10:30:00.000000+00:00"
         * description [string]: optional description to override default description to be shown in the bank statement. ex: "Payment for service #1234"
         * fee [integer]: fee charged when the Transfer is processed. ex: 200 (= R$ 2.00)
         * status [string]: current transfer status. ex: "success" or "failed"
         * transactionIds [list of strings]: ledger Transaction IDs linked to this Transfer (if there are two, the second is the chargeback). ex: ["19827356981273"]
         * created [string]: creation datetime for the transfer. "2020-03-10 10:30:00.000000+00:00"
         * updated [string]: latest update datetime for the transfer. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Transfer(Map<String, Object> data) throws Exception {
            super(null);
            HashMap<String, Object> dataCopy = new HashMap<>(data);

            this.name = (String) dataCopy.remove("name");
            this.taxId = (String) dataCopy.remove("taxId");
            this.bankCode = (String) dataCopy.remove("bankCode");
            this.branchCode = (String) dataCopy.remove("branchCode");
            this.accountNumber = (String) dataCopy.remove("accountNumber");
            this.accountType = (String) dataCopy.remove("accountType");
            this.tags = (String[]) dataCopy.remove("tags");
            this.amount = null;
            this.externalId = null;
            this.scheduled = null;
            this.description = null;
            this.fee = null;
            this.status = null;
            this.transactionIds = null;
            this.created = null;
            this.updated = null;

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }
    }

    public static final class Invoice extends Resource{
        /**
         * CreditNote.Invoice object
         * <p>
         * Invoice to be issued after the contract is signed, to be paid by the credit receiver.
         * <p>
         * Parameters:
         * amount [Long]: Invoice value in cents. Minimum = 1 (any value will be accepted). ex: 1234 (= R$ 12.34)
         * due [string, default now + 2 days]: Invoice due date or datetime in UTC ISO format. ex: "2020-10-28T17:59:26.249976+00:00" for immediate invoices and "2020-10-28" for scheduled invoices
         * expiration [Long, default 5097600 (59 days)]: time interval in seconds between due date and expiration date. ex 123456789
         * tags [list of strings, default []]: list of strings for tagging
         * descriptions [list of HashMaps, default []]: list of HashMaps with "key":string and (optional) "value":string pairs
         * id [string]: unique id returned when Invoice is created. ex: "5656565656565656"
         * name [string]: payer name. ex: "Iron Bank S.A."
         * taxId [string]: payer tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
         * pdf [string]: public Invoice PDF URL. ex: "https://invoice.starkbank.com/pdf/d454fa4e524441c1b0c1a729457ed9d8"
         * link [string]: public Invoice webpage URL. ex: "https://my-workspace.sandbox.starkbank.com/invoicelink/d454fa4e524441c1b0c1a729457ed9d8"
         * fine [number, default 2.0]: Invoice fine for overdue payment in %. ex: 2.5
         * interest [number, default 1.0]: Invoice monthly interest for overdue payment in %. ex: 5.2
         * nominalAmount [Long]: Invoice emission value in cents (will change if invoice is updated, but not if it's paid). ex: 400000
         * fineAmount [Long]: Invoice fine value calculated over nominalAmount. ex: 20000
         * interestAmount [Long]: Invoice interest value calculated over nominalAmount. ex: 10000
         * discountAmount [Long]: Invoice discount value calculated over nominalAmount. ex: 3000
         * discounts [list of CreditNote.Invoice.Discount objects]: list of Discount objects containing percentage and due parameters
         * brcode [string]: BR Code for the Invoice payment. ex: "00020101021226800014br.gov.bcb.pix2558invoice.starkbank.com/f5333103-3279-4db2-8389-5efe335ba93d5204000053039865802BR5913Arya Stark6009Sao Paulo6220051656565656565656566304A9A0"
         * status [string]: current Invoice status. ex: "registered" or "paid"
         * fee [integer]: fee charged by this Invoice. ex: 200 (= R$ 2.00)
         * transactionIds [list of strings]: ledger transaction ids linked to this Invoice (if there are more than one, all but the first are reversals or failed reversal chargebacks). ex: ["19827356981273"]
         * created [string]: creation datetime for the Invoice. ex: "2020-03-10 10:30:00.000000+00:00"
         * updated [string]: latest update datetime for the Invoice. ex: "2020-03-10 10:30:00.000000+00:00"
         *
         */
        static ClassData data = new ClassData(Invoice.class, "Invoice");

        public Long amount;
        public String due;
        public Long expiration;
        public String[] tags;
        public List<CreditNote.Invoice.Description> descriptions;
        public String name;
        public String taxId;
        public String pdf;
        public String link;
        public Number fine;
        public Number interest;
        public Long nominalAmount;
        public Long fineAmount;
        public Long interestAmount;
        public Long discountAmount;
        public List<CreditNote.Invoice.Discount> discounts;
        public String brcode;
        public String status;
        public Integer fee;
        public String[] transactionIds;
        public String created;
        public String updated;

        /**
         * CreditNote.Invoice object
         * <p>
         * Invoice object to be created after contract signature and sent to the credit receiver.
         * <p>
         * Parameters:
         * @param amount [Long]: Invoice value in cents. Minimum = 1 (any value will be accepted). ex: 1234 (= R$ 12.34)
         * @param due [string, default now + 2 days]: Invoice due date or datetime in UTC ISO format. ex: "2020-10-28T17:59:26.249976+00:00" for immediate invoices and "2020-10-28" for scheduled invoices
         * @param expiration [Long, default 5097600 (59 days)]: time interval in seconds between due date and expiration date. ex 123456789
         * @param tags [list of strings, default []]: list of strings for tagging
         * @param descriptions [list of HashMaps, default []]: list of HashMaps with "key":string and (optional) "value":string pairs
         * @param id [string]: unique id returned when Invoice is created. ex: "5656565656565656"
         * @param name [string]: payer name. ex: "Iron Bank S.A."
         * @param taxId [string]: payer tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
         * @param pdf [string]: public Invoice PDF URL. ex: "https://invoice.starkbank.com/pdf/d454fa4e524441c1b0c1a729457ed9d8"
         * @param link [string]: public Invoice webpage URL. ex: "https://my-workspace.sandbox.starkbank.com/invoicelink/d454fa4e524441c1b0c1a729457ed9d8"
         * @param fine [number, default 2.0]: Invoice fine for overdue payment in %. ex: 2.5
         * @param interest [number, default 1.0]: Invoice monthly interest for overdue payment in %. ex: 5.2
         * @param nominalAmount [Long]: Invoice emission value in cents (will change if invoice is updated, but not if it's paid). ex: 400000
         * @param fineAmount [Long]: Invoice fine value calculated over nominalAmount. ex: 20000
         * @param interestAmount [Long]: Invoice interest value calculated over nominalAmount. ex: 10000
         * @param discountAmount [Long]: Invoice discount value calculated over nominalAmount. ex: 3000
         * @param discounts [list of CreditNote.Invoice.Discount objects]: list of Discount objects containing percentage and due parameters
         * @param brcode [string]: BR Code for the Invoice payment. ex: "00020101021226800014br.gov.bcb.pix2558invoice.starkbank.com/f5333103-3279-4db2-8389-5efe335ba93d5204000053039865802BR5913Arya Stark6009Sao Paulo6220051656565656565656566304A9A0"
         * @param status [string]: current Invoice status. ex: "registered" or "paid"
         * @param fee [integer]: fee charged by this Invoice. ex: 200 (= R$ 2.00)
         * @param transactionIds [list of strings]: ledger transaction ids linked to this Invoice (if there are more than one, all but the first are reversals or failed reversal chargebacks). ex: ["19827356981273"]
         * @param created [string]: creation datetime for the Invoice. ex: "2020-03-10 10:30:00.000000+00:00"
         * @param updated [string]: latest update datetime for the Invoice. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Invoice(
            Long amount, String due, Long expiration, String[] tags, List<CreditNote.Invoice.Description> descriptions,
            String name, String taxId, String pdf, String link, Number fine, Number interest, Long nominalAmount,
            Long fineAmount, Long interestAmount, Long discountAmount, List<CreditNote.Invoice.Discount> discounts,
            String id, String brcode, String status, Integer fee, String[] transactionIds, String created, String updated
        ) {
            super(id);
            this.amount = amount;
            this.due = due;
            this.expiration = expiration;
            this.tags = tags;
            this.descriptions = descriptions;
            this.name = name;
            this.taxId = taxId;
            this.pdf = pdf;
            this.link = link;
            this.fine = fine;
            this.interest = interest;
            this.nominalAmount = nominalAmount;
            this.fineAmount = fineAmount;
            this.interestAmount = interestAmount;
            this.discountAmount = discountAmount;
            this.discounts = discounts;
            this.brcode = brcode;
            this.status = status;
            this.fee = fee;
            this.transactionIds = transactionIds;
            this.created = created;
            this.updated = updated;
        }

        /**
         * CreditNote.Invoice object
         * <p>
         * Invoice object to be created after contract signature and sent to the credit receiver.
         * <p>
         * Parameters (required):
         * @param data map of properties for the creation of the CreditNote.Invoice
         * amount [Long]: Invoice value in cents. Minimum = 1 (any value will be accepted). ex: 1234 (= R$ 12.34)
         * <p>
         * Parameters (optional):
         * due [string, default now + 2 days]: Invoice due date or datetime in UTC ISO format. ex: "2020-10-28T17:59:26.249976+00:00" for immediate invoices and "2020-10-28" for scheduled invoices
         * expiration [Long, default 5097600 (59 days)]: time interval in seconds between due date and expiration date. ex 123456789
         * tags [list of strings, default []]: list of strings for tagging
         * descriptions [list of CreditNote.Invoice.Description objects, default []]: list of Discount objects containing key and value parameters
         * <p>
         * Attributes (return-only):
         * id [string]: unique id returned when Invoice is created. ex: "5656565656565656"
         * name [string]: payer name. ex: "Iron Bank S.A."
         * taxId [string]: payer tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
         * pdf [string]: public Invoice PDF URL. ex: "https://invoice.starkbank.com/pdf/d454fa4e524441c1b0c1a729457ed9d8"
         * link [string]: public Invoice webpage URL. ex: "https://my-workspace.sandbox.starkbank.com/invoicelink/d454fa4e524441c1b0c1a729457ed9d8"
         * fine [number, default 2.0]: Invoice fine for overdue payment in %. ex: 2.5
         * interest [number, default 1.0]: Invoice monthly interest for overdue payment in %. ex: 5.2
         * nominalAmount [Long]: Invoice emission value in cents (will change if invoice is updated, but not if it's paid). ex: 400000
         * fineAmount [Long]: Invoice fine value calculated over nominalAmount. ex: 20000
         * interestAmount [Long]: Invoice interest value calculated over nominalAmount. ex: 10000
         * discountAmount [Long]: Invoice discount value calculated over nominalAmount. ex: 3000
         * discounts [list of CreditNote.Invoice.Discount objects]: list of Discount objects containing percentage and due parameters
         * brcode [string]: BR Code for the Invoice payment. ex: "00020101021226800014br.gov.bcb.pix2558invoice.starkbank.com/f5333103-3279-4db2-8389-5efe335ba93d5204000053039865802BR5913Arya Stark6009Sao Paulo6220051656565656565656566304A9A0"
         * status [string]: current Invoice status. ex: "registered" or "paid"
         * fee [integer]: fee charged by this Invoice. ex: 200 (= R$ 2.00)
         * transactionIds [list of strings]: ledger transaction ids linked to this Invoice (if there are more than one, all but the first are reversals or failed reversal chargebacks). ex: ["19827356981273"]
         * created [string]: creation datetime for the Invoice. ex: "2020-03-10 10:30:00.000000+00:00"
         * updated [string]: latest update datetime for the Invoice. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        @SuppressWarnings("unchecked")
        public Invoice(Map<String, Object> data) throws Exception {
            super(null);
            HashMap<String, Object> dataCopy = new HashMap<>(data);

            this.amount = ((Number) dataCopy.remove("amount")).longValue();
            this.due = (String) dataCopy.remove("due");
            this.expiration = (Long) dataCopy.remove("expiration");
            this.tags = (String[]) dataCopy.remove("tags");
            this.descriptions = parseDescriptions((List<Object>) dataCopy.remove("descriptions"));
            this.fine = (Number) dataCopy.remove("fine");
            this.interest = (Number) dataCopy.remove("interest");
            this.discounts = parseDiscounts((List<Object>) dataCopy.remove("discounts"));
            this.name = null;
            this.taxId = null;
            this.pdf = null;
            this.link = null;
            this.nominalAmount = null;
            this.fineAmount = null;
            this.interestAmount = null;
            this.discountAmount = null;
            this.brcode = null;
            this.status = null;
            this.fee = null;
            this.transactionIds = null;
            this.created = null;
            this.updated = null;

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }

        @SuppressWarnings("unchecked")
        private List<Invoice.Description> parseDescriptions(List<Object> descriptions) throws Exception {
            if (descriptions == null)
                return null;

            List<Invoice.Description> parsed = new ArrayList<>();
            if (descriptions.size() == 0 || descriptions.get(0) instanceof Invoice.Description) {
                for (Object description : descriptions) {
                    parsed.add((Invoice.Description) description);
                }
                return parsed;
            }

            for (Object description : descriptions) {
                Invoice.Description descriptionObject = new Invoice.Description((Map<String, Object>) description);
                parsed.add(descriptionObject);
            }
            return parsed;
        }

        @SuppressWarnings("unchecked")
        private List<Invoice.Discount> parseDiscounts(List<Object> discounts) throws Exception {
            if (discounts == null)
                return null;

            List<Invoice.Discount> parsed = new ArrayList<>();
            if (discounts.size() == 0 || discounts.get(0) instanceof Invoice.Discount) {
                for (Object discount : discounts) {
                    parsed.add((Invoice.Discount) discount);
                }

                return parsed;
            }

            for (Object discount : discounts) {
                Invoice.Discount discountObject = new Invoice.Discount((Map<String, Object>) discount);
                parsed.add(discountObject);
            }

            return parsed;
        }

        /**
         * CreditNote.Invoice.Discount object
         * <p>
         * Used to define a Discount in the Invoice
         * <p>
         * Parameters:
         * percentage [number]: discount percentage that will be applied. ex: 2.5
         * due [string]: Date after when the discount will be overdue in UTC ISO format. ex: "2020-11-25T17:59:26.249976+00:00"
         *
         */
        public final static class Discount extends SubResource{
            public Number percentage;
            public String due;


            /**
             * CreditNote.Invoice.Discount object
             * <p>
             * Used to define a Discount in the Invoice
             * <p>
             * Parameters:
             * @param percentage [number]: discount percentage that will be applied. ex: 2.5
             * @param due [string]: Date after when the discount will be overdue in UTC ISO format. ex: "2020-11-25T17:59:26.249976+00:00"
             */
            public Discount(Number percentage, String due){
                this.percentage = percentage;
                this.due = due;
            }

            /**
             * CreditNote.Invoice.Discount object
             * <p>
             * Used to define a Discount in the Invoice
             * <p>
             * Parameters:
             * @param data map of properties for the creation of the CreditNote.Invoice.Discount
             * percentage [number]: discount percentage that will be applied. ex: 2.5
             * due [string]: Date after when the discount will be overdue in UTC ISO format. ex: "2020-11-25T17:59:26.249976+00:00"
             */
            public Discount(Map<String, Object> data) throws Exception {
                HashMap<String, Object> dataCopy = new HashMap<>(data);

                this.percentage = (Number) dataCopy.remove("percentage");
                this.due = (String) dataCopy.remove("due");

                if (!dataCopy.isEmpty()) {
                    throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
                }
            }
        }

        /**
         * CreditNote.Invoice.Description object
         * <p>
         * Used to define a Description in the Invoice
         * <p>
         * Parameters:
         * key [string]: key describing a part of the invoice value. ex: "Taxes"
         * value [string]: value to which the key refers to. ex: "120"
         *
         */
        public final static class Description extends SubResource {
            public String key;
            public String value;

            /**
             * CreditNote.Invoice.Description object
             * <p>
             * Used to define a Description in the Invoice
             * <p>
             * Parameters:
             * @param key [string]: text indicating an item to be described. ex: "Taxes"
             * @param value [string]: text describing the specified item. ex: "Bad"
             */
            public Description(String key, String value){
                this.key = key;
                this.value = value;
            }

            /**
             * CreditNote.Invoice.Description object
             * <p>
             * Used to define a Description for the Invoice
             * <p>
             * Parameters:
             * @param data map of properties for the creation of the CreditNote.Invoice.Description
             * key [string]: text indicating an item to be described. ex: "Taxes"
             * value [string]: text describing the specified item. ex: "Bad"
             */
            public Description(Map<String, Object> data) throws Exception {
                HashMap<String, Object> dataCopy = new HashMap<>(data);

                this.key = (String) dataCopy.remove("key");
                this.value = (String) dataCopy.remove("value");

                if (!dataCopy.isEmpty()) {
                    throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
                }
            }
        }
    }
}
