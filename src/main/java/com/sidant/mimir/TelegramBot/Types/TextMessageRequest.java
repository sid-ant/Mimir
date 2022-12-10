package com.sidant.mimir.TelegramBot.Types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TextMessageRequest {
    @JsonProperty("chat_id")
    Integer chatId;

    @JsonProperty("text")
    String text;

    public TextMessageRequest(Integer chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
