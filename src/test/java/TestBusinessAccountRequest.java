import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.BusinessAccountRequest;
import com.starkinfra.utils.Generator;
import com.starkcore.error.InputErrors;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestBusinessAccountRequest {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<BusinessAccountRequest> requests = BusinessAccountRequest.create(exampleList(1));
        for (BusinessAccountRequest request : requests) {
            Assert.assertNotNull(request.id);
            Assert.assertEquals("business", request.accountType);
            Assert.assertTrue(request.address instanceof BusinessAccountRequest.Address);
            for (BusinessAccountRequest.Owner owner : request.owners) {
                Assert.assertTrue(owner instanceof BusinessAccountRequest.Owner);
            }
        }
    }

    @Test
    public void testCreateFromObjects() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<BusinessAccountRequest> requests = BusinessAccountRequest.create(exampleListWithObjects(1));
        for (BusinessAccountRequest request : requests) {
            Assert.assertNotNull(request.id);
            Assert.assertEquals("business", request.accountType);
            Assert.assertTrue(request.address instanceof BusinessAccountRequest.Address);
            for (BusinessAccountRequest.Owner owner : request.owners) {
                Assert.assertTrue(owner instanceof BusinessAccountRequest.Owner);
            }
        }
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<BusinessAccountRequest> requests = BusinessAccountRequest.query(params);

        int i = 0;
        for (BusinessAccountRequest request : requests) {
            i += 1;
            request = BusinessAccountRequest.get(request.id);
            Assert.assertNotNull(request.id);
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testQueryWithParams() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        params.put("after", "2020-04-01");
        params.put("before", "2030-04-30");
        params.put("status", "created");
        params.put("tags", new String[]{"employees", "monthly"});
        params.put("ids", new String[]{"1", "2", "3"});
        Generator<BusinessAccountRequest> requests = BusinessAccountRequest.query(params);

        int i = 0;
        for (BusinessAccountRequest request : requests) {
            i += 1;
        }
        Assert.assertEquals(0, i);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        BusinessAccountRequest.create(exampleList(3));

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            BusinessAccountRequest.Page page = BusinessAccountRequest.page(params);
            for (BusinessAccountRequest request : page.requests) {
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

        if (ids.size() == 0) {
            throw new Exception("ids.size() == 0");
        }
    }

    @Test
    public void testStatusEnum() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<BusinessAccountRequest> requests = BusinessAccountRequest.query(params);

        List<String> allowed = Arrays.asList("created", "processing", "approved", "denied", "failed");
        for (BusinessAccountRequest request : requests) {
            if (request.status != null) {
                Assert.assertTrue(allowed.contains(request.status));
            }
        }
    }

    @Test
    public void testOwnersAndAddressFromMapsAreParsed() throws Exception {
        BusinessAccountRequest request = new BusinessAccountRequest(exampleAsMap());

        Assert.assertTrue(request.address instanceof BusinessAccountRequest.Address);
        Assert.assertEquals("04538-132", request.address.zipCode);
        Assert.assertEquals(2, request.owners.size());
        for (BusinessAccountRequest.Owner owner : request.owners) {
            Assert.assertTrue(owner instanceof BusinessAccountRequest.Owner);
            Assert.assertNull(owner.validatorLink);
        }
    }

    @Test
    public void testGetUnknownId() throws Exception {
        Settings.user = utils.User.defaultProject();

        try {
            BusinessAccountRequest.get("0");
            Assert.fail("Expected InputErrors was not thrown");
        } catch (InputErrors e) {
            Assert.assertNotNull(e.errors);
        }
    }

    static List<BusinessAccountRequest> exampleList(int n) throws Exception {
        List<BusinessAccountRequest> requests = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            requests.add(new BusinessAccountRequest(exampleAsMap()));
        }
        return requests;
    }

    static List<BusinessAccountRequest> exampleListWithObjects(int n) throws Exception {
        BusinessAccountRequest.Address address = new BusinessAccountRequest.Address(
            "Av. Faria Lima", "2000", "Itaim Bibi", "Sao Paulo", "SP", "04538-132", "Sala 42");
        List<BusinessAccountRequest.Owner> owners = Arrays.asList(
            new BusinessAccountRequest.Owner("012.345.678-90", "Jamie Lannister", "partner", null, null, null),
            new BusinessAccountRequest.Owner("812.531.960-36", "Cersei Lannister", "representative", null, null, null));
        List<BusinessAccountRequest> requests = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            requests.add(new BusinessAccountRequest(address, 100000000L, "Stark Bank S.A.",
                "20.018.183/0001-80", owners, new String[]{"employees", "monthly"},
                null, null, null, null, null, null));
        }
        return requests;
    }

    static HashMap<String, Object> exampleAsMap() {
        HashMap<String, Object> address = new HashMap<>();
        address.put("street", "Av. Faria Lima");
        address.put("number", "2000");
        address.put("neighborhood", "Itaim Bibi");
        address.put("city", "Sao Paulo");
        address.put("state", "SP");
        address.put("zipCode", "04538-132");
        address.put("complement", "Sala 42");

        HashMap<String, Object> partner = new HashMap<>();
        partner.put("taxId", "012.345.678-90");
        partner.put("name", "Jamie Lannister");
        partner.put("role", "partner");

        HashMap<String, Object> representative = new HashMap<>();
        representative.put("taxId", "812.531.960-36");
        representative.put("name", "Cersei Lannister");
        representative.put("role", "representative");

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Stark Bank S.A.");
        data.put("taxId", "20.018.183/0001-80");
        data.put("address", address);
        data.put("revenue", 100000000);
        data.put("owners", new ArrayList<>(Arrays.asList(partner, representative)));
        data.put("tags", new String[]{"employees", "monthly"});
        return data;
    }
}
