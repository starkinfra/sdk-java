import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Assume;

import com.starkinfra.Event;
import com.starkinfra.Settings;
import com.starkinfra.PixDispute;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestPixDispute {

    @Before
    public void setUp() throws Exception {
        Settings.user = utils.User.defaultProject();
    }

    @Test
    public void testQueryGet() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixDispute> disputes = PixDispute.query(params);

        for (PixDispute dispute : disputes) {
            Assert.assertNotNull(dispute.id);
            PixDispute getDispute = PixDispute.get(dispute.id);
            Assert.assertEquals(dispute.id, getDispute.id);
        }
    }

    @Test
    public void testPage() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            PixDispute.Page page = PixDispute.page(params);
            for (PixDispute dispute: page.disputes) {
                if (ids.contains(dispute.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(dispute.id);
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
    public void testQueryAndCancel() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("status", new String[] {"created", "delivered"});

        Generator<PixDispute> disputes = PixDispute.query(params);

        List<PixDispute> disputesList = new ArrayList<>();
        for (PixDispute dispute : disputes) {
            disputesList.add(dispute);
        }

        if (disputesList.isEmpty()) {
            Assume.assumeTrue("No disputes found", false);
        }

        PixDispute dispute = disputesList.get(0);
        PixDispute canceledDispute = PixDispute.cancel(dispute.id);
        Assert.assertNotNull(canceledDispute.id);
    }

    @Test
    public void testLogQueryAndGet() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("cursor", null);

        Generator<PixDispute.Log> logs = PixDispute.Log.query(params);
        for (PixDispute.Log log : logs) {
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.dispute.id);

            PixDispute.Log getLog = PixDispute.Log.get(log.id);
            Assert.assertEquals(log.id, getLog.id);
        }
    }

    @Test
    public void testLogPage() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("cursor", null);
        
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            PixDispute.Log.Page page = PixDispute.Log.page(params);
            for (PixDispute.Log log : page.logs) {
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
    public void testPixDisputeEventParse() throws Exception{
        String content = "{\"event\": {\"created\": \"2025-12-19T19:20:08.687079+00:00\", \"id\": \"4543235613523968\", \"log\": {\"created\": \"2025-12-19T19:20:08.107566+00:00\", \"dispute\": {\"bacenId\": \"42e3c802-22c0-4862-b352-cedc912c07a1\", \"created\": \"2025-12-19T19:16:04.867430+00:00\", \"description\": \"\", \"flow\": \"in\", \"id\": \"4652621482688512\", \"maxHopCount\": 5, \"maxHopInterval\": 86400, \"maxTransactionCount\": 500, \"method\": \"scam\", \"minTransactionAmount\": 20000, \"operatorEmail\": \"fraud@company.com\", \"operatorPhone\": \"+5511989898989\", \"referenceId\": \"E20018183202512191914WcfANNEIYnt\", \"status\": \"analysed\", \"tags\": [], \"transactions\": [{\"amount\": 20000, \"endToEndId\": \"E20018183202512191914WcfANNEIYnt\", \"nominalAmount\": 20000, \"receiverAccountCreated\": \"\", \"receiverBankCode\": \"39908427\", \"receiverId\": \"1\", \"receiverTaxIdCreated\": \"\", \"receiverType\": \"business\", \"senderAccountCreated\": \"\", \"senderBankCode\": \"20018183\", \"senderId\": \"2\", \"senderTaxIdCreated\": \"\", \"senderType\": \"business\", \"settled\": \"2025-12-19T19:14:25.760000+00:00\"}], \"updated\": \"2025-12-19T19:20:08.107585+00:00\"}, \"errors\": [], \"id\": \"6007878011846656\", \"type\": \"analysed\"}, \"subscription\": \"pix-dispute\", \"workspaceId\": \"5560467233701888\"}}";
        String validSignature = "MEYCIQCPgzyktxttTM9ooQaXq37NvFjL2cF/nQMfl1rvUcsLAQIhAKLbphPa5311mHvXlz6Rtkk+LPhctxgGYOnxAdhdldls";

        Event event = Event.parse(content, validSignature);
        PixDispute.Log log = ((Event.PixDisputeEvent) event).log;

        Assert.assertNotNull(log.dispute);
    }
}
