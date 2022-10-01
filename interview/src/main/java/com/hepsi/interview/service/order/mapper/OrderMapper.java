package com.hepsi.interview.service.order.mapper;

import com.hepsi.interview.service.order.data.entity.OrderEntity;
import com.hepsi.interview.service.order.dto.CreateOrderDto;
import com.hepsi.interview.service.order.dto.OrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface OrderMapper {

    OrderDto toDto(OrderEntity orderEntity);

    List<OrderDto> toDtos(List<OrderEntity> orderEntities);

    OrderEntity toEntity(CreateOrderDto createOrderDto);
}
