// src/main/java/com/casinotest/casino_api/controller/BetController.java
package com.casinotest.casino_api.controller;

import com.casinotest.casino_api.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
