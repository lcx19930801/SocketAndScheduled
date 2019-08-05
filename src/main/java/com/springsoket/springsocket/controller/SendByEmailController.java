package com.springsoket.springsocket.controller;

import com.springsoket.springsocket.service.impl.SendByEmailTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SendByEmailController {

    @Autowired
    @Qualifier("serdbyemail")
    private SendByEmailTools service;

    @GetMapping("/send")
    public  String send(){

        String sender ="1136100452@qq.com";
        String receiver="1820456479@qq.com";
        String title = "springboot发送邮件测试";
        String text = "springboot发送邮件测试";
        String result = service.send(sender,receiver,title,text);
        return result;

    }

     @RequestMapping("/sendAttachmentsMail")
    public String sendAttachmentsMail() {
        String filePath="D:\\Picture\\112340219.jpg";
         service.sendAttachmentsMail("1820456479@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
        return "success";
    }



}
