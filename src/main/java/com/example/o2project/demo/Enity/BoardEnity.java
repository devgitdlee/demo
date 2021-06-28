package com.example.o2project.demo.Enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity // DB가 해당 객체를 인식 가능
@Table(name = "board")
@AllArgsConstructor
@ToString
public class BoardEnity {

    @Id // 대표값을 지정
    @GeneratedValue // 1,2,3 자동증가
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

}
