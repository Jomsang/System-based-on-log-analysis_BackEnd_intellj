package com.example.demo.repository;

import com.example.demo.model.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserJpa, Long> {
    // Custom query methods can be added here if needed
}
