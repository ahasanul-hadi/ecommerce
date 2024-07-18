package com.wsd.ecommerce.wishlist;

import com.wsd.ecommerce.customer.CustomerEntity;
import com.wsd.ecommerce.product.ProductEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class WishListDTO {
    private UUID id;
    private CustomerEntity customer;
    private ProductEntity product;
    private LocalDateTime dateTime;
}
