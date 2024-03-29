package com.casinotest.casino_api.service;

import com.casinotest.casino_api.model.User;

import java.util.List;

public interface UserService {
    public void initializeDatabase();

    boolean createUser(String username, double initial_balance);

    boolean deleteUser(String userId);

    User getUser(String userId);

    List<User> getAllUsers();

    double getMoneyWon(String userId);

    double getMoneyLost(String userId);

    void printUserIds();
}
