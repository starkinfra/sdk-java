import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.BusinessIdentity;
import com.starkinfra.BusinessAttachment;
import com.starkinfra.utils.Generator;

import java.util.Base64;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestBusinessAttachment {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<BusinessIdentity> identities = BusinessIdentity.create(TestBusinessIdentity.exampleWithObject());
        Assert.assertNotNull(identities.get(0).id);

        List<BusinessAttachment> attachments = exampleWithObject(identities.get(0).id);
        List<BusinessAttachment> createdAttachments = new ArrayList<>();

        for (BusinessAttachment attachment: attachments) {
            createdAttachments.add(BusinessAttachment.create(new ArrayList<>(java.util.Arrays.asList(attachment))).get(0));
        }

        for (BusinessAttachment attachment : createdAttachments) {
            Assert.assertNotNull(attachment.id);
        }
    }

    @Test
    public void testCancel() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<BusinessIdentity> identities = BusinessIdentity.create(TestBusinessIdentity.exampleWithObject());
        Assert.assertNotNull(identities.get(0).id);

        List<BusinessAttachment> attachments = exampleWithObject(identities.get(0).id);
        BusinessAttachment createdAttachment = BusinessAttachment.create(attachments).get(0);
        Assert.assertNotNull(createdAttachment.id);

        BusinessAttachment canceledAttachment = BusinessAttachment.cancel(createdAttachment.id);
        Assert.assertEquals(createdAttachment.id, canceledAttachment.id);
        Assert.assertEquals("canceled", canceledAttachment.status);
    }

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<BusinessAttachment> attachments = BusinessAttachment.query(params);

        int i = 0;
        for (BusinessAttachment attachment : attachments) {
            i += 1;
            attachment = BusinessAttachment.get(attachment.id);
            Assert.assertNotNull(attachment.id);
        }
        Assert.assertEquals(3, i);
    }

    @Test
    public void testGetWithExpand() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<BusinessAttachment> attachments = BusinessAttachment.query(params);

        for (BusinessAttachment attachment : attachments) {
            HashMap<String, Object> getParams = new HashMap<>();
            getParams.put("expand", new String[]{"content"});
            BusinessAttachment retrieved = BusinessAttachment.get(attachment.id, getParams);
            Assert.assertEquals(retrieved.id, attachment.id);
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
            BusinessAttachment.Page page = BusinessAttachment.page(params);
            for (BusinessAttachment attachment : page.attachments) {
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
    public void testLogQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<BusinessAttachment.Log> logs = BusinessAttachment.Log.query(params);

        int i = 0;
        for (BusinessAttachment.Log log : logs) {
            i += 1;
            log = BusinessAttachment.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.attachment.id);
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
            BusinessAttachment.Log.Page page = BusinessAttachment.Log.page(params);
            for (BusinessAttachment.Log log : page.logs) {
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

    static List<BusinessAttachment> exampleWithObject(String businessIdentityId) throws Exception {

        byte[] content = Base64.getDecoder().decode(
            "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mP8/5+hHgAHggJ/PchI7wAAAABJRU5ErkJggg=="
        );

        List<BusinessAttachment> attachments = new ArrayList<>();
        attachments.add(new BusinessAttachment(new HashMap<String, Object>(){{
            put("name", "articles-of-incorporation.png");
            put("content", content);
            put("contentType", "image/png");
            put("businessIdentityId", businessIdentityId);
            put("tags", new String[]{"doc-principal"});
        }}));

        return attachments;
    }

}
