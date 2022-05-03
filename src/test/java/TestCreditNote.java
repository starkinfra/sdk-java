import com.starkinfra.utils.Generator;
import com.starkinfra.CreditNote;
import com.starkinfra.Settings;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class TestCreditNote {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<CreditNote> creditNotes = CreditNote.create(exampleCCB());
        System.out.println(creditNotes);
        for (CreditNote creditNote : creditNotes) {
            Assert.assertNotNull(creditNote.id);
            System.out.println(creditNote);
        }
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<CreditNote> creditNotes = CreditNote.query(params);

        int i = 0;
        for (CreditNote creditNote : creditNotes) {
            i += 1;
            creditNote = CreditNote.get(creditNote.id);
            Assert.assertNotNull(creditNote.id);
            System.out.println(creditNote);
        }
        Assert.assertTrue(i > 0);
        System.out.println(i);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            CreditNote.Page page = CreditNote.page(params);
            for (CreditNote creditNote : page.creditNotes) {
                System.out.println(creditNote);
                if (ids.contains(creditNote.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(creditNote.id);
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
    public void testCreateAndDelete() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<CreditNote> creditNotes = CreditNote.create(exampleCCB());
        for (CreditNote creditNote : creditNotes) {
            creditNote = CreditNote.delete(creditNote.id);
            Assert.assertNotNull(creditNote.id);
            System.out.println(creditNote);
        }
    }

    @Test
    public void testLogQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<CreditNote.Log> logs = CreditNote.Log.query(params);

        int i = 0;
        for (CreditNote.Log log : logs) {
            System.out.println(log);
            i += 1;
            log = CreditNote.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.note.id);
            System.out.println(log);
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testLogPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            CreditNote.Log.Page page = CreditNote.Log.page(params);
            for (CreditNote.Log log : page.logs) {
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

    static List<CreditNote> exampleCCB() throws Exception {

        List<HashMap<String, Object>> invoices = new ArrayList<>();
        HashMap<String, Object> invoice = new HashMap<String, Object>() {{
            put("amount", 50000);
            put("fine", 10);
            put("interest", 2);
            put("due", "2022-07-05");
            put("taxId", "20.018.183/0001-80");
        }};
        invoices.add(invoice);

        invoice = new HashMap<String, Object>() {{
            put("amount", 51000);
            put("fine", 10);
            put("interest", 2);
            put("due", "2022-08-05");
            put("taxId", "20.018.183/0001-80");
        }};
        invoices.add(invoice);

        HashMap<String, Object> transfer = new HashMap<String, Object>(){{
            put("bankCode", "00000000");
            put("branchCode", "1234");
            put("accountNumber", "129340-1");
            put("taxId", "012.345.678-90");
            put("name", "Jamie Lannister");
        }};

        List<HashMap<String, Object>> signers = new ArrayList<>();
        HashMap<String, Object> signer = new HashMap<String, Object>() {{
            put("name", "Jamie Lannister");
            put("contact", "teste11@gmail.com");
            put("method","link");
        }};
        signers.add(signer);

        List<CreditNote> creditNotes = new ArrayList<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("templateId", "5707012469948416");
        data.put("name", "Jamie Lannister");
        data.put("taxId", "20.018.183/0001-80");
        data.put("nominalAmount", 100000);
        data.put("scheduled", "2022-05-05");
        data.put("invoices", invoices);
        data.put("transfer", transfer );
        data.put("signers", signers );
        data.put("externalId", UUID.randomUUID().toString());
        data.put("tags", new String[]{"War supply", "Invoice #1234"});
        data.put("rebateAmount", 0);

        creditNotes.add(new CreditNote(data));
        return creditNotes;
    }
}
