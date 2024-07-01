package com.example.demo.user.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 데이터베이스의 관리 규칙을 따름
    private Long id;

    private String name;

    private Integer score;
}
