package com.example.test.error.exception;

import com.example.test.error.ErrorCode;

public class BadRequestException extends BusinessException{
    public BadRequestException(String errorMessage, ErrorCode errorCode){
        super(errorMessage,errorCode);
    }
}