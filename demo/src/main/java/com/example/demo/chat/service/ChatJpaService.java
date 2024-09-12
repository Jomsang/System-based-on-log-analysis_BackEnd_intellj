package com.example.demo.chat.service;

import com.example.demo.chat.dto.ChatDto;

import java.util.List;

public interface ChatJpaService {

    List<ChatDto> selectChat(String userId);
    void insertChat(ChatDto chat);
    int deleteChat(String userId, Long chatId);
    String getMaxChatId(String userId);


}
