import com.starkcore.utils.Generator;
import com.starkinfra.CreditHolmes;
import com.starkinfra.Settings;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TestCreditHolmes {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<CreditHolmes> holmes = CreditHolmes.create(exampleWithObject());
        for (CreditHolmes sherlock : holmes) {
            Assert.assertNotNull(sherlock.id);
            System.out.println(sherlock);
        }
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("status", "success");
        Generator<CreditHolmes> holmes = CreditHolmes.query(params);

        int i = 0;
        for (CreditHolmes sherlock : holmes) {
            i += 1;
            sherlock = CreditHolmes.get(sherlock.id);
            Assert.assertNotNull(sherlock.id);
            System.out.println(sherlock.result);
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
            CreditHolmes.Page page = CreditHolmes.page(params);
            for (CreditHolmes sherlock : page.holmes) {
                System.out.println(sherlock);
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
    public void testLogQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<CreditHolmes.Log> logs = CreditHolmes.Log.query(params);

        int i = 0;
        for (CreditHolmes.Log log : logs) {
            System.out.println(log);
            i += 1;
            log = CreditHolmes.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.holmes.id);
            System.out.println(log.holmes);
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
            CreditHolmes.Log.Page page = CreditHolmes.Log.page(params);
            for (CreditHolmes.Log log : page.logs) {
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

    static List<CreditHolmes> exampleWithObject() throws Exception {
        List<CreditHolmes> rules = new ArrayList<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("taxId", "012.345.678-90");
        data.put("competence", "2022-10");
        rules.add(new CreditHolmes(data));
        return rules;
    }

    public static String getDateString(int delta) {
        return LocalDate.now().plusDays(delta).toString();
    }
}
