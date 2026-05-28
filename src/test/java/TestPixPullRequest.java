import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Event;
import com.starkinfra.Settings;
import com.starkinfra.PixPullRequest;
import com.starkinfra.PixPullSubscription;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.EndToEndId;

import java.util.List;
import java.util.UUID;
import java.util.HashMap;
import java.util.ArrayList;


public class TestPixPullRequest {

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixPullRequest> requests = PixPullRequest.query(params);

        int i = 0;
        for (PixPullRequest request : requests) {
            i += 1;
            PixPullRequest getRequest = PixPullRequest.get(request.id);
            Assert.assertEquals(getRequest.id, request.id);
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
            PixPullRequest.Page page = PixPullRequest.page(params);
            for (PixPullRequest request : page.requests) {
                if (ids.contains(request.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(request.id);
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
        Generator<PixPullRequest.Log> logs = PixPullRequest.Log.query(params);

        int i = 0;
        for (PixPullRequest.Log log : logs) {
            i += 1;
            log = PixPullRequest.Log.get(log.id);
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
            PixPullRequest.Log.Page page = PixPullRequest.Log.page(params);
            for (PixPullRequest.Log log : page.logs) {
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

        String content = "{\"event\": {\"created\": \"2026-03-17T22:17:48.687366+00:00\", \"id\": \"5980132964564992\", \"log\": {\"created\": \"2026-03-17T22:17:44.741312+00:00\", \"description\": \"The Pix Pull Request was created in Stark Infra.\", \"errors\": [], \"id\": \"4777799707525120\", \"reason\": \"\", \"request\": {\"amount\": 79562, \"attemptType\": \"default\", \"created\": \"2026-03-17T22:17:44.727124+00:00\", \"description\": \"Monthly fare\", \"due\": \"2026-03-18T19:17:44.382949+00:00\", \"endToEndId\": \"E32160637202617031917FXbuEOeqxTE\", \"flow\": \"out\", \"id\": \"5859939668983808\", \"receiverAccountNumber\": \"00000000\", \"receiverAccountType\": \"payment\", \"receiverBankCode\": \"32160637\", \"receiverBranchCode\": \"\", \"receiverName\": \"Stark Bank\", \"receiverTaxId\": \"39.908.427/0001-28\", \"reconciliationId\": \"20260317191744.382994-03001917VKqeyyGMWvK\", \"senderBankCode\": null, \"senderFinalName\": \"STARK SCD S.A.\", \"senderFinalTaxId\": \"39.908.427/0001-28\", \"senderTaxId\": \"99.999.919/9999-79\", \"status\": \"created\", \"subscriptionBacenId\": \"RR321606372026170319175775651\", \"subscriptionId\": \"6366699370577920\", \"tags\": [], \"updated\": \"2026-03-17T22:17:45.560279+00:00\"}, \"type\": \"created\"}, \"subscription\": \"pix-pull-request\", \"workspaceId\": \"4828094443552768\"}}";
        String validSignature = "MEUCIQDPci6mVcRQUqQazbol04cYvz8Ffuhh0birk4+8jSUH4AIgKlLhIH5zKzu+4jQlyabvSJin+8+5kJKiJpoqSQPCITg=";

        Event parsed = Event.parse(content, validSignature);
        Assert.assertNotNull(parsed.id);
    }

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<PixPullRequest> requests = new ArrayList<>();
        requests.add(example());
        requests = PixPullRequest.create(requests);

        for (PixPullRequest request : requests) {
            Assert.assertNotNull(request.id);
            Assert.assertEquals(request.id, PixPullRequest.get(request.id).id);
        }
    }

    @Test
    public void testCancel() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("status", "created");

        String requestId = null;
        for (PixPullRequest request : PixPullRequest.query(params)) {
            requestId = request.id;
            break;
        }
        if (requestId == null) {
            throw new Exception("No PixPullRequest with status 'created' available in sandbox to seed cancel test");
        }

        PixPullRequest canceled = PixPullRequest.cancel(requestId, "senderUserRequested");
        Assert.assertNotNull(canceled.id);
    }

    @Test
    public void testUpdate() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("status", "delivered");

        String requestId = null;
        for (PixPullRequest request : PixPullRequest.query(params)) {
            requestId = request.id;
            break;
        }
        if (requestId == null) {
            throw new Exception("No PixPullRequest with status 'delivered' available in sandbox to seed update test");
        }

        HashMap<String, Object> patchData = new HashMap<>();
        patchData.put("status", "denied");
        patchData.put("reason", "senderAccountBlocked");

        PixPullRequest updated = PixPullRequest.update(requestId, patchData);
        Assert.assertNotNull(updated.id);
    }

    static PixPullRequest example() throws Exception {
        String bankCode = utils.User.bankCode();

        HashMap<String, Object> subParams = new HashMap<>();
        subParams.put("limit", 1);
        subParams.put("status", "active");
        String subscriptionId = null;
        for (PixPullSubscription s : PixPullSubscription.query(subParams)) {
            subscriptionId = s.id;
            break;
        }
        if (subscriptionId == null) {
            throw new Exception("No active PixPullSubscription available in sandbox to seed PixPullRequest test");
        }

        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", 1000L);
        data.put("due", "2030-01-01T10:00:00.000000+00:00");
        data.put("endToEndId", EndToEndId.create(bankCode));
        data.put("receiverAccountNumber", "00000000");
        data.put("receiverAccountType", "payment");
        data.put("receiverBankCode", bankCode);
        data.put("reconciliationId", UUID.randomUUID().toString().replace("-", "").substring(0, 25));
        data.put("subscriptionId", subscriptionId);
        data.put("attemptType", "default");
        data.put("description", "Monthly fare");
        data.put("tags", new String[]{"java-sdk", "test"});
        return new PixPullRequest(data);
    }
}
