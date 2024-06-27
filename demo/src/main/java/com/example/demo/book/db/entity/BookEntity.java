package com.example.demo.book.db.entity;

import com.example.demo.entity.Entity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity extends Entity {

    private String name;

    private String category;

    private BigDecimal amount;
}
