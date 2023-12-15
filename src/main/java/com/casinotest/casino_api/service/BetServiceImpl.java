// src/main/java/com/casinotest/casino_api/service/BetServiceImpl.java
package com.casinotest.casino_api.service;

import com.casinotest.casino_api.model.Bet;
import com.casinotest.casino_api.model.User;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class BetServiceImpl extends Bet implements BetService {

    private final UserService userService;

    public BetServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean placeBet(String userId, double amount, String gameType) {
        // Retrieve the user from the UserService
        User user = userService.getUser(userId);

        if (user != null && user.getBalance() >= amount) {
            // Create a new bet
            Bet bet = new Bet();
            bet.setAmount(amount);
            bet.setGameType(gameType);
            bet.setWon(new Random().nextBoolean());

            // Update user balance based on the result of the bet
            double winnings = bet.isWon() ? amount * 2 : 0;
            user.updateBalance(winnings);

            // Add the bet to the user's betting history
            user.addBetToHistory(bet);

            // In a real-world scenario, you would likely save the updated user and the bet to a database

            return true; // Bet placed successfully
        }

        return false; // Bet unsuccessful (insufficient balance or invalid user)
    }
}
