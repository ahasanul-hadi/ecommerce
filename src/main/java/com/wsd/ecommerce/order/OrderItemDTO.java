package com.wsd.ecommerce.order;

import com.wsd.ecommerce.product.ProductEntity;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Data
public class OrderItemDTO{
    private Long id;
    private ProductEntity product;
    private Integer quantity;
    private BigDecimal amount;
}
