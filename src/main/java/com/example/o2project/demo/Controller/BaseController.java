package com.example.o2project.demo.Controller;

import com.example.o2project.demo.Dto.BoardDto;
import com.example.o2project.demo.Enity.BoardEnity;
import com.example.o2project.demo.Repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BaseController {
    @Autowired
    private BoardRepository boardRep;

    @GetMapping("/aaa")
    public String base() {
        return "aaa";
    }

    @PostMapping("/form")
    public String frombase(BoardDto board) {
        log.info(board.toString());
        // 1. DTO를 Enity로 변환\
        BoardEnity artenity = board.toEntity();
        log.info(artenity.toString());
        // 2. Repository에게 Entity를 DB에 저장
        BoardEnity saved = boardRep.save(artenity);
        log.info(saved.toString());

        return "bbb";
    }

}
