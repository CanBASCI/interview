package com.hepsi.interview.service.product.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.order.data.entity.OrderEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="hb_product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(name="PRODUCT_CODE", unique = true, nullable = false)
    private String productCode;

    @Column(name="PRICE", precision = 8, scale = 2, nullable = false)
    private BigDecimal price;
    @Column(name="STOCK", nullable = false)
    private Integer stock;

    @JsonIgnore
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL)
    private Set<OrderEntity> orders = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL)
    private Set<CampaignEntity> campaigns = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public Set<CampaignEntity> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(Set<CampaignEntity> campaigns) {
        this.campaigns = campaigns;
    }

}
