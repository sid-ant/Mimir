package com.sidant.mimir.TelegramBot;

import com.sidant.mimir.TelegramBot.Types.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;

import static java.lang.Math.max;

@Component
public abstract class Methods {

    Logger logger = LoggerFactory.getLogger(Methods.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    abstract String getAuthKey();

    abstract void handleUpdate(Update update);

    private String getResourceUrl(String methodName){
        return "https://api.telegram.org/bot" +
                getAuthKey() + "/" + methodName;
    }

    public void startPolling(Integer timeout) {

        Long offset = 0L;
        try {
            while (true) {
                logger.info("poll offset: {}", offset);
                offset = longPoll(offset, timeout);
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            logger.info("error in polling");
        }
    }

    protected Long longPoll(
            Long offset,
            Integer longPollTimeout) {

        Long nextOffset = offset;

        RestTemplate customRestTemplate =  restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(longPollTimeout))
                .setReadTimeout(Duration.ofSeconds(longPollTimeout))
                .build();

        HttpEntity<LongPollRequest> request = new HttpEntity<>(new LongPollRequest(offset,
                100, longPollTimeout, new String[]{"message"}));

        try {
            String resourceUrl = getResourceUrl("getUpdates");
            logger.info("url formed {}",resourceUrl);

            ResponseEntity<LongPollResponse> response = customRestTemplate.exchange(
                    resourceUrl,
                    HttpMethod.POST,
                    request,
                    LongPollResponse.class);

            if (response.getBody() == null) {
                return nextOffset;
            }

            for (Update upd : response.getBody().getResult()) {
                nextOffset = max(offset, upd.getUpdateId()) + 1;
                handleUpdate(upd);
            }

            logger.info("sendTextMessage status {}",response.getStatusCode());
        }  catch (Exception e) {
            logger.error("Error in longPoll {}", e.getMessage());
        }
        return nextOffset;

    }

    protected void sendTextMessage(
            Long chatId,
            String textMessage) {

        logger.info("sendTextMessage start");

        HttpEntity<TextMessageRequest> request = new HttpEntity<>(new TextMessageRequest(chatId, textMessage));

        try {
            String resourceUrl = getResourceUrl("sendMessage");
            logger.info("url formed {}",resourceUrl);

            ResponseEntity<Message> response = restTemplate.exchange(
                    resourceUrl,
                    HttpMethod.POST,
                    request,
                    Message.class);

            Message message = response.getBody();
            logger.info("sendTextMessage resp {}",message);
            logger.info("sendTextMessage status {}",response.getStatusCode());
        }  catch (Exception e) {
            logger.error("Error in sendTextMessage {}", e.getMessage());
        }

        logger.info("sendTextMessage end");

    }

    protected void sendPhotoMessage(
            Long chatId,
            String photoUrl) {

        logger.info("sendPhotoMessage start");
        HttpEntity<PhotoMessageRequest> request = new HttpEntity<>(new PhotoMessageRequest(chatId, photoUrl));

        try {
            String resourceUrl = getResourceUrl("sendPhoto");
            logger.info("url formed {}",resourceUrl);
            ResponseEntity<Message> response = restTemplate.exchange(
                    resourceUrl,
                    HttpMethod.POST,
                    request,
                    Message.class);
            Message message = response.getBody();
            logger.info("sendPhotoMessage resp {}",message);
            logger.info("sendPhotoMessage status {}",response.getStatusCode());
        } catch (Exception e){
            logger.error("Error in sendPhotoMessage {}", e.getMessage());
        }

        logger.info("sendPhotoMessage end");

    }


}
