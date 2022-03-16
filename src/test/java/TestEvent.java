import com.starkinfra.*;
import com.starkinfra.error.InvalidSignatureError;
import org.junit.Test;


public class TestEvent {

    @Test
    public void testEventParse() throws Exception{
        String content = "{\"event\": {\"created\": \"2022-02-15T20:45:09.852878+00:00\", \"id\": \"5015597159022592\", \"log\": {\"created\": \"2022-02-15T20:45:09.436621+00:00\", \"errors\": [{\"code\": \"insufficientFunds\", \"message\": \"Amount of funds available is not sufficient to cover the specified transfer\"}], \"id\": \"5288053467774976\", \"request\": {\"amount\": 1000, \"bankCode\": \"34052649\", \"cashAmount\": 0, \"cashierBankCode\": \"\", \"cashierType\": \"\", \"created\": \"2022-02-15T20:45:08.210009+00:00\", \"description\": \"For saving my life\", \"endToEndId\": \"E34052649202201272111u34srod1a91\", \"externalId\": \"141322efdgber1ecd1s342341321\", \"fee\": 0, \"flow\": \"out\", \"id\": \"5137269514043392\", \"initiatorTaxId\": \"\", \"method\": \"manual\", \"receiverAccountNumber\": \"000001\", \"receiverAccountType\": \"checking\", \"receiverBankCode\": \"00000001\", \"receiverBranchCode\": \"0001\", \"receiverKeyId\": \"\", \"receiverName\": \"Jamie Lennister\", \"receiverTaxId\": \"45.987.245/0001-92\", \"reconciliationId\": \"\", \"senderAccountNumber\": \"000000\", \"senderAccountType\": \"checking\", \"senderBankCode\": \"34052649\", \"senderBranchCode\": \"0000\", \"senderName\": \"tyrion Lennister\", \"senderTaxId\": \"012.345.678-90\", \"status\": \"failed\", \"tags\": [], \"updated\": \"2022-02-15T20:45:09.436661+00:00\"}, \"type\": \"failed\"}, \"subscription\": \"pix-request.out\", \"workspaceId\": \"5692908409716736\"}}";
        String valid_signature = "MEYCIQD0oFxFQX0fI6B7oqjwLhkRhkDjrOiD86wguEKWdzkJbgIhAPNGUUdlNpYBe+npOaHa9WJopzy3WJYl8XJG6f4ek2R/";

        Settings.user = utils.User.defaultProject();
        Event event = Event.parse(content, valid_signature);
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
        String invalid_signature = "MEUCIQDOpo1j+V40DNZK2URL2786UQK/8mDXon9ayEd8U0/l7AIgYXtIZJBTs8zCRR3vmted6Ehz/qfw1GRut/eYyvf1yOk=";

        Settings.user = utils.User.defaultProject();
        try{
            Event.parse(content, invalid_signature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }

    @Test
    public void testEventParseMalformedSignature() throws Exception{
        String content = "{\"event\": {\"created\": \"2022-02-15T20:45:09.852878+00:00\", \"id\": \"5015597159022592\", \"log\": {\"created\": \"2022-02-15T20:45:09.436621+00:00\", \"errors\": [{\"code\": \"insufficientFunds\", \"message\": \"Amount of funds available is not sufficient to cover the specified transfer\"}], \"id\": \"5288053467774976\", \"request\": {\"amount\": 1000, \"bankCode\": \"34052649\", \"cashAmount\": 0, \"cashierBankCode\": \"\", \"cashierType\": \"\", \"created\": \"2022-02-15T20:45:08.210009+00:00\", \"description\": \"For saving my life\", \"endToEndId\": \"E34052649202201272111u34srod1a91\", \"externalId\": \"141322efdgber1ecd1s342341321\", \"fee\": 0, \"flow\": \"out\", \"id\": \"5137269514043392\", \"initiatorTaxId\": \"\", \"method\": \"manual\", \"receiverAccountNumber\": \"000001\", \"receiverAccountType\": \"checking\", \"receiverBankCode\": \"00000001\", \"receiverBranchCode\": \"0001\", \"receiverKeyId\": \"\", \"receiverName\": \"Jamie Lennister\", \"receiverTaxId\": \"45.987.245/0001-92\", \"reconciliationId\": \"\", \"senderAccountNumber\": \"000000\", \"senderAccountType\": \"checking\", \"senderBankCode\": \"34052649\", \"senderBranchCode\": \"0000\", \"senderName\": \"tyrion Lennister\", \"senderTaxId\": \"012.345.678-90\", \"status\": \"failed\", \"tags\": [], \"updated\": \"2022-02-15T20:45:09.436661+00:00\"}, \"type\": \"failed\"}, \"subscription\": \"pix-request.out\", \"workspaceId\": \"5692908409716736\"}}";
        String malformed_signature = "something is definitely wrong";

        Settings.user = utils.User.defaultProject();
        try{
            Event.parse(content, malformed_signature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }
}
