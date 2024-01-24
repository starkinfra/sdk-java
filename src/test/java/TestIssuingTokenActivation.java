import org.junit.Test;
import com.starkinfra.Settings;
import com.starkinfra.IssuingTokenActivation;
import com.starkinfra.error.InvalidSignatureError;

public class TestIssuingTokenActivation {
    @Test
    public void testParse() throws Exception{
        String content = "{\"activationMethod\": {\"type\": \"text\", \"value\": \"** *****-5678\"}, \"tokenId\": \"5585821789122165\", \"tags\": [\"token\", \"user/1234\"], \"cardId\": \"5189831499972623\"}";
        String validSignature = "MEUCIAxn0FmsPWI4r3Y7Nq8xFNQHYZgo0QAGDQ4/7CajKoVuAiEA09kXWrPMhsw4JbgC3pmNccCWr+hidfop/KsSNqza0yE=";
        Settings.user = utils.User.defaultProject();

        IssuingTokenActivation request = IssuingTokenActivation.parse(content, validSignature);
        System.out.println(request);
    }

    @Test
    public void testIssuingTokenInvalidSignature() throws Exception{
        String content = "{\"activationMethod\": {\"type\": \"text\", \"value\": \"** *****-5678\"}, \"tokenId\": \"5585821789122165\", \"tags\": [\"token\", \"user/1234\"], \"cardId\": \"5189831499972623\"}";
        String invalidSignature = "MEUCIQDOpo1j+V40DNZK2URL2786UQK/8mDXon9ayEd8U0/l7AIgYXtIZJBTs8zCRR3vmted6Ehz/qfw1GRut/eYyvf1yOk=";
        Settings.user = utils.User.defaultProject();

        try{
            IssuingTokenActivation.parse(content, invalidSignature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }

    @Test
    public void testParseMalformedSignature() throws Exception{
        String content = "{\"activationMethod\": {\"type\": \"text\", \"value\": \"** *****-5678\"}, \"tokenId\": \"5585821789122165\", \"tags\": [\"token\", \"user/1234\"], \"cardId\": \"5189831499972623\"}";
        String malformedSignature = "something is definitely wrong";
        Settings.user = utils.User.defaultProject();

        try{
            IssuingTokenActivation.parse(content, malformedSignature);
            throw new Error("Signature incorrectly validated");
        } catch (InvalidSignatureError e){
            System.out.println("Signature correctly rejected");
        }
    }
}
