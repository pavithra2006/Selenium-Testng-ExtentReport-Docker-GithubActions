package com.learning.Exceptions;

public class BrowserInvocationFailedException extends FrameworkException {
    public BrowserInvocationFailedException(String message) {
        super(message);
    }

    public BrowserInvocationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
