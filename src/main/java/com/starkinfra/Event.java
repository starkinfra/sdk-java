package com.starkinfra;


import com.google.gson.*;
import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Parse;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;


import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.reflect.Type;


public class Event extends Resource {
    /**
     * Webhook Event object
     * <p>
     * An Event is the notification received from the subscription to the Webhook.
     * Events cannot be created, but may be retrieved from the Stark Infra API to
     * list all generated updates on entities.
     * <p>
     * Parameters:
     * id [string]: unique id returned when the event is created. ex: "5656565656565656"
     * created [string]: creation datetime for the notification event. ex: "2020-03-10 10:30:00.000000+00:00"
     * isDelivered [bool]: true if the event has been successfully delivered to the user url. ex: false
     * subscription [string]: service that triggered this event. ex: "pix-key", "infraction-report"
     * workspaceId [string]: ID of the Workspace that generated this event. Mostly used when multiple Workspaces have Webhooks registered to the same endpoint. ex: "4545454545454545"
     *
     */
    static ClassData data = new ClassData(Event.class, "Event");

    public String created;
    public Boolean isDelivered;
    public String subscription;
    public String workspaceId;

    /**
     * Webhook Event object
     * <p>
     * An Event is the notification received from the subscription to the Webhook.
     * Events cannot be created, but may be retrieved from the Stark Infra API to
     * list all generated updates on entities.
     * <p>
     * Parameters:
     * @param id [string]: unique id returned when the event is created. ex: "5656565656565656"
     * @param created [string]: creation datetime for the notification event. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param isDelivered [bool]: true if the event has been successfully delivered to the user url. ex: false
     * @param subscription [string]: service that triggered this event. ex: "pix-key", "infraction-report"
     * @param workspaceId [string]: ID of the Workspace that generated this event. Mostly used when multiple Workspaces have Webhooks registered to the same endpoint. ex: "4545454545454545"
     */
    public Event(String created, Boolean isDelivered, String subscription, String id, String workspaceId
    ) {
        super(id);
        this.created = created;
        this.isDelivered = isDelivered;
        this.subscription = subscription;
        this.workspaceId = workspaceId;
    }

    public static class Deserializer implements JsonDeserializer<Event> {
        @Override
        public Event deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            JsonElement type = jsonObject.get("subscription");
            if (type == null) {
                return null;
            }
            String stringType = type.getAsString();
            if (stringType.contains("pix-request")) {
                return context.deserialize(jsonObject, PixRequestEvent.class);
            }
            if (stringType.contains("pix-reversal")) {
                return context.deserialize(jsonObject, PixReversalEvent.class);
            }
            if (stringType.contains("pix-chargeback")) {
                return context.deserialize(jsonObject, PixChargebackEvent.class);
            }
            if (stringType.contains("pix-infraction")) {
                return context.deserialize(jsonObject, PixInfractionEvent.class);
            }
            if (stringType.contains("pix-key")) {
                return context.deserialize(jsonObject, PixKeyEvent.class);
            }
            if (stringType.contains("pix-claim")) {
                return context.deserialize(jsonObject, PixClaimEvent.class);
            }
            if (stringType.contains("issuing-card")) {
                return context.deserialize(jsonObject, IssuingCardEvent.class);
            }
            if (stringType.contains("issuing-invoice")) {
                return context.deserialize(jsonObject, IssuingInvoiceEvent.class);
            }
            if (stringType.contains("issuing-purchase")) {
                return context.deserialize(jsonObject, IssuingPurchaseEvent.class);
            }
            if (stringType.contains("credit-note")) {
                return context.deserialize(jsonObject, CreditNoteEvent.class);
            }
            return context.deserialize(jsonObject, UnknownEvent.class);
        }
    }

    public final static class PixRequestEvent extends Event {
        public PixRequest.Log log;

        public PixRequestEvent(PixRequest.Log log, String created, Boolean isDelivered, String subscription, String id, String workspaceId) {
            super(created, isDelivered, subscription, id, workspaceId);
            this.log = log;
        }
    }

    public final static class PixKeyEvent extends Event {
        public PixKey.Log log;

        public PixKeyEvent(PixKey.Log log, String created, Boolean isDelivered, String subscription, String id, String workspaceId) {
            super(created, isDelivered, subscription, id, workspaceId);
            this.log = log;
        }
    }

    public final static class PixClaimEvent extends Event {
        public PixClaim.Log log;

        public PixClaimEvent(PixClaim.Log log, String created, Boolean isDelivered, String subscription, String id, String workspaceId) {
            super(created, isDelivered, subscription, id, workspaceId);
            this.log = log;
        }
    }

    public final static class PixInfractionEvent extends Event {
        public PixInfraction.Log log;

        public PixInfractionEvent(PixInfraction.Log log, String created, Boolean isDelivered, String subscription, String id, String workspaceId) {
            super(created, isDelivered, subscription, id, workspaceId);
            this.log = log;
        }
    }

    public final static class PixChargebackEvent extends Event {
        public PixChargeback.Log log;

        public PixChargebackEvent(PixChargeback.Log log, String created, Boolean isDelivered, String subscription, String id, String workspaceId) {
            super(created, isDelivered, subscription, id, workspaceId);
            this.log = log;
        }
    }

    public final static class PixReversalEvent extends Event {
        public PixReversal.Log log;

        public PixReversalEvent(PixReversal.Log log, String created, Boolean isDelivered, String subscription, String id, String workspaceId) {
            super(created, isDelivered, subscription, id, workspaceId);
            this.log = log;
        }
    }

    public final static class IssuingCardEvent extends Event {
        public IssuingCard.Log log;

        public IssuingCardEvent(IssuingCard.Log log, String created, Boolean isDelivered, String subscription, String id, String workspaceId) {
            super(created, isDelivered, subscription, id, workspaceId);
            this.log = log;
        }
    }

    public final static class IssuingInvoiceEvent extends Event {
        public IssuingInvoice.Log log;

        public IssuingInvoiceEvent(IssuingInvoice.Log log, String created, Boolean isDelivered, String subscription, String id, String workspaceId) {
            super(created, isDelivered, subscription, id, workspaceId);
            this.log = log;
        }
    }

    public final static class IssuingPurchaseEvent extends Event {
        public IssuingPurchase.Log log;

        public IssuingPurchaseEvent(IssuingPurchase.Log log, String created, Boolean isDelivered, String subscription, String id, String workspaceId) {
            super(created, isDelivered, subscription, id, workspaceId);
            this.log = log;
        }
    }

    public final static class CreditNoteEvent extends Event {
        public CreditNote.Log log;

        public CreditNoteEvent(CreditNote.Log log, String created, Boolean isDelivered, String subscription, String id, String workspaceId) {
            super(created, isDelivered, subscription, id, workspaceId);
            this.log = log;
        }
    }

    public final static class UnknownEvent extends Event {
        public JsonObject log;

        public UnknownEvent(JsonObject log, String created, Boolean isDelivered, String subscription, String id, String workspaceId) {
            super(created, isDelivered, subscription, id, workspaceId);
            this.log = log;
        }
    }

    /**
     * Retrieve a specific notification Event
     * <p>
     * Receive a single notification Event object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return Event object with updated attributes
     * @throws Exception error in the request
     */
    public static Event get(String id) throws Exception {
        return Event.get(id, null);
    }

    /**
     * Retrieve a specific notification Event
     * <p>
     * Receive a single notification Event object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Event object with updated attributes
     * @throws Exception error in the request
     */
    public static Event get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve notification Events
     * <p>
     * Receive a generator of notification Event objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * isDelivered [bool, default null]: bool to filter successfully delivered events. ex: true or false
     * <p>
     * Return:
     * @return generator of Event objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Event> query(Map<String, Object> params) throws Exception {
        return Event.query(params, null);
    }

    /**
     * Retrieve notification Events
     * <p>
     * Receive a generator of notification Event objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Event objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Event> query(User user) throws Exception {
        return Event.query(new HashMap<>(), user);
    }

    /**
     * Retrieve notification Events
     * <p>
     * Receive a generator of notification Event objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of Event objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Event> query() throws Exception {
        return Event.query(new HashMap<>(), null);
    }

    /**
     * Retrieve notification Events
     * <p>
     * Receive a generator of notification Event objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * isDelivered [bool, default null]: bool to filter successfully delivered events. ex: true or false
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Event objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Event> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<Event> events;
        public String cursor;

        public Page(List<Event> events, String cursor) {
            this.events = events;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged Events
     * <p>
     * Receive a list of up to 100 Event objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * isDelivered [bool, default null]: bool to filter successfully delivered events. ex: true or false
     * <p>
     * Return:
     * @return Event.Page object:
     * Event.Page.events: list of Event objects with updated attributes
     * Event.Page.cursor: cursor to retrieve the next page of Event objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged Events
     * <p>
     * Receive a list of up to 100 Event objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Event.Page object:
     * Event.Page.events: list of Event objects with updated attributes
     * Event.Page.cursor: cursor to retrieve the next page of Event objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged Events
     * <p>
     * Receive a list of up to 100 Event objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return Event.Page object:
     * Event.Page.events: list of Event objects with updated attributes
     * Event.Page.cursor: cursor to retrieve the next page of Event objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged Events
     * <p>
     * Receive a list of up to 100 Event objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * isDelivered [bool, default null]: bool to filter successfully delivered events. ex: true or false
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Event.Page object:
     * Event.Page.events: list of Event objects with updated attributes
     * Event.Page.cursor: cursor to retrieve the next page of Event objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<Event> events = new ArrayList<>();
        for (SubResource event: page.entities) {
            events.add((Event) event);
        }
        return new Page(events, page.cursor);
    }

    /**
     * Delete notification Events
     * <p>
     * Delete a list of notification Event entities previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: Event unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return deleted Event object
     * @throws Exception error in the request
     */
    public static Event delete(String id) throws Exception {
        return Event.delete(id, null);
    }

    /**
     * Delete notification Events
     * <p>
     * Delete a list of notification Event entities previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: Event unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return deleted Event object
     * @throws Exception error in the request
     */
    public static Event delete(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * Update notification Event entity
     * <p>
     * Update notification Event by passing id.
     * If isDelivered is True, the event will no longer be returned on queries with isDelivered=False.
     * <p>
     * Parameters:
     * @param id [string]: Event unique ids. ex: "5656565656565656"
     * @param patchData map of parameters to patch
     * isDelivered [bool]: If True and event hasn't been delivered already, event will be set as delivered. ex: true
     * <p>
     * Return:
     * @return Event object with updated attributes
     * @throws Exception error in the request
     */
    public static Event update(String id, Map<String, Object> patchData) throws Exception {
        return Event.update(id, patchData, null);
    }

    /**
     * Update notification Event entity
     * <p>
     * Update notification Event by passing id.
     * If isDelivered is True, the event will no longer be returned on queries with isDelivered=false.
     * <p>
     * Parameters:
     * @param id [string]: Event unique ids. ex: "5656565656565656"
     * @param patchData map of properties to patch
     * isDelivered [bool]: If True and event hasn't been delivered already, event will be set as delivered. ex: true
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Event object with updated attributes
     * @throws Exception error in the request
     */
    public static Event update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    /**
     * Create single notification Event from a content string
     * <p>
     * Create a single Event object received from event listening at subscribed user endpoint.
     * If the provided digital signature does not check out with the Stark public key, a
     * starkinfra.error.InvalidSignatureError will be raised.
     * <p>
     * Parameters:
     * @param content [String]: response content from request received at user endpoint (not parsed)
     * @param signature [String]: base-64 digital signature received at response header "Digital-Signature"
     * <p>
     * Return:
     * @return Event object with updated attributes
     * @throws Exception error in the request
     */
    public static<T extends Resource> T parse(String content, String signature) throws Exception {
        return Parse.parseAndVerify(data, content, signature, Settings.user);
    }

    /**
     * Create single notification Event from a content string
     * <p>
     * Create a single Event object received from event listening at subscribed user endpoint.
     * If the provided digital signature does not check out with the Stark public key, a
     * starkinfra.error.InvalidSignatureError will be raised.
     * <p>
     * Parameters:
     * @param content [String]: response content from request received at user endpoint (not parsed)
     * @param signature [String]: base-64 digital signature received at response header "Digital-Signature"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Event object with updated attributes
     * @throws Exception error in the request
     */
    public static Event parse(String content, String signature, User user) throws Exception {
        return Parse.parseAndVerify(data ,content, signature, user);
    }

    public final static class Attempt extends Resource {

        static ClassData data = new ClassData(Attempt.class, "EventAttempt");

        public String code;
        public String message;
        public String eventId;
        public String webhookId;
        public String created;

        /**
         * Event.Attempt object
         * <p>
         * When an Event delivery fails, an event attempt will be registered.
         * It carries information meant to help you debug event reception issues.
         * <p>
         * Parameters:
         * @param id [string]: unique id that identifies the delivery attempt. ex: "5656565656565656"
         * @param code [string]: delivery error code. ex: badHttpStatus, badConnection, timeout
         * @param message [string]: delivery error full description. ex: "HTTP POST request returned status 404"
         * @param eventId [string]: ID of the Event whose delivery failed. ex: "4848484848484848"
         * @param webhookId [string]: ID of the Webhook that triggered this event. ex: "5656565656565656"
         * @param created [string]: datetime representing the moment when the attempt was made. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Attempt(String id, String code, String message, String eventId, String webhookId, String created) {
            super(id);
            this.code = code;
            this.message = message;
            this.eventId = eventId;
            this.webhookId = webhookId;
            this.created = created;
        }

        /**
         * Retrieve a specific Event.Attempt
         * <p>
         * Receive a single Event.Attempt object previously created by the Stark Infra API by its id
         * <p>
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return Event.Attempt object with updated attributes
         * @throws Exception error in the request
         */
        public static Attempt get(String id) throws Exception {
            return Attempt.get(id, null);
        }

        /**
         * Retrieve a specific Event.Attempt
         * <p>
         * Receive a single Event.Attempt object previously created by the Stark Infra API by its id
         * <p>
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return Event.Attempt object with updated attributes
         * @throws Exception error in the request
         */
        public static Attempt get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve Attempts
         * <p>
         * Receive a generator of Event.Attempt objects previously created in the Stark Infra API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * eventIds [list of strings, default null]: list of Event ids to filter attempts. ex: ["5656565656565656", "4545454545454545"]
         * webhookIds [list of strings, default null]: list of Webhook ids to filter attempts. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of Event.Attempt objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Attempt> query(Map<String, Object> params) throws Exception {
            return Attempt.query(params, null);
        }

        /**
         * Retrieve Attempts
         * <p>
         * Receive a generator of Event.Attempt objects previously created in the Stark Infra API
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of Event.Attempt objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Attempt> query(User user) throws Exception {
            return Attempt.query(new HashMap<>(), user);
        }

        /**
         * Retrieve Attempts
         * <p>
         * Receive a generator of Event.Attempt objects previously created in the Stark Infra API
         * <p>
         * Return:
         * @return generator of Event.Attempt objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Attempt> query() throws Exception {
            return Attempt.query(new HashMap<>(), null);
        }

        /**
         * Retrieve Attempts
         * <p>
         * Receive a generator of Event.Attempt objects previously created in the Stark Infra API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * eventIds [list of strings, default null]: list of Event ids to filter attempts. ex: ["5656565656565656", "4545454545454545"]
         * webhookIds [list of strings, default null]: list of Webhook ids to filter attempts. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of Event.Attempt objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Attempt> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<Attempt> attempts;
            public String cursor;

            public Page(List<Attempt> attempts, String cursor) {
                this.attempts = attempts;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged Attempts
         * <p>
         * Receive a list of up to 100 Event.Attempt objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * eventIds [list of strings, default null]: list of Event ids to filter attempts. ex: ["5656565656565656", "4545454545454545"]
         * webhookIds [list of strings, default null]: list of Webhook ids to filter attempts. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return Event.Attempt.Page object:
         * Event.Attempt.Page.attempts: list of Event.Attempt objects with updated attributes
         * Event.Attempt.Page.cursor: cursor to retrieve the next page of Attempt objects
         * @throws Exception error in the request
         */
        public static Attempt.Page page(Map<String, Object> params) throws Exception {
            return page(params, null);
        }

        /**
         * Retrieve paged Attempts
         * <p>
         * Receive a list of up to 100 event.Attempt objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return Event.Attempt.Page object:
         * Event.Attempt.Page.attempts: list of Event.Attempt objects with updated attributes
         * Event.Attempt.Page.cursor: cursor to retrieve the next page of Attempt objects
         * @throws Exception error in the request
         */
        public static Attempt.Page page(User user) throws Exception {
            return page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged Attempts
         * <p>
         * Receive a list of up to 100 event.Attempt objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return Event.Attempt.Page object:
         * Event.Attempt.Page.attempts: list of Event.Attempt objects with updated attributes
         * Event.Attempt.Page.cursor: cursor to retrieve the next page of Attempt objects
         * @throws Exception error in the request
         */
        public static Attempt.Page page() throws Exception {
            return page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged Attempts
         * <p>
         * Receive a list of up to 100 event.Attempt objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
         * eventIds [list of strings, default null]: list of Event ids to filter attempts. ex: ["5656565656565656", "4545454545454545"]
         * webhookIds [list of strings, default null]: list of Webhook ids to filter attempts. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return Event.Attempt.Page object:
         * Event.Attempt.Page.attempts: list of Event.Attempt objects with updated attributes
         * Event.Attempt.Page.cursor: cursor to retrieve the next page of Attempt objects
         * @throws Exception error in the request
         */
        public static Attempt.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<Attempt> attempts = new ArrayList<>();
            for (SubResource attempt: page.entities) {
                attempts.add((Attempt) attempt);
            }
            return new Attempt.Page(attempts, page.cursor);
        }
    }
}
