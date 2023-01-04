import com.starkcore.utils.Generator;
import org.junit.Test;
import org.junit.Assert;
import org.junit.AssumptionViolatedException;

import com.starkinfra.Event;
import com.starkinfra.Settings;
import com.starkinfra.PixRequest;
import com.starkinfra.PixReversal;
import com.starkinfra.error.InvalidSignatureError;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.List;


public class TestEvent {

    private void assertFalseForInconclusive(boolean condition) {
        if(!condition)
            throw new AssumptionViolatedException("Inconclusive");
    }

    @Test
    public void testEventQuery() throws Exception{
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 5);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<Event> events = Event.query(params);

        int i = 0;
        for (Event event : events) {
            i += 1;
            Assert.assertNotNull(event.id);
            Assert.assertNotNull(event.workspaceId);
            System.out.println(event);

            HashMap<String, Object> attemptParams = new HashMap<>();
            attemptParams.put("limit", 1);
            attemptParams.put("eventIds", event.id);
            Generator<Event.Attempt> attempts = Event.Attempt.query(attemptParams);
            for (Event.Attempt attempt : attempts) {
                Event.Attempt a = Event.Attempt.get(attempt.id);
                Assert.assertNotNull(a);
                System.out.println(a);
            }
        }
        assertFalseForInconclusive(i > 0);
    }

    @Test
    public void testEventQueryGetAndUpdate() throws Exception{
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 100);
        params.put("isDelivered", false);
        Generator<Event> events = Event.query(params);
        HashMap<String, Object> data = new HashMap<>();
        data.put("isDelivered", true);

        int index = new Random().nextInt(100);
        int i = 0;
        for (Event event : events) {
            i ++;
            if (i != index) {
                continue;
            }
            System.out.println(event);
            Assert.assertFalse(event.isDelivered);
            event = Event.get(event.id);
            event = Event.update(event.id, data);
            Assert.assertTrue(event.isDelivered);
        }
        assertFalseForInconclusive(i > 0);
    }

    @Test
    public void testEventQueryAndDelete() throws Exception{
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 100);
        int i = 0;
        int index = new Random().nextInt(100);
        for (Event event : Event.query(params)) {
            i ++;
            if (i != index) {
                continue;
            }
            event = Event.delete(event.id);
            System.out.println(event);
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
            Event.Page page = Event.page(params);
            for (Event event: page.events) {
                System.out.println(event);
                if (ids.contains(event.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(event.id);
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
    public void testEventParse() throws Exception{
        String content = "{\"event\": {\"created\": \"2022-02-15T20:45:09.852878+00:00\", \"id\": \"5015597159022592\", \"log\": {\"created\": \"2022-02-15T20:45:09.436621+00:00\", \"errors\": [{\"code\": \"insufficientFunds\", \"message\": \"Amount of funds available is not sufficient to cover the specified transfer\"}], \"id\": \"5288053467774976\", \"request\": {\"amount\": 1000, \"bankCode\": \"34052649\", \"cashAmount\": 0, \"cashierBankCode\": \"\", \"cashierType\": \"\", \"created\": \"2022-02-15T20:45:08.210009+00:00\", \"description\": \"For saving my life\", \"endToEndId\": \"E34052649202201272111u34srod1a91\", \"externalId\": \"141322efdgber1ecd1s342341321\", \"fee\": 0, \"flow\": \"out\", \"id\": \"5137269514043392\", \"initiatorTaxId\": \"\", \"method\": \"manual\", \"receiverAccountNumber\": \"000001\", \"receiverAccountType\": \"checking\", \"receiverBankCode\": \"00000001\", \"receiverBranchCode\": \"0001\", \"receiverKeyId\": \"\", \"receiverName\": \"Jamie Lennister\", \"receiverTaxId\": \"45.987.245/0001-92\", \"reconciliationId\": \"\", \"senderAccountNumber\": \"000000\", \"senderAccountType\": \"checking\", \"senderBankCode\": \"34052649\", \"senderBranchCode\": \"0000\", \"senderName\": \"tyrion Lennister\", \"senderTaxId\": \"012.345.678-90\", \"status\": \"failed\", \"tags\": [], \"updated\": \"2022-02-15T20:45:09.436661+00:00\"}, \"type\": \"failed\"}, \"subscription\": \"pix-request.out\", \"workspaceId\": \"5692908409716736\"}}";
        String validSignature = "MEYCIQD0oFxFQX0fI6B7oqjwLhkRhkDjrOiD86wguEKWdzkJbgIhAPNGUUdlNpYBe+npOaHa9WJopzy3WJYl8XJG6f4ek2R/";

        Settings.user = utils.User.defaultProject();
        Event event = Event.parse(content, validSignature);
        System.out.println(event);

        if (event.subscription.contains("pix-request")) {
            PixRequest.Log log = ((Event.PixRequestEvent) event).log;
            System.out.println(log.request);
        }
        else if (event.subscription.contains("pix-reversal")) {
            PixReversal.Log log = ((Event.PixReversalEvent) event).log;
            System.out.println(log.reversal);
        }
    }

    @Test
    public void testEventParseInvalidSignature() throws Exception{
        String content = "{\"event\": {\"created\": \"2022-02-15T20:45:09.852878+00:00\", \"id\": \"5015597159022592\", \"log\": {\"created\": \"2022-02-15T20:45:09.436621+00:00\", \"errors\": [{\"code\": \"insufficientFunds\", \"message\": \"Amount of funds available is not sufficient to cover the specified transfer\"}], \"id\": \"5288053467774976\", \"request\": {\"amount\": 1000, \"bankCode\": \"34052649\", \"cashAmount\": 0, \"cashierBankCode\": \"\", \"cashierType\": \"\", \"created\": \"2022-02-15T20:45:08.210009+00:00\", \"description\": \"For saving my life\", \"endToEndId\": \"E34052649202201272111u34srod1a91\", \"externalId\": \"141322efdgber1ecd1s342341321\", \"fee\": 0, \"flow\": \"out\", \"id\": \"5137269514043392\", \"initiatorTaxId\": \"\", \"method\": \"manual\", \"receiverAccountNumber\": \"000001\", \"receiverAccountType\": \"checking\", \"receiverBankCode\": \"00000001\", \"receiverBranchCode\": \"0001\", \"receiverKeyId\": \"\", \"receiverName\": \"Jamie Lennister\", \"receiverTaxId\": \"45.987.245/0001-92\", \"reconciliationId\": \"\", \"senderAccountNumber\": \"000000\", \"senderAccountType\": \"checking\", \"senderBankCode\": \"34052649\", \"senderBranchCode\": \"0000\", \"senderName\": \"tyrion Lennister\", \"senderTaxId\": \"012.345.678-90\", \"status\": \"failed\", \"tags\": [], \"updated\": \"2022-02-15T20:45:09.436661+00:00\"}, \"type\": \"failed\"}, \"subscription\": \"pix-request.out\", \"workspaceId\": \"5692908409716736\"}}";
        String invalidSignature = "MEUCIQDOpo1j+V40DNZK2URL2786UQK/8mDXon9ayEd8U0/l7AIgYXtIZJBTs8zCRR3vmted6Ehz/qfw1GRut/eYyvf1yOk=";

        Settings.user = utils.User.defaultProject();
        try{
            Event.parse(content, invalidSignature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }

    @Test
    public void testEventParseMalformedSignature() throws Exception{
        String content = "{\"event\": {\"created\": \"2022-02-15T20:45:09.852878+00:00\", \"id\": \"5015597159022592\", \"log\": {\"created\": \"2022-02-15T20:45:09.436621+00:00\", \"errors\": [{\"code\": \"insufficientFunds\", \"message\": \"Amount of funds available is not sufficient to cover the specified transfer\"}], \"id\": \"5288053467774976\", \"request\": {\"amount\": 1000, \"bankCode\": \"34052649\", \"cashAmount\": 0, \"cashierBankCode\": \"\", \"cashierType\": \"\", \"created\": \"2022-02-15T20:45:08.210009+00:00\", \"description\": \"For saving my life\", \"endToEndId\": \"E34052649202201272111u34srod1a91\", \"externalId\": \"141322efdgber1ecd1s342341321\", \"fee\": 0, \"flow\": \"out\", \"id\": \"5137269514043392\", \"initiatorTaxId\": \"\", \"method\": \"manual\", \"receiverAccountNumber\": \"000001\", \"receiverAccountType\": \"checking\", \"receiverBankCode\": \"00000001\", \"receiverBranchCode\": \"0001\", \"receiverKeyId\": \"\", \"receiverName\": \"Jamie Lennister\", \"receiverTaxId\": \"45.987.245/0001-92\", \"reconciliationId\": \"\", \"senderAccountNumber\": \"000000\", \"senderAccountType\": \"checking\", \"senderBankCode\": \"34052649\", \"senderBranchCode\": \"0000\", \"senderName\": \"tyrion Lennister\", \"senderTaxId\": \"012.345.678-90\", \"status\": \"failed\", \"tags\": [], \"updated\": \"2022-02-15T20:45:09.436661+00:00\"}, \"type\": \"failed\"}, \"subscription\": \"pix-request.out\", \"workspaceId\": \"5692908409716736\"}}";
        String malformedSignature = "something is definitely wrong";

        Settings.user = utils.User.defaultProject();
        try{
            Event.parse(content, malformedSignature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }
}
