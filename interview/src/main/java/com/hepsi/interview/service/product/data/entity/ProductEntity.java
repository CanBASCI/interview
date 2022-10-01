package com.hepsi.interview.service.product.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.order.data.entity.OrderEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="hb_product")
@Getter
@Setter

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

    @JsonIgnore
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL)
    public Set<OrderEntity> orders = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL)
    public Set<CampaignEntity> campaigns = new HashSet<>();

}
