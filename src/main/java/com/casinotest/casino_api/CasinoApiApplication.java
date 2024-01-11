package com.casinotest.casino_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CasinoApiApplication {
    private static final Logger logger = LoggerFactory.getLogger(CasinoApiApplication.class);

    public static void main(String[] args) {
        logger.info("Attempting to connect to the database...");

        SpringApplication.run(CasinoApiApplication.class, args);

        logger.info("Application started successfully.");
    }
}

