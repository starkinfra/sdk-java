import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Event;
import com.starkinfra.Settings;
import com.starkinfra.PixPullSubscription;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestPixPullSubscription {

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixPullSubscription> subscriptions = PixPullSubscription.query(params);

        int i = 0;
        for (PixPullSubscription subscription : subscriptions) {
            i += 1;
            PixPullSubscription getSubscription = PixPullSubscription.get(subscription.id);
            Assert.assertEquals(getSubscription.id, subscription.id);
        }
        Assert.assertTrue(i > 0);
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
            PixPullSubscription.Page page = PixPullSubscription.page(params);
            for (PixPullSubscription subscription : page.subscriptions) {
                if (ids.contains(subscription.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(subscription.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }

        Assert.assertTrue(ids.size() > 0);
    }

    @Test
    public void testLogQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixPullSubscription.Log> logs = PixPullSubscription.Log.query(params);

        int i = 0;
        for (PixPullSubscription.Log log : logs) {
            i += 1;
            log = PixPullSubscription.Log.get(log.id);
            Assert.assertNotNull(log.id);
        }
        Assert.assertTrue(i > 0);
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
            PixPullSubscription.Log.Page page = PixPullSubscription.Log.page(params);
            for (PixPullSubscription.Log log : page.logs) {
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

        Assert.assertTrue(ids.size() > 0);
    }

    @Test
    public void testEventParseAndVerify() throws Exception {
        Settings.user = utils.User.defaultProject();

        String content = "{\"event\": {\"created\": \"2026-03-17T20:24:02.006080+00:00\", \"id\": \"5739991880695808\", \"log\": {\"created\": \"2026-03-17T20:23:58.050406+00:00\", \"errors\": [], \"id\": \"5340798381981696\", \"reason\": \"\", \"subscription\": {\"amount\": 52064, \"amountMinLimit\": 0, \"bacenId\": \"RR321606372026170317231564231\", \"created\": \"2026-03-17T20:23:57.255567+00:00\", \"description\": \"A Lannister always pays his debts\", \"due\": \"2026-04-17T02:59:59.999000+00:00\", \"externalId\": \"606512134\", \"flow\": \"out\", \"id\": \"5656970050666496\", \"installmentEnd\": \"\", \"installmentStart\": \"2026-03-18T02:59:59.999999+00:00\", \"interval\": \"month\", \"pullRetryLimit\": 3, \"receiverBankCode\": \"32160637\", \"receiverName\": \"Stark Bank\", \"receiverTaxId\": \"39.908.427/0001-28\", \"referenceCode\": \"36135971\", \"senderAccountNumber\": \"55213\", \"senderBankCode\": null, \"senderBranchCode\": \"356\", \"senderCityCode\": \"\", \"senderFinalName\": \"STARK SCD S.A.\", \"senderFinalTaxId\": \"39.908.427/0001-28\", \"senderTaxId\": \"99.999.919/9999-79\", \"status\": \"created\", \"tags\": [], \"type\": \"push\", \"updated\": \"2026-03-17T20:23:58.050421+00:00\"}, \"type\": \"delivering\"}, \"subscription\": \"pix-pull-subscription\", \"workspaceId\": \"4828094443552768\"}}";
        String validSignature = "MEUCIQCCZWR4+JYoDNENLnRbSCGGZf+atOaG4q8jWB3ADgc+DQIgIZ1LuXLZ06pke2qzaMNTlDLwcriuH+S3ve1aTQeqNK0=";

        Event parsed = Event.parse(content, validSignature);
        Assert.assertNotNull(parsed.id);
    }
}
