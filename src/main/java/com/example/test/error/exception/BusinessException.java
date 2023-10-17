package com.example.test.error.exception;

import com.example.test.error.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private final ErrorCode errorCode;

    public BusinessException(String errorMessage, ErrorCode errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }
}
