// src/main/java/com/casinotest/casino_api/model/Bet.java
package com.casinotest.casino_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bet {
    private String betId;
    private double amount;
    private String gameType;
    private boolean won;

    // Constructors, getters, and setters

    // Other methods as needed
}
