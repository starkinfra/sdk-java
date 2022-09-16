package com.starkinfra.utils;

import retrofit2.Call;
import retrofit2.http.*;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import java.util.Map;

interface ClientService {
    @GET
    Call<ResponseBody> get(@retrofit2.http.Url String path, @HeaderMap Map<String, String> headers);

    @POST
    Call<ResponseBody> post(@retrofit2.http.Url String path, @Body RequestBody body, @HeaderMap Map<String, String> headers);

    @PUT
    Call<ResponseBody> put(@retrofit2.http.Url String path, @Body RequestBody body, @HeaderMap Map<String, String> headers);

    @PATCH
    Call<ResponseBody> patch(@retrofit2.http.Url String path, @Body RequestBody body, @HeaderMap Map<String, String> headers);

    @DELETE
    Call<ResponseBody> delete(@retrofit2.http.Url String path, @HeaderMap Map<String, String> headers);
}