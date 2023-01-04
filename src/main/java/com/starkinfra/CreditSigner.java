package com.starkinfra;

import com.starkcore.utils.Resource;

import java.util.Map;
import java.util.HashMap;


public final class CreditSigner extends Resource {
    /**
     * CreditSigner object
     * <p>
     * CreditNote signer's information.
     * <p>
     * Parameters:
     * name [string]: signer's name. ex: "Tony Stark"
     * contact [string]: signer's contact information. ex: "tony@starkindustries.com"
     * method [string]: delivery method for the contract. ex: "link"
     * id [string]: unique id returned when the CreditSigner is created. ex: "5656565656565656"
     *
     */
    static ClassData data = new ClassData(CreditSigner.class, "CreditSigner");

    public String name;
    public String contact;
    public String method;

    /**
     * CreditSigner object
     * <p>
     * CreditNote signer's information.
     * <p>
     * Parameters:
     * @param name [string]: signer's name. ex: "Tony Stark"
     * @param contact [string]: signer's contact information. ex: "tony@starkindustries.com"
     * @param method [string]: delivery method for the contract. ex: "link"
     * @param id [string]: unique id returned when the CreditSigner is created. ex: "5656565656565656"
     */
    public CreditSigner(String name, String contact, String method, String id){
        super(id);
        this.name = name;
        this.contact = contact;
        this.method = method;
    }

    /**
     * CreditSigner object
     * <p>
     * CreditNote signer's information.
     * <p>
     * Parameters (required):
     * @param data map of properties for the creation of the CreditSigner
     * name [string]: signer's name. ex: "Tony Stark"
     * contact [string]: signer's contact information. ex: "tony@starkindustries.com"
     * method [string]: delivery method for the contract. ex: "link"
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when the CreditSigner is created. ex: "5656565656565656"
     */
    public CreditSigner(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.name = (String) dataCopy.remove("name");
        this.contact = (String) dataCopy.remove("contact");
        this.method = (String) dataCopy.remove("method");

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }
}
