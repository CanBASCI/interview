package com.hepsi.interview.service.campaign.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncreaseDto {
    private UUID id;
    private Integer time;
    private BigDecimal price;
    private List<CampaignDto> campaignDto;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<CampaignDto> getCampaignDto() {
        return campaignDto;
    }

    public void setCampaignDto(List<CampaignDto> campaignDto) {
        this.campaignDto = campaignDto;
    }
}
