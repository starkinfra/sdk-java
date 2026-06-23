import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Ledger;
import com.starkinfra.Settings;
import com.starkinfra.LedgerTransaction;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestLedgerTransaction {

    @Test
    public void testCreateAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<LedgerTransaction> transactions = example(5);

        List<Ledger> ledgers = new ArrayList<>();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<Ledger> query = Ledger.query(params);
        for (Ledger ledger : query) {
            ledgers.add(ledger);
        }

        for (int i = 0; i < transactions.size(); i++) {
            transactions.get(i).ledgerId = ledgers.get(i % ledgers.size()).id;
        }

        transactions = LedgerTransaction.create(transactions);

        System.out.println(transactions);
        for (LedgerTransaction transaction : transactions) {
            Assert.assertNotNull(transaction.id);
            LedgerTransaction checkTransaction = LedgerTransaction.get(transaction.id);
            Assert.assertEquals(transaction.id, checkTransaction.id);
            System.out.println(checkTransaction);
        }
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        Ledger ledger = getLedgerWithTransactions();

        HashMap<String, Object> params = new HashMap<>();
        params.put("ledgerId", ledger.id);
        params.put("limit", 5);
        Generator<LedgerTransaction> transactions = LedgerTransaction.query(params);

        for (LedgerTransaction transaction : transactions) {
            System.out.println(transaction);
            Assert.assertNotNull(transaction.id);
        }
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        Ledger ledger = getLedgerWithTransactions();

        HashMap<String, Object> params = new HashMap<>();
        params.put("ledgerId", ledger.id);
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            LedgerTransaction.Page page = LedgerTransaction.page(params);
            for (LedgerTransaction transaction: page.transactions) {
                System.out.println(transaction);
                if (ids.contains(transaction.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(transaction.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }
    }

    @Test
    public void testQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        Ledger ledger = getLedgerWithTransactions();

        HashMap<String, Object> params = new HashMap<>();
        params.put("ledgerId", ledger.id);
        params.put("limit", 1);
        Generator<LedgerTransaction> transactions = LedgerTransaction.query(params);

        for (LedgerTransaction transaction : transactions) {
            Assert.assertNotNull(transaction.id);
            transaction = LedgerTransaction.get(transaction.id);
            Assert.assertNotNull(transaction.id);
            Assert.assertEquals(ledger.id, transaction.ledgerId);
            System.out.println(transaction);
        }
    }

    static Ledger getLedgerWithTransactions() throws Exception {
        return getLedgerWithTransactions(10);
    }

    static Ledger getLedgerWithTransactions(int minTransactionCount) throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 20);
        Generator<Ledger> ledgers = Ledger.query(params);
        for (Ledger ledger : ledgers) {
            HashMap<String, Object> transactionParams = new HashMap<>();
            transactionParams.put("ledgerId", ledger.id);
            transactionParams.put("limit", minTransactionCount - 1);
            LedgerTransaction.Page page = LedgerTransaction.page(transactionParams);
            if (page.cursor != null) {
                return ledger;
            }
        }
        return null;
    }

    static List<LedgerTransaction> example(int n) throws Exception {
        List<LedgerTransaction> transactions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("amount", (long) (Math.floor(Math.random() * (9999 - 1000)) + 1000));
            data.put("ledgerId", "123");
            data.put("source", "account/" + String.format("%06d", (int) (Math.random() * 999999) + 1));
            data.put("externalId", String.format("%06d", (int) (Math.random() * 999999) + 1));
            data.put("tags", new String[]{"savings account", "spending counter"});

            HashMap<String, Object> metadata = new HashMap<>();
            metadata.put("accountId", "123");
            data.put("metadata", metadata);

            List<Ledger.Rule> rules = new ArrayList<>();
            rules.add(new Ledger.Rule("minimumBalance", 0));
            data.put("rules", rules);

            transactions.add(new LedgerTransaction(data));
        }
        return transactions;
    }
}
