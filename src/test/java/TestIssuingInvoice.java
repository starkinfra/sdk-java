import com.starkinfra.IssuingInvoice;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TestIssuingInvoice {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();
        IssuingInvoice statement = IssuingInvoice.create(example());
        System.out.println(statement);
        Assert.assertNotNull(statement.id);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingInvoice.Page page = IssuingInvoice.page(params);
            for (IssuingInvoice request: page.invoices) {
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
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingInvoice> statements = IssuingInvoice.query(params);

        for (IssuingInvoice statement : statements) {
            IssuingInvoice statementExpected = IssuingInvoice.get(statement.id);
            Assert.assertNotNull(statement.id, statementExpected.id);
            System.out.println(statement);
        }
    }

    @Test
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingInvoice.Log> logs = IssuingInvoice.Log.query(params);

        for (IssuingInvoice.Log log : logs) {
            log = IssuingInvoice.Log.get(log.id);
            System.out.println(log);
        }
    }

    static IssuingInvoice example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", 1000);

        return new IssuingInvoice(data);
    }

}
