import org.junit.Test;
import org.junit.Assert;

import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

import com.starkinfra.utils.BacenId;


public class TestBacenId {

    @Test
    public void testCreateUsesUtc() throws Exception {
        String bacenId = BacenId.create("32160637");

        Assert.assertEquals(31, bacenId.length());
        Assert.assertTrue(bacenId.matches("32160637\\d{12}[a-zA-Z0-9]{11}"));

        LocalDateTime generated = LocalDateTime.parse(bacenId.substring(8, 20), DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        long minutesFromUtcNow = Math.abs(ChronoUnit.MINUTES.between(generated, LocalDateTime.now(ZoneOffset.UTC)));
        Assert.assertTrue(minutesFromUtcNow <= 1);
    }
}
