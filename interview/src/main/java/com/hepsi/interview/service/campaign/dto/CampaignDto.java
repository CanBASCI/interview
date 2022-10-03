package com.hepsi.interview.service.campaign.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hepsi.interview.utils.CalculateFormula;
import com.hepsi.interview.utils.Status;
import com.hepsi.interview.service.product.dto.ProductDto;
import lombok.*;

import java.util.List;
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

    public CalculateFormula formula;

    public Status status;

    public List<IncreaseDto> increases;
}
