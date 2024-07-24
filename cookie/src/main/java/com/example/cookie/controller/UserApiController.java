package com.example.cookie.controller;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.UserDto;
import com.example.cookie.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    private final UserRepository userRepository;

    @GetMapping("/me")
    public UserDto me(
            HttpServletRequest httpServletRequest,

            @CookieValue(name = "authorization" ,required = false)
            String authorizationCookie
    ){
        log.info("authorizationCookie: {}", authorizationCookie);
        var optionalUserDto = userRepository.findById(authorizationCookie);
        return optionalUserDto.get();
//        var cookies = httpServletRequest.getCookies();
//
//        for (var cookie : cookies) {
//            log.info("key : {}, value : {}", cookie.getName(), cookie.getValue());
//        }
//        return null;
    }

    @GetMapping("/me2")
    public UserDto me2(
            @RequestHeader(name = "authorization", required = false)
            String authorizationHeader
    ) {
        log.info("authorizationHeader: {}", authorizationHeader);
        var optionalUserDto = userRepository.findById(authorizationHeader);
        return optionalUserDto.get();
    }
}
