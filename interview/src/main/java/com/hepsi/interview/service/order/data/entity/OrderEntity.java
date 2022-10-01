package com.hepsi.interview.service.order.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="order")
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(name="QUANTITY")
    private Integer quantity;

    @Column(name="PRODUCT_CODE", unique = true, nullable = false)
    public String productCode;
}
