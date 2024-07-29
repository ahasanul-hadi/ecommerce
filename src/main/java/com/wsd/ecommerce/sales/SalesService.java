package com.wsd.ecommerce.sales;

import com.wsd.ecommerce.order.OrderItemEntity;
import com.wsd.ecommerce.payload.request.OrderRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class SalesService {
    private final SalesRepository salesRepository;

    @Async
    public void saveSummary(List<OrderItemEntity> orderItems){
        Calendar calendar= Calendar.getInstance();
        int year= calendar.get(Calendar.YEAR);
        int month= calendar.get(Calendar.MONTH) + 1;
        int day= calendar.get(Calendar.DAY_OF_MONTH);

        List<SalesEntity> summary= new ArrayList<>();
        orderItems.forEach(orderRequest -> {
            SalesEntity entity= new SalesEntity();
            entity.setYear(year);
            entity.setMonth(month);
            entity.setDay(day);
            entity.setProductID(orderRequest.getProduct().getId());
            entity.setAmount(orderRequest.getAmount());

            summary.add(entity);
        });

        salesRepository.saveAll(summary);
    }
}
