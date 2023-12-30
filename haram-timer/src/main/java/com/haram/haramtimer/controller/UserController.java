package com.haram.haramtimer.controller;

// AutoWired
import org.springframework.beans.factory.annotation.Autowired;
// RequiredArgsConstructor
import lombok.RequiredArgsConstructor;
// RestController
import org.springframework.web.bind.annotation.RestController;

// RequestMapping
import org.springframework.web.bind.annotation.RequestMapping;// GetMapping
// GetMapping
import org.springframework.web.bind.annotation.GetMapping;
// PostMapping
import org.springframework.web.bind.annotation.PostMapping;
// PathVariable
import org.springframework.web.bind.annotation.PathVariable;
// UserService
import com.haram.haramtimer.service.UserService;
// RequestBody
import org.springframework.web.bind.annotation.RequestBody;

// List
import java.util.List;

@RequiredArgsConstructor // 초기화 되지않은 final 변수에 대해 생성자를 생성
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    public static class EmailCheckRequest {

        private String userId;
        private String email;

        public String getUserId() {
            return userId;
        }

        public String getEmail() {
            return email;
        }
    }

    public static class PwChangeRequest {
        private String userId;
        private String password;

        public String getUserId() {
            return userId;
        }

        public String getPassword() {
            return password;
        }
    }

    @GetMapping("/exist/name={name}")
    public boolean existsByName(@PathVariable String name) {
        return userService.getExistsByName(name);
    }

    @GetMapping("/find/name={name}")
    public List<String> findByName(@PathVariable String name) {
        return userService.getUserIdsByName(name);
    }

    @GetMapping("/get_name/user_id={userId}")
    public String getNameByUserId(@PathVariable String userId) {
        return userService.getNameByUserId(userId);
    }

    @PostMapping("/check_email")
    public boolean checkEmail(@RequestBody EmailCheckRequest emailCheckRequest) {
        String foundEmail = userService.getEmailByUserId(emailCheckRequest.getUserId());
        return foundEmail != "" && foundEmail.equals(emailCheckRequest.getEmail());
    }

    @PostMapping("/change_password")
    public boolean changePassword(@RequestBody PwChangeRequest pwChangeRequest) {
        return userService.setPwByUserId(pwChangeRequest.getUserId(), pwChangeRequest.getPassword());
    }
}