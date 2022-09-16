import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.CardMethod;
import com.starkinfra.utils.Generator;

import java.util.HashMap;


public class TestCardMethod {

    @Test
    public void testCardMethodQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("search", "token");
        Generator<CardMethod> methods = CardMethod.query(params);
        Assert.assertNotNull(methods);

        for (CardMethod method : methods) {
            Assert.assertNotNull(method.name);
        }
    }
}
