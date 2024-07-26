package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//@Controller // HTML 응답시
@RestController // 응답 값을 json 형식으로만 응답 => 선언
@RequestMapping("/api/v1")
public class ResponseApiController {

    @GetMapping("")
    public UserRequest user(){
        log.info("[ResponseApiController] GET user()");

        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(20);
        user.setEmail("sjh0804_22@naver.com");

        log.info("user = {}", user);

        var response = ResponseEntity
                .status(HttpStatus.CREATED)
                .header("x-custom","hi")
                .body(user);

        log.info("response = {}", response);

        return user;
    }
}
