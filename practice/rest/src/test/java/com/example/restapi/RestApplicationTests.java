package com.example.restapi;

import com.example.restapi.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApplicationTests {

    @Autowired // 스프링에서 관리하는 빈들 중에 자동으로 생성되는 오브젝트 매퍼를 가져오겠다.
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() throws JsonProcessingException {
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(20);
        user.setEmail("sjh0804_22@naver.com");
        user.setIsKorean(true);

        // 직렬화
        var json = objectMapper.writeValueAsString(user);
        System.out.println("json = " + json);

        // 역직렬화
        var dto = objectMapper.readValue(json, UserRequest.class);
        System.out.println("dto = " + dto);

    }

}
