import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.PixClaim;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


public class TestPixClaim {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        PixClaim claim = PixClaim.create(example());
        System.out.println(claim);
        Assert.assertNotNull(claim.id);
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixClaim> claims = PixClaim.query(params);

        int i = 0;
        for (PixClaim claim : claims) {
            i += 1;
            claim = PixClaim.get(claim.id);
            System.out.println(claim);
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
        Generator<PixClaim.Log> logs = PixClaim.Log.query(params);

        int i = 0;
        for (PixClaim.Log log : logs) {
            i += 1;
            log = PixClaim.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.claim.id);
            System.out.println(log);
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixClaim> claims = PixClaim.query(params);

        ArrayList<String> claimsIdsExpected = new ArrayList<>();
        for (PixClaim claim : claims) {
            Assert.assertNotNull(claim.id);
            claimsIdsExpected.add(claim.id);
        }

        params.put("ids", claimsIdsExpected.toArray(new String[0]));
        Generator<PixClaim> claimsResult = PixClaim.query(params);

        ArrayList<String> claimsIdsResult = new ArrayList<>();
        for (PixClaim claim : claimsResult){
            Assert.assertNotNull(claim.id);
            claimsIdsResult.add(claim.id);
            System.out.println(claim);
        }

        Collections.sort(claimsIdsExpected);
        Collections.sort(claimsIdsResult);
        Assert.assertEquals(claimsIdsExpected, claimsIdsResult);
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
            PixClaim.Page page = PixClaim.page(params);
            for (PixClaim claim: page.claims) {
                System.out.println(claim);
                if (ids.contains(claim.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(claim.id);
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
            PixClaim.Log.Page page = PixClaim.Log.page(params);
            for (PixClaim.Log log: page.logs) {
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
    public void testUpdateStatus() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("status", "delivered");
        params.put("flow", "in");
        Generator<PixClaim> claims = PixClaim.query(params);
        for (PixClaim claim : claims) {
            HashMap<String, Object> patchData = new HashMap<>();
            patchData.put("reason", "userRequested");
            PixClaim updatedPixClaim = PixClaim.update(claim.id,"canceled", patchData);
            Assert.assertNotNull(updatedPixClaim.id);
            System.out.println(updatedPixClaim);
        }
    }

    static PixClaim example() throws Exception{
        Random random = new Random();
        HashMap<String, Object> data = new HashMap<>();
        data.put("accountCreated","2022-02-01");
        data.put("accountNumber","00000");
        data.put("accountType","savings");
        data.put("branchCode","0000");
        data.put("name","Jamie Lannister");
        data.put("taxId","012.345.678-90");
        data.put("keyId", "+5511"+(random.nextInt(99999999)+100000000));
        return new PixClaim(data);
    }
}
