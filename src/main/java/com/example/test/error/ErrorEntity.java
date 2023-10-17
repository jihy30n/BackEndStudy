package com.example.test.error;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Getter
public class ErrorEntity {
    private String errorCode;
    private String errorMessage;

    @Builder
    public ErrorEntity(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
