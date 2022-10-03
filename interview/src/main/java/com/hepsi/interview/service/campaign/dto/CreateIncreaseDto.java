package com.hepsi.interview.service.campaign.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hepsi.interview.utils.Status;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateIncreaseDto {
    public UUID campaignId;
    public Integer time;
    @JsonIgnore
    public BigDecimal price;
}
