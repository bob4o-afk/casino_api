// src/main/java/com/casinotest/casino_api/UserServiceImpl.java
package com.casinotest.casino_api;

import com.casinotest.casino_api.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @Override
    public boolean createUser(String username, double initial_balance) {
        // Implement logic to create a new user
        // Return true if successful, false otherwise
        return false;
    }

    @Override
    public boolean deleteUser(String userId) {
        // Implement logic to delete a user
        // Return true if successful, false otherwise
        return false;
    }

    @Override
    public User getUser(String userId) {
        // Implement logic to retrieve a user by userId
        // Return the user if found, null otherwise
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        // Implement logic to retrieve all users
        // Return the list of users
        return users;
    }

    @Override
    public double getMoneyWon(String userId) {
        // Implement logic to retrieve the amount of money won by a user
        // Return the amount if the user is found, -1 otherwise
        return -1;
    }

    @Override
    public double getMoneyLost(String userId) {
        // Implement logic to retrieve the amount of money lost by a user
        // Return the amount if the user is found, -1 otherwise
        return -1;
    }
}
