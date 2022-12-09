package com.sidant.mimir.Model;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService {

    @Autowired
    static UserRepository userRepository;

    public static Boolean isUserRegistered(Integer userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        return user.isPresent();
    }

    public static void registerUser(
            Integer userId,
            String username,
            String firstName
    ) {
        User newUser = new User(userId,firstName,username,true);
        userRepository.save(newUser);
    }


}
