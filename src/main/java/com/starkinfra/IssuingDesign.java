package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.io.InputStream;
import java.util.ArrayList;


public final class IssuingDesign extends Resource {
    /**
     * IssuingDesign object
     * <p>
     * The IssuingDesign object displays information on the card and card package designs available to your Workspace.
     * <p>
     * Parameters:
     * id [string]: unique id returned when IssuingDesign is created. ex: "5656565656565656"
     * name [string]: card or package design name. ex: 'stark-plastic-dark-001'
     * embosserIds [list of strings]: list of embosser unique ids. ex: ["5136459887542272", "5136459887542273"]
     * type [string]: card or package design type. Options: "card", "envelope"
     * updated [string]: latest update datetime for the IssuingDesign. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingDesign. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(IssuingDesign.class, "IssuingDesign");

    public String name;
    public String[] embosserIds;
    public String type;
    public String updated;
    public String created;

    /**
     * IssuingDesign object
     * <p>
     * The IssuingDesign object displays information on the card and card package designs available to your Workspace.
     * <p>
     * Parameters:
     * @param id [string]: unique id returned when IssuingDesign is created. ex: "5656565656565656"
     * @param name [string]: card or package design name. ex: 'stark-plastic-dark-001'
     * @param embosserIds [list of strings]: list of embosser unique ids. ex: ["5136459887542272", "5136459887542273"]
     * @param type [string]: card or package design type. Options: "card", "envelope"
     * @param updated [string]: latest update datetime for the IssuingDesign. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the IssuingDesign. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingDesign(
        String id, String name, String[] embosserIds, String type, String updated, String created
    ) {
        super(id);
        this.name = name;
        this.embosserIds = embosserIds;
        this.type = type;
        this.updated = updated;
        this.created = created;
    }

    /**
     * IssuingDesign object
     * <p>
     * The IssuingDesign object displays information on the card and card package designs available to your Workspace.
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when IssuingDesign is created. ex: "5656565656565656"
     * name [string]: card or package design name. ex: 'stark-plastic-dark-001'
     * embosserIds [list of strings]: list of embosser unique ids. ex: ["5136459887542272", "5136459887542273"]
     * type [string]: card or package design type. Options: "card", "envelope"
     * updated [string]: latest update datetime for the IssuingDesign. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingDesign. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public IssuingDesign(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.name = null;
        this.embosserIds = null;
        this.type = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve IssuingDesigns
     * <p>
     * Receive a generator of IssuingDesign objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingDesign objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingDesign> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IssuingDesigns
     * <p>
     * Receive a generator of IssuingDesign objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of IssuingDesign objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingDesign> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IssuingDesigns
     * <p>
     * Receive a generator of IssuingDesign objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingDesign objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingDesign> query(User user) throws Exception{
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingDesigns
     * <p>
     * Receive a generator of IssuingDesign objects previously created in the Stark Infra API
     * <p>
     * Return:
     * @return generator of IssuingDesign objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingDesign> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IssuingDesign> designs;
        public String cursor;

        public Page(List<IssuingDesign> designs, String cursor) {
            this.designs = designs;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingDesigns
     * <p>
     * Receive a list of up to 100 IssuingDesign objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingDesign.Page object:
     * IssuingDesign.Page.designs: list of IssuingDesign objects with updated attributes
     * IssuingDesign.Page.cursor: cursor to retrieve the next page of IssuingDesign objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingDesign> designs = new ArrayList<>();
        for (SubResource design : page.entities) {
            designs.add((IssuingDesign) design);
        }
        return new Page(designs, page.cursor);
    }

    /**
     * Retrieve paged IssuingDesigns
     * <p>
     * Receive a list of up to 100 IssuingDesign objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return IssuingDesign.Page object:
     * IssuingDesign.Page.designs: list of IssuingDesign objects with updated attributes
     * IssuingDesign.Page.cursor: cursor to retrieve the next page of IssuingDesign objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingDesigns
     * <p>
     * Receive a list of up to 100 IssuingDesign objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingDesign.Page object:
     * IssuingDesign.Page.designs: list of IssuingDesign objects with updated attributes
     * IssuingDesign.Page.cursor: cursor to retrieve the next page of IssuingDesign objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingDesigns
     * <p>
     * Receive a list of up to 100 IssuingDesign objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return IssuingDesign.Page object:
     * IssuingDesign.Page.designs: list of IssuingDesign objects with updated attributes
     * IssuingDesign.Page.cursor: cursor to retrieve the next page of IssuingDesign objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve a specific IssuingDesign
     * <p>
     * Receive a single IssuingDesign object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingDesign object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingDesign get(String id, User user) throws Exception{
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific IssuingDesign
     * <p>
     * Receive a single IssuingDesign object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingDesign object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingDesign get(String id) throws Exception{
        return IssuingDesign.get(id, null);
    }

    /**
     * Retrieve a specific IssuingDesign pdf file
     * <p>
     * Receive a single IssuingDesign pdf file generated in the Stark Infra API by passing its id.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingDesign pdf file
     * @throws Exception error in the request
     */
    public static InputStream pdf(String id) throws Exception {
        return IssuingDesign.pdf(id, null);
    }

    /**
     * Retrieve a specific IssuingDesign pdf file
     * <p>
     * Receive a single IssuingDesign pdf file generated in the Stark Infra API by passing its id.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return IssuingDesign pdf file
     * @throws Exception error in the request
     */
    public static InputStream pdf(String id, User user) throws Exception {
        return Rest.getContent(data, id, "pdf", user, new HashMap<>());
    }
}
