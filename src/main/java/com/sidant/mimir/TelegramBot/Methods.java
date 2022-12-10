package com.sidant.mimir.TelegramBot;

import com.sidant.mimir.TelegramBot.Types.Message;
import com.sidant.mimir.TelegramBot.Types.PhotoMessageRequest;
import com.sidant.mimir.TelegramBot.Types.TextMessageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public abstract class Methods {

    Logger logger = LoggerFactory.getLogger(Methods.class);

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

        try {
            ResponseEntity<Message> response = restTemplate.exchange(
                    getResourceUrl("sendMessage"),
                    HttpMethod.POST,
                    request,
                    Message.class);

            Message message = response.getBody();
            response.getStatusCode();
            logger.info("sendTextMessage resp {}",message);
            logger.info("sendTextMessage status {}",response.getStatusCode());
        }  catch (Exception e) {
            logger.error("Error in sendTextMessage {}", e.getMessage());
        }

    }

    protected void sendPhotoMessage(
            Integer chatId,
            String photoUrl) {

        HttpEntity<PhotoMessageRequest> request = new HttpEntity<>(new PhotoMessageRequest(chatId, photoUrl));

        try {
            ResponseEntity<Message> response = restTemplate.exchange(
                    getResourceUrl("sendPhoto"),
                    HttpMethod.POST,
                    request,
                    Message.class);
            Message message = response.getBody();
            logger.info("sendPhotoMessage resp {}",message);
            logger.info("sendPhotoMessage status {}",response.getStatusCode());
        } catch (Exception e){
            logger.error("Error in sendPhotoMessage {}", e.getMessage());
        }

    }


}
