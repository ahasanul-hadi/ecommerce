package com.wsd.ecommerce.order;

import com.wsd.ecommerce.core.BaseEntity;
import com.wsd.ecommerce.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private CustomerEntity user;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "order_time")
    private LocalDateTime orderTime;

}
