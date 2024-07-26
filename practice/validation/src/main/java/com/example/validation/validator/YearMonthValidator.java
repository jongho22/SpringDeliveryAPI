package com.example.validation.validator;

import com.example.validation.annotaion.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String regexp;

    public void initialize(YearMonth constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        var reValue = s + "01";
        var rePattern = regexp + "dd";
        try {

            LocalDate date = LocalDate.parse(reValue, DateTimeFormatter.ofPattern(rePattern));
            System.out.println(date);
//            boolean result = Pattern.matches(regexp, s);
        }catch (Exception e) {
            return false;
        }

        return true;
    }
}
