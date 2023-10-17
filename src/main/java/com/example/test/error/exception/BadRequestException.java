package com.example.test.error.exception;

import com.example.test.error.ErrorCode;

public class BadRequestException extends BusinessException{
    public BadRequestException(ErrorCode errorCode, String errorMessage){
        super(errorCode, errorMessage);
    }
}