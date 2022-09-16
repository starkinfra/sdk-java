package com.starkinfra;

import com.starkinfra.utils.Check;
import com.starkinfra.utils.Resource;
import com.starkbank.ellipticcurve.PrivateKey;


public abstract class User extends Resource{
    public final String pem;
    public final String environment;

    public User(String environment, String id, String privateKey) throws Exception {
        super(id);
        this.environment = Check.environment(environment);
        this.pem = Check.key(privateKey);
    }

    public abstract String accessId();

    public PrivateKey privateKey(){
        return PrivateKey.fromPem(this.pem);
    }
}
