package com.starkinfra;

import com.starkinfra.utils.Generator;
import com.starkinfra.utils.Resource;
import com.starkinfra.utils.Rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public final class PixBalance extends Resource {
    /**
     * PixBalance object
     * <p>
     * The PixBalance object displays the current balance of the workspace,
     * which is the result of the sum of all transactions within this
     * workspace. The balance is never generated by the user, but it
     * can be retrieved to see the information available.
     * <p>
     * Attributes (return-only):
     * id [string]: unique id returned when PixBalance is created. ex: "5656565656565656"
     * amount [long]: current balance amount of the workspace in cents. ex: 200 (= R$ 2.00)
     * currency [string]: currency of the current workspace. Expect others to be added eventually. ex: "BRL"
     * updated [string]: update datetime for the balance. ex: "2020-03-10 10:30:00.000000+00:00"
     *
     */
    static ClassData data = new ClassData(PixBalance.class, "PixBalance");

    public long amount;
    public String currency;
    public String updated;

    /**
     * PixBalance object
     * <p>
     * The PixBalance object displays the current balance of the workspace,
     * which is the result of the sum of all transactions within this
     * workspace. The balance is never generated by the user, but it
     * can be retrieved to see the information available.
     * <p>
     * Attributes (return-only):
     * @param id [string]: unique id returned when PixBalance is created. ex: "5656565656565656"
     * @param amount [long]: current balance amount of the workspace in cents. ex: 200 (= R$ 2.00)
     * @param currency [string]: currency of the current workspace. Expect others to be added eventually. ex: "BRL"
     * @param updated [string]: update datetime for the balance. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public PixBalance(long amount, String currency, String updated, String id) {
        super(id);
        this.amount = amount;
        this.currency = currency;
        this.updated = updated;
    }

    /**
     * Retrieve the PixBalance object
     * <p>
     * Receive the PixBalance object linked to your workspace in the Stark Infra API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkinfra.Settings.user was set before function call
     * <p>
     * Return:
     * @return PixBalance object with updated attributes
     * @throws Exception error in the request
     */
    public static PixBalance get(User user) throws Exception {
        List<PixBalance> balanceList = new ArrayList<>();
        Generator<PixBalance> balances = Rest.getStream(data, new HashMap<String, Object>(), user);
        for (PixBalance balance : balances) {
            balanceList.add(balance);
        }
        return balanceList.get(0);
    }

     /**
     * Retrieve the PixBalance object
     * <p>
     * Receive the PixBalance object linked to your workspace in the Stark Infra API
     * <p>
     * Return:
     * @return PixBalance object with updated attributes
     * @throws Exception error in the request
     */
    public static PixBalance get() throws Exception {
        return PixBalance.get(null);
    }
}
