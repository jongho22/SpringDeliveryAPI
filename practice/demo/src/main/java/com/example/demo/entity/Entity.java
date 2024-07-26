package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// 추상 메소드(abstract method)란 자식 클래스에서 반드시 오버라이딩해야만 사용할 수 있는 메소드
//@Data
public abstract class Entity implements PrimaryKey{

    @Getter
    @Setter
    private Long id;
}
