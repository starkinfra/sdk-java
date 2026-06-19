package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IssuingStockRule extends Resource {
    /**
     * IssuingStockRule object
     * <p>
     * The IssuingStockRule object is a notification rule attached to an IssuingStock.
     * When the linked stock balance reaches minimumBalance, the recipients listed in
     * emails / phones are notified.
     * <p>
     * When you initialize an IssuingStockRule, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * minimumBalance [integer]: stock balance threshold that triggers a notification. ex: 10000
     * stockId [string]: IssuingStock unique id the rule is linked to. ex: "5136459887542272"
     * tags [list of strings, default null]: list of strings for tagging. ex: ["card", "corporate"]
     * emails [list of strings, default null]: emails notified when the stock reaches the minimum balance. ex: ["john.doe@enterprise.com"]
     * phones [list of strings, default null]: phones notified when the stock reaches the minimum balance. ex: ["+55 (11) 91234 5678"]
     * id [string]: unique id returned when IssuingStockRule is created. ex: "5664445921492992"
     * status [string]: current IssuingStockRule status. ex: "active", "canceled"
     * updated [string]: latest update datetime for the IssuingStockRule. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingStockRule. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(IssuingStockRule.class, "IssuingStockRule");

    public Long minimumBalance;
    public String stockId;
    public String[] tags;
    public String[] emails;
    public String[] phones;
    public String status;
    public String updated;
    public String created;

    /**
     * IssuingStockRule object
     * <p>
     * The IssuingStockRule object is a notification rule attached to an IssuingStock.
     * When the linked stock balance reaches minimumBalance, the recipients listed in
     * emails / phones are notified.
     * <p>
     * When you initialize an IssuingStockRule, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * @param minimumBalance [long]: stock balance threshold that triggers a notification. ex: 10000
     * @param stockId [string]: IssuingStock unique id the rule is linked to. ex: "5136459887542272"
     * @param tags [list of strings, default null]: list of strings for tagging. ex: ["card", "corporate"]
     * @param emails [list of strings, default null]: emails notified when the stock reaches the minimum balance. ex: ["john.doe@enterprise.com"]
     * @param phones [list of strings, default null]: phones notified when the stock reaches the minimum balance. ex: ["+55 (11) 91234 5678"]
     * @param id [string]: unique id returned when IssuingStockRule is created. ex: "5664445921492992"
     * @param status [string]: current IssuingStockRule status. ex: "active", "canceled"
     * @param updated [string]: latest update datetime for the IssuingStockRule. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the IssuingStockRule. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingStockRule(
        String id, Long minimumBalance, String stockId, String[] tags, String[] emails,
        String[] phones, String status, String updated, String created
    ) {
        super(id);
        this.minimumBalance = minimumBalance;
        this.stockId = stockId;
        this.tags = tags;
        this.emails = emails;
        this.phones = phones;
        this.status = status;
        this.updated = updated;
        this.created = created;
    }

    /**
     * IssuingStockRule object
     * <p>
     * The IssuingStockRule object is a notification rule attached to an IssuingStock.
     * When the linked stock balance reaches minimumBalance, the recipients listed in
     * emails / phones are notified.
     * <p>
     * When you initialize an IssuingStockRule, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the IssuingStockRule
     * minimumBalance [integer]: stock balance threshold that triggers a notification. ex: 10000
     * stockId [string]: IssuingStock unique id the rule is linked to. ex: "5136459887542272"
     * <p>
     * Parameters (optional):
     * tags [list of strings, default null]: list of strings for tagging. ex: ["card", "corporate"]
     * emails [list of strings, default null]: emails notified when the stock reaches the minimum balance. ex: ["john.doe@enterprise.com"]
     * phones [list of strings, default null]: phones notified when the stock reaches the minimum balance. ex: ["+55 (11) 91234 5678"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when IssuingStockRule is created. ex: "5664445921492992"
     * status [string]: current IssuingStockRule status. ex: "active", "canceled"
     * updated [string]: latest update datetime for the IssuingStockRule. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingStockRule. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public IssuingStockRule(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.minimumBalance = ((Number) dataCopy.remove("minimumBalance")).longValue();
        this.stockId = (String) dataCopy.remove("stockId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.emails = (String[]) dataCopy.remove("emails");
        this.phones = (String[]) dataCopy.remove("phones");
        this.status = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific IssuingStockRule
     * <p>
     * Receive a single IssuingStockRule object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5664445921492992"
     * <p>
     * Return:
     * @return IssuingStockRule object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingStockRule get(String id) throws Exception{
        return IssuingStockRule.get(id, null);
    }

    /**
     * Retrieve a specific IssuingStockRule
     * <p>
     * Receive a single IssuingStockRule object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5664445921492992"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingStockRule object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingStockRule get(String id, User user) throws Exception{
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve IssuingStockRules
     * <p>
     * Receive a generator of IssuingStockRule objects registered to your workspace in the Stark Infra API.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["active", "canceled"]
     * stockIds [list of strings, default null]: list of IssuingStock ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["card", "corporate"]
     * <p>
     * Return:
     * @return generator of IssuingStockRule objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingStockRule> query(Map<String, Object> params) throws Exception{
        return IssuingStockRule.query(params, null);
    }

    /**
     * Retrieve IssuingStockRules
     * <p>
     * Receive a generator of IssuingStockRule objects registered to your workspace in the Stark Infra API.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingStockRule objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingStockRule> query(User user) throws Exception{
        return IssuingStockRule.query(new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingStockRules
     * <p>
     * Receive a generator of IssuingStockRule objects registered to your workspace in the Stark Infra API.
     * <p>
     * Return:
     * @return generator of IssuingStockRule objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingStockRule> query() throws Exception{
        return IssuingStockRule.query(new HashMap<>(), null);
    }

    /**
     * Retrieve IssuingStockRules
     * <p>
     * Receive a generator of IssuingStockRule objects registered to your workspace in the Stark Infra API.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["active", "canceled"]
     * stockIds [list of strings, default null]: list of IssuingStock ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["card", "corporate"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingStockRule objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingStockRule> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<IssuingStockRule> rules;
        public String cursor;

        public Page(List<IssuingStockRule> rules, String cursor) {
            this.rules = rules;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingStockRules
     * <p>
     * Receive a list of up to 100 IssuingStockRule objects registered to your workspace in the Stark Infra API. and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["active", "canceled"]
     * stockIds [list of strings, default null]: list of IssuingStock ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["card", "corporate"]
     * <p>
     * Return:
     * @return IssuingStockRule.Page object:
     * IssuingStockRule.Page.rules: list of IssuingStockRule objects with updated attributes
     * IssuingStockRule.Page.cursor: cursor to retrieve the next page of IssuingStockRule objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingStockRules
     * <p>
     * Receive a list of up to 100 IssuingStockRule objects registered to your workspace in the Stark Infra API. and the cursor to the next page.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingStockRule.Page object:
     * IssuingStockRule.Page.rules: list of IssuingStockRule objects with updated attributes
     * IssuingStockRule.Page.cursor: cursor to retrieve the next page of IssuingStockRule objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingStockRules
     * <p>
     * Receive a list of up to 100 IssuingStockRule objects registered to your workspace in the Stark Infra API. and the cursor to the next page.
     * <p>
     * Return:
     * @return IssuingStockRule.Page object:
     * IssuingStockRule.Page.rules: list of IssuingStockRule objects with updated attributes
     * IssuingStockRule.Page.cursor: cursor to retrieve the next page of IssuingStockRule objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged IssuingStockRules
     * <p>
     * Receive a list of up to 100 IssuingStockRule objects registered to your workspace in the Stark Infra API. and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["active", "canceled"]
     * stockIds [list of strings, default null]: list of IssuingStock ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["card", "corporate"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingStockRule.Page object:
     * IssuingStockRule.Page.rules: list of IssuingStockRule objects with updated attributes
     * IssuingStockRule.Page.cursor: cursor to retrieve the next page of IssuingStockRule objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingStockRule> rules = new ArrayList<>();
        for (SubResource rule: page.entities) {
            rules.add((IssuingStockRule) rule);
        }
        return new Page(rules, page.cursor);
    }

    /**
     * Create IssuingStockRules
     * <p>
     * Send a list of IssuingStockRule objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param rules [list of IssuingStockRule objects or HashMaps]: list of IssuingStockRule objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of IssuingStockRule objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<IssuingStockRule> create(List<?> rules, User user) throws Exception {
        List<IssuingStockRule> ruleList = new ArrayList<>();
        for (Object rule : rules){
            if (rule instanceof Map){
                ruleList.add(new IssuingStockRule((Map<String, Object>) rule));
                continue;
            }
            if (rule instanceof IssuingStockRule){
                ruleList.add((IssuingStockRule) rule);
                continue;
            }
            throw new Exception("Unknown type \"" + rule.getClass() + "\", use IssuingStockRule or HashMap");
        }
        return Rest.post(data, ruleList, user);
    }

    /**
     * Create IssuingStockRules
     * <p>
     * Send a list of IssuingStockRule objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param rules [list of IssuingStockRule objects or HashMaps]: list of IssuingStockRule objects to be created in the API
     * <p>
     * Return:
     * @return list of IssuingStockRule objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<IssuingStockRule> create(List<?> rules) throws Exception {
        return IssuingStockRule.create(rules, null);
    }

    /**
     * Update IssuingStockRule entity
     * <p>
     * Update an IssuingStockRule by passing id.
     * <p>
     * Parameters:
     * @param id [string]: IssuingStockRule id. ex: "5664445921492992"
     * @param patchData map of parameters
     * minimumBalance [integer, default null]: new stock balance threshold that triggers a notification. ex: 20000
     * tags [list of strings, default null]: new list of strings for tagging. ex: ["card", "corporate"]
     * emails [list of strings, default null]: new list of emails to be notified. ex: ["john.doe@enterprise.com"]
     * phones [list of strings, default null]: new list of phones to be notified. ex: ["+55 (11) 91234 5678"]
     * user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingStockRule object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingStockRule update(String id, Map<String, Object> patchData) throws Exception {
        return IssuingStockRule.update(id, patchData, null);
    }

    /**
     * Update IssuingStockRule entity
     * <p>
     * Update an IssuingStockRule by passing id.
     * <p>
     * Parameters:
     * @param id [string]: IssuingStockRule id. ex: "5664445921492992"
     * @param patchData map of parameters
     * minimumBalance [integer, default null]: new stock balance threshold that triggers a notification. ex: 20000
     * tags [list of strings, default null]: new list of strings for tagging. ex: ["card", "corporate"]
     * emails [list of strings, default null]: new list of emails to be notified. ex: ["john.doe@enterprise.com"]
     * phones [list of strings, default null]: new list of phones to be notified. ex: ["+55 (11) 91234 5678"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingStockRule object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingStockRule update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    /**
     * Cancel an IssuingStockRule entity
     * <p>
     * Cancel an IssuingStockRule entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: IssuingStockRule unique id. ex: "5664445921492992"
     * <p>
     * Return:
     * @return canceled IssuingStockRule object
     * @throws Exception error in the request
     */
    public static IssuingStockRule cancel(String id) throws Exception {
        return IssuingStockRule.cancel(id, null);
    }

    /**
     * Cancel an IssuingStockRule entity
     * <p>
     * Cancel an IssuingStockRule entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: IssuingStockRule unique id. ex: "5664445921492992"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled IssuingStockRule object
     * @throws Exception error in the request
     */
    public static IssuingStockRule cancel(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }
}
