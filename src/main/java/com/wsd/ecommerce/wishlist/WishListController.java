package com.wsd.ecommerce.wishlist;

import com.wsd.ecommerce.payload.request.WishListRequest;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<?> saveRequest(@Valid @RequestBody WishListRequest wish) {
        return new ResponseEntity<>(wishListService.save(wish), HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<?> getList(@PathVariable Long id) {
        return new ResponseEntity<>(wishListService.findByCustomer(id), HttpStatus.OK);
    }
}
