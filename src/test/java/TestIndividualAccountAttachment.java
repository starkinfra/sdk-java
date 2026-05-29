import org.junit.Test;

import com.starkinfra.Settings;
import com.starkinfra.IndividualAccountAttachment;
import com.starkinfra.IndividualAccountRequest;
import com.starkinfra.utils.Generator;
import com.starkcore.error.InputErrors;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class TestIndividualAccountAttachment {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<IndividualAccountAttachment> attachments = new ArrayList<>();
        attachments.add(example());

        attachments = IndividualAccountAttachment.create(attachments);

        for (IndividualAccountAttachment attachment : attachments) {
            assertNotNull(attachment.id);
            assertNotNull(attachment.status);
            assertNotNull(attachment.created);
            String id = IndividualAccountAttachment.get(attachment.id).id;
            assertEquals(id, attachment.id);
        }
    }

    @Test
    public void testConstructorEncodesDataUrl() throws Exception {
        Settings.user = utils.User.defaultProject();

        IndividualAccountAttachment attachment = example();

        assertNotNull(attachment.content);
        assertTrue(
            "content must be encoded as a data:<contentType>;base64,... URL",
            attachment.content.startsWith("data:image/png;base64,")
        );
    }

    @Test
    public void testContentTypeIsInputOnly() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("id", "5189530608992256");
        responseData.put("type", "identity-front");
        responseData.put("content", "data:image/png;base64,aGVsbG8=");
        responseData.put("accountRequestId", "5189530608992256");
        responseData.put("status", "created");
        responseData.put("contentType", "image/png");

        try {
            new IndividualAccountAttachment(responseData);
            throw new Exception("expected the constructor to reject the input-only contentType field");
        } catch (Exception e) {
            assertTrue(
                "expected unknown-parameter rejection mentioning contentType, got: " + e.getMessage(),
                e.getMessage() != null && e.getMessage().contains("contentType")
            );
        }
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "created");
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<IndividualAccountAttachment> attachments = IndividualAccountAttachment.query(params);

        int i = 0;
        for (IndividualAccountAttachment attachment : attachments) {
            i += 1;
            attachment = IndividualAccountAttachment.get(attachment.id);
            assertNotNull(attachment.id);
        }
        assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        params.put("tags", new String[]{"employees"});
        Generator<IndividualAccountAttachment> attachments = IndividualAccountAttachment.query(params);

        int i = 0;
        ArrayList<String> idsExpected = new ArrayList<>();
        for (IndividualAccountAttachment attachment : attachments) {
            i += 1;
            assertNotNull(attachment.id);
            idsExpected.add(attachment.id);
        }

        params.put("ids", idsExpected.toArray(new String[0]));
        Generator<IndividualAccountAttachment> result = IndividualAccountAttachment.query(params);

        int n = 0;
        ArrayList<String> idsResult = new ArrayList<>();
        for (IndividualAccountAttachment attachment : result) {
            n += 1;
            assertNotNull(attachment.id);
            idsResult.add(attachment.id);
        }

        Collections.sort(idsExpected);
        Collections.sort(idsResult);
        assertTrue(i > 0);
        assertTrue(n > 0);
        assertEquals(idsExpected, idsResult);
    }

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
            IndividualAccountAttachment.Page page = IndividualAccountAttachment.page(params);
            for (IndividualAccountAttachment attachment : page.attachments) {
                if (ids.contains(attachment.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(attachment.id);
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
    public void testCancel() throws Exception {
        Settings.user = utils.User.defaultProject();

        IndividualAccountAttachment created =
            IndividualAccountAttachment.create(Collections.singletonList(example())).get(0);

        IndividualAccountAttachment canceled = IndividualAccountAttachment.cancel(created.id);
        assertEquals("deleted", canceled.status);
    }

    @Test
    public void testLogQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("types", new String[]{"created"});
        Generator<IndividualAccountAttachment.Log> logs = IndividualAccountAttachment.Log.query(params);

        int i = 0;
        for (IndividualAccountAttachment.Log log : logs) {
            i += 1;
            log = IndividualAccountAttachment.Log.get(log.id);
            assertNotNull(log.id);
            assertNotNull(log.attachment.id);
        }
        assertTrue(i > 0);
    }

    @Test
    public void testLogQueryAttachmentIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 5);
        Generator<IndividualAccountAttachment.Log> logs = IndividualAccountAttachment.Log.query(params);

        ArrayList<String> attachmentIds = new ArrayList<>();
        for (IndividualAccountAttachment.Log log : logs) {
            attachmentIds.add(log.attachment.id);
        }

        HashMap<String, Object> filterParams = new HashMap<>();
        filterParams.put("limit", 5);
        filterParams.put("attachmentIds", attachmentIds.toArray(new String[0]));
        Generator<IndividualAccountAttachment.Log> filtered = IndividualAccountAttachment.Log.query(filterParams);

        int i = 0;
        for (IndividualAccountAttachment.Log log : filtered) {
            i += 1;
            assertNotNull(log.id);
            assertTrue(attachmentIds.contains(log.attachment.id));
        }
        assertTrue(i > 0);
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
            IndividualAccountAttachment.Log.Page page = IndividualAccountAttachment.Log.page(params);
            for (IndividualAccountAttachment.Log log : page.logs) {
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
    public void testTypeEnum() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<String> allowed = Arrays.asList(
            "drivers-license-front", "drivers-license-back",
            "identity-front", "identity-back"
        );

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 5);
        Generator<IndividualAccountAttachment> attachments = IndividualAccountAttachment.query(params);

        int i = 0;
        for (IndividualAccountAttachment attachment : attachments) {
            i += 1;
            assertTrue("unexpected type: " + attachment.type, allowed.contains(attachment.type));
        }
        assertTrue(i > 0);
    }

    @Test
    public void testDateTimeParsing() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        Generator<IndividualAccountAttachment> attachments = IndividualAccountAttachment.query(params);

        int i = 0;
        for (IndividualAccountAttachment attachment : attachments) {
            i += 1;
            assertNotNull(attachment.created);
        }
        assertTrue(i > 0);
    }

    @Test
    public void testCreateInvalidType() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = exampleData();
        data.put("type", "not-a-real-type");

        List<IndividualAccountAttachment> attachments = new ArrayList<>();
        attachments.add(new IndividualAccountAttachment(data));

        boolean raised = false;
        try {
            IndividualAccountAttachment.create(attachments);
        } catch (InputErrors e) {
            raised = true;
        }
        assertTrue("expected InputErrors to be raised", raised);
    }

    @Test
    public void testCreateInvalidContent() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = exampleData();
        data.put("content", new byte[]{});

        List<IndividualAccountAttachment> attachments = new ArrayList<>();
        attachments.add(new IndividualAccountAttachment(data));

        boolean raised = false;
        try {
            IndividualAccountAttachment.create(attachments);
        } catch (InputErrors e) {
            raised = true;
        }
        assertTrue("expected InputErrors to be raised", raised);
    }

    @Test
    public void testCreateInvalidContentType() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = exampleData();
        data.remove("contentType");

        List<IndividualAccountAttachment> attachments = new ArrayList<>();
        attachments.add(new IndividualAccountAttachment(data));

        boolean raised = false;
        try {
            IndividualAccountAttachment.create(attachments);
        } catch (InputErrors e) {
            raised = true;
        }
        assertTrue("expected InputErrors to be raised", raised);
    }

    @Test
    public void testCreateAccountRequestNotFound() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> data = exampleData();
        data.put("accountRequestId", "0");

        List<IndividualAccountAttachment> attachments = new ArrayList<>();
        attachments.add(new IndividualAccountAttachment(data));

        boolean raised = false;
        try {
            IndividualAccountAttachment.create(attachments);
        } catch (InputErrors e) {
            raised = true;
        }
        assertTrue("expected InputErrors to be raised", raised);
    }

    @Test
    public void testCancelIdempotent() throws Exception {
        Settings.user = utils.User.defaultProject();

        IndividualAccountAttachment attachment = example();
        List<IndividualAccountAttachment> created =
            IndividualAccountAttachment.create(Collections.singletonList(attachment));
        String id = created.get(0).id;

        IndividualAccountAttachment firstCancel = IndividualAccountAttachment.cancel(id);
        assertEquals("deleted", firstCancel.status);

        IndividualAccountAttachment secondCancel = IndividualAccountAttachment.cancel(id);
        assertEquals("deleted", secondCancel.status);
    }

    @Test
    public void testGetNotFound() throws Exception {
        Settings.user = utils.User.defaultProject();

        boolean raised = false;
        try {
            IndividualAccountAttachment.get("0");
        } catch (InputErrors e) {
            raised = true;
        }
        assertTrue("expected InputErrors to be raised", raised);
    }

    static IndividualAccountAttachment example() throws Exception {
        return new IndividualAccountAttachment(exampleData());
    }

    static HashMap<String, Object> exampleData() throws Exception {
        IndividualAccountRequest parent = TestIndividualAccountRequest.example();
        List<IndividualAccountRequest> created =
            IndividualAccountRequest.create(Collections.singletonList(parent));
        String accountRequestId = created.get(0).id;

        byte[] content = new byte[]{(byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A};

        HashMap<String, Object> data = new HashMap<>();
        data.put("type", "identity-front");
        data.put("content", content);
        data.put("contentType", "image/png");
        data.put("accountRequestId", accountRequestId);
        data.put("tags", new String[]{"employees"});
        return data;
    }
}
