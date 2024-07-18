package com.wsd.ecommerce.payload.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WishListRequest {
    private Long customerID;
    private Long productID;
    private LocalDateTime dateTime;
}
