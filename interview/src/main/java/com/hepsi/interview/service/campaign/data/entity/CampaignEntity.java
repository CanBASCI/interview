package com.hepsi.interview.service.campaign.data.entity;

import com.hepsi.interview.utils.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="campaign")
@Getter
@Setter
public class CampaignEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public UUID id;

    @Column(name="NAME", unique = true, nullable = false)
    public String name;

    @Column(name="PRODUCT_CODE", unique = true, nullable = false)
    public String productCode;

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
