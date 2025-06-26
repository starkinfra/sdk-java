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
        DynamicBrcode createdDynamicBrcode = createDynamicBrcodeByType("instant");
        BrcodePreview preview = createBrcodePreviewById(createdDynamicBrcode.id);

        Assert.assertEquals(createdDynamicBrcode.id, preview.id);
        Assert.assertEquals("", preview.due);
        Assert.assertNull(preview.subscription.amount);
    }

    @Test
    public void testTypeDue() throws Exception {
        DynamicBrcode createdDynamicBrcode = createDynamicBrcodeByType("due");
        BrcodePreview preview = createBrcodePreviewById(createdDynamicBrcode.id);

        Assert.assertEquals(createdDynamicBrcode.id, preview.id);
        Assert.assertNotEquals("", preview.due);
        Assert.assertNull(preview.subscription.amount);
    }
    
    @Test
    public void testTypeSubscription() throws Exception {
        DynamicBrcode createdDynamicBrcode = createDynamicBrcodeByType("subscription");
        BrcodePreview preview = createBrcodePreviewById(createdDynamicBrcode.id);

        Assert.assertEquals(createdDynamicBrcode.id, preview.id);
        Assert.assertEquals("", preview.payerId);
        Assert.assertEquals("qrcode", preview.subscription.type);
    }

    @Test
    public void testTypeSubscriptionAndInstant() throws Exception {
        DynamicBrcode createdDynamicBrcode = createDynamicBrcodeByType("subscriptionAndInstant");
        BrcodePreview preview = createBrcodePreviewById(createdDynamicBrcode.id);

        Assert.assertEquals(createdDynamicBrcode.id, preview.id);
        Assert.assertNotEquals("", preview.payerId);
        Assert.assertEquals("qrcodeAndPayment", preview.subscription.type);
    }

    @Test
    public void testTypeDueAndOrSubscription() throws Exception {
        DynamicBrcode createdDynamicBrcode = createDynamicBrcodeByType("dueAndOrSubscription");
        BrcodePreview preview = createBrcodePreviewById(createdDynamicBrcode.id);

        Assert.assertEquals(createdDynamicBrcode.id, preview.id);
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

    static DynamicBrcode createDynamicBrcodeByType(String type) throws Exception {
        List<DynamicBrcode> brcodes = new ArrayList<>();
        brcodes.add(exampleDynamicBrcode(type));
        brcodes = DynamicBrcode.create(brcodes);
        return brcodes.get(0);
    }

    static BrcodePreview exampleBrcodePreview(String id) throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("payerId", "20018183000180");
        return new BrcodePreview(data);
    }

    static BrcodePreview createBrcodePreviewById(String id) throws Exception {
        List<BrcodePreview> ids = new ArrayList<>();
        ids.add(exampleBrcodePreview(id));
        return BrcodePreview.create(ids).get(0);
    }
}
