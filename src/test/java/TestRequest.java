import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.starkinfra.Request;
import com.starkinfra.utils.Response;
import org.junit.Assert;
import org.junit.Test;
import com.starkinfra.PixUser;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;

import java.util.*;

import com.google.gson.*;

public class TestRequest {
    @Test
    public void testRequestGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        String path = "/pix-request";
        Map<String, Object> query = new HashMap<>();
        query.put("limit", 10);
        String request = Request.get(path, query).content();

        System.out.println(request);

        Gson gson = new Gson();
        JsonObject contentJson = gson.fromJson(request, JsonObject.class);

        JsonArray requests = contentJson.get("requests").getAsJsonArray();
        JsonObject requestElement = requests.get(0).getAsJsonObject();

        Assert.assertNotNull(requestElement.get("id"));
    }

    @Test
    public void testRequestPost() throws Exception {
        Settings.user = utils.User.defaultProject();

        String path = "/issuing-holder";
        Map<String, Object> holder = new HashMap<>();
        holder.put("name", "Jaime Lannister" + UUID.randomUUID().toString());
        holder.put("externalId", UUID.randomUUID().toString());
        holder.put("taxId", "20.018.183/0001-80");

        List<Object> holderList = new ArrayList<Object>();
        holderList.add(holder);

        Map<String, Object> data = new HashMap<>();
        data.put("holders", holderList);

        String request = Request.post(path, data).content();

        System.out.println(request);

        Gson gson = new Gson();
        JsonObject contentJson = gson.fromJson(request, JsonObject.class);

        JsonArray requests = contentJson.get("holders").getAsJsonArray();
        JsonObject requestElement = requests.get(0).getAsJsonObject();

        Assert.assertNotNull(requestElement.get("id"));
    }

    @Test
    public void testRequestPatch() throws Exception {
        Settings.user = utils.User.defaultProject();

        String path = "/issuing-holder";

        Map<String, Object> query = new HashMap<>();
        query.put("limit", 1);

        String request = Request.get(path, query).content();

        Gson gson = new Gson();
        JsonObject contentJson = gson.fromJson(request, JsonObject.class);

        JsonArray requests = contentJson.get("holders").getAsJsonArray();
        JsonObject requestElement = requests.get(0).getAsJsonObject();

        String requestId = requestElement.get("id").getAsString();

        path += "/" + requestId;

        HashMap<String, Object> data = new HashMap<>();;
        data.put("status", "blocked");

        request = Request.patch(path, data).content();

        System.out.println(request);

        contentJson = gson.fromJson(request, JsonObject.class);

        JsonObject requestObject = contentJson.get("holder").getAsJsonObject();

        Assert.assertNotNull(requestObject.get("id"));
    }

    @Test
    public void testRequestDelete() throws Exception {
        Settings.user = utils.User.defaultProject();

        String path = "/issuing-holder";
        Map<String, Object> holder = new HashMap<>();
        holder.put("name", "Jaime Lannister" + UUID.randomUUID().toString());
        holder.put("externalId", UUID.randomUUID().toString());
        holder.put("taxId", "20.018.183/0001-80");

        List<Object> holderList = new ArrayList<Object>();
        holderList.add(holder);

        Map<String, Object> data = new HashMap<>();
        data.put("holders", holderList);

        String request = Request.post(path, data).content();

        System.out.println(request);

        Gson gson = new Gson();
        JsonObject contentJson = gson.fromJson(request, JsonObject.class);

        JsonArray requests = contentJson.get("holders").getAsJsonArray();
        JsonObject requestElement = requests.get(0).getAsJsonObject();

        String requestElementId = requestElement.get("id").getAsString();

        path += "/" + requestElementId;

        request = Request.delete(path).content();

        contentJson = gson.fromJson(request, JsonObject.class);

        requestElement = contentJson.get("holder").getAsJsonObject();

        Assert.assertNotNull(requestElement.get("id"));
    }
}