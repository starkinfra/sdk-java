import org.junit.Test;
import org.junit.Assert;

import com.starkinfra.Settings;
import com.starkinfra.IssuingCard;
import com.starkinfra.IssuingEmbossingRequest;
import com.starkinfra.IssuingHolder;
import com.starkinfra.utils.Generator;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class TestIssuingEmbossingRequest {

    @Test
    public void testCreate() throws Exception {
        Settings.user = utils.User.defaultProject();
        
        List<IssuingEmbossingRequest> request = IssuingEmbossingRequest.create(example());
        System.out.println(request);
    }

    @Test
    public void testQueryGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingEmbossingRequest> requests = IssuingEmbossingRequest.query(params);

        for (IssuingEmbossingRequest request : requests) {
            IssuingEmbossingRequest requestExpected = IssuingEmbossingRequest.get(request.id);
            Assert.assertNotNull(request.id, requestExpected.id);
            System.out.println(request);
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
            IssuingEmbossingRequest.Page page = IssuingEmbossingRequest.page(params);
            for (IssuingEmbossingRequest request: page.requests) {
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
    public void testLogQueryAndGet() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<IssuingEmbossingRequest.Log> logs = IssuingEmbossingRequest.Log.query(params);

        for (IssuingEmbossingRequest.Log log : logs) {
            log = IssuingEmbossingRequest.Log.get(log.id);
            System.out.println(log);
        }
    }

    @Test
    public void testLogPage() throws Exception{
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            IssuingEmbossingRequest.Log.Page page = IssuingEmbossingRequest.Log.page(params);
            for (IssuingEmbossingRequest.Log log : page.logs) {
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

    static List<IssuingEmbossingRequest> example() throws Exception{

        List<IssuingEmbossingRequest> requests = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("cardDesignId", "5648359658356736");
            data.put("displayName1", "teste");
            data.put("envelopeDesignId", "5747368922185728");
            data.put("shippingCity", "Sao Paulo");
            data.put("shippingCountryCode", "BRA");
            data.put("shippingDistrict", "Bela Vista");
            data.put("shippingService", "loggi");
            data.put("shippingStateCode", "SP");
            data.put("shippingStreetLine1", "teste");
            data.put("shippingStreetLine2", "teste");
            data.put("shippingTrackingNumber", "teste");
            data.put("shippingZipCode", "12345-678");
            data.put("embosserId", "5746980898734080");

            List<IssuingCard> cards = createCards();

            for( IssuingCard card : cards){
                data.put("cardId", card.id);
            }
            
            requests.add(new IssuingEmbossingRequest(data));
        }
        return requests;
    }

    static List<IssuingCard> createCards() throws Exception {
        List<IssuingCard> cards = new ArrayList<>();

        HashMap<String, Object> cardParams = new HashMap<>();
        cardParams.put("productId", "52233227");
        cardParams.put("type", "physical");

        HashMap<String, Object> holderParams = new HashMap<>();
        holderParams.put("limit", 1);
        Generator<IssuingHolder> holders = IssuingHolder.query(holderParams);
        for (IssuingHolder holder : holders) {
            cardParams.put("holderName", holder.name);
            cardParams.put("holderTaxId", holder.taxId);
            cardParams.put("holderExternalId", holder.externalId);
            break;
        }

        cards.add(new IssuingCard(cardParams));

        return IssuingCard.create(cards);
    }

}
