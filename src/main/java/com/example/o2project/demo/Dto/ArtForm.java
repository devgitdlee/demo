package com.example.o2project.demo.Dto;

import com.example.o2project.demo.Enity.Artenity;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArtForm {
    private String title;
    private String content;

    public Artenity toEntity() {
        return new Artenity(null, title, content);
    }

}
