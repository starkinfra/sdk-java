package com.starkinfra.utils;


public class EndToEndId {

    public static String create(String bankCode) throws Exception{
        return  "E" + BacenId.create(bankCode);
    }
}
