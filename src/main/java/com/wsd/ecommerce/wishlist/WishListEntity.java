package com.wsd.ecommerce.wishlist;

import com.wsd.ecommerce.core.BaseEntity;
import com.wsd.ecommerce.customer.CustomerEntity;
import com.wsd.ecommerce.product.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "wishlists")
public class WishListEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    private CustomerEntity customer;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private ProductEntity product;

    @Column(name = "date_time")
    private LocalDateTime dateTime;
}
