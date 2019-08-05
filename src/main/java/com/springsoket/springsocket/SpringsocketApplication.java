package com.springsoket.springsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsocketApplication.class, args);
    }

}
