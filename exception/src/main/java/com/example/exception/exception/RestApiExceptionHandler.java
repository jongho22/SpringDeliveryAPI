package com.example.exception.exception;

import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice(basePackages = "com.example.exception.controller") // 특정 패키지 지정 => 글로벌적으로 동작안하게 됨
@Order(1)
public class RestApiExceptionHandler {

//    @ExceptionHandler(value = {Exception.class}) // 글로벌적으로 모든 예외를 잡음
//    public ResponseEntity exception(Exception e){
//        log.error("RestApiExceptionHandler", e);
//
//        return ResponseEntity.status(200).build();
//    }

    @ExceptionHandler(value = {IndexOutOfBoundsException.class}) // 글로벌 특정 예외 처리
    public ResponseEntity outOfBound(IndexOutOfBoundsException e){
        log.error("IndexOutOfBoundsException", e);

        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Api> noSuchElement(NoSuchElementException e){
        log.error("NoSuchElementException", e);

        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
