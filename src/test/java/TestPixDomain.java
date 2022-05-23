import com.starkinfra.PixDomain;
import com.starkinfra.utils.Generator;
import com.starkinfra.Settings;
import org.junit.Assert;
import org.junit.Test;


public class TestPixDomain {

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();
        Generator<PixDomain> domains = PixDomain.query();
        for (PixDomain domain : domains) {
            Assert.assertNotNull(domain);
            System.out.println(domain.certificates);
        }
    }
}
