package com.example.chat.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "chat_messages")
public class chatJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String userId;
    private String chatId;
    private String messageId;
    private String chatName;
    private List<Map<String, String>> textMessage;
    private String imgMessage;
    private String isImage;
    private String isUser;
    private String isTyping;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public List<Map<String, String>> getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(List<Map<String, String>> textMessage) {
        this.textMessage = textMessage;
    }

    public String getImgMessage() {
        return imgMessage;
    }

    public void setImgMessage(String imgMessage) {
        this.imgMessage = imgMessage;
    }

    public String getIsImage() {
        return isImage;
    }

    public void setIsImage(String isImage) {
        this.isImage = isImage;
    }

    public String getIsUser() {
        return isUser;
    }

    public void setIsUser(String isUser) {
        this.isUser = isUser;
    }

    public String getIsTyping() {
        return isTyping;
    }

    public void setIsTyping(String isTyping) {
        this.isTyping = isTyping;
    }
}

