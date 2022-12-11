package com.sidant.mimir.TelegramBot.Types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class LongPollRequest {

    @JsonProperty("offset")
    Long offset;

    @JsonProperty("limit")
    Integer limit;

    @JsonProperty("timeout")
    Integer timeout;

    @JsonProperty("allowed_updates")
    String[] allowedUpdates;

    public LongPollRequest(Long offset, Integer limit, Integer timeout, String[] allowedUpdates) {
        this.offset = offset;
        this.limit = limit;
        this.timeout = timeout;
        this.allowedUpdates = allowedUpdates;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String[] getAllowedUpdates() {
        return allowedUpdates;
    }

    public void setAllowedUpdates(String[] allowedUpdates) {
        this.allowedUpdates = allowedUpdates;
    }


    @Override
    public String toString() {
        return "LongPollRequest{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", timeout=" + timeout +
                ", allowedUpdates=" + Arrays.toString(allowedUpdates) +
                '}';
    }
}
