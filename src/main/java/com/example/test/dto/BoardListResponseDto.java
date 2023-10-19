package com.example.test.dto;

import com.example.test.entity.Board;
import com.example.test.entity.Member;
import lombok.Getter;

@Getter
public class BoardListResponseDto {

    private Long id;
    private Long member;
    private String title;


    public BoardListResponseDto(Board board) {
        this.title = board.getTitle();
        this.id = board.getId();
        this.member = board.getMember().getId();
    }

}
