package com.starkinfra;

import com.starkinfra.utils.Resource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IssuingRule extends Resource {

    /**
     * IssuingRule object
     * <p>
     * The IssuingRule object displays the spending rules of IssuingCards and IssuingHolders created in your Workspace.
     * <p>
     * Parameters:
     * name [string]: rule name. ex: "Travel" or "Food"
     * amount [Long]: maximum amount that can be spent in the informed interval. ex: 200000 (= R$ 2000.00)
     * id [string, default null]: unique id returned when an IssuingRule is created, used to update a specific IssuingRule. ex: "5656565656565656"
     * interval [string]: interval after which the rule amount counter will be reset to 0. ex: "instant", "day", "week", "month", "year" or "lifetime"
     * currencyCode [string, default "BRL"]: code of the currency that the rule amount refers to. ex: "BRL" or "USD"
     * categories [list of MerchantCategory objects, default []]: merchant categories accepted by the rule. ex: ["eatingPlacesRestaurants", "travelAgenciesTourOperators"]
     * countries [list of MerchantCountry objects, default []]: countries accepted by the rule. ex: ["BRA", "USA"]
     * methods [list of CardMethod objects, default []]: card purchase methods accepted by the rule. ex: ["contactless", "manual"]
     * counterAmount [Long]: current rule spent amount. ex: 1000
     * currencySymbol [string]: currency symbol. ex: "R$"
     * currencyName [string]: currency name. ex: "Brazilian Real"
     *
     */
    static ClassData data = new ClassData(IssuingRule.class, "IssuingRule");

    public String name;
    public Long amount;
    public String interval;
    public String currencyCode;
    public List<MerchantCategory> categories;
    public List<MerchantCountry> countries;
    public List<CardMethod> methods;
    public Number counterAmount;
    public String currencySymbol;
    public String currencyName;

    /**
     * IssuingRule object
     * <p>
     * The IssuingRule object displays the spending rules of IssuingCards and IssuingHolders created in your Workspace.
     * <p>
     * Parameters:
     * @param name [string]: rule name. ex: "Travel" or "Food"
     * @param amount [Long]: maximum amount that can be spent in the informed interval. ex: 200000 (= R$ 2000.00)
     * @param interval [string]: interval after which the rule amount counter will be reset to 0. ex: "instant", "day", "week", "month", "year" or "lifetime"
     * @param id [string]: unique id returned when an IssuingRule is created, used to update a specific IssuingRule. ex: "5656565656565656"
     * @param currencyCode [string, default "BRL"]: code of the currency that the rule amount refers to. ex: "BRL" or "USD"
     * @param categories [list of MerchantCategory objects, default []]: merchant categories accepted by the rule. ex: ["eatingPlacesRestaurants", "travelAgenciesTourOperators"]
     * @param countries [list of MerchantCountry objects, default []]: countries accepted by the rule. ex: ["BRA", "USA"]
     * @param methods [list of CardMethod objects, default []]: card purchase methods accepted by the rule. ex: ["contactless", "manual"]
     * @param counterAmount [Long]: current rule spent amount. ex: 1000
     * @param currencySymbol [string]: currency symbol. ex: "R$"
     * @param currencyName [string]: currency name. ex: "Brazilian Real"
     */
    public IssuingRule(String id, String name, Long amount, String interval, String currencyCode,
                       List<MerchantCategory> categories, List<MerchantCountry> countries, List<CardMethod> methods,
                       Long counterAmount, String currencySymbol, String currencyName
    ) {
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
     * The IssuingRule object displays the spending rules of IssuingCards and IssuingHolders created in your Workspace.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the IssuingRule
     * name [string]: rule name. ex: "Travel" or "Food"
     * amount [Long]: maximum amount that can be spent in the informed interval. ex: 200000 (= R$ 2000.00)
     * <p>
     * Parameters (optional):
     * id [string, default null]: unique id returned when an IssuingRule is created, used to update a specific IssuingRule. ex: "5656565656565656"
     * interval [string, default "lifetime"]: interval after which the rule amount counter will be reset to 0. ex: "instant", "day", "week", "month", "year" or "lifetime"
     * currencyCode [string, default "BRL"]: code of the currency that the rule amount refers to. ex: "BRL" or "USD"
     * categories [list of MerchantCategory objects, default []]: merchant categories accepted by the rule. ex: ["eatingPlacesRestaurants", "travelAgenciesTourOperators"]
     * countries [list of MerchantCountry objects, default []]: countries accepted by the rule. ex: ["BRA", "USA"]
     * methods [list of CardMethod objects, default []]: card purchase methods accepted by the rule. ex: ["contactless", "manual"]
     * <p>
     * Attributes (expanded return-only):
     * counterAmount [Long]: current rule spent amount. ex: 1000
     * currencySymbol [string]: currency symbol. ex: "R$"
     * currencyName [string]: currency name. ex: "Brazilian Real"
     * @throws Exception error in the request
     */
    public IssuingRule(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.name = (String) dataCopy.remove("name");
        this.amount = ((Number) dataCopy.remove("amount")).longValue();
        this.interval = (String) dataCopy.remove("interval");
        this.currencyCode = (String) dataCopy.remove("currencyCode");
        this.categories = (List<MerchantCategory>) dataCopy.remove("categories");
        this.countries = (List<MerchantCountry>) dataCopy.remove("countries");
        this.methods = (List<CardMethod>)dataCopy.remove("methods");
        this.counterAmount = null;
        this.currencySymbol = null;
        this.currencyName = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    @SuppressWarnings("unchecked")
    static List<IssuingRule> parseRules(List<Object> rules) throws Exception {
        if (rules == null)
            return null;

        List<IssuingRule> parsed = new ArrayList<>();
        if (rules.size() == 0 || rules.get(0) instanceof IssuingRule) {
            for (Object rule : rules) {
                parsed.add((IssuingRule) rule);
            }
            return parsed;
        }

        for (Object rule : rules) {
            IssuingRule ruleObject = new IssuingRule((Map<String, Object>) rule);
            parsed.add(ruleObject);
        }

        return parsed;
    }
}
