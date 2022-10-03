package com.hepsi.interview.test;

import com.hepsi.interview.service.product.data.ProductRepository;
import com.hepsi.interview.service.product.dto.ProductDto;
import com.hepsi.interview.service.product.operation.ProductOperation;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class ProductOperationTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductOperation productOperation;

    @BeforeEach
    public void initMock(){MockitoAnnotations.initMocks(this);}

    @Test
    @DisplayName("")
    @Order(1)
    void contextLoads()
    {

    }

    @Test
    @DisplayName("Get All Products Test")
    void getAllProducts() {
        List<ProductDto> productDtoList = productOperation.getAllProducts();
        String a = "";
    }

}