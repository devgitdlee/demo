package com.example.o2project.demo.Controller;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import com.example.o2project.demo.Repository.UserRepository;
import com.example.o2project.demo.model.RoleType;
import com.example.o2project.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        /*
         * 요청: 웹브라우저 user 객체를 -> JSON 변환 스프링부트는 MessageConverter라는 애가 응답시에 자동 작동 만약에 자바
         * 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서 user 오브젝트를 JSON으로 변환해서
         * 브라우저에게 던져주는 메소드
         */
        return user;
    }

    @GetMapping("/dummy/user")
    public List<User> list() {
        return userRepository.findAll();
    }

    /**
     * 스프링부트 자동 페이지 처리 메소드 한페이지당 2건에 데이터를 리턴받는 형식
     */
    @GetMapping("/dummy/user/page")
    public Page<User> pageList(
            @PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);

        return users;
    }

    /*
     * save 함수는 id를 전달하지 않으면 insert를 해주고 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 진행함 id를
     * 전달해도 해당 id에 대한 데이터가 없으면 insert를 진행함 Transactional만 걸면 save 함수를 사용하지 않아도 sql를
     * 진행함 이것을 더티체킹이라함
     */
    @Transactional
    @PutMapping("/dummy/user/{id}")
    public User UpdateUser(@PathVariable int id, @RequestBody User requestuser) {
        System.out.println("ID" + id);
        System.out.println("PASSWORD" + requestuser.getPassword());
        System.out.println("EMAIL" + requestuser.getEmail());
        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });
        user.setPassword(requestuser.getPassword());
        user.setEmail(requestuser.getEmail());

        // userRepository.save(user);
        // 더티 체킹

        return null;

    }

}
