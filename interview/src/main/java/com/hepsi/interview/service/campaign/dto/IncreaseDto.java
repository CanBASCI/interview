package com.hepsi.interview.service.campaign.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hepsi.interview.service.product.dto.ProductDto;
import com.hepsi.interview.utils.Status;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncreaseDto {
    public UUID id;
    public Integer time;
    public BigDecimal price;
    public List<CampaignDto> campaignDto;
}
