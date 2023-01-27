package com.softwareacademy.mediscreen_p9_jb_sprint_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MediscreenP9JbSprint3Application {

    public static void main(String[] args) {
        SpringApplication.run(MediscreenP9JbSprint3Application.class, args);
    }

}
