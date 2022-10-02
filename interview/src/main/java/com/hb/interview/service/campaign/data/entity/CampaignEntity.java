package com.hb.interview.service.campaign.data.entity;

import com.hb.interview.utils.Status;
import com.hb.interview.service.product.data.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    //@Column(name="PRODUCT_CODE", unique = true, nullable = false)
    //public String productCode;

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

    @Column(name="STATUS")
    @Enumerated(EnumType.STRING)
    public Status status;
}