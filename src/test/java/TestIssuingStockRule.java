import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.IssuingStockRule;
import com.starkinfra.IssuingStock;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;


public class TestIssuingStockRule {

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<IssuingStockRule> rules = IssuingStockRule.query(params);

        int i = 0;
        for (IssuingStockRule rule : rules) {
            i += 1;
            Assert.assertNotNull(rule.id);
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);

        IssuingStockRule.Page page = IssuingStockRule.page(params);
        for (IssuingStockRule rule : page.rules) {
            Assert.assertNotNull(rule.id);
        }
        Assert.assertNotNull(page.cursor);
    }

    @Test
    public void testCreateUpdateCancel() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> stockParams = new HashMap<>();
        stockParams.put("limit", 1);
        String stockId = null;
        for (IssuingStock stock : IssuingStock.query(stockParams)) {
            stockId = stock.id;
            break;
        }
        Assert.assertNotNull(stockId);

        HashMap<String, Object> activeParams = new HashMap<>();
        activeParams.put("stockIds", Arrays.asList(stockId));
        activeParams.put("status", Arrays.asList("active"));
        for (IssuingStockRule activeRule : IssuingStockRule.query(activeParams)) {
            IssuingStockRule.cancel(activeRule.id);
        }

        List<IssuingStockRule> rules = new ArrayList<>();
        rules.add(example(stockId));
        rules = IssuingStockRule.create(rules);
        Assert.assertEquals(1, rules.size());

        IssuingStockRule createdRule = rules.get(0);
        Assert.assertNotNull(createdRule.id);
        Assert.assertFalse(createdRule.id.isEmpty());

        HashMap<String, Object> patchData = new HashMap<>();
        patchData.put("minimumBalance", 20000);
        IssuingStockRule updatedRule = IssuingStockRule.update(createdRule.id, patchData);
        Assert.assertEquals(Integer.valueOf(20000), updatedRule.minimumBalance);

        IssuingStockRule canceledRule = IssuingStockRule.cancel(createdRule.id);
        Assert.assertEquals("canceled", canceledRule.status);
    }

    static IssuingStockRule example(String stockId) throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        data.put("minimumBalance", 10000);
        data.put("stockId", stockId);
        data.put("emails", new String[]{"john.doe@enterprise.com"});
        data.put("phones", new String[]{"+55 (11) 91234 5678"});
        return new IssuingStockRule(data);
    }
}
