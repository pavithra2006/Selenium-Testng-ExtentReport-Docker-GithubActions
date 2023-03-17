package com.learning.Exceptions;

public class InvalidPropertyFilePathException extends InvalidPathForFilesException {
    public InvalidPropertyFilePathException(String message) {
        super(message);
    }

    public InvalidPropertyFilePathException(String message, Throwable cause) {
        super(message, cause);
    }
}
