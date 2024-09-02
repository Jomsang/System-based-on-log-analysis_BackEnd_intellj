package com.example.demo.chat.model;

import java.io.Serializable;
import java.util.Objects;

public class ChatMessageId implements Serializable {
    private String userId;
    private Long chatId;
    private String messageId;

    // 기본 생성자
    public ChatMessageId() {}

    public ChatMessageId(String userId, Long chatId, String messageId) {
        this.userId = userId;
        this.chatId = chatId;
        this.messageId = messageId;
    }

    // equals와 hashCode 반드시 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessageId that = (ChatMessageId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(chatId, that.chatId) &&
                Objects.equals(messageId, that.messageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, chatId, messageId);
    }

    // Getters and setters (생략 가능, 필요시 추가)
}
