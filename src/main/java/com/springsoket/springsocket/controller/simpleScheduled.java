package com.springsoket.springsocket.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class simpleScheduled {

    @Scheduled(cron="0/2 * * * * ? ")
    public void test1(){
        System.out.println("第一个定时任务"+ LocalDateTime.now() + "\r\n线程 : " + Thread.currentThread().getName());
    }

    @Scheduled(cron="0/1 * * * * ? ")
    public void test2(){
        System.out.println("第二个定时任务"+ LocalDateTime.now() + "\r\n线程 : " + Thread.currentThread().getName());
    }

}
