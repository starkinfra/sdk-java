import com.starkcore.utils.Generator;
import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.IssuingInvoice;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestIssuingInvoice {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        IssuingInvoice invoice = IssuingInvoice.create(example());
        System.out.println(invoice);
        Assert.assertNotNull(invoice.id);
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
            for (IssuingInvoice invoice: page.invoices) {
                System.out.println(invoice);
                if (ids.contains(invoice.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(invoice.id);
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
        Generator<IssuingInvoice> invoices = IssuingInvoice.query(params);

        for (IssuingInvoice invoice : invoices) {
            IssuingInvoice invoiceExpected = IssuingInvoice.get(invoice.id);
            Assert.assertNotNull(invoice.id, invoiceExpected.id);
            System.out.println(invoice);
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
        data.put("amount", Long.valueOf(1000));

        return new IssuingInvoice(data);
    }
}
