package com.haram.haramtimer.controller;

// RequiredArgsConstructor
import lombok.RequiredArgsConstructor;
// RestController
import org.springframework.web.bind.annotation.RestController;
// PostMapping
import org.springframework.web.bind.annotation.PostMapping;
// RequestBody
import org.springframework.web.bind.annotation.RequestBody;

import com.haram.haramtimer.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor // 초기화 되지않은 final 변수에 대해 생성자를 생성
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    public static class LoginInfo {
        private String userId;
        private String password;

        public String getUserId() {
            return userId;
        }

        public String getPassword() {
            return password;
        }
    }

    @PostMapping("/login")
    public boolean tryLogin(@RequestBody LoginInfo loginInfo) {
        return loginService.tryLogin(loginInfo.getUserId(), loginInfo.getPassword());
    }
}