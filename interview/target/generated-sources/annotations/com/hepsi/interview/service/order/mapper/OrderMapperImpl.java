package com.hepsi.interview.service.order.mapper;

import com.hepsi.interview.service.order.data.entity.OrderEntity;
import com.hepsi.interview.service.order.dto.CreateOrderDto;
import com.hepsi.interview.service.order.dto.OrderDto;
import com.hepsi.interview.service.product.data.entity.ProductEntity;
import com.hepsi.interview.service.product.dto.ProductDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-03T21:58:19+0300",
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

        orderDto.setId( orderEntity.getId() );
        orderDto.setProduct( productEntityToProductDto( orderEntity.getProduct() ) );
        orderDto.setPrice( orderEntity.getPrice() );
        orderDto.setCampaignId( orderEntity.getCampaignId() );
        orderDto.setQuantity( orderEntity.getQuantity() );

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

        orderEntity.setProduct( createOrderDtoToProductEntity( createOrderDto ) );
        orderEntity.setQuantity( createOrderDto.getQuantity() );
        orderEntity.setPrice( createOrderDto.getPrice() );
        orderEntity.setCampaignId( createOrderDto.getCampaignId() );

        return orderEntity;
    }

    protected ProductDto productEntityToProductDto(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( productEntity.getId() );
        productDto.setProductCode( productEntity.getProductCode() );
        productDto.setPrice( productEntity.getPrice() );
        productDto.setStock( productEntity.getStock() );

        return productDto;
    }

    protected ProductEntity createOrderDtoToProductEntity(CreateOrderDto createOrderDto) {
        if ( createOrderDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( createOrderDto.getProductId() );

        return productEntity;
    }
}
