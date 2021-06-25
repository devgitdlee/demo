package com.example.o2project.demo.Enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // DB가 해당 객체를 인식 가능
public class Artenity {

    @Id // 대표값을 지정
    @GeneratedValue // 1,2,3 자동증가
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public Artenity(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String toString() {
        return "ArtForm{title = " + title + " content = " + content + "}";
    }
}
