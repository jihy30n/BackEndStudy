package com.example.test.dto;

import com.example.test.entity.Board;
import com.example.test.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardCreateRequestDto {
    private Long member_id;
    private String title;
    private String content;


    public BoardCreateRequestDto(Long member_id, String title, String content) {
        this.member_id = member_id;
        this.title = title;
        this.content = content;
    }
    public Board toEntity(Member member){
        return Board.builder()
                .member(member)
                .content(content)
                .title(title)
                .build();
    }
}
