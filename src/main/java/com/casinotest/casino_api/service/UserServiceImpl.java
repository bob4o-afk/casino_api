// src/main/java/com/casinotest/casino_api/UserServiceImpl.java
package com.casinotest.casino_api.service;

import com.casinotest.casino_api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @Override
    public boolean createUser(String username, double initial_balance) {
        User newUser = new User(username, initial_balance);
        return users.add(newUser);
    }

    @Override
    public boolean deleteUser(String userId) {
        User userToRemove = getUser(userId);
        if (userToRemove != null) {
            users.remove(userToRemove);
            return true;
        }
        return false;
    }

    @Override
    public User getUser(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public double getMoneyWon(String userId) {
        User user = getUser(userId);
        return (user != null) ? user.getMoneyWon() : -1;
    }

    @Override
    public double getMoneyLost(String userId) {
        User user = getUser(userId);
        return (user != null) ? user.getMoneyLost() : -1;
    }
}
