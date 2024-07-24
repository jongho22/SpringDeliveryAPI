package com.example.session.controller;

import com.example.session.model.LoginRequest;
import com.example.session.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccoundApiController {

    private final UserService userService;

    @PostMapping("/login")
    public void login(
            @RequestBody
            LoginRequest loginRequest,

            // Spring에서 자동으로 해당 요청에 대한 세션을 생성
            HttpSession httpSession
    ){
        userService.login(loginRequest, httpSession);
    }
}
