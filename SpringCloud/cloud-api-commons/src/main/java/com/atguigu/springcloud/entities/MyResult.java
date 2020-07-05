package com.atguigu.springcloud.entities;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MyResult<T> {

    private Integer code;
    private String message;
    private  T     data;

    public MyResult(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }
}
