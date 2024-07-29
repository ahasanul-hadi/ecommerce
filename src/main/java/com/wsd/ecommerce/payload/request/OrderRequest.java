package com.wsd.ecommerce.payload.request;

import lombok.Data;
@Data
public class OrderRequest {
    private Long productID;
    private int quantity;
}
