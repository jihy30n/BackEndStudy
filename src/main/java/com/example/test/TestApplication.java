package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TestApplication {

    public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);
        System.out.println("무사히 실행됨!");
    }

}
