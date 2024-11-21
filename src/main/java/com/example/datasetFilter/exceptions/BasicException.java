package com.example.datasetFilter.exceptions;

public class BasicException extends RuntimeException {

    private int code;

    public int getCode() {
        return code;
    }

    public BasicException(int code) {
        this.code = code;
    }

    public BasicException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BasicException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public BasicException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public BasicException(String message, Throwable cause, boolean enableSuppression,
                          boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

}
