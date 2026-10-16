package com.starkinfra.utils;


public class PixSubscriptionBacenId {

    /**
     * Create a random Pix subscription bacenId
     * <p>
     * Generates a random Pix subscription bacenId based on your bank code (ISPB), used as the
     * bacenId of a PixPullSubscription. The date part is always generated in UTC, regardless of
     * the machine timezone.
     * <p>
     * Parameters:
     * @param bankCode [string]: your bank code (ISPB). ex: "20018183"
     * @param prefix [string]: subscription prefix. ex: "RR"
     * <p>
     * Return:
     * @return 29-character bacenId composed of the prefix, the bank code, the current UTC date (yyyyMMdd) and 11 random alphanumeric characters. ex: "RR2001818320261016aB3xK9mQ2wZ"
     * @throws Exception error while generating the bacenId
     */
    public static String create(String bankCode, String prefix) throws Exception{
        return prefix + BacenId.create(bankCode, "yyyyMMdd");
    }
}
