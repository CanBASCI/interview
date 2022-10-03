package com.hepsi.interview.utils.calculate;

import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.sun.istack.NotNull;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Primary
@Component("First")
public class FormulaAImpl implements IFormula{
    private static final Long increaseVal = 5L;

    @NotNull
    @Override
    public BigDecimal getPrice(CampaignEntity campaignEntity) {
        BigDecimal totalIncrease = new BigDecimal( increaseVal * ((long) campaignEntity.increases.size() + 1));
        return campaignEntity.product.price.subtract(totalIncrease);
    }
}
