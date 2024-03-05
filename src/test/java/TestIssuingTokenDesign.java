import org.junit.Test;
import org.junit.Assert;
import com.starkinfra.Settings;
import com.starkinfra.IssuingTokenDesign;
import com.starkinfra.utils.Generator;

import java.io.File;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;

public class TestIssuingTokenDesign {
    @Test
    public void testQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingTokenDesign> tokenDesigns = IssuingTokenDesign.query(params);

        int i = 0;
        for (IssuingTokenDesign tokenDesign : tokenDesigns) {
            i += 1;
            tokenDesign = IssuingTokenDesign.get(tokenDesign.id);
            Assert.assertNotNull(tokenDesign.id);
            System.out.println(tokenDesign);
        }
        Assert.assertEquals(3, i);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingTokenDesign.Page page = IssuingTokenDesign.page(params);
            for (IssuingTokenDesign tokenDesign : page.tokenDesigns) {
                System.out.println(tokenDesign);
                if (ids.contains(tokenDesign.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(tokenDesign.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }

        if (ids.size() != 4) {
            throw new Exception("ids.size() != 4");
        }
    }

    @Test
    public void testIssuingDesignPdfGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        Generator<IssuingTokenDesign> tokenDesigns = IssuingTokenDesign.query(params);
        for (IssuingTokenDesign tokenDesign : tokenDesigns) {
            String designId = tokenDesign.id;
            InputStream pdf = IssuingTokenDesign.pdf(designId);
            Assert.assertNotNull(pdf);
            java.nio.file.Files.copy(
                    pdf,
                    new File("design.pdf").toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println(tokenDesign);
        }
    }
}
