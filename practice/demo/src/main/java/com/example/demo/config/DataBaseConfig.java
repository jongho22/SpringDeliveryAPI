package com.example.demo.config;

import com.example.demo.user.db.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration // 스프링에게 설정 파일이라는 것을 알려줌
//public class DataBaseConfig {
//
//    @Bean // 빈으로 등록 되면서 spring에 의해 관리됨, 필요한 곳에 자동 주입.
//    public UserRepository userRepository(){
//        return new UserRepository();
//    }
//}
