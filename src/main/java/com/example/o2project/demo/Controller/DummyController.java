package com.example.o2project.demo.Controller;

import com.example.o2project.demo.Repository.UserRepository;
import com.example.o2project.demo.model.RoleType;
import com.example.o2project.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(value="/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        User user = userRepository.findById(id).orElseGet(supplier<>()){
            @override
            public get(){
                return new 
            };
        }
        return  user;
    }

}
