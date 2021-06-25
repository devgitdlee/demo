package com.example.o2project.demo.Dto;

import javax.persistence.Table;

import com.example.o2project.demo.Enity.Artenity;

public class ArtForm {
    private String title;
    private String content;

    public ArtForm(String title, String content) {

        this.title = title;
        this.content = content;
    }

    public Artenity toEntity() {
        return new Artenity(null, title, content);
    }

}
