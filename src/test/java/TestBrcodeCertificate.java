import com.starkinfra.BrcodeCertificate;
import com.starkinfra.utils.Generator;
import com.starkinfra.Settings;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class TestBrcodeCertificate {

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();
        Generator<BrcodeCertificate> certificates = BrcodeCertificate.query();
        for (BrcodeCertificate certificate : certificates) {
            Assert.assertNotNull(certificate.content);
        }
    }
}
