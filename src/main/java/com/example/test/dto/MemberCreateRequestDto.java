package com.example.test.dto;

import com.example.test.entity.Member;

public class MemberCreateRequestDto {

    private String name;
    private String email;
    private String password;

    public MemberCreateRequestDto(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
