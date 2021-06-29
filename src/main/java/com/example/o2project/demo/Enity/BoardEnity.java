package com.example.o2project.demo.Enity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.catalina.User;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity // DB가 해당 객체를 인식 가능
@Table(name = "board")
@AllArgsConstructor
@ToString
public class BoardEnity {

    @Id // 대표값을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1,2,3 자동증가
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
    @ColumnDefault("0")
    private int count; // 조회수
    @ManyToOne // many = board user = one 하나유저는 여러개 게시글 작성 할 수 있다. 연관관계만들기
    @JoinColumn(name = "userid")
    private UserEnity user; // db는 오브젝트를 저장할 수 없다. 자바는 오브젝트를 저장할 수 있다.
    @CreationTimestamp // 시간이 자동입력
    private Timestamp createDate;

}
