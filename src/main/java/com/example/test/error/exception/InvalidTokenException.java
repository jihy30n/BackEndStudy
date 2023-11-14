package com.example.test.error.exception;

import com.example.test.error.ErrorCode;

public class InvalidTokenException extends BusinessException {

    public InvalidTokenException(ErrorCode errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
