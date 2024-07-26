package com.example.restapi.controller;

import com.example.restapi.model.BookRequest;
import com.example.restapi.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public BookRequest post(
            @RequestBody BookRequest bookRequest // request 바디의 데이터를 BookRequest에 매핑
            ){
        System.out.println("[PostApiController] POST => post(BookRequest) ]");
        System.out.println("bookRequest = {}" + bookRequest);

        return bookRequest;
    }

    @PostMapping("/user")
    public UserRequest User(
            @RequestBody UserRequest userRequest
    ){
        System.out.println("[PostApiController] POST => user(UserRequest) ");
        System.out.println("userRequest = {}" + userRequest);

        return userRequest;
    }
}
