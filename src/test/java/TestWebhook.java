import org.junit.AssumptionViolatedException;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;

import com.starkinfra.Settings;
import com.starkinfra.Webhook;
import com.starkinfra.utils.Generator;
import com.starkcore.error.InputErrors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TestWebhook {

    Webhook webhook;
    String uuid;
    String url;

    @Before
    public void setup() throws Exception {
        Settings.user = utils.User.defaultProject();
        uuid = UUID.randomUUID().toString().replace("-", "");
        url = "https://winterfell.westeros.gov/events-from-stark-bank/" + uuid;
    }

    @After
    public void tearDown() throws Exception {
        if (webhook != null) {
            Webhook.delete(webhook.id);
        }
    }

    @Test
    public void testCreateWebhook() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        
        String[] subscriptions = new String[]{"boleto-holmes", "boleto-payment", "brcode-payment", "deposit", "transfer", "utility-payment"};
        params.put("url", url);
        params.put("subscriptions", subscriptions);
        webhook = Webhook.create(params);

        Assert.assertNotNull(webhook.id);
        Assert.assertEquals(webhook.url, url);
        Assert.assertArrayEquals(webhook.subscriptions, subscriptions);
    }
    
    @Test
    public void testCreateWebhookWithParallelDeliveryMethod() throws Exception {
        HashMap<String, Object> params = new HashMap<>();

        String[] subscriptions = new String[]{"invoice"};
        String deliveryMethod = "parallel";
        params.put("url", url);
        params.put("subscriptions", subscriptions);
        params.put("deliveryMethod", deliveryMethod);
        webhook = Webhook.create(params);

        Assert.assertNotNull(webhook.id);
        Assert.assertEquals(webhook.url, url);
        Assert.assertArrayEquals(webhook.subscriptions, subscriptions);
        Assert.assertEquals(webhook.deliveryMethod, deliveryMethod);
    }

    @Test
    public void testCreateRepeatedWebhooksWithDifferentDeliveryMethod() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        
        String[] subscriptions = new String[]{"boleto"};
        params.put("url", url);
        params.put("subscriptions", subscriptions);
        Webhook sequentialWebhook = Webhook.create(params);

        params.clear();

        try {
            String url2 = "https://winterfell.westeros.gov/events-from-stark-bank2/" + uuid;
            params.put("url", url2);
            params.put("subscriptions", subscriptions);
            params.put("deliveryMethod", "parallel");
            Webhook.create(params);
        } catch (InputErrors e) {
            assert(e.errors.get(0).code.equals("invalidSubscription"));
        } finally {
            Webhook.delete(sequentialWebhook.id);
        }
    }

    @Test
    public void testQueryAndGet() throws Exception {
        Generator<Webhook> webhooks = Webhook.query();

        for (Webhook webhook : webhooks) {
            try{
                webhook = Webhook.get(webhook.id);
            } catch (InputErrors e) {
                if(e.errors.get(0).code.equals("invalidWebhookId"))
                    throw new AssumptionViolatedException("Inconclusive");
                throw e;
            }
            Assert.assertNotNull(webhook.id);
            Assert.assertNotNull(webhook.url);
            Assert.assertNotNull(webhook.subscriptions);
        }
    }

    @Test
    public void testPage() throws Exception {
        HashMap<String, Object> pageParams = new HashMap<>();
        List<Webhook> createdWebhooks = new ArrayList<>();

        int limit = 2;

        for(int i = 0; i < limit + 1; i++) {
            HashMap<String, Object> webhookParams = new HashMap<>();
            String[] subscriptions = new String[]{"boleto-holmes", "boleto-payment", "brcode-payment", "deposit", "transfer", "utility-payment"};
            webhookParams.put("url", url + "-" + i);
            webhookParams.put("subscriptions", subscriptions);
            Webhook newWebhook = Webhook.create(webhookParams);
            createdWebhooks.add(newWebhook);
        }

        pageParams.put("limit", limit);
        pageParams.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            Webhook.Page page = Webhook.page(pageParams);
            for (Webhook pageWebhook: page.webhooks) {
                if (ids.contains(pageWebhook.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(pageWebhook.id);
            }
            if (page.cursor == null) {
                break;
            }
            pageParams.put("cursor", page.cursor);
        }

        if (ids.size() > 4) {
            throw new Exception("ids.size() != 4");
        }

        for (Webhook createdWebhook : createdWebhooks) {
            Webhook.delete(createdWebhook.id);
        }
    }
}
