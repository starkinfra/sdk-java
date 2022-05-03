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
            for (IssuingPurchase purchase: page.issuingPurchases) {
                System.out.println(purchase);
                if (ids.contains(purchase.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(purchase.id);
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
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingPurchase> purchases = IssuingPurchase.query(params);

        for (IssuingPurchase purchase : purchases) {
            IssuingPurchase purchaseExpected = IssuingPurchase.get(purchase.id);
            Assert.assertNotNull(purchase.id, purchaseExpected.id);
            System.out.println(purchase);
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


    static IssuingPurchase example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", 1000);

        return new IssuingPurchase(data);
    }
}
