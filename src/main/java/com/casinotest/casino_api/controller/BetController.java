package com.casinotest.casino_api.controller;

import com.casinotest.casino_api.model.Bet;
import com.casinotest.casino_api.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bet")
public class BetController {

    @Autowired
    private BetService betService;

    @PostMapping
    public ResponseEntity<String> placeBet(@RequestParam String userId, @RequestParam double amount, @RequestParam String gameType) {
        boolean success = betService.placeBet(userId, amount, gameType);
        return success ? ResponseEntity.ok("Bet placed successfully") : ResponseEntity.badRequest().body("Invalid parameters provided");
    }

    @GetMapping("/{userId}/betting-history")
    public ResponseEntity<List<Bet>> getBettingHistory(@PathVariable String userId) {
        List<Bet> bettingHistory = betService.getBettingHistory(userId);
        return ResponseEntity.ok(bettingHistory);
    }

    @GetMapping("/print-betting-history/{userId}")
    public ResponseEntity<?> printBettingHistory(@PathVariable String userId) {
        betService.printBettingHistory(userId);
        return ResponseEntity.ok("Betting history printed to console");
    }


    @GetMapping("/{userId}/amount-won")
    public ResponseEntity<Double> getAmountWon(@PathVariable String userId) {
        double amountWon = betService.getAmountWon(userId);
        return ResponseEntity.ok(amountWon);
    }

    @GetMapping("/{userId}/amount-lost")
    public ResponseEntity<Double> getAmountLost(@PathVariable String userId) {
        double amountLost = betService.getAmountLost(userId);
        return ResponseEntity.ok(amountLost);
    }

}
