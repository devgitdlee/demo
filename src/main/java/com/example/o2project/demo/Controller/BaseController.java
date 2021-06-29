package com.example.o2project.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import com.example.o2project.demo.Dto.BoardDto;
import com.example.o2project.demo.Enity.BoardEnity;
import com.example.o2project.demo.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BaseController {
    @Autowired
    private BoardService boardservice;

    @Autowired
    public BaseController(BoardService boardservice) {
        this.boardservice = boardservice;
    }

    @GetMapping("/aaa")
    public String base() {
        return "aaa";
    }

    @PostMapping("/form")
    public Map<String, Object> save(@RequestBody BoardDto boarddto) {
        Map<String, Object> response = new HashMap<>();

        BoardEnity board = boardservice.save(boarddto);
        if (board != null) {
            response.put("result", "게시판 글작성 성공");
            response.put("user", board);
        } else {
            response.put("result", "FAIL");
            response.put("reason", "게시판 글작성 실패");
        }

        return response;
    }

}
