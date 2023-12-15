// src/main/java/com/casinotest/casino_api/User.java
package com.casinotest.casino_api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String userId;
    private String username;
    private double balance;
    // Add any other user-related fields as needed
}
