-- Create the User table
CREATE TABLE user (
    user_id VARCHAR(50) PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    balance DOUBLE NOT NULL
);

-- Create the Bet table
CREATE TABLE bet (
    bet_id VARCHAR(50) PRIMARY KEY,
    amount DOUBLE NOT NULL,
    game_type VARCHAR(100) NOT NULL,
    won BOOLEAN NOT NULL,
    user_id VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    INDEX (user_id)  -- Consider adding an index for frequently queried columns
);
