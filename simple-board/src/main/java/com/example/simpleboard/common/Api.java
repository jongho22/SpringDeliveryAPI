package com.example.simpleboard.common;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Api<T> {

    private T body;

    private Pagination pagination;
}
