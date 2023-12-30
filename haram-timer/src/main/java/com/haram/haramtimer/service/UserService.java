package com.haram.haramtimer.service;

import com.haram.haramtimer.entity.User;
import com.haram.haramtimer.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean getExistsByName(String name) {
        return userRepository.existsByName(name);
    }

    public List<String> getUserIdsByName(String name) {
        List<User> users = userRepository.findByName(name);
        return users.stream().map(User::getUserId).collect(Collectors.toList());
    }

    public String getEmailByUserId(String userId) {
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            return user.getEmail();
        }
        return "";
    }

    public String getNameByUserId(String userId) {
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            return user.getName();
        }
        return "";
    }

    public boolean setPwByUserId(String userId, String password) {
        User user = userRepository.findByUserId(userId);
        System.out.println(user);
        if (user != null) {
            user.setPassword(password);
            userRepository.save(user);
            return true;
        }
        return false;
    }
}