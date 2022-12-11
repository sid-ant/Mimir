package com.sidant.mimir.TelegramBot.Types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LongPollResponse {

    @JsonProperty("ok")
    boolean ok;

    @JsonProperty("result")
    Update[] result;

    public boolean getOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Update[] getResult() {
        return result;
    }

    public void setResult(Update[] result) {
        this.result = result;
    }
}
