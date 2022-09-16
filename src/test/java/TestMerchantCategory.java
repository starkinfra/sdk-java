import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;
import com.starkinfra.MerchantCategory;

import java.util.HashMap;

public class TestMerchantCategory {

    @Test
    public void testMerchantCategoryQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("search", "food");
        Generator<MerchantCategory> categories = MerchantCategory.query(params);
        Assert.assertNotNull(categories);

        for (MerchantCategory category : categories) {
            Assert.assertNotNull(category.name);
        }
    }
}
