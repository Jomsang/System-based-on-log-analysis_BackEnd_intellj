package com.example.demo.repository;

import com.example.demo.model.chatJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

    public interface ChatRepository extends JpaRepository<chatJpa, Long> {
        @Query("SELECT COUNT(*) FROM chat_messages WHERE userid = :userid AND password = :password")
        int selectChat(@Param("userid") String userid, @Param("password") String password);

}
