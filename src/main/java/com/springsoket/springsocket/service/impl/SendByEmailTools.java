package com.springsoket.springsocket.service.impl;

import com.springsoket.springsocket.service.serdbyemail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("serdbyemail")
public class SendByEmailTools   implements serdbyemail {

    @Autowired
    JavaMailSender jms;

    @Override
    public String send(String sender, String receiver, String title, String text) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        System.out.println("发送者-----------------");

        mailMessage.setFrom(sender);
        System.out.println("接受者------------------");

        mailMessage.setTo(receiver);

        mailMessage.setSubject(title);

        mailMessage.setText(text);

        jms.send(mailMessage);
        return "1";
    }
}
