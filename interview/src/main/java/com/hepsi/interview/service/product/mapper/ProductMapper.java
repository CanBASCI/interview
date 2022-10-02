package com.hepsi.interview.service.product.mapper;

import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.campaign.dto.CampaignDto;
import com.hepsi.interview.service.order.data.entity.OrderEntity;
import com.hepsi.interview.service.order.dto.OrderDto;
import com.hepsi.interview.service.product.data.entity.ProductEntity;
import com.hepsi.interview.service.product.dto.CreateProductDto;
import com.hepsi.interview.service.product.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;
@Mapper(componentModel="spring")
public interface ProductMapper {
    @Mapping(target = "campaigns.product", ignore = true)
    @Mapping(target = "orders.product", ignore = true)
    @Mapping(target = "orders.product.orders", ignore = true)
    @Mapping(target = "orders.product.campaigns", ignore = true)
    ProductDto toDto(ProductEntity productEntity);

    @Mapping(target = "product", ignore = true)
    OrderDto orderEntityToOrderDto(OrderEntity orderEntity);
    @Mapping(target = "product", ignore = true)
    CampaignDto campaignEntityToCampaignDto(CampaignEntity campaignEntity);
    List<ProductDto> toDtos(List<ProductEntity> productEntities);
    ProductEntity toEntity(CreateProductDto createProductDto);
}
