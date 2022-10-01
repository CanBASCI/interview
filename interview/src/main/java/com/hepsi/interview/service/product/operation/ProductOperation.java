package com.hepsi.interview.service.product.operation;

import com.hepsi.interview.service.product.dto.CreateProductDto;
import com.hepsi.interview.service.product.dto.ProductDto;
import com.hepsi.interview.service.product.mapper.ProductMapper;
import com.hepsi.interview.service.product.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductOperation {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public List<ProductDto> getAllProducts(){

        return productMapper.toDtos(productRepository.findAll());
    }

    public ProductDto getProductInfo(String productCode){
        return productMapper.toDto(productRepository.findByProductCode(productCode));
    }

    public ProductDto createProduct(CreateProductDto createProductDto){
        return productMapper.toDto(productRepository.save(productMapper.toEntity(createProductDto)));
    }
}
