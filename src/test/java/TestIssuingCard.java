import com.starkinfra.utils.Generator;
import com.starkinfra.IssuingCard;
import com.starkinfra.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestIssuingCard {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();
        List<IssuingCard> cards = new ArrayList<>();
        cards.add(example(false));
        cards.add(example(true));
        cards = IssuingCard.create(cards);
        System.out.println(cards);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingCard.Page page = IssuingCard.page(params);
            for (IssuingCard card: page.cards) {
                System.out.println(card);
                if (ids.contains(card.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(card.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }

        if (ids.size() != 4) {
            throw new Exception("ids.size() != 4");
        }
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingCard> cards = IssuingCard.query(params);

        for (IssuingCard card : cards) {
            IssuingCard cardExpected = IssuingCard.get(card.id);
            Assert.assertNotNull(card.id, cardExpected.id);
            System.out.println(card);
        }
    }

    @Test
    public void testUpdateStatus() throws Exception {
        Settings.user = utils.User.defaultProject();

        Map<String, Object> patchData = new HashMap<>();;
        patchData.put("status", "blocked");

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "active");
        Generator<IssuingCard> cards = IssuingCard.query(params);
        for (IssuingCard card : cards) {
            IssuingCard updatedIssuingCard = IssuingCard.update(card.id, patchData);
            Assert.assertEquals("blocked", updatedIssuingCard.status);
        }
    }

    @Test
    public void testDelete() throws Exception {
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("status", "active");
        Generator<IssuingCard> cards = IssuingCard.query(params);
        for (IssuingCard card : cards) {
            IssuingCard deletedIssuingCard = IssuingCard.delete(card.id);
            Assert.assertEquals("canceled", deletedIssuingCard.status);
            System.out.println(deletedIssuingCard);
        }
    }

    @Test
    public void testLogPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingCard.Log.Page page = IssuingCard.Log.page(params);
            for (IssuingCard.Log log: page.logs) {
                System.out.println(log);
                if (ids.contains(log.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(log.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }

        if (ids.size() != 4) {
            throw new Exception("ids.size() != 4");
        }
    }

    @Test
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingCard.Log> logs = IssuingCard.Log.query(params);

        for (IssuingCard.Log log : logs) {
            log = IssuingCard.Log.get(log.id);
            System.out.println(log);
        }
    }

    static IssuingCard example(Boolean useRules) throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("holderExternalId", "123456");
        data.put("holderName", "Developers");
        data.put("holderTaxId", "012.345.678-90");
        if (useRules){
            data.put("rules", ruleExample());
        }
        return new IssuingCard(data);
    }

    private static List<IssuingRule> ruleExample() throws Exception {
        List<IssuingRule> rules = new ArrayList<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "test");
        data.put("amount", 10000);
        data.put("interval", "day");
        data.put("currencyCode", "BRL");
        rules.add(new IssuingRule(data));
        return rules;
    }
}
