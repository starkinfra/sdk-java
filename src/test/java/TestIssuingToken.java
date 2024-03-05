import com.starkinfra.*;
import org.junit.Test;
import org.junit.Assert;
import com.starkinfra.utils.Generator;
import com.starkinfra.error.InvalidSignatureError;

import java.util.*;

public class TestIssuingToken {
    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingToken> tokens = IssuingToken.query(params);

        for (IssuingToken token : tokens) {
            IssuingToken expectedToken = IssuingToken.get(token.id);
            Assert.assertNotNull(token.id, expectedToken.id);
            System.out.println(expectedToken);
        }
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingToken.Page page = IssuingToken.page(params);
            for (IssuingToken token: page.tokens) {
                System.out.println(token);
                if (ids.contains(token.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(token.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }

        if (ids.size() != 4) {
            throw new Exception("ids.size() != 4");
        }
    }

    @Test
    public void testUpdateStatus() throws Exception {
        Settings.user = utils.User.defaultProject();

        Map<String, Object> patchData = new HashMap<>();;
        patchData.put("status", "blocked");

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("status", "active");
        Generator<IssuingToken> tokens = IssuingToken.query(params);
        for (IssuingToken token : tokens) {
            IssuingToken updatedIssuingToken = IssuingToken.update(token.id, patchData);
            Assert.assertNotNull(updatedIssuingToken.id);
        }
    }

    @Test
    public void testCancel() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("status", "active");
        Generator<IssuingToken> tokens = IssuingToken.query(params);
        for (IssuingToken token : tokens) {
            IssuingToken canceledIssuingToken = IssuingToken.cancel(token.id);
            Assert.assertNotNull(canceledIssuingToken.id);
            System.out.println(canceledIssuingToken);
        }
    }

    @Test
    public void testIssuingTokenParseRight() throws Exception{
        String content = "{\"deviceName\": \"My phone\", \"methodCode\": \"manual\", \"walletName\": \"Google Pay\", \"activationCode\": \"\", \"deviceSerialNumber\": \"2F6D63\", \"deviceImei\": \"352099001761481\", \"deviceType\": \"Phone\", \"walletInstanceId\": \"1b24f24a24ba98e27d43e345b532a245e4723d7a9c4f624e\", \"deviceOsVersion\": \"4.4.4\", \"cardId\": \"5189831499972623\", \"deviceOsName\": \"Android\", \"merchantId\": \"12345678901\", \"walletId\": \"google\"}";
        String validSignature = "MEYCIQC4XbhjxEp9VhowLeg9JbSOo94FCRWE9GI7l7OuHh0bUwIhAJBuLDl5DAT9L4iMI0qYQ+PVmBIG5scxxvkWSsoWmwi4";
        Settings.user = utils.User.defaultProject();

        IssuingToken token = IssuingToken.parse(content, validSignature);
        System.out.println(token);
    }

    @Test
    public void testIssuingTokenInvalidSignature() throws Exception{
        String content = "{\"deviceName\": \"My phone\", \"methodCode\": \"manual\", \"walletName\": \"Google Pay\", \"activationCode\": \"\", \"deviceSerialNumber\": \"2F6D63\", \"deviceImei\": \"352099001761481\", \"deviceType\": \"Phone\", \"walletInstanceId\": \"1b24f24a24ba98e27d43e345b532a245e4723d7a9c4f624e\", \"deviceOsVersion\": \"4.4.4\", \"cardId\": \"5189831499972623\", \"deviceOsName\": \"Android\", \"merchantId\": \"12345678901\", \"walletId\": \"google\"}";
        String invalidSignature = "MEUCIQDOpo1j+V40DNZK2URL2786UQK/8mDXon9ayEd8U0/l7AIgYXtIZJBTs8zCRR3vmted6Ehz/qfw1GRut/eYyvf1yOk=";
        Settings.user = utils.User.defaultProject();

        try{
            IssuingToken.parse(content, invalidSignature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }

    @Test
    public void testIssuingTokenParseMalformedSignature() throws Exception{
        String content = "{\"deviceName\": \"My phone\", \"methodCode\": \"manual\", \"walletName\": \"Google Pay\", \"activationCode\": \"\", \"deviceSerialNumber\": \"2F6D63\", \"deviceImei\": \"352099001761481\", \"deviceType\": \"Phone\", \"walletInstanceId\": \"1b24f24a24ba98e27d43e345b532a245e4723d7a9c4f624e\", \"deviceOsVersion\": \"4.4.4\", \"cardId\": \"5189831499972623\", \"deviceOsName\": \"Android\", \"merchantId\": \"12345678901\", \"walletId\": \"google\"}";
        String malformedSignature = "malformed signature";
        Settings.user = utils.User.defaultProject();

        try{
            IssuingToken.parse(content, malformedSignature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }

    @Test
    public void testResponseAuthorization() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<String> tags = new ArrayList<>();
        tags.add("test");
        tags.add("response");
        tags.add("token-authorization");

        HashMap<String, Object> data = new HashMap<>();
        data.put("status", "approved");
        data.put("designId", "4584031664472031");
        data.put("tags", tags);

        String response = IssuingToken.responseAuthorization(data);
        Assert.assertNotNull(response);
        System.out.println(response);
    }

    @Test
    public void testResponseActivation() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<String> tags = new ArrayList<>();
        tags.add("test");
        tags.add("response");
        tags.add("token-activation");

        HashMap<String, Object> data = new HashMap<>();
        data.put("status", "approved");
        data.put("tags", tags);

        String response = IssuingToken.responseActivation(data);
        Assert.assertNotNull(response);
        System.out.println(response);
    }

    @Test
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingToken.Log> logs = IssuingToken.Log.query(params);

        for (IssuingToken.Log log : logs) {
            log = IssuingToken.Log.get(log.id);
            System.out.println(log);
        }
    }

    @Test
    public void testLogPage() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingToken.Log.Page page = IssuingToken.Log.page(params);
            for (IssuingToken.Log log : page.logs) {
                System.out.println(log);
                if (ids.contains(log.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(log.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }

        if (ids.size() != 4) {
            throw new Exception("ids.size() != 4");
        }
    }
}
