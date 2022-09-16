package utils;

import com.starkinfra.PixRequest;

import java.util.HashMap;

public class EndToEndId {
    public static String get() throws Exception{
        String cursor = null;
        String endToEndId = null;
        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 5);
        params.put("status", "success");
        params.put("cursor", null);
        while (endToEndId == null){
            PixRequest.Page page = PixRequest.page(params);
            for (PixRequest request: page.requests) {
                if (request.flow.equals("in") && request.amount > 1){
                    endToEndId = request.endToEndId;
                    break;
                }
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }
        if (endToEndId == null){
            throw new Error("There are no inbound PixRequests to be reversed");
        }
        return endToEndId;
    }
}
