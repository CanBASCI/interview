package com.hepsi.interview.utils;

public enum Status {
    ACTIVE(1, "Active"),
    PASSIVE(0, "Passive");
    private final int code;
    private final String message;

    private Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
