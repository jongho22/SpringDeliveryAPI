package com.example.filter.aop;

import com.example.filter.model.UserRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TimerAop {

    @Pointcut(value = "within(com.example.filter.controller.UserApiController)")
    public void timerPointCut(){}

    @Before(value = "timerPointCut()") // 매소드 실행전
    public void before(JoinPoint joinPoint){
        System.out.println("before");
    }

    @After(value = "timerPointCut()") // 실행후
    public void after(JoinPoint joinPoint){
        System.out.println("after");
    }

    @AfterReturning(value = "timerPointCut()", returning = "result") // 예외가 발생하지 않았을 경우
    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println("after returning");
    }

    @AfterThrowing(value = "timerPointCut()", throwing = "tx") // 예외가 발생했을 경우
    public void afterThrowing(JoinPoint joinPoint, Throwable tx){
        System.out.println("after throwing");
    }

    @Around(value = "timerPointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("메소드 실행 이전");

        Arrays.stream(joinPoint.getArgs()).forEach(
                it-> {
                    if(it instanceof UserRequest){
                        var tempUser = (UserRequest) it;
                        var phonNumber = tempUser.getPhoneNumber().replace("-","");
                        tempUser.setPhoneNumber(phonNumber);
                    }
                }
        );

        joinPoint.proceed();

        System.out.println("메소드 실향 이후");
    }
}
