package com.example.test.dto;

import com.example.test.entity.BoardEntity;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private Long id;
    private Long member;
    private String title;
    private String content;
    public BoardResponseDto(BoardEntity boardEntity){
        this.id = boardEntity.getId();
        this.member = boardEntity.getMember().getId();
        this.title = boardEntity.getTitle();
        this.content = boardEntity.getContent();
    }
}
