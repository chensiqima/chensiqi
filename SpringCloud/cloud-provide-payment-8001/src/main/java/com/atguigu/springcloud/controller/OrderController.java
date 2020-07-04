package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.MyResult;
import com.atguigu.springcloud.entities.Order;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService OrderService;
@PostMapping("/FindAllOrder")
    public MyResult<List<Order>> FindAllOrder(){


    return OrderService.FindAllOrder();
}
}
