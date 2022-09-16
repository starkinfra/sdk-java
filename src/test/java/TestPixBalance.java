import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.PixBalance;


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
