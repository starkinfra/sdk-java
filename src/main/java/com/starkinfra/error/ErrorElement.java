package com.starkinfra.error;

public final class ErrorElement extends StarkError {

	public String code;
    public String message;

    public ErrorElement(String code, String message) {
        super(code + ": " + message);
        this.code = code;
        this.message = message;
    }
}
