package com.example.demo.chat.repository;

import com.example.demo.chat.dto.ChatDto;
import com.example.demo.chat.dto.ChatKeyInfoDto;
import com.example.demo.chat.dto.MessageDto;
import com.example.demo.chat.model.ChatJpa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ChatRepository extends JpaRepository<ChatJpa, String> {

    // 특정 유저의 모든 채팅방 조회
    @Query("SELECT c FROM ChatJpa c WHERE c.userId = :userId")
    List<ChatJpa> selectChat(@Param("userId") String userId);

    // 특정 유저의 모든 채팅방 조회
    @Query("SELECT new com.example.demo.chat.dto.ChatKeyInfoDto(c.userId, c.chatId, c.chatName) FROM ChatJpa c WHERE c.userId = :userId GROUP BY c.userId, c.chatId, c.chatName")
    List<ChatKeyInfoDto>  selectChatKeyInfo(@Param("userId") String userId);

    // 새로운 채팅방에 메시지 추가 (단순한 insert는 필요 없음, save() 메서드 사용)
    // save() 메서드는 JpaRepository가 기본으로 제공

    // 채팅방 삭제
    @Transactional
    @Modifying
    @Query("DELETE FROM ChatJpa c WHERE c.userId = :userId AND c.chatId = :chatId")
    int deleteChat(@Param("userId") String userId, @Param("chatId") Long chatId);

    // 특정 유저의 채팅방에서 가장 큰 chatId 가져오기
    @Query("SELECT MAX(c.chatId) FROM ChatJpa c WHERE c.userId = :userId")
    String getMaxChatId(@Param("userId") String userId);
}