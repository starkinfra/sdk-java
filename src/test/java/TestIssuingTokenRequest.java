import com.starkinfra.IssuingCard;
import org.junit.Test;
import org.junit.Assert;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;

import java.util.HashMap;


public class TestIssuingTokenRequest {
    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("status", "active");
        params.put("limit", 1);
        Generator<IssuingCard> cards = IssuingCard.query(params);

        for (IssuingCard card : cards) {
            Assert.assertNotNull(card.id);
        }
        System.out.println(cards);
    }
}
