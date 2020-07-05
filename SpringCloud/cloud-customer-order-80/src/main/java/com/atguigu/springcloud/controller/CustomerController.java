package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.MyResult;
import com.atguigu.springcloud.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    public static String URL="http://localhost:8624";
@Autowired
private RestTemplate RestTemplate;
@PostMapping("/register")
    public MyResult<Order> register(@RequestBody  Order order){
    return  RestTemplate.postForObject(URL+"/Order/InsertOrder",order,MyResult.class);
}
}
