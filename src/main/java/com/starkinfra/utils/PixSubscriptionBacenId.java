package com.starkinfra.utils;


public class PixSubscriptionBacenId {

    public static String create(String bankCode, String prefix) throws Exception{
        return prefix + BacenId.create(bankCode, "yyyyMMdd");
    }
}
