package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController // 컨트롤 클래스 지정
@RequestMapping("/api") // 컨드롤러의 주소 설정
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello World!";
    }

    // PathVariable => 데이터 전달 방식

    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable(name="message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ){ // 인자 전달 @PathVariable
        System.out.println("[RestApiController] GET (echo)");
        System.out.println("msg = " + msg);
        System.out.println("age = " + age);
        System.out.println("isMan = " + isMan);
        return msg;
    }

    // Quary Parameter => 특정 정보의 필터링을 걸때 사용, ?으로 시작하고 이어주는 형태는 &로 묶어준다.
    @GetMapping("/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name="issued-month") String issuedMonth,
            @RequestParam(name="issued-day") String issuedDay
    ){
        System.out.println("[RestApiController] GET (queryParam)");
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    @GetMapping("/book2")
    public void queryParamDto( // DTO(Data Transfer Object)
            BookQueryParam bookQueryParam
    ){
        System.out.println("[RestApiController] GET (queryParamDto)");
        System.out.println(bookQueryParam);
    }

    @DeleteMapping(path={
            "/user/{userName}/delete",
            "/user/{userName}/del"
        }
    )
    public void delete(
            @PathVariable String userName
    ){
        log.info("[RestApiController] DELETE -> delete(userName)");
        log.info("user-name : {} ", userName);
    }
}


