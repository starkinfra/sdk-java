import com.starkinfra.IssuingTransaction;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
            for (IssuingTransaction request: page.issuingTransactions) {
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
        IssuingTransaction invoices = IssuingTransaction.get("5396424728510464");
        System.out.println(invoices);
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingTransaction> statements = IssuingTransaction.query(params);

        int i = 0;
        for (IssuingTransaction statement : statements) {
            i += 1;
            IssuingTransaction statementExpected = IssuingTransaction.get(statement.id);
            Assert.assertNotNull(statement.id, statementExpected.id);
            System.out.println(statement);
        }
        System.out.println(i);
    }

    static IssuingTransaction example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", 1000);

        return new IssuingTransaction(data);
    }
}
