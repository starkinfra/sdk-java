import com.starkinfra.IssuingPurchase;
import com.starkinfra.IssuingPurchase;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestIssuingPurchase {

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingPurchase.Page page = IssuingPurchase.page(params);
            for (IssuingPurchase request: page.issuingPurchases) {
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
    public void testGet() throws Exception {
        Settings.user = utils.User.defaultProject();
        IssuingPurchase invoices = IssuingPurchase.get("5302186862968832");
        System.out.println(invoices);
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingPurchase> statements = IssuingPurchase.query(params);

        for (IssuingPurchase statement : statements) {
            IssuingPurchase statementExpected = IssuingPurchase.get(statement.id);
            Assert.assertNotNull(statement.id, statementExpected.id);
            System.out.println(statement);
        }
    }

    @Test
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingPurchase.Log> logs = IssuingPurchase.Log.query(params);

        for (IssuingPurchase.Log log : logs) {
            log = IssuingPurchase.Log.get(log.id);
            System.out.println(log);
        }
    }

    @Test
    public void testLogGet() throws Exception{
        Settings.user = utils.User.defaultProject();
        IssuingPurchase.Log log = IssuingPurchase.Log.get("6428086769811456");
        System.out.println(log);

    }

    static IssuingPurchase example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", 1000);

        return new IssuingPurchase(data);
    }
}
