package com.hepsi.interview.facade;

import com.hepsi.interview.service.product.dto.ProductDto;
import com.hepsi.interview.service.product.operation.ProductOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductFacade {
    @Autowired
    ProductOperation productOperation;
    public ProductDto getProductCalculated(String productCode){
        ProductDto productDto = productOperation.getProductInfo(productCode);


       // BigDecimal price1 = firstCalculate.getPrice(productDto.price, "P1");
        //BigDecimal price2 = secondCalculate.getPrice(productDto.price, "P1");

        String asd = "";

        return null;
    }
}
