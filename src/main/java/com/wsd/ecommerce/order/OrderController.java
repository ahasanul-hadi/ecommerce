package com.wsd.ecommerce.order;

import com.wsd.ecommerce.payload.request.OrderRequest;
import com.wsd.ecommerce.payload.request.WishListRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> saveRequest(@Valid @RequestBody List<OrderRequest> order) {
        return new ResponseEntity<>(orderService.save(order), HttpStatus.OK);
    }
}
