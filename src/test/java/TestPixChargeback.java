import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Event;
import com.starkinfra.Settings;
import com.starkinfra.PixRequest;
import com.starkinfra.PixChargeback;
import com.starkinfra.utils.ReturnId;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


public class TestPixChargeback {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<PixChargeback> chargebacks = new ArrayList<>();
        chargebacks.add(example());
        chargebacks = PixChargeback.create(chargebacks);

        for (PixChargeback chargeback : chargebacks) {
            Assert.assertNotNull(chargeback.id);
            String id = PixChargeback.get(chargeback.id).id;
            Assert.assertEquals(id, chargeback.id);
        }
    }

    @Test
    public void testCancel() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("status", "delivered");
        Generator<PixChargeback> chargebacks = PixChargeback.query(params);
        for (PixChargeback chargeback : chargebacks) {
            chargeback = PixChargeback.cancel(chargeback.id);
            Assert.assertEquals(chargeback.status, "canceled");
        }
    }
    
    @Test
    public void testQueryAndCancel() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("status", "created");
        int i = 0;
        for (PixChargeback chargeback : PixChargeback.query(params)) {
            i ++;
            chargeback = PixChargeback.cancel(chargeback.id);
            Assert.assertEquals(chargeback.status, "canceled");
        }
    }
    @Test
    
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixChargeback> chargebacks = PixChargeback.query(params);

        int i = 0;
        for (PixChargeback chargeback : chargebacks) {
            i += 1;
            chargeback = PixChargeback.get(chargeback.id);
            Assert.assertNotNull(chargeback.id);
        }
    }

    @Test
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixChargeback.Log> logs = PixChargeback.Log.query(params);
        int i = 0;
        for (PixChargeback.Log log : logs) {
            i += 1;
            log = PixChargeback.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.chargeback.id);
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixChargeback> chargebacks = PixChargeback.query(params);

        ArrayList<String> chargebacksIdsExpected = new ArrayList<>();
        for (PixChargeback chargeback : chargebacks) {
            Assert.assertNotNull(chargeback.id);
            chargebacksIdsExpected.add(chargeback.id);
        }

        params.put("ids", chargebacksIdsExpected.toArray(new String[0]));
        Generator<PixChargeback> chargebacksResult = PixChargeback.query(params);

        ArrayList<String> chargebacksIdsResult = new ArrayList<>();
        for (PixChargeback chargeback : chargebacksResult){
            Assert.assertNotNull(chargeback.id);
            chargebacksIdsResult.add(chargeback.id);
        }

        Collections.sort(chargebacksIdsExpected);
        Collections.sort(chargebacksIdsResult);
        Assert.assertEquals(chargebacksIdsExpected, chargebacksIdsResult);
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
            PixChargeback.Page page = PixChargeback.page(params);
            for (PixChargeback chargeback: page.chargebacks) {
                if (ids.contains(chargeback.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(chargeback.id);
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
            PixChargeback.Log.Page page = PixChargeback.Log.page(params);
            for (PixChargeback.Log log: page.logs) {
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
    public void testUpdate() throws Exception {
        Settings.user = utils.User.defaultProject();
        String bankCode = utils.User.bankCode();

        String chargebackId = getRequestIdToPatch();
        HashMap<String, Object> patchData = new HashMap<>();
        patchData.put("reversalReferenceId", ReturnId.create(bankCode));
        if (!(chargebackId == null)) {
            PixChargeback updatedPixChargeback = PixChargeback.update(chargebackId, "accepted", patchData);
            Assert.assertNotNull(updatedPixChargeback.id);
        }
        else {
            System.out.println("There are no PixChargebacks to patch");
            Assert.assertNotNull(null);
        }
    }

    @Test
    public void testPixChargebackEventParse() throws Exception {
        Settings.user = utils.User.defaultProject();

        String content = "{\"event\": {\"created\": \"2025-12-19T19:30:25.041795+00:00\", \"id\": \"6723786382508032\", \"log\": {\"chargeback\": {\"amount\": 20000, \"analysis\": \"\", \"bacenId\": \"619ee9c1-4883-4fc3-9b34-a14d3a8f8442\", \"created\": \"2025-12-19T19:30:14.873000+00:00\", \"description\": \"\", \"disputeId\": \"4652621482688512\", \"flow\": \"in\", \"id\": \"5348906212786176\", \"isMonitoringRequired\": true, \"reason\": \"fraud\", \"referenceId\": \"E20018183202512191914WcfANNEIYnt\", \"rejectionReason\": \"\", \"result\": \"\", \"reversalAccountNumber\": \"5953984539918336\", \"reversalAccountType\": \"payment\", \"reversalBankCode\": \"20018183\", \"reversalBranchCode\": \"0001\", \"reversalReferenceId\": \"\", \"reversalTaxId\": \"39.908.427/0001-28\", \"senderBankCode\": \"20018183\", \"status\": \"delivered\", \"tags\": [], \"updated\": \"2025-12-19T19:30:21.102077+00:00\"}, \"created\": \"2025-12-19T19:30:21.102062+00:00\", \"errors\": [], \"id\": \"6551487224217600\", \"type\": \"delivered\"}, \"subscription\": \"pix-chargeback\", \"workspaceId\": \"5560467233701888\"}}";
        String validSignature = "MEUCIBN4qKKlUCHb6ynJQADrcCWO/QcjiJ/UEollHAlE9J83AiEAwR1TwmFXGyTWQr0RkQWwwUMQdGzDRv1rb8CO52s1/Ww=";
        Event event = Event.parse(content, validSignature);

        Assert.assertNotNull(event.id);
        Assert.assertNotNull(event.workspaceId);
        Assert.assertNotNull(((Event.PixChargebackEvent) event).log.id);
    }

    public String getRequestIdToPatch() throws Exception {
        String bankCode = utils.User.bankCode();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("cursor", null);
        params.put("status", "delivered");
        String chargebackId = null;
        while (chargebackId == null) {
            PixChargeback.Page page = PixChargeback.page(params);
            for (PixChargeback chargeback: page.chargebacks) {
                if (!chargeback.senderBankCode.equals(bankCode)){
                    chargebackId = chargeback.id;
                    break;
                }
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }
        return chargebackId;
    }

    static PixChargeback example() throws Exception{
        Random random = new Random();
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", Long.valueOf(random.nextInt(100000)));
        data.put("referenceId", endToEndIdFromPixRequest());
        data.put("reason","fraud");
        return new PixChargeback(data);
    }

    static String endToEndIdFromPixRequest() throws Exception{
        List<String> endToEndIds = new ArrayList<>();
        Random random = new Random();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixRequest> chargebacks = PixRequest.query(params);
        for (PixRequest chargeback : chargebacks) {
            endToEndIds.add(chargeback.endToEndId);
        }
        return endToEndIds.get(random.nextInt(10));
    }
}
