import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.PixFraud;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestPixFraudLog {

    @Test
    public void testLogQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixFraud.Log> logs = PixFraud.Log.query(params);

        int i = 0;
        for (PixFraud.Log log : logs) {
            i += 1;
            log = PixFraud.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.fraud);
            Assert.assertNotNull(log.fraud.id);
            Assert.assertNotNull(log.type);
            Assert.assertTrue(log.type.length() > 0);
            Assert.assertNotNull(log.created);
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
            PixFraud.Log.Page page = PixFraud.Log.page(params);
            for (PixFraud.Log log : page.logs) {
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
    public void testLogQueryFilters() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 5);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");

        ArrayList<String> fraudIds = new ArrayList<>();
        HashMap<String, Object> fraudParams = new HashMap<>();
        fraudParams.put("limit", 1);
        for (PixFraud fraud : PixFraud.query(fraudParams)) {
            Assert.assertNotNull(fraud.id);
            fraudIds.add(fraud.id);
        }

        if (!fraudIds.isEmpty()) {
            params.put("fraudIds", fraudIds.toArray(new String[0]));
        }
        params.put("types", new String[]{"registered", "canceled"});

        Generator<PixFraud.Log> logs = PixFraud.Log.query(params);

        int i = 0;
        ArrayList<String> logIds = new ArrayList<>();
        for (PixFraud.Log log : logs) {
            i += 1;
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.type);
            logIds.add(log.id);
        }

        if (!logIds.isEmpty()) {
            params.remove("types");
            params.remove("fraudIds");
            params.put("ids", logIds.toArray(new String[0]));
            int n = 0;
            for (PixFraud.Log log : PixFraud.Log.query(params)) {
                n += 1;
                Assert.assertNotNull(log.id);
            }
            Assert.assertTrue(n > 0);
        }

    }
}
