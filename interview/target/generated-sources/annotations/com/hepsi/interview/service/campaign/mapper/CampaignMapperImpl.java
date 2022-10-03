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
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-03T18:59:41+0300",
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

        campaignDto.setId( campaignEntity.getId() );
        campaignDto.setName( campaignEntity.getName() );
        campaignDto.setProduct( productEntityToProductDto( campaignEntity.getProduct() ) );
        campaignDto.setDuration( campaignEntity.getDuration() );
        campaignDto.setPriceManLimit( campaignEntity.getPriceManLimit() );
        campaignDto.setTargetSalesCount( campaignEntity.getTargetSalesCount() );
        campaignDto.setTotalSales( campaignEntity.getTotalSales() );
        campaignDto.setFormula( campaignEntity.getFormula() );
        campaignDto.setStatus( campaignEntity.getStatus() );
        campaignDto.setIncreases( increaseEntitySetToIncreaseDtoList( campaignEntity.getIncreases() ) );

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

        campaignEntity.setProduct( createCampaignDtoToProductEntity( createCampaignDto ) );
        if ( createCampaignDto.getStatus() != null ) {
            campaignEntity.setStatus( createCampaignDto.getStatus() );
        }
        else {
            campaignEntity.setStatus( Status.ACTIVE );
        }
        if ( createCampaignDto.getTotalSales() != null ) {
            campaignEntity.setTotalSales( createCampaignDto.getTotalSales() );
        }
        else {
            campaignEntity.setTotalSales( 0 );
        }
        campaignEntity.setName( createCampaignDto.getName() );
        campaignEntity.setDuration( createCampaignDto.getDuration() );
        campaignEntity.setPriceManLimit( createCampaignDto.getPriceManLimit() );
        campaignEntity.setTargetSalesCount( createCampaignDto.getTargetSalesCount() );
        campaignEntity.setFormula( createCampaignDto.getFormula() );

        return campaignEntity;
    }

    protected ProductDto productEntityToProductDto(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( productEntity.getId() );
        productDto.setProductCode( productEntity.getProductCode() );
        productDto.setPrice( productEntity.getPrice() );
        productDto.setStock( productEntity.getStock() );

        return productDto;
    }

    protected IncreaseDto increaseEntityToIncreaseDto(IncreaseEntity increaseEntity) {
        if ( increaseEntity == null ) {
            return null;
        }

        IncreaseDto increaseDto = new IncreaseDto();

        increaseDto.setId( increaseEntity.getId() );
        increaseDto.setTime( increaseEntity.getTime() );
        increaseDto.setPrice( increaseEntity.getPrice() );

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

        productEntity.setId( createCampaignDto.getProductId() );

        return productEntity;
    }
}
