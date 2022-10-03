package com.hepsi.interview.service.campaign.mapper;

import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.campaign.data.entity.IncreaseEntity;
import com.hepsi.interview.service.campaign.dto.CreateIncreaseDto;
import com.hepsi.interview.service.campaign.dto.IncreaseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-03T17:31:44+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class IncreaseMapperImpl implements IncreaseMapper {

    @Override
    public IncreaseDto toDto(IncreaseEntity increaseEntity) {
        if ( increaseEntity == null ) {
            return null;
        }

        IncreaseDto increaseDto = new IncreaseDto();

        increaseDto.id = increaseEntity.id;
        increaseDto.time = increaseEntity.time;
        increaseDto.price = increaseEntity.price;

        return increaseDto;
    }

    @Override
    public List<IncreaseDto> toDtos(List<IncreaseEntity> increaseEntities) {
        if ( increaseEntities == null ) {
            return null;
        }

        List<IncreaseDto> list = new ArrayList<IncreaseDto>( increaseEntities.size() );
        for ( IncreaseEntity increaseEntity : increaseEntities ) {
            list.add( toDto( increaseEntity ) );
        }

        return list;
    }

    @Override
    public IncreaseEntity toEntity(CreateIncreaseDto createIncreaseDto) {
        if ( createIncreaseDto == null ) {
            return null;
        }

        IncreaseEntity increaseEntity = new IncreaseEntity();

        increaseEntity.campaign = createIncreaseDtoToCampaignEntity( createIncreaseDto );
        increaseEntity.time = createIncreaseDto.time;
        increaseEntity.price = createIncreaseDto.price;

        return increaseEntity;
    }

    protected CampaignEntity createIncreaseDtoToCampaignEntity(CreateIncreaseDto createIncreaseDto) {
        if ( createIncreaseDto == null ) {
            return null;
        }

        CampaignEntity campaignEntity = new CampaignEntity();

        campaignEntity.id = createIncreaseDto.campaignId;

        return campaignEntity;
    }
}
