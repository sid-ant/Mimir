package com.sidant.mimir;

import com.sidant.mimir.TelegramBot.MimirBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RunAfterStartup {

    @Autowired
    MimirBot mimirBot;

    Logger logger = LoggerFactory.getLogger(RunAfterStartup.class);

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {

        logger.info("runAfterStartup start");
        // TODO: run this is in a separate thread?
        mimirBot.startPolling(100);
        logger.info("runAfterStartup exit");

    }

}
