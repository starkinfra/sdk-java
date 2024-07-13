package com.starkinfra;

import com.google.gson.*;
import com.starkinfra.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Objects;
import java.util.ArrayList;
import java.lang.reflect.Type;


public final class CreditPreview extends SubResource {
    /**
     * CreditPreview object
     * <p>
     * A CreditPreview is used to get information from a credit before taking it.
     * This resource can be used to preview credit notes
     * <p>
     * When you initialize a CreditPreview, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * credit [CreditNotePreview object]: CreditNotePreview object containing credit information.
     * type [string]: Credit type, inferred from the payment parameter if it is not a dictionary. ex: "credit-note"
     *
     */
    static SubResource.ClassData data = new SubResource.ClassData(CreditPreview.class, "CreditPreview");

    public CreditNotePreview credit;
    public String type;

    /**
     * CreditPreview object
     * <p>
     * A CreditPreview is used to get information from a credit before taking it.
     * This resource can be used to preview credit notes
     * <p>
     * When you initialize a CreditPreview, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * @param credit [CreditNotePreview object]: CreditNotePreview object containing credit information.
     * @param type [string]: Credit type, inferred from the payment parameter if it is not a dictionary. ex: "credit-note"
     */

    public CreditPreview(CreditNotePreview credit, String type) {
        this.credit = credit;
        this.type = type;
    }

    /**
     * CreditPreview object
     * <p>
     * A CreditPreview is used to get information from a credit before taking it.
     * This resource can be used to preview credit notes
     * <p>
     * When you initialize a CreditPreview, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the CreditPreview
     * credit [CreditNotePreview object]: CreditNotePreview object containing credit information.
     * <p>
     * Parameters (conditionally required):
     * type [string]: Credit type, inferred from the payment parameter if it is not a dictionary. ex: "credit-note"
     * @throws Exception error in the request
     */
    public CreditPreview(Map<String, Object> data) throws Exception {
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.credit = (CreditNotePreview) dataCopy.remove("credit");
        this.type = (String) dataCopy.remove("type");

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    @SuppressWarnings("unchecked")
    public static class Deserializer implements JsonDeserializer<CreditPreview> {
        @Override
        public CreditPreview deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctw) throws JsonParseException {
            JsonElement resourceElement = json.getAsJsonObject().get("credit");
            json.getAsJsonObject().remove("credit");
            CreditPreview preview = new Gson().fromJson(json, CreditPreview.class);
            CreditNotePreview resource = null;
            if (Objects.equals(preview.type, "credit-note")) {
                resource = new Gson().fromJson(resourceElement, CreditNotePreview.class);
            }

            preview.credit = resource;

            return preview;
        }
    }

    /**
     * Create CreditPreviews
     * <p>
     * Send a list of CreditPreview objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param previews [list of CreditPreview objects or Maps]: list of CreditPreview objects to be created in the API
     * <p>
     * Return:
     * @return list of CreditPreview objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<CreditPreview> create(List<?> previews) throws Exception {
        return CreditPreview.create(previews, null);
    }

    /**
     * Create CreditPreviews
     * <p>
     * Send a list of CreditPreview objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param previews [list of CreditPreview objects or Maps]: list of CreditPreview objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of CreditPreview objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<CreditPreview> create(List<?> previews, User user) throws Exception {
        List<CreditPreview> previewsList = new ArrayList<>();
        for (Object preview : previews){
            if (preview instanceof Map){
                previewsList.add(new CreditPreview((Map<String, Object>) preview));
                continue;
            }
            if (preview instanceof CreditPreview){
                previewsList.add((CreditPreview) preview);
                continue;
            }
            throw new Exception("Unknown type \"" + preview.getClass() + "\", use CreditPreview or HashMap");
        }
        return Rest.post(data, previewsList, user);
    }

    public static final class CreditNotePreview extends SubResource{
        /**
         * CreditNotePreview object
         * <p>
         * A CreditNotePreview is used to preview a CCB contract between the borrower and lender with a specific table type.
         * <p>
         * When you initialize a CreditNotePreview, the entity will not be automatically sent to the Stark Infra API.
         * <p>
         * Parameters:
         * type [string]: table type that defines the amortization system. Options: "sac", "price", "american", "bullet", "custom"
         * nominalAmount [Long]: amount in cents transferred to the credit receiver, before deductions. ex: nominalAmount=11234 (= R$ 112.34)
         * scheduled [string]: date of transfer execution. ex: "2020-03-11"
         * taxId [string]: credit receiver's tax ID (CPF or CNPJ). ex: "20.018.183/0001-80"
         * invoices [list of CreditNote.Invoice objects]: list of Invoice objects to be created and sent to the credit receiver. ex: invoices=[Invoice(), Invoice()]
         * nominalInterest [Number]: yearly nominal interest rate of the credit note, in percentage. ex: 12.5
         * initialDue [string]: date of the first invoice. ex: "2020-03-11"
         * count [integer]: quantity of invoices for payment. ex: 12
         * initialAmount [Long]: value of the first invoice in cents. ex: 1234 (= R$12.34)
         * interval [string]: interval between invoices. ex: "year", "month"
         * rebateAmount [Long, default null]: credit analysis fee deducted from lent amount. ex: rebateAmount=11234 (= R$ 112.34)
         * amount [Long]: credit note value in cents. ex: 1234 (= R$ 12.34)
         * interest [Number]: yearly effective interest rate of the credit note, in percentage. ex: 12.5
         * taxAmount [Long]: tax amount included in the credit note. ex: 100
         *
         */
        public String type;
        public Long nominalAmount;
        public String scheduled;
        public String taxId;
        public List<CreditNote.Invoice> invoices;
        public Number nominalInterest;
        public String initialDue;
        public Integer count;
        public Number initialAmount;
        public String interval;
        public Long rebateAmount;
        public Long amount;
        public Number interest;
        public Long taxAmount;

        /**
         * CreditNotePreview object
         * <p>
         * A CreditNotePreview is used to preview a CCB contract between the borrower and lender with a specific table type.
         * <p>
         * When you initialize a CreditNotePreview, the entity will not be automatically sent to the Stark Infra API.
         * <p>
         * Parameters:
         * @param type [string]: table type that defines the amortization system. Options: "sac", "price", "american", "bullet", "custom"
         * @param nominalAmount [Long]: amount in cents transferred to the credit receiver, before deductions. ex: nominalAmount=11234 (= R$ 112.34)
         * @param scheduled [string]: date of transfer execution. ex: "2020-03-11"
         * @param taxId [string]: credit receiver's tax ID (CPF or CNPJ). ex: "20.018.183/0001-80"
         * @param invoices [list of CreditNote.Invoice objects]: list of Invoice objects to be created and sent to the credit receiver. ex: invoices=[Invoice(), Invoice()]
         * @param nominalInterest [Number]: yearly nominal interest rate of the credit note, in percentage. ex: 12.5
         * @param initialDue [string]: date of the first invoice. ex: "2020-03-11"
         * @param count [integer]: quantity of invoices for payment. ex: 12
         * @param initialAmount [Long]: value of the first invoice in cents. ex: 1234 (= R$12.34)
         * @param interval [string]: interval between invoices. ex: "year", "month"
         * @param rebateAmount [Long, default null]: credit analysis fee deducted from lent amount. ex: rebateAmount=11234 (= R$ 112.34)
         * @param amount [Long]: credit note value in cents. ex: 1234 (= R$ 12.34)
         * @param interest [Number]: yearly effective interest rate of the credit note, in percentage. ex: 12.5
         * @param taxAmount [Long]: tax amount included in the credit note. ex: 100
         */
        public CreditNotePreview (String type, Long nominalAmount, String scheduled, String taxId,
                                  List<CreditNote.Invoice> invoices, Number nominalInterest, String initialDue, Integer count,
                                  Long initialAmount, String interval, Long rebateAmount, Long amount, Number interest,
                                  Long taxAmount
        ) {
            this.type = type;
            this.nominalAmount = nominalAmount;
            this.scheduled = scheduled;
            this.taxId = taxId;
            this.invoices = invoices;
            this.nominalInterest = nominalInterest;
            this.initialDue = initialDue;
            this.count = count;
            this.initialAmount = initialAmount;
            this.interval = interval;
            this.rebateAmount = rebateAmount;
            this.amount = amount;
            this.interest = interest;
            this.taxAmount = taxAmount;
        }

        /**
         * CreditNotePreview object
         * <p>
         * A CreditNotePreview is used to preview a CCB contract between the borrower and lender with a specific table type.
         * <p>
         * When you initialize a CreditNotePreview, the entity will not be automatically sent to the Stark Infra API.
         * <p>
         * Parameters (required):
         * @param data map of properties for the creation of the CreditNotePreview
         * type [string]: table type that defines the amortization system. Options: "sac", "price", "american", "bullet", "custom"
         * nominalAmount [Long]: amount in cents transferred to the credit receiver, before deductions. ex: nominalAmount=11234 (= R$ 112.34)
         * scheduled [string]: date of transfer execution. ex: "2020-03-11"
         * taxId [string]: credit receiver's tax ID (CPF or CNPJ). ex: "20.018.183/0001-80"
         * <p>
         * Parameters (conditionally required):
         * invoices [list of CreditNote.Invoice objects]: list of Invoice objects to be created and sent to the credit receiver. ex: invoices=[Invoice(), Invoice()]
         * nominalInterest [Number]: yearly nominal interest rate of the credit note, in percentage. ex: 12.5
         * initialDue [string]: date of the first invoice. ex: "2020-03-11"
         * count [integer]: quantity of invoices for payment. ex: 12
         * initialAmount [Long]: value of the first invoice in cents. ex: 1234 (= R$12.34)
         * interval [string]: interval between invoices. ex: "year", "month"
         * <p>
         * Parameters (optional):
         * rebateAmount [Long, default null]: credit analysis fee deducted from lent amount. ex: rebateAmount=11234 (= R$ 112.34)
         * <p>
         * Attributes (return-only):
         * amount [Long]: credit note value in cents. ex: 1234 (= R$ 12.34)
         * interest [Number]: yearly effective interest rate of the credit note, in percentage. ex: 12.5
         * taxAmount [Long]: tax amount included in the credit note. ex: 100
         * @throws Exception error in the request
         */
        public CreditNotePreview(Map<String, Object> data) throws Exception {
            HashMap<String, Object> dataCopy = new HashMap<>(data);

            this.type = (String) dataCopy.remove("type");
            this.nominalAmount = ((Number) dataCopy.remove("nominalAmount")).longValue();
            this.scheduled = (String) dataCopy.remove("scheduled");
            this.taxId = (String) dataCopy.remove("taxId");
            this.invoices = CreditNote.parseInvoices((List<Object>) dataCopy.remove("invoices"));
            this.nominalInterest = (Number) dataCopy.remove("nominalInterest");
            this.initialDue = (String) dataCopy.remove("initialDue");
            this.count = (Integer) dataCopy.remove("count");
            this.initialAmount = (Number) dataCopy.remove("initialAmount");
            this.interval = (String) dataCopy.remove("interval");
            this.rebateAmount = ((Number) dataCopy.remove("rebateAmount")).longValue();
            this.amount = null;
            this.interest = null;
            this.taxAmount = null;

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }
    }
}
