package com.hepsi.interview.service.campaign.data;

import com.hepsi.interview.service.campaign.data.entity.IncreaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IncreaseRepository extends JpaRepository<IncreaseEntity, UUID> {

}
