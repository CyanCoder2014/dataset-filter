package com.example.datasetFilter.exceptions;

public class BadRequestException extends BasicException {

    private final String message;
    private static final int CODE=400;

    public BadRequestException(String message) {
        super(message,CODE);
        this.message = message;

    }
    public BadRequestException(String message,Integer code) {
        super(message,code);
        this.message = message;
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause,CODE);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
