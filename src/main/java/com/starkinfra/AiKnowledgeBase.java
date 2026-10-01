package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.ResponseHandler;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;


public final class AiKnowledgeBase extends Resource {
    /**
     * AiKnowledgeBase object
     * <p>
     * An AiKnowledgeBase turns a website into material an AiAgent can read. You give it a root URL; Stark Infra
     * crawls the page, follows its links, converts everything to Markdown and indexes it for retrieval.
     * <p>
     * When you initialize an AiKnowledgeBase, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * name [string]: name of the knowledge base. Between 1 and 100 characters. ex: "Product Documentation"
     * rootUrl [string]: absolute http or https URL the crawl starts from. ex: "https://docs.starkinfra.com"
     * <p>
     * Parameters (optional):
     * isRecursive [Boolean, default null]: whether the crawl may follow links into other subdomains of the root URL's registered domain. The API defaults to true. ex: false
     * tags [list of strings, default null]: list of up to 100 strings for reference when searching for AiKnowledgeBases. ex: ["support", "public"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the AiKnowledgeBase is created. ex: "5656565656565656"
     * status [string]: current status of the knowledge base. Options: "processing", "success", "failed". An agent retrieves from a base only once it reaches "success".
     * created [string]: creation datetime for the AiKnowledgeBase. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the AiKnowledgeBase. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public String name;
    public String rootUrl;
    public Boolean isRecursive;
    public String[] tags;
    public String status;
    public String created;
    public String updated;

    private static final String PATH = "/ai-knowledge-base";

    /**
     * AiKnowledgeBase object
     * <p>
     * An AiKnowledgeBase turns a website into material an AiAgent can read. You give it a root URL; Stark Infra
     * crawls the page, follows its links, converts everything to Markdown and indexes it for retrieval.
     * <p>
     * When you initialize an AiKnowledgeBase, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param name [string]: name of the knowledge base. Between 1 and 100 characters. ex: "Product Documentation"
     * @param rootUrl [string]: absolute http or https URL the crawl starts from. ex: "https://docs.starkinfra.com"
     * @param isRecursive [Boolean, default null]: whether the crawl may follow links into other subdomains of the root URL's registered domain. The API defaults to true. ex: false
     * @param tags [list of strings, default null]: list of up to 100 strings for reference when searching for AiKnowledgeBases. ex: ["support", "public"]
     * <p>
     * Attributes (return-only):
     * @param id [string]: unique id returned when the AiKnowledgeBase is created. ex: "5656565656565656"
     * @param status [string]: current status of the knowledge base. Options: "processing", "success", "failed". An agent retrieves from a base only once it reaches "success".
     * @param created [string]: creation datetime for the AiKnowledgeBase. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the AiKnowledgeBase. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public AiKnowledgeBase(String name, String rootUrl, Boolean isRecursive, String[] tags, String id, String status,
                           String created, String updated
    ) {
        super(id);
        this.name = name;
        this.rootUrl = rootUrl;
        this.isRecursive = isRecursive;
        this.tags = tags;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    /**
     * AiKnowledgeBase object
     * <p>
     * An AiKnowledgeBase turns a website into material an AiAgent can read. You give it a root URL; Stark Infra
     * crawls the page, follows its links, converts everything to Markdown and indexes it for retrieval.
     * <p>
     * When you initialize an AiKnowledgeBase, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the object
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param name [string]: name of the knowledge base. Between 1 and 100 characters. ex: "Product Documentation"
     * @param rootUrl [string]: absolute http or https URL the crawl starts from. ex: "https://docs.starkinfra.com"
     * @param isRecursive [Boolean, default null]: whether the crawl may follow links into other subdomains of the root URL's registered domain. The API defaults to true. ex: false
     * @param tags [list of strings, default null]: list of up to 100 strings for reference when searching for AiKnowledgeBases. ex: ["support", "public"]
     */
    public AiKnowledgeBase(String name, String rootUrl, Boolean isRecursive, String[] tags) {
        this(name, rootUrl, isRecursive, tags, null, null, null, null);
    }

    /**
     * Create an AiKnowledgeBase
     * <p>
     * Send an AiKnowledgeBase object for creation at the Stark Infra API and start crawling it.
     * The call returns immediately with the knowledge base in "processing" status.
     * <p>
     * Parameters:
     * @param knowledgeBase [AiKnowledgeBase object]: AiKnowledgeBase object to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiKnowledgeBase object with updated attributes
     * @throws Exception error in the request
     */
    public static AiKnowledgeBase create(AiKnowledgeBase knowledgeBase, User user) throws Exception {
        String content = Rest.postRaw(PATH, knowledgeBase.payload(), user).content();
        return parseOne(content);
    }

    /**
     * Create an AiKnowledgeBase
     * <p>
     * Send an AiKnowledgeBase object for creation at the Stark Infra API and start crawling it.
     * The call returns immediately with the knowledge base in "processing" status.
     * <p>
     * Parameters:
     * @param knowledgeBase [AiKnowledgeBase object]: AiKnowledgeBase object to be created in the API
     * <p>
     * Return:
     * @return AiKnowledgeBase object with updated attributes
     * @throws Exception error in the request
     */
    public static AiKnowledgeBase create(AiKnowledgeBase knowledgeBase) throws Exception {
        return create(knowledgeBase, null);
    }

    /**
     * Retrieve a specific AiKnowledgeBase
     * <p>
     * Receive a single AiKnowledgeBase object previously created in the Stark Infra API by its id.
     * This is the call to poll while the crawl runs.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiKnowledgeBase object with updated attributes
     * @throws Exception error in the request
     */
    public static AiKnowledgeBase get(String id, User user) throws Exception {
        String content = Rest.getRaw(PATH + "/" + id, user).content();
        return parseOne(content);
    }

    /**
     * Retrieve a specific AiKnowledgeBase
     * <p>
     * Receive a single AiKnowledgeBase object previously created in the Stark Infra API by its id.
     * This is the call to poll while the crawl runs.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return AiKnowledgeBase object with updated attributes
     * @throws Exception error in the request
     */
    public static AiKnowledgeBase get(String id) throws Exception {
        return get(id, null);
    }

    /**
     * Retrieve AiKnowledgeBases
     * <p>
     * Receive a generator of AiKnowledgeBase objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * name [string, default null]: case-insensitive substring of the name to filter retrieved objects. ex: "docs"
     * status [string, default null]: filter for status of retrieved objects. Options: "processing", "success", "failed"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of AiKnowledgeBase objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiKnowledgeBase> query(Map<String, Object> params, User user) throws Exception {
        // this route is not paginated: it answers with every base and rejects limit and cursor (invalidQueryString)
        Map<String, Object> filters = params == null ? new HashMap<String, Object>() : new HashMap<>(params);
        String content = Rest.getRaw(PATH, filters, user).content();
        return ResponseHandler.query(content, AiKnowledgeBase.class, "knowledgeBases", new HashMap<String, Object>());
    }

    /**
     * Retrieve AiKnowledgeBases
     * <p>
     * Receive a generator of AiKnowledgeBase objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * name [string, default null]: case-insensitive substring of the name to filter retrieved objects. ex: "docs"
     * status [string, default null]: filter for status of retrieved objects. Options: "processing", "success", "failed"
     * <p>
     * Return:
     * @return generator of AiKnowledgeBase objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiKnowledgeBase> query(Map<String, Object> params) throws Exception {
        return query(params, null);
    }

    /**
     * Retrieve AiKnowledgeBases
     * <p>
     * Receive a generator of every AiKnowledgeBase object previously created in the Stark Infra API
     * <p>
     * Return:
     * @return generator of AiKnowledgeBase objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<AiKnowledgeBase> query() throws Exception {
        return query(new HashMap<String, Object>(), null);
    }

    /**
     * Update AiKnowledgeBase entity
     * <p>
     * Rename a knowledge base, retag it or change whether its crawl is recursive. The root URL cannot be changed.
     * Only the fields present in the map are sent.
     * <p>
     * Parameters:
     * @param id [string]: AiKnowledgeBase unique id. ex: "5656565656565656"
     * @param patchData map of parameters
     * name [string, default null]: new name of the knowledge base. Between 1 and 100 characters.
     * isRecursive [Boolean, default null]: whether the next crawl may follow links into other subdomains of the root URL's registered domain.
     * tags [list of strings, default null]: new list of up to 100 strings. Replaces the current list.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return AiKnowledgeBase with updated attributes
     * @throws Exception error in the request
     */
    public static AiKnowledgeBase update(String id, Map<String, Object> patchData, User user) throws Exception {
        Map<String, Object> payload = new HashMap<>();
        Map<String, Object> fields = patchData == null ? new HashMap<String, Object>() : patchData;
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            if (field.getValue() == null) {
                continue;
            }
            payload.put(field.getKey(), field.getValue());
        }
        String content = Rest.patchRaw(PATH + "/" + id, payload, user).content();
        return parseOne(content);
    }

    /**
     * Update AiKnowledgeBase entity
     * <p>
     * Rename a knowledge base, retag it or change whether its crawl is recursive. The root URL cannot be changed.
     * Only the fields present in the map are sent.
     * <p>
     * Parameters:
     * @param id [string]: AiKnowledgeBase unique id. ex: "5656565656565656"
     * @param patchData map of parameters
     * name [string, default null]: new name of the knowledge base. Between 1 and 100 characters.
     * isRecursive [Boolean, default null]: whether the next crawl may follow links into other subdomains of the root URL's registered domain.
     * tags [list of strings, default null]: new list of up to 100 strings. Replaces the current list.
     * <p>
     * Return:
     * @return AiKnowledgeBase with updated attributes
     * @throws Exception error in the request
     */
    public static AiKnowledgeBase update(String id, Map<String, Object> patchData) throws Exception {
        return update(id, patchData, null);
    }

    /**
     * List the pages of an AiKnowledgeBase
     * <p>
     * Receive every page the crawler has seen, grouped by host. While a crawl is running this is the live picture,
     * merged with the last finished one.
     * <p>
     * Parameters:
     * @param id [string]: AiKnowledgeBase unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return map from each host to its list of pages. Each page is a map with "originalUrl", "storageUrl" and "status" ("pending", "success" or "failed")
     * @throws Exception error in the request
     */
    public static Map<String, List<Map<String, Object>>> hosts(String id, User user) throws Exception {
        String content = Rest.getRaw(PATH + "/" + id + "/hosts", user).content();
        JsonObject hosts = new Gson().fromJson(content, JsonObject.class).getAsJsonObject("hosts");
        Map<String, List<Map<String, Object>>> pagesByHost = new LinkedHashMap<>();
        for (Map.Entry<String, JsonElement> host : hosts.entrySet()) {
            pagesByHost.put(
                host.getKey(),
                new Gson().fromJson(host.getValue(), new TypeToken<List<Map<String, Object>>>(){}.getType())
            );
        }
        return pagesByHost;
    }

    /**
     * List the pages of an AiKnowledgeBase
     * <p>
     * Receive every page the crawler has seen, grouped by host. While a crawl is running this is the live picture,
     * merged with the last finished one.
     * <p>
     * Parameters:
     * @param id [string]: AiKnowledgeBase unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return map from each host to its list of pages. Each page is a map with "originalUrl", "storageUrl" and "status" ("pending", "success" or "failed")
     * @throws Exception error in the request
     */
    public static Map<String, List<Map<String, Object>>> hosts(String id) throws Exception {
        return hosts(id, null);
    }

    /**
     * Delete AiKnowledgeBases
     * <p>
     * Delete up to 100 AiKnowledgeBases at once. Agents still referencing a deleted base simply retrieve nothing from it.
     * <p>
     * Parameters:
     * @param ids [list of strings]: ids of the AiKnowledgeBases to be deleted. Up to 100 ids. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of deleted AiKnowledgeBase objects
     * @throws Exception error in the request
     */
    public static List<AiKnowledgeBase> delete(List<String> ids, User user) throws Exception {
        Map<String, Object> query = new HashMap<>();
        query.put("ids", ids);
        String content = Rest.deleteRaw(PATH, query, user).content();
        return ResponseHandler.post(content, AiKnowledgeBase.class, "knowledgeBases");
    }

    /**
     * Delete AiKnowledgeBases
     * <p>
     * Delete up to 100 AiKnowledgeBases at once. Agents still referencing a deleted base simply retrieve nothing from it.
     * <p>
     * Parameters:
     * @param ids [list of strings]: ids of the AiKnowledgeBases to be deleted. Up to 100 ids. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return list of deleted AiKnowledgeBase objects
     * @throws Exception error in the request
     */
    public static List<AiKnowledgeBase> delete(List<String> ids) throws Exception {
        return delete(ids, null);
    }

    // starkcore reads the response key from the last word of the resource name ("base"), but this API
    // answers under "knowledgeBase"/"knowledgeBases", so the resource parses the responses itself.
    private static AiKnowledgeBase parseOne(String content) throws Exception {
        return ResponseHandler.get(content, AiKnowledgeBase.class, "knowledgeBase");
    }

    private Map<String, Object> payload() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", name);
        payload.put("rootUrl", rootUrl);
        if (isRecursive != null) {
            payload.put("isRecursive", isRecursive);
        }
        if (tags != null) {
            payload.put("tags", tags);
        }
        return payload;
    }
}
