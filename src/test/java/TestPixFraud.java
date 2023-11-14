import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.PixFraud;
import com.starkinfra.utils.Generator;

import java.util.*;

public class TestPixFraud {
    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<PixFraud> frauds = new ArrayList<>();
        frauds.add(example());
        frauds = PixFraud.create(frauds);
        for (PixFraud fraud : frauds) {
            Assert.assertNotNull(fraud.id);
            String id = PixFraud.get(fraud.id).id;
            Assert.assertEquals(id, fraud.id);
        }
        System.out.println(frauds);
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "registered");
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixFraud> frauds = PixFraud.query(params);

        int i = 0;
        for (PixFraud fraud : frauds) {
            i += 1;
            fraud = PixFraud.get(fraud.id);
            System.out.println(fraud);
        }
        System.out.println(i);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixFraud> frauds = PixFraud.query(params);

        ArrayList<String> fraudsIdsExpected = new ArrayList<>();
        for (PixFraud fraud : frauds) {
            Assert.assertNotNull(fraud.id);
            fraudsIdsExpected.add(fraud.id);
        }

        params.put("ids", fraudsIdsExpected.toArray(new String[0]));
        Generator<PixFraud> fraudsResult = PixFraud.query(params);

        ArrayList<String> fraudsIdsResult = new ArrayList<>();
        for (PixFraud fraud : fraudsResult){
            Assert.assertNotNull(fraud.id);
            fraudsIdsResult.add(fraud.id);
        }

        Collections.sort(fraudsIdsExpected);
        Collections.sort(fraudsIdsResult);
        Assert.assertEquals(fraudsIdsExpected, fraudsIdsResult);
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
            PixFraud.Page page = PixFraud.page(params);
            for (PixFraud fraud: page.frauds) {
                System.out.println(fraud);
                if (ids.contains(fraud.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(fraud.id);
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
    public void testPixFraudQueryAndCancel() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("status", "registered");
        int i = 0;
        for (PixFraud fraud : PixFraud.query(params)) {
            i ++;
            fraud = PixFraud.cancel(fraud.id);
            Assert.assertNotNull(fraud.id);
            System.out.println(fraud);
        }
    }

    static PixFraud example() throws Exception{
        String bankCode = utils.User.bankCode();
        HashMap<String, Object> data = new HashMap<>();
        data.put("externalId", "my_external_id_1234");
        data.put("type", "mule");
        data.put("taxId", "01234567890");
        return new PixFraud(data);
    }
}
