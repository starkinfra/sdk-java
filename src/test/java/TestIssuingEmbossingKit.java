import com.starkinfra.IssuingEmbossingKit;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TestIssuingEmbossingKit {

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingEmbossingKit> kits = IssuingEmbossingKit.query(params);

        for (IssuingEmbossingKit kit : kits) {
            IssuingEmbossingKit kitExpected = IssuingEmbossingKit.get(kit.id);
            Assert.assertNotNull(kit.id, kitExpected.id);
            System.out.println(kit);
        }
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            IssuingEmbossingKit.Page page = IssuingEmbossingKit.page(params);
            for (IssuingEmbossingKit kit: page.kits) {
                System.out.println(kit);
                if (ids.contains(kit.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(kit.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }

        if (ids.size() != 1) {
            throw new Exception("ids.size() != 1");
        }
    }

}
