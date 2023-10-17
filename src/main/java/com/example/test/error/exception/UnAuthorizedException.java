package com.example.test.error.exception;

import com.example.test.error.ErrorCode;

public class UnAuthorizedException extends BusinessException {

    public UnAuthorizedException(String errorMessage, ErrorCode errorCode) {

        super(errorMessage, errorCode);
    }
}
