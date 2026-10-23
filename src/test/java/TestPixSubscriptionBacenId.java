import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.starkinfra.utils.ReturnId;
import com.starkinfra.utils.EndToEndId;
import com.starkinfra.utils.PixSubscriptionBacenId;


public class TestPixSubscriptionBacenId {

    @Test
    public void testCreate() throws Exception {
        String bacenId = PixSubscriptionBacenId.create("32160637", "RR");

        Assert.assertEquals(29, bacenId.length());
        Assert.assertTrue(bacenId.matches("RR32160637\\d{8}[a-zA-Z0-9]{11}"));
        Assert.assertEquals(LocalDate.now(ZoneOffset.UTC).format(DateTimeFormatter.BASIC_ISO_DATE), bacenId.substring(10, 18));
    }

    @Test
    public void testRandomPartDiffers() throws Exception {
        String first = PixSubscriptionBacenId.create("32160637", "RR");
        String second = PixSubscriptionBacenId.create("32160637", "RR");

        Assert.assertNotEquals(first, second);
    }

    @Test
    public void testNullArgumentsAreStringifiedAndLeftToTheApi() throws Exception {
        Assert.assertTrue(PixSubscriptionBacenId.create(null, "RR").matches("RRnull\\d{8}[a-zA-Z0-9]{11}"));
        Assert.assertTrue(PixSubscriptionBacenId.create("32160637", null).matches("null32160637\\d{8}[a-zA-Z0-9]{11}"));
    }

    @Test
    public void testEndToEndIdAndReturnIdKeepMinutePrecision() throws Exception {
        String endToEndId = EndToEndId.create("32160637");
        String returnId = ReturnId.create("32160637");

        Assert.assertEquals(32, endToEndId.length());
        Assert.assertEquals(32, returnId.length());
        Assert.assertTrue(endToEndId.matches("E32160637\\d{12}[a-zA-Z0-9]{11}"));
        Assert.assertTrue(returnId.matches("D32160637\\d{12}[a-zA-Z0-9]{11}"));
    }
}
