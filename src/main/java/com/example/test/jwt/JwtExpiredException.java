package com.example.test.jwt;
import com.example.test.error.ErrorCode;
import org.springframework.security.core.AuthenticationException;

public class JwtExpiredException extends AuthenticationException {
    public JwtExpiredException(String message) {
        super(message);
    }
}