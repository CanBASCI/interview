package com.hepsi.interview.service.campaign.operation;

import com.hepsi.interview.service.campaign.data.IncreaseRepository;
import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.campaign.data.entity.IncreaseEntity;
import com.hepsi.interview.service.campaign.dto.CreateIncreaseDto;
import com.hepsi.interview.service.campaign.dto.IncreaseDto;
import com.hepsi.interview.service.campaign.mapper.CampaignMapper;
import com.hepsi.interview.service.campaign.data.CampaignRepository;
import com.hepsi.interview.service.campaign.dto.CampaignDto;
import com.hepsi.interview.service.campaign.dto.CreateCampaignDto;
import com.hepsi.interview.service.campaign.mapper.IncreaseMapper;
import com.hepsi.interview.utils.Status;
import com.hepsi.interview.utils.calculate.IFormula;
import com.hepsi.interview.utils.error.ResourceBadRequestException;
import com.hepsi.interview.utils.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CampaignOperation {
    @Autowired
    CampaignRepository campaignRepository;
    @Autowired
    IncreaseRepository increaseRepository;
    @Autowired
    CampaignMapper campaignMapper;
    @Autowired
    IncreaseMapper increaseMapper;

    @Autowired
    @Qualifier(value = "First")
    IFormula AFormula;

    @Autowired
    @Qualifier(value = "Second")
    IFormula BFormula;

    public List<CampaignDto> getAllCampaign(){
        return campaignMapper.toDtos(campaignRepository.findAll());
    }

    public CampaignDto getCampaignInfo(String name){
        return campaignMapper.toDto(campaignRepository.findByName(name));
    }

    public CampaignDto createCampaign(CreateCampaignDto createCampaignDto){
        return campaignMapper.toDto(campaignRepository.save(campaignMapper.toEntity(createCampaignDto)));
    }

    public IncreaseDto createIncrease(CreateIncreaseDto createIncreaseDto) throws Exception {
        CampaignEntity campaignEntity = campaignRepository.findById(createIncreaseDto.getCampaignId()).orElseThrow(() -> new ResourceNotFoundException("campaign not found." + "id: " + createIncreaseDto.getCampaignId().toString()));

        validationStatus(campaignEntity);

        BigDecimal minManLimit = minManLimit(campaignEntity);
        BigDecimal maxManLimit = maxManLimit(campaignEntity);

        int maxTime = 0;
        if(campaignEntity.getIncreases().size() > 0) {
             maxTime = campaignEntity.getIncreases().stream().mapToInt(IncreaseEntity::getTime).max().orElseThrow(NoSuchElementException::new);
        }

        createIncreaseDto.setTime(maxTime + createIncreaseDto.getTime());

        if(createIncreaseDto.getTime() > campaignEntity.getDuration()){
            createIncreaseDto.setPrice(campaignEntity.getProduct().getPrice());
            campaignEntity.setStatus(Status.PASSIVE);
        }
        else {
            BigDecimal currentPrice;
            switch (campaignEntity.getFormula()) {
                case A:
                    currentPrice = AFormula.getPrice(campaignEntity);
                    createIncreaseDto.setPrice(currentPrice);
                    break;
                case B:
                    currentPrice = BFormula.getPrice(campaignEntity);
                    createIncreaseDto.setPrice(currentPrice);
                    break;
                default:
                    break;
            }

            campaignEntity.setStatus(Status.ACTIVE);
        }

        if((createIncreaseDto.getPrice().compareTo(minManLimit) < 0) || (createIncreaseDto.getPrice().compareTo(maxManLimit) > 0)){
            createIncreaseDto.setPrice(campaignEntity.getProduct().getPrice());
            campaignEntity.setStatus(Status.PASSIVE);
        }

        campaignRepository.save(campaignEntity);

        return increaseMapper.toDto(increaseRepository.save(increaseMapper.toEntity(createIncreaseDto)));
    }

    private void validationStatus(CampaignEntity campaignEntity){
        if(campaignEntity.getStatus() == Status.PASSIVE)
        {
            throw new ResourceBadRequestException("Campaign is passive");
        }
    }

    private BigDecimal minManLimit(CampaignEntity campaignEntity){
        return campaignEntity.getProduct().getPrice().subtract((campaignEntity.getProduct().getPrice().multiply(BigDecimal.valueOf(campaignEntity.getPriceManLimit()))).divide(new BigDecimal(100)));
    }

    private BigDecimal maxManLimit(CampaignEntity campaignEntity){
        return campaignEntity.getProduct().getPrice().add((campaignEntity.getProduct().getPrice().multiply(BigDecimal.valueOf(campaignEntity.getPriceManLimit()))).divide(new BigDecimal(100)));
    }
}
