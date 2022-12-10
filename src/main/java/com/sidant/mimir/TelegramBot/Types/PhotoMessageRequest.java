package com.sidant.mimir.TelegramBot.Types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhotoMessageRequest {
    @JsonProperty("chat_id")
    Integer chatId;

    @JsonProperty("photo")
    String photo;

    public PhotoMessageRequest(Integer chatId, String photo) {
        this.chatId = chatId;
        this.photo = photo;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
