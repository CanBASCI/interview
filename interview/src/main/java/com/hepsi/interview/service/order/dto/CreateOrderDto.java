package com.hepsi.interview.service.order.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateOrderDto {

    public String productCode;

    public BigDecimal price;

    public Integer stock;
}
