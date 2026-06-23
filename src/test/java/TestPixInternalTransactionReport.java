import org.junit.Test;

import com.starkinfra.Settings;
import com.starkinfra.PixInternalTransactionReport;
import com.starkinfra.utils.Generator;
import com.starkinfra.utils.EndToEndId;
import com.starkinfra.utils.ReturnId;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class TestPixInternalTransactionReport {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();

        List<PixInternalTransactionReport> reports = new ArrayList<>();
        reports.add(example(false));
        reports.add(example(true));
        reports = PixInternalTransactionReport.create(reports);

        for (PixInternalTransactionReport report : reports) {
            assertNotNull(report.id);
            assertNotNull(report.status);
            assertNotNull(report.updated);
            String id = PixInternalTransactionReport.get(report.id).id;
            assertEquals(id, report.id);
        }
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixInternalTransactionReport> reports = PixInternalTransactionReport.query(params);

        int i = 0;
        for (PixInternalTransactionReport report : reports) {
            i += 1;
            report = PixInternalTransactionReport.get(report.id);
            assertNotNull(report.id);
        }
        assertTrue(i > 0);
    }

    @Test
    public void testQueryStatus() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("status", Collections.singletonList("success"));
        Generator<PixInternalTransactionReport> reports = PixInternalTransactionReport.query(params);

        int i = 0;
        for (PixInternalTransactionReport report : reports) {
            i += 1;
            assertNotNull(report.id);
        }
        assertTrue(i > 0);
    }

    @Test
    public void testQueryIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);
        Generator<PixInternalTransactionReport> reports = PixInternalTransactionReport.query(params);

        int i = 0;
        ArrayList<String> reportsIdsExpected = new ArrayList<>();
        for (PixInternalTransactionReport report : reports) {
            i += 1;
            assertNotNull(report.id);
            reportsIdsExpected.add(report.id);
        }

        params.put("ids", reportsIdsExpected.toArray(new String[0]));
        Generator<PixInternalTransactionReport> reportsResult = PixInternalTransactionReport.query(params);

        int n = 0;
        ArrayList<String> reportsIdsResult = new ArrayList<>();
        for (PixInternalTransactionReport report : reportsResult) {
            n += 1;
            assertNotNull(report.id);
            reportsIdsResult.add(report.id);
        }

        Collections.sort(reportsIdsExpected);
        Collections.sort(reportsIdsResult);
        assertTrue(i > 0);
        assertTrue(n > 0);
        assertEquals(reportsIdsExpected, reportsIdsResult);
    }

    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 10);

        PixInternalTransactionReport.Page page = PixInternalTransactionReport.page(params);

        for (PixInternalTransactionReport report : page.reports) {
            assertNotNull(report.id);
        }
        assertNotNull(page.cursor);
    }

    @Test
    public void testLogQueryAndGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("after", "2019-04-01");
        params.put("before", "2030-04-30");
        Generator<PixInternalTransactionReport.Log> logs = PixInternalTransactionReport.Log.query(params);

        int i = 0;
        for (PixInternalTransactionReport.Log log : logs) {
            i += 1;
            log = PixInternalTransactionReport.Log.get(log.id);
            assertNotNull(log.id);
            assertNotNull(log.report.id);
            assertNotNull(log.created);
        }
        assertTrue(i > 0);
    }

    @Test
    public void testLogQueryTypesAndReportIds() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> reportParams = new HashMap<>();
        reportParams.put("limit", 10);
        Generator<PixInternalTransactionReport> reports = PixInternalTransactionReport.query(reportParams);

        List<String> reportIds = new ArrayList<>();
        for (PixInternalTransactionReport report : reports) {
            assertNotNull(report.id);
            reportIds.add(report.id);
        }
        assertTrue(reportIds.size() > 0);

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        params.put("types", Collections.singletonList("success"));
        params.put("reportIds", reportIds);
        Generator<PixInternalTransactionReport.Log> logs = PixInternalTransactionReport.Log.query(params);

        int i = 0;
        for (PixInternalTransactionReport.Log log : logs) {
            i += 1;
            assertNotNull(log.id);
            assertNotNull(log.report.id);
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
            PixInternalTransactionReport.Log.Page page = PixInternalTransactionReport.Log.page(params);
            for (PixInternalTransactionReport.Log log : page.logs) {
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

    static PixInternalTransactionReport example(boolean reversal) throws Exception {
        String bankCode = utils.User.bankCode();
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", 1234L);
        data.put("created", "2026-06-15T17:23:53.980238+00:00");
        data.put("endToEndId", EndToEndId.create(bankCode));
        data.put("method", "manual");
        data.put("senderAccountNumber", "76543-8");
        data.put("senderBranchCode", "2201");
        data.put("senderAccountType", "checking");
        data.put("senderBankCode", bankCode);
        data.put("senderTaxId", "594.739.480-42");
        data.put("receiverAccountNumber", "00000-0");
        data.put("receiverBranchCode", "0001");
        data.put("receiverAccountType", "checking");
        data.put("receiverBankCode", "18236120");
        data.put("receiverTaxId", "012.345.678-90");
        data.put("receiverKeyId", "+5511989898989");
        if (reversal) {
            data.put("referenceType", "reversal");
            data.put("returnId", ReturnId.create(bankCode));
        } else {
            data.put("referenceType", "request");
        }
        return new PixInternalTransactionReport(data);
    }
}
