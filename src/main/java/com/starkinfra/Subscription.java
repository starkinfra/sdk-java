package com.starkinfra;

import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.HashMap;


public final class Subscription extends SubResource {
    /**
     * Subscription object
     * <p>
     * Subscription is a recurring payment that can be used to charge a user periodically.
     * <p>
     * Parameters:
     * amount [Long]: amount to be charged in cents. ex: 1000 = R$ 10.00
     * amountMinLimit [Long]: minimum amount limit for the subscription. ex: 500 = R$ 5.00
     * bacenId [String]: BACEN (Brazilian Central Bank) identifier.
     * created [String]: creation datetime for the subscription.
     * description [String]: description of the subscription.
     * installmentEnd [String]: end datetime for the installments.
     * installmentStart [String]: start datetime for the installments.
     * interval [String]: interval for the recurring charge. ex: "monthly"
     * pullRetryLimit [Long]: maximum number of retries for pulling the payment.
     * receiverBankCode [String]: bank code of the receiver.
     * receiverName [String]: name of the receiver.
     * receiverTaxId [String]: tax ID of the receiver.
     * referenceCode [String]: reference code for the subscription.
     * senderFinalName [String]: final sender name.
     * senderFinalTaxId [String]: final sender tax ID.
     * status [String]: current status of the subscription.
     * type [String]: type of the subscription.
     * updated [String]: last update datetime for the subscription.
     */
    static SubResource.ClassData data = new SubResource.ClassData(Subscription.class, "Subscription");

    public Long amount;
    public Long amountMinLimit;
    public String bacenId;
    public String created;
    public String description;
    public String installmentEnd;
    public String installmentStart;
    public String interval;
    public Long pullRetryLimit;
    public String receiverBankCode;
    public String receiverName;
    public String receiverTaxId;
    public String referenceCode;
    public String senderFinalName;
    public String senderFinalTaxId;
    public String status;
    public String type;
    public String updated;

    /**
     * Subscription object
     * <p>
     * @param amount [Long]: amount to be charged in cents. ex: 1000 = R$ 10.00
     * @param amountMinLimit [Long]: minimum amount limit for the subscription. ex: 500 = R$ 5.00
     * @param bacenId [String]: BACEN (Brazilian Central Bank) identifier.
     * @param created [String]: creation datetime for the subscription.
     * @param description [String]: description of the subscription.
     * @param installmentEnd [String]: end datetime for the installments.
     * @param installmentStart [String]: start datetime for the installments.
     * @param interval [String]: interval for the recurring charge. ex: "monthly"
     * @param pullRetryLimit [Long]: maximum number of retries for pulling the payment.
     * @param receiverBankCode [String]: bank code of the receiver.
     * @param receiverName [String]: name of the receiver.
     * @param receiverTaxId [String]: tax ID of the receiver.
     * @param referenceCode [String]: reference code for the subscription.
     * @param senderFinalName [String]: final sender name.
     * @param senderFinalTaxId [String]: final sender tax ID.
     * @param status [String]: current status of the subscription.
     * @param type [String]: type of the subscription.
     * @param updated [String]: last update datetime for the subscription.
     */
    public Subscription(Long amount, Long amountMinLimit, String bacenId, String created, String description,
                        String installmentEnd, String installmentStart, String interval, Long pullRetryLimit,
                        String receiverBankCode, String receiverName, String receiverTaxId, String referenceCode,
                        String senderFinalName, String senderFinalTaxId, String status, String type, String updated
    ) {
        this.amount = amount;
        this.amountMinLimit = amountMinLimit;
        this.bacenId = bacenId;
        this.created = created;
        this.description = description;
        this.installmentEnd = installmentEnd;
        this.installmentStart = installmentStart;
        this.interval = interval;
        this.pullRetryLimit = pullRetryLimit;
        this.receiverBankCode = receiverBankCode;
        this.receiverName = receiverName;
        this.receiverTaxId = receiverTaxId;
        this.referenceCode = referenceCode;
        this.senderFinalName = senderFinalName;
        this.senderFinalTaxId = senderFinalTaxId;
        this.status = status;
        this.type = type;
        this.updated = updated;
    }

    /**
     * Subscription object
     * <p>
     * @param data map of properties for the creation of the Subscription
     * @throws Exception error in the request
     */
    public Subscription(Map<String, Object> data) throws Exception {
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.amount = (Long) dataCopy.remove("amount");
        this.amountMinLimit = (Long) dataCopy.remove("amountMinLimit");
        this.bacenId = (String) dataCopy.remove("bacenId");
        this.created = (String) dataCopy.remove("created");
        this.description = (String) dataCopy.remove("description");
        this.installmentEnd = (String) dataCopy.remove("installmentEnd");
        this.installmentStart = (String) dataCopy.remove("installmentStart");
        this.interval = (String) dataCopy.remove("interval");
        this.pullRetryLimit = (Long) dataCopy.remove("pullRetryLimit");
        this.receiverBankCode = (String) dataCopy.remove("receiverBankCode");
        this.receiverName = (String) dataCopy.remove("receiverName");
        this.receiverTaxId = (String) dataCopy.remove("receiverTaxId");
        this.referenceCode = (String) dataCopy.remove("referenceCode");
        this.senderFinalName = (String) dataCopy.remove("senderFinalName");
        this.senderFinalTaxId = (String) dataCopy.remove("senderFinalTaxId");
        this.status = (String) dataCopy.remove("status");
        this.type = (String) dataCopy.remove("type");
        this.updated = (String) dataCopy.remove("updated");

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }
}