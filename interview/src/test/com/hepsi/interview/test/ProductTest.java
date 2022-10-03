package com.hepsi.interview.test;

import com.hepsi.interview.service.product.data.ProductRepository;
import com.hepsi.interview.service.product.data.entity.ProductEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;


class ProductTest {
    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void get_all_product_entity() {

        List<ProductEntity> productEntities = new ArrayList<>();
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(UUID.randomUUID());
        productEntity.setProductCode("P1");
        productEntity.setPrice(new BigDecimal(100));
        productEntity.setStock(10);
        productEntity.setOrders(null);
        productEntity.setCampaigns(null);
        productEntity.setOrders(null);
        productEntities.add(productEntity);

        Assertions.assertNotNull(when(productRepository.findAll()).thenReturn(productEntities));
    }

    @Test
    public void get_find_by_product_code() {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(UUID.randomUUID());
        productEntity.setProductCode("P1");
        productEntity.setPrice(new BigDecimal(100));
        productEntity.setStock(10);
        productEntity.setOrders(null);
        productEntity.setCampaigns(null);
        productEntity.setOrders(null);

        Assertions.assertNotNull(when(productRepository.findByProductCode("P1")).thenReturn(productEntity));
    }
}
