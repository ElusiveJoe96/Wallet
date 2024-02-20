package com.example.wallet.service;

import com.example.wallet.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public void deposit(UUID walletId, int amount) {
        Optional<Wallet> walletOptional = walletRepository.findById(walletId);
        if (walletOptional.isPresent()) {
            Wallet wallet = walletOptional.get();
            wallet.setBalance(wallet.getBalance() + amount);
            walletRepository.save(wallet);
        }
    }

    public void withdraw(UUID walletId, int amount) {
        Optional<Wallet> walletOptional = walletRepository.findById(walletId);
        if (walletOptional.isPresent()) {
            Wallet wallet = walletOptional.get();
            wallet.setBalance(wallet.getBalance() - amount);
            walletRepository.save(wallet);
        }
    }

    public int getBalance(UUID walletId) {
        Optional<Wallet> walletOptional = walletRepository.findById(walletId);
        return walletOptional.map(Wallet::getBalance).orElse(0);
    }
}
