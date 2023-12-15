// src/main/java/com/casinotest/casino_api/UserService.java
package com.casinotest.casino_api;

import com.casinotest.casino_api.User;

import java.util.List;

public interface UserService {
    boolean createUser(String username, double initial_balance);

    boolean deleteUser(String userId);

    User getUser(String userId);

    List<User> getAllUsers();

    double getMoneyWon(String userId);

    double getMoneyLost(String userId);
}
