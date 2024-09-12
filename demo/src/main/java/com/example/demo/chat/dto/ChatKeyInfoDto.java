package com.example.demo.chat.dto;

public class ChatKeyInfoDto {

    private String userId;
    private Long chatId;
    private String chatName;

    public ChatKeyInfoDto(String userId, Long chatId, String chatName) {
        this.userId = userId;
        this.chatId = chatId;
        this.chatName = chatName;
    }
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

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }


}
