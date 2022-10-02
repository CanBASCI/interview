package com.hepsi.interview.service.campaign.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hepsi.interview.utils.Status;
import com.hepsi.interview.service.product.data.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="hb_campaign")
@Getter
@Setter
public class CampaignEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public UUID id;

    @Column(name="NAME", unique = true, nullable = false)
    public String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public ProductEntity product;

    @Column(name="DURATION", columnDefinition = "integer default 1")
    public Integer duration;

    @Column(name="PRICE_MAN_LIMIT")
    public Integer priceManLimit;

    @Column(name="TARGET_SALES_COUNT")
    public Integer targetSalesCount;

    //todo bu nedir
    @Column(name="TOTAL_SALES")
    public Integer totalSales;

    @Column(name="STATUS", length = 32)
    @Enumerated(EnumType.STRING)
    public Status status;

    @JsonIgnore
    @OneToMany(mappedBy="campaign", cascade = CascadeType.ALL)
    public Set<IncreaseEntity> increases = new HashSet<>();
}
