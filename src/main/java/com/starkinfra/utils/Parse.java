package com.starkinfra.utils;

import com.starkcore.user.User;
import com.starkcore.utils.Resource;

public class Parse {
    public static <T extends Resource> T parseAndVerify(String content, String signature, Resource.ClassData resource, User user) throws Exception {
        return Relay.parseAndVerify(content, signature, resource, user);
    }

    public static String verify(String content, String signature, User user) throws Exception {
        return Relay.verify(content, signature, user);
    }
}
