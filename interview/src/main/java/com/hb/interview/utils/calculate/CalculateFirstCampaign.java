package com.hb.interview.utils.calculate;

import com.hb.interview.service.campaign.operation.CampaignOperation;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Primary
@Component("First")
public class CalculateFirstCampaign implements ICalculate {
    @Autowired
    CampaignOperation campaignOperation;
    @NotNull
    @Override
    public BigDecimal getPrice(BigDecimal price, String name) {

        return new BigDecimal(1);

        //CampaignDto campaignDto = campaignOperation.getCampaignInfo(name);

        //return (price.multiply(BigDecimal.valueOf(campaignDto.priceManLimit))).divide(new BigDecimal(100));
    }
}
