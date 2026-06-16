import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.PixKeyHolmes;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


public class TestPixKeyHolmes {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<PixKeyHolmes> holmes = new ArrayList<>();
        holmes.add(example());

        holmes = PixKeyHolmes.create(holmes);

        for (PixKeyHolmes sherlock : holmes) {
            Assert.assertNotNull(sherlock.id);
            Assert.assertNotNull(sherlock.status);
            Assert.assertFalse(sherlock.status.isEmpty());
            Assert.assertNotNull(sherlock.created);
            Assert.assertFalse(sherlock.created.isEmpty());
            Assert.assertNotNull(sherlock.updated);
            Assert.assertFalse(sherlock.updated.isEmpty());
        }
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("status", "solved");
        Generator<PixKeyHolmes> holmes = PixKeyHolmes.query(params);

        int i = 0;
        for (PixKeyHolmes sherlock : holmes) {
            i += 1;
            Assert.assertNotNull(sherlock.id);
            Assert.assertNotNull(sherlock.status);
            Assert.assertFalse(sherlock.status.isEmpty());
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixKeyHolmes> holmes = PixKeyHolmes.query(params);

        int i = 0;
        ArrayList<String> holmesIdsExpected = new ArrayList<>();
        for (PixKeyHolmes sherlock : holmes) {
            i += 1;
            Assert.assertNotNull(sherlock.id);
            holmesIdsExpected.add(sherlock.id);
        }

        params.put("ids", holmesIdsExpected.toArray(new String[0]));
        Generator<PixKeyHolmes> holmesResult = PixKeyHolmes.query(params);

        int n = 0;
        ArrayList<String> holmesIdsResult = new ArrayList<>();
        for (PixKeyHolmes sherlock : holmesResult) {
            n += 1;
            Assert.assertNotNull(sherlock.id);
            holmesIdsResult.add(sherlock.id);
        }

        Collections.sort(holmesIdsExpected);
        Collections.sort(holmesIdsResult);
        Assert.assertTrue(i > 0);
        Assert.assertTrue(n > 0);
        Assert.assertEquals(holmesIdsExpected, holmesIdsResult);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            PixKeyHolmes.Page page = PixKeyHolmes.page(params);
            for (PixKeyHolmes sherlock : page.holmes) {
                if (ids.contains(sherlock.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(sherlock.id);
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
    public void testCreateWithoutTags() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = new HashMap<>();
        data.put("keyId", "valid@sandbox.com");

        List<PixKeyHolmes> holmes = new ArrayList<>();
        holmes.add(new PixKeyHolmes(data));

        holmes = PixKeyHolmes.create(holmes);

        for (PixKeyHolmes sherlock : holmes) {
            Assert.assertNotNull(sherlock.id);
            Assert.assertFalse(sherlock.id.isEmpty());
        }
    }

    static PixKeyHolmes example() throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        data.put("keyId", "valid@sandbox.com");
        List<String> tags = new ArrayList<>();
        tags.add("travel");
        tags.add("food");
        data.put("tags", tags.toArray(new String[0]));
        return new PixKeyHolmes(data);
    }
}
