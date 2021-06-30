package com.example.o2project.demo.mapper;

import java.util.Optional;

import com.example.o2project.demo.model.Board;

import org.apache.ibatis.annotations.Select;

public interface BoardMapper {

    public Optional<Board> findById(Long id);

    @Select("SELECT * FROM BOARD WHERE ID = #{id}")
    public Optional<Board> findById2(Long id);

}
