import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.IssuingRule;
import com.starkinfra.IssuingHolder;
import com.starkinfra.utils.Generator;

import java.util.UUID;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


public class TestIssuingHolder {

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingHolder.Page page = IssuingHolder.page(params);
            for (IssuingHolder holder: page.holders) {
                System.out.println(holder);
                if (ids.contains(holder.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(holder.id);
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
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingHolder> holders = IssuingHolder.query(params);

        int i = 0;
        for (IssuingHolder holder : holders) {
            i += 1;
            System.out.println(holder);
            Assert.assertNotNull(holder.id);
        }
        System.out.println(i);
    }

    @Test
    public void testCreateAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<IssuingHolder> holders = new ArrayList<>();
        holders.add(example(false));
        holders.add(example(true));
        holders = IssuingHolder.create(holders);

        HashMap<String, Object> expand = new HashMap<>();
        expand.put("expand", Collections.singletonList("rules"));

        System.out.println(holders);
        for (IssuingHolder holder : holders) {
            Assert.assertNotNull(holder.id);
            holder = IssuingHolder.get(holder.id, expand);
            String id = holder.id;
            Assert.assertEquals(id, holder.id);
            System.out.println(holder);
        }
    }

    @Test
    public void testUpdateStatus() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = new HashMap<>();;
        data.put("status", "blocked");

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("status", "active");
        Generator<IssuingHolder> holders = IssuingHolder.query(params);

        for (IssuingHolder holder : holders) {
            IssuingHolder updatedIssuingHolder = IssuingHolder.update(holder.id, data);
            Assert.assertEquals("blocked", updatedIssuingHolder.status);
            System.out.println(updatedIssuingHolder);
        }
    }

    @Test
    public void testCancel() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("status", "active");
        Generator<IssuingHolder> holders = IssuingHolder.query(params);

        for (IssuingHolder holder : holders) {
            IssuingHolder canceledIssuingHolder = IssuingHolder.cancel(holder.id);
            Assert.assertEquals("canceled", canceledIssuingHolder.status);
            System.out.println(canceledIssuingHolder);
        }
    }

    @Test
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingHolder.Log> logs = IssuingHolder.Log.query(params);

        int i = 0;
        for (IssuingHolder.Log log : logs) {
            i += 1;
            log = IssuingHolder.Log.get(log.id);
            System.out.println(log);
        }
    }

    static IssuingHolder example(Boolean useRules) throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Iron Bank S.A.");
        data.put("externalId", UUID.randomUUID().toString());
        data.put("taxId", "012.345.678-90");
        data.put("tags", new String[]{"Traveler Employee"});
        if (useRules){
            data.put("rules", ruleExample());
        }
        return new IssuingHolder(data);
    }

    private static List<IssuingRule> ruleExample() throws Exception {
        List<IssuingRule> rules = new ArrayList<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "test");
        data.put("amount", 10000);
        data.put("interval", "day");
        data.put("currencyCode", "BRL");
        rules.add(new IssuingRule(data));
        return rules;
    }
}
