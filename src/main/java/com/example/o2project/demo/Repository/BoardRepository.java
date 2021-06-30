package com.example.o2project.demo.Repository;

import com.example.o2project.demo.model.Board;

import org.springframework.data.repository.CrudRepository;

//객체 및 키값 설정
public interface BoardRepository extends CrudRepository<Board, Long> {

}
