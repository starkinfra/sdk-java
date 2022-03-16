import com.starkinfra.PixRequest;
import com.starkinfra.Settings;
import com.starkinfra.error.InvalidSignatureError;
import com.starkinfra.utils.EndToEndId;
import com.starkinfra.utils.Generator;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class TestPixRequest {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();
        List<PixRequest> requests = new ArrayList<>();
        requests.add(example());
        requests = PixRequest.create(requests);

        for (PixRequest request : requests) {
            Assert.assertNotNull(request.id);
            String id = PixRequest.get(request.id).id;
            Assert.assertEquals(id, request.id);
        }
    }

    @Test
    public void testQueryGetAndPdf() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "success");
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixRequest> requests = PixRequest.query(params);

        int i = 0;
        for (PixRequest request : requests) {
            i += 1;
            request = PixRequest.get(request.id);
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
        Generator<PixRequest.Log> logs = PixRequest.Log.query(params);

        int i = 0;
        for (PixRequest.Log log : logs) {
            i += 1;
            log = PixRequest.Log.get(log.id);
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
        Generator<PixRequest> requests = PixRequest.query(params);

        ArrayList<String> requestsIdsExpected = new ArrayList<>();
        for (PixRequest request : requests) {
            Assert.assertNotNull(request.id);
            requestsIdsExpected.add(request.id);
        }

        params.put("ids", requestsIdsExpected.toArray(new String[0]));
        Generator<PixRequest> requestsResult = PixRequest.query(params);

        ArrayList<String> requestsIdsResult = new ArrayList<>();
        for (PixRequest request : requestsResult){
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
            PixRequest.Page page = PixRequest.page(params);
            for (PixRequest request: page.requests) {
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
            PixRequest.Log.Page page = PixRequest.Log.page(params);
            for (PixRequest.Log log: page.logs) {
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
    public void testPixRequestParse() throws Exception{
        String content = "{\"receiverBranchCode\": \"0001\", \"cashierBankCode\": \"\", \"senderTaxId\": \"20.018.183/0001-80\", \"senderName\": \"Stark Bank S.A. - Instituicao de Pagamento\", \"id\": \"4508348862955520\", \"senderAccountType\": \"payment\", \"fee\": 0, \"receiverName\": \"Cora\", \"cashierType\": \"\", \"externalId\": \"\", \"method\": \"manual\", \"status\": \"processing\", \"updated\": \"2022-02-16T17:23:53.980250+00:00\", \"description\": \"\", \"tags\": [], \"receiverKeyId\": \"\", \"cashAmount\": 0, \"senderBankCode\": \"20018183\", \"senderBranchCode\": \"0001\", \"bankCode\": \"34052649\", \"senderAccountNumber\": \"5647143184367616\", \"receiverAccountNumber\": \"5692908409716736\", \"initiatorTaxId\": \"\", \"receiverTaxId\": \"34.052.649/0001-78\", \"created\": \"2022-02-16T17:23:53.980238+00:00\", \"flow\": \"in\", \"endToEndId\": \"E20018183202202161723Y4cqxlfLFcm\", \"amount\": 1, \"receiverAccountType\": \"checking\", \"reconciliationId\": \"\", \"receiverBankCode\": \"34052649\"}";
        String valid_signature = "MEUCIQC7FVhXdripx/aXg5yNLxmNoZlehpyvX3QYDXJ8o02X2QIgVwKfJKuIS5RDq50NC/+55h/7VccDkV1vm8Q/7jNu0VM=";

        Settings.user = utils.User.defaultProject();
        PixRequest request = PixRequest.parse(content, valid_signature);
        System.out.println(request);
    }

    @Test
    public void testPixRequestParseInvalidSignature() throws Exception{
        String content = "{\"receiverBranchCode\": \"0001\", \"cashierBankCode\": \"\", \"senderTaxId\": \"20.018.183/0001-80\", \"senderName\": \"Stark Bank S.A. - Instituicao de Pagamento\", \"id\": \"4508348862955520\", \"senderAccountType\": \"payment\", \"fee\": 0, \"receiverName\": \"Cora\", \"cashierType\": \"\", \"externalId\": \"\", \"method\": \"manual\", \"status\": \"processing\", \"updated\": \"2022-02-16T17:23:53.980250+00:00\", \"description\": \"\", \"tags\": [], \"receiverKeyId\": \"\", \"cashAmount\": 0, \"senderBankCode\": \"20018183\", \"senderBranchCode\": \"0001\", \"bankCode\": \"34052649\", \"senderAccountNumber\": \"5647143184367616\", \"receiverAccountNumber\": \"5692908409716736\", \"initiatorTaxId\": \"\", \"receiverTaxId\": \"34.052.649/0001-78\", \"created\": \"2022-02-16T17:23:53.980238+00:00\", \"flow\": \"in\", \"endToEndId\": \"E20018183202202161723Y4cqxlfLFcm\", \"amount\": 1, \"receiverAccountType\": \"checking\", \"reconciliationId\": \"\", \"receiverBankCode\": \"34052649\"}";
        String invalid_signature = "MEUCIQDOpo1j+V40DNZK2URL2786UQK/8mDXon9ayEd8U0/l7AIgYXtIZJBTs8zCRR3vmted6Ehz/qfw1GRut/eYyvf1yOk=";

        Settings.user = utils.User.defaultProject();
        try{
            PixRequest.parse(content, invalid_signature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }

    @Test
    public void testPixRequestParseMalformedSignature() throws Exception{
        String malformed_signature = "something is definitely wrong";
        String content = "{\"receiverBranchCode\": \"0001\", \"cashierBankCode\": \"\", \"senderTaxId\": \"20.018.183/0001-80\", \"senderName\": \"Stark Bank S.A. - Instituicao de Pagamento\", \"id\": \"4508348862955520\", \"senderAccountType\": \"payment\", \"fee\": 0, \"receiverName\": \"Cora\", \"cashierType\": \"\", \"externalId\": \"\", \"method\": \"manual\", \"status\": \"processing\", \"updated\": \"2022-02-16T17:23:53.980250+00:00\", \"description\": \"\", \"tags\": [], \"receiverKeyId\": \"\", \"cashAmount\": 0, \"senderBankCode\": \"20018183\", \"senderBranchCode\": \"0001\", \"bankCode\": \"34052649\", \"senderAccountNumber\": \"5647143184367616\", \"receiverAccountNumber\": \"5692908409716736\", \"initiatorTaxId\": \"\", \"receiverTaxId\": \"34.052.649/0001-78\", \"created\": \"2022-02-16T17:23:53.980238+00:00\", \"flow\": \"in\", \"endToEndId\": \"E20018183202202161723Y4cqxlfLFcm\", \"amount\": 1, \"receiverAccountType\": \"checking\", \"reconciliationId\": \"\", \"receiverBankCode\": \"34052649\"}";

        Settings.user = utils.User.defaultProject();
        try{
            PixRequest.parse(content, malformed_signature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }

    static PixRequest example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", 1000);
        data.put("externalId", "java-" + UUID.randomUUID().toString());
        data.put("senderAccountNumber", "76543-8");
        data.put("senderBranchCode", "2201");
        data.put("senderAccountType", "checking");
        data.put("senderName", "checking");
        data.put("senderTaxId", "594.739.480-42");
        data.put("receiverBankCode", "341");
        data.put("receiverAccountNumber", "00000-0");
        data.put("receiverBranchCode", "0001");
        data.put("receiverAccountType", "checking");
        data.put("receiverName", "Daenerys Targaryen Stormborn");
        data.put("receiverTaxId", "012.345.678-90");
        data.put("endToEndId", EndToEndId.create(System.getenv("SANDBOX_ISPB")));

        return new PixRequest(data);
    }
}
