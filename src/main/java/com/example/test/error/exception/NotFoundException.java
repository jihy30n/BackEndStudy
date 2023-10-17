package com.example.test.error.exception;

import com.example.test.error.ErrorCode;

public class NotFoundException extends BusinessException{
    public NotFoundException(ErrorCode errorCode, String errorMessage) {

        super(errorCode, errorMessage);
    }

}