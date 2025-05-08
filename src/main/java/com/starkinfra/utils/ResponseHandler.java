package com.starkinfra.utils;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;


public final class ResponseHandler {

    public static <T> List<T> post(
        String data,
        Class<T> resourceClass,
        String memberName
    ) throws Exception {
        Gson gson = GsonEvent.getInstance();
        JsonObject contentJson = gson.fromJson(data, JsonObject.class);
        JsonArray jsonArray = contentJson.get(memberName).getAsJsonArray();
    
        List<T> items = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            items.add(gson.fromJson(element, resourceClass));
        }
    
        return items;
    }

    public static <T> T get(
        String data,
        Class<T> resourceClass,
        String memberName
        ) throws Exception {

        Gson gson = GsonEvent.getInstance();
        JsonObject jsonObject = new Gson().fromJson(data, JsonObject.class).get(memberName).getAsJsonObject();

        return gson.fromJson(jsonObject, resourceClass);
    }

    public static <T> Generator<T> query(
        String data,
        Class<T> resourceClass,
        String memberName,
        Map<String, Object> params
    ) {
        return new Generator<T>() {
            public void run() throws Exception {
                String cursor = null;
                Integer limit = (Integer) params.get("limit");

                do {
                    params.put("cursor", cursor);
                    if (limit != null) {
                        params.put("limit", limit > 100 ? "100" : limit.toString());
                        limit -= 100;
                    }

                    Gson gson = GsonEvent.getInstance();
                    JsonObject contentJson = gson.fromJson(data, JsonObject.class).getAsJsonObject();
                    JsonElement cursorJson = contentJson.get("cursor");
                    cursor = cursorJson != null && !cursorJson.isJsonNull() ? cursorJson.getAsString() : null;

                    JsonArray jsonArray = contentJson.get(memberName).getAsJsonArray();
                    for (JsonElement element : jsonArray) {
                        T resource = gson.fromJson(element, resourceClass);
                        this.yield(resource);
                    }
                } while (cursor != null && !cursor.isEmpty() && (limit == null || limit > 0));
            }
        };
    }

    public static <T> Map<String, Object> page(
        String data,
        Class<T> resourceClass,
        String memberName,
        Map<String, Object> params
    ) throws Exception {
        
        Gson gson = GsonEvent.getInstance();

        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        JsonArray jsonArray = jsonObject.get(memberName).getAsJsonArray();
        String cursor = jsonObject.has("cursor") && !jsonObject.get("cursor").isJsonNull()
            ? jsonObject.get("cursor").getAsString()
            : null;

        List<T> items = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            items.add(gson.fromJson(element, resourceClass));
        }

        Map<String, Object> result = new HashMap<>();
        result.put("items", items);
        result.put("cursor", cursor);
        return result;
    }

    public static <T> T delete(
        String data,
        Class<T> resourceClass,
        String memberName
        ) throws Exception {

        Gson gson = GsonEvent.getInstance();
        JsonObject jsonObject = new Gson().fromJson(data, JsonObject.class).get(memberName).getAsJsonObject();

        return gson.fromJson(jsonObject, resourceClass);
    }
}
