package com.sidant.mimir.OpenAI.Types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TextCompletionResponse {

    @JsonProperty("id")
    String id;

    @JsonProperty("object")
    String object;

    @JsonProperty("created")
    Long created;

    @JsonProperty("model")
    String model;

    @JsonProperty("choices")
    Choices[] choices;

    @JsonProperty("usage")
    Usage usage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Choices[] getChoices() {
        return choices;
    }

    public void setChoices(Choices[] choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
