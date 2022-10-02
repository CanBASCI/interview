package com.hepsi.interview.service.order.operation;

import com.hepsi.interview.service.order.data.OrderRepository;
import com.hepsi.interview.service.order.data.entity.OrderEntity;
import com.hepsi.interview.service.order.dto.CreateOrderDto;
import com.hepsi.interview.service.order.dto.OrderDto;
import com.hepsi.interview.service.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderOperation {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    public List<OrderDto> getAllOrders(){

        return orderMapper.toDtos(orderRepository.findAll());
    }

    public OrderDto createOrder(CreateOrderDto createOrderDto){
        OrderEntity orderEntity = orderRepository.save(orderMapper.toEntity(createOrderDto));
        return orderMapper.toDto(orderEntity);
    }
}
