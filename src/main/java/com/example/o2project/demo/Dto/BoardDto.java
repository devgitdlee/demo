package com.example.o2project.demo.Dto;

import com.example.o2project.demo.Enity.BoardEnity;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class BoardDto {
    private String title;
    private String content;

    public BoardEnity toEntity() {
        return new BoardEnity(null, title, content);
    }

}
