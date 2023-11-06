package com.example.test.dto;

import com.example.test.entity.MemberEntity;

public class MemberCreateRequestDto {

    private String name;
    private String email;
    private String password;

    public MemberCreateRequestDto(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
