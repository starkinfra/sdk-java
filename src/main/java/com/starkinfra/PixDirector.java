package com.starkinfra;

import com.starkinfra.utils.SubResource;
import com.starkinfra.utils.Rest;

import java.util.HashMap;
import java.util.Map;


public final class PixDirector extends SubResource {
    /**
     * PixDirector object
     * <p>
     * Mandatory data that must be registered within the Central Bank for emergency contact purposes.
     * When you initialize a PixDirector, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * name       [string]: name of the PixDirector. ex: "Edward Stark".
     * taxId      [string]: tax ID (CPF/CNPJ) of the PixDirector. ex: "03.300.300/0001-00"
     * phone      [string]: phone of the PixDirector. ex: "+55-1198989898"
     * email      [string]: email of the PixDirector. ex: "ned.stark@starkbank.com"
     * password   [string]: password of the PixDirector. ex: "12345678"
     * teamEmail  [string]: team email. ex: "aria.stark@starkbank.com"
     * teamPhones [list of strings]: list of phones of the team. ex: ["+55-11988889999", "+55-11988889998"]
     * id         [string]: unique id returned when the PixDirector is created. ex: "5656565656565656"
     * status     [string]: current PixDirector status. ex: "success"
     */
    static ClassData data = new ClassData(PixDirector.class, "PixDirector");

    public String name;
    public String taxId;
    public String phone;
    public String email;
    public String password;
    public String teamEmail;
    public String[] teamPhones;
    public String status;

    /**
     * PixDirector object
     * <p>
     * When you initialize a PixDirector, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param name [string]: name of the PixDirector. ex: "Edward Stark".
     * @param taxId [string]: tax ID (CPF/CNPJ) of the PixDirector. ex: "03.300.300/0001-00"
     * @param phone [string]: phone of the PixDirector. ex: "+55-1198989898"
     * @param email [string]: email of the PixDirector. ex: "ned.stark@starkbank.com"
     * @param password [string]: password of the PixDirector. ex: "12345678"
     * @param teamEmail [string]: team email. ex: "aria.stark@starkbank.com"
     * @param teamPhones [list of strings]: list of phones of the team. ex: ["+55-11988889999", "+55-11988889998"]
     * @param id [string]: unique id returned when the PixDirector is created. ex: "5656565656565656"
     * @param status [string]: current PixDirector status. ex: "success"
     *
     */
    public PixDirector(String name, String taxId, String phone, String email, String password, String teamEmail,
                       String[] teamPhones, String id, String status) {
        this.name = name;
        this.taxId = taxId;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.teamEmail = teamEmail;
        this.teamPhones = teamPhones;
        this.status = status;
    }

    /**
     * PixDirector object
     * <p>
     * Mandatory data that must be registered within the Central Bank for emergency contact purposes.
     * When you initialize a PixDirector, the entity will not be automatically
     * created in the Stark Infra API. The 'create' function sends the objects
     * to the Stark Infra API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the PixDirector
     * name       [string]: name of the PixDirector. ex: "Edward Stark".
     * taxId      [string]: tax ID (CPF/CNPJ) of the PixDirector. ex: "03.300.300/0001-00"
     * phone      [string]: phone of the PixDirector. ex: "+55-1198989898"
     * email      [string]: email of the PixDirector. ex: "ned.stark@starkbank.com"
     * password   [string]: password of the PixDirector. ex: "12345678"
     * teamEmail  [string]: team email. ex: "aria.stark@starkbank.com"
     * teamPhones [list of strings]: list of phones of the team. ex: ["+55-11988889999", "+55-11988889998"]
     * <p>
     * Attributes (return-only):
     * status     [string]: current PixDirector status. ex: "success"
     * @throws Exception error in the request
     */
    public PixDirector(Map<String, Object> data) throws Exception {
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.name = (String) dataCopy.remove("name");
        this.taxId = (String) dataCopy.remove("taxId");
        this.phone = (String) dataCopy.remove("phone");
        this.email = (String) dataCopy.remove("email");
        this.password = (String) dataCopy.remove("password");
        this.teamEmail = (String) dataCopy.remove("teamEmail");
        this.teamPhones = (String[]) dataCopy.remove("teamPhones");
        this.status = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Create a PixDirector
     * <p>
     * Send a PixDirector object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param director [PixDirector object or HashMap]: PixDirector object to be created in the API
     * <p>
     * Return:
     * @return PixDirector object with updated attributes
     * @throws Exception error in the request
     */
    public static PixDirector create(PixDirector director) throws Exception {
        return PixDirector.create(director, null);
    }

    /**
     * Create a PixDirector
     * <p>
     * Send a PixDirector object for creation in the Stark Infra API
     * <p>
     * Parameters:
     * @param director [PixDirector object or HashMaps]: PixDirector object to be created in the API
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkinfra.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return PixDirector object with updated attributes
     * @throws Exception error in the request
     */
    public static PixDirector create(PixDirector director, User user) throws Exception {
        return Rest.postSingle(data, director, user);
    }
}
