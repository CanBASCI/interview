package com.hepsi.interview.service.campaign.mapper;

import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.campaign.data.entity.IncreaseEntity;
import com.hepsi.interview.service.campaign.dto.CampaignDto;
import com.hepsi.interview.service.campaign.dto.CreateCampaignDto;
import com.hepsi.interview.service.campaign.dto.IncreaseDto;
import com.hepsi.interview.service.product.data.entity.ProductEntity;
import com.hepsi.interview.service.product.dto.ProductDto;
import com.hepsi.interview.utils.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-03T17:31:44+0300",
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
        campaignDto.formula = campaignEntity.formula;
        campaignDto.status = campaignEntity.status;
        campaignDto.increases = increaseEntitySetToIncreaseDtoList( campaignEntity.increases );

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

        campaignEntity.product = createCampaignDtoToProductEntity( createCampaignDto );
        if ( createCampaignDto.status != null ) {
            campaignEntity.status = createCampaignDto.status;
        }
        else {
            campaignEntity.status = Status.ACTIVE;
        }
        if ( createCampaignDto.totalSales != null ) {
            campaignEntity.totalSales = createCampaignDto.totalSales;
        }
        else {
            campaignEntity.totalSales = 0;
        }
        campaignEntity.name = createCampaignDto.name;
        campaignEntity.duration = createCampaignDto.duration;
        campaignEntity.priceManLimit = createCampaignDto.priceManLimit;
        campaignEntity.targetSalesCount = createCampaignDto.targetSalesCount;
        campaignEntity.formula = createCampaignDto.formula;

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

    protected IncreaseDto increaseEntityToIncreaseDto(IncreaseEntity increaseEntity) {
        if ( increaseEntity == null ) {
            return null;
        }

        IncreaseDto increaseDto = new IncreaseDto();

        increaseDto.id = increaseEntity.id;
        increaseDto.time = increaseEntity.time;
        increaseDto.price = increaseEntity.price;

        return increaseDto;
    }

    protected List<IncreaseDto> increaseEntitySetToIncreaseDtoList(Set<IncreaseEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<IncreaseDto> list = new ArrayList<IncreaseDto>( set.size() );
        for ( IncreaseEntity increaseEntity : set ) {
            list.add( increaseEntityToIncreaseDto( increaseEntity ) );
        }

        return list;
    }

    protected ProductEntity createCampaignDtoToProductEntity(CreateCampaignDto createCampaignDto) {
        if ( createCampaignDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.id = createCampaignDto.productId;

        return productEntity;
    }
}
