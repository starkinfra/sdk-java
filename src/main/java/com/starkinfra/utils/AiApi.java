package com.starkinfra.utils;

import com.starkinfra.User;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;


// The AI routes answer under keys starkcore cannot derive from the resource name (it reads the last word of the
// name, and "speeches" is not "speechs"), and some creates answer with a list, so the AI resources read the
// responses themselves through these functions.
public final class AiApi {

    private AiApi() {
    }

    public static Map<String, Object> dropNulls(Map<String, Object> payload) {
        Map<String, Object> kept = new LinkedHashMap<>();
        if (payload == null) {
            return kept;
        }
        for (Map.Entry<String, Object> field : payload.entrySet()) {
            if (field.getValue() == null) {
                continue;
            }
            kept.put(field.getKey(), field.getValue());
        }
        return kept;
    }

    public static <T> T createOne(
        String path, String key, Map<String, Object> payload, Map<String, Object> query, User user, Class<T> resource
    ) throws Exception {
        String content = Rest.postRaw(path, payload, emptyToNull(query), user).content();
        return ResponseHandler.get(content, resource, key);
    }

    public static <T> T getOne(
        String path, String id, String key, Map<String, Object> query, User user, Class<T> resource
    ) throws Exception {
        String content = Rest.getRaw(path + "/" + id, emptyToNull(query), user).content();
        return ResponseHandler.get(content, resource, key);
    }

    public static <T> T patchOne(
        String path, String id, String key, Map<String, Object> payload, User user, Class<T> resource
    ) throws Exception {
        String content = Rest.patchRaw(path + "/" + id, payload, user).content();
        return ResponseHandler.get(content, resource, key);
    }

    public static <T> Generator<T> listAll(
        String path, String key, Map<String, Object> query, User user, Class<T> resource
    ) throws Exception {
        String content = Rest.getRaw(path, emptyToNull(query), user).content();
        return ResponseHandler.query(content, resource, key, new HashMap<String, Object>());
    }

    public static <T> List<T> deleteMany(
        String path, String key, List<String> ids, User user, Class<T> resource
    ) throws Exception {
        Map<String, Object> query = new HashMap<>();
        query.put("ids", ids);
        String content = Rest.deleteRaw(path, query, user).content();
        return ResponseHandler.post(content, resource, key);
    }

    public static Map<String, Object> emptyToNull(Map<String, Object> query) {
        if (query == null || query.isEmpty()) {
            return null;
        }
        return query;
    }
}
