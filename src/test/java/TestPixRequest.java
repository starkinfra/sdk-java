import org.junit.Test;

import com.starkinfra.Settings;
import com.starkinfra.PixRequest;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.EndToEndId;
import com.starkcore.error.InvalidSignatureError;

import java.util.List;
import java.util.UUID;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class TestPixRequest {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<PixRequest> requests = new ArrayList<>();
        requests.add(example());
        requests = PixRequest.create(requests);

        for (PixRequest request : requests) {
            assertNotNull(request.id);
            String id = PixRequest.get(request.id).id;
            assertEquals(id, request.id);
        }
    }

    @Test
    public void testQueryGet() throws Exception {
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
            assertNotNull(request.id);
        }
        assertTrue(i > 0);
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
            assertNotNull(log.id);
            assertNotNull(log.request.id);
        }
        assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixRequest> requests = PixRequest.query(params);

        int i = 0;
        ArrayList<String> requestsIdsExpected = new ArrayList<>();
        for (PixRequest request : requests) {
            i += 1;
            assertNotNull(request.id);
            requestsIdsExpected.add(request.id);
        }

        params.put("ids", requestsIdsExpected.toArray(new String[0]));
        Generator<PixRequest> requestsResult = PixRequest.query(params);

        int n = 0;
        ArrayList<String> requestsIdsResult = new ArrayList<>();
        for (PixRequest request : requestsResult){
            n += 1;
            assertNotNull(request.id);
            requestsIdsResult.add(request.id);
        }

        Collections.sort(requestsIdsExpected);
        Collections.sort(requestsIdsResult);
        assertTrue(i > 0);
        assertTrue(n > 0);
        assertEquals(requestsIdsExpected, requestsIdsResult);
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
    public void testResponse() throws Exception {
        Settings.user = utils.User.defaultProject();

        String status = "denied";
        String reason = "invalidAccountNumber";

        HashMap<String, Object> datas = new HashMap<>();
        datas.put("status", status);
        datas.put("reason", reason);

        HashMap<String, Object> data = new HashMap<>();
        data.put("authorization", datas);

        String response = PixRequest.response(data);

        JsonObject json = JsonParser.parseString(response).getAsJsonObject();
        String statusValue = json.getAsJsonObject("authorization").get("status").getAsString();
        String statusReason = json.getAsJsonObject("authorization").get("reason").getAsString();
        assertNotNull(response);
        assertEquals(status, statusValue);
        assertEquals(reason, statusReason);
    }

    @Test
    public void testPixRequestParse() throws Exception{
        String content = "{\"receiverBranchCode\": \"0001\", \"cashierBankCode\": \"\", \"senderTaxId\": \"20.018.183/0001-80\", \"senderName\": \"Stark Bank S.A. - Instituicao de Pagamento\", \"id\": \"4508348862955520\", \"senderAccountType\": \"payment\", \"fee\": 0, \"receiverName\": \"Cora\", \"cashierType\": \"\", \"externalId\": \"\", \"method\": \"manual\", \"status\": \"processing\", \"updated\": \"2022-02-16T17:23:53.980250+00:00\", \"description\": \"\", \"tags\": [], \"receiverKeyId\": \"\", \"cashAmount\": 0, \"senderBankCode\": \"20018183\", \"senderBranchCode\": \"0001\", \"bankCode\": \"34052649\", \"senderAccountNumber\": \"5647143184367616\", \"receiverAccountNumber\": \"5692908409716736\", \"initiatorTaxId\": \"\", \"receiverTaxId\": \"34.052.649/0001-78\", \"created\": \"2022-02-16T17:23:53.980238+00:00\", \"flow\": \"in\", \"endToEndId\": \"E20018183202202161723Y4cqxlfLFcm\", \"amount\": 1, \"receiverAccountType\": \"checking\", \"reconciliationId\": \"\", \"receiverBankCode\": \"34052649\"}";
        String validSignature = "MEUCIQC7FVhXdripx/aXg5yNLxmNoZlehpyvX3QYDXJ8o02X2QIgVwKfJKuIS5RDq50NC/+55h/7VccDkV1vm8Q/7jNu0VM=";
        Settings.user = utils.User.defaultProject();

        PixRequest request = PixRequest.parse(content, validSignature);
    }

    @Test
    public void testPixRequestParseWithUser() throws Exception{
        String content = "{\"receiverBranchCode\": \"0001\", \"cashierBankCode\": \"\", \"senderTaxId\": \"20.018.183/0001-80\", \"senderName\": \"Stark Bank S.A. - Instituicao de Pagamento\", \"id\": \"4508348862955520\", \"senderAccountType\": \"payment\", \"fee\": 0, \"receiverName\": \"Cora\", \"cashierType\": \"\", \"externalId\": \"\", \"method\": \"manual\", \"status\": \"processing\", \"updated\": \"2022-02-16T17:23:53.980250+00:00\", \"description\": \"\", \"tags\": [], \"receiverKeyId\": \"\", \"cashAmount\": 0, \"senderBankCode\": \"20018183\", \"senderBranchCode\": \"0001\", \"bankCode\": \"34052649\", \"senderAccountNumber\": \"5647143184367616\", \"receiverAccountNumber\": \"5692908409716736\", \"initiatorTaxId\": \"\", \"receiverTaxId\": \"34.052.649/0001-78\", \"created\": \"2022-02-16T17:23:53.980238+00:00\", \"flow\": \"in\", \"endToEndId\": \"E20018183202202161723Y4cqxlfLFcm\", \"amount\": 1, \"receiverAccountType\": \"checking\", \"reconciliationId\": \"\", \"receiverBankCode\": \"34052649\"}";
        String validSignature = "MEUCIQC7FVhXdripx/aXg5yNLxmNoZlehpyvX3QYDXJ8o02X2QIgVwKfJKuIS5RDq50NC/+55h/7VccDkV1vm8Q/7jNu0VM=";

        PixRequest request = PixRequest.parse(content, validSignature, utils.User.defaultProject());
        assertTrue(request instanceof PixRequest);
    }

    @Test
    public void testPixRequestParseInvalidSignature() throws Exception{
        String content = "{\"receiverBranchCode\": \"0001\", \"cashierBankCode\": \"\", \"senderTaxId\": \"20.018.183/0001-80\", \"senderName\": \"Stark Bank S.A. - Instituicao de Pagamento\", \"id\": \"4508348862955520\", \"senderAccountType\": \"payment\", \"fee\": 0, \"receiverName\": \"Cora\", \"cashierType\": \"\", \"externalId\": \"\", \"method\": \"manual\", \"status\": \"processing\", \"updated\": \"2022-02-16T17:23:53.980250+00:00\", \"description\": \"\", \"tags\": [], \"receiverKeyId\": \"\", \"cashAmount\": 0, \"senderBankCode\": \"20018183\", \"senderBranchCode\": \"0001\", \"bankCode\": \"34052649\", \"senderAccountNumber\": \"5647143184367616\", \"receiverAccountNumber\": \"5692908409716736\", \"initiatorTaxId\": \"\", \"receiverTaxId\": \"34.052.649/0001-78\", \"created\": \"2022-02-16T17:23:53.980238+00:00\", \"flow\": \"in\", \"endToEndId\": \"E20018183202202161723Y4cqxlfLFcm\", \"amount\": 1, \"receiverAccountType\": \"checking\", \"reconciliationId\": \"\", \"receiverBankCode\": \"34052649\"}";
        String invalidSignature = "MEUCIQDOpo1j+V40DNZK2URL2786UQK/8mDXon9ayEd8U0/l7AIgYXtIZJBTs8zCRR3vmted6Ehz/qfw1GRut/eYyvf1yOk=";
        Settings.user = utils.User.defaultProject();

        InvalidSignatureError invalidSignatureError = assertThrows(InvalidSignatureError.class, () -> {
            PixRequest.parse(content, invalidSignature);
        });

        assertEquals("The provided signature and content do not match the Stark Infra public key", invalidSignatureError.getMessage());

    }

    @Test
    public void testPixRequestParseMalformedSignature() throws Exception{
        String malformedSignature = "something is definitely wrong";
        String content = "{\"receiverBranchCode\": \"0001\", \"cashierBankCode\": \"\", \"senderTaxId\": \"20.018.183/0001-80\", \"senderName\": \"Stark Bank S.A. - Instituicao de Pagamento\", \"id\": \"4508348862955520\", \"senderAccountType\": \"payment\", \"fee\": 0, \"receiverName\": \"Cora\", \"cashierType\": \"\", \"externalId\": \"\", \"method\": \"manual\", \"status\": \"processing\", \"updated\": \"2022-02-16T17:23:53.980250+00:00\", \"description\": \"\", \"tags\": [], \"receiverKeyId\": \"\", \"cashAmount\": 0, \"senderBankCode\": \"20018183\", \"senderBranchCode\": \"0001\", \"bankCode\": \"34052649\", \"senderAccountNumber\": \"5647143184367616\", \"receiverAccountNumber\": \"5692908409716736\", \"initiatorTaxId\": \"\", \"receiverTaxId\": \"34.052.649/0001-78\", \"created\": \"2022-02-16T17:23:53.980238+00:00\", \"flow\": \"in\", \"endToEndId\": \"E20018183202202161723Y4cqxlfLFcm\", \"amount\": 1, \"receiverAccountType\": \"checking\", \"reconciliationId\": \"\", \"receiverBankCode\": \"34052649\"}";
        Settings.user = utils.User.defaultProject();

        InvalidSignatureError invalidSignatureError = assertThrows(InvalidSignatureError.class, () -> {
            PixRequest.parse(content, malformedSignature);
        });

        assertEquals("The provided signature is not valid", invalidSignatureError.getMessage());
    }

    static PixRequest example() throws Exception{
        String bankCode = utils.User.bankCode();
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", 1000L);
        data.put("externalId", "java-" + UUID.randomUUID().toString());
        data.put("senderAccountNumber", "76543-8");
        data.put("senderBranchCode", "2201");
        data.put("senderAccountType", "checking");
        data.put("senderName", "checking");
        data.put("senderTaxId", "594.739.480-42");
        data.put("receiverBankCode", "20018183");
        data.put("receiverAccountNumber", "00000-0");
        data.put("receiverBranchCode", "0001");
        data.put("receiverAccountType", "checking");
        data.put("receiverName", "Daenerys Targaryen Stormborn");
        data.put("receiverTaxId", "012.345.678-90");
        data.put("priority", "high");
        data.put("endToEndId", EndToEndId.create(bankCode));
        return new PixRequest(data);
    }
}
