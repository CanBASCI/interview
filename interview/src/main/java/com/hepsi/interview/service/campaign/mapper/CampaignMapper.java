package com.hepsi.interview.service.campaign.mapper;

import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.campaign.dto.CampaignDto;
import com.hepsi.interview.service.campaign.dto.CreateCampaignDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface CampaignMapper {

    //@Mapping(target = "productCode", source = "product.productCode")
    @Mapping(target = "product.orders", ignore = true)
    @Mapping(target = "product.campaigns", ignore = true)
    CampaignDto toDto(CampaignEntity campaignEntity);
    List<CampaignDto> toDtos(List<CampaignEntity> campaignEntities);

    @Mapping(target = "product.id", source = "productId")
    @Mapping(target = "status", defaultValue = "PASSIVE")
    CampaignEntity toEntity(CreateCampaignDto createCampaignDto);
}
