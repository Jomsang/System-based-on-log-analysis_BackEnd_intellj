package com.example.chat.service;

import com.example.chat.model.chatJpa;

import java.util.List;

public interface ChatJpaService {

    List<chatJpa> selectChat(String userId);
    int insertChat(chatJpa chat);
    int deleteChat(String userId, String chatId);
    String getMaxChatId(String userId);


}
