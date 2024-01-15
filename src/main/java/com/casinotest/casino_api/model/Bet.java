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
    private String userId;

    public Bet(){
        this.createdAt = LocalDateTime.now();
    }

    public Bet(String userId) {
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
    }

    public void setBetId(String betId){
        this.betId = betId;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean isWon(){
        return this.won;
    }

    public boolean isValidBet() {
        return amount > 0.0;
    }
}
