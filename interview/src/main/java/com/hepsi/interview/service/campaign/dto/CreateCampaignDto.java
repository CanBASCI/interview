package com.hepsi.interview.service.campaign.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hepsi.interview.utils.CalculateFormula;
import com.hepsi.interview.utils.Status;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCampaignDto {
    @NonNull
    public String name;
    public UUID productId;
    @NonNull
    public Integer duration;
    @NonNull
    public Integer priceManLimit;
    @NonNull
    public Integer targetSalesCount;
    @NonNull
    public CalculateFormula formula;

    @JsonIgnore
    public Integer totalSales;
    @JsonIgnore
    public Status status;
}
