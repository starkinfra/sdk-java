import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.starkcore.error.InputErrors;
import com.starkinfra.IssuingCard;
import com.starkinfra.IssuingHolder;
import com.starkinfra.IssuingProduct;
import com.starkinfra.Settings;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;


// The offline tests check the JSON the SDK hands to the core (the core serializes the list with Gson, there is no seam to
// replace its HTTP call); the sandbox tests run against the real API and cancel every card they create.
public class TestIssuingCardWithoutHolder {

    private static Map<String, Object> map(Object... keysAndValues) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < keysAndValues.length; i += 2) {
            map.put((String) keysAndValues[i], keysAndValues[i + 1]);
        }
        return map;
    }

    @Test
    public void testHolderFieldsAreNotSentWhenOmitted() throws Exception {
        IssuingCard card = new IssuingCard(map("productId", "123", "type", "physical"));

        JsonObject sent = new Gson().toJsonTree(List.of(card)).getAsJsonArray().get(0).getAsJsonObject();

        Assert.assertEquals("{\"productId\":\"123\",\"type\":\"physical\"}", sent.toString());
        Assert.assertFalse(sent.has("holderName"));
        Assert.assertFalse(sent.has("holderTaxId"));
        Assert.assertFalse(sent.has("holderExternalId"));
    }

    @Test
    public void testHolderFieldsAreSentWhenInformed() throws Exception {
        IssuingCard card = new IssuingCard(map(
            "holderName", "Tony Stark", "holderTaxId", "012.345.678-90", "holderExternalId", "my-entity/123", "productId", "123"
        ));

        JsonObject sent = new Gson().toJsonTree(List.of(card)).getAsJsonArray().get(0).getAsJsonObject();

        Assert.assertEquals("Tony Stark", sent.get("holderName").getAsString());
        Assert.assertEquals("012.345.678-90", sent.get("holderTaxId").getAsString());
        Assert.assertEquals("my-entity/123", sent.get("holderExternalId").getAsString());
    }

    // ---- sandbox ----

    private static IssuingProduct firstProduct() throws Exception {
        Settings.user = utils.User.defaultProject();
        // The stream ends silently when its page request times out, so an empty result is looked up again.
        for (int attempt = 0; attempt < 3; attempt++) {
            for (IssuingProduct product : IssuingProduct.query(map("limit", 1))) {
                return product;
            }
        }
        throw new Exception("no issuing product in the sandbox Project");
    }

    // A holder can only be linked to a product of its own type: business holders have a CNPJ (14 digits) and individual
    // holders a CPF (11 digits). Existing holders are used so no personal data is created by the test.
    private static IssuingHolder findExistingHolderForProduct(IssuingProduct product) throws Exception {
        Map<String, Integer> digitsByType = map("business", 14, "individual", 11).entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> (Integer) entry.getValue()));
        Integer digits = digitsByType.get(product.holderType);
        if (digits == null) {
            throw new Exception("unknown holderType of the sandbox product: " + product.holderType);
        }
        // The holder stream ends silently when a page request times out, so an empty result is looked up again.
        for (int attempt = 0; attempt < 3; attempt++) {
            for (IssuingHolder holder : IssuingHolder.query(map("status", "active", "limit", 100))) {
                if (holder.taxId.replaceAll("\\D", "").length() == digits) {
                    return holder;
                }
            }
        }
        return null;
    }

    private static List<Object> cardsWithoutHolder(int n, String type, String productId) {
        List<Object> cards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cards.add(map("productId", productId, "type", type, "tags", new String[]{"sdk-test"}));
        }
        return cards;
    }

    // A failed cancel must not hide the failure of the test (a leftover card is reported by the sandbox-test plan).
    private static void cancelAll(List<IssuingCard> cards) {
        for (IssuingCard card : cards) {
            try {
                IssuingCard.cancel(card.id);
            } catch (Exception exception) {
                System.out.println("could not cancel card " + card.id);
            }
        }
    }

    private static Map<String, Object> holderFields(IssuingHolder holder) {
        return map("holderName", holder.name, "holderTaxId", holder.taxId, "holderExternalId", holder.externalId);
    }

    // The API rejection reaches the caller untouched, with the error code of the API.
    private static void assertRejected(Callable<?> call, String code) throws Exception {
        try {
            call.call();
        } catch (InputErrors errors) {
            List<String> codes = errors.errors.stream().map(error -> error.code).collect(Collectors.toList());
            Assert.assertTrue("expected " + code + ", got " + codes, codes.contains(code));
            return;
        }
        Assert.fail("expected the API to reject the call");
    }

    private interface PendingCardsTest {
        void run(List<IssuingCard> cards, IssuingHolder holder) throws Exception;
    }

    // Creates pending physical cards without holder, runs the test with them and always cancels them.
    private static void withPendingCards(int n, PendingCardsTest test) throws Exception {
        IssuingProduct product = firstProduct();
        IssuingHolder holder = findExistingHolderForProduct(product);
        Assert.assertNotNull("the sandbox needs an existing active holder compatible with the product", holder);
        List<IssuingCard> cards = IssuingCard.create(cardsWithoutHolder(n, "physical", product.id));
        try {
            test.run(cards, holder);
        } finally {
            cancelAll(cards);
        }
    }

    @Test
    public void testPhysicalCardWithoutHolderIsCreatedPending() throws Exception {
        List<IssuingCard> cards = IssuingCard.create(cardsWithoutHolder(1, "physical", firstProduct().id));
        try {
            Assert.assertEquals(1, cards.size());
            Assert.assertEquals("pending", cards.get(0).status);
            Assert.assertEquals("physical", cards.get(0).type);
            Assert.assertEquals("", cards.get(0).holderId);
            Assert.assertEquals("", cards.get(0).holderName);
        } finally {
            cancelAll(cards);
        }
    }

    @Test
    public void testApiRejectsVirtualCardWithoutHolder() throws Exception {
        List<Object> cards = cardsWithoutHolder(1, "virtual", firstProduct().id);
        assertRejected(() -> IssuingCard.create(cards), "invalidHolder");
    }

    @Test
    public void testApiRejectsIncompleteHolderFieldsOnCreate() throws Exception {
        List<Object> cards = cardsWithoutHolder(1, "physical", firstProduct().id);
        ((Map<String, Object>) cards.get(0)).put("holderName", "Tony Stark");
        assertRejected(() -> IssuingCard.create(cards), "invalidHolder");
    }

    @Test
    public void testHolderIsAssignedToAPendingCard() throws Exception {
        withPendingCards(1, (cards, holder) -> {
            IssuingCard card = IssuingCard.update(cards.get(0).id, holderFields(holder));
            Assert.assertEquals("pending", card.status);
            Assert.assertEquals(holder.id, card.holderId);
        });
    }

    @Test
    public void testHolderIsAssignedAndCardActivatedInTheSameCall() throws Exception {
        withPendingCards(1, (cards, holder) -> {
            Map<String, Object> patch = holderFields(holder);
            patch.put("status", "active");
            patch.put("pin", "1234");
            IssuingCard card = IssuingCard.update(cards.get(0).id, patch);
            Assert.assertEquals("active", card.status);
            Assert.assertEquals(holder.id, card.holderId);
        });
    }

    @Test
    public void testApiRejectsIncompleteHolderFieldsOnUpdate() throws Exception {
        withPendingCards(1, (cards, holder) ->
            assertRejected(() -> IssuingCard.update(cards.get(0).id, map("holderName", holder.name)), "invalidHolder"));
    }

    @Test
    public void testApiRejectsActivationWithoutHolder() throws Exception {
        withPendingCards(1, (cards, holder) ->
            assertRejected(() -> IssuingCard.update(cards.get(0).id, map("status", "active", "pin", "1234")), "invalidHolder"));
    }

    @Test
    public void testHolderIsAssignedToSeveralCards() throws Exception {
        withPendingCards(2, (cards, holder) -> {
            List<Map<String, Object>> items = new ArrayList<>();
            for (IssuingCard card : cards) {
                Map<String, Object> item = holderFields(holder);
                item.put("id", card.id);
                items.add(item);
            }
            List<IssuingCard> updated = IssuingCard.updateMulti(items);
            Assert.assertEquals(
                cards.stream().map(card -> card.id).sorted().collect(Collectors.toList()),
                updated.stream().map(card -> card.id).sorted().collect(Collectors.toList())
            );
            for (IssuingCard card : updated) {
                Assert.assertEquals(holder.id, card.holderId);
            }
        });
    }

    @Test
    public void testApiRejectsTheWholeListWhenOneItemIsInvalid() throws Exception {
        withPendingCards(2, (cards, holder) -> {
            Map<String, Object> valid = holderFields(holder);
            valid.put("id", cards.get(0).id);
            Map<String, Object> invalid = holderFields(holder);
            invalid.put("id", "0000000000000001");
            assertRejected(() -> IssuingCard.updateMulti(List.of(valid, invalid)), "invalidCard");
            Assert.assertEquals("", IssuingCard.get(cards.get(0).id).holderId);
        });
    }

    @Test
    public void testApiRejectsIncompleteHolderFieldsOnUpdateMulti() throws Exception {
        withPendingCards(1, (cards, holder) ->
            assertRejected(() -> IssuingCard.updateMulti(List.of(map("id", cards.get(0).id, "holderName", holder.name))), "invalidHolder"));
    }

    @Test
    public void testApiRejectsPinInTheBatch() throws Exception {
        withPendingCards(1, (cards, holder) ->
            assertRejected(() -> IssuingCard.updateMulti(List.of(map("id", cards.get(0).id, "pin", "1234"))), "invalidJson"));
    }

    @Test
    public void testApiRejectsDisplayNameInTheBatch() throws Exception {
        withPendingCards(1, (cards, holder) ->
            assertRejected(() -> IssuingCard.updateMulti(List.of(map("id", cards.get(0).id, "displayName", "Name"))), "invalidJson"));
    }
}
