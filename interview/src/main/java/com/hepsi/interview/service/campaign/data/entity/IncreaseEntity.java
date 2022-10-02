package com.hepsi.interview.service.campaign.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name="hb_increase")
@Getter
@Setter
public class IncreaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public UUID id;

    @Column(name="TIME", columnDefinition = "TIME")
    public Time time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "campaign_id", referencedColumnName = "id")
    public CampaignEntity campaign;
}
