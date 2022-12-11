package com.sidant.mimir.TelegramBot.Types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TextMessageRequest {
    @JsonProperty("chat_id")
    Long chatId;

    @JsonProperty("text")
    String text;

    public TextMessageRequest(Long chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
