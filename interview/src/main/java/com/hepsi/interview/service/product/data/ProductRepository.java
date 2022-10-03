package com.hepsi.interview.service.product.data;

import com.hepsi.interview.service.product.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    ProductEntity findByProductCode(String productCode);
}
