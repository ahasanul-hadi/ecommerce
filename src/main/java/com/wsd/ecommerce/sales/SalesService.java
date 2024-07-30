package com.wsd.ecommerce.sales;

import com.wsd.ecommerce.order.OrderItemEntity;
import com.wsd.ecommerce.payload.request.OrderRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
            SalesEntity entity= salesRepository.findByYearAndMonthAndDayAndProductID(year, month, day, orderRequest.getProduct().getId()).orElseGet(SalesEntity::new);
            entity.setYear(year);
            entity.setMonth(month);
            entity.setDay(day);
            entity.setProductID(orderRequest.getProduct().getId());

            entity.setQuantity(entity.getQuantity()+orderRequest.getQuantity());
            entity.setAmount(entity.getAmount().add(orderRequest.getAmount()).setScale(2, RoundingMode.HALF_UP));

            summary.add(entity);
        });

        salesRepository.saveAll(summary);
    }

    public BigDecimal getSalesOfCurrentDay() {
        Calendar calendar= Calendar.getInstance();
        int year= calendar.get(Calendar.YEAR);
        int month= calendar.get(Calendar.MONTH) + 1;
        int day= calendar.get(Calendar.DAY_OF_MONTH);
        return salesRepository.findByYearAndMonthAndDay(year, month, day);
    }
}
