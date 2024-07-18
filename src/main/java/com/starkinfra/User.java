package com.starkinfra;

import com.starkinfra.utils.Check;
import com.starkinfra.utils.Resource;
import com.starkbank.ellipticcurve.PrivateKey;


public abstract class User extends com.starkcore.user.User {
    public User(String environment, String id, String privateKey) throws Exception {
        super(environment, id, privateKey);
    }
}
