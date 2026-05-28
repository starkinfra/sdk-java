import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Event;
import com.starkinfra.Settings;
import com.starkinfra.PixPullSubscription;
import com.starkinfra.utils.Generator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestPixPullSubscription {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<PixPullSubscription> subscriptions = new ArrayList<>();
        subscriptions.add(example());

        List<PixPullSubscription> created = PixPullSubscription.create(subscriptions);
        Assert.assertTrue(created.size() > 0);
        for (PixPullSubscription subscription : created) {
            Assert.assertNotNull(subscription.id);
            System.out.println(subscription);
        }
    }

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
    public void testUpdate() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "pending");
        Generator<PixPullSubscription> subscriptions = PixPullSubscription.query(params);
        for (PixPullSubscription subscription : subscriptions) {
            HashMap<String, Object> patchData = new HashMap<>();
            patchData.put("status", "denied");
            patchData.put("reason", "userRejected");
            PixPullSubscription updated = PixPullSubscription.update(subscription.id, patchData);
            Assert.assertNotNull(updated.id);
            System.out.println(updated);
        }
    }

    @Test
    public void testCancel() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<PixPullSubscription> toCreate = new ArrayList<>();
        toCreate.add(example());
        List<PixPullSubscription> created = PixPullSubscription.create(toCreate);
        Assert.assertTrue(created.size() > 0);

        for (PixPullSubscription subscription : created) {
            PixPullSubscription canceled = PixPullSubscription.cancel(subscription.id, "receiverUserRequested");
            Assert.assertNotNull(canceled.id);
            Assert.assertEquals(subscription.id, canceled.id);
            System.out.println(canceled);
        }
    }

    @Test
    public void testGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<PixPullSubscription> toCreate = new ArrayList<>();
        toCreate.add(example());
        List<PixPullSubscription> created = PixPullSubscription.create(toCreate);
        Assert.assertTrue(created.size() > 0);

        for (PixPullSubscription subscription : created) {
            PixPullSubscription fetched = PixPullSubscription.get(subscription.id);
            Assert.assertEquals(subscription.id, fetched.id);
            Assert.assertEquals(subscription.externalId, fetched.externalId);
            System.out.println(fetched);
        }
    }

    @Test
    public void testEventParseAndVerify() throws Exception {
        Settings.user = utils.User.defaultProject();

        String content = "{\"event\": {\"created\": \"2026-03-17T20:24:02.006080+00:00\", \"id\": \"5739991880695808\", \"log\": {\"created\": \"2026-03-17T20:23:58.050406+00:00\", \"errors\": [], \"id\": \"5340798381981696\", \"reason\": \"\", \"subscription\": {\"amount\": 52064, \"amountMinLimit\": 0, \"bacenId\": \"RR321606372026170317231564231\", \"created\": \"2026-03-17T20:23:57.255567+00:00\", \"description\": \"A Lannister always pays his debts\", \"due\": \"2026-04-17T02:59:59.999000+00:00\", \"externalId\": \"606512134\", \"flow\": \"out\", \"id\": \"5656970050666496\", \"installmentEnd\": \"\", \"installmentStart\": \"2026-03-18T02:59:59.999999+00:00\", \"interval\": \"month\", \"pullRetryLimit\": 3, \"receiverBankCode\": \"32160637\", \"receiverName\": \"Stark Bank\", \"receiverTaxId\": \"39.908.427/0001-28\", \"referenceCode\": \"36135971\", \"senderAccountNumber\": \"55213\", \"senderBankCode\": null, \"senderBranchCode\": \"356\", \"senderCityCode\": \"\", \"senderFinalName\": \"STARK SCD S.A.\", \"senderFinalTaxId\": \"39.908.427/0001-28\", \"senderTaxId\": \"99.999.919/9999-79\", \"status\": \"created\", \"tags\": [], \"type\": \"push\", \"updated\": \"2026-03-17T20:23:58.050421+00:00\"}, \"type\": \"delivering\"}, \"subscription\": \"pix-pull-subscription\", \"workspaceId\": \"4828094443552768\"}}";
        String validSignature = "MEUCIQCCZWR4+JYoDNENLnRbSCGGZf+atOaG4q8jWB3ADgc+DQIgIZ1LuXLZ06pke2qzaMNTlDLwcriuH+S3ve1aTQeqNK0=";

        Event parsed = Event.parse(content, validSignature);
        Assert.assertNotNull(parsed.id);
    }

    static PixPullSubscription example() throws Exception {
        long suffix = System.currentTimeMillis();
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        HashMap<String, Object> data = new HashMap<>();
        data.put("bacenId", "RR32160637" + today + String.format("%011d", suffix % 100_000_000_000L));
        data.put("externalId", "java-sdk-" + suffix);
        data.put("referenceCode", "java-sdk-ref-" + suffix);
        data.put("installmentStart", "2026-06-01T03:00:00.000000+00:00");
        data.put("interval", "month");
        data.put("receiverName", "Stark Bank");
        data.put("receiverBankCode", "32160637");
        data.put("receiverTaxId", "39.908.427/0001-28");
        data.put("senderAccountNumber", "55213");
        data.put("senderBankCode", "20018183");
        data.put("senderBranchCode", "0001");
        data.put("senderTaxId", "99.999.919/9999-79");
        data.put("type", "push");
        data.put("amount", 1000L);
        data.put("description", "Java SDK sandbox subscription");
        return new PixPullSubscription(data);
    }
}
