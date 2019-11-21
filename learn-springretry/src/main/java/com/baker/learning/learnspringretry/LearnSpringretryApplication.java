package com.baker.learning.learnspringretry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class LearnSpringretryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringretryApplication.class, args);
    }

}
