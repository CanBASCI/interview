package com.hepsi.interview.service.product.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hepsi.interview.service.campaign.dto.CampaignDto;
import com.hepsi.interview.service.order.dto.OrderDto;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    public UUID id;
    public String productCode;
    public BigDecimal price;
    public Integer stock;
    public List<OrderDto> orders;
    public List<CampaignDto> campaigns;
}
