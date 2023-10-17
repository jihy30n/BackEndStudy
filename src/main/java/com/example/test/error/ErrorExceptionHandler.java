package com.example.test.error;

import com.example.test.error.exception.BadRequestException;
import com.example.test.error.exception.ForbiddenException;
import com.example.test.error.exception.NotFoundException;
import com.example.test.error.exception.UnAuthorizedException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class ErrorExceptionHandler{
    @ExceptionHandler({BadRequestException.class})//400
    public ResponseEntity<ErrorEntity> exceptionHandler(HttpServletRequest request, final BadRequestException e){
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(ErrorEntity.builder()
                        .errorCode(e.getErrorCode().getCode())
                        .errorMessage(e.getErrorCode().getMessage())
                        .build());
    }



    //business duplicate, 넣어야함
    @ExceptionHandler({ForbiddenException.class})//403
    public ResponseEntity<ErrorEntity> exceptionHandler(HttpServletRequest request, final ForbiddenException e){
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(ErrorEntity.builder()
                        .errorCode(e.getErrorCode().getCode())
                        .errorMessage(e.getErrorCode().getMessage())
                        .build());
    }


    @ExceptionHandler({NotFoundException.class}) //404
    public ResponseEntity<ErrorEntity> exceptionHandler(HttpServletRequest request, final NotFoundException e){
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(ErrorEntity.builder()
                        .errorCode(e.getErrorCode().getCode())
                        .errorMessage(e.getErrorCode().getMessage())
                        .build());
    }

    @ExceptionHandler({UnAuthorizedException.class})//401
    public ResponseEntity<ErrorEntity> exceptionHandler(HttpServletRequest request, final UnAuthorizedException e){
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(ErrorEntity.builder()
                        .errorCode(e.getErrorCode().getCode())
                        .errorMessage(e.getErrorCode().getMessage())
                        .build());
    }

}