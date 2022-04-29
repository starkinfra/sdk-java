import com.starkinfra.CreditNote;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class TestCreditNote {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<CreditNote> creditNotes = CreditNote.create(exampleCCB());
        for (CreditNote creditNote : creditNotes) {
            Assert.assertNotNull(creditNote.id);
            System.out.println(creditNote);
        }
    }

    @Test
    public void testGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        CreditNote creditNote = CreditNote.get("5130851633332224");
        Assert.assertNotNull(creditNote.id);

        System.out.println(creditNote);
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "success");
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
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
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
            i += 1;
            log = CreditNote.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.creditNote.id);
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
        List<CreditNote> creditNotes = new ArrayList<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("templateId", "01234567890");
        data.put("name", "Jamie Lannister");
        data.put("taxId", "20.018.183/0001-80");
        data.put("nominalAmount", 9000);
        data.put("scheduled", "2022-4-29");
        data.put("invoices", Collections.singletonList(
                new HashMap<String, Object>() {{
                    put("amount", 5500);
                    put("name", "Jamie Lannister");
                    put("taxId", "20.018.183/0001-80");
                    put("fine", 2.0);
                    put("interest", 1.0);
                    new HashMap<String, Object>() {{
                        put("amount", 4399);
                        put("name", "Jamie Lannister");
                        put("taxId", "20.018.183/0001-80");
                        put("fine", 2.0);
                        put("interest", 1.0);
                    }};
                }}
        ));
        data.put("transfer", new HashMap<String, Object>() {{
            put("amount", 8831);
            put("bankCode", "00000000");
            put("branchCode", "1234");
            put("accountNumber", "129340-1");
            put("taxId", "012.345.678-90");
            put("name", "Jamie Lannister");
        }});

        data.put("signers", Collections.singletonList(
                new HashMap<String, Object>() {{
                    put("name", "Jamie Lannister");
                    put("contact", "joe.limals.14@gmail.com");
                    put("method", "link");
                }}
        ));

        data.put("externalId", "my-internal-id-8435356");
        data.put("tags", new String[]{"War supply", "Invoice #1234"});
        data.put("rebateAmount", 0);

        creditNotes.add(new CreditNote(data));
        return creditNotes;
    }
}
