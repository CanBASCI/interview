package com.hepsi.interview.service.order.data.entity;

import com.hepsi.interview.service.product.data.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="hb_order")
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public UUID id;
    @Column(name="QUANTITY", nullable = false)
    public Integer quantity;

    @Column(name="PRICE", precision = 8, scale = 2, nullable = false)
    public BigDecimal price;

    @Column(name="CAMPAIGN_ID")
    public UUID campaignId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public ProductEntity product;
}
