import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Ledger;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestLedgerLog {

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<Ledger.Log> logs = Ledger.Log.query(params);

        for (Ledger.Log log : logs) {
            System.out.println(log);
            Assert.assertNotNull(log.id);
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
            Ledger.Log.Page page = Ledger.Log.page(params);
            for (Ledger.Log log: page.logs) {
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
    }

    @Test
    public void testQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        Generator<Ledger.Log> logs = Ledger.Log.query(params);

        for (Ledger.Log log : logs) {
            Assert.assertNotNull(log.id);
            log = Ledger.Log.get(log.id);
            Assert.assertNotNull(log.id);
            System.out.println(log);
        }
    }
}
