import com.starkinfra.ReversalRequest;
import com.starkinfra.utils.Generator;
import com.starkinfra.PixRequest;
import com.starkinfra.Settings;
import com.starkinfra.utils.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;


public class TestReversalRequest {

    @Test
    public void testCreateAndDelete() throws Exception {
        Settings.user = utils.User.defaultProject();
        System.out.println(example());
        ReversalRequest request = ReversalRequest.create(example());
        Assert.assertNotNull(request.id);
    }

    @Test
    public void testDelete() throws Exception {
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "delivered");
        Generator<ReversalRequest> requests = ReversalRequest.query(params);
        for (ReversalRequest request : requests) {
            System.out.println(request);
            request = ReversalRequest.delete(request.id);
            Assert.assertEquals(request.status, "canceled");
            System.out.println(request);
        }
    }
    
    @Test
    public void testReversalRequestQueryAndDelete() throws Exception{
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("status", "created");
        int i = 0;
        for (ReversalRequest request : ReversalRequest.query(params)) {
            i ++;
            request = ReversalRequest.delete(request.id);
            Assert.assertEquals(request.status, "canceled");
            System.out.println(request);
        }
    }
    @Test
    
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "created");
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<ReversalRequest> requests = ReversalRequest.query(params);

        int i = 0;
        for (ReversalRequest request : requests) {
            i += 1;
            request = ReversalRequest.get(request.id);
            System.out.println(request);
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
        Generator<ReversalRequest.Log> logs = ReversalRequest.Log.query(params);
        int i = 0;
        for (ReversalRequest.Log log : logs) {
            i += 1;
            log = ReversalRequest.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.request.id);
            System.out.println(log);
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<ReversalRequest> requests = ReversalRequest.query(params);

        ArrayList<String> requestsIdsExpected = new ArrayList<>();
        for (ReversalRequest request : requests) {
            Assert.assertNotNull(request.id);
            requestsIdsExpected.add(request.id);
        }

        params.put("ids", requestsIdsExpected.toArray(new String[0]));
        Generator<ReversalRequest> requestsResult = ReversalRequest.query(params);

        ArrayList<String> requestsIdsResult = new ArrayList<>();
        for (ReversalRequest request : requestsResult){
            Assert.assertNotNull(request.id);
            requestsIdsResult.add(request.id);
        }

        Collections.sort(requestsIdsExpected);
        Collections.sort(requestsIdsResult);
        Assert.assertEquals(requestsIdsExpected, requestsIdsResult);
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
            ReversalRequest.Page page = ReversalRequest.page(params);
            for (ReversalRequest request: page.requests) {
                System.out.println(request);
                if (ids.contains(request.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(request.id);
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
            ReversalRequest.Log.Page page = ReversalRequest.Log.page(params);
            for (ReversalRequest.Log log: page.logs) {
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
    public void testUpdate() throws Exception {
        Settings.user = utils.User.defaultProject();
        String requestId = getRequestIdToPatch();
        HashMap<String, Object> patchData = new HashMap<>();
        patchData.put("result", "accepted");
        patchData.put("reversalReferenceId", ReturnId.create(System.getenv("SANDBOX_BANK_CODE")));
        if (!(requestId == null)) {
            ReversalRequest updatedReversalRequest = ReversalRequest.update(requestId, patchData);
            Assert.assertNotNull(updatedReversalRequest.id);
            System.out.println(updatedReversalRequest);
        }
        else {
            System.out.println("There are no ReversalRequests to patch");
            Assert.assertNotNull(null);
        }
    }

    public String getRequestIdToPatch() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("cursor", null);
        params.put("status", "delivered");
        String requestId = null;
        while (requestId == null) {
            ReversalRequest.Page page = ReversalRequest.page(params);
            for (ReversalRequest request: page.requests) {
                if (!request.senderBankCode.equals("34052649")){
                    requestId = request.id;
                    break;
                }
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }
        return requestId;
    }

    static ReversalRequest example() throws Exception{
        Random random = new Random();
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", random.nextInt(100000));
        data.put("referenceId", endToEndIdFromPixRequest());
        data.put("reason","fraud");
        return new ReversalRequest(data);
    }

    static String endToEndIdFromPixRequest() throws Exception{
        List<String> endToEndIds = new ArrayList<>();
        Random random = new Random();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixRequest> requests = PixRequest.query(params);
        for (PixRequest request : requests) {
            endToEndIds.add(request.endToEndId);
        }
        return endToEndIds.get(random.nextInt(10));

    }
}
