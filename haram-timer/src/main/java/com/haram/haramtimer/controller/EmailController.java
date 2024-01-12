package com.haram.haramtimer.controller;

import org.springframework.beans.factory.annotation.Autowired;
// RestController
import org.springframework.web.bind.annotation.RestController;
// PostMapping
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.mail.MessagingException;

// EmailService
import com.haram.haramtimer.service.EmailService;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    public static class EmailRequest {
        private String userId;
        private String email;

        public String getUserId() {
            return userId;
        }

        public String getEmail() {
            return email;
        }
    }

    @PostMapping("/send_email/auth")
    public String sendAuthEmail(@RequestBody EmailRequest emailRequest) {
        try {
            // 이메일 정보 설정
            String to = emailRequest.getEmail();
            String subject = "[하람] 하람 비밀번호가 변경되었습니다.";
            String authCode = generateRandomCode();

            // 이메일 내용 생성
            String htmlBody = String.format("<html lang=\"ko\">" +
                    "<head>" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" +
                    "<style>" +
                    "body { font-family: 'Arial', sans-serif; background-color: #f2f2f2; }" +
                    ".container { width: 80%%; margin: 0 auto; padding: 20px; background-color: #fff; }" +
                    "h2 { color: #333; }" +
                    "p { color: #555; }" +
                    "</style>" +
                    "</head>" +
                    "<body>" +
                    "<div class='container'>" +
                    "<h2>하람 비밀번호 변경 인증번호입니다</h2>" +
                    "<p><strong>인증번호:</strong> %s</p>" +
                    "</div>" +
                    "</body>" +
                    "</html>", authCode);

            // 이메일 발송
            emailService.sendHtmlEmail(to, subject, htmlBody);

            // 성공 응답
            return authCode;
        } catch (MessagingException e) {
            e.printStackTrace();
            return "";
        }
    }

    // 무작위 코드 생성 메서드
    private String generateRandomCode() {
        int code = (int) ((Math.random() * 900000) + 100000);
        return String.valueOf(code);
    }
}
