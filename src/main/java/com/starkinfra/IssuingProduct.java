package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IssuingProduct extends Resource {
    /**
     * IssuingProduct object
     * <p>
     * The IssuingProduct object displays information of available card products registered to your Workspace.
     * They represent a group of cards that begin with the same numbers (BIN) and offer the same product to end customers.
     * <p>
     * Parameters:
     * id [string]: unique card product number (BIN) registered within the card network. ex: "53810200"
     * network [string]: card network flag. ex: "mastercard"
     * fundingType [string]: type of funding used for payment. ex: "credit", "debit"
     * holderType [string]: holder type. ex: "business", "individual"
     * code [string]: internal code from card flag informing the product. ex: "MRW", "MCO", "MWB", "MCS"
     * created [string]: creation datetime for the IssuingProduct. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(IssuingProduct.class, "IssuingProduct");

    public String network;
    public String fundingType;
    public String holderType;
    public String code;
    public String created;

    /**
     * IssuingProduct object
     * <p>
     * The IssuingProduct object displays information of available card products registered to your Workspace.
     * <p>
     * Parameters:
     * @param id [string]: unique card product number (BIN) registered within the card network. ex: "53810200"
     * @param network [string]: card network flag. ex: "mastercard"
     * @param fundingType [string]: type of funding used for payment. ex: "credit", "debit"
     * @param holderType [string]: holder type. ex: "business", "individual"
     * @param code [string]: internal code from card flag informing the product. ex: "MRW", "MCO", "MWB", "MCS"
     * @param created [string]: creation datetime for the IssuingProduct. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingProduct(String id, String network, String fundingType, String code, String holderType, String created) {
        super(id);
        this.network = network;
        this.fundingType = fundingType;
        this.code = code;
        this.holderType = holderType;
        this.created = created;
    }

    /**
     * IssuingProduct object
     * <p>
     * The IssuingProduct object displays information of available card products registered to your Workspace.
     * <p>
     * Attributes (return-only):
     * id [string]: unique card product number (BIN) registered within the card network. ex: "53810200"
     * network [string]: card network flag. ex: "mastercard"
     * fundingType [string]: type of funding used for payment. ex: "credit", "debit"
     * holderType [string]: holder type. ex: "business", "individual"
     * code [string]: internal code from card flag informing the product. ex: "MRW", "MCO", "MWB", "MCS"
     * created [string]: creation datetime for the IssuingProduct. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public IssuingProduct(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.network = null;
        this.fundingType = null;
        this.code = null;
        this.holderType = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve IssuingProducts
     * <p>
     * Receive a generator of available IssuingProduct objects registered to your workspace.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingProduct objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingProduct> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IssuingProducts
     * <p>
     * Receive a generator of available IssuingProduct objects registered to your workspace.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * <p>
     * Return:
     * @return generator of IssuingProduct objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingProduct> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IssuingProducts
     * <p>
     * Receive a generator of available IssuingProduct objects registered to your workspace.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingProduct objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingProduct> query(User user) throws Exception{
        return Rest.getStream(data, new HashMap<>(), user);
    }


    /**
     * Retrieve IssuingProducts
     * <p>
     * Receive a generator of available IssuingProduct objects registered to your workspace.
     * <p>
     * Return:
     * @return generator of IssuingProduct objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingProduct> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IssuingProduct> products;
        public String cursor;

        public Page(List<IssuingProduct> products, String cursor) {
            this.products = products;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingProducts
     * <p>
     * Receive a list of up to 100 IssuingProduct objects registered to your workspace in the Stark Infra API. and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingProduct.Page object:
     * IssuingProduct.Page.products: list of IssuingProduct objects with updated attributes
     * IssuingProduct.Page.cursor: cursor to IssuingProduct the next page of IssuingProduct objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingProduct> products = new ArrayList<>();
        for (SubResource product: page.entities) {
            products.add((IssuingProduct) product);
        }
        return new Page(products, page.cursor);
    }

    /**
     * Retrieve paged IssuingProducts
     * <p>
     * Receive a list of up to 100 IssuingProduct objects registered to your workspace in the Stark Infra API. and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * <p>
     * Return:
     * @return IssuingProduct.Page object:
     * IssuingProduct.Page.products: list of IssuingProduct objects with updated attributes
     * IssuingProduct.Page.cursor: cursor to IssuingProduct the next page of IssuingProduct objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingProducts
     * <p>
     * Receive a list of up to 100 IssuingProduct objects registered to your workspace in the Stark Infra API. and the cursor to the next page.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingProduct.Page object:
     * IssuingProduct.Page.products: list of IssuingProduct objects with updated attributes
     * IssuingProduct.Page.cursor: cursor to IssuingProduct the next page of IssuingProduct objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingProducts
     * <p>
     * Receive a list of up to 100 IssuingProduct objects registered to your workspace in the Stark Infra API. and the cursor to the next page.
     * <p>
     * Return:
     * @return IssuingProduct.Page object:
     * IssuingProduct.Page.products: list of IssuingProduct objects with updated attributes
     * IssuingProduct.Page.cursor: cursor to IssuingProduct the next page of IssuingProduct objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }
}
