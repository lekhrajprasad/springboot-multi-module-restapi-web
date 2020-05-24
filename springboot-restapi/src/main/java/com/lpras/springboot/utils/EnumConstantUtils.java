package com.lpras.springboot.utils;

public enum EnumConstantUtils {
    CORRELATION_ID_HEADER_NAME("X-Correlation-Id"),
    CORRELATION_ID_LOG_VAR_NAME("correlationId"),
    SESSION_ID_HEADER_NAME("Session-Id"),
    SESSION_ID_LOG_VAR_NAME("sessionId"),
    NO_SESSION_ID_FOUND_HEADER("No sessionId found in Header.");
    private final String name;

    EnumConstantUtils(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
