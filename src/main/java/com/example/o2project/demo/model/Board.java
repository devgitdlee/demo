package com.example.o2project.demo.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // DB가 해Board능
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {

    @Id // 대표값을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1,2,3 자동증가
    private Long id;
    @Column
    private String title;
    @Column(nullable = false)
    @Lob
    private String content;
    @ColumnDefault("0")
    private int count; // 조회수
    @ManyToOne(fetch = FetchType.EAGER) // many = board user = one 하나유저는 여러개 게시글 작성 할 수 있다. 연관관계만들기
    @JoinColumn(name = "userid")
    private User user; // db는 오브젝트를 저장할 수 없다. 자바는 오브젝트를 저장할 수 있다.
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedby 연관관계의 주인이 아니다 (난 FK가 아니예요) DB에 컬럼을 만들지마세요
    private List<Reply> reply;

    @CreationTimestamp // 시간이 자동입력
    private Timestamp createDate;

}
