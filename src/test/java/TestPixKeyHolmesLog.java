import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.PixKeyHolmes;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestPixKeyHolmesLog {

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixKeyHolmes.Log> logs = PixKeyHolmes.Log.query(params);

        int i = 0;
        for (PixKeyHolmes.Log log : logs) {
            i += 1;
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.type);
            Assert.assertNotNull(log.holmes.id);
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            PixKeyHolmes.Log.Page page = PixKeyHolmes.Log.page(params);
            for (PixKeyHolmes.Log log : page.logs) {
                Assert.assertFalse(ids.contains(log.id));
                ids.add(log.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }

        Assert.assertEquals(4, ids.size());
    }

    @Test
    public void testGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        PixKeyHolmes.Log first = PixKeyHolmes.Log.query(params).iterator().next();

        PixKeyHolmes.Log log = PixKeyHolmes.Log.get(first.id);
        Assert.assertEquals(first.id, log.id);
        Assert.assertNotNull(log.holmes.id);
    }
}
