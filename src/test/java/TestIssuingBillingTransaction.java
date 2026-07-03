import org.junit.Test;

import com.starkinfra.Settings;
import com.starkinfra.IssuingBillingInvoice;
import com.starkinfra.IssuingBillingTransaction;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class TestIssuingBillingTransaction {

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<IssuingBillingTransaction> transactions = IssuingBillingTransaction.query(params);

        int i = 0;
        for (IssuingBillingTransaction transaction : transactions) {
            i += 1;
            assertNotNull(transaction.id);
        }
        assertTrue(i > 0);
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
            IssuingBillingTransaction.Page page = IssuingBillingTransaction.page(params);
            for (IssuingBillingTransaction transaction : page.transactions) {
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
    public void testQueryInvoiceId() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> invoiceParams = new HashMap<>();
        invoiceParams.put("limit", 1);
        Generator<IssuingBillingInvoice> invoices = IssuingBillingInvoice.query(invoiceParams);

        String invoiceId = null;
        for (IssuingBillingInvoice invoice : invoices) {
            invoiceId = invoice.id;
        }
        assertNotNull(invoiceId);

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("invoiceId", invoiceId);
        Generator<IssuingBillingTransaction> transactions = IssuingBillingTransaction.query(params);

        int i = 0;
        for (IssuingBillingTransaction transaction : transactions) {
            i += 1;
            assertNotNull(transaction.id);
        }
        assertTrue(i >= 0);
    }
}
