package com.hepsi.interview.controller;

import com.hepsi.interview.service.order.dto.CreateOrderDto;
import com.hepsi.interview.service.order.dto.OrderDto;
import com.hepsi.interview.service.order.operation.OrderOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    OrderOperation orderOperation;

    @GetMapping("/getAllOrders")
    List<OrderDto> getAllOrders(){
        return orderOperation.getAllOrders();
    }

    @PostMapping("/createOrder")
    OrderDto createOrder(@RequestBody CreateOrderDto createOrderDto) throws Exception {
        return orderOperation.createOrder(createOrderDto);
    }
}
