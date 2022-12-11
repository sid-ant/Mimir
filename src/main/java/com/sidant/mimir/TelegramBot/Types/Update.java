package com.sidant.mimir.TelegramBot.Types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Update {

    @JsonProperty("update_id")
    Long updateId;

    @JsonProperty("message")
    Message message;
    @JsonProperty("edited_message")
    Message editedMessage;
    Message channelPost;
    Message editedChannelPost;

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message getEditedMessage() {
        return editedMessage;
    }

    public void setEditedMessage(Message editedMessage) {
        this.editedMessage = editedMessage;
    }

    public Message getChannelPost() {
        return channelPost;
    }

    public void setChannelPost(Message channelPost) {
        this.channelPost = channelPost;
    }

    public Message getEditedChannelPost() {
        return editedChannelPost;
    }

    public void setEditedChannelPost(Message editedChannelPost) {
        this.editedChannelPost = editedChannelPost;
    }

}
