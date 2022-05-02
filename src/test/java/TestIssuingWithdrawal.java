import com.starkinfra.IssuingWithdrawal;
import com.starkinfra.Settings;
import com.starkinfra.utils.Generator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestIssuingWithdrawal {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();
        IssuingWithdrawal statement = IssuingWithdrawal.create(example());
        System.out.println(statement);
        Assert.assertNotNull(statement.id);
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
            for (IssuingWithdrawal request: page.issuingWithdrawals) {
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
        Generator<IssuingWithdrawal> statements = IssuingWithdrawal.query(params);

        int i = 0;
        for (IssuingWithdrawal statement : statements) {
            i += 1;
            IssuingWithdrawal statementExpected = IssuingWithdrawal.get(statement.id);
            Assert.assertNotNull(statement.id, statementExpected.id);
            System.out.println(statement);
        }
        System.out.println(i);
    }

    static IssuingWithdrawal example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", 1000);
        data.put("externalId", "1234");
        data.put("description", "Sending back");

        return new IssuingWithdrawal(data);
    }

}
