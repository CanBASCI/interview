package com.hb.interview.service.campaign.mapper;

import com.hb.interview.service.campaign.data.entity.CampaignEntity;
import com.hb.interview.service.campaign.dto.CampaignDto;
import com.hb.interview.service.campaign.dto.CreateCampaignDto;
import com.hb.interview.service.product.data.entity.ProductEntity;
import com.hb.interview.service.product.dto.ProductDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-02T02:59:30+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class CampaignMapperImpl implements CampaignMapper {

    @Override
    public CampaignDto toDto(CampaignEntity campaignEntity) {
        if ( campaignEntity == null ) {
            return null;
        }

        CampaignDto campaignDto = new CampaignDto();

        campaignDto.id = campaignEntity.id;
        campaignDto.name = campaignEntity.name;
        campaignDto.product = productEntityToProductDto( campaignEntity.product );
        campaignDto.duration = campaignEntity.duration;
        campaignDto.priceManLimit = campaignEntity.priceManLimit;
        campaignDto.targetSalesCount = campaignEntity.targetSalesCount;
        campaignDto.totalSales = campaignEntity.totalSales;
        campaignDto.status = campaignEntity.status;

        return campaignDto;
    }

    @Override
    public List<CampaignDto> toDtos(List<CampaignEntity> campaignEntities) {
        if ( campaignEntities == null ) {
            return null;
        }

        List<CampaignDto> list = new ArrayList<CampaignDto>( campaignEntities.size() );
        for ( CampaignEntity campaignEntity : campaignEntities ) {
            list.add( toDto( campaignEntity ) );
        }

        return list;
    }

    @Override
    public CampaignEntity toEntity(CreateCampaignDto createCampaignDto) {
        if ( createCampaignDto == null ) {
            return null;
        }

        CampaignEntity campaignEntity = new CampaignEntity();

        campaignEntity.name = createCampaignDto.name;
        campaignEntity.duration = createCampaignDto.duration;
        campaignEntity.priceManLimit = createCampaignDto.priceManLimit;
        campaignEntity.targetSalesCount = createCampaignDto.targetSalesCount;
        campaignEntity.totalSales = createCampaignDto.totalSales;
        campaignEntity.status = createCampaignDto.status;

        return campaignEntity;
    }

    protected ProductDto productEntityToProductDto(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.id = productEntity.id;
        productDto.productCode = productEntity.productCode;
        productDto.price = productEntity.price;
        productDto.stock = productEntity.stock;

        return productDto;
    }
}
