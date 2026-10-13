import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.utils.PixSubscriptionBacenId;


public class TestPixSubscriptionBacenId {

    @Test
    public void testCreate() throws Exception {
        String bacenId = PixSubscriptionBacenId.create("32160637", "RR");

        Assert.assertEquals(29, bacenId.length());
        Assert.assertTrue(bacenId.matches("RR32160637\\d{8}[a-zA-Z0-9]{11}"));
    }

    @Test
    public void testNullArgumentsAreStringifiedAndLeftToTheApi() throws Exception {
        Assert.assertTrue(PixSubscriptionBacenId.create(null, "RR").matches("RRnull\\d{8}[a-zA-Z0-9]{11}"));
        Assert.assertTrue(PixSubscriptionBacenId.create("32160637", null).matches("null32160637\\d{8}[a-zA-Z0-9]{11}"));
    }
}
