package com.example.test.dto;

import com.example.test.entity.Board;

public class BoardListResponseDto {

    private Long id;
    private String member;
    private String title;

    public BoardListResponseDto(Board board) {
        this.id = board.getId();
        this.member = board.getMember().getName();
        this.title = board.getTitle();
    }

}
