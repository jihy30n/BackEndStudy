package com.example.test.error.exception;

import com.example.test.error.ErrorCode;

public class ForbiddenException extends BusinessException {

    public ForbiddenException(ErrorCode errorCode, String errorMessage) {

        super(errorCode, errorMessage);
    }
}