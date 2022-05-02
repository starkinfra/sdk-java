package com.starkinfra;

import com.starkinfra.utils.Generator;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Rest;
import com.starkinfra.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class IssuingBin extends Resource {
    /**
     * IssuingBin object
     * <p>
     * The IssuingBin object displays the informations of BINs registered to your Workspace.
     * They represent a group of cards that begin with the same numbers (BIN) and offer the same product to end customers.
     * <p>
     * Attributes (return-only):
     * id           [string]: unique BIN number registered within the card network. ex: "53810200"
     * network      [string]: card network flag. ex: "mastercard"
     * settlement   [string]: settlement type. ex: "credit"
     * category     [string]: purchase category. ex: "prepaid"
     * client       [string]: client type. ex: "business"
     * updated      [string]: latest update datetime for the Bin. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(IssuingBin.class, "IssuingBin");

    public String network;
    public String settlement;
    public String category;
    public String client;
    public String updated;
    public String created;

    /**
     * IssuingBin object
     * <p>
     * The IssuingBin object displays the information of BINs registered to your Workspace.
     * <p>
     * Attributes (return-only):
     * @param id            [string]: unique BIN number registered within the card network. ex: "53810200"
     * @param network       [string]: card network flag. ex: "mastercard"
     * @param settlement    [string]: settlement type. ex: "credit"
     * @param category      [string]: purchase category. ex: "prepaid"
     * @param client        [string]: client type. ex: "business"
     * @param updated       [string]: latest update datetime for the Bin. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingBin(String id, String network, String settlement, String category, String client, String updated, String created){
        super(id);
        this.network = network;
        this.settlement = settlement;
        this.category = category;
        this.client = client;
        this.updated = updated;
        this.created = created;
    }

    /**
     * IssuingBin object
     * <p>
     * The IssuingBin object displays the information of BINs registered to your Workspace.
     * <p>
     * Attributes (return-only):
     * id [string]: unique BIN number registered within the card network. ex: "53810200"
     * network [string]: card network flag. ex: "mastercard"
     * settlement [string]: settlement type. ex: "credit"
     * category [string]: purchase category. ex: "prepaid"
     * client [string]: client type. ex: "business"
     * updated [string]: latest update datetime for the Bin. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public IssuingBin(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.network = null;
        this.settlement = null;
        this.category = null;
        this.client = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve IssuingBins
     * <p>
     * Receive a generator of IssuingBin objects previously registered in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Invoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingBin> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IssuingBins
     * <p>
     * Receive a generator of IssuingBin objects previously registered in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * <p>
     * Return:
     * @return generator of Invoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingBin> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IssuingBins
     * <p>
     * Receive a generator of IssuingBin objects previously registered in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Invoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingBin> query(User user) throws Exception{
        return Rest.getStream(data,  new HashMap<>(), user);
    }


    /**
     * Retrieve IssuingBins
     * <p>
     * Receive a generator of IssuingBin objects previously registered in the Stark Bank API
     * <p>
     * Return:
     * @return generator of Invoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingBin> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IssuingBin> issuingBins;
        public String cursor;

        public Page(List<IssuingBin> issuingBins, String cursor) {
            this.issuingBins = issuingBins;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingBins
     * <p>
     * Receive a list of up to 100 IssuingBin objects previously registered in the Stark Bank API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default ""]: cursor returned on the previous page function call
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Invoice.Page object:
     * Invoice.Page.invoices: list of Invoice objects with updated attributes
     * Invoice.Page.cursor: cursor to retrieve the next page of Invoice objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingBin> issuingBins = new ArrayList<>();
        for (SubResource issuingBin: page.entities) {
            issuingBins.add((IssuingBin) issuingBin);
        }
        return new Page(issuingBins, page.cursor);
    }

    /**
     * Retrieve paged IssuingBins
     * <p>
     * Receive a list of up to 100 IssuingBin objects previously registered in the Stark Bank API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default ""]: cursor returned on the previous page function call
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * <p>
     * Return:
     * @return Invoice.Page object:
     * Invoice.Page.invoices: list of Invoice objects with updated attributes
     * Invoice.Page.cursor: cursor to retrieve the next page of Invoice objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingBins
     * <p>
     * Receive a list of up to 100 IssuingBin objects previously registered in the Stark Bank API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param user [Project object, default null]: Project object. Not necessary if StarkInfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return Invoice.Page object:
     * Invoice.Page.invoices: list of Invoice objects with updated attributes
     * Invoice.Page.cursor: cursor to retrieve the next page of Invoice objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingBins
     * <p>
     * Receive a list of up to 100 IssuingBin objects previously registered in the Stark Bank API and the cursor to the next page.
     * <p>
     * Return:
     * @return Invoice.Page object:
     * Invoice.Page.invoices: list of Invoice objects with updated attributes
     * Invoice.Page.cursor: cursor to retrieve the next page of Invoice objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }
}
