package com.wsd.ecommerce.sales;

import com.wsd.ecommerce.core.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "sales_summary")
public class SalesEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "day", nullable = false)
    private int day;

    @Column(name = "product_id", nullable = false)
    private long productID;

    @Column(name = "quantity", nullable = false)
    private long quantity;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

}
