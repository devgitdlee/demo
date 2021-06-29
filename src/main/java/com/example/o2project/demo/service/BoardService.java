package com.example.o2project.demo.service;

import java.util.Optional;

import com.example.o2project.demo.Dto.BoardDto;
import com.example.o2project.demo.Enity.BoardEnity;
import com.example.o2project.demo.Repository.BoardRepository;
import com.example.o2project.demo.mapper.BoardMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardService {

    private final BoardRepository boardrep;
    private final BoardMapper boardmapper;

    @Autowired
    public BoardService(BoardRepository boardrep, BoardMapper boardmapper) {
        this.boardrep = boardrep;
        this.boardmapper = boardmapper;
    }

    @Transactional
    public BoardEnity save(BoardDto boarddto) {
        // 1. DTO를 Enity로 변환
        BoardEnity bEnity = boarddto.toEntity();
        log.info(bEnity.toString());
        // 2. Repository에게 Entity를 DB에 저장
        return boardrep.save(bEnity);
    }

}
