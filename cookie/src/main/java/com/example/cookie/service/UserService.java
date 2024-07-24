package com.example.cookie.service;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.LoginRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void login(
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse
    ) {
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id);

        if (optionalUser.isPresent()) {
            var userDto = optionalUser.get();

            if(userDto.getPassword().equals(pw)) {
                // 쿠키 해당 정보를 저장
                var cookie = new Cookie("authorization", userDto.getId());
                cookie.setDomain("localhost");
                cookie.setPath("/");
                cookie.setHttpOnly(true); // 보안 처리 => 브라우저에서 읽을 수 없음
//                cookie.setSecure(true); // https에서만 작동하도록 설정
                cookie.setMaxAge(-1); // session과 동일 탭 닫히기 전까지  (접속시간)

                httpServletResponse.addCookie(cookie);
            } else {
                throw new RuntimeException("비밀번호가 틀렸습니다.");
            }
        } else{
            throw new RuntimeException("유저가 없습니다.");
        }

    }
}
