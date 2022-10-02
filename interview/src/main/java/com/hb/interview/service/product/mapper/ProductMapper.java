package com.hb.interview.service.product.mapper;

import com.hb.interview.service.campaign.data.entity.CampaignEntity;
import com.hb.interview.service.campaign.dto.CampaignDto;
import com.hb.interview.service.order.data.entity.OrderEntity;
import com.hb.interview.service.order.dto.OrderDto;
import com.hb.interview.service.product.data.entity.ProductEntity;
import com.hb.interview.service.product.dto.CreateProductDto;
import com.hb.interview.service.product.dto.ProductDto;
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
