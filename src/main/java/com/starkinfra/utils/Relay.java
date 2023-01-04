package com.starkinfra.utils;

import com.google.gson.Gson;
import com.starkinfra.CreditNote;
import com.starkinfra.CreditPreview;
import com.starkinfra.Event;
import com.starkinfra.Settings;
import com.starkcore.user.User;
import com.starkcore.utils.Parse;
import com.starkcore.utils.Rest;
import com.starkcore.utils.*;

import java.io.InputStream;
import java.util.List;
import java.util.Map;


final class Relay {

    final static String host = "infra";
    final static String apiVersion = "v2";

    public static <T extends SubResource> T getId(Resource.ClassData resource, String id, User user) throws Exception {
        if(user == null) user = Settings.user;
        return Rest.getId(
            Settings.version, 
            host, 
            apiVersion, 
            user, 
            resource, 
            id, 
            Settings.language, 
            Settings.timeout
        );
    }

    public static <T extends SubResource> T getId(Resource.ClassData resource, String id, User user, Map<String, Object> query) throws Exception {
        if(user == null) user = Settings.user;
        return Rest.getId(
            Settings.version,
            host,
            apiVersion,
            user,
            resource,
            id,
            Settings.language,
            Settings.timeout,
            query
        );
    }

    public static <T extends SubResource> List<T> post(Resource.ClassData resource, List<T> entities, Map<String, Object> data, User user) throws Exception {
        if(user == null) user = Settings.user;
        Gson gson = GsonEvent.getInstance();
        return Rest.post(
            Settings.version, 
            host, 
            apiVersion, 
            user, 
            resource, 
            entities,
            data,
            Settings.language, 
            Settings.timeout
        );
    }

    public static <T extends SubResource> List<T> post(Resource.ClassData resource, List<T> entities, User user) throws Exception {
        if(user == null) user = Settings.user;
        Gson gson = GsonEvent.getInstance();
        return Rest.post(
                Settings.version,
                host,
                apiVersion,
                user,
                resource,
                entities,
                Settings.language,
                Settings.timeout
        );
    }

    public static <T extends SubResource> T patch(Resource.ClassData resource, String id, Map<String, Object> data, User user) throws Exception {
        if(user == null) user = Settings.user;
        return Rest.patch(
            Settings.version, 
            host, 
            apiVersion, 
            user, 
            resource, 
            id, 
            Settings.language, 
            Settings.timeout,
            data
        );
    }

    public static Page getPage(Resource.ClassData resource, Map<String, Object> params, User user) throws Exception {
        if(user == null) user = Settings.user;
        return Rest.getPage(
            Settings.version,
            host,
            apiVersion, 
            user, 
            resource,
            Settings.language, 
            Settings.timeout,
            params
        );
    }

    public static <T extends SubResource> Generator<T> getStream(Resource.ClassData resource, Map<String, Object> params, User user) {
        if(user == null) user = Settings.user;
        return Rest.getStream(
            Settings.version,
            host,
            apiVersion, 
            user, 
            resource,
            Settings.language, 
            Settings.timeout,
            params
        );
    }

    public static <T extends SubResource> Generator<T> getSimpleList(Resource.ClassData resource, Map<String, Object> params, User user) {
        if(user == null) user = Settings.user;
        return Rest.getSimpleList(
            Settings.version,
            host,
            apiVersion, 
            user, 
            resource,
            Settings.language, 
            Settings.timeout,
            params
        );
    }

    public static InputStream getContent(Resource.ClassData resource, String id, String subResourceName ,User user, Map<String, Object> options) throws Exception {
        if(user == null) user = Settings.user;
        Gson gson = GsonEvent.getInstance();
        return Rest.getContent(
            Settings.version,
            host,
            apiVersion, 
            user, 
            resource,
            subResourceName,
            id,
            Settings.language, 
            Settings.timeout,
            options
        );
    }

    public static <T extends SubResource> T getSubResource(Resource.ClassData resource, String id, SubResource.ClassData subResource, User user, Map<String, Object> options) throws Exception {
        if(user == null) user = Settings.user;
        return Rest.getSubResource(
            Settings.version,
            host,
            apiVersion, 
            user, 
            resource,
            id,
            subResource,
            Settings.language, 
            Settings.timeout,
            options
        );
    }

    public static <T extends SubResource> List<T> getSubResources(Resource.ClassData resource, String id, SubResource.ClassData subResource, User user, Map<String, Object> options) throws Exception {
        if(user == null) user = Settings.user;
        return Rest.getSubResources(
            Settings.version,
            host,
            apiVersion, 
            user, 
            resource,
            id,
            subResource,
            Settings.language, 
            Settings.timeout,
            options
        );
    }

    public static <T extends SubResource> T delete(Resource.ClassData resource, String id, User user) throws Exception {
        if(user == null) user = Settings.user;
        return Rest.delete(
            Settings.version,
            host,
            apiVersion, 
            user, 
            resource,
            id,
            Settings.language, 
            Settings.timeout
        );
    }

    public static <T extends SubResource> T postSingle(Resource.ClassData resource, SubResource entity, User user) throws Exception {
        if(user == null) user = Settings.user;
        return Rest.postSingle(
            Settings.version, 
            host, 
            apiVersion, 
            user, 
            resource, 
            entity, 
            Settings.language, 
            Settings.timeout
        );
    }

    public static <T extends SubResource> T parseAndVerify(String content, String signature, Resource.ClassData resource, User user) throws Exception {
        if(user == null) user = Settings.user;
        return Parse.parseAndVerify(
            content,
            signature,
            Settings.version, 
            apiVersion, 
            host, 
            resource, 
            user, 
            Settings.language, 
            Settings.timeout
        );
    }

    public static String verify(String content, String signature, User user) throws Exception {
        if(user == null) user = Settings.user;
        return Parse.verify(
            content,
            signature,
            Settings.version,
            apiVersion,
            host,
            user,
            Settings.language,
            Settings.timeout
        );
    }

    static {
        GsonEvent.registerTypeAdapter(Event.class, new Event.Deserializer());
        GsonEvent.registerTypeAdapter(CreditNote.class, new CreditNote.Deserializer());
        GsonEvent.registerTypeAdapter(CreditPreview.class, new CreditPreview.Deserializer());
    }

}
