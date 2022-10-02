package com.hepsi.interview.service.campaign.operation;

import com.hepsi.interview.service.campaign.data.IncreaseRepository;
import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.campaign.dto.CreateIncreaseDto;
import com.hepsi.interview.service.campaign.mapper.CampaignMapper;
import com.hepsi.interview.service.campaign.data.CampaignRepository;
import com.hepsi.interview.service.campaign.dto.CampaignDto;
import com.hepsi.interview.service.campaign.dto.CreateCampaignDto;
import com.hepsi.interview.service.campaign.mapper.IncreaseMapper;
import com.hepsi.interview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CampaignOperation {
    @Autowired
    CampaignRepository campaignRepository;
    @Autowired
    IncreaseRepository increaseRepository;
    @Autowired
    CampaignMapper campaignMapper;
    @Autowired
    IncreaseMapper increaseMapper;

    public List<CampaignDto> getAllCampaign(){
        return campaignMapper.toDtos(campaignRepository.findAll());
    }

    public CampaignDto getCampaignInfo(String name){
        return campaignMapper.toDto(campaignRepository.findByName(name));
    }

    public CampaignDto createCampaign(CreateCampaignDto createCampaignDto){
        return campaignMapper.toDto(campaignRepository.save(campaignMapper.toEntity(createCampaignDto)));
    }

    public CampaignDto createCampaignIncrease(CreateIncreaseDto createIncreaseDto) throws Exception {
        increaseRepository.save(increaseMapper.toEntity(createIncreaseDto));
        CampaignEntity campaignEntity = campaignRepository.findById(createIncreaseDto.campaignId).orElseThrow(() -> new Exception("campaign not found" ));
        campaignEntity.status = Status.ACTIVE;
        return campaignMapper.toDto(campaignRepository.save(campaignEntity));
    }
}
