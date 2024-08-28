package com.example.demo.chat.dto;

public class MessageDto {

    private String textMessage;
    private String imgMessage;
    private boolean isUser;
    private boolean isImage;
    private boolean isTyping;
    private String message_id;

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

    public boolean getIsUser() {
        return isUser;
    }

    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }

    public boolean getIsImage() {
        return isImage;
    }

    public void setIsImage(boolean isImage) {
        this.isImage = isImage;
    }

    public boolean getIsTyping() {
        return isTyping;
    }

    public void setIsTyping(boolean isTyping) {
        this.isTyping = isTyping;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }


}


