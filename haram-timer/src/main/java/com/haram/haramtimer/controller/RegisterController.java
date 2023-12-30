package com.haram.haramtimer.controller;

// RequiredArgsConstructor
import lombok.RequiredArgsConstructor;
// RestController
import org.springframework.web.bind.annotation.RestController;
// GetMapping
import org.springframework.web.bind.annotation.GetMapping;
// PostMapping
import org.springframework.web.bind.annotation.PostMapping;
// RequestBody
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// RegisterService
import com.haram.haramtimer.service.RegisterService;
// UserService
import com.haram.haramtimer.service.UserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor // 초기화 되지않은 final 변수에 대해 생성자를 생성
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @Autowired
    UserService userService;

    public static class RegistrationInfo {
        private String userId;
        private String password;
        private String email;
        private String name;
        private String birthDate;
        private String phoneNum;

        public String getUserId() {
            return userId;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public String getPhoneNum() {
            return phoneNum;
        }
    }

    @GetMapping("/check_duplicate/{userId}")
    public boolean checkDuplicate(@PathVariable String userId) {
        return registerService.checkDuplicate(userId);
    }

    @PostMapping("/try_registration")
    public boolean tryRegistration(@RequestBody RegistrationInfo registrationInfo) {
        return registerService.tryRegistration(
                registrationInfo.getUserId(),
                registrationInfo.getPassword(),
                registrationInfo.getEmail(),
                registrationInfo.getName(),
                registrationInfo.getBirthDate(),
                registrationInfo.getPhoneNum());
    }
}