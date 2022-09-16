import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.PixInfraction;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.EndToEndId;

import java.util.List;
import java.util.Objects;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


public class TestPixInfraction {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<PixInfraction> infractions = new ArrayList<>();
        infractions.add(example());
        infractions = PixInfraction.create(infractions);
        for (PixInfraction infraction : infractions) {
            Assert.assertNotNull(infraction.id);
            String id = PixInfraction.get(infraction.id).id;
            Assert.assertEquals(id, infraction.id);
        }
        System.out.println(infractions);
    }

    @Test
    public void testCancel() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "delivered");
        Generator<PixInfraction> infractions = PixInfraction.query(params);
        for (PixInfraction infraction : infractions) {
            if (Objects.equals(infraction.flow, "out")) {
                infraction = PixInfraction.cancel(infraction.id);
                Assert.assertEquals(infraction.status, "canceled");
                System.out.println(infraction);
            }
        }
    }

    @Test
    public void testQueryAndCancel() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("status", "delivered");
        int i = 0;
        for (PixInfraction infraction : PixInfraction.query(params)) {
            i ++;
            infraction = PixInfraction.cancel(infraction.id);
            Assert.assertEquals(infraction.status, "canceled");
            System.out.println(infraction);
        }
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "delivered");
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixInfraction> infractions = PixInfraction.query(params);

        int i = 0;
        for (PixInfraction infraction : infractions) {
            i += 1;
            infraction = PixInfraction.get(infraction.id);
            System.out.println(infraction);
        }
        System.out.println(i);
    }

    @Test
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixInfraction.Log> logs = PixInfraction.Log.query(params);

        int i = 0;
        for (PixInfraction.Log log : logs) {
            i += 1;
            log = PixInfraction.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.infraction.id);
            System.out.println(log);
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixInfraction> infractions = PixInfraction.query(params);

        ArrayList<String> infractionsIdsExpected = new ArrayList<>();
        for (PixInfraction infraction : infractions) {
            Assert.assertNotNull(infraction.id);
            infractionsIdsExpected.add(infraction.id);
        }

        params.put("ids", infractionsIdsExpected.toArray(new String[0]));
        Generator<PixInfraction> infractionsResult = PixInfraction.query(params);

        ArrayList<String> infractionsIdsResult = new ArrayList<>();
        for (PixInfraction infraction : infractionsResult){
            Assert.assertNotNull(infraction.id);
            infractionsIdsResult.add(infraction.id);
        }

        Collections.sort(infractionsIdsExpected);
        Collections.sort(infractionsIdsResult);
        Assert.assertEquals(infractionsIdsExpected, infractionsIdsResult);
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
            PixInfraction.Page page = PixInfraction.page(params);
            for (PixInfraction infraction: page.infractions) {
                System.out.println(infraction);
                if (ids.contains(infraction.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(infraction.id);
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
    public void testLogPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            PixInfraction.Log.Page page = PixInfraction.Log.page(params);
            for (PixInfraction.Log log: page.logs) {
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

    @Test
    public void testUpdateStatus() throws Exception {
        Settings.user = utils.User.defaultProject();
        List<PixInfraction> infractions = getReportToPatch();

        for (PixInfraction infraction : infractions) {
            System.out.println(infraction);
            PixInfraction updatedPixInfraction = PixInfraction.update(infraction.id, "agreed");
            Assert.assertNotNull(updatedPixInfraction.id);
            System.out.println(updatedPixInfraction);
        }
    }

    public List<PixInfraction> getReportToPatch() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("cursor", null);
        params.put("status", "delivered");
        List<PixInfraction> infractions = new ArrayList<>();
        while (infractions.size() < 1) {
            PixInfraction.Page page = PixInfraction.page(params);
            for (PixInfraction infraction: page.infractions) {
                if (infraction.flow.equals("out")){
                    infractions.add(infraction);
                }
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }
        return(infractions);
    }

    static PixInfraction example() throws Exception{
        String bankCode = utils.User.bankCode();
        HashMap<String, Object> data = new HashMap<>();
        data.put("referenceId", EndToEndId.create(bankCode));
        data.put("type","fraud");
        return new PixInfraction(data);
    }
}
