import org.junit.Test;

import com.starkinfra.Settings;
import com.starkinfra.IndividualAccountRequest;
import com.starkinfra.utils.Generator;
import com.starkcore.error.InputErrors;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class TestIndividualAccountRequest {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<IndividualAccountRequest> requests = new ArrayList<>();
        requests.add(example());

        requests = IndividualAccountRequest.create(requests);

        for (IndividualAccountRequest request : requests) {
            assertNotNull(request.id);
            assertNotNull(request.status);
            assertEquals("individual", request.accountType);
            assertNotNull(request.created);
            assertNotNull(request.updated);
            String id = IndividualAccountRequest.get(request.id).id;
            assertEquals(id, request.id);
        }
    }

    @Test
    public void testCreateWithObjectAddress() throws Exception {
        Settings.user = utils.User.defaultProject();

        IndividualAccountRequest request = example();

        assertNotNull(request.address);
        assertEquals("Rua do Estilo Barroco", request.address.street);
        assertEquals("648", request.address.number);
        assertEquals("Santo Amaro", request.address.neighborhood);
        assertEquals("Sao Paulo", request.address.city);
        assertEquals("SP", request.address.state);
        assertEquals("05724005", request.address.zipCode);
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IndividualAccountRequest> requests = IndividualAccountRequest.query(params);

        int i = 0;
        for (IndividualAccountRequest request : requests) {
            i += 1;
            request = IndividualAccountRequest.get(request.id);
            assertNotNull(request.id);
        }
        assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        params.put("tags", new String[]{"employees", "monthly"});
        Generator<IndividualAccountRequest> requests = IndividualAccountRequest.query(params);

        int i = 0;
        ArrayList<String> requestsIdsExpected = new ArrayList<>();
        for (IndividualAccountRequest request : requests) {
            i += 1;
            assertNotNull(request.id);
            requestsIdsExpected.add(request.id);
        }

        params.put("ids", requestsIdsExpected.toArray(new String[0]));
        Generator<IndividualAccountRequest> requestsResult = IndividualAccountRequest.query(params);

        int n = 0;
        ArrayList<String> requestsIdsResult = new ArrayList<>();
        for (IndividualAccountRequest request : requestsResult) {
            n += 1;
            assertNotNull(request.id);
            requestsIdsResult.add(request.id);
        }

        assertTrue(i > 0);
        assertTrue(n > 0);
        for (String id : requestsIdsResult) {
            assertTrue(
                "ids filter returned an id outside the requested set: " + id,
                requestsIdsExpected.contains(id)
            );
        }
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
            IndividualAccountRequest.Page page = IndividualAccountRequest.page(params);
            for (IndividualAccountRequest request : page.requests) {
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
    public void testUpdate() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> patchData = new HashMap<>();
        patchData.put("name", "Tony Stark");

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        Generator<IndividualAccountRequest> requests = IndividualAccountRequest.query(params);
        for (IndividualAccountRequest request : requests) {
            IndividualAccountRequest updated = IndividualAccountRequest.update(request.id, patchData);
            assertEquals("Tony Stark", updated.name);
            assertEquals(request.id, updated.id);
        }
    }

    @Test
    public void testUpdateAddress() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> newAddress = new HashMap<>();
        newAddress.put("street", "Avenida Paulista");
        newAddress.put("number", "1000");
        newAddress.put("neighborhood", "Bela Vista");
        newAddress.put("city", "Sao Paulo");
        newAddress.put("state", "SP");
        newAddress.put("zipCode", "01310100");

        HashMap<String, Object> patchData = new HashMap<>();
        patchData.put("address", newAddress);

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        Generator<IndividualAccountRequest> requests = IndividualAccountRequest.query(params);
        for (IndividualAccountRequest request : requests) {
            IndividualAccountRequest updated = IndividualAccountRequest.update(request.id, patchData);
            assertEquals("Avenida Paulista", updated.address.street);
            assertEquals("01310100", updated.address.zipCode);
        }
    }

    @Test
    public void testStatusEnum() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<String> allowed = Arrays.asList("approved", "created", "denied", "processing", "updated");

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 5);
        Generator<IndividualAccountRequest> requests = IndividualAccountRequest.query(params);

        int i = 0;
        for (IndividualAccountRequest request : requests) {
            i += 1;
            assertNotNull(request.status);
            assertTrue("unexpected status: " + request.status, allowed.contains(request.status));
        }
        assertTrue(i > 0);
    }

    @Test
    public void testLogQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("types", new String[]{"created"});
        Generator<IndividualAccountRequest.Log> logs = IndividualAccountRequest.Log.query(params);

        int i = 0;
        for (IndividualAccountRequest.Log log : logs) {
            i += 1;
            log = IndividualAccountRequest.Log.get(log.id);
            assertNotNull(log.id);
            assertNotNull(log.request.id);
        }
        assertTrue(i > 0);
    }

    @Test
    public void testLogQueryAccountRequestIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 5);
        Generator<IndividualAccountRequest.Log> logs = IndividualAccountRequest.Log.query(params);

        ArrayList<String> accountRequestIds = new ArrayList<>();
        for (IndividualAccountRequest.Log log : logs) {
            accountRequestIds.add(log.request.id);
        }

        HashMap<String, Object> filterParams = new HashMap<>();
        filterParams.put("limit", 5);
        filterParams.put("accountRequestIds", accountRequestIds.toArray(new String[0]));
        Generator<IndividualAccountRequest.Log> filtered = IndividualAccountRequest.Log.query(filterParams);

        int i = 0;
        for (IndividualAccountRequest.Log log : filtered) {
            i += 1;
            assertNotNull(log.id);
            assertTrue(accountRequestIds.contains(log.request.id));
        }
        assertTrue(i > 0);
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
            IndividualAccountRequest.Log.Page page = IndividualAccountRequest.Log.page(params);
            for (IndividualAccountRequest.Log log : page.logs) {
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
    public void testDateTimeParsing() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        Generator<IndividualAccountRequest> requests = IndividualAccountRequest.query(params);

        int i = 0;
        for (IndividualAccountRequest request : requests) {
            i += 1;
            assertNotNull(request.created);
            assertNotNull(request.updated);
        }
        assertTrue(i > 0);
    }

    @Test
    public void testOutputOnlyFieldsRejectedByConstructor() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = exampleData();
        data.put("status", "created");
        data.put("accountType", "individual");

        try {
            new IndividualAccountRequest(data);
            throw new Exception("expected the constructor to reject the return-only fields");
        } catch (Exception e) {
            assertTrue(
                "expected unknown-parameter rejection, got: " + e.getMessage(),
                e.getMessage() != null
                    && e.getMessage().startsWith("Unknown parameters used in constructor:")
            );
        }
    }

    @Test
    public void testCreateInvalidName() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = exampleData();
        data.put("name", "");

        List<IndividualAccountRequest> requests = new ArrayList<>();
        requests.add(new IndividualAccountRequest(data));

        boolean raised = false;
        try {
            IndividualAccountRequest.create(requests);
        } catch (InputErrors e) {
            raised = true;
        }
        assertTrue("expected InputErrors to be raised", raised);
    }

    @Test
    public void testCreateInvalidTaxId() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = exampleData();
        data.put("taxId", "000.000.000-00");

        List<IndividualAccountRequest> requests = new ArrayList<>();
        requests.add(new IndividualAccountRequest(data));

        boolean raised = false;
        try {
            IndividualAccountRequest.create(requests);
        } catch (InputErrors e) {
            raised = true;
        }
        assertTrue("expected InputErrors to be raised", raised);
    }

    @Test
    public void testCreateInvalidAddress() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> incompleteAddress = new HashMap<>();
        incompleteAddress.put("street", "Rua do Estilo Barroco");

        HashMap<String, Object> data = exampleData();
        data.put("address", incompleteAddress);

        List<IndividualAccountRequest> requests = new ArrayList<>();
        requests.add(new IndividualAccountRequest(data));

        boolean raised = false;
        try {
            IndividualAccountRequest.create(requests);
        } catch (InputErrors e) {
            raised = true;
        }
        assertTrue("expected InputErrors to be raised", raised);
    }

    @Test
    public void testCreateInvalidIncome() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = exampleData();
        data.put("income", -1L);

        List<IndividualAccountRequest> requests = new ArrayList<>();
        requests.add(new IndividualAccountRequest(data));

        boolean raised = false;
        try {
            IndividualAccountRequest.create(requests);
        } catch (InputErrors e) {
            raised = true;
        }
        assertTrue("expected InputErrors to be raised", raised);
    }

    @Test
    public void testUpdateInvalidStatus() throws Exception {
        Settings.user = utils.User.defaultProject();

        IndividualAccountRequest request =
            IndividualAccountRequest.create(Collections.singletonList(example())).get(0);

        HashMap<String, Object> patchData = new HashMap<>();
        patchData.put("status", "not-a-real-status");

        boolean raised = false;
        try {
            IndividualAccountRequest.update(request.id, patchData);
        } catch (InputErrors e) {
            raised = true;
        }
        assertTrue("expected InputErrors to be raised", raised);
    }

    @Test
    public void testGetNotFound() throws Exception {
        Settings.user = utils.User.defaultProject();

        boolean raised = false;
        try {
            IndividualAccountRequest.get("0");
        } catch (InputErrors e) {
            raised = true;
        }
        assertTrue("expected InputErrors to be raised", raised);
    }

    static IndividualAccountRequest example() throws Exception {
        return new IndividualAccountRequest(exampleData());
    }

    static HashMap<String, Object> exampleData() throws Exception {
        HashMap<String, Object> address = new HashMap<>();
        address.put("street", "Rua do Estilo Barroco");
        address.put("number", "648");
        address.put("neighborhood", "Santo Amaro");
        address.put("city", "Sao Paulo");
        address.put("state", "SP");
        address.put("zipCode", "05724005");

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Tony Stark " + UUID.randomUUID().toString());
        data.put("taxId", "012.345.678-90");
        data.put("address", address);
        data.put("income", 1000000L);
        data.put("tags", new String[]{"employees", "monthly"});
        return data;
    }
}
