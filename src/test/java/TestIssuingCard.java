import com.starkinfra.*;
import com.starkinfra.IssuingCard;
import com.starkinfra.utils.Generator;
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
        List<IssuingCard> requests = new ArrayList<>();
        requests.add(example(false));
        requests.add(example(true));
        requests = IssuingCard.create(requests);

        System.out.println(requests);
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
            for (IssuingCard request: page.cards) {
                System.out.println(request);
                if (ids.contains(request.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(request.id);
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
        Generator<IssuingCard> statements = IssuingCard.query(params);

        for (IssuingCard statement : statements) {
            IssuingCard statementExpected = IssuingCard.get(statement.id);
            Assert.assertNotNull(statement.id, statementExpected.id);
            System.out.println(statement);
        }
    }

    @Test
    public void testGet() throws Exception {
        Settings.user = utils.User.defaultProject();
        IssuingCard cards = IssuingCard.get("5186529903247360");
        System.out.println(cards);
    }

    @Test
    public void testUpdateStatus() throws Exception {
        Settings.user = utils.User.defaultProject();
        Map<String, Object> patchData = new HashMap<>();;
        patchData.put("status", "blocked");

        IssuingCard updatedIssuingCard = IssuingCard.update("5760854205136896", patchData);

        System.out.println(updatedIssuingCard);
    }

    @Test
    public void testDelete() throws Exception {
        Settings.user = utils.User.defaultProject();
        IssuingCard deletedIssuingCard = IssuingCard.delete("5760854205136896");

        Assert.assertEquals("canceled", deletedIssuingCard.status);

        System.out.println(deletedIssuingCard);
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

    @Test
    public void testLogGet() throws Exception{
        Settings.user = utils.User.defaultProject();

        IssuingCard.Log log = IssuingCard.Log.get("5642114708799488");
        System.out.println(log);
    }

    static IssuingCard example(Boolean useRules) throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("holderExternalId", "1234");
        data.put("holderName", "Developers");
        data.put("holderTaxId", "012.345.678-90");
        if (useRules){
            data.put("rules", new IssuingRule[]{ruleExample()});
        }
        return new IssuingCard(data);
    }

    private static IssuingRule ruleExample() throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "test");
        data.put("amount", 10000);
        data.put("interval", "day");
        data.put("currencyCode", "BRL");
        return new IssuingRule(data);
    }
}
