package com.example.session.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto {

    private String name;
    private String passwoard;
}
