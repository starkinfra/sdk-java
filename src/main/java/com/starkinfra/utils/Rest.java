package com.starkinfra.utils;

import com.google.gson.Gson;
import com.starkcore.user.User;
import com.starkcore.utils.Generator;
import com.starkcore.utils.Page;
import com.starkcore.utils.Resource;
import com.starkcore.utils.SubResource;
import com.starkinfra.CreditPreview;
import com.starkinfra.Settings;

import java.io.InputStream;
import java.util.List;
import java.util.Map;


public final class Rest {

    public static <T extends SubResource> T getId(Resource.ClassData resource, String id, User user) throws Exception {
        return Relay.getId(resource, id, user);
    }

    public static <T extends SubResource> T getId(Resource.ClassData resource, String id, Map<String, Object> query, User user) throws Exception {
        return Relay.getId(resource, id, user, query);
    }

    public static <T extends SubResource> List<T> post(Resource.ClassData resource, List<T> entities, User user) throws Exception {
        return Relay.post(resource, entities, user);
    }

    public static <T extends SubResource> List<T> post(Resource.ClassData resource, List<T> entities, Map<String, Object> data, User user) throws Exception {
        return Relay.post(resource, entities, data, user);
    }

    public static <T extends SubResource> T patch(Resource.ClassData resource, String id, Map<String, Object> data, User user) throws Exception {
        return Relay.patch(resource, id, data, user);
    }

    public static Page getPage(Resource.ClassData resource, Map<String, Object> params, User user) throws Exception {
        return Relay.getPage(resource, params, user);
    }

    public static <T extends SubResource> Generator<T> getStream(Resource.ClassData resource, Map<String, Object> params, User user) {
        return Relay.getStream(resource, params, user);
    }

    public static <T extends SubResource> Generator<T> getSimpleList(Resource.ClassData resource, Map<String, Object> params, User user) {
        return Relay.getSimpleList(resource, params, user);
    }

    public static InputStream getContent(Resource.ClassData resource, String id, String subResourceName ,User user, Map<String, Object> options) throws Exception {
        return Relay.getContent(resource, id, subResourceName, user, options);
    }

    public static <T extends SubResource> T getSubResource(Resource.ClassData resource, String id, SubResource.ClassData subResource, User user, Map<String, Object> options) throws Exception {
        return Relay.getSubResource(resource, id, subResource, user, options);
    }

    public static <T extends SubResource> List<T> getSubResources(Resource.ClassData resource, String id, SubResource.ClassData subResource, User user, Map<String, Object> options) throws Exception {
        return Relay.getSubResources(resource, id, subResource, user, options);
    }

    public static <T extends SubResource> T delete(Resource.ClassData resource, String id, User user) throws Exception {
        return Relay.delete(resource, id, user);
    }

    public static <T extends SubResource> T postSingle(Resource.ClassData resource, SubResource entity, User user) throws Exception {
        return Relay.postSingle(resource, entity, user);
    }
}
