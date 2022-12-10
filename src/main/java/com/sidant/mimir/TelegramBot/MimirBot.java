package com.sidant.mimir.TelegramBot;

import com.sidant.mimir.ContentMessages;
import com.sidant.mimir.Exceptions.UnsupportedOperation;
import com.sidant.mimir.Model.TelemetryService;
import com.sidant.mimir.Model.UsageService;
import com.sidant.mimir.Model.UserService;
import com.sidant.mimir.TelegramBot.Types.Message;
import com.sidant.mimir.TelegramBot.Types.Update;
import com.sidant.mimir.TelegramBot.Types.User;
import com.sidant.mimir.Types.MessageType;
import com.sidant.mimir.Types.MimirResponse;
import com.sidant.mimir.Utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MimirBot extends Methods {

    @Autowired
    UserService userService;

    @Autowired
    UsageService usageService;

    @Autowired
    TelemetryService telemetryService;

    Logger logger = LoggerFactory.getLogger(MimirBot.class);

    @Value("${mimir.key}")
    private String authKey;

    @Override
    String getAuthKey() {
        return authKey;
    }

    public void handleUpdate(Update update) {

        logger.info("handleUpdate start");

        MimirResponse response;

        Message message = update.getMessage();
        Integer chatId = message.getChat().getId();
        User telegramUser = message.getFrom();
        Long userId = telegramUser.getId();

        // TODO: handle active boolean flag too
        Boolean isUserRegistered = userService.isUserRegistered(userId);
        String textMessage = message.getText();

        try {
            Helper.validateText(textMessage);

            String commandIdentifier = "/";
            if (textMessage.startsWith(commandIdentifier))
                response = handleCommand(textMessage, isUserRegistered,telegramUser);
            else
                response = isUserRegistered ?
                        handleContent(textMessage) :
                        new MimirResponse(onboardNewUser(telegramUser), MessageType.TEXT);
        }
        catch (UnsupportedOperation ex) {
            response = new MimirResponse(ex.getMessage(), MessageType.TEXT);
        }

        logger.info("response is {}",response.getContent());

        // Please note that entire bot calls sendMessage only from here.
         sendMessage(chatId, response);

        // TODO : The following usage and telemetry updates should happen asynchronously ( vis a queue? )
        logger.info("telemetry start");

        usageService.addUsage(telegramUser.getId(),
                telegramUser.getFirstName(),
                textMessage);

        switch (response.getMessageType()) {
            case PHOTO -> telemetryService.incrementPhoto(userId);
            case TEXT ->  telemetryService.incrementText(userId);
        }

        logger.info("telemetry end");
        logger.info("handleUpdate end");

    }

    private MimirResponse handleCommand(String textMessage,
                                        Boolean isUserRegistered,
                                        User telegramUser) {
        logger.info("handleCommand start");

        String content;

        switch (textMessage) {
            case "/start" -> content = isUserRegistered ?
                    ContentMessages.ALREADY_REGISTERED : onboardNewUser(telegramUser);
            case "/stop" -> content = offboardUser();
            case "/help" -> content = ContentMessages.HELP;
            default -> content = ContentMessages.UNKNOWN_COMMAND;
        }

        logger.info("handleCommand end");
        return new MimirResponse(content, MessageType.TEXT);
    }

    private MimirResponse handleContent(String textMessage) {

        logger.info("handleContent start");

        String content;
        MessageType responseType;

        if (textMessage.startsWith("photo:")) {
            String prompt = textMessage.substring(6)
                    .stripLeading()
                    .stripTrailing();
            content = "https://images.pexels.com/photos/8386356/pexels-photo-8386356.jpeg";
            responseType = MessageType.PHOTO;
        } else {
            content = "response from the text api";
            responseType = MessageType.TEXT;
        }

        return new MimirResponse(content, responseType);
    }

    private void sendMessage(Integer chatId,
                             MimirResponse response){

        logger.info("sendMessage start");
        switch (response.getMessageType()) {
            case PHOTO -> sendPhotoMessage(chatId, response.getContent());
            case TEXT -> sendTextMessage(chatId, response.getContent());
        }
        logger.info("sendMessage end");
    }

    private String onboardNewUser(User telegramUser) {
        logger.info("onboardNewUser start");
        userService.registerUser(
                telegramUser.getId(),
                telegramUser.getUserName(),
                telegramUser.getFirstName()
        );
        logger.info("onboardNewUser end");
        return ContentMessages.ONBOARD_MESSAGE;
    }

    private String offboardUser() {
        // TODO: mark active flag as false
        return ContentMessages.OFFBOARD_MESSAGE;
    }

}
