package com.baker.learning.learnshirojwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baker.learning.learnshirojwt.mapper")
public class LearnShiroJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnShiroJwtApplication.class, args);
    }

}
