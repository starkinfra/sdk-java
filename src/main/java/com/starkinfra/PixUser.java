package com.starkinfra;

import com.starkinfra.utils.Rest;
import com.starkinfra.utils.Resource;
import com.starkcore.utils.SubResource;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class PixUser extends Resource {
    /**
     * PixUser object
     * <p>
     * Pix Users are used to get fraud statistics of a user.
     * <p>
     * Parameters:
     * id [string]: user tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * statistics [list of PixUser.Statistics, default []]: list of PixUser.Statistics objects. ex: [PixUser.Statistics(after="2023-11-06T18:57:08.325090+00:00", source="pix-key")]
     *
     */
    static Resource.ClassData data = new Resource.ClassData(PixUser.class, "PixUser");

    public List<PixUser.Statistics> statistics;

    /**
     * PixUser object
     * <p>
     * Pix Users are used to get fraud statistics of a user.
     * <p>
     * Parameters:
     * @param id [string]: user tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * @param statistics [list of PixUser.Statistics, default []]: list of PixUser.Statistics objects. ex: [PixUser.Statistics(after="2023-11-06T18:57:08.325090+00:00", source="pix-key")]
     */
    public PixUser(String id, List<PixUser.Statistics> statistics)
    {
        super(id);
        this.statistics = statistics;
    }

    /**
     * PixUser object
     * <p>
     * Pix Users are used to get fraud statistics of a user.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the PixUser
     * id [string]: user tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * <p>
     * Attributes (return-only):
     * statistics [list of PixUser.Statistics, default []]: list of PixUser.Statistics objects. ex: [PixUser.Statistics(after="2023-11-06T18:57:08.325090+00:00", source="pix-key")]
     * @throws Exception error in the request
     */
    public PixUser(Map<String, Object> data) throws Exception {

        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);

        this.statistics = parseStatistics((List<Object>) dataCopy.remove("statistics"));

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    /**
     * Retrieve a specific PixUser
     * <p>
     * Receive a single PixUser object information by passing its taxId
     * <p>
     * Parameters:
     * @param id [string]: user tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * <p>
     * Return:
     * @return PixUser object with updated attributes
     * @throws Exception error in the request
     */
    public static PixUser get(String id) throws Exception {
        return PixUser.get(id, null, null);
    }

    /**
     * Retrieve a specific PixUser
     * <p>
     * Receive a single PixUser object information by passing its taxId
     * <p>
     * Parameters:
     * @param id [string]: user tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * @param params parameters for the query
     * keyId [string]: marked PixKey id. ex: "+5511989898989"
     * <p>
     * Return:
     * @return PixUser object with updated attributes
     * @throws Exception error in the request
     */
    public static PixUser get(String id, Map<String, Object> params) throws Exception {
        return PixUser.get(id, params, null);
    }

    /**
     * Retrieve a specific PixUser
     * <p>
     * Receive a single PixUser object information by passing its taxId
     * <p>
     * Parameters:
     * @param id [string]: user tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixUser object with updated attributes
     * @throws Exception error in the request
     */
    public static PixUser get(String id, Map<String, Object> params, User user) throws Exception {
        return Rest.getId(data, id, params, user);
    }

    private List<PixUser.Statistics> parseStatistics(List<Object> statistics) throws Exception {
        if (statistics == null)
            return null;

        List<PixUser.Statistics> parsed = new ArrayList<>();
        if (statistics.size() == 0 || statistics.get(0) instanceof PixUser.Statistics) {
            for (Object rule : statistics) {
                parsed.add((PixUser.Statistics) rule);
            }
            return parsed;
        }

        return parsed;
    }

    /**
     * PixUser.Statistics object
     * <p>
     * The PixUser.Statistics object are used to see fraud statistics of a user.
     * <p>
     * Parameters:
     * source [string]: source of PixUser. ex: "pix-fraud"
     * type [string]: type of PixUser. Options: "settled", "registered", "denied", "mule", "scam", "other"
     * value [string]: value of PixUser. ex: "0"
     * after [string]: after datetime for the PixUser. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the PixUser. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    public final static class Statistics extends SubResource{
        public String source;
        public String type;
        public String value;
        public String after;
        public String updated;

        /**
         * PixUser.Statistics object
         * <p>
         * The PixUser.Statistics object are used to see fraud statistics of a user.
         * <p>
         * Parameters:
         * @param source [string]: source of PixUser. ex: "pix-fraud"
         * @param type [string]: type of PixUser. Options: "settled", "registered", "denied", "mule", "scam", "other"
         * @param value [string]: value of PixUser. ex: "0"
         * @param after [string]: after datetime for the PixUser. ex: "2020-03-10 10:30:00.000000+00:00"
         * @param updated [string]: latest update datetime for the PixUser. ex: "2020-03-10 10:30:00.000000+00:00"
         */
        public Statistics(String source, String type, String value, String after, String updated){
            this.source = source;
            this.type = type;
            this.value = value;
            this.after = after;
            this.updated = updated;
        }
    }
}
