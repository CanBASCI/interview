package com.hb.interview.service.campaign.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hb.interview.utils.Status;
import com.hb.interview.service.product.dto.ProductDto;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampaignDto {
    public UUID id;
    public String name;
    public ProductDto product;
    public Integer duration;
    public Integer priceManLimit;
    public Integer targetSalesCount;
    //todo bu nedir
    public Integer totalSales;
    public Status status;
}
