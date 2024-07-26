package com.example.validation.validator;

import com.example.validation.annotaion.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Slf4j
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> { // 어노테이션 상속

    private String regexp;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) { // String = 사용자 입력값
        System.out.println("Validating: " + value);
        boolean result = Pattern.matches(regexp, value);// 매칭 되는지 검사
        log.info("isValid : {}", result);
        return result;
    }
}
