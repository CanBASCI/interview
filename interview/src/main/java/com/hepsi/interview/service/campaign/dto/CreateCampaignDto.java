package com.hepsi.interview.service.campaign.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hepsi.interview.utils.Status;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCampaignDto {
    public String name;
    public UUID productId;
    public Integer duration;
    public Integer priceManLimit;
    public Integer targetSalesCount;
    @JsonIgnore
    public Status status;
}
