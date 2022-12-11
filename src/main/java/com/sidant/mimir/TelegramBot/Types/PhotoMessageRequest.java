package com.sidant.mimir.TelegramBot.Types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhotoMessageRequest {
    @JsonProperty("chat_id")
    Long chatId;

    @JsonProperty("photo")
    String photo;

    public PhotoMessageRequest(Long chatId, String photo) {
        this.chatId = chatId;
        this.photo = photo;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
