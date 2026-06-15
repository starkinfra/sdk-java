import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.PixFraud;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

// Log sub-resource tests for PixFraud (contract pix-fraud.md v3, M9-M14).
//
// migrate run: the parent PixFraud (M1-M8) already exists and is NOT touched.
// Its tests live in TestPixFraud.java and are not modified here. The Log
// sub-resource is new (PixFraudLog / PixFraud.Log, confirmed absent in
// branch-created.md). These tests are additive and live in a separate
// default-package class so the parent test file is left untouched, per the
// Phase 3 task directive. Surefire auto-discovers Test*.java by name
// (docs/infra/java/running-tests.md:66), so no runner config changes.
//
// Idioms mirror the canonical Log tests verbatim:
//   sdk-infra/java/src/test/java/TestPixClaim.java:46-64 (testLogQueryAndGet)
//   sdk-infra/java/src/test/java/TestPixClaim.java:127-150 (testLogPage)
//   sdk-infra/java/src/test/java/TestPixRequest.java:60-78,144-172
//
// Note on Log.type: per M11 the live API emits transitional values (e.g.
// "canceling"), so type is an OPEN, non-empty string. The canonical *_log
// test convention asserts NOTHING on type (TestPixClaim asserts only
// log.id / log.claim.id). This file follows that convention exactly and does
// NOT assert a closed enum on type.

public class TestPixFraudLog {

    // M9 (Log exposed under pixfraud.log with query + get; read-only),
    // M10 (Log.fraud deserializes the embedded parent into a full PixFraud),
    // M11 (Log.type parsed as a free, non-empty string - no closed enum),
    // M13 (Log.created parsed to the native datetime type).
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
            // M10: the embedded parent is deserialized to a full PixFraud.
            Assert.assertNotNull(log.fraud);
            Assert.assertNotNull(log.fraud.id);
            // M11: type is parsed and non-empty. NO closed-enum assertion -
            // the live API emits transitional values such as "canceling".
            Assert.assertNotNull(log.type);
            Assert.assertTrue(log.type.length() > 0);
            // M13: created is parsed to the native datetime type (non-null).
            Assert.assertNotNull(log.created);
            System.out.println(log);
        }
        Assert.assertTrue(i > 0);
    }

    // M12 (Log query/page support limit, after, before, types, fraud_ids, ids
    // [+ cursor on page]) and M5-style opaque-cursor pagination for the Log.
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

    // M12: the documented Log filters (types, fraud_ids, ids) are accepted by
    // query alongside the date filters. Loose date range keeps the test
    // resilient to sandbox state; the load-bearing check is that the filtered
    // query returns parsed Log entries.
    @Test
    public void testLogQueryFilters() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 5);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");

        // Collect a fraud id to drive the fraud_ids filter.
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

        System.out.println(i);
    }
}
