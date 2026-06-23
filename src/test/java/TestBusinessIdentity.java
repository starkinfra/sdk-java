import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.BusinessIdentity;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;


public class TestBusinessIdentity {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();
        Settings.language = "en-US";

        List<BusinessIdentity> identities = BusinessIdentity.create(exampleWithObject());
        for (BusinessIdentity identity : identities) {
            Assert.assertNotNull(identity.id);
        }
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<BusinessIdentity> identities = BusinessIdentity.query(params);

        int i = 0;
        for (BusinessIdentity identity : identities) {
            i += 1;
            identity = BusinessIdentity.get(identity.id);
            Assert.assertNotNull(identity.id);
        }
        Assert.assertEquals(3, i);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            BusinessIdentity.Page page = BusinessIdentity.page(params);
            for (BusinessIdentity identity : page.identities) {
                if (ids.contains(identity.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(identity.id);
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
    public void testUpdate() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        Generator<BusinessIdentity> identities = BusinessIdentity.query(params);
        for (BusinessIdentity identity : identities) {
            HashMap<String, Object> patchData = new HashMap<>();
            patchData.put("tags", identity.tags);
            identity = BusinessIdentity.update(identity.id, patchData);
            Assert.assertNotNull(identity.id);
        }
    }

    @Test
    public void testQueryAndCancel() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("status", "created");
        Generator<BusinessIdentity> identities = BusinessIdentity.query(params);
        for (BusinessIdentity identity : identities) {
            identity = BusinessIdentity.cancel(identity.id);
            Assert.assertEquals(identity.status, "canceled");
        }
    }

    @Test
    public void testLogQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<BusinessIdentity.Log> logs = BusinessIdentity.Log.query(params);

        int i = 0;
        for (BusinessIdentity.Log log : logs) {
            i += 1;
            log = BusinessIdentity.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.identity.id);
        }
        Assert.assertEquals(3, i);
    }

    @Test
    public void testLogPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            BusinessIdentity.Log.Page page = BusinessIdentity.Log.page(params);
            for (BusinessIdentity.Log log : page.logs) {
                if (ids.contains(log.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(log.id);
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

    static List<BusinessIdentity> exampleWithObject() throws Exception {

        List<BusinessIdentity> identities = new ArrayList<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("taxId", "20.018.183/0001-80");
        data.put("tags", new String[]{"onboarding-123"});

        identities.add(new BusinessIdentity(data));
        return identities;
    }

    public static String getDateString(int delta) {
        return LocalDate.now().plusDays(delta).toString();
    }
}
