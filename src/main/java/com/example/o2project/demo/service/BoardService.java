package com.example.o2project.demo.service;

import java.util.Optional;

import com.example.o2project.demo.Repository.BoardRepository;
import com.example.o2project.demo.mapper.BoardMapper;
import com.example.o2project.demo.model.Board;

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

}
