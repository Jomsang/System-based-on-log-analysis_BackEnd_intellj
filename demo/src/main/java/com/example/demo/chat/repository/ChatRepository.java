package com.example.demo.chat.repository;

import com.example.demo.chat.model.chatJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<chatJpa, Long> {

    // 특정 유저의 모든 채팅방 조회
    @Query("SELECT c FROM chatJpa c WHERE c.userId = :userId")
    List<chatJpa> selectChat(@Param("userId") String userId);

    // 새로운 채팅방에 메시지 추가 (단순한 insert는 필요 없음, save() 메서드 사용)
    // save() 메서드는 JpaRepository가 기본으로 제공

    // 채팅방 삭제
    @Query("DELETE FROM chatJpa c WHERE c.userId = :userId AND c.chatId = :chatId")
    int deleteChat(@Param("userId") String userId, @Param("chatId") String chatId);

    // 특정 유저의 채팅방에서 가장 큰 chatId 가져오기
    @Query("SELECT MAX(c.chatId) FROM chatJpa c WHERE c.userId = :userId")
    String getMaxChatId(@Param("userId") String userId);
}