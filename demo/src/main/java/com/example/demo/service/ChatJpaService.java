package com.example.demo.service;

import com.example.demo.model.chatJpa;

import java.util.List;

public interface ChatJpaService {

    List<chatJpa> selectChat(String userId);
    int insertChat(int chatId);
    int deleteChat(int chatId);
    int getMaxChatId(int chatId);


}
