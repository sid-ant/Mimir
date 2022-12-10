package com.sidant.mimir.TelegramBot.Types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    @JsonProperty("message_id")
    Integer messageId;

    @JsonProperty("message_thread_id")
    Integer messageThreadId; // Optional

    @JsonProperty("from")
    User from;

    @JsonProperty("sender_chat")
    Chat senderChat;

    @JsonProperty("date")
    Integer date; // Epoch

    @JsonProperty("chat")
    Chat chat;

    @JsonProperty("text")
    String text;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getMessageThreadId() {
        return messageThreadId;
    }

    public void setMessageThreadId(Integer messageThreadId) {
        this.messageThreadId = messageThreadId;
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

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
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
