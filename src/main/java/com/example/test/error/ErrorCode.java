package com.example.test.error;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ErrorCode {

    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "400", "400: 잘못된 요청입니다."),
    EMAIL_DUPLICATION(HttpStatus.BAD_REQUEST, "400", "중복된 이메일입니다."),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "401", "401: 승인이 필요합니다."),
    FORBIDDEN_EXCEPTION(HttpStatus.FORBIDDEN, "403", "403: 접근 권한이 없습니다."),
    NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "404", "404: 찾을 수 없는 페이지입니다. "),
    USER_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "404", "404:사용자를 찾을 수 없습니다."),
    POST_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "404", "404: 게시글을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}