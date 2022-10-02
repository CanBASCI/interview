package com.hb.interview.facade;

import com.hb.interview.service.product.dto.ProductDto;
import com.hb.interview.service.product.operation.ProductOperation;
import com.hb.interview.utils.calculate.ICalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductFacade {
    @Autowired
    ProductOperation productOperation;

    @Autowired
    @Qualifier(value = "First")
    ICalculate firstCalculate;

    @Autowired
    @Qualifier(value = "Second")
    ICalculate secondCalculate;

    public ProductDto getProductCalculated(String productCode){
        ProductDto productDto = productOperation.getProductInfo(productCode);


        BigDecimal price1 = firstCalculate.getPrice(productDto.price, "P1");
        BigDecimal price2 = secondCalculate.getPrice(productDto.price, "P1");

        String asd = "";

        return null;
    }
}
