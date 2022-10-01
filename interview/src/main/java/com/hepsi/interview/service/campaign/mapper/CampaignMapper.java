package com.hepsi.interview.service.campaign.mapper;

import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.campaign.dto.CampaignDto;
import com.hepsi.interview.service.campaign.dto.CreateCampaignDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface CampaignMapper {

    CampaignDto toDto(CampaignEntity campaignEntity);
    List<CampaignDto> toDtos(List<CampaignEntity> campaignEntities);

    CampaignEntity toEntity(CreateCampaignDto createCampaignDto);
}
