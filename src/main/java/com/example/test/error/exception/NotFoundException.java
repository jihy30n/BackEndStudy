package com.example.test.error.exception;

import com.example.test.error.ErrorCode;

public class NotFoundException extends BusinessException{
    public NotFoundException(String errorMessage, ErrorCode errorCode) {

        super(errorCode, errorMessage);
    }

}