package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.MyResult;
import com.atguigu.springcloud.entities.Order;
import com.atguigu.springcloud.mapper.OrderMapper;
import com.atguigu.springcloud.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceimpl implements OrderService {
    @Autowired
    private OrderMapper OrderMapper;

    @Override
    public MyResult<List<Order>> FindAllOrder() {


        return  new MyResult<List<Order>>(200,"sucess",OrderMapper.FindAllOrder());
    }
}
