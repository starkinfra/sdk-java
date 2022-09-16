import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.DynamicBrcode;
import com.starkinfra.utils.Generator;
import com.starkinfra.error.InvalidSignatureError;

import java.util.List;
import java.util.UUID;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


public class TestDynamicBrcode {

    @Test
    public void testDynamicBrcodeQuery() throws Exception {
      Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2021-04-29");
        params.put("before", "2030-04-29");

        Generator<DynamicBrcode> brcodes = DynamicBrcode.query(params);
        Assert.assertNotNull(brcodes);

        int i = 0;
        for (DynamicBrcode brcode : brcodes) {
            brcode = DynamicBrcode.get(brcode.uuid);
            Assert.assertNotNull(brcode.id);
            ++i;
        }
        Assert.assertEquals(3, i);
    }

    @Test
    public void testDynamicBrcodePage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            DynamicBrcode.Page page = DynamicBrcode.page(params);
            Assert.assertNotNull(page);
            Assert.assertEquals(2, page.brcodes.size());
            for (DynamicBrcode brcode: page.brcodes) {
                Assert.assertNotNull(brcode);
                if (ids.contains(brcode.uuid)) {
                    throw new Exception("repeated id");
                }
                ids.add(brcode.uuid);
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
    public void testDynamicBrcodeGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");

        Generator<DynamicBrcode> brcodes = DynamicBrcode.query(params);
        Assert.assertNotNull(brcodes);

        int i = 0;
        for (DynamicBrcode brcode : brcodes) {
            brcode = DynamicBrcode.get(brcode.uuid);
            Assert.assertNotNull(brcode);
            ++i;
        }
        Assert.assertEquals(3, i);
    }

    @Test
    public void testDynamicBrcodeCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<DynamicBrcode> brcodes = new ArrayList<>();
        brcodes.add(example());
        brcodes = DynamicBrcode.create(brcodes);
        Assert.assertNotNull(brcodes);

        for (DynamicBrcode brcode : brcodes) {
            Assert.assertNotNull(brcode.uuid);
            String uuid = DynamicBrcode.get(brcode.uuid).uuid;
            Assert.assertEquals(uuid, brcode.uuid);
        }
    }

    @Test
    public void testValidSignature() throws Exception{
        String uuid = "21f174ab942843eb90837a5c3135dfd6";
        String validSignature = "MEYCIQC+Ks0M54DPLEbHIi0JrMiWbBFMRETe/U2vy3gTiid3rAIhANMmOaxT03nx2bsdo+vg6EMhWGzdphh90uBH9PY2gJdd";
        Settings.user = utils.User.defaultProject();

        try{
            DynamicBrcode.verify(uuid, validSignature);
            System.out.println("Signature correctly validated");
        } catch (InvalidSignatureError e){
            throw new Error("Signature correctly rejected");
        }
    }

    @Test
    public void testInvalidSignature() throws Exception{
        String uuid = "21f174ab942843eb90837a5c3135dfd6";
        String invalidSignature = "MEUCIQDOpo1j+V40pNZK2URL2786UQK/8mDXon9ayEd8U0/l7AIgYXtIZJBTs8zCRR3vmted6Ehz/qfw1GRut/eYyvf1yOk=";

        Settings.user = utils.User.defaultProject();

        try{
            DynamicBrcode.verify(uuid, invalidSignature);
            throw new Error("Signature correctly rejected");
        } catch (InvalidSignatureError ignored){}
    }

    @Test
    public void testDynamicBrcodeResponseDue() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = new HashMap<>();
        data.put("percentage", 3);
        data.put("due", "2022-07-13");

        DynamicBrcode.Discount discount = new DynamicBrcode.Discount(data);

        HashMap<String, Object> datas = new HashMap<>();
        data.put("version", 1);
        data.put("created", "2022-07-10");
        data.put("due", "2022-07-15");
        data.put("keyId", "+5511989898989");
        data.put("status", "paid");
        data.put("reconciliationId", "123456");
        data.put("nominalAmount", 10000);
        data.put("senderName", "Jamie Lannister");
        data.put("receiverName", "Anthony Edward Stark");
        data.put("receiverStreetLine", "Av. Paulista 200");
        data.put("receiverCity", "Sao Paulo");
        data.put("receiverStateCode", "SP");
        data.put("receiverZipCode", "01234-567");
        data.put("expiration", "82000");
        data.put("senderTaxId", "012.345.678-90");
        data.put("receiverTaxId", "20.018.183/0001-8");
        data.put("fine", 2);
        data.put("interest", 1);
        data.put("discounts", Collections.singletonList(discount));
        data.put("description", "Java test");

        String dues = DynamicBrcode.responseDue(datas);
        Assert.assertNotNull(dues);
    }

    @Test
    public void testDynamicBrcodeResponseInstant() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = new HashMap<>();
        data.put("version", 1);
        data.put("created", "2020-03-10 10:30:00.000000+00:00");
        data.put("keyId", "+5511989898989");
        data.put("status", "created");
        data.put("reconciliationId", "ah27s53agj6493hjds6836v49");
        data.put("amount", 1234);
        data.put("expiration", "82000");
        data.put("cashierType", "merchant");
        data.put("cashierBankCode", "20018183");
        data.put("cashAmount", 1000);
        data.put("senderName", "Anthony Edward Stark");
        data.put("senderTaxId", "01.001.001/0001-01");
        data.put("amountType", "fixed");
        data.put("description", "Java test");

        String instant = DynamicBrcode.responseInstant(data);
        Assert.assertNotNull(instant);
    }

    static DynamicBrcode example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Tony Stark");
        data.put("city", "Rio de Janeiro");
        data.put("externalId", "java-" + UUID.randomUUID().toString());
        data.put("type", "instant");
        return new DynamicBrcode(data);
    }

    @Test
    public void testExample() throws Exception {
        Settings.user = utils.User.defaultProject();

        DynamicBrcode brcode = DynamicBrcode.get("7cc0974604224a63a67764b921836e67");

        System.out.println(brcode);
    }
}
