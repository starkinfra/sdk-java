package com.starkinfra.utils;

import com.starkinfra.PixRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class EndToEndId {

    public static String create(String ispb) throws Exception{
        char[] randomSource = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
                '3', '4', '5', '6', '7', '8', '9'};

        StringBuilder endToEndId = new StringBuilder("E" + ispb);

        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmm", Locale.ENGLISH);
        String todayString = dateFormat.format(today);
        endToEndId.append(todayString);

        Random random = new Random();
        for (int i = 0; i < 11; i++){
            endToEndId.append(randomSource[random.nextInt(62)]);
        }

        return endToEndId.toString();
    }
}
