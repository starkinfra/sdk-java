import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.StaticBrcode;
import com.starkinfra.BrcodePreview;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestBrcodePreview {

    @Test
    public void testBrcodePreview() throws Exception {
        Settings.user = utils.User.defaultProject();

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

    static BrcodePreview exampleBrcodePreview(String id) throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", id);
        return new BrcodePreview(data);
    }
}
