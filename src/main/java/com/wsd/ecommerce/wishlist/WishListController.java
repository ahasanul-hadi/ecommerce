package com.wsd.ecommerce.wishlist;

import com.wsd.ecommerce.payload.request.WishListRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/api/wishlists")
@CrossOrigin
public class WishListController {

    private final WishListService wishListService;

    @PostMapping
    @Operation(summary = "Save a wishlist")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = WishListDTO.class )))
    public ResponseEntity<?> saveRequest(@Valid @RequestBody WishListRequest wish) {
        return new ResponseEntity<>(wishListService.save(wish), HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{id}")
    @Operation(summary = "Get wishlist of a Customer")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = WishListDTO.class))))
    public ResponseEntity<?> getList(@PathVariable Long id) {
        return new ResponseEntity<>(wishListService.findByCustomer(id), HttpStatus.OK);
    }
}
