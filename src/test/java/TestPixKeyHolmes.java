import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.PixKeyHolmes;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


public class TestPixKeyHolmes {

    // [M1] create accepts a list of PixKeyHolmes and returns the list with
    //      server-assigned id, status, result, created, updated.
    // [M3] surface is create/query/page ONLY -- no get is called here.
    // [M5] only keyId and tags are accepted by create; id/result/status/
    //      created/updated come back populated from the server.
    // [M6] created/updated are parsed and non-empty (NOT asserted as a closed
    //      enum or as a native Date object -- see PixFraud-run lessons).
    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<PixKeyHolmes> holmes = new ArrayList<>();
        holmes.add(example());

        holmes = PixKeyHolmes.create(holmes);

        for (PixKeyHolmes sherlock : holmes) {
            Assert.assertNotNull(sherlock.id);
            Assert.assertNotNull(sherlock.status);
            Assert.assertFalse(sherlock.status.isEmpty());
            Assert.assertNotNull(sherlock.created);
            Assert.assertFalse(sherlock.created.isEmpty());
            Assert.assertNotNull(sherlock.updated);
            Assert.assertFalse(sherlock.updated.isEmpty());
            System.out.println(sherlock);
        }
    }

    // [M2] query supports limit, after, before, status, tags, ids.
    // [M3] no get -- iterate the generator and assert on the streamed entity
    //      directly (CreditHolmes/PixFraud re-fetch via get; this resource has
    //      none, so we assert on the queried object itself).
    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        // [M2] the live API accepts ONLY solved/solving as status filter values
        //      (verified 2026-06-16); created/failed return invalidStatus.
        params.put("status", "solved");
        Generator<PixKeyHolmes> holmes = PixKeyHolmes.query(params);

        int i = 0;
        for (PixKeyHolmes sherlock : holmes) {
            i += 1;
            Assert.assertNotNull(sherlock.id);
            Assert.assertNotNull(sherlock.status);
            Assert.assertFalse(sherlock.status.isEmpty());
            System.out.println(sherlock);
        }
        Assert.assertTrue(i > 0);
    }

    // [M2] query supports the ids filter -- collect ids from a first query,
    //      feed them back as the ids filter, assert the set round-trips.
    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixKeyHolmes> holmes = PixKeyHolmes.query(params);

        int i = 0;
        ArrayList<String> holmesIdsExpected = new ArrayList<>();
        for (PixKeyHolmes sherlock : holmes) {
            i += 1;
            Assert.assertNotNull(sherlock.id);
            holmesIdsExpected.add(sherlock.id);
        }

        params.put("ids", holmesIdsExpected.toArray(new String[0]));
        Generator<PixKeyHolmes> holmesResult = PixKeyHolmes.query(params);

        int n = 0;
        ArrayList<String> holmesIdsResult = new ArrayList<>();
        for (PixKeyHolmes sherlock : holmesResult) {
            n += 1;
            Assert.assertNotNull(sherlock.id);
            holmesIdsResult.add(sherlock.id);
        }

        Collections.sort(holmesIdsExpected);
        Collections.sort(holmesIdsResult);
        Assert.assertTrue(i > 0);
        Assert.assertTrue(n > 0);
        Assert.assertEquals(holmesIdsExpected, holmesIdsResult);
    }

    // [M2] page supports limit, after, before, status, tags, ids + cursor.
    // [M4] pagination uses an opaque cursor (mutated into params), not a
    //      numeric page index.
    // Page.holmes is the last-word-plural field ("Holmes" -> "holmes"), per
    // the sibling CreditHolmes.Page.holmes model.
    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            PixKeyHolmes.Page page = PixKeyHolmes.page(params);
            for (PixKeyHolmes sherlock : page.holmes) {
                System.out.println(sherlock);
                if (ids.contains(sherlock.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(sherlock.id);
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

    // [M7] tags defaults to an empty list when omitted -- construct a
    //      PixKeyHolmes with ONLY keyId (no "tags" key in the map) and assert
    //      create accepts it and returns a server-assigned id. This exercises
    //      the default-when-omitted path the SDK must still accept.
    @Test
    public void testCreateWithoutTags() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = new HashMap<>();
        data.put("keyId", "valid@sandbox.com");

        List<PixKeyHolmes> holmes = new ArrayList<>();
        holmes.add(new PixKeyHolmes(data));

        holmes = PixKeyHolmes.create(holmes);

        for (PixKeyHolmes sherlock : holmes) {
            Assert.assertNotNull(sherlock.id);
            Assert.assertFalse(sherlock.id.isEmpty());
            System.out.println(sherlock);
        }
    }

    // Fixture for PixKeyHolmes create.
    // [M5] Required input: keyId (a valid Pix key). Optional: tags.
    // The contract documents email / phone / taxId key formats; an email key
    // mirrors the sibling resources' sandbox-friendly Pix key.
    // [M7] tags is left to the SDK default when omitted -- the fixture exercises
    //      the explicit-tags path; the default-tags path is covered by the
    //      keyId-only construction the SDK must still accept.
    static PixKeyHolmes example() throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        data.put("keyId", "valid@sandbox.com");
        List<String> tags = new ArrayList<>();
        tags.add("travel");
        tags.add("food");
        data.put("tags", tags.toArray(new String[0]));
        return new PixKeyHolmes(data);
    }
}
