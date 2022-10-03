package com.hepsi.interview.service.order.data.entity;

import com.hepsi.interview.service.product.data.entity.ProductEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="hb_order")

public class OrderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    @Column(name="QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name="PRICE", precision = 8, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name="CAMPAIGN_ID")
    private UUID campaignId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UUID getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(UUID campaignId) {
        this.campaignId = campaignId;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
