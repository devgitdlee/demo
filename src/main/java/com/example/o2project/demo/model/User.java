package com.example.o2project.demo.model;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//ORM - JAVA
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // 빌더패턴
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 30)
    private String username;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 50)
    private String email;
    // @ColumnDefault("user")
    @Enumerated(EnumType.STRING)
    private RoleType role; // Enum 쓰는게 좋다. ADMIN, USER
    @CreationTimestamp // 시간이 자동입력
    private Timestamp createDate;

}
