package com.hepsi.interview.service.campaign.operation;

import com.hepsi.interview.service.campaign.data.IncreaseRepository;
import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.campaign.dto.CreateIncreaseDto;
import com.hepsi.interview.service.campaign.dto.IncreaseDto;
import com.hepsi.interview.service.campaign.mapper.CampaignMapper;
import com.hepsi.interview.service.campaign.data.CampaignRepository;
import com.hepsi.interview.service.campaign.dto.CampaignDto;
import com.hepsi.interview.service.campaign.dto.CreateCampaignDto;
import com.hepsi.interview.service.campaign.mapper.IncreaseMapper;
import com.hepsi.interview.utils.Status;
import com.hepsi.interview.utils.calculate.IFormula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

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
        CampaignEntity campaignEntity = campaignRepository.findById(createIncreaseDto.campaignId).orElseThrow(() -> new Exception("campaign not found" ));

        validationStatus(campaignEntity);

        BigDecimal minManLimit = minManLimit(campaignEntity);
        BigDecimal maxManLimit = maxManLimit(campaignEntity);

        int maxTime = 0;
        if(campaignEntity.increases.size() > 0) {
             maxTime = campaignEntity.increases.stream().mapToInt(v -> v.time).max().orElseThrow(NoSuchElementException::new);
        }

        createIncreaseDto.time = maxTime + createIncreaseDto.time;

        if(createIncreaseDto.time > campaignEntity.duration){
            createIncreaseDto.price = campaignEntity.product.price;
            campaignEntity.status = Status.PASSIVE;
        }
        else {
            BigDecimal currentPrice;
            switch (campaignEntity.formula) {
                case A:
                    currentPrice = AFormula.getPrice(campaignEntity);
                    createIncreaseDto.price = currentPrice;
                    break;
                case B:
                    currentPrice = BFormula.getPrice(campaignEntity);
                    createIncreaseDto.price = currentPrice;
                    break;
                default:
                    break;
            }

            campaignEntity.status = Status.ACTIVE;
        }

        if((createIncreaseDto.price.compareTo(minManLimit) < 0) || (createIncreaseDto.price.compareTo(maxManLimit) > 0)){
            createIncreaseDto.price = campaignEntity.product.price;
            campaignEntity.status = Status.PASSIVE;
        }

        campaignRepository.save(campaignEntity);

        return increaseMapper.toDto(increaseRepository.save(increaseMapper.toEntity(createIncreaseDto)));
    }

    private void validationStatus(CampaignEntity campaignEntity){
        if(campaignEntity.status == Status.PASSIVE)
        {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Campaign is passive");
        }
    }

    private BigDecimal minManLimit(CampaignEntity campaignEntity){
        return campaignEntity.product.price.subtract((campaignEntity.product.price.multiply(BigDecimal.valueOf(campaignEntity.priceManLimit))).divide(new BigDecimal(100)));
    }

    private BigDecimal maxManLimit(CampaignEntity campaignEntity){
        return campaignEntity.product.price.add((campaignEntity.product.price.multiply(BigDecimal.valueOf(campaignEntity.priceManLimit))).divide(new BigDecimal(100)));
    }
}
