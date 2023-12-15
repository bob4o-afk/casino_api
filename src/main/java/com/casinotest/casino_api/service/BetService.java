// src/main/java/com/casinotest/casino_api/service/BetService.java
package com.casinotest.casino_api.service;

public interface BetService {
    boolean placeBet(String userId, double amount, String gameType);
}
