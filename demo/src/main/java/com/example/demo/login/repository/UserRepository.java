package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods can be added here if needed
    @Query("SELECT COUNT(*) FROM User WHERE userid = :userid AND password = :password AND status = 'ACTIVE'")
    int login(@Param("userid") String userid, @Param("password") String password);

    @Query("SELECT COUNT(*) FROM User WHERE userid = :userid")
    int duplicateCheckUser(@Param("userid") String userid);
}
