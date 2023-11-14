import org.junit.Assert;
import org.junit.Test;
import com.starkinfra.PixUser;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;

import java.util.HashMap;

public class TestPixUser {
    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        PixUser user = PixUser.get("01234567890");
        Assert.assertNotNull(user);
        System.out.println(user);
    }
}
