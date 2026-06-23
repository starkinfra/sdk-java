import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Ledger;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;

import java.util.UUID;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


public class TestLedger {

    @Test
    public void testCreateAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<Ledger> ledgers = Ledger.create(example(3));

        System.out.println(ledgers);
        for (Ledger ledger : ledgers) {
            Assert.assertNotNull(ledger.id);
            Ledger checkLedger = Ledger.get(ledger.id);
            Assert.assertEquals(ledger.id, checkLedger.id);
            System.out.println(checkLedger);
        }
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<Ledger> ledgers = Ledger.query(params);

        for (Ledger ledger : ledgers) {
            System.out.println(ledger);
            Assert.assertNotNull(ledger.id);
        }
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Ledger.Page page = Ledger.page(params);
            for (Ledger ledger: page.ledgers) {
                System.out.println(ledger);
                if (ids.contains(ledger.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(ledger.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }
    }

    @Test
    public void testUpdate() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        Generator<Ledger> ledgers = Ledger.query(params);

        for (Ledger ledger : ledgers) {
            HashMap<String, Object> patchData = new HashMap<>();
            List<Ledger.Rule> rules = new ArrayList<>();
            rules.add(new Ledger.Rule("minimumBalance", 0));
            patchData.put("rules", rules);

            Ledger updatedLedger = Ledger.update(ledger.id, patchData);
            Assert.assertNotNull(updatedLedger.id);
            System.out.println(updatedLedger);
        }
    }

    static List<Ledger> example(int n) throws Exception {
        List<Ledger> ledgers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("externalId", UUID.randomUUID().toString());
            data.put("tags", new String[]{"savings account", "spending counter"});

            HashMap<String, Object> metadata = new HashMap<>();
            metadata.put("accountId", "123");
            data.put("metadata", metadata);

            List<Ledger.Rule> rules = new ArrayList<>();
            rules.add(new Ledger.Rule("minimumBalance", 0));
            data.put("rules", rules);

            ledgers.add(new Ledger(data));
        }
        return ledgers;
    }
}
