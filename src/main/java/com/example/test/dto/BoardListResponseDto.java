package com.example.test.dto;

import com.example.test.entity.BoardEntity;
import lombok.Getter;

@Getter
public class BoardListResponseDto {

    private Long id;
    private Long member;
    private String title;


    public BoardListResponseDto(BoardEntity boardEntity) {
        this.title = boardEntity.getTitle();
        this.id = boardEntity.getId();
        this.member = boardEntity.getMember().getId();
    }

}
