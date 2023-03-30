package com.learning.exceptions;

public class InvalidPropertyFilePathException extends InvalidPathForFilesException {
    public InvalidPropertyFilePathException(String message) {
        super(message);
    }

    public InvalidPropertyFilePathException(String message, Throwable cause) {
        super(message, cause);
    }
}
