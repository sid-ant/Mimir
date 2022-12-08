package com.sidant.mimir.TelegramBot;

import com.sidant.mimir.TelegramBot.Types.Message;
import com.sidant.mimir.TelegramBot.Types.Update;
import com.sidant.mimir.Utils.Helper;

public class Bot {

    public void handleUpdate(Update update) {

        Message message = update.getMessage();
        Integer chatId = message.getChat().getId();
        Helper.createUserIfNotExists(chatId); // Should return a user
        // Increment usage
        String response = "open ai returned this";
        // Send message
    }

}
