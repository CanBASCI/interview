package com.hepsi.interview.controller;

import com.hepsi.interview.facade.ProductFacade;
import com.hepsi.interview.service.product.dto.CreateProductDto;
import com.hepsi.interview.service.product.dto.ProductDto;

import com.hepsi.interview.service.product.operation.ProductOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    ProductFacade productFacade;
    @Autowired
    ProductOperation productOperation;

    @GetMapping("/getAllProducts")
    List<ProductDto> getAllProducts(){
        return productOperation.getAllProducts();
    }

    @GetMapping("/getProductInfo/{productCode}")
    ProductDto getProductInfo(@PathVariable("productCode") String productCode){
        return productOperation.getProductInfo(productCode);
    }

    @PostMapping("/createProduct")
    ProductDto createProduct(@RequestBody CreateProductDto createProductDto){
        return productOperation.createProduct(createProductDto);
    }

    @GetMapping("/getProductCalculatedInfo/{productCode}")
    ProductDto getProductCalculatedInfo(@PathVariable("productCode") String productCode){
        return productFacade.getProductCalculated(productCode);
    }
}
