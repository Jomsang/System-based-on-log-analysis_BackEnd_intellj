package com.example.chat.service;

import com.example.chat.model.chatJpa;
import com.example.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatJpaServiceImpl implements ChatJpaService {

    private final ChatRepository chatRepository;

    @Autowired
    public ChatJpaServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public List<chatJpa> selectChat(String userId) {
        return chatRepository.selectChat(userId);
    }

    @Override
    public int insertChat(chatJpa chat) {
        // 새로운 메시지 저장
        chatRepository.save(chat);
        return 1; // 성공 코드
    }

    @Override
    public int deleteChat(String userId, String chatId) {
        return chatRepository.deleteChat(userId, chatId);
    }

    @Override
    public String getMaxChatId(String userId) {
        return chatRepository.getMaxChatId(userId);
    }
}