package com.hepsi.interview.service.order.data;

import com.hepsi.interview.service.order.data.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    OrderEntity findByProductId(UUID productId);

    Optional<List<OrderEntity>> findAllByQuantity(Integer quantity);
}
