package com.berkedev.weather.user.exception;

public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String message) {
        super(message);
    }

    public DuplicateResourceException(String fieldName, String fieldValue) {
        super(String.format("%s already exists: %s", fieldName, fieldValue));
    }
}
