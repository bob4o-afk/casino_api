package com.casinotest.casino_api.service;

import com.casinotest.casino_api.model.Bet;

import java.util.List;

public interface BetService {
    boolean placeBet(String userId, double amount, String gameType);

    List<Bet> getBettingHistory(String userId);

    double getAmountWon(String userId);

    double getAmountLost(String userId);
    
}
