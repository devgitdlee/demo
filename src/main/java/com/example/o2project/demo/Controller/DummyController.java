package com.example.o2project.demo.Controller;

import java.util.function.Supplier;

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

    @GetMapping(value = "/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        // null 처리 하는 형식 인터페이스 클래스가 아니기 때문에 객체 사용 불가능 하기 때문에
        // 해당 메소드 빈 객체를 return
        /*
         * 람다식 User user = userRepository.findById(id).orElseThrow(()->{ return new
         * IllegalArgumentException("해당 유저는 없는 유저입니다." + id);
         * 
         * });
         */
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없는 유저입니다." + id);
            }
        });
        return user;
    }

}
