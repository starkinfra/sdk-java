package utils;

import com.starkinfra.Key;
import com.starkinfra.Project;
import com.starkinfra.Settings;

import java.net.URLDecoder;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Set;

import com.google.gson.JsonParser;
import com.google.gson.JsonObject;


// Shared by the tests that replace only the network: a throwaway project, and readers for what the fake recorded.
public class AiBoundary {

    public static void useThrowawayProject() throws Exception {
        Settings.user = new Project("sandbox", "5656565656565656", Key.create().privatePem);
    }

    public static String path(String target) {
        int question = target.indexOf('?');
        return question < 0 ? target : target.substring(0, question);
    }

    // starkcore writes the query as "?&a=b&c=d"; what matters is the decoded pairs
    public static List<String> queryPairs(String target) throws Exception {
        List<String> pairs = new ArrayList<>();
        if (target.indexOf('?') < 0) {
            return pairs;
        }
        for (String pair : target.substring(target.indexOf('?') + 1).split("&")) {
            if (pair.isEmpty()) {
                continue;
            }
            pairs.add(URLDecoder.decode(pair, "UTF-8"));
        }
        return pairs;
    }

    public static JsonObject json(String body) {
        return JsonParser.parseString(body).getAsJsonObject();
    }

    public static Set<String> keys(String body) {
        return new TreeSet<>(json(body).keySet());
    }
}
