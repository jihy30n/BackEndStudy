package com.example.test.error;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ErrorCode {

    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "400", "400 Error: 잘못된 요청입니다."),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "401", "401 Error: 승인이 필요합니다."),
    FORBIDDEN_EXCEPTION(HttpStatus.FORBIDDEN, "403", "403 Forbidden: 접근 권한이 없습니다."),
    NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "404", "404 Not found: 페이지를 찾을 수 없습니다. "),
    NOT_EXIST_USER(HttpStatus.NOT_FOUND, "404", "404 Not found: 존재하지 않는 사용자입니다."),
    NOT_EXIST_POST(HttpStatus.NOT_FOUND, "404", "404 Not found: 존재하지 않는 게시글입니다."),
    INTERNAL_SERVER_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "500", "500: 예기치 못한 오류가 발생했습니다.");

    private HttpStatus status;
    private String code;
    private String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}