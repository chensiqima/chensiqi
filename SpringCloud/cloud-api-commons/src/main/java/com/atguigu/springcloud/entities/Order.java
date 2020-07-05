package com.atguigu.springcloud.entities;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;

    private Double money;

    private String username;
}