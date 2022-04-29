import com.starkinfra.utils.Generator;
import com.starkinfra.PixStatement;
import com.starkinfra.Settings;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.StandardCopyOption;
import java.io.InputStream;
import java.io.File;
import java.util.*;


public class TestPixStatement {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();
        PixStatement statement = PixStatement.create(example());
        System.out.println(statement);
        Assert.assertNotNull(statement.id);
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<PixStatement> statements = PixStatement.query(params);

        int i = 0;
        for (PixStatement statement : statements) {
            i += 1;
            PixStatement statementExpected = PixStatement.get(statement.id);
            Assert.assertNotNull(statement.id, statementExpected.id);
            System.out.println(statement);
        }
        System.out.println(i);
    }


    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixStatement> statements = PixStatement.query(params);

        ArrayList<String> statementsIdsExpected = new ArrayList<>();
        for (PixStatement statement : statements) {
            Assert.assertNotNull(statement.id);
            statementsIdsExpected.add(statement.id);
        }

        params.put("ids", statementsIdsExpected.toArray(new String[0]));
        Generator<PixStatement> statementsResult = PixStatement.query(params);

        ArrayList<String> statementsIdsResult = new ArrayList<>();
        for (PixStatement statement : statementsResult){
            Assert.assertNotNull(statement.id);
            statementsIdsResult.add(statement.id);
        }

        Collections.sort(statementsIdsExpected);
        Collections.sort(statementsIdsResult);
        Assert.assertEquals(statementsIdsExpected, statementsIdsResult);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            PixStatement.Page page = PixStatement.page(params);
            for (PixStatement statement: page.statements) {
                System.out.println(statement);
                if (ids.contains(statement.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(statement.id);
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
    public void testPixStatementCsvGet() throws Exception {

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        Generator<PixStatement> statements = PixStatement.query(params);
        for (PixStatement statement : statements) {
            String id = statement.id;
            InputStream csv = PixStatement.csv(id);
            Assert.assertNotNull(csv);
            java.nio.file.Files.copy(
                    csv,
                    new File("statement.zip").toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println(statement);
        }
    }

    static PixStatement example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("after", "2022-01-01");
        data.put("before", "2022-01-01");
        data.put("type", "transaction");

        return new PixStatement(data);
    }
}
