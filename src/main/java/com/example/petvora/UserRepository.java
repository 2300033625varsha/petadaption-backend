package com.example.petvora;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ✅ Find user by email
    Optional<User> findByEmail(String email);

    // ✅ Find user by username
    Optional<User> findByUsername(String username);

    // ✅ Check if email already exists
    boolean existsByEmail(String email);

    // ✅ Check if username already exists
    boolean existsByUsername(String username);
}
