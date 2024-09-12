package com.example.demo.chat.service;

import com.example.demo.chat.dto.ChatKeyInfoDto;
import com.example.demo.chat.model.ChatJpa;
import com.example.demo.chat.dto.ChatDto;
import com.example.demo.chat.repository.ChatRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.chat.mapper.ChatMapper;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;


@Service
public class ChatJpaServiceImpl implements ChatJpaService {

    private final ChatRepository chatRepository;

    @Autowired
    public ChatJpaServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public List<ChatDto> selectChat(String userId)
    {
        // select된 chatJpaList의 메시지정보와 리스트를
        // chatDto에 넣어준 후에 return 해준다.
        List<ChatJpa> chatList = chatRepository.selectChat(userId);
        List<ChatKeyInfoDto> chatKeyInfoList = chatRepository.selectChatKeyInfo(userId);
        return ChatMapper.toDto(chatList, chatKeyInfoList);
    }

    @Override
    public void insertChat(ChatDto chatDto) {
        // 새로운 메시지 저장
        // dto의 정보를 chatJpa형식으로 변환
        // dto의 message를 하나씩 풀어서 chatJpa에 넣어준다
        List<ChatJpa> messages = ChatMapper.toEntityList(chatDto);

        for (ChatJpa message : messages) {
            System.out.println("******: " + message.getMessageId() + "******" + message.getChatId() + "****" + message.getTextMessage());
            try {
                if(message.getIsUser() && message.getIsImage() && !message.getImgMessage().isEmpty()) {
                    // Base64 데이터 가져오기 (data:image/png;base64,... 형식이면 제거해야 함)
                    String base64Image = message.getImgMessage().split(",")[1]; // 콤마 이후의 실제 Base64 데이터
                    // Base64 디코딩
                    byte[] decodedBytes = Base64.getDecoder().decode(base64Image);
                    String fileName = message.getUserId() + "_" + message.getChatId() + "_" + message.getMessageId();
                    // 파일로 저장
                    File outputFile = new File("img/" + fileName + ".png"); // 저장 경로와 파일 이름 지정
                    FileUtils.writeByteArrayToFile(outputFile, decodedBytes);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            chatRepository.save(message);
        }
    }

    @Override
    public int deleteChat(String userId, Long chatId) {
         return chatRepository.deleteChat(userId, chatId);
    }

    @Override
    public String getMaxChatId(String userId) {
        return chatRepository.getMaxChatId(userId);
    }
}