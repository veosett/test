package com.example.quote.validator;

public class ViolationErrors {
    private final String message;
    public ViolationErrors(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
