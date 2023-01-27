package com.softwareacademy.projet9_front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Projet9FrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(Projet9FrontApplication.class, args);
    }

}
