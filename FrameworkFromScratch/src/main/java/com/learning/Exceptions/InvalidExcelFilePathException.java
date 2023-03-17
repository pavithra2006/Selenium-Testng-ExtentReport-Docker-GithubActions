package com.learning.Exceptions;

public class InvalidExcelFilePathException extends FrameworkException {
    public InvalidExcelFilePathException(String message) {
        super(message);
    }

    InvalidExcelFilePathException(String message, Throwable cause) {
        super(message, cause);
    }
}
