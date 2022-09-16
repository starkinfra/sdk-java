import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.IssuingProduct;
import com.starkinfra.utils.Generator;

import java.util.HashMap;


public class TestIssuingProduct {
    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        for (int i = 0; i < 2; i++) {
            IssuingProduct.Page page = IssuingProduct.page(params);
            Assert.assertNotNull(page);
            Assert.assertEquals(2, page.products.size());
            for (IssuingProduct product: page.products) {
                Assert.assertNotNull(product.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);

        Generator<IssuingProduct> products = IssuingProduct.query(params);
        Assert.assertNotNull(products);

        int i = 0;
        for (IssuingProduct product : products) {
            Assert.assertNotNull(product.id);
            ++i;
        }
        Assert.assertEquals(2, i);

    }

}
