package com.sidant.mimir.TelegramBot;

import com.sidant.mimir.ContentMessages;
import com.sidant.mimir.Exceptions.UnsupportedOperation;
import com.sidant.mimir.Model.UserService;
import com.sidant.mimir.TelegramBot.Types.Message;
import com.sidant.mimir.TelegramBot.Types.Update;
import com.sidant.mimir.TelegramBot.Types.User;
import com.sidant.mimir.Types.MessageType;
import com.sidant.mimir.Types.MimirResponse;
import com.sidant.mimir.Utils.Helper;

public class MimirBot {

    public void handleUpdate(Update update) {

        MimirResponse response;

        Message message = update.getMessage();
        User telegramUser = message.getFrom();

        // TODO: handle active boolean flag too
        Boolean isUserRegistered = UserService.isUserRegistered(telegramUser.getId());
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

        sendMessage(response);
    }

    private MimirResponse handleCommand(String textMessage,
                                        Boolean isUserRegistered,
                                        User telegramUser) {

        String content;

        switch (textMessage) {
            case "/start" -> content = isUserRegistered ?
                    ContentMessages.ALREADY_REGISTERED : onboardNewUser(telegramUser);
            case "/stop" -> content = offboardUser();
            case "/help" -> content = ContentMessages.HELP;
            default -> content = ContentMessages.UNKNOWN_COMMAND;
        }

        return new MimirResponse(content, MessageType.TEXT);
    }

    private MimirResponse handleContent(String textMessage) {

        String content;
        MessageType responseType;

        if (textMessage.startsWith("photo:")) {
            String prompt = textMessage.substring(6)
                    .stripLeading()
                    .stripTrailing();
            content = "call the photo api";
            responseType = MessageType.PHOTO;
        } else {
            content = "response from the text api";
            responseType = MessageType.TEXT;
        }

        return new MimirResponse(content, responseType);
    }

    private void sendMessage(MimirResponse response){

    }

    private String onboardNewUser(User telegramUser) {

        UserService.registerUser(
                telegramUser.getId(),
                telegramUser.getUserName(),
                telegramUser.getFirstName()
        );
        return ContentMessages.ONBOARD_MESSAGE;
    }

    private String offboardUser() {
        // TODO: mark active flag as false
        return ContentMessages.OFFBOARD_MESSAGE;
    }

}
