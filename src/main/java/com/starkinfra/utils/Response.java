package com.starkinfra.utils;

import com.google.gson.JsonObject;

import com.starkinfra.User;
import com.starkinfra.error.InputErrors;
import com.starkinfra.error.UnknownError;
import com.starkbank.ellipticcurve.Ecdsa;
import com.starkinfra.error.InternalServerError;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import java.util.Map;
import java.io.Reader;
import java.util.HashMap;
import java.io.InputStream;
import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static java.lang.System.currentTimeMillis;
import static com.starkinfra.Settings.userAgentOverride;


public final class Response extends com.starkcore.utils.Response {

    public Response(int status, InputStream stream) {
        super(status, stream);
    }
}
