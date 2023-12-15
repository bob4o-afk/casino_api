// src/main/java/com/casinotest/casino_api/UserRepository.java

package com.casinotest.casino_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom queries if needed
}
