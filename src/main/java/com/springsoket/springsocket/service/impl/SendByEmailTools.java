package com.springsoket.springsocket.service.impl;

import com.springsoket.springsocket.service.serdbyemail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service("serdbyemail")
public class SendByEmailTools   implements serdbyemail {

    @Autowired
    JavaMailSender jms;
      private String from;

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




    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = jms.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("1136100452@qq.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            //helper.addAttachment("test"+fileName, file);

            jms.send(message);
            System.out.println("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            System.out.println("发送带附件的邮件时发生异常！"+e);


        }
    }

}
