package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> FindAllOrder();
}
