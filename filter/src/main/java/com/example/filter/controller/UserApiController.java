package com.example.filter.controller;

import com.example.filter.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("") // 클라이언트가 보낸 데이터를 확인하는 방법
    public UserRequest register(
            @RequestBody
            UserRequest userRequest
    ){
            log.info("{}", userRequest);
            return userRequest;
    }
}
