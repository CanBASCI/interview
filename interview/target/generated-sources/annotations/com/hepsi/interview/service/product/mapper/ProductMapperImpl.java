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
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-03T21:58:18+0300",
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

        productDto.setId( productEntity.getId() );
        productDto.setProductCode( productEntity.getProductCode() );
        productDto.setPrice( productEntity.getPrice() );
        productDto.setStock( productEntity.getStock() );
        productDto.setOrders( orderEntitySetToOrderDtoList( productEntity.getOrders() ) );
        productDto.setCampaigns( campaignEntitySetToCampaignDtoList( productEntity.getCampaigns() ) );

        return productDto;
    }

    @Override
    public OrderDto orderEntityToOrderDto(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( orderEntity.getId() );
        orderDto.setPrice( orderEntity.getPrice() );
        orderDto.setCampaignId( orderEntity.getCampaignId() );
        orderDto.setQuantity( orderEntity.getQuantity() );

        return orderDto;
    }

    @Override
    public CampaignDto campaignEntityToCampaignDto(CampaignEntity campaignEntity) {
        if ( campaignEntity == null ) {
            return null;
        }

        CampaignDto campaignDto = new CampaignDto();

        campaignDto.setId( campaignEntity.getId() );
        campaignDto.setName( campaignEntity.getName() );
        campaignDto.setDuration( campaignEntity.getDuration() );
        campaignDto.setPriceManLimit( campaignEntity.getPriceManLimit() );
        campaignDto.setTargetSalesCount( campaignEntity.getTargetSalesCount() );
        campaignDto.setTotalSales( campaignEntity.getTotalSales() );
        campaignDto.setFormula( campaignEntity.getFormula() );
        campaignDto.setStatus( campaignEntity.getStatus() );
        campaignDto.setIncreases( increaseEntitySetToIncreaseDtoList( campaignEntity.getIncreases() ) );

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

        productEntity.setProductCode( createProductDto.getProductCode() );
        productEntity.setPrice( createProductDto.getPrice() );
        productEntity.setStock( createProductDto.getStock() );

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

        increaseDto.setId( increaseEntity.getId() );
        increaseDto.setTime( increaseEntity.getTime() );
        increaseDto.setPrice( increaseEntity.getPrice() );

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
