package com.example.demo.user.service;

import com.example.demo.user.db.UserRepository;
import com.example.demo.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // 서비스가 들어가는 빈의 영역이다.
//@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository; // config를 통해 레파지토리를 빈 등록을 하지 않으면 에러 발생.

    // save
    public UserEntity save(UserEntity userEntity){
        return userRepository.save(userEntity);
    };

    // read
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    // delete
    public void delete(Long id){
        userRepository.delete(id);
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    public List<UserEntity> filterUser(int score){
        return userRepository.findALlScoreGreaterThan(score);
    }
}
