package com.example.wallet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WalletControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testUpdateWallet() throws Exception {
        String requestBody = "{\"walletId\": \"2885d98d-6f0e-4f20-9f93-3204597ad689\", \"operationType\": \"DEPOSIT\", \"amount\": 1000}";

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/wallets/api/v1/wallet")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);

        mockMvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    void testGetBalance() throws Exception {
        UUID walletId = UUID.randomUUID();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/v1/wallets/" + walletId);

        mockMvc.perform(request)
                .andExpect(status().isOk());
    }

}
