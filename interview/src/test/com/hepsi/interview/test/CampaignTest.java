package com.hepsi.interview.test;

import com.hepsi.interview.service.campaign.data.CampaignRepository;
import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.product.data.entity.ProductEntity;
import com.hepsi.interview.utils.CalculateFormula;
import com.hepsi.interview.utils.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.when;


class CampaignTest {
    @Mock
    private CampaignRepository campaignRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void get_campaign_find_by_name() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(UUID.randomUUID());
        productEntity.setProductCode("P1");
        productEntity.setPrice(new BigDecimal(100));
        productEntity.setStock(10);
        productEntity.setOrders(null);
        productEntity.setCampaigns(null);
        productEntity.setOrders(null);

        CampaignEntity campaignEntity = new CampaignEntity();
        campaignEntity.setId(UUID.randomUUID());
        campaignEntity.setProduct(productEntity);
        campaignEntity.setTotalSales(100);
        campaignEntity.setDuration(10);
        campaignEntity.setStatus(Status.ACTIVE);
        campaignEntity.setName("Campaign1");
        campaignEntity.setFormula(CalculateFormula.A);
        campaignEntity.setPriceManLimit(10);

        Assertions.assertNotNull(when(campaignRepository.findByName(productEntity.getProductCode())).thenReturn(campaignEntity));
    }

    @Test
    public void get_campaign_find_by_product_id() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(UUID.randomUUID());
        productEntity.setProductCode("P1");
        productEntity.setPrice(new BigDecimal(100));
        productEntity.setStock(10);
        productEntity.setOrders(null);
        productEntity.setCampaigns(null);
        productEntity.setOrders(null);

        CampaignEntity campaignEntity = new CampaignEntity();
        campaignEntity.setId(UUID.randomUUID());
        campaignEntity.setProduct(productEntity);
        campaignEntity.setTotalSales(100);
        campaignEntity.setDuration(10);
        campaignEntity.setStatus(Status.ACTIVE);
        campaignEntity.setName("Campaign1");
        campaignEntity.setFormula(CalculateFormula.A);
        campaignEntity.setPriceManLimit(10);

        Assertions.assertNotNull(when(campaignRepository.findByProductId(productEntity.getId())).thenReturn(campaignEntity));
    }

}
