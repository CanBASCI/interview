package com.hepsi.interview.service.campaign.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="hb_increase")
@Getter
@Setter
public class IncreaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public UUID id;

    @Column(name="TIME")
    public Integer time;

    @Column(name="PRICE", precision = 8, scale = 2, nullable = false)
    public BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "campaign_id", referencedColumnName = "id")
    public CampaignEntity campaign;
}
