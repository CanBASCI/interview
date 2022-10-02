package com.hb.interview.service.campaign.operation;

import com.hb.interview.service.campaign.mapper.CampaignMapper;
import com.hb.interview.service.campaign.data.CampaignRepository;
import com.hb.interview.service.campaign.data.entity.CampaignEntity;
import com.hb.interview.service.campaign.dto.CampaignDto;
import com.hb.interview.service.campaign.dto.CreateCampaignDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CampaignOperation {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignMapper campaignMapper;

    public List<CampaignDto> getAllCampaign(){
        return campaignMapper.toDtos(campaignRepository.findAll());
    }

    public CampaignDto getCampaignInfo(String name){
        return campaignMapper.toDto(campaignRepository.findByName(name));
    }

    public CampaignDto createCampaign(CreateCampaignDto createCampaignDto){
        CampaignEntity campaignEntity = campaignRepository.save(campaignMapper.toEntity(createCampaignDto));
        return campaignMapper.toDto(campaignEntity);
    }
}
