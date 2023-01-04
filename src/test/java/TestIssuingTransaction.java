import com.starkcore.utils.Generator;
import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.IssuingTransaction;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestIssuingTransaction {

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingTransaction.Page page = IssuingTransaction.page(params);
            for (IssuingTransaction transaction: page.issuingTransactions) {
                System.out.println(transaction);
                if (ids.contains(transaction.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(transaction.id);
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
        Generator<IssuingTransaction> transactions = IssuingTransaction.query(params);

        int i = 0;
        for (IssuingTransaction transaction : transactions) {
            i += 1;
            IssuingTransaction transactionExpected = IssuingTransaction.get(transaction.id);
            Assert.assertNotNull(transaction.id, transactionExpected.id);
            System.out.println(transaction);
        }
        System.out.println(i);
    }

    static IssuingTransaction example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", 1000);

        return new IssuingTransaction(data);
    }
}
