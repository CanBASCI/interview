package com.hepsi.interview.test;

import com.hepsi.interview.service.order.data.OrderRepository;
import com.hepsi.interview.service.order.data.entity.OrderEntity;
import com.hepsi.interview.service.product.data.entity.ProductEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;


class OrderTest {
    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void get_find_by_product_id() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(UUID.randomUUID());
        productEntity.setProductCode("P1");
        productEntity.setPrice(new BigDecimal(100));
        productEntity.setStock(10);
        productEntity.setOrders(null);
        productEntity.setCampaigns(null);
        productEntity.setOrders(null);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(UUID.randomUUID());
        orderEntity.setCampaignId(UUID.randomUUID());
        orderEntity.setProduct(productEntity);
        orderEntity.setQuantity(100);
        orderEntity.setPrice(new BigDecimal(100));

        Assertions.assertNotNull(when(orderRepository.findByProductId(productEntity.getId())).thenReturn(orderEntity));
    }

    @Test
    public void get_find_all_by_quantity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(UUID.randomUUID());
        productEntity.setProductCode("P1");
        productEntity.setPrice(new BigDecimal(100));
        productEntity.setStock(10);
        productEntity.setOrders(null);
        productEntity.setCampaigns(null);
        productEntity.setOrders(null);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(UUID.randomUUID());
        orderEntity.setCampaignId(UUID.randomUUID());
        orderEntity.setProduct(productEntity);
        orderEntity.setQuantity(100);
        orderEntity.setPrice(new BigDecimal(100));

        Optional<List<OrderEntity>> orderEntities = Optional.empty();
        orderEntities.get().add(orderEntity);

        Assertions.assertNotNull(when(orderRepository.findAllByQuantity(orderEntity.getQuantity())).thenReturn(orderEntities));
    }
}
