package com.hepsi.interview.utils.calculate;


import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface IFormula {
    BigDecimal getPrice(CampaignEntity campaignEntity) throws Exception;
}
