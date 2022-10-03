package com.hepsi.interview.service.product.dto;

import com.sun.istack.NotNull;
import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDto {
    @NonNull
    private String productCode;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer stock;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
