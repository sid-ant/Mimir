package com.sidant.mimir.OpenAI.Types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TextCompletionRequest {

    @JsonProperty("model")
    String model;

    @JsonProperty("prompt")
    String prompt;

    @JsonProperty("temperature")
    Double temperature;

    @JsonProperty("max_tokens")
    Integer maxTokens;

    public TextCompletionRequest(String model, String prompt, Double temperature, Integer maxTokens) {
        this.model = model;
        this.prompt = prompt;
        this.temperature = temperature;
        this.maxTokens = maxTokens;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }
}
