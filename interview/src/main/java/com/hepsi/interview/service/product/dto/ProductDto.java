package com.hepsi.interview.service.product.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hepsi.interview.service.campaign.dto.CampaignDto;
import com.hepsi.interview.service.order.dto.OrderDto;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    private UUID id;
    private String productCode;
    private BigDecimal price;
    private Integer stock;
    private List<OrderDto> orders;
    private List<CampaignDto> campaigns;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }

    public List<CampaignDto> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignDto> campaigns) {
        this.campaigns = campaigns;
    }
}
