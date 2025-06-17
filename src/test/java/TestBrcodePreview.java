import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.StaticBrcode;
import com.starkinfra.DynamicBrcode;
import com.starkinfra.BrcodePreview;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.UUID;
import java.util.HashMap;
import java.util.ArrayList;

import org.junit.Before;


public class TestBrcodePreview {

    @Before
    public void setup() throws Exception {
        Settings.user = utils.User.defaultProject();
    }

    @Test
    public void testBrcodePreview() throws Exception {
        List<BrcodePreview> ids = new ArrayList<>();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);

        Generator<StaticBrcode> brcodes = StaticBrcode.query(params);

        int i = 0;
        for (StaticBrcode brcode : brcodes) {
            ids.add(exampleBrcodePreview(brcode.id));
            Assert.assertNotNull(brcode.id);
            ++i;
        }
        Assert.assertEquals(3, i);
        Assert.assertNotNull(ids);

        List<BrcodePreview> previews = BrcodePreview.create(ids);
        Assert.assertEquals(previews.size(), ids.size());
        for (BrcodePreview preview : previews) {
            Assert.assertNotNull(preview);
        }
    }

    @Test
    public void testTypeInstant() throws Exception {
        String brcodeId = createDynamicBrcodeAndGetId("instant");
        BrcodePreview preview = createBrcodePreview(brcodeId).get(0);

        Assert.assertEquals(brcodeId, preview.id);
        Assert.assertEquals("", preview.due);
        Assert.assertNull(preview.subscription.amount);
    }

    @Test
    public void testTypeDue() throws Exception {
        String brcodeId = createDynamicBrcodeAndGetId("due");
        BrcodePreview preview = createBrcodePreview(brcodeId).get(0);

        Assert.assertEquals(brcodeId, preview.id);
        Assert.assertNotEquals("", preview.due);
        Assert.assertNull(preview.subscription.amount);
    }
    
    @Test
    public void testTypeSubscription() throws Exception {
        String brcodeId = createDynamicBrcodeAndGetId("subscription");
        BrcodePreview preview = createBrcodePreview(brcodeId).get(0);

        Assert.assertEquals(brcodeId, preview.id);
        Assert.assertEquals("", preview.payerId);
        Assert.assertEquals("qrcode", preview.subscription.type);
    }

    @Test
    public void testTypeSubscriptionAndInstant() throws Exception {
        String brcodeId = createDynamicBrcodeAndGetId("subscriptionAndInstant");
        BrcodePreview preview = createBrcodePreview(brcodeId).get(0);

        Assert.assertEquals(brcodeId, preview.id);
        Assert.assertNotEquals("", preview.payerId);
        Assert.assertEquals("qrcodeAndPayment", preview.subscription.type);
    }

    @Test
    public void testTypeDueAndOrSubscription() throws Exception {
        String brcodeId = createDynamicBrcodeAndGetId("dueAndOrSubscription");
        BrcodePreview preview = createBrcodePreview(brcodeId).get(0);

        Assert.assertEquals(brcodeId, preview.id);
        Assert.assertNotEquals("", preview.payerId);
        Assert.assertEquals("paymentAndOrQrcode", preview.subscription.type);
    }

    static DynamicBrcode exampleDynamicBrcode(String type) throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Tony Stark");
        data.put("city", "Rio de Janeiro");
        data.put("externalId", "java-" + UUID.randomUUID().toString());
        data.put("type", type);
        return new DynamicBrcode(data);
    }

    static String createDynamicBrcodeAndGetId(String type) throws Exception {
        List<DynamicBrcode> brcodes = new ArrayList<>();
        brcodes.add(exampleDynamicBrcode(type));
        brcodes = DynamicBrcode.create(brcodes);
        return brcodes.get(0).id;
    }

    static BrcodePreview exampleBrcodePreview(String id) throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("payerId", "20018183000180");
        return new BrcodePreview(data);
    }

    static List<BrcodePreview> createBrcodePreview(String id) throws Exception {
        List<BrcodePreview> ids = new ArrayList<>();
        ids.add(exampleBrcodePreview(id));
        return BrcodePreview.create(ids);
    }
}
