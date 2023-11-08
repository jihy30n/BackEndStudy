package com.example.test.service.jwt;



import javax.naming.AuthenticationException;

public class JwtExpiredException extends AuthenticationException {
    public JwtExpiredException(String errorMessage) {

        super(errorMessage);
    }

}