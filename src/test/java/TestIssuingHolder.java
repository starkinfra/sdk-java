import com.starkinfra.IssuingHolder;
import com.starkinfra.IssuingRule;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestIssuingHolder {

    @Test
    public void testGet() throws Exception {
        Settings.user = utils.User.defaultProject();
        IssuingHolder invoices = IssuingHolder.get("6668150653321216");
        System.out.println(invoices);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingHolder.Page page = IssuingHolder.page(params);
            for (IssuingHolder request: page.holders) {
                System.out.println(request);
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

        if (ids.size() != 4) {
            throw new Exception("ids.size() != 4");
        }
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingHolder> requests = IssuingHolder.query(params);

        int i = 0;
        for (IssuingHolder request : requests) {
            i += 1;
            System.out.println(request);
            Assert.assertNotNull(request.id);
        }
        System.out.println(i);
    }

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();
        List<IssuingHolder> holders = new ArrayList<>();
        holders.add(example(false));
        holders.add(example(true));
        holders = IssuingHolder.create(holders);
        System.out.println(holders);
        for (IssuingHolder holder : holders) {
            Assert.assertNotNull(holder.id);
            String id = IssuingHolder.get(holder.id).id;
            Assert.assertEquals(id, holder.id);
        }
    }

    @Test
    public void testUpdateStatus() throws Exception {
        Settings.user = utils.User.defaultProject();
        Map<String, Object> patchData = new HashMap<>();
        patchData.put("status", "blocked");

        IssuingHolder updatedIssuingHolder = IssuingHolder.update("6668150653321216", patchData);
        System.out.println(updatedIssuingHolder);
    }

    @Test
    public void testDelete() throws Exception {
        Settings.user = utils.User.defaultProject();
        IssuingHolder deletedIssuingHolder = IssuingHolder.delete("6668150653321216");

        Assert.assertEquals("canceled", deletedIssuingHolder.status);

        System.out.println(deletedIssuingHolder);
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

    @Test
    public void testLogGet() throws Exception{
        Settings.user = utils.User.defaultProject();
        IssuingHolder.Log log = IssuingHolder.Log.get("6381355445256192");
        System.out.println(log);
    }

    static IssuingHolder example(Boolean useRules) throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Iron Bank S.A.");
        data.put("externalId", "2325");
        data.put("taxId", "012.345.678-90");
        data.put("tags", new String[]{"Traveler Employee"});
        if (useRules){
            data.put("rules", new IssuingRule[]{ruleExample()});
        }
        return new IssuingHolder(data);
    }

    private static IssuingRule ruleExample() throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "test");
        data.put("amount", 10000);
        data.put("interval", "day");
        data.put("currencyCode", "BRL");
        return new IssuingRule(data);
    }
}
