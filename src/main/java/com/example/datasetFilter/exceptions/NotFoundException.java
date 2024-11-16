package com.example.datasetFilter.exceptions;


import org.springframework.http.HttpStatus;

public class NotFoundException extends BasicException {

    private String message;
    private static final int CODE= HttpStatus.NOT_FOUND.value();

    public NotFoundException() {
        super("{common.error.notfound}",CODE);

    }
    public NotFoundException(String message) {
        super(message,CODE);
        this.message = message;
    }
    public NotFoundException(String message, Throwable cause) {
        super(message, cause,CODE);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
