import com.starkinfra.utils.Generator;
import com.starkinfra.IssuingBin;
import com.starkinfra.*;
import org.junit.Test;

import java.util.HashMap;


public class TestIssuingBin {
    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        for (int i = 0; i < 2; i++) {
            IssuingBin.Page page = IssuingBin.page(params);
            for (IssuingBin bin: page.issuingBins) {
                System.out.println(bin);
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
        params.put("limit", 10);
        Generator<IssuingBin> bins = IssuingBin.query(params);

        for (IssuingBin bin : bins) {
            System.out.println(bin);
        }

    }

}
