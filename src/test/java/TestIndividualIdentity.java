import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.IndividualIdentity;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;


public class TestIndividualIdentity {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<IndividualIdentity> identities = IndividualIdentity.create(exampleWithObject());
        System.out.println(identities);
        for (IndividualIdentity identity : identities) {
            Assert.assertNotNull(identity.id);
            System.out.println(identity);
        }
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IndividualIdentity> identities = IndividualIdentity.query(params);

        int i = 0;
        for (IndividualIdentity identity : identities) {
            i += 1;
            identity = IndividualIdentity.get(identity.id);
            Assert.assertNotNull(identity.id);
            System.out.println(identity);
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
            IndividualIdentity.Page page = IndividualIdentity.page(params);
            for (IndividualIdentity identity : page.identities) {
                System.out.println(identity);
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
    public void testQueryAndCancel() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("status", "created");
        Generator<IndividualIdentity> identities = IndividualIdentity.query(params);
        for (IndividualIdentity identity : identities) {
            identity = IndividualIdentity.cancel(identity.id);
            Assert.assertEquals(identity.status, "canceled");
            System.out.println(identity);
        }
    }

    @Test
    public void testLogQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<IndividualIdentity.Log> logs = IndividualIdentity.Log.query(params);

        int i = 0;
        for (IndividualIdentity.Log log : logs) {
            System.out.println(log);
            i += 1;
            log = IndividualIdentity.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.identity.id);
            System.out.println(log);
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
            IndividualIdentity.Log.Page page = IndividualIdentity.Log.page(params);
            for (IndividualIdentity.Log log : page.logs) {
                System.out.println(log);
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

    static List<IndividualIdentity> exampleWithObject() throws Exception {

        List<IndividualIdentity> identities = new ArrayList<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Walter White");
        data.put("taxId", "012.345.678-90");
        data.put("tags", new String[]{"Breaking", "Bad"});

        identities.add(new IndividualIdentity(data));
        return identities;
    }

    public static String getDateString(int delta) {
        return LocalDate.now().plusDays(delta).toString();
    }
}
