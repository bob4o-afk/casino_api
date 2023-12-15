// src/main/java/com/casinotest/casino_api/BetService.java
package com.casinotest.casino_api;

public interface BetService {
    boolean placeBet(String userId, double amount, String gameType);
}
