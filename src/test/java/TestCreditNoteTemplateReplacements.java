import org.junit.Test;
import org.junit.Assert;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.starkinfra.CreditNote;
import com.starkinfra.utils.ResponseHandler;

import java.util.List;
import java.util.HashMap;
import java.util.Collections;

// Offline: no network, no credentials.
public class TestCreditNoteTemplateReplacements {

    @Test
    public void testSerializationKeepsCamelCaseKeys() throws Exception {
        JsonObject sent = serializeLikeCreate(newNote(replacements()));
        JsonObject sentReplacements = sent.getAsJsonObject("templateReplacements");

        Assert.assertEquals(3, sentReplacements.size());
        Assert.assertEquals("Jon Snow", sentReplacements.get("guarantorName").getAsString());
        Assert.assertEquals("336.959.235-55", sentReplacements.get("cpfCnpjAvalista").getAsString());
        Assert.assertEquals("Av. Paulista, 200", sentReplacements.get("guarantorAddress").getAsString());
    }

    @Test
    public void testSerializationOmitsFieldWhenAbsent() throws Exception {
        Assert.assertFalse(serializeLikeCreate(newNote(null)).has("templateReplacements"));
    }

    @Test
    public void testSerializationDropsNullValuesInsideTheMap() throws Exception {
        HashMap<String, Object> withNull = replacements();
        withNull.put("guarantorComplement", null);

        JsonObject sentReplacements = serializeLikeCreate(newNote(withNull)).getAsJsonObject("templateReplacements");

        Assert.assertFalse(sentReplacements.has("guarantorComplement"));
        Assert.assertTrue(sentReplacements.has("guarantorName"));
    }

    @Test
    public void testResponseExposesFieldAsReceived() throws Exception {
        String content = "{\"notes\": [{\"id\": \"5656565656565656\", \"paymentType\": \"transfer\", \"payment\": {}, "
                + "\"templateReplacements\": {\"guarantorName\": \"Jon Snow\", \"cpfCnpjAvalista\": \"336.959.235-55\"}}]}";

        List<CreditNote> notes = ResponseHandler.post(content, CreditNote.class, "notes");

        Assert.assertEquals("Jon Snow", notes.get(0).templateReplacements.get("guarantorName"));
        Assert.assertEquals("336.959.235-55", notes.get(0).templateReplacements.get("cpfCnpjAvalista"));
        Assert.assertEquals(2, notes.get(0).templateReplacements.size());
    }

    @Test
    public void testObjectAndRawMapSendTheSamePayload() throws Exception {
        JsonObject fromMap = serializeLikeCreate(newNote(replacements()));
        JsonObject fromObject = serializeLikeCreate(newNote(new CreditNote.TemplateReplacements(replacements())));

        Assert.assertEquals(fromMap.get("templateReplacements"), fromObject.get("templateReplacements"));
        Assert.assertFalse(fromObject.getAsJsonObject("templateReplacements").has("values"));
    }

    @Test
    public void testRawMapBecomesTemplateReplacementsWithAllKeys() throws Exception {
        CreditNote note = newNote(replacements());

        Assert.assertEquals(CreditNote.TemplateReplacements.class, note.templateReplacements.getClass());
        Assert.assertEquals(replacements(), note.templateReplacements);
    }

    @Test
    public void testTemplateReplacementsInstancePassesThrough() throws Exception {
        CreditNote.TemplateReplacements given = new CreditNote.TemplateReplacements(replacements());

        Assert.assertSame(given, newNote(given).templateReplacements);
    }

    @Test
    public void testUnsupportedTypeIsRejected() throws Exception {
        try {
            newNote("not a map");
            Assert.fail("expected an exception");
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage(), e.getMessage().contains("templateReplacements"));
        }
    }

    @Test
    public void testResponseKeepsEveryKeyAsTemplateReplacements() throws Exception {
        String content = "{\"notes\": [{\"id\": \"5656565656565656\", \"paymentType\": \"transfer\", \"payment\": {}, "
                + "\"templateReplacements\": {\"guarantorName\": \"Jon Snow\", \"someNewKey\": \"x\", \"nested\": {\"a\": 1}}}]}";

        CreditNote note = ResponseHandler.post(content, CreditNote.class, "notes").get(0);

        Assert.assertEquals(CreditNote.TemplateReplacements.class, note.templateReplacements.getClass());
        Assert.assertEquals(3, note.templateReplacements.size());
        Assert.assertEquals("x", note.templateReplacements.get("someNewKey"));
        Assert.assertTrue(note.templateReplacements.containsKey("nested"));
    }

    @Test
    public void testResponseWithoutFieldLeavesItNull() throws Exception {
        String content = "{\"notes\": [{\"id\": \"5656565656565656\", \"paymentType\": \"transfer\", \"payment\": {}}]}";

        List<CreditNote> notes = ResponseHandler.post(content, CreditNote.class, "notes");

        Assert.assertNull(notes.get(0).templateReplacements);
    }

    @Test
    public void testPreviousPositionalConstructorStillExists() throws Exception {
        CreditNote note = new CreditNote(
                "5706627130851328", "Jamie Lannister", "20.018.183/0001-80", "2030-06-07", null,
                null, null, "offline-test-2", "Rua ABC",
                "Ap 123", "Jardim Paulista", "Sao Paulo", "SP", "01234-567",
                "transfer", 200000L, null, 0L, null, null,
                null, null, null, null,
                null, null, null,
                null, null, null, null, null
        );

        Assert.assertNull(note.templateReplacements);
        Assert.assertEquals("offline-test-2", note.externalId);
    }

    // Same steps as CreditNote.create followed by the core postRaw: toJsonTree of the notes, then
    // toJson/fromJson of the payload map. Only the HTTPS call is left out (the host is not injectable).
    private static JsonObject serializeLikeCreate(CreditNote note) {
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("notes", new Gson().toJsonTree(Collections.singletonList(note)).getAsJsonArray());

        JsonObject body = new Gson().fromJson(new Gson().toJson(payload), JsonObject.class);
        JsonArray notes = body.getAsJsonArray("notes");
        return notes.get(0).getAsJsonObject();
    }

    private static HashMap<String, Object> replacements() {
        HashMap<String, Object> replacements = new HashMap<>();
        replacements.put("guarantorName", "Jon Snow");
        replacements.put("cpfCnpjAvalista", "336.959.235-55");
        replacements.put("guarantorAddress", "Av. Paulista, 200");
        return replacements;
    }

    private static CreditNote newNote(Object templateReplacements) throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        data.put("templateId", "5706627130851328");
        data.put("name", "Jamie Lannister");
        data.put("taxId", "20.018.183/0001-80");
        data.put("nominalAmount", 200000L);
        data.put("scheduled", "2030-06-07");
        data.put("invoices", Collections.emptyList());
        data.put("payment", new CreditNote.Transfer(new HashMap<String, Object>() {{
            put("bankCode", "00000000");
            put("branchCode", "1234");
            put("accountNumber", "129340-1");
            put("taxId", "012.345.678-90");
            put("name", "Jamie Lannister");
        }}));
        data.put("signers", Collections.emptyList());
        data.put("externalId", "offline-test-1");
        data.put("rebateAmount", 0);
        data.put("streetLine1", "Rua ABC");
        data.put("streetLine2", "Ap 123");
        data.put("district", "Jardim Paulista");
        data.put("city", "Sao Paulo");
        data.put("stateCode", "SP");
        data.put("zipCode", "01234-567");
        if (templateReplacements != null) {
            data.put("templateReplacements", templateReplacements);
        }
        return new CreditNote(data);
    }
}
