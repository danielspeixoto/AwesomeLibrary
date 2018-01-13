package com.library.result;

public abstract class Result {

    private String message;

    public Result(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
