import org.junit.Test;

import com.starkinfra.Settings;
import com.starkinfra.IssuingBillingInvoice;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class TestIssuingBillingInvoice {

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<IssuingBillingInvoice> invoices = IssuingBillingInvoice.query(params);

        int i = 0;
        for (IssuingBillingInvoice invoice : invoices) {
            i += 1;
            invoice = IssuingBillingInvoice.get(invoice.id);
            assertNotNull(invoice.id);
        }
        assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<IssuingBillingInvoice> invoices = IssuingBillingInvoice.query(params);

        int i = 0;
        ArrayList<String> invoiceIdsExpected = new ArrayList<>();
        for (IssuingBillingInvoice invoice : invoices) {
            i += 1;
            assertNotNull(invoice.id);
            invoiceIdsExpected.add(invoice.id);
        }

        params.put("ids", invoiceIdsExpected.toArray(new String[0]));
        Generator<IssuingBillingInvoice> invoicesResult = IssuingBillingInvoice.query(params);

        int n = 0;
        ArrayList<String> invoiceIdsResult = new ArrayList<>();
        for (IssuingBillingInvoice invoice : invoicesResult) {
            n += 1;
            assertNotNull(invoice.id);
            invoiceIdsResult.add(invoice.id);
        }

        Collections.sort(invoiceIdsExpected);
        Collections.sort(invoiceIdsResult);
        assertTrue(i > 0);
        assertTrue(n > 0);
        assertEquals(invoiceIdsExpected, invoiceIdsResult);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingBillingInvoice.Page page = IssuingBillingInvoice.page(params);
            for (IssuingBillingInvoice invoice : page.invoices) {
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
}
