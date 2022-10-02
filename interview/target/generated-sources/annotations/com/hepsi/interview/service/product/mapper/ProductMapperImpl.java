package com.hepsi.interview.service.product.mapper;

import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.campaign.data.entity.IncreaseEntity;
import com.hepsi.interview.service.campaign.dto.CampaignDto;
import com.hepsi.interview.service.campaign.dto.IncreaseDto;
import com.hepsi.interview.service.order.data.entity.OrderEntity;
import com.hepsi.interview.service.order.dto.OrderDto;
import com.hepsi.interview.service.product.data.entity.ProductEntity;
import com.hepsi.interview.service.product.dto.CreateProductDto;
import com.hepsi.interview.service.product.dto.ProductDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-02T13:41:23+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.id = productEntity.id;
        productDto.productCode = productEntity.productCode;
        productDto.price = productEntity.price;
        productDto.stock = productEntity.stock;
        productDto.orders = orderEntitySetToOrderDtoList( productEntity.orders );
        productDto.campaigns = campaignEntitySetToCampaignDtoList( productEntity.campaigns );

        return productDto;
    }

    @Override
    public OrderDto orderEntityToOrderDto(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.id = orderEntity.id;
        orderDto.quantity = orderEntity.quantity;

        return orderDto;
    }

    @Override
    public CampaignDto campaignEntityToCampaignDto(CampaignEntity campaignEntity) {
        if ( campaignEntity == null ) {
            return null;
        }

        CampaignDto campaignDto = new CampaignDto();

        campaignDto.id = campaignEntity.id;
        campaignDto.name = campaignEntity.name;
        campaignDto.duration = campaignEntity.duration;
        campaignDto.priceManLimit = campaignEntity.priceManLimit;
        campaignDto.targetSalesCount = campaignEntity.targetSalesCount;
        campaignDto.totalSales = campaignEntity.totalSales;
        campaignDto.status = campaignEntity.status;
        campaignDto.increases = increaseEntitySetToIncreaseDtoList( campaignEntity.increases );

        return campaignDto;
    }

    @Override
    public List<ProductDto> toDtos(List<ProductEntity> productEntities) {
        if ( productEntities == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( productEntities.size() );
        for ( ProductEntity productEntity : productEntities ) {
            list.add( toDto( productEntity ) );
        }

        return list;
    }

    @Override
    public ProductEntity toEntity(CreateProductDto createProductDto) {
        if ( createProductDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.productCode = createProductDto.productCode;
        productEntity.price = createProductDto.price;
        productEntity.stock = createProductDto.stock;

        return productEntity;
    }

    protected List<OrderDto> orderEntitySetToOrderDtoList(Set<OrderEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( set.size() );
        for ( OrderEntity orderEntity : set ) {
            list.add( orderEntityToOrderDto( orderEntity ) );
        }

        return list;
    }

    protected List<CampaignDto> campaignEntitySetToCampaignDtoList(Set<CampaignEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<CampaignDto> list = new ArrayList<CampaignDto>( set.size() );
        for ( CampaignEntity campaignEntity : set ) {
            list.add( campaignEntityToCampaignDto( campaignEntity ) );
        }

        return list;
    }

    protected IncreaseDto increaseEntityToIncreaseDto(IncreaseEntity increaseEntity) {
        if ( increaseEntity == null ) {
            return null;
        }

        IncreaseDto increaseDto = new IncreaseDto();

        increaseDto.id = increaseEntity.id;
        increaseDto.time = increaseEntity.time;

        return increaseDto;
    }

    protected List<IncreaseDto> increaseEntitySetToIncreaseDtoList(Set<IncreaseEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<IncreaseDto> list = new ArrayList<IncreaseDto>( set.size() );
        for ( IncreaseEntity increaseEntity : set ) {
            list.add( increaseEntityToIncreaseDto( increaseEntity ) );
        }

        return list;
    }
}
