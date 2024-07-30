package com.wsd.ecommerce.sales;

import java.math.BigDecimal;

public interface SalesDTO {
    int getYear();
    int getMonth();
    int getDay();
    long getQuantity();
    BigDecimal getAmount();

}
