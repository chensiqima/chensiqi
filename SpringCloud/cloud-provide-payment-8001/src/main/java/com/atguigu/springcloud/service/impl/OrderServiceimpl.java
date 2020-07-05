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
        List<Order> list=OrderMapper.FindAllOrder();
        if (list!=null){
            return  new MyResult<List<Order>>(200,"sucess",OrderMapper.FindAllOrder());
        }else {
            return  new MyResult<List<Order>>(400,"fail");
        }



    }

    @Override
    public MyResult<String> InsertOrder(Order order) {
        System.out.println("order = " + order);
        int num=OrderMapper.InsertOrder(order);
        if (num>0){
            return new MyResult<>(0,"注册成功");
        }else {
            return new MyResult<>(1,"注册失败");
        }
    }
}
