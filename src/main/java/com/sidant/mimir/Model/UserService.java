package com.sidant.mimir.Model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public Boolean isUserRegistered(Long userId) {
        logger.info("user-id lookup {}",userId);
        Optional<BotUsers> user = userRepository.findByUserId(userId);
        return user.isPresent();
    }

    public void registerUser(
            Long userId,
            String username,
            String firstName
    ) {
        BotUsers newUser = new BotUsers(userId,firstName,username,true);
        userRepository.save(newUser);
    }


}
