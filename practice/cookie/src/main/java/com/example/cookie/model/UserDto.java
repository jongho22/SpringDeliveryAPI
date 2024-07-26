package com.example.cookie.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDto {

    private String id;

    private String name;

    private String password;
}
