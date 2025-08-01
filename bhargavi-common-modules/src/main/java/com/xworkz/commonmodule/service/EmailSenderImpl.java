package com.xworkz.commonmodule.service;

import com.xworkz.commonmodule.configuration.EmailConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class EmailSenderImpl implements EmailSender{
    @Autowired
    EmailConfiguration configuration;
    @Override
    public void mailSend(String email, String otp) {
        log.info("Invoking mail sender{}", email);
     SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
      simpleMailMessage.setTo(email);
      simpleMailMessage.setSubject("Otp to login");
      simpleMailMessage.setText("Otp for login"+otp);
      configuration.mailSender().send(simpleMailMessage);
        log.info("Otp sent for :{} : {}", email, otp);
    }
}
