package com.hepsi.interview.service.campaign.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hepsi.interview.utils.CalculateFormula;
import com.hepsi.interview.utils.Status;
import com.hepsi.interview.service.product.dto.ProductDto;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampaignDto {
    private UUID id;
    private String name;
    private ProductDto product;
    private Integer duration;
    private Integer priceManLimit;
    private Integer targetSalesCount;
    private Integer totalSales;
    private CalculateFormula formula;
    private Status status;
    private List<IncreaseDto> increases;

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

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
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

    public List<IncreaseDto> getIncreases() {
        return increases;
    }

    public void setIncreases(List<IncreaseDto> increases) {
        this.increases = increases;
    }
}
