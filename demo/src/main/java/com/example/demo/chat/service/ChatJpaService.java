package com.example.demo.chat.service;

import com.example.demo.chat.model.chatJpa;
import com.example.demo.chat.dto.ChatDto;
import java.util.List;

public interface ChatJpaService {

    ChatDto selectChat(String userId);
    void insertChat(ChatDto chat);
    int deleteChat(String userId, String chatId);
    String getMaxChatId(String userId);


}
