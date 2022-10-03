package com.hepsi.interview.service.campaign.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hepsi.interview.utils.CalculateFormula;
import com.hepsi.interview.utils.Status;
import com.hepsi.interview.service.product.data.entity.ProductEntity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="hb_campaign")
public class CampaignEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(name="NAME", unique = true, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;

    @Column(name="DURATION", columnDefinition = "integer default 0", nullable = false)
    private Integer duration;

    @Column(name="PRICE_MAN_LIMIT", nullable = false)
    private Integer priceManLimit;

    @Column(name="TARGET_SALES_COUNT")
    private Integer targetSalesCount;

    @Column(name="TOTAL_SALES", columnDefinition = "integer default 0", nullable = false)
    private Integer totalSales;

    @Column(name="FORMULA", length = 32)
    @Enumerated(EnumType.STRING)
    private CalculateFormula formula;

    @Column(name="STATUS", length = 32)
    @Enumerated(EnumType.STRING)
    private Status status;


    @JsonIgnore
    @OneToMany(mappedBy="campaign", cascade = CascadeType.ALL)
    private Set<IncreaseEntity> increases = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getPriceManLimit() {
        return priceManLimit;
    }

    public void setPriceManLimit(Integer priceManLimit) {
        this.priceManLimit = priceManLimit;
    }

    public Integer getTargetSalesCount() {
        return targetSalesCount;
    }

    public void setTargetSalesCount(Integer targetSalesCount) {
        this.targetSalesCount = targetSalesCount;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    public CalculateFormula getFormula() {
        return formula;
    }

    public void setFormula(CalculateFormula formula) {
        this.formula = formula;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<IncreaseEntity> getIncreases() {
        return increases;
    }

    public void setIncreases(Set<IncreaseEntity> increases) {
        this.increases = increases;
    }

}
