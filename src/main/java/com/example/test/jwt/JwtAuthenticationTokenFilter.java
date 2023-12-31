package com.example.test.jwt;

import com.example.test.error.ErrorCode;
import com.example.test.error.ErrorJwtCode;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SignatureException;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        if (path.contains("/login") || path.contains("/signup") || path.contains("/members")) {
            filterChain.doFilter(request, response);
            return;
        }

        String AT = jwtProvider.resolveAT(request);

        if (AT == null){
            String RT = jwtProvider.resolveRT(request);
            if (jwtProvider.validateToken(RT)) {
                String userEmail = jwtProvider.getUserEmail(RT);
                AT = jwtProvider.createAT(userEmail);
                jwtProvider.setHeaderAT(response, AT);
                this.setAuthentication(AT);
            }
        } else{
            if (jwtProvider.validateToken(AT)) {
                this.setAuthentication(AT);
            }
        }

        ErrorJwtCode errorCode = null;
        try {
            filterChain.doFilter(request, response);
        } catch (JwtException ex) {
            String message = ex.getMessage();
            if(ErrorJwtCode.INVALID_TOKEN.getMessage().equals(message)) {
                setResponse(response, errorCode);
            }
            //잘못된 타입의 토큰인 경우
            else if(ErrorJwtCode.INVALID_TOKEN.getMessage().equals(message)) {
                setResponse(response, errorCode);
            }
            //토큰 만료된 경우
            else if(ErrorJwtCode.EMPTY_TOKEN.getMessage().equals(message)) {
                setResponse(response, errorCode);
            }
            //지원되지 않는 토큰인 경우
            else if(ErrorJwtCode.EXPIRED_AT.getMessage().equals(message)) {
                setResponse(response, errorCode);
            }
            else {
                setResponse(response, errorCode);
            }
        }

        filterChain.doFilter(request,response);
    }


    private void setAuthentication(String token) {
        //토큰에서 유저정보 빼기
        Authentication authentication = jwtProvider.getAuthentication(token);
        //유저정보 뺀거 컨택스트에 저장
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    private void setResponse(HttpServletResponse response, ErrorJwtCode  ErrorCode) throws RuntimeException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(ErrorCode.getCode());
        response.getWriter().print(ErrorCode.getMessage());
    }
}