package com.wsd.ecommerce.order;


import com.wsd.ecommerce.exception.ApplicationException;
import com.wsd.ecommerce.payload.request.OrderRequest;
import com.wsd.ecommerce.product.ProductEntity;
import com.wsd.ecommerce.product.ProductRepository;
import com.wsd.ecommerce.sales.SalesService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class OrderService {
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final SalesService salesService;

    public OrderDTO save(List<OrderRequest> orderRequests){
        BigDecimal total= new BigDecimal("0.00");
        List<OrderItemEntity> orderItemEntities= new ArrayList<>();
        for(OrderRequest request: orderRequests){
            ProductEntity product = productRepository.findById(request.getProductID()).orElseThrow(()->  new ApplicationException("No product found", HttpStatus.NOT_FOUND));

            OrderItemEntity item= new OrderItemEntity();
            item.setProduct(product);
            item.setAmount(product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity())).setScale(2, RoundingMode.HALF_UP));
            item.setQuantity(request.getQuantity());
            orderItemEntities.add(item);

            total = total.add(item.getAmount()).setScale(2, RoundingMode.HALF_UP);
        }

        //save parent order
        OrderEntity order= new OrderEntity();
        order.setTotalAmount(total);
        order.setOrderTime(LocalDateTime.now());
        order= orderRepository.save(order);

        //save individual items
        for(OrderItemEntity item : orderItemEntities){
            item.setOrder(order);
        }
        orderItemRepository.saveAll(orderItemEntities);

        //save summary asynchronously
        salesService.saveSummary(orderItemEntities);

       return mapToDTO(order, orderItemEntities);
    }

    private OrderDTO mapToDTO(OrderEntity entity, List<OrderItemEntity> items){
        OrderDTO orderDTO= modelMapper.map(entity, OrderDTO.class);
        if(items!=null && !items.isEmpty()){
            for(OrderItemEntity item: items){
                orderDTO.getItems().add(modelMapper.map(item, OrderItemDTO.class));
            }
        }
        return orderDTO;
    }

}
