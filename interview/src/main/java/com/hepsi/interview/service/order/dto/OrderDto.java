package com.hepsi.interview.service.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hepsi.interview.service.product.dto.ProductDto;
import lombok.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {

    public UUID id;

    public ProductDto product;
    public Integer quantity;
}
