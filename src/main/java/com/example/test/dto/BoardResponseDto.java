package com.example.test.dto;

import com.example.test.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private Long id;
    private Long member;
    private String title;
    private String content;
    public BoardResponseDto(Board board){
        this.id = board.getId();
        this.member = board.getMember().getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
