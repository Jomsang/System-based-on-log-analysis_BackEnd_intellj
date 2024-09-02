package com.example.demo.chat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chat_messages")
@IdClass(ChatMessageId.class)

public class ChatJpa {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    @Id
    private Long chatId;
    @Id
    private String messageId;
    private String chatName;
    private String textMessage;
    private String imgMessage;
    private Boolean isImage;
    private Boolean isUser;
    private Boolean isTyping;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
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

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getImgMessage() {
        return imgMessage;
    }

    public void setImgMessage(String imgMessage) {
        this.imgMessage = imgMessage;
    }

    public Boolean getIsImage() {
        return isImage;
    }

    public void setIsImage(Boolean isImage) {
        this.isImage = isImage;
    }

    public Boolean getIsUser() {
        return isUser;
    }

    public void setIsUser(Boolean isUser) {
        this.isUser = isUser;
    }

    public Boolean getIsTyping() {
        return isTyping;
    }

    public void setIsTyping(Boolean isTyping) {
        this.isTyping = isTyping;
    }
}

