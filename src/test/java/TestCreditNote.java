import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.CreditNote;
import com.starkinfra.CreditSigner;
import com.starkinfra.utils.Generator;

import java.util.UUID;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;

public class TestCreditNote {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<CreditNote> notes = CreditNote.create(exampleWithObject());
        for (CreditNote note : notes) {
            Assert.assertNotNull(note.id);
        }
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<CreditNote> notes = CreditNote.query(params);

        int i = 0;
        for (CreditNote note : notes) {
            i += 1;
            note = CreditNote.get(note.id);
            Assert.assertNotNull(note.id);
        }
        Assert.assertEquals(3, i);
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
            for (CreditNote note : page.notes) {
                if (ids.contains(note.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(note.id);
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
    public void testCreateAndCancel() throws Exception {
        Settings.user = utils.User.defaultProject();
        
        List<CreditNote> notes = CreditNote.create(exampleWithObject());
        CreditNote canceledNote = CreditNote.cancel(notes.get(0).id);
        Assert.assertEquals(canceledNote.status, "canceled");
    }

    @Test
    public void testCreateWithRulesAsObject() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<CreditNote> notes = CreditNote.create(exampleWithObject());
        for (CreditNote note : notes) {
            Assert.assertNotNull(note.id);
            Assert.assertNotNull(note.rules);
            Assert.assertEquals(1, note.rules.size());
            CreditNote.Rule rule = note.rules.get(0);
            Assert.assertTrue(rule instanceof CreditNote.Rule);
            Assert.assertEquals("invoiceCreationMode", rule.key);
            Assert.assertEquals("scheduled", rule.value);
        }
    }

    @Test
    public void testCreateWithRulesAsMap() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<CreditNote> notes = CreditNote.create(exampleWithRulesAsMap());
        for (CreditNote note : notes) {
            Assert.assertNotNull(note.id);
            Assert.assertNotNull(note.rules);
            Assert.assertEquals(1, note.rules.size());
            CreditNote.Rule rule = note.rules.get(0);
            Assert.assertTrue(rule instanceof CreditNote.Rule);
            Assert.assertEquals("invoiceCreationMode", rule.key);
            Assert.assertEquals("scheduled", rule.value);
        }
    }

    @Test
    public void testRuleConstructsFromKeyAndValue() throws Exception {
        Settings.user = utils.User.defaultProject();

        CreditNote.Rule rule = new CreditNote.Rule("invoiceCreationMode", "scheduled");
        Assert.assertEquals("invoiceCreationMode", rule.key);
        Assert.assertEquals("scheduled", rule.value);

        HashMap<String, Object> ruleData = new HashMap<>();
        ruleData.put("key", "invoiceCreationMode");
        ruleData.put("value", "instant");
        CreditNote.Rule ruleFromMap = new CreditNote.Rule(ruleData);
        Assert.assertEquals("invoiceCreationMode", ruleFromMap.key);
        Assert.assertEquals("instant", ruleFromMap.value);
    }

    @Test
    public void testDebtorWorkspaceIdReturnAttribute() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<CreditNote> notes = CreditNote.create(exampleWithObject());
        for (CreditNote note : notes) {
            Assert.assertNotNull(note.id);
            String debtorWorkspaceId = note.debtorWorkspaceId;
            Assert.assertNotNull(debtorWorkspaceId);
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
            Assert.assertNotNull(log.note.id);
        }
        Assert.assertEquals(3, i);
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

    static List<CreditNote> exampleWithObject() throws Exception {

        List<CreditNote.Invoice> invoices = new ArrayList<>();
        HashMap<String, Object> invoice = new HashMap<String, Object>() {{
            put("amount", 100000);
            put("due", "2030-06-16");
        }};
        invoices.add(new CreditNote.Invoice(invoice));

        List<CreditNote.Invoice.Description> descriptions = new ArrayList<>();
        HashMap<String, Object> description = new HashMap<String, Object>() {{
            put("key", "test");
            put("value", "R$ 1000");
        }};
        descriptions.add(new CreditNote.Invoice.Description(description));

        invoice = new HashMap<String, Object>() {{
            put("amount", 100000);
            put("due", "2030-06-16");
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

        List<CreditSigner> signers = new ArrayList<>();
        HashMap<String, Object> signer = new HashMap<String, Object>() {{
            put("name", "Jamie Lannister");
            put("contact", "teste11@gmail.com");
            put("method","link");
        }};
        signers.add(new CreditSigner(signer));

        long nominalAmount = 200000;

        List<CreditNote> notes = new ArrayList<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("templateId", "5706627130851328");
        data.put("name", "Jamie Lannister");
        data.put("taxId", "20.018.183/0001-80");
        data.put("nominalAmount", nominalAmount);
        data.put("scheduled", "2030-06-07");
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

        List<CreditNote.Rule> rules = new ArrayList<>();
        rules.add(new CreditNote.Rule("invoiceCreationMode", "scheduled"));
        data.put("rules", rules);

        notes.add(new CreditNote(data));
        return notes;
    }

    static List<CreditNote> exampleWithRulesAsMap() throws Exception {
        List<CreditNote> notes = exampleWithObject();

        List<HashMap<String, Object>> rules = new ArrayList<>();
        HashMap<String, Object> rule = new HashMap<>();
        rule.put("key", "invoiceCreationMode");
        rule.put("value", "scheduled");
        rules.add(rule);

        CreditNote base = notes.get(0);
        HashMap<String, Object> data = new HashMap<>();
        data.put("templateId", base.templateId);
        data.put("name", base.name);
        data.put("taxId", base.taxId);
        data.put("nominalAmount", base.nominalAmount);
        data.put("scheduled", base.scheduled);
        data.put("invoices", base.invoices);
        data.put("payment", base.payment);
        data.put("paymentType", base.paymentType);
        data.put("signers", base.signers);
        data.put("externalId", UUID.randomUUID().toString());
        data.put("tags", base.tags);
        data.put("rebateAmount", 0);
        data.put("streetLine1", base.streetLine1);
        data.put("streetLine2", base.streetLine2);
        data.put("district", base.district);
        data.put("city", base.city);
        data.put("stateCode", base.stateCode);
        data.put("zipCode", base.zipCode);
        data.put("rules", rules);

        List<CreditNote> mapNotes = new ArrayList<>();
        mapNotes.add(new CreditNote(data));
        return mapNotes;
    }

    public static String getDateString(int delta) {
        return LocalDate.now().plusDays(delta).toString();
    }
}
