import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.CreditNote;
import com.starkinfra.CreditPreview;
import com.starkinfra.CreditPreview.CreditNotePreview;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;

public class TestCreditPreview {

    @Test
    public void testCreditNotePreviewSac() throws Exception {
        Settings.user = utils.User.defaultProject();

        CreditNotePreview creditNoteSac = getCreditNotePreviewExample("sac");
        CreditNotePreview creditNotePrice = getCreditNotePreviewExample("price");
        CreditNotePreview creditNoteAmerican = getCreditNotePreviewExample("american");
        CreditNotePreview creditNoteBullet = getCreditNotePreviewExample("bullet");

        List<String> expectedTypes = new ArrayList<>();
        expectedTypes.add("credit-note");
        expectedTypes.add("credit-note");
        expectedTypes.add("credit-note");
        expectedTypes.add("credit-note");

        List<String> expectedNoteTypes = new ArrayList<>();
        expectedNoteTypes.add("sac");
        expectedNoteTypes.add("price");
        expectedNoteTypes.add("american");
        expectedNoteTypes.add("bullet");

        List<String> previewedTypes = new ArrayList<>();
        List<String> creditNotePreviewedTypes = new ArrayList<>();

        List<CreditPreview> creditNotePreviews = new ArrayList<>();
        creditNotePreviews.add(new CreditPreview(creditNoteSac, "credit-note"));
        creditNotePreviews.add(new CreditPreview(creditNotePrice, "credit-note"));
        creditNotePreviews.add(new CreditPreview(creditNoteAmerican, "credit-note"));
        creditNotePreviews.add(new CreditPreview(creditNoteBullet, "credit-note"));

        System.out.println(creditNotePreviews);
        List <CreditPreview> previews = CreditPreview.create(creditNotePreviews);
        Assert.assertNotNull(previews);

        for (CreditPreview preview : previews) {
            previewedTypes.add(preview.type);
            creditNotePreviewedTypes.add(preview.credit.type);
        }
        Assert.assertEquals(creditNotePreviewedTypes, expectedNoteTypes);
        Assert.assertEquals(expectedTypes, previewedTypes);
    }

    static CreditNotePreview getCreditNotePreviewExample(String type) throws Exception {
        switch (type){
            case "sac":
                return exampleSacPreview();
            case "price":
                return examplePricePreview();
            case "american":
                return exampleAmericanPreview();
            case "bullet":
                return exampleBulletPreview();
            case "custom":
                return exampleCustomPreview();
        }
        return null;
    }

    static CreditNotePreview exampleSacPreview() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("type", "sac");
        data.put("nominalAmount", 100000);
        data.put("scheduled", getDateString(3));
        data.put("taxId", "20.018.183/0001-80");
        data.put("initialDue", getDateString(4));
        data.put("nominalInterest", 15);
        data.put("count", 1);
        data.put("interval", "year");
        data.put("rebateAmount", 0);
        return new CreditNotePreview(data);
    }

    static CreditNotePreview exampleCustomPreview() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("type", "custom");
        data.put("nominalAmount", 1000);
        data.put("scheduled", getDateString(3));
        data.put("taxId", "20.018.183/0001-80");
        data.put("rebateAmount", 0);
        data.put("initialDue", getDateString(4));
        data.put("invoices", generateInvoice());
        return new CreditNotePreview(data);
    }

    static CreditNotePreview exampleBulletPreview() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("type", "bullet");
        data.put("nominalAmount", 100000);
        data.put("scheduled", getDateString(3));
        data.put("taxId", "20.018.183/0001-80");
        data.put("initialDue", getDateString(4));
        data.put("nominalInterest", 15);
        data.put("rebateAmount", 0);
        return new CreditNotePreview(data);
    }

    static CreditNotePreview exampleAmericanPreview() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("type", "american");
        data.put("nominalAmount", 100000);
        data.put("scheduled", getDateString(3));
        data.put("taxId", "20.018.183/0001-80");
        data.put("initialDue", getDateString(4));
        data.put("nominalInterest", 15);
        data.put("count", 5);
        data.put("interval", "month");
        data.put("rebateAmount", 900);
        return new CreditNotePreview(data);
    }

    static CreditNotePreview examplePricePreview() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("type", "price");
        data.put("nominalAmount", 100000);
        data.put("scheduled", getDateString(3));
        data.put("taxId", "20.018.183/0001-80");
        data.put("initialDue", getDateString(4));
        data.put("nominalInterest", 15);
        data.put("count", 15);
        data.put("interval", "year");
        data.put("rebateAmount", 900);
        return new CreditNotePreview(data);
    }
    public static String getDateString(int delta) {
        return LocalDate.now().plusDays(delta).toString();
    }

    static List<CreditNote.Invoice> generateInvoice() throws Exception {
        List<CreditNote.Invoice> invoices = new ArrayList<>();
        HashMap<String, Object> invoice = new HashMap<String, Object>() {{
            put("amount", 50000);
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
            put("due", getDateString(30));
            put("descriptions", descriptions);
        }};
        invoices.add(new CreditNote.Invoice(invoice));
        return invoices;
    }
}
