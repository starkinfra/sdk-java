package com.starkinfra.utils;

import com.starkinfra.User;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;


final class HttpClient {
    private static ClientService productionInstance;
    private static ClientService sandboxInstance;
    private static ClientService developmentInstance;
    private static final String version = "v2/";

    private HttpClient() {}

    public static synchronized ClientService getProjectInstance(User user) throws Exception {
        switch (user.environment)
        {
            case "production":
                if(productionInstance == null)
                    productionInstance = makeInstance("https://api.starkinfra.com/");
                return productionInstance;
            case "sandbox":
                if(sandboxInstance == null)
                    sandboxInstance = makeInstance("https://sandbox.api.starkinfra.com/");
                return sandboxInstance;
            case "development":
                if(developmentInstance == null)
                    developmentInstance = makeInstance("https://development.api.starkinfra.com/");
                return developmentInstance;
            default:
                throw new Exception("Unexpected environment: " + user.environment);
        }
    }

    private static ClientService makeInstance(String baseUrl)
    {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl + version)
                .client(client).build();
        return retrofit.create(ClientService.class);
    }
}
