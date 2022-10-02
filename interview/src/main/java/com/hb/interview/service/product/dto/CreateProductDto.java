package com.hb.interview.service.product.dto;

import com.sun.istack.NotNull;
import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateProductDto {

    @NonNull
    public String productCode;

    @NotNull
    public BigDecimal price;

    @NotNull
    public Integer stock;
}
