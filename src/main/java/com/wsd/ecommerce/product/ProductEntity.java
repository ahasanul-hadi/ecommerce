package com.wsd.ecommerce.product;

import com.wsd.ecommerce.core.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String productName;

    @Column(name = "brand_name")
    private String brand;

    @Column(name = "sku_code", unique = true)
    private String skuCode;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

}
