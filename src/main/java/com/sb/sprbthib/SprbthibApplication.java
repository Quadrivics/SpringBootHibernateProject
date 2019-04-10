package com.sb.sprbthib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sb.sprbthib")
public class SprbthibApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprbthibApplication.class, args);
    }
}
