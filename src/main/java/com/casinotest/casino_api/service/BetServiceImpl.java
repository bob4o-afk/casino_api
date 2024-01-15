package com.casinotest.casino_api.service;

import com.casinotest.casino_api.model.Bet;
import com.casinotest.casino_api.model.User;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.PostConstruct;

@Service
public class BetServiceImpl implements BetService {

    private final UserService userService;
    private final JdbcTemplate jdbcTemplate;

    public BetServiceImpl(UserService userService, JdbcTemplate jdbcTemplate) {
        this.userService = userService;
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void initializeDatabase() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS bet (" +
                "bet_id VARCHAR(255) PRIMARY KEY," +
                "amount DOUBLE NOT NULL," +
                "game_type VARCHAR(255) NOT NULL," +
                "won BOOLEAN NOT NULL," +
                "user_id VARCHAR(255) NOT NULL," +
                "FOREIGN KEY (user_id) REFERENCES user(user_id)" +
                ")";
        jdbcTemplate.execute(createTableSQL);
    }

    private boolean determineBetOutcome() {
        return new Random().nextBoolean();
    }

    @Override
    public boolean placeBet(String userId, double amount, String gameType) {
        // Check for null values
        if (userId == null || gameType == null) {
            return false; // Indicate failure due to null values
        }
    
        initializeDatabase();
    
        User user = userService.getUser(userId);
    
        if (user != null && user.getBalance() >= amount) {
            if(user.getBetHistory() == null){
                ArrayList<Bet> betHistory = new ArrayList<Bet>();
                user.setBetHistory(betHistory);
            }
            Bet bet = new Bet(userId);
            bet.setAmount(amount);
            bet.setGameType(gameType);
            bet.setWon(determineBetOutcome());
    
            double winnings = bet.isWon() ? amount * 2 : amount * (-1);
            String betId = generateBetId();
            bet.setBetId(betId);
            user.updateBalance(winnings);

            System.out.println(bet);
            System.out.println(user);

    
            try {
                String insertBetSql = "INSERT INTO bet (bet_id, amount, game_type, won, user_id) VALUES (?, ?, ?, ?, ?)";
                jdbcTemplate.update(insertBetSql, betId, amount, gameType, bet.isWon(), userId);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
    
            user.addBetToHistory(bet);
            System.out.println("Bet placed successfully");
            System.out.println(user);
            return true; // Bet placed successfully
        }
    
        return false; // Indicate failure due to insufficient balance or user not found
    }
    

    @Override
    public List<Bet> getBettingHistory(String userId) {
        String sql = "SELECT * FROM bet WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(Bet.class));
    }

    

    @Override
    public double getAmountWon(String userId) {
        String sql = "SELECT SUM(amount) FROM bet WHERE user_id = ? AND won = true";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, Double.class);
    }

    @Override
    public double getAmountLost(String userId) {
        String sql = "SELECT SUM(amount) FROM bet WHERE user_id = ? AND won = false";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, Double.class);
    }

    // Add other methods as needed
    private String generateBetId() {
        return "bet" + UUID.randomUUID().toString();
    }

    @Override
    public void printBettingHistory(String userId) {
        List<Bet> bettingHistory = getBettingHistory(userId);

        if (bettingHistory.isEmpty()) {
            System.out.println("No betting history available for user with ID: " + userId);
        } else {
            System.out.println("Betting history for user with ID: " + userId);
            for (Bet bet : bettingHistory) {
                System.out.println(bet);
            }
        }
    }

}
