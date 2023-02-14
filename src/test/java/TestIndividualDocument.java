import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.IndividualDocument;
import com.starkinfra.IndividualIdentity;
import com.starkinfra.utils.Generator;

import utils.FilesReader;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestIndividualDocument {

    @Test
    public void testCreateAndPatchIdentity() throws Exception {
        Settings.user = utils.User.defaultProject();
        List<IndividualIdentity> identities = IndividualIdentity.create(TestIndividualIdentity.exampleWithObject());

        Assert.assertNotNull(identities.get(0).id);

        List<IndividualDocument> documents = exampleWithObject(identities.get(0).id);
        List<IndividualDocument> createdDocuments = new ArrayList<>();

        for (IndividualDocument document: documents) {
            createdDocuments.add(IndividualDocument.create(new ArrayList<>(Arrays.asList(document))).get(0));
        }
        
        System.out.println(documents);
        for (IndividualDocument document : createdDocuments) {
            Assert.assertNotNull(document.id);
            System.out.println(document);
        }

        IndividualIdentity identity = IndividualIdentity.update(identities.get(0).id, "processing");

        Assert.assertEquals("processing", identity.status);
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IndividualDocument> documents = IndividualDocument.query(params);

        int i = 0;
        for (IndividualDocument document : documents) {
            i += 1;
            document = IndividualDocument.get(document.id);
            Assert.assertNotNull(document.id);
            System.out.println(document);
        }
        Assert.assertEquals(3, i);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IndividualDocument.Page page = IndividualDocument.page(params);
            for (IndividualDocument document : page.documents) {
                System.out.println(document);
                if (ids.contains(document.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(document.id);
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
    public void testLogQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<IndividualDocument.Log> logs = IndividualDocument.Log.query(params);

        int i = 0;
        for (IndividualDocument.Log log : logs) {
            System.out.println(log);
            i += 1;
            log = IndividualDocument.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.document.id);
            System.out.println(log);
        }
        Assert.assertEquals(3, i);
    }

    @Test
    public void testLogPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IndividualDocument.Log.Page page = IndividualDocument.Log.page(params);
            for (IndividualDocument.Log log : page.logs) {
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

    static List<IndividualDocument> exampleWithObject(String identityId) throws Exception {

        List<IndividualDocument> documents = new ArrayList<>();
        HashMap<String, Object> data = new HashMap<>();
        byte[] rgFront = new FilesReader().reader("./src/test/java/utils/identity/identity-front-face.png");
        byte[] rgBack = new FilesReader().reader("./src/test/java/utils/identity/identity-back-face.png");
        byte[] selfie = new FilesReader().reader("./src/test/java/utils/identity/walter-white.png");

        documents.add(new IndividualDocument(new HashMap<String, Object>(){{
            put("type", "identity-front");
            put("content", rgFront);
            put("contentType", "image/png");
            put("identityId", identityId);
        }}));

        documents.add(new IndividualDocument(new HashMap<String, Object>(){{
            put("type", "identity-back");
            put("content", rgBack);
            put("contentType", "image/png");
            put("identityId", identityId);
        }}));

        documents.add(new IndividualDocument(new HashMap<String, Object>(){{
            put("type", "selfie");
            put("content", selfie);
            put("contentType", "image/png");
            put("identityId", identityId);
        }}));

        return documents;
    }

}
