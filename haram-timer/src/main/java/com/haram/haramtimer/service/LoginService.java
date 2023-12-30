package com.haram.haramtimer.service;

import com.haram.haramtimer.entity.User;
import com.haram.haramtimer.repository.UserRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;

    public boolean tryLogin(String userId, String password) {
        User foundUser = userRepository.findByUserId(userId);
        if (foundUser != null) {
            if (foundUser.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
