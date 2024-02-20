package com.example.wallet.controller;

import com.example.wallet.DTO.WalletDto;
import com.example.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wallets")
public class WalletController   {

    @Autowired
    private WalletService walletService;

    @PostMapping("/api/v1/wallet")
    public void updateWallet(@RequestBody WalletDto walletDto) {
        if (walletDto.getOperationType().equals("DEPOSIT")) {
            walletService.deposit(walletDto.getWalletId(), walletDto.getAmount());
        } else if (walletDto.getOperationType().equals("WITHDRAW")) {
            walletService.withdraw(walletDto.getWalletId(), walletDto.getAmount());
        }
    }

    @GetMapping("/{walletId}")
    public int getBalance(@PathVariable UUID walletId) {
        return walletService.getBalance(walletId);
    }
}
