package com.wsd.ecommerce.wishlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers =WishListController.class)
@AutoConfigureMockMvc(addFilters = false)
public class WishlistIT {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WishListService wishListService;

    @Test
    public void shouldReturnEmptyList() throws Exception {
        when(wishListService.findByCustomer(any())).thenReturn(List.of());

        mockMvc.perform(get("/api/wishlists/customer/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldReturnList() throws Exception {
        when(wishListService.findByCustomer(any())).thenReturn(List.of(new WishListDTO()));

        mockMvc.perform(get("/api/wishlists/customer/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}
