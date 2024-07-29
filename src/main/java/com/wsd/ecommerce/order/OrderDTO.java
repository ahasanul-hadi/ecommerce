package com.wsd.ecommerce.order;

import com.wsd.ecommerce.customer.CustomerDTO;
import com.wsd.ecommerce.customer.CustomerEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class OrderDTO {
    private Long id;
    private CustomerDTO user;
    private BigDecimal totalAmount;
}
