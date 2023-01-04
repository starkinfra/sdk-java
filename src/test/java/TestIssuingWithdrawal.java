import com.starkcore.utils.Generator;
import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.IssuingWithdrawal;

import java.util.List;
import java.util.UUID;
import java.util.HashMap;
import java.util.ArrayList;


public class TestIssuingWithdrawal {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        IssuingWithdrawal withdrawal = IssuingWithdrawal.create(example());
        System.out.println(withdrawal);
        Assert.assertNotNull(withdrawal.id);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingWithdrawal.Page page = IssuingWithdrawal.page(params);
            for (IssuingWithdrawal withdrawal: page.issuingWithdrawals) {
                System.out.println(withdrawal);
                if (ids.contains(withdrawal.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(withdrawal.id);
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
        Generator<IssuingWithdrawal> withdrawals = IssuingWithdrawal.query(params);

        int i = 0;
        for (IssuingWithdrawal withdrawal : withdrawals) {
            i += 1;
            IssuingWithdrawal withdrawalExpected = IssuingWithdrawal.get(withdrawal.id);
            Assert.assertNotNull(withdrawal.id, withdrawalExpected.id);
            System.out.println(withdrawal);
        }
        System.out.println(i);
    }

    static IssuingWithdrawal example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", Long.valueOf(1000));
        data.put("externalId", UUID.randomUUID().toString());
        data.put("description", "Sending back");

        return new IssuingWithdrawal(data);
    }
}
