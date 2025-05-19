import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.PixKey;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class TestPixKey {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        PixKey key = PixKey.create(example());
        Assert.assertNotNull(key.id);
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("status", "registered");
        Generator<PixKey> keys = PixKey.query(params);
        int i = 0;
        for (PixKey key : keys) {
            i += 1;
            key = PixKey.get(key.id, "012.345.678-90");
            Assert.assertNotNull(key.id);
        }
    }

    @Test
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixKey.Log> logs = PixKey.Log.query(params);

        int i = 0;
        for (PixKey.Log log : logs) {
            i += 1;
            log = PixKey.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.key.id);
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 5);
        params.put("status", "created");
        Generator<PixKey> keys = PixKey.query(params);

        ArrayList<String> keysIdsExpected = new ArrayList<>();
        for (PixKey key : keys) {
            Assert.assertNotNull(key.id);
            keysIdsExpected.add(key.id);
        }

        params.put("ids", keysIdsExpected.toArray(new String[0]));
        params.put("status", "created");
        Generator<PixKey> keysResult = PixKey.query(params);

        ArrayList<String> keysIdsResult = new ArrayList<>();
        for (PixKey key : keysResult){
            Assert.assertNotNull(key.id);
            keysIdsResult.add(key.id);
        }

        Collections.sort(keysIdsExpected);
        Collections.sort(keysIdsResult);
        Assert.assertEquals(keysIdsExpected, keysIdsResult);
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
            PixKey.Page page = PixKey.page(params);
            for (PixKey key: page.keys) {
                ids.add(key.id);
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
            PixKey.Log.Page page = PixKey.Log.page(params);
            for (PixKey.Log log: page.logs) {
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
    public void testPixKeyQueryAndCancel() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "registered");

        HashMap<String, Object> query = new HashMap<>();
        query.put("reason", "fraud");

        int i = 0;
        for (PixKey key : PixKey.query(params)) {
            i ++;
            key = PixKey.cancel(key.id, query);

            HashMap<String, Object> queryParams = new HashMap<>();
            queryParams.put("keyIds", key.id);
            queryParams.put("types", "canceling");
            Generator<PixKey.Log> logs = PixKey.Log.query(queryParams);

            for (PixKey.Log log : logs) {
                Assert.assertNotNull(log.key.id);
                Assert.assertEquals("canceling", log.type);
            }
        }
    }

    @Test
    public void testUpdate() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("status", "registered");
        params.put("type", "phone");
        Generator<PixKey> keys = PixKey.query(params);
        for (PixKey key : keys) {
            HashMap<String, Object> patchData = new HashMap<>();
            patchData.put("name", "Arya Stark");
            patchData.put("accountNumber", "0000000000");
            patchData.put("accountType", "savings");
            PixKey updatedPixKey = PixKey.update(key.id, "userRequested", patchData);
            Assert.assertNotNull(updatedPixKey.id);
            Assert.assertEquals(updatedPixKey.name, "Arya Stark");
        }
    }

    static PixKey example() throws Exception{
        Random random = new Random();
        HashMap<String, Object> data = new HashMap<>();
        data.put("accountCreated","2022-02-01");
        data.put("accountNumber","00000");
        data.put("accountType","savings");
        data.put("branchCode","0000");
        data.put("name","Jamie Lannister");
        data.put("taxId","012.345.678-90");
        data.put("id", "+5511"+(random.nextInt(99999999)+100000000));
        return new PixKey(data);
    }
}
