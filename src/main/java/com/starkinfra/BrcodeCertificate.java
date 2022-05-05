package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.SubResource;
import java.util.HashMap;


public final class BrcodeCertificate extends SubResource {
    /**
     * BrcodeCertificate object
     * <p>
     * The BrcodeCertificate object displays certificate information of registered
     * SPI participants able to issue dynamic QR Codes.
     * They are used in the validation of the URLs contained in the dynamic QR Codes.
     * <p>
     * Attributes (return-only):
     * content [string]: certificate of the SPI participant in PEM format.
     * domain  [string]: current active domain (URL) of the SPI participant.
     *
     */
    static ClassData data = new ClassData(BrcodeCertificate.class, "BrcodeCertificate");
    
    public String content;
    public String domain;
    /**
     * BrcodeCertificate object
     * <p>
     * The BrcodeCertificate object displays the certificate information of registered
     * SPI participants able to issue dynamic QR Codes.
     * They are used in the validation of the URLs contained in the dynamic QR Codes.
     * <p>
     * Attributes (return-only):
     * @param content [string]: certificate of the SPI participant in PEM format.
     * @param domain  [string]: current active domain (URL) of the SPI participant.
     */
    public BrcodeCertificate(String content, String domain) {
        this.content = content;
        this.domain = domain;
    }

    /**
     * Retrieve BrcodeCertificates
     * <p>
     * Receive a generator of BrcodeCertificate objects.
     * <p>
     * Return:
     * @return generator of BrcodeCertificate objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BrcodeCertificate> query() throws Exception {
        return BrcodeCertificate.query(null);
    }

    /**
     * Retrieve BrcodeCertificates
     * <p>
     * Receive a generator of BrcodeCertificate objects.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return BrcodeCertificate object with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BrcodeCertificate> query(User user) throws Exception {
        return Rest.getStream(data, new HashMap<>(), user);
    }
}
