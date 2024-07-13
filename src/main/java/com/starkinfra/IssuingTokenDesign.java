package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.InputStream;

public class IssuingTokenDesign extends Resource {
    /**
     * IssuingTokenDesign object
     * <p>
     * The IssuingTokenDesign object displays the information of the token designs created in your Workspace.
     * This resource represents the existent designs for the cards which will be tokenized.
     * <p>
     * Parameters:
     * id [string]: unique id returned when IssuingTokenDesign is created. ex: "5656565656565656"
     * name [string]: design name. ex: "Stark Bank - White Metal"
     * created [string]: creation datetime for the IssuingTokenDesign. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the IssuingTokenDesign. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(IssuingTokenDesign.class, "IssuingTokenDesign");

    public String name;
    public String created;
    public String updated;

    /**
     * IssuingTokenDesign object
     * <p>
     * The IssuingTokenDesign object displays the information of the token designs created in your Workspace.
     * This resource represents the existent designs for the cards which will be tokenized.
     * <p>
     * When you initialize a IssuingTokenDesign, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * @param id [string]: unique id returned when IssuingTokenDesign is created. ex: "5656565656565656"
     * @param name [string]: design name. ex: "Stark Bank - White Metal"
     * @param created [string]: creation datetime for the IssuingTokenDesign. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the IssuingTokenDesign. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingTokenDesign(String id, String name, String created, String updated
    ) {
        super(id);
        this.name = name;
        this.created = created;
        this.updated = updated;
    }

    /**
     * IssuingTokenDesign object
     * <p>
     * The IssuingTokenDesign object displays the information of the token designs created in your Workspace.
     * This resource represents the existent designs for the cards which will be tokenized.
     * Attributes (return-only):
     * id [string]: unique id returned when IssuingTokenDesign is created. ex: "5656565656565656"
     * name [string]: design name. ex: "Stark Bank - White Metal"
     * created [string]: creation datetime for the IssuingTokenDesign. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the IssuingTokenDesign. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public IssuingTokenDesign(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.name = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific IssuingTokenDesign
     * <p>
     * Receive a single IssuingTokenDesign object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingTokenDesign object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingTokenDesign get(String id) throws Exception{
        return IssuingTokenDesign.get(id, null);
    }

    /**
     * Retrieve a specific IssuingTokenDesign
     * <p>
     * Receive a single IssuingTokenDesign object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingTokenDesign object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingTokenDesign get(String id, User user) throws Exception{
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve IssuingTokenDesign
     * <p>
     * Receive a generator of IssuingTokenDesign objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingTokenDesign objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingTokenDesign> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IssuingTokenDesigns
     * <p>
     * Receive a generator of IssuingTokenDesign objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingTokenDesign objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingTokenDesign> query(User user) throws Exception{
        return Rest.getStream(data, new HashMap<>(), user);
    }

    /**
     * Retrieve IssuingTokenDesigns
     * <p>
     * Receive a generator of IssuingTokenDesign objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of IssuingTokenDesign objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingTokenDesign> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IssuingTokenDesigns
     * <p>
     * Receive a generator of IssuingTokenDesign objects previously created in the Stark Infra API
     * <p>
     * Return:
     * @return generator of IssuingTokenDesign objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingTokenDesign> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IssuingTokenDesign> tokenDesigns;
        public String cursor;

        public Page(List<IssuingTokenDesign> tokenDesigns, String cursor) {
            this.tokenDesigns = tokenDesigns;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingTokenDesigns
     * <p>
     * Receive a list of up to 100 IssuingTokenDesign objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your Designs.
     * <p>
     * Return:
     * @return IssuingTokenDesign.Page object:
     * IssuingTokenDesign.Page.tokenDesigns: list of IssuingTokenDesign objects with updated attributes
     * IssuingTokenDesign.Page.cursor: cursor to retrieve the next page of IssuingTokenDesign objects
     * @throws Exception error in the request
     */
    public static IssuingTokenDesign.Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged IssuingTokenDesigns
     * <p>
     * Receive a list of up to 100 IssuingTokenDesign objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your Designs.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return IssuingTokenDesign.Page object:
     * IssuingTokenDesign.Page.tokenDesigns: list of IssuingTokenDesign objects with updated attributes
     * IssuingTokenDesign.Page.cursor: cursor to retrieve the next page of IssuingTokenDesign objects
     * @throws Exception error in the request
     */
    public static IssuingTokenDesign.Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingTokenDesigns
     * <p>
     * Receive a list of up to 100 IssuingTokenDesign objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your Designs.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingTokenDesign.Page object:
     * IssuingTokenDesign.Page.tokenDesigns: list of IssuingTokenDesign objects with updated attributes
     * IssuingTokenDesign.Page.cursor: cursor to retrieve the next page of IssuingTokenDesign objects
     * @throws Exception error in the request
     */
    public static IssuingTokenDesign.Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingTokenDesigns
     * <p>
     * Receive a list of up to 100 IssuingTokenDesign objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your Designs.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default None]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingTokenDesign.Page object:
     * IssuingTokenDesign.Page.tokenDesigns: list of IssuingTokenDesign objects with updated attributes
     * IssuingTokenDesign.Page.cursor: cursor to retrieve the next page of IssuingTokenDesign objects
     * @throws Exception error in the request
     */
    public static IssuingTokenDesign.Page page(Map<String , Object> params, User user) throws Exception {

        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingTokenDesign> tokenDesigns = new ArrayList<>();
        for (SubResource tokenDesign: page.entities) {
            tokenDesigns.add((IssuingTokenDesign) tokenDesign);
        }
        return new IssuingTokenDesign.Page(tokenDesigns, page.cursor);
    }

    /**
     * Retrieve a specific IssuingTokenDesign pdf file
     * <p>
     * Receive a single IssuingTokenDesign pdf file generated in the Stark Infra API by its id.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingTokenDesign pdf file
     * @throws Exception error in the request
     */
    public static InputStream pdf(String id) throws Exception {
        return IssuingDesign.pdf(id, null);
    }

    /**
     * Retrieve a specific IssuingTokenDesign pdf file
     * <p>
     * Receive a single IssuingTokenDesign pdf file generated in the Stark Infra API by its id.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return IssuingTokenDesign pdf file
     * @throws Exception error in the request
     */
    public static InputStream pdf(String id, User user) throws Exception {
        return Rest.getContent(data, id, "pdf", user, new HashMap<>());
    }
}
