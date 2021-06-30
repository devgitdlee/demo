package com.example.o2project.demo.Controller;

import com.example.o2project.demo.Repository.UserRepository;
import com.example.o2project.demo.model.RoleType;
import com.example.o2project.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println(user.getId());
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입 완료했습니다.";

    }
}
