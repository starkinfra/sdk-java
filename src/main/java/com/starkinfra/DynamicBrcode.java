package com.starkinfra;

import com.google.gson.Gson;
import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Parse;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class DynamicBrcode extends Resource {
    /**
     * DynamicBrcode object
     * <p>
     * BR Codes store information represented by Pix QR Codes, which are used to
     * send or receive Pix transactions in a convenient way.
     * DynamicBrcodes represent charges with information that can change at any time,
     * since all data needed for the payment is requested dynamically to an URL stored
     * in the BR Code. Stark Infra will receive the GET request and forward it to your
     * registered endpoint with a GET request containing the UUID of the BR Code for identification.
     * <p>
     * When you initialize a DynamicBrcode, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * name [string]: receiver's name. ex: "Tony Stark"
     * city [string]: receiver's city name. ex: "Rio de Janeiro"
     * externalId [string]: string that must be unique among all your DynamicBrcodes. Duplicated external ids will cause failures. ex: "my-internal-id-123456"
     * type [string, default "instant"]: type of the DynamicBrcode. Options: "instant", "due"
     * tags [list of strings, default []]: list of strings for tagging. ex: ["travel", "food"]
     * id [string]: id returned on creation, this is the BR Code. ex: "00020126360014br.gov.bcb.pix0114+552840092118152040000530398654040.095802BR5915Jamie Lannister6009Sao Paulo620705038566304FC6C"
     * uuid [string]: unique uuid of the DynamicBrcode. ex: "4e2eab725ddd495f9c98ffd97440702d"
     * url [string]: url link to the BR Code image. ex: "https://brcode-h.development.starkinfra.com/dynamic-qrcode/901e71f2447c43c886f58366a5432c4b.png"
     * created [string]: creation datetime for the DynamicBrcode. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the DynamicBrcode. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(DynamicBrcode.class, "DynamicBrcode");

    public String name;
    public String city;
    public String externalId;
    public String type;
    public String[] tags;
    public String uuid;
    public String url;
    public String created;
    public String updated;

    /**
     * DynamicBrcode object
     * <p>
     * BR Codes store information represented by Pix QR Codes, which are used to
     * send or receive Pix transactions in a convenient way.
     * DynamicBrcodes represent charges with information that can change at any time,
     * since all data needed for the payment is requested dynamically to an URL stored
     * in the BR Code. Stark Infra will receive the GET request and forward it to your
     * registered endpoint with a GET request containing the UUID of the BR Code for identification.
     * <p>
     * When you initialize a DynamicBrcode, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * @param name [string]: receiver's name. ex: "Tony Stark"
     * @param city [string]: receiver's city name. ex: "Rio de Janeiro"
     * @param externalId [string]: string that must be unique among all your DynamicBrcodes. Duplicated external ids will cause failures. ex: "my-internal-id-123456"
     * @param type [string, default "instant"]: type of the DynamicBrcode. Options: "instant", "due"
     * @param tags [list of strings, default []]: list of strings for tagging. ex: ["travel", "food"]
     * @param id [string]: id returned on creation, this is the BR Code. ex: "00020126360014br.gov.bcb.pix0114+552840092118152040000530398654040.095802BR5915Jamie Lannister6009Sao Paulo620705038566304FC6C"
     * @param uuid [string]: unique uuid of the DynamicBrcode. ex: "4e2eab725ddd495f9c98ffd97440702d"
     * @param url [string]: url link to the BR Code image. ex: "https://brcode-h.development.starkinfra.com/dynamic-qrcode/901e71f2447c43c886f58366a5432c4b.png"
     * @param created [string]: creation datetime for the DynamicBrcode. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the DynamicBrcode. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public DynamicBrcode(String name, String city, String externalId, String type, String[] tags, String id,
                         String uuid, String url, String created, String updated
    ) {
        super(id);
        this.name = name;
        this.city = city;
        this.externalId = externalId;
        this.type = type;
        this.tags = tags;
        this.uuid = uuid;
        this.url = url;
        this.created = created;
        this.updated = updated;
    }

    /**
     * DynamicBrcode object
     * <p>
     * BR Codes store information represented by Pix QR Codes, which are used to
     * send or receive Pix transactions in a convenient way.
     * DynamicBrcodes represent charges with information that can change at any time,
     * since all data needed for the payment is requested dynamically to an URL stored
     * in the BR Code. Stark Infra will receive the GET request and forward it to your
     * registered endpoint with a GET request containing the UUID of the BR Code for identification.
     * <p>
     * When you initialize a DynamicBrcode, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the DynamicBrcode
     * name [string]: receiver's name. ex: "Tony Stark"
     * city [string]: receiver's city name. ex: "Rio de Janeiro"
     * externalId [string]: string that must be unique among all your DynamicBrcodes. Duplicated external ids will cause failures. ex: "my-internal-id-123456"
     * <p>
     * Parameters (optional):
     * type [string, default "instant"]: type of the DynamicBrcode. Options: "instant", "due"
     * tags [list of strings, default []]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Attributes (return-only):
     * id [string]: id returned on creation, this is the BR Code. ex: "00020126360014br.gov.bcb.pix0114+552840092118152040000530398654040.095802BR5915Jamie Lannister6009Sao Paulo620705038566304FC6C"
     * uuid [string]: unique uuid of the DynamicBrcode. ex: "4e2eab725ddd495f9c98ffd97440702d"
     * url [string]: url link to the BR Code image. ex: "https://brcode-h.development.starkinfra.com/dynamic-qrcode/901e71f2447c43c886f58366a5432c4b.png"
     * created [string]: creation datetime for the DynamicBrcode. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the DynamicBrcode. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public DynamicBrcode(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.name = (String) dataCopy.remove("name");
        this.city = (String) dataCopy.remove("city");
        this.externalId = (String) dataCopy.remove("externalId");
        this.type = (String) dataCopy.remove("type");
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
     * Retrieve a specific DynamicBrcode
     * <p>
     * Receive a single DynamicBrcode object previously created in the Stark Infra API by passing its uuid
     * <p>
     * Parameters:
     * @param uuid [string]: object's unique uuid. ex: "901e71f2447c43c886f58366a5432c4b"
     * <p>
     * Return:
     * @return DynamicBrcode object with updated attributes
     * @throws Exception error in the request
     */
    public static DynamicBrcode get(String uuid) throws Exception {
        return DynamicBrcode.get(uuid, null);
    }

    /**
     * Retrieve a specific DynamicBrcode
     * <p>
     * Receive a single DynamicBrcode object previously created in the Stark Infra API by passing its uuid
     * <p>
     * Parameters:
     * @param uuid [string]: object's unique uuid. ex: "901e71f2447c43c886f58366a5432c4b"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return DynamicBrcode object with updated attributes
     * @throws Exception error in the request
     */
    public static DynamicBrcode get(String uuid, User user) throws Exception {
        return Rest.getId(data, uuid, user);
    }

    /**
     * Retrieve DynamicBrcodes
     * <p>
     * Receive a generator of DynamicBrcode objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my_external_id1", "my_external_id2"]
     * uuids [list of strings, default null]: list of uuids to filter retrieved objects. ex: ["901e71f2447c43c886f58366a5432c4b", "4e2eab725ddd495f9c98ffd97440702d"]
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * <p>
     * Return:
     * @return generator of DynamicBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<DynamicBrcode> query(Map<String, Object> params) throws Exception {
        return DynamicBrcode.query(params, null);
    }

    /**
     * Retrieve DynamicBrcodes
     * <p>
     * Receive a generator of DynamicBrcode objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of DynamicBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<DynamicBrcode> query(User user) throws Exception {
        return DynamicBrcode.query(new HashMap<>(), user);
    }

    /**
     * Retrieve DynamicBrcodes
     * <p>
     * Receive a generator of DynamicBrcode objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of DynamicBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<DynamicBrcode> query() throws Exception {
        return DynamicBrcode.query(new HashMap<>(), null);
    }

    /**
     * Retrieve DynamicBrcodes
     * <p>
     * Receive a generator of DynamicBrcode objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my_external_id1", "my_external_id2"]
     * uuids [list of strings, default null]: list of uuids to filter retrieved objects. ex: ["901e71f2447c43c886f58366a5432c4b", "4e2eab725ddd495f9c98ffd97440702d"]
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of DynamicBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<DynamicBrcode> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<DynamicBrcode> brcodes;
        public String cursor;

        public Page(List<DynamicBrcode> brcodes, String cursor) {
            this.brcodes = brcodes;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged DynamicBrcodes
     * <p>
     * Receive a list of up to 100 DynamicBrcode objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * endToEndIds [list of strings, default null]: central bank's unique transaction IDs. ex: ["E79457883202101262140HHX553UPqeq", "E79457883202101262140HHX553UPxzx"]
     * externalIds [list of strings, default null]: url safe strings that must be unique among all your PixRequests. Duplicated external IDs will cause failures. By default, this parameter will block any PixRequests that repeats amount and receiver information on the same date. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * <p>
     * Return:
     * @return DynamicBrcode.Page object:
     * DynamicBrcode.Page.brcodes: list of DynamicBrcode objects with updated attributes
     * DynamicBrcode.Page.cursor: cursor to retrieve the next page of DynamicBrcode objects
     * @throws Exception error in the request
     */
    public static DynamicBrcode.Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged DynamicBrcodes
     * <p>
     * Receive a list of up to 100 DynamicBrcode objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return DynamicBrcode.Page object:
     * DynamicBrcode.Page.brcodes: list of DynamicBrcode objects with updated attributes
     * DynamicBrcode.Page.cursor: cursor to retrieve the next page of DynamicBrcode objects
     * @throws Exception error in the request
     */
    public static DynamicBrcode.Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged DynamicBrcodes
     * <p>
     * Receive a list of up to 100 DynamicBrcode objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return DynamicBrcode.Page object:
     * DynamicBrcode.Page.brcodes: list of DynamicBrcode objects with updated attributes
     * DynamicBrcode.Page.cursor: cursor to retrieve the next page of DynamicBrcode objects
     * @throws Exception error in the request
     */
    public static DynamicBrcode.Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged DynamicBrcodes
     * <p>
     * Receive a list of up to 100 DynamicBrcode objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created or updated only after specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created or updated only before specified date. ex: "2020-04-30"
     * uuids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: url safe strings that must be unique among all your PixRequests. Duplicated external IDs will cause failures. By default, this parameter will block any PixRequests that repeats amount and receiver information on the same date. ex: ["my-internal-id-123456", "my-internal-id-654321"]
     * tags [list of strings, default []]: list of tags to filter retrieved objects. ex: ["travel", "food"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return DynamicBrcode.Page object:
     * DynamicBrcode.Page.brcodes: list of DynamicBrcode objects with updated attributes
     * DynamicBrcode.Page.cursor: cursor to retrieve the next page of DynamicBrcode objects
     * @throws Exception error in the request
     */
    public static DynamicBrcode.Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<DynamicBrcode> brcodes = new ArrayList<>();
        for (SubResource request: page.entities) {
            brcodes.add((DynamicBrcode) request);
        }
        return new DynamicBrcode.Page(brcodes, page.cursor);
    }

    /**
     * Create DynamicBrcodes
     * <p>
     * Send a list of DynamicBrcode objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param brcodes [list of DynamicBrcode objects or HashMaps]: list of DynamicBrcode objects to be created in the API.
     * <p>
     * Return:
     * @return list of DynamicBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<DynamicBrcode> create(List<?> brcodes) throws Exception {
        return DynamicBrcode.create(brcodes, null);
    }

    /**
     * Create DynamicBrcodes
     * <p>
     * Send a list of DynamicBrcode objects for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param brcodes [list of DynamicBrcode objects or HashMaps]: list of DynamicBrcode objects to be created in the API.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of DynamicBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<DynamicBrcode> create(List<?> brcodes, User user) throws Exception {
        List<DynamicBrcode> brcodeList = new ArrayList<>();
        for (Object brcode : brcodes){
            if (brcode instanceof Map){
                brcodeList.add(new DynamicBrcode((Map<String, Object>) brcode));
                continue;
            }
            if (brcode instanceof DynamicBrcode){
                brcodeList.add((DynamicBrcode) brcode);
                continue;
            }
            throw new Exception("Unknown type \"" + brcode.getClass() + "\", use DynamicBrcode or HashMap");
        }
        return Rest.post(data, brcodeList, user);
    }

    /**
     * Helps you respond to a due DynamicBrcode Read
     * <p>
     * When a Due DynamicBrcode is read by your user, a GET request containing the BR Code's
     * UUID will be made to your registered URL to retrieve additional information needed
     * to complete the transaction.
     * The get request must be answered in the following format, within 5 seconds, and with
     * an HTTP status code 200.
     * <p>
     * Parameters (required):
     * @param params to be returned on a due DynamicBrcode read.
     * version [integer]: integer that represents how many times the BR Code was updated.
     * created [string]: creation datetime in ISO format of the DynamicBrcode. ex: "2020-03-10T10:30:00.000000+00:00"
     * due [string]: requested payment due datetime in ISO format. ex: "2020-03-10T10:30:00.000000+00:00"
     * keyId [string]: receiver's PixKey id. Can be a taxId (CPF/CNPJ), a phone number, an email or an alphanumeric sequence (EVP). ex: "+5511989898989"
     * status [string]: BR Code status. Options: "created", "overdue", "paid", "canceled" or "expired"
     * reconciliationId [string]: id to be used for conciliation of the resulting Pix transaction. This id must have from to 26 to 35 alphanumeric characters' ex: "cd65c78aeb6543eaaa0170f68bd741ee"
     * nominalAmount [Long]: positive integer that represents the amount in cents of the resulting Pix transaction. ex: 1234 (= R$ 12.34)
     * senderName [string]: sender's full name. ex: "Anthony Edward Stark"
     * senderTaxId [string]: sender's CPF (11 digits formatted or unformatted) or CNPJ (14 digits formatted or unformatted). ex: "01.001.001/0001-01"
     * receiverName [string]: receiver's full name. ex: "Jamie Lannister"
     * receiverStreetLine [string]: receiver's main address. ex: "Av. Paulista, 200"
     * receiverCity [string]: receiver's address city name. ex: "Sao Paulo"
     * receiverStateCode [string]: receiver's address state code. ex: "SP"
     * receiverZipCode [string]: receiver's address zip code. ex: "01234-567"
     * expiration [Long]: time in seconds counted from the creation datetime until the DynamicBrcode expires. After expiration, the BR Code cannot be paid anymore.
     * <p>
     * Parameters (optional):
     * receiverTaxId [string, default null]: receiver's CPF (11 digits formatted or unformatted) or CNPJ (14 digits formatted or unformatted). ex: "012.345.678-90"
     * fine [Number, default 2.0]: percentage charged if the sender pays after the due datetime.
     * interest [Number, default 1.0]: interest percentage charged if the sender pays after the due datetime.
     * discounts [list of Discount objects, default null]: discount amount applied if the sender pays at a specific datetime before the due datetime.
     * description [string, default null]: additional information to be shown to the sender at the moment of payment.
     * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us
     * @throws Exception error in the request
     */
    public static String responseDue(Map<String, Object> params) throws Exception {
        Gson gson = new Gson();
        return gson.toJson(params);
    }

    /**
     * Helps you respond to an instant DynamicBrcode Read
     * <p>
     * When an instant DynamicBrcode is read by your user, a GET request containing the BR Code's UUID will be made
     * to your registered URL to retrieve additional information needed to complete the transaction.
     * The get request must be answered in the following format within 5 seconds and with an HTTP status code 200.
     * <p>
     * Parameters (required):
     * @param params to be returned on an instant DynamicBrcode read.
     * version [integer]: integer that represents how many times the BR Code was updated.
     * created [string]: creation datetime of the DynamicBrcode. ex: "2020-03-10T10:30:00.000000+00:00"
     * keyId [string]: receiver's PixKey id. Can be a taxId (CPF/CNPJ), a phone number, an email or an alphanumeric sequence (EVP). ex: "+5511989898989"
     * status [string]: BR Code status. Options: "created", "overdue", "paid", "canceled" or "expired"
     * reconciliationId [string]: id to be used for conciliation of the resulting Pix transaction. This id must have from to 26 to 35 alphanumeric characters' ex: "cd65c78aeb6543eaaa0170f68bd741ee"
     * amount [Long]: positive integer that represents the amount in cents of the resulting Pix transaction. ex: 1234 (= R$ 12.34).
     * expiration [Long]: time in seconds counted from the creation datetime until the DynamicBrcode expires. After expiration, the BR Code cannot be paid anymore.
     * <p>
     * Parameters (conditionally-required):
     * cashierType [string, default null]: cashier's type. Required if the cashAmount is different from 0. Options: "merchant", "participant" and "other"
     * cashierBankCode [string, default null]: cashier's bank code. Required if the cashAmount is different from 0. ex: "20018183"
     * <p>
     * Parameters (optional):
     * cashAmount [Long, default 0]: amount to be withdrawn from the cashier in cents. ex: 1000 (= R$ 10.00)
     * senderName [string, default null]: sender's full name. ex: "Anthony Edward Stark"
     * senderTaxId [string, default null]: sender's CPF (11 digits formatted or unformatted) or CNPJ (14 digits formatted or unformatted). ex: "01.001.001/0001-01"
     * amountType [string, default "fixed"]: amount type of the BR Code. If the amount type is "custom" the Brcode's amount can be changed by the sender at the moment of payment. Options: "fixed" or "custom"
     * description [string, default null]: additional information to be shown to the sender at the moment of payment. * <p>
     * Return:
     * @return Dumped JSON string that must be returned to us
     * @throws Exception error in the request
     */
    public static String responseInstant(Map<String, Object> params) throws Exception {
        Gson gson = new Gson();
        return gson.toJson(params);
    }

    /**
     * Verify a DynamicBrcode Read
     * <p>
     * When a DynamicBrcode is read by your user, a GET request will be made to your registered URL to
     * retrieve additional information needed to complete the transaction.
     * Use this method to verify the authenticity of a GET request received at your registered endpoint.
     * If the provided digital signature does not check out with the StarkInfra public key,
     * a com.starkinfra.error.InvalidSignatureError will be raised.
     * <p>
     * Parameters:
     * @param uuid [string]: unique uuid of the DynamicBrcode, passed as a path variable in the DynamicBrcode Read request. ex: "4e2eab725ddd495f9c98ffd97440702d"
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return DynamicBrcode object with updated attributes
     * @throws Exception error in the request
     */
    public static String verify(String uuid, String signature, User user) throws Exception {
        return Parse.verify(uuid, signature, user);
    }

    /**
     * Verify a DynamicBrcode Read
     * <p>
     * When a DynamicBrcode is read by your user, a GET request will be made to your registered URL to
     * retrieve additional information needed to complete the transaction.
     * Use this method to verify the authenticity of a GET request received at your registered endpoint.
     * If the provided digital signature does not check out with the StarkInfra public key,
     * a com.starkinfra.error.InvalidSignatureError will be raised.
     * <p>
     * Parameters:
     * @param uuid [string]: unique uuid of the DynamicBrcode, passed as a path variable in the DynamicBrcode Read request. ex: "4e2eab725ddd495f9c98ffd97440702d"
     * @param signature [string]: base-64 digital signature received at response header "Digital-Signature"
     * <p>
     * Return:
     * @return DynamicBrcode object with updated attributes
     * @throws Exception error in the request
     */
    public static String verify(String uuid, String signature) throws Exception {
        return DynamicBrcode.verify(uuid, signature, null);
    }

    /**
     * DynamicBrcode.Discount object
     * <p>
     * Used to define a Discount in the BR Code
     * <p>
     * Parameters:
     * percentage [number]: discount percentage that will be applied. ex: 2.5
     * due [string]: Date after when the discount will be overdue in UTC ISO format. ex: "2020-11-25T17:59:26.249976+00:00"
     */
    public final static class Discount extends SubResource{
        public Number percentage;
        public String due;


        /**
         * DynamicBrcode.Discount object
         * <p>
         * Used to define a Discount in the BR Code
         * <p>
         * Parameters:
         * @param percentage [number]: discount percentage that will be applied. ex: 2.5
         * @param due [string]: Date after when the discount will be overdue in UTC ISO format. ex: "2020-11-25T17:59:26.249976+00:00"
         */
        public Discount(Number percentage, String due){
            this.percentage = percentage;
            this.due = due;
        }

        /**
         * DynamicBrcode.Discount object
         * <p>
         * Used to define a Discount in the BR Code
         * <p>
         * Parameters:
         * @param data map of properties for the creation of the DynamicBrcode.Discount object
         * percentage [number]: discount percentage that will be applied. ex: 2.5
         * due [string]: Date after when the discount will be overdue in UTC ISO format. ex: "2020-11-25T17:59:26.249976+00:00"
         */
        public Discount(Map<String, Object> data) throws Exception {
            HashMap<String, Object> dataCopy = new HashMap<>(data);

            this.percentage = (Number) dataCopy.remove("percentage");
            this.due = (String) dataCopy.remove("due");

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }
    }
}
