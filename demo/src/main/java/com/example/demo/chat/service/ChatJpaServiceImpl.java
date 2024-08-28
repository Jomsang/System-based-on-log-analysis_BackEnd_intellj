package com.example.demo.chat.service;

import com.example.demo.chat.model.chatJpa;
import com.example.demo.chat.dto.ChatDto;
import com.example.demo.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.chat.mapper.ChatMapper;

import java.util.List;
import java.util.Optional;


@Service
public class ChatJpaServiceImpl implements ChatJpaService {

    private final ChatRepository chatRepository;

    @Autowired
    public ChatJpaServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public ChatDto selectChat(String userId)
    {
        // select된 chatJpaList의 메시지정보와 리스트를
        // chatDto에 넣어준 후에 return 해준다.
        List<chatJpa> chatList = chatRepository.selectChat(userId);
        return ChatMapper.toDto(chatList);
    }

    @Override
    public void insertChat(ChatDto chatDto) {
        // 새로운 메시지 저장
        // dto의 정보를 chatJpa형식으로 변환
        // dto의 message를 하나씩 풀어서 chatJpa에 넣어준다
        List<chatJpa> messages = ChatMapper.toEntityList(chatDto);
        for (chatJpa message : messages) {
            chatRepository.save(message);
        }
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