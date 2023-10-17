package com.example.test.error.exception;

import com.example.test.error.ErrorCode;

public class InternalServerException extends BusinessException{
    public InternalServerException(ErrorCode errorCode, String errorMessage) {

        super(errorCode, errorMessage);
    }
}