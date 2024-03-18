import com.starkinfra.IssuingCard;
import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.IssuingPurchase;
import com.starkinfra.utils.Generator;
import com.starkinfra.error.InvalidSignatureError;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;


public class TestIssuingPurchase {

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingPurchase.Page page = IssuingPurchase.page(params);
            for (IssuingPurchase purchase: page.issuingPurchases) {
                System.out.println(purchase);
                if (ids.contains(purchase.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(purchase.id);
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
        Generator<IssuingPurchase> purchases = IssuingPurchase.query(params);

        for (IssuingPurchase purchase : purchases) {
            IssuingPurchase purchaseExpected = IssuingPurchase.get(purchase.id);
            Assert.assertNotNull(purchase.id, purchaseExpected.id);
            Assert.assertEquals(HashMap.class, purchase.metadata.getClass());
            System.out.println(purchase);
        }
    }

    @Test
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingPurchase.Log> logs = IssuingPurchase.Log.query(params);

        for (IssuingPurchase.Log log : logs) {
            log = IssuingPurchase.Log.get(log.id);
            System.out.println(log);
        }
    }

    @Test
    public void testUpdateStatus() throws Exception {
        Settings.user = utils.User.defaultProject();

        Map<String, Object> patchData = new HashMap<>();
        patchData.put("description", "war supply");
        patchData.put("tags", new String[]{"Arya", "Stark"});

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);

        Generator<IssuingPurchase> purchases = IssuingPurchase.query(params);

        for (IssuingPurchase purchase : purchases) {
            IssuingPurchase updatedIssuingPurchase = IssuingPurchase.update(purchase.id, patchData);
            Assert.assertEquals("war supply", updatedIssuingPurchase.description);
        }
    }

    @Test
    public void testResponse() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<String> tags = new ArrayList<>();
        tags.add("test");
        tags.add("response");
        tags.add("issuing-purchase");

        HashMap<String, Object> datas = new HashMap<>();
        datas.put("status", "approved");
        datas.put("amount", 100000);
        datas.put("reason", "other");
        datas.put("tags", tags);

        HashMap<String, Object> data = new HashMap<>();
        data.put("authorization", datas);

        String response = IssuingPurchase.response(data);
        Assert.assertNotNull(response);
        System.out.println(response);
    }

    @Test
    public void testParse() throws Exception{
        String content = "{\"acquirerId\": \"236090\", \"amount\": 100, \"cardId\": \"5671893688385536\", \"cardTags\": [], \"endToEndId\": \"2fa7ef9f-b889-4bae-ac02-16749c04a3b6\", \"holderId\": \"5917814565109760\", \"holderTags\": [], \"isPartialAllowed\": false, \"issuerAmount\": 100, \"issuerCurrencyCode\": \"BRL\", \"merchantAmount\": 100, \"merchantCategoryCode\": \"bookStores\", \"merchantCountryCode\": \"BRA\", \"merchantCurrencyCode\": \"BRL\", \"merchantFee\": 0, \"merchantId\": \"204933612653639\", \"merchantName\": \"COMPANY 123\", \"methodCode\": \"token\", \"purpose\": \"purchase\", \"score\": null, \"tax\": 0, \"walletId\": \"\"}";
        String validSignature = "MEUCIBxymWEpit50lDqFKFHYOgyyqvE5kiHERi0ZM6cJpcvmAiEA2wwIkxcsuexh9BjcyAbZxprpRUyjcZJ2vBAjdd7o28Q=";
        Settings.user = utils.User.defaultProject();

        IssuingPurchase request = IssuingPurchase.parse(content, validSignature);
        System.out.println(request);
    }

    @Test
    public void testParseMalformedSignature() throws Exception{
        String content = "{\"acquirerId\": \"236090\", \"amount\": 100, \"cardId\": \"5671893688385536\", \"cardTags\": [], \"endToEndId\": \"2fa7ef9f-b889-4bae-ac02-16749c04a3b6\", \"holderId\": \"5917814565109760\", \"holderTags\": [], \"isPartialAllowed\": false, \"issuerAmount\": 100, \"issuerCurrencyCode\": \"BRL\", \"merchantAmount\": 100, \"merchantCategoryCode\": \"bookStores\", \"merchantCountryCode\": \"BRA\", \"merchantCurrencyCode\": \"BRL\", \"merchantFee\": 0, \"merchantId\": \"204933612653639\", \"merchantName\": \"COMPANY 123\", \"methodCode\": \"token\", \"purpose\": \"purchase\", \"score\": null, \"tax\": 0, \"walletId\": \"\"}";
        String malformedSignature = "something is definitely wrong";
        Settings.user = utils.User.defaultProject();

        try{
            IssuingPurchase.parse(content, malformedSignature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }

    @Test
    public void testParseInvalidSignature() throws Exception{
        String content = "{\"acquirerId\": \"236090\", \"amount\": 100, \"cardId\": \"5671893688385536\", \"cardTags\": [], \"endToEndId\": \"2fa7ef9f-b889-4bae-ac02-16749c04a3b6\", \"holderId\": \"5917814565109760\", \"holderTags\": [], \"isPartialAllowed\": false, \"issuerAmount\": 100, \"issuerCurrencyCode\": \"BRL\", \"merchantAmount\": 100, \"merchantCategoryCode\": \"bookStores\", \"merchantCountryCode\": \"BRA\", \"merchantCurrencyCode\": \"BRL\", \"merchantFee\": 0, \"merchantId\": \"204933612653639\", \"merchantName\": \"COMPANY 123\", \"methodCode\": \"token\", \"purpose\": \"purchase\", \"score\": null, \"tax\": 0, \"walletId\": \"\"}";
        String invalidSignature = "MEUCIQDOpo1j+V40pNZK2URL2786UQK/8mDXon9ayEd8U0/l7AIgYXtIZJBTs8zCRR3vmted6Ehz/qfw1GRut/eYyvf1yOk=";
        Settings.user = utils.User.defaultProject();

        try{
            IssuingPurchase.parse(content, invalidSignature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }

    static IssuingPurchase example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", 1000);

        return new IssuingPurchase(data);
    }
}
