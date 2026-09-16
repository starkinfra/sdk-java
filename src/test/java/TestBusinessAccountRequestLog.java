import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.BusinessAccountRequest;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestBusinessAccountRequestLog {

    @Test
    public void testLogQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<BusinessAccountRequest.Log> logs = BusinessAccountRequest.Log.query(params);

        int i = 0;
        for (BusinessAccountRequest.Log log : logs) {
            i += 1;
            log = BusinessAccountRequest.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.request);
            Assert.assertTrue(log.request instanceof BusinessAccountRequest);
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testLogQueryByAccountRequestIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> requestParams = new HashMap<>();
        requestParams.put("limit", 2);
        Generator<BusinessAccountRequest> requests = BusinessAccountRequest.query(requestParams);

        List<String> requestIds = new ArrayList<>();
        for (BusinessAccountRequest request : requests) {
            requestIds.add(request.id);
        }

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 5);
        params.put("accountRequestIds", requestIds.toArray(new String[0]));
        Generator<BusinessAccountRequest.Log> logs = BusinessAccountRequest.Log.query(params);

        for (BusinessAccountRequest.Log log : logs) {
            Assert.assertTrue(requestIds.contains(log.request.id));
        }
    }

    @Test
    public void testLogPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            BusinessAccountRequest.Log.Page page = BusinessAccountRequest.Log.page(params);
            for (BusinessAccountRequest.Log log : page.logs) {
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

        if (ids.size() == 0) {
            throw new Exception("ids.size() == 0");
        }
    }

    @Test
    public void testLogTypeEnum() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 5);
        Generator<BusinessAccountRequest.Log> logs = BusinessAccountRequest.Log.query(params);

        for (BusinessAccountRequest.Log log : logs) {
            Assert.assertNotNull(log.type);
        }
    }
}
