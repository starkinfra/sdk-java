package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class StaticBrcode extends Resource {
    /**
     * StaticBrcode object
     * <p>
     * A StaticBrcode stores account information in the form of a PixKey and can be used to create
     * Pix transactions easily.
     * <p>
     * When you initialize a StaticBrcode, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * <p>
     * Parameters:
     * name [string]: receiver's name. ex: "Tony Stark"
     * keyId [string]: receiver's Pixkey id. ex: "+5541999999999"
     * city [string, default "Sao Paulo"]: receiver's city name. ex: "Rio de Janeiro"
     * amount [integer, default 0]: positive integer that represents the amount in cents of the resulting Pix transaction. If the amount is zero, the sender can choose any amount in the moment of payment. ex: 1234 (= R$ 12.34)
     * cashierBankCode [string, default ""] Cashier's bank code. ex: "20018183".
     * description [string, default ""]: Optional description to override default description to be shown in the bank statement. ex: "Payment for service #1234"
     * reconciliationId [string, default ""]: id to be used for conciliation of the resulting Pix transaction. This id must have up to 25 alphanumeric characters' ex: "cd65c78aeb6543eaaa017"
     * tags [list of strings, default []]: list of strings for tagging. ex: ["travel", "food"]
     * id [string]: id returned on creation, this is the BR Code. ex: "00020126360014br.gov.bcb.pix0114+552840092118152040000530398654040.095802BR5915Jamie Lannister6009Sao Paulo620705038566304FC6C"
     * uuid [string]: unique uuid returned when a StaticBrcode is created. ex: "97756273400d42ce9086404fe10ea0d6"
     * url [string]: url link to the BR Code image. ex: "https://brcode-h.development.starkinfra.com/static-qrcode/97756273400d42ce9086404fe10ea0d6.png"
     * created [string]: creation datetime for the StaticBrcode. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the StaticBrcode. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(StaticBrcode.class, "StaticBrcode");

    public String name;
    public String keyId;
    public String city;
    public Long amount;
    public String cashierBankCode;
    public String description;
    public String reconciliationId;
    public String[] tags;
    public String uuid;
    public String url;
    public String created;
    public String updated;

    /**
     * StaticBrcode object
     * <p>
     * A StaticBrcode stores account information in the form of a PixKey and can be used to create
     * Pix transactions easily.
     * <p>
     * When you initialize a StaticBrcode, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * <p>
     * Parameters:
     * @param name [string]: receiver's name. ex: "Tony Stark"
     * @param keyId [string]: receiver's Pixkey id. ex: "+5541999999999"
     * @param city [string]: receiver's city name. ex: "Rio de Janeiro"
     * @param amount [Long]: positive integer that represents the amount in cents of the resulting Pix transaction. ex: 1234 (= R$ 12.34)
     * @param cashierBankCode [string, default ""] Cashier's bank code. ex: "20018183".
     * @param description [string, default ""]: Optional description to override default description to be shown in the bank statement. ex: "Payment for service #1234"
     * @param reconciliationId [string, default ""]: id to be used for conciliation of the resulting Pix transaction. This id must have up to 25 alphanumeric characters. ex: "ah27s53agj6493hjds6836v49"
     * @param tags [list of strings, default []]: list of strings for tagging. ex: ["travel", "food"]
     * @param id [string]: id returned on creation, this is the BR Code. ex: "00020126360014br.gov.bcb.pix0114+552840092118152040000530398654040.095802BR5915Jamie Lannister6009Sao Paulo620705038566304FC6C"
     * @param uuid [string]: unique uuid returned when a StaticBrcode is created. ex: "97756273400d42ce9086404fe10ea0d6"
     * @param url [string]: url link to the BR Code image. ex: "https://brcode-h.development.starkinfra.com/static-qrcode/97756273400d42ce9086404fe10ea0d6.png"
     * @param created [string]: creation datetime for the StaticBrcode. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the StaticBrcode. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public StaticBrcode(String name, String city, String keyId, Long amount, String cashierBankCode, String description,
                        String id, String reconciliationId, String[] tags, String uuid, String url, String created,
                        String updated
    ) {
        super(id);
        this.name = name;
        this.keyId = keyId;
        this.city = city;
        this.amount = amount;
        this.cashierBankCode = cashierBankCode;
        this.description = description;
        this.reconciliationId = reconciliationId;
        this.tags = tags;
        this.uuid = uuid;
        this.url = url;
        this.created = created;
        this.updated = updated;
    }

    /**
     * StaticBrcode object
     * <p>
     * A StaticBrcode stores account information in the form of a PixKey and can be used to create
     * Pix transactions easily.
     * <p>
     * When you initialize a StaticBrcode, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the StaticBrcode
     * name [string]: receiver's name. ex: "Tony Stark"
     * keyId [string]: receiver's Pixkey id. ex: "+5541999999999"
     * city [string, default São Paulo]: receiver's city name. ex: "Rio de Janeiro"
     * <p>
     * Parameters (optional):
     * amount [Long, default 0]: positive integer that represents the amount in cents of the resulting Pix transaction. ex: 1234 (= R$ 12.34)
     * cashierBankCode [string, default ""] Cashier's bank code. ex: "20018183".
     * description [string, default ""]: Optional description to override default description to be shown in the bank statement. ex: "Payment for service #1234"
     * reconciliationId [string, default ""]: id to be used for conciliation of the resulting Pix transaction. This id must have up to 25 alphanumeric characters. ex: "ah27s53agj6493hjds6836v49"
     * tags [list of strings, default []]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Attributes (return-only):
     * id [string]: id returned on creation, this is the BR Code. ex: "00020126360014br.gov.bcb.pix0114+552840092118152040000530398654040.095802BR5915Jamie Lannister6009Sao Paulo620705038566304FC6C"
     * uuid [string]: unique uuid returned when a StaticBrcode is created. ex: "97756273400d42ce9086404fe10ea0d6"
     * url [string]: url link to the BR Code image. ex: "https://brcode-h.development.starkinfra.com/static-qrcode/97756273400d42ce9086404fe10ea0d6.png"
     * created [string]: creation datetime for the StaticBrcode. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the StaticBrcode. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public StaticBrcode(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.name = (String) dataCopy.remove("name");
        this.keyId = (String) dataCopy.remove("keyId");
        this.city = (String) dataCopy.remove("city");
        this.amount = ((Number) dataCopy.remove("amount")).longValue();
        this.cashierBankCode = (String) dataCopy.remove("cashierBankCode");
        this.description = (String) dataCopy.remove("description");
        this.reconciliationId = (String) dataCopy.remove("reconciliationId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.uuid = null;
        this.url = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific StaticBrcode
     * <p>
     * Receive a single StaticBrcode object previously created in the Stark Infra API by its uuid
     * <p>
     * Parameters:
     * @param uuid [string]: object's unique uuid. ex: "97756273400d42ce9086404fe10ea0d6"
     * <p>
     * Return:
     * @return StaticBrcode object with updated attributes
     * @throws Exception error in the request
     */
    public static StaticBrcode get(String uuid) throws Exception {
        return StaticBrcode.get(uuid, null);
    }

    /**
     * Retrieve a specific StaticBrcode
     * <p>
     * Receive a single StaticBrcode object previously created in the Stark Infra API by its uuid
     * <p>
     * Parameters:
     * @param uuid [string]: oobject's unique uuid. ex: "97756273400d42ce9086404fe10ea0d6"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return StaticBrcode object with updated attributes
     * @throws Exception error in the request
     */
    public static StaticBrcode get(String uuid, User user) throws Exception {
        return Rest.getId(data, uuid, user);
    }

    /**
     * Retrieve StaticBrcodes
     * <p>
     * Receive a generator of StaticBrcode objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * uuids [list of strings, default null]: list of uuids to filter retrieved objects. ex: ["97756273400d42ce9086404fe10ea0d6", "e3da0b6d56fa4045b9b295b2be82436e"]
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * <p>
     * Return:
     * @return generator of StaticBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<StaticBrcode> query(Map<String, Object> params) throws Exception {
        return StaticBrcode.query(params, null);
    }

    /**
     * Retrieve StaticBrcodes
     * <p>
     * Receive a generator of StaticBrcode objects previously created in the Stark Infra API
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of StaticBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<StaticBrcode> query(User user) throws Exception {
        return StaticBrcode.query(new HashMap<>(), user);
    }

    /**
     * Retrieve StaticBrcodes
     * <p>
     * Receive a generator of StaticBrcode objects previously created in the Stark Infra API
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of StaticBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<StaticBrcode> query() throws Exception {
        return StaticBrcode.query(new HashMap<>(), null);
    }

    /**
     * Retrieve StaticBrcodes
     * <p>
     * Receive a generator of StaticBrcode objects previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * uuids [list of strings, default null]: list of uuids to filter retrieved objects. ex: ["97756273400d42ce9086404fe10ea0d6", "e3da0b6d56fa4045b9b295b2be82436e"]
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of StaticBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<StaticBrcode> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<StaticBrcode> brcodes;
        public String cursor;

        public Page(List<StaticBrcode> brcodes, String cursor) {
            this.brcodes = brcodes;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged StaticBrcodes
     * <p>
     * Receive a list of StaticBrcode objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * uuids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return StaticBrcode.Page object:
     * StaticBrcode.Page.brcodes: list of StaticBrcode objects with updated attributes
     * StaticBrcode.Page.cursor: cursor to retrieve the next page of StaticBrcode objects
     * @throws Exception error in the request
     */
    public static StaticBrcode.Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged StaticBrcodes
     * <p>
     * Receive a list of StaticBrcode objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return StaticBrcode.Page object:
     * StaticBrcode.Page.brcodes: list of StaticBrcode objects with updated attributes
     * StaticBrcode.Page.cursor: cursor to retrieve the next page of StaticBrcode objects
     * @throws Exception error in the request
     */
    public static StaticBrcode.Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged StaticBrcodes
     * <p>
     * Receive a list of StaticBrcode objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return StaticBrcode.Page object:
     * StaticBrcode.Page.brcodes: list of StaticBrcode objects with updated attributes
     * StaticBrcode.Page.cursor: cursor to retrieve the next page of StaticBrcode objects
     * @throws Exception error in the request
     */
    public static StaticBrcode.Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged StaticBrcodes
     * <p>
     * Receive a list of StaticBrcode objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * uuids [list of strings, default null]: list of uuids to filter retrieved objects. ex: ["97756273400d42ce9086404fe10ea0d6", "e3da0b6d56fa4045b9b295b2be82436e"]
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return StaticBrcode.Page object:
     * StaticBrcode.Page.brcodes: list of StaticBrcode objects with updated attributes
     * StaticBrcode.Page.cursor: cursor to retrieve the next page of StaticBrcode objects
     * @throws Exception error in the request
     */
    public static StaticBrcode.Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<StaticBrcode> brcodes = new ArrayList<>();
        for (SubResource brcode: page.entities) {
            brcodes.add((StaticBrcode) brcode);
        }
        return new StaticBrcode.Page(brcodes, page.cursor);
    }

    /**
     * Create StaticBrcodes
     * <p>
     * Send a list of StaticBrcode objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param brcodes [list of StaticBrcode objects or HashMaps]: list of StaticBrcode objects to be created in the API
     * <p>
     * Return:
     * @return list of StaticBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<StaticBrcode> create(List<?> brcodes) throws Exception {
        return StaticBrcode.create(brcodes, null);
    }

    /**
     * Create StaticBrcodes
     * <p>
     * Send a list of StaticBrcode objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param brcodes [list of StaticBrcode objects or HashMaps]: list of StaticBrcode objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of StaticBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<StaticBrcode> create(List<?> brcodes, User user) throws Exception {
        List<StaticBrcode> brcodeList = new ArrayList<>();
        for (Object brcode : brcodes){
            if (brcode instanceof Map){
                brcodeList.add(new StaticBrcode((Map<String, Object>) brcode));
                continue;
            }
            if (brcode instanceof StaticBrcode){
                brcodeList.add((StaticBrcode) brcode);
                continue;
            }
            throw new Exception("Unknown type \"" + brcode.getClass() + "\", use StaticBrcode or HashMap");
        }
        return Rest.post(data, brcodeList, user);
    }
}
