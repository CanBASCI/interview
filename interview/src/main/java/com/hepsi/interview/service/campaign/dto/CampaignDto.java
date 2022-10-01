package com.hepsi.interview.service.campaign.dto;

import com.hepsi.interview.utils.Status;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class CampaignDto {
    public UUID id;

    public String name;

    public String productCode;

    public Integer duration;

    public Integer priceManLimit;

    public Integer targetSalesCount;

    //todo bu nedir
    public Integer totalSales;

    public Status status;
}
