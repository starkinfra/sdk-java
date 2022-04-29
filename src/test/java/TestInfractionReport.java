import com.starkinfra.InfractionReport;
import com.starkinfra.utils.EndToEndId;
import com.starkinfra.utils.Generator;
import com.starkinfra.Settings;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class TestInfractionReport {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();
        InfractionReport report = InfractionReport.create(example());
        Assert.assertNotNull(report.id);
    }

    @Test
    public void testDelete() throws Exception {
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", "delivered");
        Generator<InfractionReport> reports = InfractionReport.query(params);
        for (InfractionReport report : reports) {
            report = InfractionReport.delete(report.id);
            Assert.assertEquals(report.status, "canceled");
            System.out.println(report);
        }
    }

    @Test
    public void testInfractionReportQueryAndDelete() throws Exception{
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("status", "created");
        int i = 0;
        for (InfractionReport report : InfractionReport.query(params)) {
            i ++;
            report = InfractionReport.delete(report.id);
            Assert.assertEquals(report.status, "canceled");
            System.out.println(report);
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
        Generator<InfractionReport> reports = InfractionReport.query(params);

        int i = 0;
        for (InfractionReport report : reports) {
            i += 1;
            report = InfractionReport.get(report.id);
            System.out.println(report);
        }
        System.out.println(i);
    }

    @Test
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<InfractionReport.Log> logs = InfractionReport.Log.query(params);

        int i = 0;
        for (InfractionReport.Log log : logs) {
            i += 1;
            log = InfractionReport.Log.get(log.id);
            Assert.assertNotNull(log.id);
            Assert.assertNotNull(log.report.id);
            System.out.println(log);
        }
        Assert.assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<InfractionReport> reports = InfractionReport.query(params);

        ArrayList<String> reportsIdsExpected = new ArrayList<>();
        for (InfractionReport report : reports) {
            Assert.assertNotNull(report.id);
            reportsIdsExpected.add(report.id);
        }

        params.put("ids", reportsIdsExpected.toArray(new String[0]));
        Generator<InfractionReport> reportsResult = InfractionReport.query(params);

        ArrayList<String> reportsIdsResult = new ArrayList<>();
        for (InfractionReport report : reportsResult){
            Assert.assertNotNull(report.id);
            reportsIdsResult.add(report.id);
        }

        Collections.sort(reportsIdsExpected);
        Collections.sort(reportsIdsResult);
        Assert.assertEquals(reportsIdsExpected, reportsIdsResult);
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
            InfractionReport.Page page = InfractionReport.page(params);
            for (InfractionReport report: page.reports) {
                System.out.println(report);
                if (ids.contains(report.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(report.id);
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
    public void testLogPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            InfractionReport.Log.Page page = InfractionReport.Log.page(params);
            for (InfractionReport.Log log: page.logs) {
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

    @Test
    public void testUpdateStatus() throws Exception {
        Settings.user = utils.User.defaultProject();
        List<InfractionReport> reports = getReportToPatch();

        for (InfractionReport report : reports) {
            System.out.println(report);
            HashMap<String, Object> patchData = new HashMap<>();
            patchData.put("result", "agreed");
            InfractionReport updatedInfractionReport = InfractionReport.update(report.id, patchData);
            Assert.assertNotNull(updatedInfractionReport.id);
            System.out.println(updatedInfractionReport);
        }
    }

    public List<InfractionReport> getReportToPatch() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        params.put("cursor", null);
        params.put("status", "delivered");
        List<InfractionReport> reports = new ArrayList<>();
        while (reports.size() < 1) {
            InfractionReport.Page page = InfractionReport.page(params);
            for (InfractionReport report: page.reports) {
                if (report.agent.equals("reporter")){
                    reports.add(report);
                }
                System.out.println(report);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }
        return(reports);
    }

    static InfractionReport example() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("referenceId", EndToEndId.create(System.getenv("SANDBOX_BANK_CODE")));
        data.put("type","fraud");
        return new InfractionReport(data);
    }
}
