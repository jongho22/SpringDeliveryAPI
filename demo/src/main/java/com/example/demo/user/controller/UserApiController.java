package com.example.demo.user.controller;

import com.example.demo.entity.Entity;
import com.example.demo.user.model.UserEntity;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Controller // HTTP 리퀘스트가 들어오는 내용을 처리하고 리스폰스를 처리하는 영영
@RequestMapping("/api/user")
@RequiredArgsConstructor // 서비스 등록 시, 생성자 매서드로 채워주는 역할. 스프링으로 부터 UserService를 주입 받음
public class UserApiController {

    private final UserService userService;

    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity
    ){
        return userService.save(userEntity);
    };

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public void delete(
            @PathVariable Long id
    ){
        userService.delete(id);
    }

    @GetMapping("/id/{id}")
    public UserEntity findOne(
            @PathVariable Long id
    ){
        var response = userService.findById(id);
        return response.get();
    }

    @GetMapping("/score")
    public List<UserEntity> filterUser(
        @RequestParam int score
    ){
        return userService.filterUser(score);
    }

}
