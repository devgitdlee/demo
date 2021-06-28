package com.example.o2project.demo.mapper;

import java.util.Optional;
import org.apache.ibatis.annotations.Select;
import com.example.o2project.demo.Enity.BoardEnity;

public interface BoardMapper {

    public Optional<BoardEnity> findById(Long id);

    @Select("SELECT * FROM BOARD WHERE ID = #{id}")
    public Optional<BoardEnity> findById2(Long id);

}
