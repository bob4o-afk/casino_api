// src/main/java/com/casinotest/casino_api/controller/UserController.java
package com.casinotest.casino_api.controller;

import com.casinotest.casino_api.model.User;
import com.casinotest.casino_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestParam String username, @RequestParam double initial_balance) {
        boolean success = userService.createUser(username, initial_balance);
        return success ? ResponseEntity.ok("User created successfully") : ResponseEntity.badRequest().body("Invalid parameters provided");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        boolean success = userService.deleteUser(userId);
        return success ? ResponseEntity.ok("User deleted successfully") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> showUser(@PathVariable(required = false) String userId) {
        if (userId != null) {
            User user = userService.getUser(userId);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } else {
            return ResponseEntity.ok(userService.getAllUsers());
        }
    }
    
    @GetMapping("/{userId}/money-won")
    public ResponseEntity<Double> moneyWon(@PathVariable String userId) {
        double moneyWon = userService.getMoneyWon(userId);
        if (moneyWon >= 0) {
            return ResponseEntity.ok(moneyWon);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    @GetMapping("/{userId}/money-lost")
    public ResponseEntity<Double> moneyLost(@PathVariable String userId) {
        double moneyLost = userService.getMoneyLost(userId);
        if (moneyLost >= 0) {
            return ResponseEntity.ok(moneyLost);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
