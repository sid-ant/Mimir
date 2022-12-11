package com.sidant.mimir;

import com.sidant.mimir.TelegramBot.MimirBot;
import com.sidant.mimir.TelegramBot.Types.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookHandler {

    @Autowired
    MimirBot mimirBot;

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    // TODO: To use webhooks, I need to setup a domain + https cert
    @PostMapping("/handlemimir")
    public void handleMimir(@RequestBody Update update) {
        mimirBot.handleUpdate(update);
    }

}
