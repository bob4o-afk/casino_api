DROP DATABASE IF EXISTS Casino_api;

CREATE DATABASE IF NOT EXISTS Casino_api;

USE Casino_api;

-- Create the User table
CREATE TABLE user (
    user_id VARCHAR(50) PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL  -- Example: Represents a monetary value with up to 10 digits, 2 of which are after the decimal point
);

-- Create the Bet table
CREATE TABLE bet (
    bet_id VARCHAR(50) PRIMARY KEY,
    amount DECIMAL(10, 2) NOT NULL,  -- Example: Represents a monetary value with up to 10 digits, 2 of which are after the decimal point
    game_type VARCHAR(100) NOT NULL,
    won BOOLEAN NOT NULL,
    user_id VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    INDEX (user_id)
);