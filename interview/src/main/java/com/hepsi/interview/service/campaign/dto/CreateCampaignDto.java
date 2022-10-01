package com.hepsi.interview.service.campaign.dto;

import com.hepsi.interview.utils.Status;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCampaignDto {
    public String name;
    public String productCode;
    public Integer duration;
    public Integer priceManLimit;
    public Integer targetSalesCount;
    //todo bu nedir
    public Integer totalSales;
    public Status status;
}
