package com.casinotest.casino_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Bet {
    private String betId;
    private double amount;
    private String gameType;
    private boolean won;
    private LocalDateTime createdAt;    //mb dont need it
    private final String userId;

    public Bet(String userId) {
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
    }


    // Other methods as needed

    public void setWon(boolean won) {
        this.won = won;
    }

    // Additional validation logic
    public boolean isValidBet() {
        return amount > 0.0;
    }
}
