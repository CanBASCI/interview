package com.hepsi.interview.service.order.mapper;

import com.hepsi.interview.service.order.data.entity.OrderEntity;
import com.hepsi.interview.service.order.dto.CreateOrderDto;
import com.hepsi.interview.service.order.dto.OrderDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-01T14:59:30+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto toDto(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.productCode = orderEntity.productCode;

        return orderDto;
    }

    @Override
    public List<OrderDto> toDtos(List<OrderEntity> orderEntities) {
        if ( orderEntities == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( orderEntities.size() );
        for ( OrderEntity orderEntity : orderEntities ) {
            list.add( toDto( orderEntity ) );
        }

        return list;
    }

    @Override
    public OrderEntity toEntity(CreateOrderDto createOrderDto) {
        if ( createOrderDto == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.productCode = createOrderDto.productCode;

        return orderEntity;
    }
}
