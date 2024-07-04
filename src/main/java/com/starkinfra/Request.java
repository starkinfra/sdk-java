package com.starkinfra;

import com.google.gson.JsonObject;
import com.starkinfra.utils.Response;
import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Request {

    static String prefix = "Joker";

    /**
     * Retrieve any StarkInfra resource.
     * <p>
     * Receive a JSON of resources previously created in StarkInfra's API.
     * <p>
     * Parameters:
     * path [String]: StarkInfra resource's route. Example: "/pix-request/"
     */

    public static Response get(String path) throws Exception {
        return Rest.getRaw(path, null, null, prefix, false);
    }

    /**
     * Retrieve any StarkInfra resource.
     * <p>
     * Receive a JSON of resources previously created in StarkInfra's API.
     * <p>
     * Parameters:
     * path [String]: StarkInfra resource's route. Example: "/pix-request/"
     * query [Map<String, Object>]: Query parameters. Example: new HashMap<String, Object>() {{ put("limit", 1); put("status", "paid"); }}
     */

    public static Response get(String path, Map<String, Object> query) throws Exception {
        return Rest.getRaw(path, query, null, prefix, false);
    }

    /**
     * Retrieve any StarkInfra resource.
     * <p>
     * Receive a JSON of resources previously created in StarkInfra's API.
     * <p>
     * Parameters:
     * path [String]: StarkInfra resource's route. Example: "/pix-request/"
     * query [Map<String, Object>]: Query parameters. Example: new HashMap<String, Object>() {{ put("limit", 1); put("status", "paid"); }}
     * user [Organization/Project object]: Organization or Project object. Not necessary if StarkInfra.Settings.User was set before function call.
     */

    public static Response get(String path, Map<String, Object> query, User user ) throws Exception {
        return Rest.getRaw(path, query, user, prefix, false);
    }

    /**
     * Create any StarkInfra resource.
     * <p>
     * Send a list of JSONs and create any StarkInfra resource objects.
     * <p>
     * Parameters:
     * path [String]: StarkInfra resource's route. Example: "/pix-request/"
     * body [Map<String, Object>]: Request parameters. Example:
     *   <pre>
     *   new HashMap<String, Object>() {{
     *       put("requests", new ArrayList<Map<String, Object>>() {{
     *           add(new HashMap<String, Object>() {{
     *               put("amount", 100);
     *               put("name", "Iron Bank S.A.");
     *               put("taxId", "20.018.183/0001-80");
     *           }});
     *       }});
     *   }});
     *   </pre>
     * query [Map<String, Object>]: Query parameters. Example: new HashMap<String, Object>() {{ put("limit", 1); put("status", "paid"); }}
     */

    public static Response post(String path, Map<String, Object> payload) throws Exception {
        return Rest.postRaw(path, payload, null, prefix, false);
    }

    /**
     * Create any StarkInfra resource.
     * <p>
     * Send a list of JSONs and create any StarkInfra resource objects.
     * <p>
     * Parameters:
     * path [String]: StarkInfra resource's route. Example: "/pix-request/"
     * body [Map<String, Object>]: Request parameters. Example:
     *   <pre>
     *   new HashMap<String, Object>() {{
     *       put("requests", new ArrayList<Map<String, Object>>() {{
     *           add(new HashMap<String, Object>() {{
     *               put("amount", 100);
     *               put("name", "Iron Bank S.A.");
     *               put("taxId", "20.018.183/0001-80");
     *           }});
     *       }});
     *   }});
     *   </pre>
     * query [Map<String, Object>]: Query parameters. Example: new HashMap<String, Object>() {{ put("limit", 1); put("status", "paid"); }}
     * user [Organization/Project object]: Organization or Project object. Not necessary if StarkInfra.Settings.User was set before function call.
     */

    public static Response post(String path, Map<String, Object> payload, User user ) throws Exception {
        return Rest.postRaw(path, payload, user, prefix, false);
    }

    /**
     * Update any StarkInfra resource.
     * <p>
     * Send a JSON with parameters of a single StarkInfra resource object and update it.
     * <p>
     * Parameters:
     * path [String]: StarkInfra resource's route. Example: "/pix-request/"
     * <br>
     * - body [Map<String, Object>]: Request parameters. Example:
     *   <pre>
     *   new HashMap<String, Object>() {{
     *       put("requests", new HashMap<String, Object>() {{
     *           put("amount", 100);
     *           put("name", "Iron Bank S.A.");
     *           put("taxId", "20.018.183/0001-80");
     *       }});
     *   }});
     *   </pre>
     */

    public static Response patch(String path, Map<String, Object> payload) throws Exception {
        return Rest.patchRaw(path, payload, null, prefix, false);
    }

    /**
     * Update any StarkInfra resource.
     * <p>
     * Send a JSON with parameters of a single StarkInfra resource object and update it.
     * <p>
     * Parameters:
     * path [String]: StarkInfra resource's route. Example: "/pix-request/"
     * <br>
     * - body [Map<String, Object>]: Request parameters. Example:
     *   <pre>
     *   new HashMap<String, Object>() {{
     *       put("requests", new HashMap<String, Object>() {{
     *           put("amount", 100);
     *           put("name", "Iron Bank S.A.");
     *           put("taxId", "20.018.183/0001-80");
     *       }});
     *   }});
     *   </pre>
     * user [Organization/Project object]: Organization or Project object. Not necessary if StarkInfra.Settings.User was set before function call.
     */

    public static Response patch(String path, Map<String, Object> payload, User user ) throws Exception {
        return Rest.patchRaw(path, payload, user, prefix, false);
    }

    /**
     * Put any StarkInfra resource.
     * <p>
     * Send a JSON with parameters of a single StarkInfra resource object and create it.
     * If the resource already exists, it will be updated.
     * <p>
     * Parameters:
     * path [String]: StarkInfra resource's route. Example: "/pix-request/"
     * body [Map<String, Object>]: Request parameters. Example:
     *   <pre>
     *   new HashMap<String, Object>() {{
     *       put("requests", new HashMap<String, Object>() {{
     *           put("amount", 100);
     *           put("name", "Iron Bank S.A.");
     *           put("taxId", "20.018.183/0001-80");
     *       }});
     *   }});
     *   </pre>
     * user [Organization/Project object]: Organization or Project object. Not necessary if StarkInfra.Settings.User was set before function call.
     */

    public static Response put(String path, Map<String, Object> payload) throws Exception {
        return Rest.putRaw(path, payload, null, prefix, false);
    }

    /**
     * Put any StarkInfra resource.
     * <p>
     * Send a JSON with parameters of a single StarkInfra resource object and create it.
     * If the resource already exists, it will be updated.
     * <p>
     * Parameters:
     * path [String]: StarkInfra resource's route. Example: "/pix-request/"
     * body [Map<String, Object>]: Request parameters. Example:
     *   <pre>
     *   new HashMap<String, Object>() {{
     *       put("requests", new HashMap<String, Object>() {{
     *           put("amount", 100);
     *           put("name", "Iron Bank S.A.");
     *           put("taxId", "20.018.183/0001-80");
     *       }});
     *   }});
     *   </pre>
     */

    public static Response put(String path, Map<String, Object> payload, User user ) throws Exception {
        return Rest.putRaw(path, payload, user, prefix, false);
    }

    /**
     * Delete any StarkInfra resource.
     * <p>
     * Send a JSON with parameters of a single StarkInfra resource object and delete it.
     * <p>
     * Parameters:
     * path [String]: StarkInfra resource's route. Example: "/pix-request/"
     * body [Map<String, Object>]: Request parameters. Example:
     *   <pre>
     *   new HashMap<String, Object>() {{
     *       put("requests", new HashMap<String, Object>() {{
     *           put("amount", 100);
     *           put("name", "Iron Bank S.A.");
     *           put("taxId", "20.018.183/0001-80");
     *       }});
     *   }});
     *   </pre>
     * user [Organization/Project object]: Organization or Project object. Not necessary if StarkInfra.Settings.User was set before function call.
     */

    public static Response delete(String path) throws Exception {
        return Request.delete(path, null);
    }

    /**
     * Delete any StarkInfra resource.
     * <p>
     * Send a JSON with parameters of a single StarkInfra resource object and delete it.
     * <p>
     * Parameters:
     * path [String]: StarkInfra resource's route. Example: "/pix-request/"
     * body [Map<String, Object>]: Request parameters. Example:
     *   <pre>
     *   new HashMap<String, Object>() {{
     *       put("requests", new HashMap<String, Object>() {{
     *           put("amount", 100);
     *           put("name", "Iron Bank S.A.");
     *           put("taxId", "20.018.183/0001-80");
     *       }});
     *   }});
     *   </pre>
     * user [Organization/Project object]: Organization or Project object. Not necessary if StarkInfra.Settings.User was set before function call.
     */

    public static Response delete(String path, User user) throws Exception {
        return Rest.deleteRaw(path, null, user, prefix, false);
    }
}