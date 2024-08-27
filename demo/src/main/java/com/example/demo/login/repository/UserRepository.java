package com.example.demo.login.repository;

import com.example.demo.login.model.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserJpa, Long> {
    // Custom query methods can be added here if needed
    @Query("SELECT COUNT(*) FROM UserJpa WHERE userid = :userid AND password = :password")
    int login(@Param("userid") String userid, @Param("password") String password);
}
