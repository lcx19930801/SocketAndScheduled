package com.springsoket.springsocket.service;

public interface serdbyemail {

     String send(String sender,String receiver,String title,String text);

     void sendAttachmentsMail(String to, String subject, String content, String filePath);
}
