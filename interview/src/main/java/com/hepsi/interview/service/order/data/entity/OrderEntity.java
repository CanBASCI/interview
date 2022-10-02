package com.hepsi.interview.service.order.data.entity;

import com.hepsi.interview.service.product.data.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="hb_order")
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public UUID id;

    @Column(name="QUANTITY")
    public Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public ProductEntity product;

}
