package com.wsd.ecommerce.sales;

import com.wsd.ecommerce.wishlist.WishListDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/api/sales")
@CrossOrigin
@Tag(name = "Sales Report", description = "Sales Report APIs")
public class SalesController {

    private final SalesService salesService;

    @GetMapping(value = "/current/day")
    @Operation(summary = "Get total sales of the current day")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Double.class )))
    public ResponseEntity<?> getSalesAmount() {
        Map<String, BigDecimal> result= new HashMap<>();
        result.put("totalSales", salesService.getSalesOfCurrentDay());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
