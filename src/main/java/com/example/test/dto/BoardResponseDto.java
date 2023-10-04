package com.example.test.dto;

import com.example.test.entity.Board;

public class BoardResponseDto {

    private Long id;
    private String member;
    private String title;
    private String content;

    public BoardResponseDto(Board entity){
        this.id = entity.getId();
        this.member = entity.getMember().getName();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
