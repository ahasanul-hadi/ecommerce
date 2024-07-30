package com.wsd.ecommerce.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SalesController.class)
@AutoConfigureMockMvc(addFilters = false)
public class SalesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalesService salesService;

    @Test
    public void shouldReturnEmptySales() throws Exception {

        when(salesService.getSalesOfCurrentDay()).thenReturn(new BigDecimal("0.00"));

        mockMvc.perform(get("/api/sales/current/day"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalSales").value(0.00));
    }
}
