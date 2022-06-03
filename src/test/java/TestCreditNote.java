import com.starkinfra.utils.Generator;
import com.starkinfra.CreditNote;
import com.starkinfra.Settings;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class TestCreditNote {

    @Test
    public void testCreateWithHashMap() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<CreditNote> creditNotes = CreditNote.create(exampleWithHashMap());
        System.out.println(creditNotes);
        for (CreditNote creditNote : creditNotes) {
            Assert.assertNotNull(creditNote.id);
            System.out.println(creditNote);
        }
    }

    @Test
    public void testCreateWithObjects() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<CreditNote> creditNotes = CreditNote.create(exampleWithObject());
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
            for (CreditNote creditNote : page.notes) {
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
    public void testQueryAndCancel() throws Exception {
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("status", "created");
        Generator<CreditNote> notes = CreditNote.query(params);
        for (CreditNote note : notes) {
            note = CreditNote.cancel(note.id);
            Assert.assertEquals(note.status, "canceled");
            System.out.println(note);
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

    static List<CreditNote> exampleWithHashMap() throws Exception {

        List<HashMap<String, Object>> invoices = new ArrayList<>();
        HashMap<String, Object> invoice = new HashMap<String, Object>() {{
            put("amount", 50000);
            put("fine", 10);
            put("interest", 2);
            put("due", getDateString(60));
        }};
        invoices.add(invoice);

        invoice = new HashMap<String, Object>() {{
            put("amount", 51000);
            put("fine", 10);
            put("interest", 2);
            put("due", getDateString(30));
        }};
        invoices.add(invoice);

        HashMap<String, Object> payment = new HashMap<String, Object>(){{
            put("bankCode", "00000000");
            put("branchCode", "1234");
            put("accountNumber", "129340-1");
            put("taxId", "012.345.678-90");
            put("name", "Jamie Lannister");
        }};
        CreditNote.Transfer transfer = new CreditNote.Transfer(payment);

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
        data.put("scheduled", getDateString(3));
        data.put("invoices", invoices);
        data.put("payment", transfer );
        data.put("paymentType", "transfer" );
        data.put("signers", signers );
        data.put("externalId", UUID.randomUUID().toString());
        data.put("tags", new String[]{"War supply", "Invoice #1234"});
        data.put("rebateAmount", 0);
        data.put("streetLine1", "Rua ABC");
        data.put("streetLine2", "Ap 123");
        data.put("district", "Jardim Paulista");
        data.put("city", "São Paulo");
        data.put("stateCode", "SP");
        data.put("zipCode", "01234-567");

        creditNotes.add(new CreditNote(data));
        return creditNotes;
    }

    static List<CreditNote> exampleWithObject() throws Exception {

        List<CreditNote.Invoice> invoices = new ArrayList<>();
        HashMap<String, Object> invoice = new HashMap<String, Object>() {{
            put("amount", 50000);
            put("fine", 10);
            put("interest", 2);
            put("due", getDateString(60));
        }};
        invoices.add(new CreditNote.Invoice(invoice));

        List<CreditNote.Invoice.Description> descriptions = new ArrayList<>();
        HashMap<String, Object> description = new HashMap<String, Object>() {{
            put("key", "test");
            put("value", "R$ 1000");
        }};
        descriptions.add(new CreditNote.Invoice.Description(description));

        invoice = new HashMap<String, Object>() {{
            put("amount", 51000);
            put("fine", 10);
            put("interest", 2);
            put("due", getDateString(30));
            put("descriptions", descriptions);
        }};
        invoices.add(new CreditNote.Invoice(invoice));

        HashMap<String, Object> payment = new HashMap<String, Object>(){{
            put("bankCode", "00000000");
            put("branchCode", "1234");
            put("accountNumber", "129340-1");
            put("taxId", "012.345.678-90");
            put("name", "Jamie Lannister");
        }};
        CreditNote.Transfer transfer = new CreditNote.Transfer(payment);

        List<CreditNote.Signer> signers = new ArrayList<>();
        HashMap<String, Object> signer = new HashMap<String, Object>() {{
            put("name", "Jamie Lannister");
            put("contact", "teste11@gmail.com");
            put("method","link");
        }};
        signers.add(new CreditNote.Signer(signer));

        List<CreditNote> creditNotes = new ArrayList<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("templateId", "5707012469948416");
        data.put("name", "Jamie Lannister");
        data.put("taxId", "20.018.183/0001-80");
        data.put("nominalAmount", 100000);
        data.put("scheduled", getDateString(3));
        data.put("invoices", invoices);
        data.put("payment", transfer );
        data.put("paymentType", "transfer" );
        data.put("signers", signers );
        data.put("externalId", UUID.randomUUID().toString());
        data.put("tags", new String[]{"War supply", "Invoice #1234"});
        data.put("rebateAmount", 0);
        data.put("streetLine1", "Rua ABC");
        data.put("streetLine2", "Ap 123");
        data.put("district", "Jardim Paulista");
        data.put("city", "São Paulo");
        data.put("stateCode", "SP");
        data.put("zipCode", "01234-567");

        creditNotes.add(new CreditNote(data));
        return creditNotes;
    }

    public static String getDateString(int delta) {
        return LocalDate.now().plusDays(delta).toString();
    }
}
