package com.hepsi.interview.service.order.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class OrderDto {

    public UUID id;

    public String productCode;

    public BigDecimal price;

    public Integer stock;
}
