package com.berkedev.weather.user.exception.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ValidationErrorResponse extends ErrorResponse{

    private Map<String, String> fieldErrors;

    public ValidationErrorResponse(
            int status,
            String message,
            LocalDateTime timeStamp,
            String path,
            Map<String, String> fieldErrors
    ) {
        super(status, message, timeStamp, path);
        this.fieldErrors = fieldErrors;
    }
}
