import com.starkinfra.*;
import com.starkinfra.IssuingBin;
import com.starkinfra.utils.Generator;
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
            for (IssuingBin request: page.issuingBins) {
                System.out.println(request);
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
        Generator<IssuingBin> requests = IssuingBin.query(params);

        for (IssuingBin request : requests) {
            System.out.println(request);
        }

    }

}
