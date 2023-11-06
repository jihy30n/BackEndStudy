package com.example.test.error.exception;

import com.example.test.error.ErrorCode;

public class JwtExpiredException extends BusinessException{
    public JwtExpiredException(String errorMessage, ErrorCode errorCode) {
        super(errorCode, errorMessage);
    }
}