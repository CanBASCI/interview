package com.hb.interview.service.campaign.mapper;

import com.hb.interview.service.campaign.data.entity.CampaignEntity;
import com.hb.interview.service.campaign.dto.CampaignDto;
import com.hb.interview.service.campaign.dto.CreateCampaignDto;
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

    CampaignEntity toEntity(CreateCampaignDto createCampaignDto);
}
