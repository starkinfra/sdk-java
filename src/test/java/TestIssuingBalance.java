import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.IssuingBalance;
import com.starkinfra.Settings;


public class TestIssuingBalance {

    @Test
    public void testGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        IssuingBalance balance = IssuingBalance.get();
        System.out.println(balance);
        Assert.assertNotNull(balance.id);
        Assert.assertNotNull(balance.currency);
    }
}
