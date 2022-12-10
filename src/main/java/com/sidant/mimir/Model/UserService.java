package com.sidant.mimir.Model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public Boolean isUserRegistered(Long userId) {
        logger.info("user-id lookup {}",userId);
        Optional<Users> user = usersRepository.findByUserId(userId);
        return user.isPresent();
    }

    public void registerUser(
            Long userId,
            String username,
            String firstName
    ) {
        Users newUser = new Users(userId,firstName,username,true);
        usersRepository.save(newUser);
    }


}
