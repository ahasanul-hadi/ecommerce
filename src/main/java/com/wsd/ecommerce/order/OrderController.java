package com.wsd.ecommerce.order;

import com.wsd.ecommerce.payload.request.OrderRequest;
import com.wsd.ecommerce.payload.request.WishListRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Order", description = "Customer Order APIs")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @Operation(summary = "Save an Order")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderDTO.class )))
    public ResponseEntity<?> saveRequest(@Valid @RequestBody List<OrderRequest> order) {
        return new ResponseEntity<>(orderService.save(order), HttpStatus.OK);
    }
}
