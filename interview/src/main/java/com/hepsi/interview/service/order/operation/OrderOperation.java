package com.hepsi.interview.service.order.operation;

import com.hepsi.interview.service.campaign.data.CampaignRepository;
import com.hepsi.interview.service.campaign.data.entity.CampaignEntity;
import com.hepsi.interview.service.campaign.data.entity.IncreaseEntity;
import com.hepsi.interview.service.campaign.dto.IncreaseDto;
import com.hepsi.interview.service.order.data.OrderRepository;
import com.hepsi.interview.service.order.data.entity.OrderEntity;
import com.hepsi.interview.service.order.dto.CreateOrderDto;
import com.hepsi.interview.service.order.dto.OrderDto;
import com.hepsi.interview.service.order.mapper.OrderMapper;
import com.hepsi.interview.service.product.data.ProductRepository;
import com.hepsi.interview.service.product.data.entity.ProductEntity;
import com.hepsi.interview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Component
public class OrderOperation {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    OrderMapper orderMapper;

    public List<OrderDto> getAllOrders(){

        return orderMapper.toDtos(orderRepository.findAll());
    }

    public OrderDto createOrder(CreateOrderDto createOrderDto) throws Exception {
        ProductEntity productEntity = productRepository.findById(createOrderDto.getProductId()).orElseThrow(() -> new Exception("product not found" ));

        int totalQuantity = 0;
        totalQuantity = productEntity.getOrders().stream().mapToInt(OrderEntity::getQuantity).sum();
        validateStock(productEntity.getStock(), totalQuantity, createOrderDto.getQuantity());

        Optional<CampaignEntity> campaignOptional = productEntity.getCampaigns().stream().filter(f -> Objects.equals(f.getStatus(), Status.ACTIVE)).findFirst();

        BigDecimal orderPrice = new BigDecimal(String.valueOf(productEntity.getPrice()));

        if(campaignOptional.isPresent())
        {
            CampaignEntity campaignEntity = campaignOptional.get();
            Integer maxTime = campaignEntity.getIncreases().stream().mapToInt(IncreaseEntity::getTime).max().orElseThrow(NoSuchElementException::new);
            Optional<IncreaseEntity> increaseOptional = campaignEntity.getIncreases().stream().filter(f -> Objects.equals(f.getTime(), maxTime)).findFirst();

            if (increaseOptional.isPresent())
            {
                IncreaseEntity increaseEntity = increaseOptional.get();
                if(createOrderDto.getQuantity() <= (campaignEntity.getTargetSalesCount() - campaignEntity.getTotalSales())) {
                    orderPrice = increaseEntity.getPrice();
                    campaignEntity.setTotalSales(campaignEntity.getTotalSales() + createOrderDto.getQuantity());
                    campaignRepository.save(campaignEntity);
                    createOrderDto.setCampaignId(increaseEntity.getId());
                }
            }
        }

        createOrderDto.setPrice(orderPrice);

        OrderEntity orderEntity = orderRepository.save(orderMapper.toEntity(createOrderDto));
        return orderMapper.toDto(orderEntity);
    }

    private void validateStock(Integer stock, Integer orderedQuantity, Integer quantity){
        if(stock < quantity || stock < (orderedQuantity + quantity))
        {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Stock can not be less than quantity");
        }
    }
}
