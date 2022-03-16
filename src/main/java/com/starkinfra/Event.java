package com.starkinfra;
import com.starkinfra.utils.*;

import com.google.gson.*;


import java.lang.reflect.Type;


public class Event extends Resource {
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
     * Attributes:
     * @param id [string]: unique id returned when the event is created. ex: "5656565656565656"
     * @param created [string]: creation datetime for the notification event. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param isDelivered [bool]: true if the event has been successfully delivered to the user url. ex: false
     * @param subscription [string]: service that triggered this event. ex: "transfer", "utility-payment"
     * @param workspaceId [string]: ID of the Workspace that generated this event. Mostly used when multiple Workspaces have Webhooks registered to the same endpoint. ex: "4545454545454545"
     */
    public Event(String created, Boolean isDelivered, String subscription, String id, String workspaceId) {
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

    public final static class PixReversalEvent extends Event {
        public PixReversal.Log log;

        public PixReversalEvent(PixReversal.Log log, String created, Boolean isDelivered, String subscription, String id, String workspaceId) {
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
     * Create single notification Event from a content string
     * <p>
     * Create a single Event object received from event listening at subscribed user endpoint.
     * If the provided digital signature does not check out with the Stark public key, a
     * starkinfra.exception.InvalidSignatureException will be raised.
     * <p>
     * Parameters:
     * @param content [string]: response content from request received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
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
     * starkinfra.exception.InvalidSignatureException will be raised.
     * <p>
     * Parameters:
     * @param content [string]: response content from request received at user endpoint (not parsed)
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return Event object with updated attributes
     * @throws Exception error in the request
     */
    public static Event parse(String content, String signature, User user) throws Exception {
        return Parse.parseAndVerify(data ,content, signature, user);
    }
}
