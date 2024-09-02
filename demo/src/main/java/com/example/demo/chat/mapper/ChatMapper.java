package com.example.demo.chat.mapper;
import com.example.demo.chat.dto.ChatDto;
import com.example.demo.chat.dto.ChatKeyInfoDto;
import com.example.demo.chat.dto.MessageDto;
import com.example.demo.chat.model.ChatJpa;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ChatMapper {


    public static List<ChatJpa> toEntityList(ChatDto chatDto) {
        return chatDto.getMessages().stream().map(messageDto -> {
            ChatJpa message = new ChatJpa();
            message.setMessageId(messageDto.getMessageId());
            message.setTextMessage(messageDto.getTextMessage());
            message.setImgMessage(messageDto.getImgMessage());
            message.setIsUser(messageDto.getIsUser());
            message.setIsImage(messageDto.getIsImage());
            message.setIsTyping(messageDto.getIsTyping());
            message.setUserId(chatDto.getUserId());
            message.setChatId(chatDto.getChatId());
            message.setChatName(chatDto.getChatName());
            return message;
        }).collect(Collectors.toList());
    }

    public static List<ChatDto> toDto(List<ChatJpa> chatJpaList, List<ChatKeyInfoDto> chatKeyInfoList) {
        if (chatJpaList.isEmpty()) {
            List<ChatDto> chatdtoList = new ArrayList<>();
            return chatdtoList; // or throw an exception if appropriate
        }

        //1. 어차피 로그인한 아이디의 채팅방을 불러오는것이므로
        //2. chatJpaList를 순회하면서 hashmap<String, List<MessageDto>> 선언해서 chatid당 message를 모은다.
        //3. stream 구문 이용해서 chatDto에 userId, chatId,, chatNm 넣어주고 hashmap에서 chatId에 해당하는 message 찾아서 chatDto에 넣어줌
        //4. chatDto 반환


        HashMap<Long, List<MessageDto>> hashMap = new HashMap<>();
        for (ChatJpa chatJpa : chatJpaList){
            MessageDto messageDto = new MessageDto();
            messageDto.setMessageId(chatJpa.getMessageId());
            messageDto.setTextMessage(chatJpa.getTextMessage());
            messageDto.setImgMessage(chatJpa.getImgMessage());
            messageDto.setIsUser(chatJpa.getIsUser());
            messageDto.setIsImage(chatJpa.getIsImage());
            messageDto.setIsTyping(chatJpa.getIsTyping());
            if(!hashMap.containsKey(chatJpa.getChatId())){hashMap.put(chatJpa.getChatId(), new ArrayList<>());}
            hashMap.get(chatJpa.getChatId()).add(messageDto);
        }

        List<ChatDto> chatDtoList = chatKeyInfoList.stream().map(chatKeyInfo -> {
            ChatDto chatDto = new ChatDto();
            chatDto.setChatId(chatKeyInfo.getChatId());
            chatDto.setUserId(chatKeyInfo.getUserId());
            chatDto.setChatName(chatKeyInfo.getChatName());
            chatDto.setMessages(hashMap.get(chatKeyInfo.getChatId()));
            return chatDto;
        }).collect(Collectors.toList());

        return chatDtoList;
    }
}

