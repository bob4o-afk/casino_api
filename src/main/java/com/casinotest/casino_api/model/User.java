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
    public User(){

    }

    public User(String username, double initialBalance) {
        // Validate initial balance
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be non-negative");
        }

        this.username = username;
        this.balance = initialBalance;
        this.userId = generateUserId(username);
        this.betHistory = new ArrayList<Bet>();
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
        return username + UUID.randomUUID().toString();
    }

    // Method to get the total amount of money won by the user
    public double getMoneyWon() {
        return betHistory.stream()
                .filter(Bet::isWon)
                .mapToDouble(Bet::getAmount)
                .sum();
    }

    // Method to get the total amount of money lost by the user
    public double getMoneyLost() {
        return betHistory.stream()
                .filter(bet -> !bet.isWon())
                .mapToDouble(Bet::getAmount)
                .sum();
    }
}
