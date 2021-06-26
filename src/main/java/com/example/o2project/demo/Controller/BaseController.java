package com.example.o2project.demo.Controller;

import com.example.o2project.demo.Dto.ArtForm;
import com.example.o2project.demo.Enity.Artenity;
import com.example.o2project.demo.Repository.ArtRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BaseController {
    @Autowired
    private ArtRepository ArtRep;

    @GetMapping("/aaa")
    public String base() {
        return "aaa";
    }

    @PostMapping("/form")
    public String frombase(ArtForm Form) {
        log.info(Form.toString());
        // 1. DTO를 Enity로 변환\
        Artenity artenity = Form.toEntity();
        log.info(artenity.toString());
        // 2. Repository에게 Entity를 DB에 저장
        Artenity saved = ArtRep.save(artenity);
        log.info(saved.toString());

        return "bbb";
    }

}
