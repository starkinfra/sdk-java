import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.StaticBrcode;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class TestStaticBrcode {

    @Test
    public void testStaticBrcodeQuery() throws Exception {

        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<StaticBrcode> brcodes = StaticBrcode.query(params);
        Assert.assertNotNull(brcodes);

        int i = 0;
        for (StaticBrcode brcode : brcodes) {
            Assert.assertNotNull(brcode.uuid);
            brcode = StaticBrcode.get(brcode.uuid);
            Assert.assertNotNull(brcode.id);
            ++i;
        }
        Assert.assertEquals(3, i);
    }

    @Test
    public void testStaticBrcodePage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            StaticBrcode.Page page = StaticBrcode.page(params);
            Assert.assertNotNull(page);
            Assert.assertEquals(2, page.brcodes.size());
            for (StaticBrcode brcode: page.brcodes) {
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
    public void testStaticBrcodeGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<StaticBrcode> brcodes = StaticBrcode.query(params);
        Assert.assertNotNull(brcodes);

        int i = 0;
        for (StaticBrcode brcode : brcodes) {
            Assert.assertNotNull(brcode.uuid);
            brcode = StaticBrcode.get(brcode.uuid);
            Assert.assertNotNull(brcode.id);
            ++i;
        }
        Assert.assertEquals(3, i);
    }

    @Test
    public void testStaticBrcodeCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<StaticBrcode> brcodes = new ArrayList<>();
        brcodes.add(example());
        brcodes = StaticBrcode.create(brcodes);
        Assert.assertNotNull(brcodes);

        for (StaticBrcode brcode : brcodes) {
            System.out.println(brcode);
            Assert.assertNotNull(brcode.uuid);
            String uuid = StaticBrcode.get(brcode.uuid).uuid;
            Assert.assertEquals(uuid, brcode.uuid);
        }
    }

    static StaticBrcode example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Tony Stark");
        data.put("keyId", "+5541999999999");
        data.put("city", "Rio de Janeiro");
        data.put("amount", Long.valueOf(100));
        data.put("cashierBankCode", "20018183");
        data.put("description", "A StaticBrcode");
        return new StaticBrcode(data);
    }
}
