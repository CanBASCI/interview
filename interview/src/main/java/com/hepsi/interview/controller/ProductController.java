package com.hepsi.interview.controller;

import com.hepsi.interview.service.product.dto.CreateProductDto;
import com.hepsi.interview.service.product.dto.ProductDto;

import com.hepsi.interview.service.product.operation.ProductOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @Autowired
    ProductOperation productOperation;

    @GetMapping("/getAllProducts")
    ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productOperation.getAllProducts());
    }

    @GetMapping("/getProductInfo/{productCode}")
    ResponseEntity<ProductDto> getProductInfo(@PathVariable("productCode") String productCode){
        return ResponseEntity.ok(productOperation.getProductInfo(productCode));
    }

    @PostMapping("/createProduct")
    ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductDto createProductDto){
        return ResponseEntity.ok(productOperation.createProduct(createProductDto));
    }

}
