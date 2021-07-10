package com.example.o2project.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    // @respone
    public String getApiTest() {
        return null;

    }
}
