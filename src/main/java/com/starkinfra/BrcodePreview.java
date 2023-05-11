package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class BrcodePreview extends Resource {
    /**
     * BrcodePreview object
     * <p>
     * The BrcodePreview object is used to preview information from a BR Code before paying it.
     * <p>
     * When you initialize a BrcodePreview, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * id [string]: BR Code string for the Pix payment. This is also de information directly encoded in a QR Code. ex: "34191.09008 63571.277308 71444.640008 5 81960000000062", "00020126580014br.gov.bcb.pix0136a629532e-7693-4846-852d-1bbff817b5a8520400005303986540510.005802BR5908T'Challa6009Sao Paulo62090505123456304B14A"
     * payerId [string, default null]: Tax id (CPF/CNPJ) of the individual or business requesting the PixKey information. This id is used by the Central Bank to limit request rates. ex: "20.018.183/0001-80"
     * endToEndId [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * accountNumber [string]: Payment receiver account number. ex: "1234567"
     * accountType [string]: Payment receiver account type. ex: "checking"
     * amount [Long]: Value in cents that this payment is expecting to receive. If 0, any value is accepted. ex: 123 (= R$1,23)
     * amountType [string]: amount type of the BR Ccode. If the amount type is "custom" the Brcode's amount can be changed by the sender at the moment of payment. Options: "fixed" or "custom"
     * bankCode [string]: Payment receiver bank code. ex: "20018183"
     * branchCode [string]: Payment receiver branch code. ex: "0001"
     * cashAmount [Long]: Amount to be withdrawal from the cashier in cents. ex: 1000 (= R$ 10.00)
     * cashierBankCode [string]: Cashier's bank code. ex: "00000000"
     * cashierType [string]: Cashier's type. Options: "merchant", "other" or "participant"
     * discountAmount [Long]: Discount value calculated over nominalAmount. ex: 3000
     * fineAmount [Long]: Fine value calculated over nominalAmount. ex: 20000
     * interestAmount [Long]: Interest value calculated over nominalAmount. ex: 10000
     * name [string]: Payment receiver name. ex: "Tony Stark"
     * nominalAmount [Long]: BR Code emission amount, without fines, fees and discounts. ex: 1234 (= R$ 12.34)
     * keyId [string]: Receiver's PixKey id. ex: "+5511989898989"
     * reconciliationId [string]: Reconciliation ID linked to this payment. If the BR Code is dynamic, the reconciliationId will have from 26 to 35 alphanumeric digits, ex: "cd65c78aeb6543eaaa0170f68bd741ee". If the brcode is static, the reconciliation_id will have up to 25 alphanumeric digits "ah27s53agj6493hjds6836v49"
     * reductionAmount [Long]: Reduction value to discount from nominalAmount. ex: 1000
     * scheduled [string]: datetime of payment execution. ex: "2020-03-10 10:30:00.000000+00:00"
     * status [string]: Payment status. ex: "active", "paid", "canceled" or "unknown"
     * taxId [string]: Payment receiver tax ID. ex: "012.345.678-90"
     *
     */
    static ClassData data = new ClassData(BrcodePreview.class, "BrcodePreview");

    public String payerId;
    public String endToEndId;
    public String accountNumber;
    public String accountType;
    public Long amount;
    public String amountType;
    public String bankCode;
    public String branchCode;
    public Long cashAmount;
    public String cashierBankCode;
    public String cashierType;
    public Long discountAmount;
    public Long fineAmount;
    public Long interestAmount;
    public String name;
    public Long nominalAmount;
    public String keyId;
    public String reconciliationId;
    public Long reductionAmount;
    public String scheduled;
    public String status;
    public String taxId;

    /**
     * BrcodePreview object
     * <p>
     * The BrcodePreview object is used to preview information from a BR Code before paying it.
     * <p>
     * When you initialize a BrcodePreview, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * @param id [string]: BR Code string for the Pix payment. This is also de information directly encoded in a QR Code. ex: "34191.09008 63571.277308 71444.640008 5 81960000000062", "00020126580014br.gov.bcb.pix0136a629532e-7693-4846-852d-1bbff817b5a8520400005303986540510.005802BR5908T'Challa6009Sao Paulo62090505123456304B14A"
     * @param payerId [string, default null]: Tax id (CPF/CNPJ) of the individual or business requesting the PixKey information. This id is used by the Central Bank to limit request rates. ex: "20.018.183/0001-80"
     * @param endToEndId [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * @param accountNumber [string]: Payment receiver account number. ex: "1234567"
     * @param accountType [string]: Payment receiver account type. ex: "checking"
     * @param amount [Long]: Value in cents that this payment is expecting to receive. If 0, any value is accepted. ex: 123 (= R$1,23)
     * @param amountType [string]: amount type of the BR Code. If the amount type is "custom" the Brcode's amount can be changed by the sender at the moment of payment. Options: "fixed" or "custom"
     * @param bankCode [string]: Payment receiver bank code. ex: "20018183"
     * @param branchCode [string]: Payment receiver branch code. ex: "0001"
     * @param cashAmount [Long]: Amount to be withdrawal from the cashier in cents. ex: 1000 (= R$ 10.00)
     * @param cashierBankCode [string]: Cashier's bank code. ex: "00000000"
     * @param cashierType [string]: Cashier's type. ex: [merchant, other, participant]
     * @param discountAmount [Long]: Discount value calculated over nominalAmount. ex: 3000
     * @param fineAmount [Long]: Fine value calculated over nominalAmount. ex: 20000
     * @param interestAmount [Long]: Interest value calculated over nominalAmount. ex: 10000
     * @param name [string]: Payment receiver name. ex: "Tony Stark"
     * @param nominalAmount [Long]: BR Code emission amount, without fines, fees and discounts. ex: 1234 (= R$ 12.34)
     * @param keyId [string]: Receiver's PixKey id. ex: "+5511989898989"
     * @param reconciliationId [string]: Reconciliation ID linked to this payment. If the BR Code is dynamic, the reconciliationId will have from 26 to 35 alphanumeric digits, ex: "cd65c78aeb6543eaaa0170f68bd741ee". If the brcode is static, the reconciliationId will have up to 25 alphanumeric digits "ah27s53agj6493hjds6836v49"
     * @param reductionAmount [Long]: Reduction value to discount from nominal_amount. ex: 1000
     * @param scheduled [string]: datetime of payment execution. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param status [string]: Payment status. ex: "active", "paid", "canceled" or "unknown"
     * @param taxId [string]: Payment receiver tax ID. ex: "012.345.678-90"
     */
    public BrcodePreview(String payerId, String endToEndId, String status, String name, String taxId, String bankCode,
                         String branchCode, Long cashAmount, String cashierBankCode, String cashierType, String accountNumber,
                         String accountType, String scheduled, Long amount, String amountType, Long nominalAmount,
                         String keyId, Long interestAmount, Long fineAmount, Long reductionAmount, Long discountAmount,
                         String reconciliationId, String id
    ) {
        super(id);
        this.payerId = payerId;
        this.endToEndId = endToEndId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.amount = amount;
        this.amountType = amountType;
        this.bankCode = bankCode;
        this.branchCode = branchCode;
        this.cashAmount = cashAmount;
        this.cashierBankCode = cashierBankCode;
        this.cashierType = cashierType;
        this.discountAmount = discountAmount;
        this.fineAmount = fineAmount;
        this.interestAmount = interestAmount;
        this.name = name;
        this.nominalAmount = nominalAmount;
        this.keyId = keyId;
        this.reconciliationId = reconciliationId;
        this.reductionAmount = reductionAmount;
        this.scheduled = scheduled;
        this.status = status;
        this.taxId = taxId;
    }

    /**
     * BrcodePreview object
     * <p>
     * The BrcodePreview object is used to preview information from a BR Code before paying it.
     * <p>
     * When you initialize a BrcodePreview, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the BrcodePreview
     * id [string]: BR Code string for the Pix payment. This is also de information directly encoded in a QR Code. ex: "34191.09008 63571.277308 71444.640008 5 81960000000062", "00020126580014br.gov.bcb.pix0136a629532e-7693-4846-852d-1bbff817b5a8520400005303986540510.005802BR5908T'Challa6009Sao Paulo62090505123456304B14A"
     * payerId [string]: Tax id (CPF/CNPJ) of the individual or business requesting the PixKey information. This id is used by the Central Bank to limit request rates. ex: "20.018.183/0001-80"
     * <p>
     * Parameters (optional):
     * endToEndId [string, default null]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * <p>
     * Attributes (return-only):
     * accountNumber [string]: Payment receiver account number. ex: "1234567"
     * accountType [string]: Payment receiver account type. ex: "checking"
     * amount [Long]: Value in cents that this payment is expecting to receive. If 0, any value is accepted. ex: 123 (= R$1,23)
     * amountType [string]: amount type of the BR Code. If the amount type is "custom" the Brcode's amount can be changed by the sender at the moment of payment. Options: "fixed" or "custom"
     * bankCode [string]: Payment receiver bank code. ex: "20018183"
     * branchCode [string]: Payment receiver branch code. ex: "0001"
     * cashAmount [Long]: Amount to be withdrawal from the cashier in cents. ex: 1000 (= R$ 10.00)
     * cashierBankCode [string]: Cashier's bank code. ex: "00000000"
     * cashierType [string]: Cashier's type. Options: "merchant", "other" or "participant"
     * discountAmount [Long]: Discount value calculated over nominalAmount. ex: 3000
     * fineAmount [Long]: Fine value calculated over nominalAmount. ex: 20000
     * interestAmount [Long]: Interest value calculated over nominalAmount. ex: 10000
     * name [string]: Payment receiver name. ex: "Tony Stark"
     * nominalAmount [Long]: Brcode emission amount, without fines, fees and discounts. ex: 1234 (= R$ 12.34)
     * keyId [string]: Receiver's PixKey id. ex: "+5511989898989"
     * reconciliationId [string]: Reconciliation ID linked to this payment. If the brcode is dynamic, the reconciliationId will have from 26 to 35 alphanumeric digits, ex: "cd65c78aeb6543eaaa0170f68bd741ee". If the brcode is static, the reconciliation_id will have up to 25 alphanumeric digits "ah27s53agj6493hjds6836v49"
     * reductionAmount [Long]: Reduction value to discount from nominal_amount. ex: 1000
     * scheduled [string]: datetime of payment execution. ex: "2020-03-10 10:30:00.000000+00:00"
     * status [string]: Payment status. ex: "active", "paid", "canceled" or "unknown"
     * taxId [string]: Payment receiver tax ID. ex: "012.345.678-90"
     * @throws Exception error in the request
     */
    public BrcodePreview(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.id = (String) dataCopy.remove("id");
        this.payerId = (String) dataCopy.remove("payerId");
        this.endToEndId = (String) dataCopy.remove("endToEndId");
        this.accountNumber = null;
        this.accountType = null;
        this.amount = null;
        this.amountType = null;
        this.bankCode = null;
        this.branchCode = null;
        this.cashAmount = null;
        this.cashierBankCode = null;
        this.cashierType = null;
        this.discountAmount = null;
        this.fineAmount = null;
        this.interestAmount = null;
        this.name = null;
        this.nominalAmount = null;
        this.keyId = null;
        this.reconciliationId = null;
        this.reductionAmount = null;
        this.scheduled = null;
        this.status = null;
        this.taxId = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create BrcodePreviews
     * <p>
     * Send a list of BrcodePreview objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param previews [list of BrcodePreview objects]: List of BrcodePreview objects to preview. ex: [starkinfra.BrcodePreview("00020126580014br.gov.bcb.pix0136a629532e-7693-4846-852d-1bbff817b5a8520400005303986540510.005802BR5908T'Challa6009Sao Paulo62090505123456304B14A")]
     * <p>
     * Return:
     * @return list of BrcodePreview objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<BrcodePreview> create(List<?> previews) throws Exception {
        return BrcodePreview.create(previews, null);
    }

    /**
     * Create BrcodePreviews
     * <p>
     * Send a list of BrcodePreview objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param previews [list of BrcodePreview objects]: List of BrcodePreview objects to preview. ex: [starkinfra.BrcodePreview("00020126580014br.gov.bcb.pix0136a629532e-7693-4846-852d-1bbff817b5a8520400005303986540510.005802BR5908T'Challa6009Sao Paulo62090505123456304B14A")]
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return list of BrcodePreview objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<BrcodePreview> create(List<?> previews, User user) throws Exception {
        List<BrcodePreview> previewList = new ArrayList<>();
        for (Object preview : previews){
            if (preview instanceof Map){
                previewList.add(new BrcodePreview((Map<String, Object>) preview));
                continue;
            }
            if (preview instanceof BrcodePreview){
                previewList.add((BrcodePreview) preview);
                continue;
            }
            throw new Exception("Unknown type \"" + preview.getClass() + "\", use BrcodePreview or HashMap");
        }
        return Rest.post(data, previewList, user);
    }
}
