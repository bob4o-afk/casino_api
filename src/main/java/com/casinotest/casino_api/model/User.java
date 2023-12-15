// src/main/java/com/casinotest/casino_api/User.java
package com.casinotest.casino_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class User {
    private String userId;
    private String username;
    private double balance;
    private List<Bet> betHistory;

    // Constructors, getters, and setters

    public User(String username, double initialBalance) {
        this.username = username;
        this.balance = initialBalance;
        this.userId = generateUserId(username);
        this.betHistory = new ArrayList<>();
    }

    // Method to update user balance after winning or losing a bet
    public void updateBalance(double amountWon) {
        this.balance += amountWon;
    }

    // Method to add a bet to the user's betting history
    public void addBetToHistory(Bet bet) {
        this.betHistory.add(bet);
    }

    private String generateUserId(String username) {
        String unique_id = username + UUID.randomUUID().toString();

        return unique_id;
    }
}
