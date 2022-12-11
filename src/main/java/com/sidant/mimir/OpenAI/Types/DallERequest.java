package com.sidant.mimir.OpenAI.Types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DallERequest {

    @JsonProperty("size")
    String size;

    @JsonProperty("prompt")
    String prompt;

    @JsonProperty("user")
    String user;

    public DallERequest(String size, String prompt, String user) {
        this.size = size;
        this.prompt = prompt;
        this.user = user;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
