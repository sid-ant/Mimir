package com.sidant.mimir.TelegramBot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public abstract class Methods {

    @Autowired
    RestTemplate restTemplate;

    abstract String getAuthKey();

    protected void sendTextMessage(Integer chatId, String textMessage) {

    }


}
