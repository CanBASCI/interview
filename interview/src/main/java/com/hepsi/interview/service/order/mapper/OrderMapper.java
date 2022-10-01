package com.hepsi.interview.service.order.mapper;

import com.hepsi.interview.service.order.data.entity.OrderEntity;
import com.hepsi.interview.service.order.dto.CreateOrderDto;
import com.hepsi.interview.service.order.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface OrderMapper {

    //@Mapping(target = "productCode", source = "product.productCode")
    @Mapping(target = "product.orders", ignore = true)
    @Mapping(target = "product.campaigns", ignore = true)
    OrderDto toDto(OrderEntity orderEntity);

    List<OrderDto> toDtos(List<OrderEntity> orderEntities);

    OrderEntity toEntity(CreateOrderDto createOrderDto);
}
