package com.learning.exceptions;

public class ElementLocatorException extends FrameworkException {
    public ElementLocatorException(String message) {
        super(message);
    }

    public ElementLocatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
