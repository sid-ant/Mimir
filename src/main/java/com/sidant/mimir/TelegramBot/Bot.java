package com.sidant.mimir.TelegramBot;

import com.sidant.mimir.ContentMessages;
import com.sidant.mimir.Exceptions.UnsupportedOperation;
import com.sidant.mimir.TelegramBot.Types.Message;
import com.sidant.mimir.TelegramBot.Types.Update;
import com.sidant.mimir.Types.MessageType;
import com.sidant.mimir.Types.MimirResponse;
import com.sidant.mimir.Utils.Helper;

public class Bot {

    public void handleUpdate(Update update) {

        MimirResponse response;

        Message message = update.getMessage();
        Integer chatId = message.getChat().getId();

        Boolean isUserRegistered = false;
        String textMessage = message.getText();

        try {
            Helper.validateText(textMessage);

            String commandIdentifier = "/";
            if (textMessage.startsWith(commandIdentifier))
                response = handleCommand(textMessage, isUserRegistered);
            else
                response = isUserRegistered ?
                        handleContent(textMessage) :
                        new MimirResponse(onboardNewUser(), MessageType.TEXT);
        }
        catch (UnsupportedOperation ex) {
            response = new MimirResponse(ex.getMessage(), MessageType.TEXT);
        }

        sendMessage(response);
    }

    private MimirResponse handleCommand(String textMessage, Boolean isUserRegistered) {

        String content;

        switch (textMessage) {
            case "/start" -> content = isUserRegistered ?
                    ContentMessages.ALREADY_REGISTERED : onboardNewUser();
            case "/stop" -> content = offboardUser();
            case "/help" -> content = ContentMessages.HELP;
            default -> content = ContentMessages.UNKOWN_COMMAND;
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

    private String onboardNewUser() {
        return "";
    }

    private String offboardUser() {
        return "";

    }

}
