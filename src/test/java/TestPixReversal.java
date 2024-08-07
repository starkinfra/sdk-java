import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.PixReversal;
import com.starkinfra.utils.Generator;
import com.starkinfra.error.InvalidSignatureError;

import java.util.List;
import java.util.UUID;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


public class TestPixReversal {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<PixReversal> reversals = new ArrayList<>();
        reversals.add(example());
        reversals = PixReversal.create(reversals);

        for (PixReversal reversal : reversals) {
            Assert.assertNotNull(reversal.id);
            String id = PixReversal.get(reversal.id).id;
            Assert.assertEquals(id, reversal.id);
        }
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "success");
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixReversal> reversals = PixReversal.query(params);

        int i = 0;
        for (PixReversal reversal : reversals) {
            i += 1;
            reversal = PixReversal.get(reversal.id);
            System.out.println(reversal);
        }
        System.out.println(i);
    }

    @Test
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixReversal.Log> logs = PixReversal.Log.query(params);

        int i = 0;
        for (PixReversal.Log log : logs) {
            i += 1;
            log = PixReversal.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.reversal.id);
            System.out.println(log);
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixReversal> reversals = PixReversal.query(params);

        ArrayList<String> reversalsIdsExpected = new ArrayList<>();
        for (PixReversal reversal : reversals) {
            Assert.assertNotNull(reversal.id);
            reversalsIdsExpected.add(reversal.id);
        }

        params.put("ids", reversalsIdsExpected.toArray(new String[0]));
        Generator<PixReversal> reversalsResult = PixReversal.query(params);

        ArrayList<String> reversalsIdsResult = new ArrayList<>();
        for (PixReversal reversal : reversalsResult){
            Assert.assertNotNull(reversal.id);
            reversalsIdsResult.add(reversal.id);
        }

        Collections.sort(reversalsIdsExpected);
        Collections.sort(reversalsIdsResult);
        Assert.assertEquals(reversalsIdsExpected, reversalsIdsResult);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            PixReversal.Page page = PixReversal.page(params);
            for (PixReversal reversal: page.reversals) {
                System.out.println(reversal);
                if (ids.contains(reversal.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(reversal.id);
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
    public void testLogPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            PixReversal.Log.Page page = PixReversal.Log.page(params);
            for (PixReversal.Log log: page.logs) {
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

    @Test
    public void testResponse() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> datas = new HashMap<>();
        datas.put("status", "denied");
        datas.put("reason", "accountClosed");

        HashMap<String, Object> data = new HashMap<>();
        data.put("authorization", datas);

        String response = PixReversal.response(data);
        Assert.assertNotNull(response);
        System.out.println(response);
    }

    @Test
    public void testPixReversalParse() throws Exception{
        String content = "{\"status\": \"processing\", \"returnId\": \"D34052649202212081809BSc6b12oLsF\", \"amount\": 10, \"updated\": \"2022-12-08T18:09:38.344943+00:00\", \"tags\": [\"lannister\", \"chargeback\"], \"reason\": \"fraud\", \"created\": \"2022-12-08T18:09:38.344936+00:00\", \"flow\": \"in\", \"id\": \"5685338043318272\", \"endToEndId\": \"E35547753202201201450oo8srGorhf1\"}";
        String validSignature = "MEQCIFiONlW6TV4+U3XWfACP2IttNrxPi8E++FCuXEsf1NjuAiAD2wktgT1tTzxcz+MMJWDPuw3PZjp2kJG+Wf9yF1lcGg==";
        Settings.user = utils.User.defaultProject();

        PixReversal reversal = PixReversal.parse(content, validSignature);
        System.out.println(reversal);
    }

    @Test
    public void testPixReversalParseInvalidSignature() throws Exception{
        String content = "{\"amount\": 1, \"bankCode\": \"20018183\", \"created\": \"2022-03-10T20:52:42.071257+00:00\", \"endToEndId\": \"E01572667202203101930az8mguuaoBZ\", \"externalId\": \"java-ac477bfe-5a39-4de8-8747-56b12cc66a32\", \"fee\": 35, \"flow\": \"out\", \"id\": \"5924184966299648\", \"reason\": \"fraud\", \"returnId\": \"D20018183202203102052ueYgps4qBTE\", \"status\": \"success\", \"updated\": \"2022-03-10T20:52:47.555513+00:00\"}";
        String invalidSignature = "MEUCIQC7FVhXdripx/aXg5yNLxmNoZlehpyvX3QYDXJ8o02X2QIgVwKfJKuIS5RDq50NC/+55h/7VccDkV1vm8Q/7jNu0VM=";
        Settings.user = utils.User.defaultProject();

        try{
            PixReversal.parse(content, invalidSignature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }

    @Test
    public void testPixReversalParseMalformedSignature() throws Exception{
        String content = "{\"amount\": 1, \"bankCode\": \"20018183\", \"created\": \"2022-03-10T20:52:42.071257+00:00\", \"endToEndId\": \"E01572667202203101930az8mguuaoBZ\", \"externalId\": \"java-ac477bfe-5a39-4de8-8747-56b12cc66a32\", \"fee\": 35, \"flow\": \"out\", \"id\": \"5924184966299648\", \"reason\": \"fraud\", \"returnId\": \"D20018183202203102052ueYgps4qBTE\", \"status\": \"success\", \"updated\": \"2022-03-10T20:52:47.555513+00:00\"}";
        String malformedSignature = "malformed signature";
        Settings.user = utils.User.defaultProject();

        try{
            PixReversal.parse(content, malformedSignature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }

    static PixReversal example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", Long.valueOf(100000));
        data.put("externalId", "java-" + UUID.randomUUID().toString());
        data.put("reason", "fraud");
        data.put("endToEndId", utils.EndToEndId.get());
        data.put("description", "reversal details");
        return new PixReversal(data);
    }
}
