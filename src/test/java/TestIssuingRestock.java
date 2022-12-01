import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.IssuingRestock;
import com.starkinfra.IssuingStock;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestIssuingRestock {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();
        List<IssuingRestock> data = IssuingRestock.create(example());
        System.out.println(data);
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingRestock> restocks = IssuingRestock.query(params);

        for (IssuingRestock restock : restocks) {
            IssuingRestock restockExpected = IssuingRestock.get(restock.id);
            Assert.assertNotNull(restock.id, restockExpected.id);
            System.out.println(restock);
        }
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingRestock.Page page = IssuingRestock.page(params);
            for (IssuingRestock restock: page.restocks) {
                System.out.println(restock);
                if (ids.contains(restock.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(restock.id);
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
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingRestock.Log> logs = IssuingRestock.Log.query(params);

        for (IssuingRestock.Log log : logs) {
            log = IssuingRestock.Log.get(log.id);
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
            IssuingRestock.Log.Page page = IssuingRestock.Log.page(params);
            for (IssuingRestock.Log log : page.logs) {
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

    static List<IssuingRestock> example() throws Exception{

        List<IssuingRestock> restocks = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("count", 200);
    
            HashMap<String, Object> stockParams = new HashMap<>();
            stockParams.put("limit", 1);
            Generator<IssuingStock> stocks = IssuingStock.query(stockParams);
            for (IssuingStock stock : stocks) {
                data.put("stockId", stock.id);
                break;
            }
            restocks.add(new IssuingRestock(data));
        }
        return restocks;
    }

}
