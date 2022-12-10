package com.sidant.mimir.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsageService {

    Logger logger = LoggerFactory.getLogger(UsageService.class);

    @Autowired
    UsageRepository usageRepository;

    public void addUsage(Long userId, String firstName, String prompt){
        logger.info("addUsage start");
        Usage usage = new Usage(userId,firstName,prompt);
        logger.info("addUsage stop");
        usageRepository.save(usage);
    }

}
