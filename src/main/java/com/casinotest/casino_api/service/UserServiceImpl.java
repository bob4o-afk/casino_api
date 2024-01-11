package com.casinotest.casino_api.service;

import com.casinotest.casino_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean createUser(String username, double initial_balance) {
        String userId = generateUserId(username);
        String sql = "INSERT INTO user (user_id, username, balance) VALUES (?, ?, ?)";
        int result = jdbcTemplate.update(sql, userId, username, initial_balance);
        return result > 0;
    }

    @Override
    public boolean deleteUser(String userId) {
        String sql = "DELETE FROM user WHERE user_id = ?";
        int result = jdbcTemplate.update(sql, userId);
        return result > 0;
    }

    @Override
    public User getUser(String userId) {
        String sql = "SELECT * FROM user WHERE user_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{userId},
                    new BeanPropertyRowMapper<>(User.class));
        } catch (Exception e) {
            return null; // User not found
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public double getMoneyWon(String userId) {
        String sql = "SELECT money_won FROM user WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, Double.class);
    }

    @Override
    public double getMoneyLost(String userId) {
        String sql = "SELECT money_lost FROM user WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, Double.class);
    }

    private String generateUserId(String username) {
            return username + UUID.randomUUID().toString();
    }
    public void printUserIds() {
        String sql = "SELECT user_id FROM user";
        List<String> userIds = jdbcTemplate.queryForList(sql, String.class);

        System.out.println("User IDs:");
        for (String userId : userIds) {
            System.out.println(userId);
        }
    }

}
