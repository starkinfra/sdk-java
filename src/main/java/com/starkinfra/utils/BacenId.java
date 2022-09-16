package com.starkinfra.utils;

import java.util.Locale;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BacenId {

    public static String create(String bankCode) throws Exception{
        char[] randomSource = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
                '3', '4', '5', '6', '7', '8', '9'};

        StringBuilder endToEndId = new StringBuilder(bankCode);

        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmm", Locale.ENGLISH);
        String todayString = dateFormat.format(today);
        endToEndId.append(todayString);

        Random random = new Random();
        for (int i = 0; i < 11; i++){
            endToEndId.append(randomSource[random.nextInt(randomSource.length)]);
        }

        return endToEndId.toString();
    }
}
