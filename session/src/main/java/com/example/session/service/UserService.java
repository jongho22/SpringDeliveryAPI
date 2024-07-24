package com.example.session.service;

import com.example.session.db.UserRepository;
import com.example.session.model.LoginRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 로그인
    public void login(
            LoginRequest loginRequest,
            HttpSession httpSession
    ){
        var id = loginRequest.getId();
        var password = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id);

        if (optionalUser.isPresent()) {
            var userDto = optionalUser.get();

            if(userDto.getPasswoard().equals(password)){
                // 세션 정보저장
                httpSession.setAttribute("user", userDto);
            }else{
                // 패스워드 틀림
                throw new RuntimeException("Passwords do not match");
            }

        }else {
            // id가 존재하지 않음
            throw new RuntimeException("User Not Found");
        }


    }
}
