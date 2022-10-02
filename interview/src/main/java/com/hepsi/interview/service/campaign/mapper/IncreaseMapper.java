package com.hepsi.interview.service.campaign.mapper;

import com.hepsi.interview.service.campaign.data.entity.IncreaseEntity;
import com.hepsi.interview.service.campaign.dto.CreateIncreaseDto;
import com.hepsi.interview.service.campaign.dto.IncreaseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface IncreaseMapper {

    IncreaseDto toDto(IncreaseEntity increaseEntity);

    List<IncreaseDto> toDtos(List<IncreaseEntity> increaseEntities);

    @Mapping(target = "campaign.id", source = "campaignId")
    IncreaseEntity toEntity(CreateIncreaseDto createIncreaseDto);
}
