package com.example.o2project.demo.Controller;

import com.example.o2project.demo.Dto.ArtForm;
import com.example.o2project.demo.Enity.Artenity;
import com.example.o2project.demo.Repository.ArtRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BaseController {
    @Autowired
    private ArtRepository ArtRep;

    @GetMapping("/")
    public String base() {
        return "";
    }

    @PostMapping("/form")
    public String frombase(ArtForm Form) {
        // 1. DTO를 Enity로 변환\
        Artenity artenity = Form.toEntity();
        // 2. Repository에게 Entity를 DB에 저장
        Artenity saved = ArtRep.save(artenity);
        System.out.println(saved.toString());

        return "";
    }

}
