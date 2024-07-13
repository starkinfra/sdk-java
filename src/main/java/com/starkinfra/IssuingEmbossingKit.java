package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class IssuingEmbossingKit extends Resource {
    /**
     * IssuingEmbossingKit object
     * <p>
     * The IssuingEmbossingKit object displays the information of embossing requests in your Workspace.
     * <p>
     * Parameters:
     * id [string]: unique id returned when IssuingEmbossingKit is created. ex: "5656565656565656"
     * name [string]: embossing kit name. ex: "stark-plastic-dark-001"
     * designs [list of IssuingDesign objects]: list of IssuingDesign objects.
     * updated [string]: latest update datetime for the IssuingEmbossingKit. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingEmbossingKit. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(IssuingEmbossingKit.class, "IssuingEmbossingKit");

    public String name;
    public List<IssuingDesign> designs;
    public String updated;
    public String created;

    /**
     * IssuingEmbossingKit object
     * <p>
     * The IssuingEmbossingKit objects display information on the card embossing requests made in your Workspace.
     * <p>
     * Parameters:
     * @param id [string]: unique id returned when IssuingEmbossingKit is created. ex: "5656565656565656"
     * @param name [string]: embossing kit name. ex: "stark-plastic-dark-001"
     * @param designs [list of IssuingDesign objects]: list of IssuingDesign objects.
     * @param updated [string]: latest update datetime for the IssuingEmbossingKit. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the IssuingEmbossingKit. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public IssuingEmbossingKit(
            String id, String name, List<IssuingDesign> designs, String updated, String created
    ) {
        super(id);
        this.name = name;
        this.designs = designs;
        this.updated = updated;
        this.created = created;
    }

    /**
     * IssuingEmbossingKit object
     * <p>
     * The IssuingEmbossingKit object displays the information of the request orders created in your Workspace.
     * <p>
     * When you initialize a IssuingEmbossingKit, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when IssuingEmbossingKit is created. ex: "5656565656565656"
     * name [string]: embossing kit name. ex: "stark-plastic-dark-001"
     * designs [list of IssuingDesign objects]: list of IssuingDesign objects.
     * updated [string]: latest update datetime for the IssuingEmbossingKit. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the IssuingEmbossingKit. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public IssuingEmbossingKit(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.name = (String) dataCopy.remove("name");
        this.designs = parseDesigns((List<Object>) dataCopy.remove("designs"));
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    @SuppressWarnings("unchecked")
    public static List<IssuingDesign> parseDesigns(List<Object> designs) throws Exception {
        if (designs == null)
            return null;

        List<IssuingDesign> parsed = new ArrayList<>();
        if (designs.size() == 0 || designs.get(0) instanceof IssuingDesign) {
            for (Object design : designs) {
                parsed.add((IssuingDesign) design);
            }
            return parsed;
        }

        for (Object design : designs) {
            IssuingDesign designObject = new IssuingDesign((Map<String, Object>) design);
            parsed.add(designObject);
        }

        return parsed;
    }

    /**
     * Retrieve IssuingEmbossingKits
     * <p>
     * Receive a generator of IssuingEmbossingKit objects registered to your workspace in the Stark Infra API.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "processing", "success", "failed"]
     * designIds [list of string, default null]: list of designIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingEmbossingKit objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingEmbossingKit> query(Map<String, Object> params, User user) throws Exception{
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve IssuingEmbossingKits
     * <p>
     * Receive a generator of IssuingEmbossingKit objects registered to your workspace in the Stark Infra API.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "processing", "success", "failed"]
     * designIds [list of string, default null]: list of designIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of IssuingEmbossingKit objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingEmbossingKit> query(Map<String, Object> params) throws Exception{
        return Rest.getStream(data, params, null);
    }

    /**
     * Retrieve IssuingEmbossingKits
     * <p>
     * Receive a generator of IssuingEmbossingKit objects registered to your workspace in the Stark Infra API.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of IssuingEmbossingKit objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingEmbossingKit> query(User user) throws Exception{
        return Rest.getStream(data, new HashMap<>(), user);
    }


    /**
     * Retrieve IssuingEmbossingKits
     * <p>
     * Receive a generator of IssuingEmbossingKit objects registered to your workspace in the Stark Infra API.
     * <p>
     * Return:
     * @return generator of IssuingEmbossingKit objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<IssuingEmbossingKit> query() throws Exception{
        return Rest.getStream(data, new HashMap<>(), null);
    }

    public final static class Page {
        public List<IssuingEmbossingKit> kits;
        public String cursor;

        public Page(List<IssuingEmbossingKit> kits, String cursor) {
            this.kits = kits;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged IssuingEmbossingKits
     * <p>
     * Receive a list of up to 100 IssuingEmbossingKit objects registered to your workspace in the Stark Infra API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created only after specified date. ex: "2022-03-22"
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "processing", "success", "failed"]
     * designIds [list of string, default null]: list of designIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingEmbossingKit.Page object:
     * IssuingEmbossingKit.Page.requests: list of IssuingEmbossingKit objects with updated attributes
     * IssuingEmbossingKit.Page.cursor: cursor to retrieve the next page of IssuingEmbossingKit objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<IssuingEmbossingKit> requests = new ArrayList<>();
        for (SubResource card: page.entities) {
            requests.add((IssuingEmbossingKit) card);
        }
        return new Page(requests, page.cursor);
    }

    /**
     * Retrieve paged IssuingEmbossingKits
     * <p>
     * Receive a list of up to 100 IssuingEmbossingKit objects registered to your workspace in the Stark Infra API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param params map of parameters
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * before [string, default null]: date filter for objects created only before specified date. ex: "2022-03-22"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["created", "processing", "success", "failed"]
     * designIds [list of string, default null]: list of designIds to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return IssuingEmbossingKit.Page object:
     * IssuingEmbossingKit.Page.requests: list of IssuingEmbossingKit objects with updated attributes
     * IssuingEmbossingKit.Page.cursor: cursor to retrieve the next page of IssuingEmbossingKit objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String , Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged IssuingEmbossingKits
     * <p>
     * Receive a list of up to 100 IssuingEmbossingKit objects registered to your workspace in the Stark Infra API and the cursor to the next page.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingEmbossingKit.Page object:
     * IssuingEmbossingKit.Page.requests: list of IssuingEmbossingKit objects with updated attributes
     * IssuingEmbossingKit.Page.cursor: cursor to retrieve the next page of IssuingEmbossingKit objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged IssuingEmbossingKits
     * <p>
     * Receive a list of up to 100 IssuingEmbossingKit objects registered to your workspace in the Stark Infra API and the cursor to the next page.
     * <p>
     * Return:
     * @return IssuingEmbossingKit.Page object:
     * IssuingEmbossingKit.Page.requests: list of IssuingEmbossingKit objects with updated attributes
     * IssuingEmbossingKit.Page.cursor: cursor to retrieve the next page of IssuingEmbossingKit objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve a specific IssuingEmbossingKit
     * <p>
     * Receive a single IssuingEmbossingKit object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return IssuingEmbossingKit object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingEmbossingKit get(String id, User user) throws Exception{
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve a specific IssuingEmbossingKit
     * <p>
     * Receive a single IssuingEmbossingKit object previously created in the Stark Infra API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return IssuingEmbossingKit object with updated attributes
     * @throws Exception error in the request
     */
    public static IssuingEmbossingKit get(String id) throws Exception{
        return IssuingEmbossingKit.get(id, null);
    }

}
