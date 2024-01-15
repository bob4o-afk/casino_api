package com.casinotest.casino_api.service;

import com.casinotest.casino_api.model.Bet;
import com.casinotest.casino_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

@Service
public class BetServiceImpl implements BetService {

    private final UserService userService;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
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
        User user = userService.getUser(userId);

        if (user != null && user.getBalance() >= amount) {
            Bet bet = new Bet(userId);
            bet.setAmount(amount);
            bet.setGameType(gameType);
            bet.setWon(determineBetOutcome());

            double winnings = bet.isWon() ? amount * 2 : 0;
            user.updateBalance(winnings);
            user.addBetToHistory(bet);

            // Insert the bet into the database
            String insertBetSql = "INSERT INTO bet (bet_id, amount, game_type, won, user_id) VALUES (?, ?, ?, ?, ?)";
            String betId = generateBetId(); // You need to implement this method
            jdbcTemplate.update(insertBetSql, betId, amount, gameType, bet.isWon(), userId);

            return true; // Bet placed successfully
        }

        return false; // Bet unsuccessful (insufficient balance or invalid user)
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

    // Implement this method to generate unique bet IDs
    private String generateBetId() {
        // Your implementation here
        return "bet" + System.currentTimeMillis();
    }
}
