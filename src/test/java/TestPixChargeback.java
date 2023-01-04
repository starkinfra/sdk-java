import com.starkcore.utils.Generator;
import com.starkinfra.utils.ReturnId;
import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.PixRequest;
import com.starkinfra.PixChargeback;

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
        System.out.println(chargebacks);
    }

    @Test
    public void testCancel() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("status", "delivered");
        Generator<PixChargeback> chargebacks = PixChargeback.query(params);
        for (PixChargeback chargeback : chargebacks) {
            System.out.println(chargeback.id);
            chargeback = PixChargeback.cancel(chargeback.id);
            Assert.assertEquals(chargeback.status, "canceled");
            System.out.println(chargeback);
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
            System.out.println(chargeback);
        }
    }
    @Test
    
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "created");
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixChargeback> chargebacks = PixChargeback.query(params);

        int i = 0;
        for (PixChargeback chargeback : chargebacks) {
            i += 1;
            chargeback = PixChargeback.get(chargeback.id);
            System.out.println(chargeback);
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
        Generator<PixChargeback.Log> logs = PixChargeback.Log.query(params);
        int i = 0;
        for (PixChargeback.Log log : logs) {
            i += 1;
            log = PixChargeback.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.chargeback.id);
            System.out.println(log);
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
                System.out.println(chargeback);
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
    public void testUpdate() throws Exception {
        Settings.user = utils.User.defaultProject();
        String bankCode = utils.User.bankCode();

        String chargebackId = getRequestIdToPatch();
        HashMap<String, Object> patchData = new HashMap<>();
        patchData.put("reversalReferenceId", ReturnId.create(bankCode));
        if (!(chargebackId == null)) {
            PixChargeback updatedPixChargeback = PixChargeback.update(chargebackId, "accepted", patchData);
            Assert.assertNotNull(updatedPixChargeback.id);
            System.out.println(updatedPixChargeback);
        }
        else {
            System.out.println("There are no PixChargebacks to patch");
            Assert.assertNotNull(null);
        }
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
