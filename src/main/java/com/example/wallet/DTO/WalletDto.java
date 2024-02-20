package com.example.wallet.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WalletDto {
    private UUID walletId;
    private String operationType;
    private int amount;
}
