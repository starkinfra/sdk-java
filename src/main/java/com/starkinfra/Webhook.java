package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class Webhook extends Resource {
    static ClassData data = new ClassData(Webhook.class, "Webhook");

    public String url;
    public String[] subscriptions;
    public String deliveryMethod;

    /**
     * Webhook subscription object
     * <p>
     * A Webhook is used to subscribe to notification events on a user-selected endpoint.
     * Currently available services for subscription are transfer, boleto, boleto-payment,
     * utility-payment, invoice, deposit, e brcode-payment.
     * <p>
     * Parameters:
     * @param url [string]: Url that will be notified when an event occurs.
     * @param subscriptions [list of strings]: list of any non-empty combination of the available services. ex: ["transfer", "boleto-payment"]
     * @param deliveryMethod [string]: Determines the delivery mode for the webhook. Use "sequential" (default) for ordered events and "parallel" for unordered delivery.
     * Attributes:
     * @param id [string]: unique id returned when the webhook is created. ex: "5656565656565656"
     */
    public Webhook(String url, String[] subscriptions, String id, String deliveryMethod) {
        super(id);
        this.url = url;
        this.subscriptions = subscriptions;
        this.deliveryMethod = deliveryMethod;
    }

    /**
     * Webhook subscription object
     * <p>
     * A Webhook is used to subscribe to notification events on a user-selected endpoint.
     * Currently available services for subscription are transfer, boleto, boleto-payment,
     * utility-payment, invoice, deposit, e brcode-payment.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the WebHook
     * url [string]: Url that will be notified when an event occurs.
     * subscriptions [list of strings]: list of any non-empty combination of the available services. ex: ["transfer", "boleto-payment"]
     * deliveryMethod [string]: determines the delivery mode for the webhook. Use the "sequential" (default) for ordered events and "parallel" for faster, unordered delivery.
     * Attributes:
     * id [string]: unique id returned when the webhook is created. ex: "5656565656565656"
     */
    public Webhook(Map<String, Object> data) {
        super(null);
        this.url = (String) data.get("url");
        this.subscriptions = (String[]) data.get("subscriptions");
        this.deliveryMethod = (String) data.get("deliveryMethod");
    }

    /**
     * Retrieve a specific Webhook subscription
     * <p>
     * Receive a single Webhook subscription object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return Webhook object with updated attributes
     * @throws Exception error in the request
     */
    public static Webhook get(String id) throws Exception {
        return Webhook.get(id, null);
    }

    /**
     * Retrieve a specific Webhook subscription
     * <p>
     * Receive a single Webhook subscription object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Webhook object with updated attributes
     * @throws Exception error in the request
     */
    public static Webhook get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve Webhook subcriptions
     * <p>
     * Receive a generator of Webhook subcription objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * <p>
     * Return:
     * @return generator of Webhook objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Webhook> query(Map<String, Object> params) throws Exception {
        return Webhook.query(params, null);
    }

    /**
     * Retrieve Webhook subcriptions
     * <p>
     * Receive a generator of Webhook subcription objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Webhook objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Webhook> query(User user) throws Exception {
        return Webhook.query(new HashMap<>(), user);
    }

    /**
     * Retrieve Webhook subcriptions
     * <p>
     * Receive a generator of Webhook subcription objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of Webhook objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Webhook> query() throws Exception {
        return Webhook.query(new HashMap<>(), null);
    }

    /**
     * Retrieve Webhook subcriptions
     * <p>
     * Receive a generator of Webhook subcription objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Webhook objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Webhook> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<Webhook> webhooks;
        public String cursor;

        public Page(List<Webhook> webhooks, String cursor) {
            this.webhooks = webhooks;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged Webhook subscriptions
     * <p>
     * Receive a list of up to 100 Webhook objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * <p>
     * Return:
     * @return Webhook.Page object:
     * Webhook.Page.webhooks: list of Webhook objects with updated attributes
     * Webhook.Page.cursor: cursor to retrieve the next page of Webhook objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged Webhooks
     * <p>
     * Receive a list of up to 100 Webhook objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Webhook.Page object:
     * Webhook.Page.webhooks: list of Webhook objects with updated attributes
     * Webhook.Page.cursor: cursor to retrieve the next page of Webhook objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged Webhooks
     * <p>
     * Receive a list of up to 100 Webhook objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return Webhook.Page object:
     * Webhook.Page.webhooks: list of Webhook objects with updated attributes
     * Webhook.Page.cursor: cursor to retrieve the next page of Webhook objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged Webhooks
     * <p>
     * Receive a list of up to 100 Webhook objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Webhook.Page object:
     * Webhook.Page.webhooks: list of Webhook objects with updated attributes
     * Webhook.Page.cursor: cursor to retrieve the next page of Webhook objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<Webhook> webhooks = new ArrayList<>();
        for (SubResource webhook: page.entities) {
            webhooks.add((Webhook) webhook);
        }
        return new Page(webhooks, page.cursor);
    }

    /**
     * Create Webhook subscription
     * <p>
     * Send a single Webhook subscription for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param webhookData parameters for the creation of the webhook
     * url [string]: Url that will be notified when an event occurs.
     * subscriptions [list of strings]: list of any non-empty combination of the available services. ex: ["transfer", "boleto-payment"]
     * <p>
     * Return:
     * @return Webhook object with updated attributes
     * @throws Exception error in the request
     */
    public static Webhook create(Map<String, Object> webhookData) throws Exception {
        return Webhook.create(webhookData, null);
    }

    /**
     * Create Webhook subscription
     * <p>
     * Send a single Webhook subscription for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param webhookData parameters for the creation of the webhook
     * url [string]: Url that will be notified when an event occurs.
     * subscriptions [list of strings]: list of any non-empty combination of the available services. ex: ["transfer", "boleto-payment"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Webhook object with updated attributes
     * @throws Exception error in the request
     */
    public static Webhook create(Map<String, Object> webhookData, User user) throws Exception {
        String url = (String) webhookData.get("url");
        String[] subscriptions = (String[]) webhookData.get("subscriptions");
        String deliveryMethod = (String) webhookData.get("deliveryMethod");
        return Rest.postSingle(data, new Webhook(url, subscriptions, null, deliveryMethod), user);
    }

    /**
     * Delete a Webhook subscription entity
     * <p>
     * Delete a Webhook subscription entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: Webhook unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return deleted Webhook object
     * @throws Exception error in the request
     */
    public static Webhook delete(String id) throws Exception {
        return Webhook.delete(id, null);
    }

    /**
     * Delete a Webhook subscription entity
     * <p>
     * Delete a Webhook subscription entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: Webhook unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return deleted Webhook object
     * @throws Exception error in the request
     */
    public static Webhook delete(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }
}
