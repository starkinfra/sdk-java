package com.starkinfra.utils;


public class ReturnId {

    public static String create(String bankCode) throws Exception{
        return  "D" + BacenId.create(bankCode);
    }
}
