package com.hb.interview.utils.calculate;

import com.hb.interview.service.campaign.operation.CampaignOperation;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("Second")
public class CalculateSecondCampaignImpl implements ICalculate{
    @Autowired
    CampaignOperation campaignOperation;

    @NotNull
    @Override
    public BigDecimal getPrice(BigDecimal price, String name) {
        return new BigDecimal(2);
        //CampaignDto campaignDto = campaignOperation.getCampaignInfo(name);

        //return price.subtract(price.multiply(BigDecimal.valueOf(campaignDto.priceManLimit))).divide(new BigDecimal(100));
    }
}
