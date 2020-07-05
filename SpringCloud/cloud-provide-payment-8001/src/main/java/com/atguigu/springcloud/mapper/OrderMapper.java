package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entities.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderMapper {
    List<Order> FindAllOrder();

    Integer InsertOrder(@Param("order") Order order);
}
