package com.baker.learning.learntransaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baker.learning.learntransaction.mapper")
public class LearnTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnTransactionApplication.class, args);
    }

}
