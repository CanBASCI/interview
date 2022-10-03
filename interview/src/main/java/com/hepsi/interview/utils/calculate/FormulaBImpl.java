package com.hepsi.interview.utils.calculate;

import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.campaign.data.entity.IncreaseEntity;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("Second")
public class FormulaBImpl implements IFormula{

    private static final Long increaseVal = 5L;
    @NotNull
    @Override
    public BigDecimal getPrice(CampaignEntity campaignEntity) {
        long timeCount = 0L;
        for (IncreaseEntity increaseEntity : campaignEntity.getIncreases()) {
            timeCount = increaseEntity.getTime() + timeCount;
        }
        BigDecimal totalIncrease = campaignEntity.getProduct().getPrice().multiply(new BigDecimal(campaignEntity.getPriceManLimit())).divide(new BigDecimal(100));

        return campaignEntity.getProduct().getPrice().subtract(totalIncrease);
    }
}
