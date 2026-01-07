import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Event;
import com.starkinfra.Settings;
import com.starkinfra.PixInfraction;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.EndToEndId;

import java.util.List;
import java.util.Objects;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


public class TestPixInfraction {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<PixInfraction> infractions = new ArrayList<>();
        infractions.add(example());
        infractions = PixInfraction.create(infractions);
        for (PixInfraction infraction : infractions) {
            Assert.assertNotNull(infraction.id);
            String id = PixInfraction.get(infraction.id).id;
            Assert.assertEquals(id, infraction.id);
        }
    }

    @Test
    public void testCancel() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "delivered");
        Generator<PixInfraction> infractions = PixInfraction.query(params);
        for (PixInfraction infraction : infractions) {
            if (Objects.equals(infraction.flow, "out")) {
                infraction = PixInfraction.cancel(infraction.id);
                Assert.assertEquals(infraction.status, "canceled");
            }
        }
    }

    @Test
    public void testQueryAndCancel() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("status", "delivered");
        int i = 0;
        for (PixInfraction infraction : PixInfraction.query(params)) {
            i ++;
            infraction = PixInfraction.cancel(infraction.id);
            Assert.assertEquals(infraction.status, "canceled");
        }
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        int limit = 3;
        params.put("limit", limit);
        params.put("status", "delivered");
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixInfraction> infractions = PixInfraction.query(params);

        int i = 0;
        for (PixInfraction infraction : infractions) {
            i += 1;
            PixInfraction getInfraction = PixInfraction.get(infraction.id);
            Assert.assertEquals(getInfraction.id, infraction.id);
        }
        Assert.assertTrue(i == limit);
    }

    @Test
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixInfraction.Log> logs = PixInfraction.Log.query(params);

        int i = 0;
        for (PixInfraction.Log log : logs) {
            i += 1;
            log = PixInfraction.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.infraction.id);
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixInfraction> infractions = PixInfraction.query(params);

        ArrayList<String> infractionsIdsExpected = new ArrayList<>();
        for (PixInfraction infraction : infractions) {
            Assert.assertNotNull(infraction.id);
            infractionsIdsExpected.add(infraction.id);
        }

        params.put("ids", infractionsIdsExpected.toArray(new String[0]));
        Generator<PixInfraction> infractionsResult = PixInfraction.query(params);

        ArrayList<String> infractionsIdsResult = new ArrayList<>();
        for (PixInfraction infraction : infractionsResult){
            Assert.assertNotNull(infraction.id);
            infractionsIdsResult.add(infraction.id);
        }

        Collections.sort(infractionsIdsExpected);
        Collections.sort(infractionsIdsResult);
        Assert.assertEquals(infractionsIdsExpected, infractionsIdsResult);
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
            PixInfraction.Page page = PixInfraction.page(params);
            for (PixInfraction infraction: page.infractions) {
                if (ids.contains(infraction.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(infraction.id);
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
            PixInfraction.Log.Page page = PixInfraction.Log.page(params);
            for (PixInfraction.Log log: page.logs) {
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
    public void testUpdateStatus() throws Exception {
        Settings.user = utils.User.defaultProject();
        List<PixInfraction> infractions = getReportToPatch();

        for (PixInfraction infraction : infractions) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("result", "agreed");
            params.put("fraudType", "scam");
            PixInfraction updatedPixInfraction = PixInfraction.update(infraction.id, params);
            Assert.assertNotNull(updatedPixInfraction.id);
        }
    }

    @Test
    public void testEventParsePixInfraction() throws Exception{
        Settings.user = utils.User.defaultProject();

        String content = "{\"event\": {\"created\": \"2025-12-18T18:42:45.820608+00:00\", \"id\": \"6029674738089984\", \"log\": {\"created\": \"2025-12-18T18:42:41.340992+00:00\", \"errors\": [], \"id\": \"4591715356770304\", \"infraction\": {\"amount\": 0, \"analysis\": \"\", \"bacenId\": \"62fd3559-9365-428d-a90d-8bc218e8bb73\", \"created\": \"2025-12-18T18:42:40.389427+00:00\", \"creditedBankCode\": \"52076716\", \"debitedBankCode\": \"32160637\", \"description\": \"Eu acho que eu fui scammado\", \"disputeId\": \"\", \"flow\": \"out\", \"fraudId\": \"\", \"fraudType\": \"\", \"id\": \"5154612831059968\", \"method\": \"other\", \"operatorEmail\": \"fraud@company.com\", \"operatorPhone\": \"+5511989898989\", \"referenceId\": \"E32160637202512091420yaANrbU2bkh\", \"reportedBy\": \"debited\", \"result\": \"\", \"status\": \"created\", \"tags\": [], \"type\": \"reversal\", \"updated\": \"2025-12-18T18:42:41.341010+00:00\"}, \"type\": \"delivering\"}, \"subscription\": \"pix-infraction\", \"workspaceId\": \"4828094443552768\"}}";
        String validSignature = "MEYCIQCQdgvFQzZSs+igH46jV5VqvXTdgtp4lsbGuFH/UUUYGwIhAPw2mglILJLLJRa9XxiEfMqCAA1hsVw/cbqLSom7fGnQ";
        Event event = Event.parse(content, validSignature);

        PixInfraction.Log log = ((Event.PixInfractionEvent) event).log;
        Assert.assertNotNull(log.id);
        Assert.assertNotNull(log.infraction.id);
    }

    public List<PixInfraction> getReportToPatch() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("cursor", null);
        params.put("status", "delivered");
        List<PixInfraction> infractions = new ArrayList<>();
        while (infractions.size() < 1) {
            PixInfraction.Page page = PixInfraction.page(params);
            for (PixInfraction infraction: page.infractions) {
                if (infraction.flow.equals("out")){
                    infractions.add(infraction);
                }
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }
        return(infractions);
    }

    static PixInfraction example() throws Exception{
        String bankCode = utils.User.bankCode();
        HashMap<String, Object> data = new HashMap<>();
        data.put("referenceId", EndToEndId.create(bankCode));
        data.put("type", "reversal");
        data.put("method", "scam");
        data.put("operatorEmail", "ned.stark@company.com");
        data.put("operatorPhone", "+5511999999999");
        return new PixInfraction(data);
    }
}
