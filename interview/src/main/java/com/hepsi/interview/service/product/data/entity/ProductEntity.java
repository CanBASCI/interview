package com.hepsi.interview.service.product.data.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public UUID id;

    @Column(name="PRODUCT_CODE", unique = true, nullable = false)
    public String productCode;

    @Column(name="PRICE", precision = 8, scale = 2)
    public BigDecimal price;

    @Column(name="STOCK")
    public Integer stock;

    //@OneToOne(mappedBy="productCode")
    //private OrderEntity order;
}
