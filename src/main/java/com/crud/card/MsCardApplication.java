package com.crud.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.crud.card")
public class MsCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCardApplication.class, args);
    }
}