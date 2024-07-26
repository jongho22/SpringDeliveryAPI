package com.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) // 요청이 스네이크 케이스 형식으로 들어오면 자동으로 변수에 매핑, 응답도 자동적으로 처리됨
public class UserRequest {
    private String userName;
    private Integer userAge;
    private String email;
    // @JsonProperty("KOEAN") // 커스텀 명칭으로 매핑
    private Boolean isKorean;
}
