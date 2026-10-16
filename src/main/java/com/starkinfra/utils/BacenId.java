package com.starkinfra.utils;

import java.util.Locale;
import java.util.Random;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BacenId {

    /**
     * Create a random bacenId
     * <p>
     * Generates a random bacenId based on your bank code (ISPB). The date part is always
     * generated in UTC, regardless of the machine timezone.
     * <p>
     * Parameters:
     * @param bankCode [string]: your bank code (ISPB). ex: "20018183"
     * <p>
     * Return:
     * @return bacenId composed of the bank code, the current UTC datetime (yyyyMMddHHmm) and 11 random alphanumeric characters
     * @throws Exception error while generating the bacenId
     */
    public static String create(String bankCode) throws Exception{
        return create(bankCode, "yyyyMMddHHmm");
    }

    static String create(String bankCode, String datePattern) throws Exception{
        char[] randomSource = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
                '3', '4', '5', '6', '7', '8', '9'};

        StringBuilder bacenId = new StringBuilder(String.valueOf(bankCode));

        LocalDateTime today = LocalDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(datePattern, Locale.ENGLISH);
        String todayString = dateFormat.format(today);
        bacenId.append(todayString);

        Random random = new Random();
        for (int i = 0; i < 11; i++){
            bacenId.append(randomSource[random.nextInt(randomSource.length)]);
        }

        return bacenId.toString();
    }
}
