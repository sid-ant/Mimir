package com.sidant.mimir.TelegramBot.Types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    @JsonProperty("message_id")
    Long messageId;

    @JsonProperty("from")
    User from;

    @JsonProperty("sender_chat")
    Chat senderChat;

    @JsonProperty("date")
    Long date; // Epoch

    @JsonProperty("chat")
    Chat chat;

    @JsonProperty("text")
    String text;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public Chat getSenderChat() {
        return senderChat;
    }

    public void setSenderChat(Chat senderChat) {
        this.senderChat = senderChat;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



}
