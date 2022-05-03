import com.starkinfra.PixBalance;
import com.starkinfra.Settings;
import org.junit.Assert;
import org.junit.Test;


public class TestPixBalance {

    @Test
    public void testGet() throws Exception {
        Settings.user = utils.User.defaultProject();
        PixBalance balance = PixBalance.get();
        System.out.println(balance);
        Assert.assertNotNull(balance.id);
        Assert.assertNotNull(balance.currency);
    }
}
