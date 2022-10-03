package com.hepsi.interview.service.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateOrderDto {
    public UUID productId;

    public Integer quantity;

    @JsonIgnore
    public BigDecimal price;
    @JsonIgnore
    public UUID campaignId;
}
