package com.sidant.mimir.TelegramBot;

import com.sidant.mimir.TelegramBot.Types.Message;
import com.sidant.mimir.TelegramBot.Types.PhotoMessageRequest;
import com.sidant.mimir.TelegramBot.Types.TextMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public abstract class Methods {

    @Autowired
    RestTemplate restTemplate;

    abstract String getAuthKey();

    private String getResourceUrl(String methodName){
        return "https://api.telegram.org/bot" +
                getAuthKey() + "/" + methodName;
    }

    protected void sendTextMessage(
            Integer chatId,
            String textMessage) {

        HttpEntity<TextMessageRequest> request = new HttpEntity<>(new TextMessageRequest(chatId, textMessage));

        ResponseEntity<Message> response = restTemplate.exchange(
                getResourceUrl("sendMessage"),
                HttpMethod.POST,
                request,
                Message.class);

        Message message = response.getBody();
        // TODO: add logging
        response.getStatusCode();
    }

    protected void sendPhotoMessage(
            Integer chatId,
            String photoUrl) {

        HttpEntity<PhotoMessageRequest> request = new HttpEntity<>(new PhotoMessageRequest(chatId, photoUrl));

        ResponseEntity<Message> response = restTemplate.exchange(
                getResourceUrl("sendPhoto"),
                HttpMethod.POST,
                request,
                Message.class);

        Message message = response.getBody();
        response.getStatusCode();
    }


}
