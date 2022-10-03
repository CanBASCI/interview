package com.hepsi.interview.service.campaign.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hepsi.interview.utils.CalculateFormula;
import com.hepsi.interview.utils.Status;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCampaignDto {
    @NonNull
    private String name;
    private UUID productId;
    @NonNull
    private Integer duration;
    @NonNull
    private Integer priceManLimit;
    @NonNull
    private Integer targetSalesCount;
    @NonNull
    private CalculateFormula formula;
    @JsonIgnore
    private Integer totalSales;
    @JsonIgnore
    private Status status;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
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

    public CalculateFormula getFormula() {
        return formula;
    }

    public void setFormula(CalculateFormula formula) {
        this.formula = formula;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
