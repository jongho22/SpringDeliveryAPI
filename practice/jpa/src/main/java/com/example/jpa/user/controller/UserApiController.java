package com.example.jpa.user.controller;

import com.example.jpa.user.db.UserEntity;
import com.example.jpa.user.db.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/findall")
    public List<UserEntity> findall(){
        return userRepository.findAll();
    }

    @GetMapping("/name")
    public void autoSave(
            @RequestParam String name
    ){
        var user = UserEntity.builder().name(name).build();

        userRepository.save(user);
    }

}
