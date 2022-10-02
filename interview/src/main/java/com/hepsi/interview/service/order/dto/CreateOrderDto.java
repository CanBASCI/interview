package com.hepsi.interview.service.order.dto;

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

    public BigDecimal price;

    public Integer quantity;
}
