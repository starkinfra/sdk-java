package com.starkinfra;

import com.starkinfra.utils.Resource;

import java.util.HashMap;
import java.util.Map;


public final class IssuingRule extends Resource {

    /**
     * IssuingRule object
     * <p>
     * The IssuingRule object displays the spending rules of IssuingCards and IssuingHolders created in your Workspace.
     * <p>
     * Parameters:
     * name           [string]: rule name. ex: "Travel" or "Food"
     * amount         [integer]: maximum amount that can be spent in the informed interval. ex: 200000 (= R$ 2000.00)
     * interval       [string]: interval after which the rule amount counter will be reset to 0. ex: "instant", "day", "week", "month", "year" or "lifetime"
     * currencyCode   [string, default "BRL"]: code of the currency that the rule amount refers to. ex: "BRL" or "USD"
     * categories     [list of strings, default []]: merchant categories accepted by the rule. ex: ["eatingPlacesRestaurants", "travelAgenciesTourOperators"]
     * countries      [list of strings, default []]: countries accepted by the rule. ex: ["BRA", "USA"]
     * methods        [list of strings, default []]: card purchase methods accepted by the rule. ex: ["contactless", "manual"]
     * counterAmount  [number]: current rule spent amount. ex: 1000
     * currencySymbol [string]: currency symbol. ex: "R$"
     * currencyName   [string]: currency name. ex: "Brazilian Real"
     * id             [string]: unique id returned when the rule is created. ex: "5656565656565656"
     */
    static ClassData data = new ClassData(IssuingRule.class, "IssuingRule");

    public String name;
    public long amount;
    public String interval;
    public String currencyCode;
    public String[] categories;
    public String[] countries;
    public String[] methods;
    public Number counterAmount;
    public String currencySymbol;
    public String currencyName;

    /**
     * IssuingRule object
     * <p>
     * Describes pre-configured rules to filter your approvals.
     * <p>
     * Parameters:
     * @param name [string]: rule name. ex: "Travel" or "Food"
     * @param amount [integer]: maximum amount that can be spent in the informed interval. ex: 200000 (= R$ 2000.00)
     * @param interval [string]: interval after which the rule amount counter will be reset to 0. ex: "instant", "day", "week", "month", "year" or "lifetime"
     * @param currencyCode [string, default "BRL"]: code of the currency that the rule amount refers to. ex: "BRL" or "USD"
     * @param categories [list of strings, default []]: merchant categories accepted by the rule. ex: ["eatingPlacesRestaurants", "travelAgenciesTourOperators"]
     * @param countries [list of strings, default []]: countries accepted by the rule. ex: ["BRA", "USA"]
     * @param methods [list of strings, default []]: card purchase methods accepted by the rule. ex: ["contactless", "manual"]
     * @param counterAmount [number]: current rule spent amount. ex: 1000
     * @param currencySymbol [string]: currency symbol. ex: "R$"
     * @param currencyName [string]: currency name. ex: "Brazilian Real"
     * @param id [string]: unique id returned when the rule is created. ex: "5656565656565656"
     */
    public IssuingRule(String id, String name, long amount, String interval, String currencyCode, String[] categories, String[] countries, String[] methods, Number counterAmount, String currencySymbol, String currencyName){
        super(id);
        this.name = name;
        this.amount = amount;
        this.interval = interval;
        this.currencyCode = currencyCode;
        this.categories = categories;
        this.countries = countries;
        this.methods = methods;
        this.counterAmount = counterAmount;
        this.currencySymbol = currencySymbol;
        this.currencyName = currencyName;
    }

    /**
     * IssuingRule object
     * <p>
     * When you initialize an IssuingRule, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the IssuingRule
     * name         [string]: rule name. ex: "Travel" or "Food"
     * amount       [integer]: maximum amount that can be spent in the informed interval. ex: 200000 (= R$ 2000.00)
     * interval     [string]: interval after which the rule amount counter will be reset to 0. ex: "instant", "day", "week", "month", "year" or "lifetime"
     * <p>
     * Parameters (optional):
     * currencyCode [string, default "BRL"]: code of the currency that the rule amount refers to. ex: "BRL" or "USD"
     * categories   [list of strings, default []]: merchant categories accepted by the rule. ex: ["eatingPlacesRestaurants", "travelAgenciesTourOperators"]
     * countries    [list of strings, default []]: countries accepted by the rule. ex: ["BRA", "USA"]
     * methods      [list of strings, default []]: card purchase methods accepted by the rule. ex: ["contactless", "manual"]
     * <p>
     * Attributes (expanded return-only):
     * counterAmount  [number]: current rule spent amount. ex: 1000
     * currencySymbol [string]: currency symbol. ex: "R$"
     * currencyName   [string]: currency name. ex: "Brazilian Real"
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when Rule is created. ex: "5656565656565656"
     * @throws Exception error in the request
     */

    public IssuingRule(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.name = (String) dataCopy.remove("name");
        this.amount = ((Number) dataCopy.remove("amount")).longValue();
        this.interval = (String) dataCopy.remove("interval");
        this.currencyCode = (String) dataCopy.remove("currencyCode");
        this.categories = (String[]) dataCopy.remove("categories");
        this.countries = (String[]) dataCopy.remove("countries");
        this.methods = (String[]) dataCopy.remove("methods");
        this.counterAmount = null;
        this.currencySymbol = null;
        this.currencyName = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }
}
