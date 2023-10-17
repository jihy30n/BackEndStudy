package com.example.test.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private String title;
    private String content;

    public BoardUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}