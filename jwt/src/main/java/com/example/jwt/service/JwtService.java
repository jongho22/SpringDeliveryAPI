package com.example.jwt.service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;

@Slf4j
@Service
public class JwtService {

    private static String secretKey = "java11SpringBootJWTTokenIssueMethod";

    // token 생성
    public String create(
            Map<String, Object> claims, // 클레임?
            LocalDateTime expireAt // 만료일자
    ){
        var key = Keys.hmacShaKeyFor(secretKey.getBytes());
        var _expireAt = Date.from(expireAt.atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256) // 서명 키, 알고리즘 등록
                .setClaims(claims)
                .setExpiration(_expireAt)
                .compact();
    }

    public void validation(
            String token
    ){
        var key = Keys.hmacShaKeyFor(secretKey.getBytes());

        var parser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();
        try {
            var result = parser.parseClaimsJws(token);

            result.getBody().entrySet().forEach(value->
                    log.info("key : {}, value : {}", value.getKey(), value.getValue())
            );
        } catch (Exception e){
            if (e instanceof SignatureException){
                throw new RuntimeException("JWT Token 서명 오류");
            } else if (e instanceof ExpiredJwtException) {
                throw new RuntimeException("JWT Token 인증 시간 만료");
            } else {
                throw new RuntimeException("JWT Token 인증 오류");
            }
        }


    }
}
