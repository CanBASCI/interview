package com.hepsi.interview.utils;

public enum CalculateFormula {
    A(0, "A"),
    B(1, "B");
    private final int code;
    private final String message;

    private CalculateFormula(int code, String message) {
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
