package com.starkinfra;

import com.starkinfra.utils.Parse;
import com.starkinfra.utils.Resource;

import java.util.HashMap;
import java.util.Map;


public final class IssuingAuthorization extends Resource {
    /**
     * IssuingAuthorization object
     * <p>
     * An IssuingAuthorization presents purchase data to be analysed and answered with an approval or a declination.
     * When you initialize an IssuingAuthorization, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Attributes:
     * endToEndId               [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * amount                   [integer]: IssuingPurchase value in cents. Minimum = 0. ex: 1234 (= R$ 12.34)
     * tax                      [integer]: IOF amount taxed for international purchases. ex: 1234 (= R$ 12.34)
     * cardId                   [string]: unique id returned when IssuingCard is created. ex: "5656565656565656"
     * issuerAmount             [integer]: issuer amount. ex: 1234 (= R$ 12.34)
     * issuerCurrencyCode       [string]: issuer currency code. ex: "USD"
     * merchantAmount           [integer]: merchant amount. ex: 1234 (= R$ 12.34)
     * merchantCurrencyCode     [string]: merchant currency code. ex: "USD"
     * merchantCategoryCode     [string]: merchant category code. ex: "fastFoodRestaurants"
     * merchantCountryCode      [string]: merchant country code. ex: "USA"
     * acquirerId               [string]: acquirer ID. ex: "5656565656565656"
     * merchantId               [string]: merchant ID. ex: "5656565656565656"
     * merchantName             [string]: merchant name. ex: "Google Cloud Platform"
     * merchantFee              [integer]: merchant fee charged. ex: 200 (= R$ 2.00)
     * walletId                 [string]: virtual wallet ID. ex: "googlePay"
     * methodCode               [string]: method code. ex: "chip", "token", "server", "manual", "magstripe" or "contactless"
     * score                    [float]: internal score calculated for the authenticity of the purchase. Null in case of insufficient data. ex: 7.6
     * isPartialAllowed         [bool]: true if the the merchant allows partial purchases. ex: False
     * purpose                  [string]: purchase purpose. ex: "purchase"
     * cardTags                 [list of strings]: tags of the IssuingCard responsible for this purchase. ex: ["travel", "food"]
     * holderTags               [list of strings]: tags of the IssuingHolder responsible for this purchase. ex: ["technology", "john snow"]
     */
    static ClassData data = new ClassData(IssuingAuthorization.class, "IssuingAuthorization");
    
    public String endToEndId;
    public Number amount;
    public Integer tax;
    public String cardId;
    public Number issuerAmount;
    public String issuerCurrencyCode;
    public Number merchantAmount;
    public String merchantCurrencyCode;
    public String merchantCategoryCode;
    public String merchantCountryCode;
    public String acquirerId;
    public String merchantId;
    public String merchantName;
    public Number merchantFee;
    public String walletId;
    public String methodCode;
    public float score;
    public boolean isPartialAllowed;
    public String purpose;
    public String[] cardTags;
    public String[] holderTags;

    /**
     * IssuingAuthorization object
     * <p>
     * An IssuingAuthorization presents purchase data to be analysed and answered with an approval or a declination.
     * When you initialize an IssuingAuthorization, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Attributes:
     * @param endToEndId [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * @param amount [integer]: IssuingPurchase value in cents. Minimum = 0. ex: 1234 (= R$ 12.34)
     * @param tax [integer]: IOF amount taxed for international purchases. ex: 1234 (= R$ 12.34)
     * @param cardId [string]: unique id returned when IssuingCard is created. ex: "5656565656565656"
     * @param issuerAmount [integer]: issuer amount. ex: 1234 (= R$ 12.34)
     * @param issuerCurrencyCode [string]: issuer currency code. ex: "USD"
     * @param merchantAmount [integer]: merchant amount. ex: 1234 (= R$ 12.34)
     * @param merchantCurrencyCode [string]: merchant currency code. ex: "USD"
     * @param merchantCategoryCode [string]: merchant category code. ex: "fastFoodRestaurants"
     * @param merchantCountryCode [string]: merchant country code. ex: "USA"
     * @param acquirerId [string]: acquirer ID. ex: "5656565656565656"
     * @param merchantId [string]: merchant ID. ex: "5656565656565656"
     * @param merchantName [string]: merchant name. ex: "Google Cloud Platform"
     * @param merchantFee [integer]: merchant fee charged. ex: 200 (= R$ 2.00)
     * @param walletId [string]: virtual wallet ID. ex: "googlePay"
     * @param methodCode [string]: method code. ex: "chip", "token", "server", "manual", "magstripe" or "contactless"
     * @param score [float]: internal score calculated for the authenticity of the purchase. None in case of insufficient data. ex: 7.6
     * @param isPartialAllowed [bool]: true if the the merchant allows partial purchases. ex: False
     * @param purpose [string]: purchase purpose. ex: "purchase"
     * @param cardTags [list of strings]: tags of the IssuingCard responsible for this purchase. ex: ["travel", "food"]
     * @param holderTags [list of strings]: tags of the IssuingHolder responsible for this purchase. ex: ["technology", "john snow"]
     */
    public IssuingAuthorization(String id, String endToEndId, Number amount, Integer tax, String cardId,
                                Number issuerAmount, String issuerCurrencyCode, Number merchantAmount,
                                String merchantCurrencyCode, String merchantCategoryCode, String merchantCountryCode,
                                String acquirerId, String merchantId, String merchantName, Number merchantFee,
                                String walletId, String methodCode, float score, boolean isPartialAllowed,
                                String purpose, String[] cardTags, String[] holderTags){
        super(id);
        this.endToEndId = endToEndId;
        this.amount = amount;
        this.tax = tax;
        this.cardId = cardId;
        this.issuerAmount = issuerAmount;
        this.issuerCurrencyCode = issuerCurrencyCode;
        this.merchantAmount = merchantAmount;
        this.merchantCurrencyCode = merchantCurrencyCode;
        this.merchantCategoryCode = merchantCategoryCode;
        this.merchantCountryCode = merchantCountryCode;
        this.acquirerId = acquirerId;
        this.merchantId = merchantId;
        this.merchantName = merchantName;
        this.merchantFee = merchantFee;
        this.walletId = walletId;
        this.methodCode = methodCode;
        this.score = score;
        this.isPartialAllowed = isPartialAllowed;
        this.purpose = purpose;
        this.cardTags = cardTags;
        this.holderTags = holderTags;
    }

    /**
     * IssuingAuthorization object
     * <p>
     * An IssuingAuthorization presents purchase data to be analysed and answered with an approval or a declination.
     * When you initialize an IssuingAuthorization, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Attributes:
     * endToEndId [string]: central bank's unique transaction ID. ex: "E79457883202101262140HHX553UPqeq"
     * amount [integer]: IssuingPurchase value in cents. Minimum = 0. ex: 1234 (= R$ 12.34)
     * tax [integer]: IOF amount taxed for international purchases. ex: 1234 (= R$ 12.34)
     * cardId [string]: unique id returned when IssuingCard is created. ex: "5656565656565656"
     * issuerAmount [integer]: issuer amount. ex: 1234 (= R$ 12.34)
     * issuerCurrencyCode [string]: issuer currency code. ex: "USD"
     * merchantAmount [integer]: merchant amount. ex: 1234 (= R$ 12.34)
     * merchantCurrencyCode [string]: merchant currency code. ex: "USD"
     * merchantCategoryCode [string]: merchant category code. ex: "fastFoodRestaurants"
     * merchantCountryCode [string]: merchant country code. ex: "USA"
     * acquirerId [string]: acquirer ID. ex: "5656565656565656"
     * merchantId [string]: merchant ID. ex: "5656565656565656"
     * merchantName [string]: merchant name. ex: "Google Cloud Platform"
     * merchantFee [integer]: merchant fee charged. ex: 200 (= R$ 2.00)
     * walletId [string]: virtual wallet ID. ex: "googlePay"
     * methodCode [string]: method code. ex: "chip", "token", "server", "manual", "magstripe" or "contactless"
     * score [float]: internal score calculated for the authenticity of the purchase. None in case of insufficient data. ex: 7.6
     * isPartialAllowed [bool]: true if the the merchant allows partial purchases. ex: False
     * purpose [string]: purchase purpose. ex: "purchase"
     * cardTags [list of strings]: tags of the IssuingCard responsible for this purchase. ex: ["travel", "food"]
     * holderTags [list of strings]: tags of the IssuingHolder responsible for this purchase. ex: ["technology", "john snow"]
     * @throws Exception error in the request
     */
    public IssuingAuthorization(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.endToEndId = null;
        this.amount = null;
        this.tax = null;
        this.cardId = null;
        this.issuerAmount = null;
        this.issuerCurrencyCode = null;
        this.merchantAmount = null;
        this.merchantCurrencyCode = null;
        this.merchantCategoryCode = null;
        this.merchantCountryCode = null;
        this.acquirerId = null;
        this.merchantId = null;
        this.merchantName = null;
        this.merchantFee = null;
        this.walletId = null;
        this.methodCode = null;
        this.score = 0;
        this.isPartialAllowed = false;
        this.purpose = null;
        this.cardTags = null;
        this.holderTags = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create single IssuingAuthorization from a content string
     * <p>
     * Create a single IssuingAuthorization object received from IssuingAuthorization at the informed endpoint.
     * If the provided digital signature does not check out with the StarkInfra public key, a
     * starkinfra.exception.InvalidSignatureException will be raised.
     * <p>
     * Parameters:
     * @param content [string]: response content from request received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.user was set before function call
     * <p>
     * Return:
     * @return Parsed IssuingAuthorization object
     * @throws Exception error in the request
     */
    public static IssuingAuthorization parse(String content, String signature, User user) throws Exception{
        return Parse.parseAndVerify(data, content, signature, user);
    }

    /**
     * Create single IssuingAuthorization from a content string
     * <p>
     * Create a single IssuingAuthorization object received from IssuingAuthorization at the informed endpoint.
     * If the provided digital signature does not check out with the StarkInfra public key, a
     * starkinfra.exception.InvalidSignatureException will be raised.
     * <p>
     * Parameters:
     * @param content [string]: response content from request received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * <p>
     * Return:
     * @return Parsed IssuingAuthorization object
     * @throws Exception error in the request
     */
    public static IssuingAuthorization parse(String content, String signature) throws Exception{
        return Parse.parseAndVerify(data, content, signature, null);
    }

    /**
     * Helps you respond IssuingAuthorization requests.
     * <p>
     * Parameters:
     * @param status [string]: sub-issuer response to the authorization. ex: "accepted" or "denied"
     * @param amount [integer, default 0]: amount in cents that was authorized. ex: 1234 (= R$ 12.34)
     * @param reason [string, default ""]: denial reason. ex: "other"
     * @param tags [list of strings, default []]: tags to filter retrieved object. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us on the IssuingAuthorization request
     */
    public static String response(String status, Number amount, String reason, String[] tags){
        return "{authorization: {" +
                "status:" + status + "," +
                "amount:" + amount + "," +
                "reason:" + reason + "," +
                "tags: [" + String.join(", ", tags) + "]" +
                "}}";
    }

    /**
     * Helps you respond IssuingAuthorization requests.
     * <p>
     * Parameters:
     * @param status [string]: sub-issuer response to the authorization. ex: "accepted" or "denied"
     * @param amount [integer, default 0]: amount in cents that was authorized. ex: 1234 (= R$ 12.34)
     * @param reason [string, default ""]: denial reason. ex: "other"
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us on the IssuingAuthorization request
     */
    public static String response(String status, Number amount, String reason) {
        return IssuingAuthorization.response(status, amount, reason, new String[]{});
    }

    /**
     * Helps you respond IssuingAuthorization requests.
     * <p>
     * Parameters:
     * @param status [string]: sub-issuer response to the authorization. ex: "accepted" or "denied"
     * @param amount [integer, default 0]: amount in cents that was authorized. ex: 1234 (= R$ 12.34)
     * @param tags [list of strings, default []]: tags to filter retrieved object. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us on the IssuingAuthorization request
     */
    public static String response(String status, Number amount, String[] tags) {
        return IssuingAuthorization.response(status, amount, "", tags);
    }

    /**
     * Helps you respond IssuingAuthorization requests.
     * <p>
     * Parameters:
     * @param status [string]: sub-issuer response to the authorization. ex: "accepted" or "denied"
     * @param amount [integer, default 0]: amount in cents that was authorized. ex: 1234 (= R$ 12.34)
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us on the IssuingAuthorization request
     */
    public static String response(String status, Number amount){
        return IssuingAuthorization.response(status, amount, "", new String[]{});
    }

    /**
     * Helps you respond IssuingAuthorization requests.
     * <p>
     * Parameters:
     * @param status [string]: sub-issuer response to the authorization. ex: "accepted" or "denied"
     * @param reason [string, default ""]: denial reason. ex: "other"
     * @param tags [list of strings, default []]: tags to filter retrieved object. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us on the IssuingAuthorization request
     */
    public static String response(String status, String reason, String[] tags) {
        return IssuingAuthorization.response(status, 0, reason, tags);
    }

    /**
     * Helps you respond IssuingAuthorization requests.
     * <p>
     * Parameters:
     * @param status [string]: sub-issuer response to the authorization. ex: "accepted" or "denied"
     * @param reason [string, default ""]: denial reason. ex: "other"
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us on the IssuingAuthorization request
     */
    public static String response(String status, String reason) {
        return IssuingAuthorization.response(status, 0, reason, new String[]{});
    }

    /**
     * Helps you respond IssuingAuthorization requests.
     * <p>
     * Parameters:
     * @param status [string]: sub-issuer response to the authorization. ex: "accepted" or "denied"
     * @param tags [list of strings, default []]: tags to filter retrieved object. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us on the IssuingAuthorization request
     */
    public static String response(String status, String[] tags){
        return IssuingAuthorization.response(status, 0, "", tags);
    }

    /**
     * Helps you respond IssuingAuthorization requests.
     * <p>
     * Parameters:
     * @param status [string]: sub-issuer response to the authorization. ex: "accepted" or "denied"
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us on the IssuingAuthorization request
     */
    public static String response(String status){
        return IssuingAuthorization.response(status, 0, "", new String[]{});
    }
}
