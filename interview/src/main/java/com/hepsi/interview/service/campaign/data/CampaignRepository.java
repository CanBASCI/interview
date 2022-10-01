package com.hepsi.interview.service.campaign.data;

import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CampaignRepository extends JpaRepository<CampaignEntity, UUID> {
    CampaignEntity findByName(String name);
}
