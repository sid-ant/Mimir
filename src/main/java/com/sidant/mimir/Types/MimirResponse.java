package com.sidant.mimir.Types;

public class MimirResponse {

    private String content;
    private MessageType messageType;

    public MimirResponse(String content, MessageType messageType) {
        this.content = content;
        this.messageType = messageType;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }


}
