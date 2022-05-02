package com.starkinfra;

import com.starkinfra.error.ErrorElement;
import com.starkinfra.utils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class PixKey extends Resource {
    /**
     * PixKey object
     * <p>
     * PixKeys link bank account information to key ids.
     * Key ids are a convenient way to search and pass bank account information.
     * When you initialize a PixKey, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the created object.
     * <p>
     * Parameters:
     * accountCreated  [string]: opening Date or Datetime for the linked account. ex: "2022-01-01".
     * accountNumber   [string]: number of the linked account. ex: "76543".
     * accountType     [string]: type of the linked account. Options: "checking", "savings", "salary" or "payment".
     * branchCode      [string]: branch code of the linked account. ex: 1234".
     * name            [string]: holder's name of the linked account. ex: "Jamie Lannister".
     * taxId           [string]: holder's taxId (CPF/CNPJ) of the linked account. ex: "012.345.678-90".
     * id              [string, default null]: id of the registered PixKey. Allowed types are: CPF, CNPJ, phone number or email. If this parameter is not passed, an EVP will be created. ex: "+5511989898989";
     * tags            [list of strings, default null]: list of strings for reference when searching for PixKeys. ex: ["employees", "monthly"]
     * owned           [string, default null]: datetime when the key was owned by the holder. ex: "2022-04-13 00:37:47.393+00:00"
     * ownerType       [string, default null]: type of the owner of the PixKey. Options: "business" or "individual".
     * status          [string, default null]: current PixKey status. Options: "created", "registered", "canceled", "failed"
     * bankCode        [string, default null]: bankCode of the account linked to the PixKey. ex: "20018183".
     * bankName        [string, default null]: name of the bank that holds the account linked to the PixKey. ex: "StarkBank"
     * type            [string, default null]: type of the PixKey. Options: "cpf", "cnpj", "phone", "email" and "evp",
     * created         [string, default null]: creation datetime for the PixKey. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(PixKey.class, "PixKey");

    public String accountCreated;
    public String accountNumber;
    public String accountType;
    public String branchCode;
    public String name;
    public String taxId;
    public String[] tags;
    public String owned;
    public String ownerType;
    public String status;
    public String bankCode;
    public String bankName;
    public String type;
    public String created;

    /**
     * PixKey object
     * <p>
     * PixKeys link bank account information to key ids.
     * Key ids are a convenient way to search and pass bank account information.
     * When you initialize a PixKey, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param accountCreated [string]: opening Date or Datetime for the linked account. ex: "2022-01-01".
     * @param accountNumber  [string]: number of the linked account. ex: "76543".
     * @param accountType    [string]: type of the linked account. Options: "checking", "savings", "salary" or "payment".
     * @param branchCode     [string]: branch code of the linked account. ex: 1234".
     * @param name           [string]: holder's name of the linked account. ex: "Jamie Lannister".
     * @param taxId          [string]: holder's taxId (CPF/CNPJ) of the linked account. ex: "012.345.678-90".
     * @param id             [string, default null]: id of the registered PixKey. Allowed types are: CPF, CNPJ, phone number or email. If this parameter is not passed, an EVP will be created. ex: "+5511989898989";
     * @param tags           [list of strings, default null]: list of strings for reference when searching for PixKeys. ex: ["employees", "monthly"]
     * @param owned          [string, default null]: datetime when the key was owned by the holder. ex: "2022-04-13 00:37:47.393+00:00"
     * @param ownerType      [string, default null]: type of the owner of the PixKey. Options: "business" or "individual".
     * @param status         [string, default null]: current PixKey status. Options: "created", "registered", "canceled", "failed"
     * @param bankCode       [string, default null]: bankCode of the account linked to the PixKey. ex: "20018183".
     * @param bankName       [string, default null]: name of the bank that holds the account linked to the PixKey. ex: "StarkBank"
     * @param type           [string, default null]: type of the PixKey. Options: "cpf", "cnpj", "phone", "email" and "evp",
     * @param created        [string, default null]: creation datetime for the PixKey. ex: "2022-04-13 00:37:47.393+00:00"
     *
     */
    public PixKey(String accountCreated, String accountNumber, String accountType, String branchCode, String name,
                  String taxId, String id, String[] tags, String owned, String ownerType, String status,
                  String bankCode, String bankName, String type, String created) {
        super(id);
        this.accountCreated = accountCreated;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.branchCode = branchCode;
        this.name = name;
        this.taxId = taxId;
        this.tags = tags;
        this.owned = owned;
        this.ownerType = ownerType;
        this.status = status;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.type = type;
        this.created = created;
    }

    /**
     * PixKey object
     * <p>
     * PixKeys link bank account information to key ids.
     * Key ids are a convenient way to search and pass bank account information.
     * When you initialize a PixKey, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the PixKey
     * accountCreated [string]: opening Date or Datetime for the linked account. ex: "2022-01-01".
     * accountNumber [string]: number of the linked account. ex: "76543".
     * accountType [string]: type of the linked account. Options: "checking", "savings", "salary" or "payment".
     * branchCode [string]: branch code of the linked account. ex: 1234".
     * name [string]: holder's name of the linked account. ex: "Jamie Lannister".
     * taxId [string]: holder's taxId (CPF/CNPJ) of the linked account. ex: "012.345.678-90".
     * <p>
     * Parameters (optional):
     * id [string, default null]: id of the registered PixKey. Allowed types are: CPF, CNPJ, phone number or email. If this parameter is not passed, an EVP will be created. ex: "+5511989898989";
     * tags [list of strings, default null]: list of strings for reference when searching for PixKeys. ex: ["employees", "monthly"]
     * <p>
     * Attributes (return-only):
     * owned [string, default null]: datetime when the key was owned by the holder. ex: "2022-04-13 00:37:47.393+00:00"
     * ownerType [string, default null]: type of the owner of the PixKey. Options: "business" or "individual".
     * status [string, default null]: current PixKey status. Options: "created", "registered", "canceled", "failed"
     * bankCode [string, default null]: bankCode of the account linked to the PixKey. ex: "20018183".
     * bankName [string, default null]: name of the bank that holds the account linked to the PixKey. ex: "StarkBank"
     * type [string, default null]: type of the PixKey. Options: "cpf", "cnpj", "phone", "email" and "evp",
     * created [string, default null]: creation datetime for the PixKey. ex: "2022-04-13 00:37:47.393+00:00"
     * @throws Exception error in the request
     */
    public PixKey(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.accountCreated = (String) dataCopy.remove("accountCreated");
        this.accountNumber = (String) dataCopy.remove("accountNumber");
        this.accountType = (String) dataCopy.remove("accountType");
        this.branchCode = (String) dataCopy.remove("branchCode");
        this.name = (String) dataCopy.remove("name");
        this.taxId = (String) dataCopy.remove("taxId");
        this.id = (String) dataCopy.remove("id");
        this.tags = (String[]) dataCopy.remove("tags");
        this.owned = null;
        this.ownerType = null;
        this.status = null;
        this.bankCode = null;
        this.bankName = null;
        this.type = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific PixKey
     * <p>
     * Receive a single PixKey object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return PixKey object with updated attributes
     * @throws Exception error in the request
     */
    public static PixKey get(String id, Map<String, Object> params) throws Exception {
        return PixKey.get(id, params, null);
    }

    /**
     * Retrieve a specific PixKey
     * <p>
     * Receive a single PixKey object previously created in the Stark Infra API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixKey object with updated attributes
     * @throws Exception error in the request
     */
    public static PixKey get(String id, Map<String, Object> params, User user) throws Exception {
        return Rest.getId(data, id, params, user);
    }

    /**
     * Delete a PixKey entity
     * <p>
     * Delete a PixKey entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: PixKey unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return deleted PixKey object
     * @throws Exception error in the request
     */
    public static PixKey delete(String id) throws Exception {
        return PixKey.delete(id, null);
    }

    /**
     * Delete a PixKey entity
     * <p>
     * Delete a PixKey entity previously created in the Stark Infra API
     * <p>
     * Parameters:
     * @param id [string]: PixKey unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return deleted PixKey object
     * @throws Exception error in the request
     */
    public static PixKey delete(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    /**
     * Retrieve PixKeys
     * <p>
     * Receive a generator of PixKey objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "registered", "canceled", "failed".
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [list of strings, default null]: filter for the type of retrieved PixKeys. Options: "cpf", "cnpj", "phone", "email", "evp".
     * <p>
     * Return:
     * @return generator of PixKey objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixKey> query(Map<String, Object> params) throws Exception {
        return PixKey.query(params, null);
    }

    /**
     * Retrieve PixKeys
     * <p>
     * Receive a generator of PixKey objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of PixKey objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixKey> query(User user) throws Exception {
        return PixKey.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PixKeys
     * <p>
     * Receive a generator of PixKey objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of PixKey objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixKey> query() throws Exception {
        return PixKey.query(new HashMap<>(), null);
    }

    /**
     * Retrieve PixKeys
     * <p>
     * Receive a generator of PixKey objects previously created in the Stark Infra API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of properties for the creation of the PixKey
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "registered", "canceled", "failed".
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [list of strings, default null]: filter for the type of retrieved PixKeys. Options: "cpf", "cnpj", "phone", "email", "evp".
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of PixKey objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PixKey> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<PixKey> keys;
        public String cursor;

        public Page(List<PixKey> keys, String cursor) {
            this.keys = keys;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged PixKeys
     * <p>
     * Receive a list of up to 100 PixKey objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your keys.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "registered", "canceled", "failed".
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [list of strings, default null]: filter for the type of retrieved PixKeys. Options: "cpf", "cnpj", "phone", "email", "evp".
     * <p>
     * Return:
     * @return PixKey.Page object:
     * PixKey.Page.keys: list of PixKey objects with updated attributes
     * PixKey.Page.cursor: cursor to retrieve the next page of PixKey objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return page(params, null);
    }

    /**
     * Retrieve paged PixKeys
     * <p>
     * Receive a list of up to 100 PixKey objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your keys.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixKey.Page object:
     * PixKey.Page.keys: list of PixKey objects with updated attributes
     * PixKey.Page.cursor: cursor to retrieve the next page of PixKey objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PixKeys
     * <p>
     * Receive a list of up to 100 PixKey objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your keys.
     * <p>
     * Return:
     * @return PixKey.Page object:
     * PixKey.Page.keys: list of PixKey objects with updated attributes
     * PixKey.Page.cursor: cursor to retrieve the next page of PixKey objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PixKeys
     * <p>
     * Receive a list of up to 100 PixKey objects previously created in the Stark Infra API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your keys.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null]: date filter for objects created after a specified date. ex: "2020-04-29"
     * before [string, default null]: date filter for objects created before a specified date. ex: "2020-04-30"
     * status [list of strings, default null]: filter for status of retrieved objects. Options: "created", "registered", "canceled", "failed".
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * type [list of strings, default null]: filter for the type of retrieved PixKeys. Options: "cpf", "cnpj", "phone", "email", "evp".
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixKey.Page object:
     * PixKey.Page.keys: list of PixKey objects with updated attributes
     * PixKey.Page.cursor: cursor to retrieve the next page of PixKey objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
        List<PixKey> keys = new ArrayList<>();
        for (SubResource key: page.entities) {
            keys.add((PixKey) key);
        }
        return new Page(keys, page.cursor);
    }

    /**
     * Create a PixKey
     * <p>
     * Send a PixKey object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param key [PixKey object or HashMap]: PixKey object to be created in the API
     * <p>
     * Return:
     * @return PixKey object with updated attributes
     * @throws Exception error in the request
     */
    public static PixKey create(PixKey key) throws Exception {
        return PixKey.create(key, null);
    }

    /**
     * Create a PixKey
     * <p>
     * Send a PixKey object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param key [PixKey object or HashMaps]: PixKey object to be created in the API
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixKey object with updated attributes
     * @throws Exception error in the request
     */
    public static PixKey create(PixKey key, User user) throws Exception {
        return Rest.postSingle(data, key, user);
    }

    /**
     * Update notification PixKey entity
     * <p>
     * Update the PixKey by passing id.
     * <p>
     * Parameters:
     * @param id        [string]: PixKey id. ex: '5656565656565656'
     * @param patchData map of patch parameters
     *                  reason [string, default null]: reason why the PixKey is being patched. Options: "branchTransfer", "reconciliation" or "userRequested".
     *                  accountCreated [string, default null]: opening Date or DateTime for the account to be linked. ex: "2020-03-10".
     *                  accountNumber [string, default null]: number of the account to be linked. ex: "76543".
     *                  accountType [string, default null]: type of the account to be linked. Options: "checking", "savings", "salary" or "payment".
     *                  branchCode [string, default null]: branch code of the account to be linked. ex: 1234".
     *                  name [string, default null]: holder's name of the account to be linked. ex: "Jamie Lannister".
     * <p>
     * Return:
     * @return PixKey object with updated attributes
     * @throws Exception error in the request
     */
    public static PixKey update(String id, Map<String, Object> patchData) throws Exception {
        return PixKey.update(id, patchData, null);
    }

    /**
     * Update notification PixKey entity
     * <p>
     * Update notification PixKey by passing id.
     * <p>
     * Parameters:
     * @param id        [string]: PixKey id. ex: '5656565656565656'
     * @param patchData map of patch parameters
     *                  reason [string, default null]: reason why the PixKey is being patched. Options: "branchTransfer", "reconciliation" or "userRequested".
     *                  accountCreated [string, default null]: opening Date or DateTime for the account to be linked. ex: "2020-03-10".
     *                  accountNumber [string, default null]: number of the account to be linked. ex: "76543".
     *                  accountType [string, default null]: type of the account to be linked. Options: "checking", "savings", "salary" or "payment".
     *                  branchCode [string, default null]: branch code of the account to be linked. ex: 1234".
     *                  name [string, default null]: holder's name of the account to be linked. ex: "Jamie Lannister".
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixKey object with updated attributes
     * @throws Exception error in the request
     */
    public static PixKey update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "PixKeyLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public PixKey key;

        /**
         * PixKey Log object
         * <p>
         * Every time a PixKey entity is modified, a corresponding PixKey Log
         * is generated for the entity. This log is never generated by the
         * user.
         * <p>
         * Attributes:
         * @param id [string]: unique id returned when the log is created. ex: "5656565656565656"
         * @param key [PixKey]: PixKey entity to which the log refers to.
         * @param errors [list of strings]: list of errors linked to the PixKey event.
         * @param type [string]: type of the PixKey event which triggered the log creation. ex: "processing" or "success"
         * @param created [string]: creation datetime for the log. ex: "2020-03-10"
         */
        public Log(String created, String type, List<ErrorElement> errors, PixKey key, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.key = key;
        }

        /**
         * Retrieve a specific PixKey Log
         * <p>
         * Receive a single PixKey Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return PixKey Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific PixKey Log
         * <p>
         * Receive a single PixKey Log object previously created by the Stark Infra API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return PixKey Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve PixKey Logs
         * <p>
         * Receive a generator of PixKey.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * ids [list of strings, default null]: Log ids to filter PixKey Logs. ex: ["5656565656565656"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after specified date. ex: "2020-04-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-04-30"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * keyIds [list of strings, default null]: list of PixKey IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of PixKey Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve PixKey Logs
         * <p>
         * Receive a generator of PixKey.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return generator of PixKey Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve PixKey Logs
         * <p>
         * Receive a generator of PixKey.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Return:
         * @return generator of PixKey Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve PixKey Logs
         * <p>
         * Receive a generator of PixKey.Log objects previously created in the Stark Infra API.
         * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * ids [list of strings, default null]: Log ids to filter PixKey Logs. ex: ["5656565656565656"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after specified date. ex: "2020-04-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-04-30"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * keyIds [list of strings, default null]: list of PixKey IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of PixKey Log objects with updated attributes
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
         * Retrieve paged PixKey.Logs
         * <p>
         * Receive a list of up to 100 PixKey.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your keys.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter PixKey Logs. ex: ["5656565656565656"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after specified date. ex: "2020-04-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-04-30"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * keyIds [list of strings, default null]: list of PixKey IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return PixKey.Log.Page object:
         * PixKey.Log.Page.logs: list of PixKey.Log objects with updated attributes
         * PixKey.Log.Page.cursor: cursor to retrieve the next page of PixKey.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged PixKey.Logs
         * <p>
         * Receive a list of up to 100 PixKey.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your keys.
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return PixKey.Log.Page object:
         * PixKey.Log.Page.logs: list of PixKey.Log objects with updated attributes
         * PixKey.Log.Page.cursor: cursor to retrieve the next page of PixKey.Log objects
         * @throws Exception error in the request
         */
        public static Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged PixKey.Logs
         * <p>
         * Receive a list of up to 100 PixKey.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your keys.
         * <p>
         * Return:
         * @return PixKey.Log.Page object:
         * PixKey.Log.Page.logs: list of PixKey.Log objects with updated attributes
         * PixKey.Log.Page.cursor: cursor to retrieve the next page of PixKey.Log objects
         * @throws Exception error in the request
         */
        public static Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged PixKey.Logs
         * <p>
         * Receive a list of up to 100 PixKey.Log objects previously created in the Stark Infra API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your keys.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * ids [list of strings, default null]: Log ids to filter PixKey Logs. ex: ["5656565656565656"]
         * limit [integer, default null]: maximum number of objects to be retrieved. Max = 100. ex: 35
         * after [string, default null]: date filter for objects created after specified date. ex: "2020-04-29"
         * before [string, default null]: date filter for objects created before a specified date. ex: "2020-04-30"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * keyIds [list of strings, default null]: list of PixKey IDs to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
         * <p>
         * Return:
         * @return PixKey.Log.Page object:
         * PixKey.Log.Page.logs: list of PixKey.Log objects with updated attributes
         * PixKey.Log.Page.cursor: cursor to retrieve the next page of PixKey.Log objects
         * @throws Exception error in the request
         */
        public static Page page(Map<String, Object> params, User user) throws Exception {
            com.starkinfra.utils.Page page = Rest.getPage(data, params, user);
            List<Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }
}
