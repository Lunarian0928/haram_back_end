package com.haram.haramtimer.service;

import com.haram.haramtimer.entity.User;
import com.haram.haramtimer.repository.UserRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RegisterService {
    @Autowired
    UserRepository userRepository;

    public boolean checkDuplicate(String userId) { // 아이디 중복체크
        return userRepository.existsByUserId(userId);
    }

    public boolean tryRegistration(String userId, String password, String email, String name, String birthDate,
            String phoneNum) {
        try {
            userRepository.save(new User(userId, password, email, name, birthDate, phoneNum));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
