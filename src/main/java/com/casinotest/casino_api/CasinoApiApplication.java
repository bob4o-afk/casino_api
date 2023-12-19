package com.casinotest.casino_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan; // Add this import

@SpringBootApplication
@ComponentScan(basePackages = "com.casinotest.casino_api")
public class CasinoApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CasinoApiApplication.class, args);
    }
}
