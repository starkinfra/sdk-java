package com.starkinfra.error;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

import java.util.List;
import java.util.ArrayList;

public final class InputErrors extends StarkError {

	public List<ErrorElement> errors;

    public InputErrors(String content) {
        super(content);
        this.errors = new ArrayList<>();

        JsonObject errorsJson = new Gson().fromJson(content, JsonObject.class);
        if (!errorsJson.get("errors").isJsonNull()) {
            for (JsonElement error : errorsJson.get("errors").getAsJsonArray()) {
                JsonObject errorJson = error.getAsJsonObject();
                errors.add(
                        new ErrorElement(
                                errorJson.get("code").getAsString(),
                                errorJson.get("message").getAsString()
                        )
                );
            }
        }
    }
}
