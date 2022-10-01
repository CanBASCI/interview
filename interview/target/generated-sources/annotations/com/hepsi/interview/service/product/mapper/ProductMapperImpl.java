package com.hepsi.interview.service.product.mapper;

import com.hepsi.interview.service.product.data.entity.ProductEntity;
import com.hepsi.interview.service.product.dto.CreateProductDto;
import com.hepsi.interview.service.product.dto.ProductDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-01T14:59:30+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.id = productEntity.id;
        productDto.productCode = productEntity.productCode;
        productDto.price = productEntity.price;
        productDto.stock = productEntity.stock;

        return productDto;
    }

    @Override
    public List<ProductDto> toDtos(List<ProductEntity> productEntities) {
        if ( productEntities == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( productEntities.size() );
        for ( ProductEntity productEntity : productEntities ) {
            list.add( toDto( productEntity ) );
        }

        return list;
    }

    @Override
    public ProductEntity toEntity(CreateProductDto createProductDto) {
        if ( createProductDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.productCode = createProductDto.productCode;
        productEntity.price = createProductDto.price;
        productEntity.stock = createProductDto.stock;

        return productEntity;
    }
}
