package com.haram.haramtimer.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendHtmlEmail(String to, String subject, String htmlBody) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8"); // Set the second parameter to
                                                                                      // true
        mimeMessage.setContent(htmlBody, "text/html; charset=utf-8"); // Specify charset

        helper.setTo(to);
        helper.setSubject(subject);

        javaMailSender.send(mimeMessage);
    }
}
