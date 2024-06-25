package com.example.validation.model;

import java.util.Objects;

import com.example.validation.annotaion.PhoneNumber;
import com.example.validation.annotaion.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

    //    @NotNull // NULL을 허용하지 않음
    //    @NotEmpty // NULL도 아니고 빈 텍스트도 아니여야함
    //    @NotBlank // NULL도 아니고 빈 텍스트도 아니고 공백(스페이스 바)도 아님

    private String name;

    private String nickName;

    @Size(min = 1, max = 12) // 최소와 최대 텍스트 길이 설정 (정수형은 안됨)
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\\$") // 패턴 => 정규식 사용
    @PhoneNumber
    private String phoneNumber;

    @YearMonth
    private String birthday;

    @FutureOrPresent // 현재 시간 또는 그 이상
    private LocalDateTime registerAt;

    @AssertTrue(message = "name or nickName은 반드시 1개가 존재해야 합니다.") // 해당 리턴이 true일때 실행
    public boolean isNameCheck() { // 반드시 is라는 매소드를 붙여줘야함

        if (Objects.nonNull(name) && !name.isBlank()) {
            return true;
        }

        if (Objects.nonNull(nickName) && !nickName.isBlank()) {
            return true;
        }

        return false;
    }
}
