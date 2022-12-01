import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.IssuingStock;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestIssuingStock {

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("expand", "balance");
        Generator<IssuingStock> stocks = IssuingStock.query(params);

        HashMap<String, Object> getParams = new HashMap<>();
        params.put("expand", "balance");
        for (IssuingStock stock : stocks) {
            IssuingStock stockExpected = IssuingStock.get(stock.id, getParams);
            Assert.assertNotNull(stock.id, stockExpected.id);
            Assert.assertNotNull(stock.balance);
            System.out.println(stock);
        }
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);
        params.put("expand", "balance");

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingStock.Page page = IssuingStock.page(params);
            for (IssuingStock stock: page.stocks) {
                System.out.println(stock);
                if (ids.contains(stock.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(stock.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }

        if (ids.size() != 2) {
            throw new Exception("ids.size() != 4");
        }
    }

    @Test
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingStock.Log> logs = IssuingStock.Log.query(params);

        for (IssuingStock.Log log : logs) {
            log = IssuingStock.Log.get(log.id);
            System.out.println(log);
        }
    }

    @Test
    public void testLogPage() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingStock.Log.Page page = IssuingStock.Log.page(params);
            for (IssuingStock.Log log : page.logs) {
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

}
