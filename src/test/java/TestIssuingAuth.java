import com.google.gson.JsonObject;
import com.starkinfra.IssuingAuthorization;
import com.starkinfra.Settings;
import com.starkinfra.utils.EndToEndId;
import org.junit.Test;
import sun.nio.cs.UTF_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestIssuingAuth {
    @Test
    public void testResponse() throws Exception {
        Settings.user = utils.User.defaultProject();
        String payload = IssuingAuthorization.response("test", "teste", new String[]{"lannister", "debts"});
        System.out.println(payload);
    }

    @Test
    public void testAuth() throws Exception {
        Settings.user = utils.User.defaultProject();
        String content = "{\"acquirerId\": \"236090\", \"amount\": 100, \"cardId\": \"5671893688385536\", \"cardTags\": [], \"endToEndId\": \"2fa7ef9f-b889-4bae-ac02-16749c04a3b6\", \"holderId\": \"5917814565109760\", \"holderTags\": [], \"isPartialAllowed\": false, \"issuerAmount\": 100, \"issuerCurrencyCode\": \"BRL\", \"merchantAmount\": 100, \"merchantCategoryCode\": \"bookStores\", \"merchantCountryCode\": \"BRA\", \"merchantCurrencyCode\": \"BRL\", \"merchantFee\": 0, \"merchantId\": \"204933612653639\", \"merchantName\": \"COMPANY 123\", \"methodCode\": \"token\", \"purpose\": \"purchase\", \"score\": null, \"tax\": 0, \"walletId\": \"\"}";
        String valid_signature = "MEUCIBxymWEpit50lDqFKFHYOgyyqvE5kiHERi0ZM6cJpcvmAiEA2wwIkxcsuexh9BjcyAbZxprpRUyjcZJ2vBAjdd7o28Q=";
        String invalid_signature = "MEUCIQDOpo1j+V40DNZK2URL2786UQK/8mDXon9ayEd8U0/l7AIgYXtIZJBTs8zCRR3vmted6Ehz/qfw1GRut/eYyvf1yOk=";

        IssuingAuthorization authorization = IssuingAuthorization.parse(content, valid_signature);

        System.out.println(authorization.amount);

    }
}