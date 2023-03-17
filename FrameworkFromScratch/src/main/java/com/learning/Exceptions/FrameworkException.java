package com.learning.Exceptions;

public class FrameworkException extends RuntimeException {
    public FrameworkException(String message) {
        super(message);
    }

    FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
