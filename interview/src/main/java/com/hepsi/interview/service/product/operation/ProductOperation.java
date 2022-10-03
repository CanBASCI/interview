package com.hepsi.interview.service.product.operation;

import com.hepsi.interview.service.campaign.dto.IncreaseDto;
import com.hepsi.interview.service.product.mapper.ProductMapper;
import com.hepsi.interview.service.product.dto.CreateProductDto;
import com.hepsi.interview.service.product.dto.ProductDto;
import com.hepsi.interview.service.product.data.ProductRepository;
import com.hepsi.interview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

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

        ProductDto productDto = productMapper.toDto(productRepository.findByProductCode(productCode));

        productDto.getCampaigns().forEach(campaignDto -> {
            if(campaignDto.getStatus() == Status.ACTIVE) {
                Integer maxTime = campaignDto.getIncreases().stream().mapToInt(v -> v.getTime()).max().orElseThrow(NoSuchElementException::new);
                Optional<IncreaseDto> increaseDtos = campaignDto.getIncreases().stream().filter(f -> Objects.equals(f.getTime(), maxTime)).findFirst();
                increaseDtos.ifPresent(increaseDto -> productDto.setPrice(increaseDto.getPrice()));
            }
        });

        return productDto;
    }

    public ProductDto createProduct(CreateProductDto createProductDto){
        return productMapper.toDto(productRepository.save(productMapper.toEntity(createProductDto)));
    }
}
