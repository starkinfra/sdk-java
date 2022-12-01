import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.IssuingDesign;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.io.File;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;


public class TestIssuingDesign {

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingDesign> designs = IssuingDesign.query(params);

        for (IssuingDesign design : designs) {
            IssuingDesign designExpected = IssuingDesign.get(design.id);
            Assert.assertNotNull(design.id, designExpected.id);
            System.out.println(design);
        }
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingDesign.Page page = IssuingDesign.page(params);
            for (IssuingDesign design: page.designs) {
                System.out.println(design);
                if (ids.contains(design.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(design.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }

        if (ids.size() != 2) {
            throw new Exception("ids.size() != 4");
        }
    }

    @Test
    public void testIssuingDesignPdfGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        Generator<IssuingDesign> designs = IssuingDesign.query(params);
        for (IssuingDesign design : designs) {
            String designId = design.id;
            InputStream pdf = IssuingDesign.pdf(designId);
            Assert.assertNotNull(pdf);
            java.nio.file.Files.copy(
                pdf,
                new File("design.pdf").toPath(),
                StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println(design);
        }
    }

}
