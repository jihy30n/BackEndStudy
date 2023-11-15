package com.example.test.error.exception;
import com.example.test.error.ErrorCode;
import lombok.Getter;

@Getter
public class JwtException extends BusinessException{
    public JwtException( ErrorCode errorCode, String errorMessage){
        super(errorCode, errorMessage);
    }
}