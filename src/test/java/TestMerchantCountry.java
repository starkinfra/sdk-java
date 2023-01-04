import com.starkcore.utils.Generator;
import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.MerchantCountry;

import java.util.HashMap;


public class TestMerchantCountry {

    @Test
    public void testMerchantCountryQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("search", "brazil");
        Generator<MerchantCountry> countries = MerchantCountry.query(params);
        Assert.assertNotNull(countries);

        for (MerchantCountry country : countries) {
            Assert.assertNotNull(country.name);
        }
    }
}
