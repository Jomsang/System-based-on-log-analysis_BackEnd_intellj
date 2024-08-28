package com.example.demo.chat.mapper;
import com.example.demo.chat.dto.ChatDto;
import com.example.demo.chat.dto.MessageDto;
import com.example.demo.chat.model.chatJpa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChatMapper {


    public static List<chatJpa> toEntityList(ChatDto chatDto) {
        return chatDto.getMessages().stream().map(messageDto -> {
            chatJpa message = new chatJpa();
            message.setMessageId(messageDto.getMessage_id().toString());
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

    public static ChatDto toDto(List<chatJpa> chatJpaList) {
        if (chatJpaList.isEmpty()) {
            return new ChatDto(); // or throw an exception if appropriate
        }

        ChatDto chatDto = new ChatDto();
        chatDto.setChatId(chatJpaList.get(0).getChatId());
        chatDto.setUserId(chatJpaList.get(0).getUserId());
        chatDto.setChatName(chatJpaList.get(0).getChatName());

        List<MessageDto> messages = chatJpaList.stream().map(chatJpa -> {
            MessageDto messageDto = new MessageDto();
            messageDto.setMessage_id(chatJpa.getMessageId());
            messageDto.setTextMessage(chatJpa.getTextMessage());
            messageDto.setImgMessage(chatJpa.getImgMessage());
            messageDto.setIsUser(chatJpa.getIsUser());
            messageDto.setIsImage(chatJpa.getIsImage());
            messageDto.setIsTyping(chatJpa.getIsTyping());
            return messageDto;
        }).collect(Collectors.toList());

        chatDto.setMessages(messages);
        return chatDto;
    }
}

