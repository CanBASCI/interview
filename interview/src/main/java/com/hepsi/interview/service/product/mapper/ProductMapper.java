package com.hepsi.interview.service.product.mapper;

import com.hepsi.interview.service.product.data.entity.ProductEntity;
import com.hepsi.interview.service.product.dto.CreateProductDto;
import com.hepsi.interview.service.product.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface ProductMapper {

    ProductDto toDto(ProductEntity productEntity);
    List<ProductDto> toDtos(List<ProductEntity> productEntities);
    ProductEntity toEntity(CreateProductDto createProductDto);
}
