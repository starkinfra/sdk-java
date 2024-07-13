package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Generator;
import com.starkcore.utils.SubResource;
import com.starkinfra.error.ErrorElement;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public final class PixClaim extends Resource {
    /**
     * PixClaim object
     * <p>
     * A Pix Claim is a request to transfer a Pix Key from an account hosted at another
     * Pix participant to an account under your bank code. Pix Claims must always be requested by the claimer.
     * <p>
     * When you initialize a PixClaim, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * accountCreated [string]: opening Date or DateTime for the account claiming the PixKey. ex: "2022-01-01".
     * accountNumber [string]: number of the account claiming the PixKey. ex: "76543".
     * accountType [string]: type of the account claiming the PixKey. Options: "checking", "savings", "salary" or "payment".
     * branchCode [string]: branch code of the account claiming the PixKey. ex: 1234".
     * name [string]: holder's name of the account claiming the PixKey. ex: "Jamie Lannister".
     * taxId [string]: holder's taxId of the account claiming the PixKey (CPF/CNPJ). ex: "012.345.678-90".
     * keyId [string]: id of the registered Pix Key to be claimed. Allowed keyTypes are CPF, CNPJ, phone number or email. ex: "+5511989898989".
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * id [string, default null]: unique id returned when the PixClaim is created. ex: "5656565656565656"
     * status [string, default null]: current PixClaim status. Options: "created", "failed", "delivered", "confirmed", "success", "canceled"
     * type [string, default null]: type of Pix Claim. Options: "ownership", "portability".
     * keyType [string, default null]: keyType of the claimed PixKey. Options: "CPF", "CNPJ", "phone" or "email"
     * flow [string]: direction of the Pix Claim. Options: "in" if you received the PixClaim or "out" if you created the PixClaim.
     * claimerBankCode [string], bank code of the Pix participant that created the PixClaim. ex: "20018183".
     * claimedBankCode [string, default null]: bank code of the account claiming the PixKey being claimed. ex: "20018183".
     * created [string, default null]: creation datetime for the PixClaim. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string, default null]: update datetime for the PixClaim. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(PixClaim.class, "PixClaim");

    public String accountCreated;
    public String accountNumber;
    public String accountType;
    public String branchCode;
    public String name;
    public String taxId;
    public String keyId;
    public String[] tags;
    public String status;
    public String type;
    public String keyType;
    public String flow;
    public String claimerBankCode;
    public String claimedBankCode;
    public String created;
    public String updated;

    /**
     * PixClaim object
     * <p>
     * A Pix Claim is a request to transfer a Pix Key from an account hosted at another
     * Pix participant to an account under your bank code. Pix Claims must always be requested by the claimer.
     * <p>
     * When you initialize a PixClaim, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * @param accountCreated [string]: opening Date or DateTime for the account claiming the PixKey. ex: "2022-01-01".
     * @param accountNumber [string]: number of the account claiming the PixKey. ex: "76543".
     * @param accountType [string]: type of the account claiming the PixKey. Options: "checking", "savings", "salary" or "payment".
     * @param branchCode [string]: branch code of the account claiming the PixKey. ex: 1234".
     * @param name [string]: holder's name of the account claiming the PixKey. ex: "Jamie Lannister".
     * @param taxId [string]: holder's taxId of the account claiming the PixKey (CPF/CNPJ). ex: "012.345.678-90".
     * @param keyId [string]: id of the registered Pix Key to be claimed. Allowed keyTypes are CPF, CNPJ, phone number or email. ex: "+5511989898989".
     * @param tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * @param id [string]: unique id returned when the PixClaim is created. ex: "5656565656565656"
     * @param status [string]: current PixClaim status. Options: "created", "failed", "delivered", "confirmed", "success", "canceled"
     * @param type [string]: type of Pix Claim. Options: "ownership", "portability".
     * @param keyType [string]: keyType of the claimed PixKey. Options: "CPF", "CNPJ", "phone" or "email"
     * @param flow [string]: direction of the Pix Claim. Options: "in" if you received the PixClaim or "out" if you created the PixClaim.
     * @param claimerBankCode [string], bank code of the Pix participant that created the PixClaim. ex: "20018183".
     * @param claimedBankCode [string]: bank code of the account claiming the PixKey being claimed. ex: "20018183".
     * @param created [string]: creation datetime for the PixClaim. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: update datetime for the PixClaim. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public PixClaim(String accountCreated, String accountNumber, String accountType, String branchCode, String name,
                    String taxId, String keyId, String[] tags, String id, String status, String type, String keyType,
                    String claimerBankCode, String flow, String claimedBankCode, String created, String updated
    ) {
        super(id);
        this.accountCreated = accountCreated;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.branchCode = branchCode;
        this.name = name;
        this.taxId = taxId;
        this.keyId = keyId;
        this.tags = tags;
        this.status = status;
        this.type = type;
        this.keyType = keyType;
        this.flow = flow;
        this.claimerBankCode = claimerBankCode;
        this.claimedBankCode = claimedBankCode;
        this.created = created;
        this.updated = updated;
    }

    /**
     * PixClaim object
     * <p>
     * A Pix Claim is a request to transfer a Pix Key from an account hosted at another
     * Pix participant to an account under your bank code. Pix Claims must always be requested by the claimer.
     * <p>
     * When you initialize a PixClaim, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the PixClaim
     * accountCreated [string]: opening Date or DateTime for the account claiming the PixKey. ex: "2022-01-01".
     * accountNumber [string]: number of the account claiming the PixKey. ex: "76543".
     * accountType [string]: type of the account claiming the PixKey. Options: "checking", "savings", "salary" or "payment".
     * branchCode [string]: branch code of the account claiming the PixKey. ex: 1234".
     * name [string]: holder's name of the account claiming the PixKey. ex: "Jamie Lannister".
     * taxId [string]: holder's taxId of the account claiming the PixKey (CPF/CNPJ). ex: "012.345.678-90".
     * keyId [string]: id of the registered Pix Key to be claimed. Allowed keyTypes are CPF, CNPJ, phone number or email. ex: "+5511989898989".
     * <p>
     * Parameters (optional):
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the PixClaim is created. ex: "5656565656565656"
     * status [string]: current PixClaim status. Options: "created", "failed", "delivered", "confirmed", "success", "canceled"
     * type [string]: type of Pix Claim. Options: "ownership", "portability".
     * keyType [string]: keyType of the claimed PixKey. Options: "CPF", "CNPJ", "phone" or "email"
     * flow [string]: direction of the Pix Claim. Options: "in" if you received the PixClaim or "out" if you created the PixClaim.
     * claimerBankCode [string], bank code of the Pix participant that created the PixClaim. ex: "20018183".
     * claimedBankCode [string]: bank code of the account claiming the PixKey being claimed. ex: "20018183".
     * created [string]: creation datetime for the PixClaim. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: update datetime for the PixClaim. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public PixClaim(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.accountCreated = (String) dataCopy.remove("accountCreated");
        this.accountNumber = (String) dataCopy.remove("accountNumber");
        this.accountType = (String) dataCopy.remove("accountType");
        this.branchCode = (String) dataCopy.remove("branchCode");
        this.name = (String) dataCopy.remove("name");
        this.taxId = (String) dataCopy.remove("taxId");
        this.keyId = (String) dataCopy.remove("keyId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.status = null;
        this.type = null;
        this.keyType = null;
        this.flow = null;
        this.claimerBankCode = null;
        this.claimedBankCode = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific PixClaim
     * <p>
     * Receive a single PixClaim object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return PixClaim object with updated attributes
     * @throws Exception error in the request
     */
    public static PixClaim get(String id) throws Exception {
        return PixClaim.get(id, null);
    }

    /**
     * Retrieve a specific PixClaim
     * <p>
     * Receive a single PixClaim object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixClaim object with updated attributes
     * @throws Exception error in the request
     */
    public static PixClaim get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve PixClaims
     * <p>
     * Receive a generator of PixClaim objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "confirmed", "success", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved PixClaims. Options: "ownership" or "portability".
     * keyType [string, default null]: filter for the PixKey type of retrieved PixClaims. Options: "cpf", "cnpj", "phone", "email" and "evp",
     * keyId [string, default null]: filter PixClaims linked to a specific PixKey id. Example: "+5511989898989".
     * flow [string]: direction of the Pix Claim. Options: "in" if you received the PixClaim or "out" if you created the PixClaim.
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Return:
     * @return generator of PixClaim objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixClaim> query(Map<String, Object> params) throws Exception {
        return PixClaim.query(params, null);
    }

    /**
     * Retrieve PixClaims
     * <p>
     * Receive a generator of PixClaim objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixClaim objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixClaim> query(User user) throws Exception {
        return PixClaim.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PixClaims
     * <p>
     * Receive a generator of PixClaim objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of PixClaim objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixClaim> query() throws Exception {
        return PixClaim.query(new HashMap<>(), null);
    }

    /**
     * Retrieve PixClaims
     * <p>
     * Receive a generator of PixClaim objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "confirmed", "success", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved PixClaims. Options: "ownership" or "portability".
     * keyType [string, default null]: filter for the PixKey type of retrieved PixClaims. Options: "cpf", "cnpj", "phone", "email" and "evp",
     * keyId [string, default null]: Filter PixClaims linked to a specific PixKey id. Example: "+5511989898989".
     * flow [string]: direction of the Pix Claim. Options: "in" if you received the PixClaim or "out" if you created the PixClaim.
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PixClaim objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixClaim> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<PixClaim> claims;
        public String cursor;

        public Page(List<PixClaim> claims, String cursor) {
            this.claims = claims;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged PixClaims
     * <p>
     * Receive a list of up to 100 PixClaim objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your claims.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "confirmed", "success", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved PixClaims. Options: "ownership" or "portability".
     * keyType [string, default null]: filter for the PixKey type of retrieved PixClaims. Options: "cpf", "cnpj", "phone", "email" and "evp",
     * keyId [string, default null]: Filter PixClaims linked to a specific PixKey id. Example: "+5511989898989".
     * flow [string]: direction of the Pix Claim. Options: "in" if you received the PixClaim or "out" if you created the PixClaim.
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Return:
     * @return PixClaim.Page object:
     * PixClaim.Page.claims: list of PixClaim objects with updated attributes
     * PixClaim.Page.cursor: cursor to retrieve the next page of PixClaim objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged PixClaims
     * <p>
     * Receive a list of up to 100 PixClaim objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your claims.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixClaim.Page object:
     * PixClaim.Page.claims: list of PixClaim objects with updated attributes
     * PixClaim.Page.cursor: cursor to retrieve the next page of PixClaim objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PixClaims
     * <p>
     * Receive a list of up to 100 PixClaim objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your claims.
     * <p>
     * Return:
     * @return PixClaim.Page object:
     * PixClaim.Page.claims: list of PixClaim objects with updated attributes
     * PixClaim.Page.cursor: cursor to retrieve the next page of PixClaim objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PixClaims
     * <p>
     * Receive a list of up to 100 PixClaim objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your claims.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "failed", "delivered", "confirmed", "success", "canceled".
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [strings, default null]: filter for the type of retrieved PixClaims. Options: "ownership" or "portability".
     * keyType [string, default null]: filter for the PixKey type of retrieved PixClaims. Options: "cpf", "cnpj", "phone", "email" and "evp",
     * keyId [string, default null]: Filter PixClaims linked to a specific PixKey id. Example: "+5511989898989".
     * flow [string]: direction of the Pix Claim. Options: "in" if you received the PixClaim or "out" if you created the PixClaim.
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixClaim.Page object:
     * PixClaim.Page.claims: list of PixClaim objects with updated attributes
     * PixClaim.Page.cursor: cursor to retrieve the next page of PixClaim objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<PixClaim> claims = new ArrayList<>();
        for (SubResource claim: page.entities) {
            claims.add((PixClaim) claim);
        }
        return new Page(claims, page.cursor);
    }

    /**
     * Create a PixClaim object
     * <p>
     * Create a Pix Claim to request the transfer of a Pix Key from an account
     * hosted at another Pix participant to an account under your bank code.
     * <p>
     * Parameters:
     * @param claim [PixClaim object or HashMap]: PixClaim object to be created in the API
     * <p>
     * Return:
     * @return PixClaim object with updated attributes
     * @throws Exception error in the request
     */
    public static PixClaim create(PixClaim claim) throws Exception {
        return PixClaim.create(claim, null);
    }

    /**
     * Create a PixClaim object
     * <p>
     * Create a Pix Claim to request the transfer of a Pix Key from an account
     * hosted at another Pix participant to an account under your bank code.
     * <p>
     * Parameters:
     * @param claim [PixClaim object or HashMap]: PixClaim object to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixClaim object with updated attributes
     * @throws Exception error in the request
     */
    public static PixClaim create(PixClaim claim, User user) throws Exception {
        return Rest.postSingle(data, claim, user);
    }

    /**
     * Update PixClaim entity
     * <p>
     * Update the PixClaim by passing id.
     * <p>
     * Parameters:
     * @param id [string]: PixClaim id. ex: "5656565656565656"
     * @param status [string]: patched status for Pix Claim. Options: "confirmed" and "canceled"
     * <p>
     * Return:
     * @return PixClaim object with updated attributes
     * @throws Exception error in the request
     */
    public static PixClaim update(String id, String status) throws Exception {
        return PixClaim.update(id, status, new HashMap<>(), null);
    }

    /**
     * Update PixClaim entity
     * <p>
     * Update the PixClaim by passing id.
     * <p>
     * Parameters:
     * @param id [string]: PixClaim id. ex: "5656565656565656"
     * @param status [string]: patched status for Pix Claim. Options: "confirmed" and "canceled"
     * @param patchData map of patch parameters
     * reason [string, default: "userRequested"]: reason why the PixClaim is being patched. Options: "fraud", "userRequested".
     * <p>
     * Return:
     * @return PixClaim object with updated attributes
     * @throws Exception error in the request
     */
    public static PixClaim update(String id, String status, Map<String, Object> patchData) throws Exception {
        return PixClaim.update(id, status, patchData, null);
    }

    /**
     * Update PixClaim entity
     * <p>
     * Update the PixClaim by passing id.
     * <p>
     * Parameters:
     * @param id [string]: PixClaim id. ex: "5656565656565656"
     * @param status [string]: patched status for Pix Claim. Options: "confirmed" and "canceled"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixClaim object with updated attributes
     * @throws Exception error in the request
     */
    public static PixClaim update(String id, String status, User user) throws Exception {
        return PixClaim.update(id, status, new HashMap<>(), user);
    }

    /**
     * Update PixClaim entity
     * <p>
     * Update PixClaim by passing id.
     * <p>
     * Parameters:
     * @param id [string]: PixClaim id. ex: "656565656565656"
     * @param status [string]: patched status for Pix Claim. Options: "confirmed" and "canceled"
     * @param patchData map of patch parameters
     * reason [string, default: "userRequested"]: reason why the PixClaim is being patched. Options: "fraud", "userRequested".
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixClaim object with updated attributes
     * @throws Exception error in the request
     */
    public static PixClaim update(String id, String status, Map<String, Object> patchData, User user) throws Exception {
        patchData.put("status", status);
        return Rest.patch(data, id, patchData, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "PixClaimLog");

        public String created;
        public String type;
        public List<String> errors;
        public String reason;
        public PixClaim claim;

        /***
         * PixClaim Log object
         * <p>
         * Every time a PixClaim entity is modified, a corresponding PixClaim Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param created [string]: creation datetime for the log. ex: "2020-03-29"
         * @param type [string]: type of the PixClaim event which triggered the log creation. ex: "registered" or "paid"
         * @param errors [list of strings]: list of errors linked to this PixClaim event
         * @param reason [string]: reason for the modification in the PixClaim. Options: "fraud", "userRequested", "accountClosure", "defaultOperation", "reconciliation".
         * @param claim [PixClaim]: PixClaim entity to which the log refers to.
         */
        public Log(String created, String type, List<String> errors, String reason, PixClaim claim, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.reason = reason;
            this.claim = claim;
        }

        /**
         * Retrieve a specific PixClaim Log
         * <p>
         * Receive a single PixClaim Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return PixClaim Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific PixClaim Log
         * <p>
         * Receive a single PixClaim Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixClaim Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve PixClaim Logs
         * <p>
         * Receive a generator of PixClaim.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * ids [list of strings, default null]: Log ids to filter PixClaim Logs. ex: ["5656565656565656"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created"] or ["failed"]
         * claimIds [list of strings, default null]: list of PixClaim IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of PixClaim Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve PixClaim Logs
         * <p>
         * Receive a generator of PixClaim.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of PixClaim Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve PixClaim Logs
         * <p>
         * Receive a generator of PixClaim.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of PixClaim Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve PixClaim Logs
         * <p>
         * Receive a generator of PixClaim.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * ids [list of strings, default null]: Log ids to filter PixClaim Logs. ex: ["5656565656565656"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, deflaut null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created"] or ["failed"]
         * claimIds [list of strings, default null]: list of PixClaim IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of PixClaim Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<Log> logs;
            public String cursor;

            public Page(List<Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged PixClaim.Logs
         * <p>
         * Receive a list of up to 100 PixClaim.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your claims.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter PixClaim Logs. ex: ["5656565656565656"]
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created"] or ["failed"]
         * claimIds [list of strings, default null]: list of PixClaim IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return PixClaim.Log.Page object:
         * PixClaim.Log.Page.logs: list of PixClaim.Log objects with updated attributes
         * PixClaim.Log.Page.cursor: cursor to retrieve the next page of PixClaim.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged PixClaim.Logs
         * <p>
         * Receive a list of up to 100 PixClaim.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your claims.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixClaim.Log.Page object:
         * PixClaim.Log.Page.logs: list of PixClaim.Log objects with updated attributes
         * PixClaim.Log.Page.cursor: cursor to retrieve the next page of PixClaim.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged PixClaim.Logs
         * <p>
         * Receive a list of up to 100 PixClaim.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your claims.
         * <p>
         * Return:
         * @return PixClaim.Log.Page object:
         * PixClaim.Log.Page.logs: list of PixClaim.Log objects with updated attributes
         * PixClaim.Log.Page.cursor: cursor to retrieve the next page of PixClaim.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged PixClaim.Logs
         * <p>
         * Receive a list of up to 100 PixClaim.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your claims.
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter PixClaim Logs. ex: ["5656565656565656"]
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 35
         * after [string, default null]: date filter for objects created after a specified date. ex: "2020-03-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-03-30"
         * types [list of strings, default null]: filter retrieved objects by types. ex: ["created"] or ["failed"]
         * claimIds [list of strings, default null]: list of PixClaim IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
         * <p>
         * Return:
         * @return PixClaim.Log.Page object:
         * PixClaim.Log.Page.logs: list of PixClaim.Log objects with updated attributes
         * PixClaim.Log.Page.cursor: cursor to retrieve the next page of PixClaim.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }
}
